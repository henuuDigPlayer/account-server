package com.lindj.boot.service;

import com.lindj.boot.mapper.SysUserMapper;
import com.lindj.boot.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hxy
 * @description: 登录service实现类
 * @date: 2017/10/24 11:53
 */
@Service
public class SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

/*
	*/
/**
	 * 登录表单提交
	 *//*

	@Override
	public JSONObject authLogin(JSONObject jsonObject) {
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		JSONObject info = new JSONObject();
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			info.put("result", "success");
		} catch (AuthenticationException e) {
			info.put("result", "fail");
		}
		return CommonUtil.successJson(info);
	}
*/

	/**
	 * 根据用户id查询权限
	 *
	 * @param id Integer
	 * @return STring列表
	 */
	public List<String> getUserPermissionList(Integer id){
		return this.sysUserMapper.getUserPermissionList(id);
	}


	public SysUser getUserByUsername(String username){
		return this.sysUserMapper.getUserByUsername(username);
	}

	/**
	 * 查询当前登录用户的权限等信息
	 *//*
	@Override
	public JSONObject getInfo() {
		//从session获取用户信息
		Session session = SecurityUtils.getSubject().getSession();
		JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
		String username = userInfo.getString("username");
		JSONObject info = new JSONObject();
		JSONObject userPermission = permissionService.getUserPermission(username);
		session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
		info.put("userPermission", userPermission);
		return CommonUtil.successJson(info);
	}

	*//**
	 * 退出登录
	 *//*
	@Override
	public JSONObject logout() {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
		} catch (Exception e) {
		}
		return CommonUtil.successJson();
	}*/
}
