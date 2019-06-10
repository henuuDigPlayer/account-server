package com.lindj.boot.model;

import java.util.Date;

/**
 * @author: lindj
 * @date: 2019-05-29 15:05:32
 * @description:  
 */
public class SysUser {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
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
     * 用户名
     *
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     *
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 昵称
     *
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     *
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @param updateTime 修改时间
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