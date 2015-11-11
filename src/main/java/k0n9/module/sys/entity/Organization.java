package k0n9.module.sys.entity;

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

    @Override
    public Boolean getIsShow() {
        return isShow;
    }

    @Override
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }
}
