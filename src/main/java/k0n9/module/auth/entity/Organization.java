package k0n9.module.auth.entity;

import k0n9.common.entity.TreeEntity;

/**
 *
 * 组织机构实体
 * @author David Kong
 * @version 1.0
 */
public class Organization extends TreeEntity<Long> {

    private static final long serialVersionUID = -601918858879571472L;

    private Long id;

    private Long parentId;

    private OrganizationType organizationType;

    private Boolean isShow = Boolean.TRUE;

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }

    @Override
    public Boolean getIsShow() {
        return isShow;
    }

    @Override
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }
}
