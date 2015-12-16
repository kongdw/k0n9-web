package k0n9.module.auth.entity;

import k0n9.common.entity.TreeEntity;

/**
 * 资源实体
 * @author David Kong
 * @version 1.0
 */
public class Resource extends TreeEntity<Long> {

    private static final long serialVersionUID = 7264052075463381938L;

    /** 资源ID */
    private Long id;
    /** 资源父ID */
    private Long parentId;
    /** 资源唯一标识 */
    private String identity;
    /** 请求资源URL地址 */
    private String url;
    /** 是否显示 */
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
