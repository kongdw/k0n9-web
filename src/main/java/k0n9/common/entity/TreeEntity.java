package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import k0n9.common.utils.Reflections;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class TreeEntity<T> extends BaseNativeEntity {

    private static final long serialVersionUID = -8283898532047691696L;

    protected T parent;
    private String parentIds;
    private String name;
    private Integer sort;

    @JsonBackReference
    @NotNull
    public abstract T getParent();

    public abstract void setParent(T parent);

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        String id = null;
        if (parent != null){
            id = (String) Reflections.getFieldValue(parent, "id");
        }
        return StringUtils.isNotBlank(id) ? id : "0";
    }
}
