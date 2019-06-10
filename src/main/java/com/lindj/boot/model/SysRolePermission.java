package com.lindj.boot.model;

import java.util.Date;

/**
 * @author: lindj
 * @date: 2019-05-29 13:36:11
 * @description:  
 */
public class SysRolePermission {
    /**
     * 
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 是否有效 1有效     2无效
     */
    private String deleteStatus;

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
     * 角色id
     *
     * @return role_id 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 权限id
     *
     * @return permission_id 权限id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 权限id
     *
     * @param permissionId 权限id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 
     *
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     *
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     *
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     *
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否有效 1有效     2无效
     *
     * @return delete_status 是否有效 1有效     2无效
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 是否有效 1有效     2无效
     *
     * @param deleteStatus 是否有效 1有效     2无效
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}