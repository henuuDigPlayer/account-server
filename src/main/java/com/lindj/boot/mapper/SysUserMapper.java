package com.lindj.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lindj.boot.model.SysUser;

import java.util.List;

/**
 * @author lindj
 * @date 2019/5/29 0029
 * @description
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户id查询权限
     *
     * @param id Integer
     * @return STring列表
     */
    List<String> getUserPermissionList(Integer id);

    SysUser getUserByUsername(String username);
}
