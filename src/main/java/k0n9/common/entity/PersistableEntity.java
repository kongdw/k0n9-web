package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Map;

/**
 * 持久化实体基础类
 * @author David Kong
 * @version 1.0
 */
public abstract class PersistableEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = -4651666362893057648L;

    public static final String EXTRA_ATTRIBUTE_GRID_TREE_LEVEL = "level";

    /** 在批量提交处理数据时，标识对象操作类型*/
    public static final String EXTRA_ATTRIBUTE_OPERATION = "operation";

    /** 在显示或提交数据时，标识对象为脏数据需要处理 */
    public static final String EXTRA_ATTRIBUTE_DIRTY_ROW = "dirtyRow";

    /** Entity本身无用，主要用于UI层辅助参数传递 */
    private Map<String, Object> extraAttributes;

    /** Entity本身无用，主要用于sql条件过滤*/
    private Map<String,String> sqlMap;

    public abstract ID getId();

    /** 前段UI显示 */
    public abstract String getDisplay();

    /** 用于快速判断对象是否新建状态 */
    @JsonIgnore
    public boolean isNew() {
        Serializable id = getId();
        return id == null || StringUtils.isBlank(String.valueOf(id));
    }

    /*
     * 用于快速判断对象是否编辑状态
     */
    @JsonIgnore
    public boolean isNotNew() {
        return !isNew();
    }

    /**
     * 从扩展属性中取值判断当前对象是否标记需要删除
     * 一般用于前端UI对关联集合对象元素移除操作
     * @return
     */
    @JsonIgnore
    public boolean isMarkedRemove() {
        if (extraAttributes == null) {
            return false;
        }
        Object opParams = extraAttributes.get(EXTRA_ATTRIBUTE_OPERATION);
        if (opParams == null) {
            return false;
        }
        String op = null;
        if (opParams instanceof String[]) {
            op = ((String[]) opParams)[0];
        } else if (opParams instanceof String) {
            op = (String) opParams;
        }
        if ("remove".equalsIgnoreCase(op)) {
            return true;
        }
        return false;
    }

    @JsonProperty
    public Map<String, Object> getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(Map<String, Object> extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    @JsonIgnore
    public Map<String, String> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    /**
     * 扩展属性中添加值
     * @param key
     * @param value
     */
    public void addExtraAttribute(String key, Object value) {
        if (extraAttributes == null) {
            extraAttributes = Maps.newHashMap();
        }
        extraAttributes.put(key, value);
    }

    @JsonIgnore
    public String getExtraAttributesValue(String key) {
        if (extraAttributes == null) {
            return null;
        }
        Object opParams = extraAttributes.get(key);
        if (opParams == null) {
            return null;
        }
        String op = null;
        if (opParams instanceof String[]) {
            op = ((String[]) opParams)[0];
        } else if (opParams instanceof String) {
            op = (String) opParams;
        }
        return op;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Persistable that = (Persistable) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += null == getId() ? 0 : getId().hashCode() * 31;
        return hashCode;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
