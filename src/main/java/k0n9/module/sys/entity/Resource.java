package k0n9.module.sys.entity;

import k0n9.common.entity.TreeEntity;

/**
 *
 * 资源实体
 * @author David Kong
 * @version 1.0
 */
public class Resource extends TreeEntity<Long> {

    private static final long serialVersionUID = 7264052075463381938L;

    private Long id;

    private Long parentId;

    private String identity;

    private String url;

    private Boolean isShow = Boolean.TRUE;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
