package k0n9.module.auth.entity;

import com.google.common.collect.Lists;
import k0n9.common.entity.BaseEntity;

import java.util.List;

/**
 *
 * 角色关联资源与权限实体
 * @author David Kong
 * @version 1.0
 */
public class RoleResourcePermission extends BaseEntity<Long> {

    private static final long serialVersionUID = 575418329805568261L;

    private Long id;

    private Role role;

    private List<Resource> resourceList;

    private List<Permission> permissionList;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Resource> getResourceList() {
        if(resourceList == null){
            resourceList = Lists.newArrayList();
        }
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<Permission> getPermissionList() {
        if(permissionList == null){
            permissionList = Lists.newArrayList();
        }
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
