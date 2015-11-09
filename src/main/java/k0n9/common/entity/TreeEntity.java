package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 树形实体继承该实体
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class TreeEntity<T,ID extends Serializable> extends AbstractEntity<ID> {

    private static final long serialVersionUID = -8283898532047691696L;

    /**
     * 父对象
     */
    protected T parent;
    /**
     * 父ID的字符串
     */
    private String parentIds;
    /**
     * 名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 显示图标
     */
    private String icon;

    @JsonBackReference
    public abstract T getParent();

    public abstract void setParent(T parent);

    @JsonIgnore
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @JsonProperty
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
