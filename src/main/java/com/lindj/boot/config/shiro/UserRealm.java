package com.lindj.boot.config.shiro;

import com.lindj.boot.config.shiro.token.JwtToken;
import com.lindj.boot.model.SysRole;
import com.lindj.boot.model.SysUser;
import com.lindj.boot.service.SysRoleService;
import com.lindj.boot.service.SysUserService;
import com.lindj.boot.util.JwtUtil;
import com.lindj.boot.util.SecurityConsts;
import jodd.util.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lindj
 * @description 自定义Realm
 * @date 2017/10/24 10:06
 */
@Service
public class UserRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private RedissonClient redissonClient;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     * 当使用注解@RequiresPermissions进行权限校验时会触发该方法的校验
     *
     * @param principals PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JwtUtil.getClaim(principals.toString(), SecurityConsts.ACCOUNT);
        SysUser user = sysUserService.getUserByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> roleList =
                this.roleService.selectListByUid(user.getId()).stream().map(SysRole::getRoleName).collect(Collectors.toList());
        simpleAuthorizationInfo.addRoles(roleList);
        List<String> permissionList = this.sysUserService.getUserPermissionList(user.getId());
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        logger.info("授权完成");
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * 验证当前登录的Subject,执行Subject.login()时 执行此方法
     *
     * @param authcToken AuthenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String token = (String) authcToken.getCredentials();
        // 解密获得username
        String username = JwtUtil.getClaim(token, SecurityConsts.ACCOUNT);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        SysUser sysUser = sysUserService.getUserByUsername(username);
        if (sysUser == null) {
            throw new AuthenticationException("user didn't existed!");
        }
        // 校验jwt是否正确
        if (!JwtUtil.verify(token, sysUser.getPassword())) {
            throw new AuthenticationException("username or password error");
        }
        // 获取token时间戳与RefreshToken的时间戳对比
        String refreshTokenCacheKey = SecurityConsts.PREFIX_SHIRO_REFRESH_TOKEN + username;
        RBucket<String> bucket = this.redissonClient.getBucket(refreshTokenCacheKey);
        String currentTimeMillisRedis = bucket.get();
        if (StringUtil.isEmpty(currentTimeMillisRedis) || !JwtUtil.getClaim(token, SecurityConsts.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
            throw new AuthenticationException("token expired or incorrect.");
        }
        logger.info("认证完成");
        return new SimpleAuthenticationInfo(token, token, "user_realm");
    }


}
