package k0n9.module.auth.entity;

import com.google.common.collect.Lists;
import k0n9.common.entity.BaseEntity;

import java.util.List;

/**
 *
 * 角色实体
 * @author David Kong
 * @version 1.0
 */
public class Role extends BaseEntity<Long>{

    private static final long serialVersionUID = 459946315221806103L;

    /** 角色ID */
    private Long id;
    /** 角色名称 */
    private String name;
    /** 系统中使用的验证字符串 */
    private String role;
    /** 备注 */
    private String description;
    /** 是否显示 */
    private Boolean isShow = Boolean.TRUE;
    /** 角色拥有资源列表 */
    private List<RoleResourcePermission> resourcePermissionList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<RoleResourcePermission> getResourcePermissionList() {
        if(resourcePermissionList == null){
            resourcePermissionList = Lists.newArrayList();
        }
        return resourcePermissionList;
    }

    public void setResourcePermissionList(List<RoleResourcePermission> resourcePermissionList) {
        this.resourcePermissionList = resourcePermissionList;
    }
}
