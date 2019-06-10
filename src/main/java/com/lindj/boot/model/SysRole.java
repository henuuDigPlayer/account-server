package com.lindj.boot.model;

import java.util.Date;

/**
 * @author: lindj
 * @date: 2019-05-29 13:36:11
 * @description:  
 */
public class SysRole {
    /**
     * 
     */
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 是否有效  1有效  2无效
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
     * 角色名
     *
     * @return role_name 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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
     * 是否有效  1有效  2无效
     *
     * @return delete_status 是否有效  1有效  2无效
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 是否有效  1有效  2无效
     *
     * @param deleteStatus 是否有效  1有效  2无效
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}