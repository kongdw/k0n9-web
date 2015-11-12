package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import k0n9.common.entity.plugin.Tree;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 树形实体继承该实体
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class TreeEntity<ID extends Serializable> extends BaseEntity<ID> implements Tree<ID>, Serializable {

    private static final long serialVersionUID = 7013548013739460184L;
    /**
     * 标题
     */
    private String name;

    private String parentIds;

    private Integer weight;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否有叶子节点
     */
    private boolean hasChildren;

    /**
     * 是否显示
     */
    private Boolean isShow = Boolean.FALSE;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract ID getParentId();

    public abstract void setParentId(ID parentId);

    @JsonIgnore
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public String makeSelfAsNewParentIds() {
        return getParentIds() + getId() + getSeparator();
    }

    @Override
    @JsonIgnore
    public String getSeparator() {
        return "/";
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getIcon() {
        if (!StringUtils.isEmpty(icon)) {
            return icon;
        }
        if (isRoot()) {
            return getRootDefaultIcon();
        }
        if (isLeaf()) {
            return getLeafDefaultIcon();
        }
        return getBranchDefaultIcon();
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    @Override
    public boolean isRoot() {
        Serializable id = getParentId();
        if (id == null) {
            return true;
        }
        if (id instanceof String) {
            return StringUtils.isBlank(String.valueOf(getParentId()));
        }
        if (id instanceof Long) {
            return (Long) id == 0l;
        }
        if (id instanceof Integer) {
            return (Integer) id == 0;
        }
        return false;
    }


    @Override
    public boolean isLeaf() {
        if (isRoot()) {
            return false;
        }
        if (isHasChildren()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isHasChildren() {
        return hasChildren;
    }


    public int getLevel() {
        String s = parentIds; // 0/
        if (StringUtils.isNotBlank(s)) {
            String[] ids = s.split(getSeparator());
            return ids.length;
        }
        return 1;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @JsonIgnore
    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 根节点默认图标 如果没有默认 空即可
     *
     * @return
     */
    @Override
    @JsonIgnore
    public String getRootDefaultIcon() {
        return "ztree_root_open";
    }

    /**
     * 树枝节点默认图标 如果没有默认 空即可
     *
     * @return
     */
    @Override
    @JsonIgnore
    public String getBranchDefaultIcon() {
        return "ztree_branch";
    }

    /**
     * 树叶节点默认图标 如果没有默认 空即可
     *
     * @return
     */
    @Override
    @JsonIgnore
    public String getLeafDefaultIcon() {
        return "ztree_leaf";
    }
}
