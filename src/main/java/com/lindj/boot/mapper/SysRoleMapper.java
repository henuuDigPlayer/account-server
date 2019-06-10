package com.lindj.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lindj.boot.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lindj
 * @date 2019/5/29 0029
 * @description
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {


    List<SysRole> selectListByUid(@Param("uid") Integer uid);
}
