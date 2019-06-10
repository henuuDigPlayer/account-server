package com.lindj.boot.model;

/**
 * @author: lindj
 * @date: 2019-05-29 15:05:32
 * @description:  
 */
public class SysUserRole {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer sysUserId;

    /**
     * 
     */
    private Integer sysRoleId;

    /**
     * 
     *
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     *
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     *
     * @return sys_user_id 
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 
     *
     * @param sysUserId 
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 
     *
     * @return sys_role_id 
     */
    public Integer getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 
     *
     * @param sysRoleId 
     */
    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}