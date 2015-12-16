package k0n9.module.auth.entity;

import k0n9.common.entity.BaseEntity;

/**
 *
 * 权限标识字典
 * @author David Kong
 * @version 1.0
 */
public class Permission extends BaseEntity<Long> {

    private static final long serialVersionUID = -7565344326831433660L;

    private Long id;

    private String name;
    /** 权限标识 */
    private String identity;
    /** 备注 */
    private String description;
    /** 是否显示 */
    private Boolean isShow = Boolean.TRUE;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
}
