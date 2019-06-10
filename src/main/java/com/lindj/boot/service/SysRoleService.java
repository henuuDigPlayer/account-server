package com.lindj.boot.service;

import com.lindj.boot.mapper.SysRoleMapper;
import com.lindj.boot.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lindj
 * @date 2019/5/29 0029
 * @description
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

   public List<SysRole> selectListByUid(Integer uid){
        return this.sysRoleMapper.selectListByUid(uid);
    }
}
