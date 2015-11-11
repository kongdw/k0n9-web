package k0n9.module.sys.entity;

import k0n9.common.entity.BaseEntity;

/**
 *
 * 角色实体
 * @author David Kong
 * @version 1.0
 */
public class Role extends BaseEntity<Long>{

    private static final long serialVersionUID = 459946315221806103L;

    private Long id;

    private String name;

    /**
     * 系统中使用的验证字符串
     */
    private String role;

    private String description;

    private Boolean isShow = Boolean.TRUE;

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
}
