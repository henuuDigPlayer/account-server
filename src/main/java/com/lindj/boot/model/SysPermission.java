package com.lindj.boot.model;

/**
 * @author: lindj
 * @date: 2019-05-29 13:36:11
 * @description:  
 */
public class SysPermission {
    /**
     * 自定id,主要供前端展示权限列表分类排序使用.
     */
    private Integer id;

    /**
     * 归属菜单,前端判断并展示菜单使用,
     */
    private String menuCode;

    /**
     * 菜单的中文释义
     */
    private String menuName;

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    private String permissionCode;

    /**
     * 本权限的中文释义
     */
    private String permissionName;

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    private Boolean requiredPermission;

    /**
     * 自定id,主要供前端展示权限列表分类排序使用.
     *
     * @return id 自定id,主要供前端展示权限列表分类排序使用.
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自定id,主要供前端展示权限列表分类排序使用.
     *
     * @param id 自定id,主要供前端展示权限列表分类排序使用.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 归属菜单,前端判断并展示菜单使用,
     *
     * @return menu_code 归属菜单,前端判断并展示菜单使用,
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 归属菜单,前端判断并展示菜单使用,
     *
     * @param menuCode 归属菜单,前端判断并展示菜单使用,
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    /**
     * 菜单的中文释义
     *
     * @return menu_name 菜单的中文释义
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单的中文释义
     *
     * @param menuName 菜单的中文释义
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     *
     * @return permission_code 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     *
     * @param permissionCode 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * 本权限的中文释义
     *
     * @return permission_name 本权限的中文释义
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 本权限的中文释义
     *
     * @param permissionName 本权限的中文释义
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     *
     * @return required_permission 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    public Boolean getRequiredPermission() {
        return requiredPermission;
    }

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     *
     * @param requiredPermission 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    public void setRequiredPermission(Boolean requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}