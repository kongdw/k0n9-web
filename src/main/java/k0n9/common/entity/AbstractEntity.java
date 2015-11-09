package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * 增加乐观锁支持的实体
 * @author David Kong
 * @version 1.0
 */
public abstract class AbstractEntity<ID extends Serializable> implements BaseEntity<ID> {

    private static final long serialVersionUID = 8735316878185564089L;

    /** 当前用户对象sqlMapKey */
    public static final String SQLMAPKEY_CURRENTUSER = "_USER";

    /**
     * 在批量提交处理数据时，标识对象操作类型。
     */
    public static final String EXTRA_ATTRIBUTE_OPERATION = "operation";
    public static final String EXTRA_ATTRIBUTE_OPERATION_ADD = "add";
    public static final String EXTRA_ATTRIBUTE_OPERATION_UPDATE = "update";
    public static final String EXTRA_ATTRIBUTE_OPERATION_REMOVE = "remove";

    /** 自定义sqlMap(sql标识,值对象) */
    protected Map<String, Object> sqlMap;

    /** Entity本身无用，主要用于UI层辅助参数传递 */
    private Map<String, Object> extraAttributes;

    /**
     * 判断当前业务对象是否新对象
     * @return
     */
    @JsonIgnore
    public boolean isNew() {
        Serializable id = getId();
        return id == null || StringUtils.isBlank(String.valueOf(id));
    }

    @JsonIgnore
    public boolean isNotNew() {
        return !isNew();
    }

    //TODO protected 属性是否会被忽略?
    protected String getOperationStatus(){
        if (extraAttributes == null) {
            return null;
        }
        Object opParams = extraAttributes.get(EXTRA_ATTRIBUTE_OPERATION);
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

    @JsonIgnore
    public boolean isMarkedRemove() {
        return EXTRA_ATTRIBUTE_OPERATION_REMOVE.equalsIgnoreCase(getOperationStatus());
    }

    @JsonIgnore
    public boolean isMarkedUpdate() {
        return EXTRA_ATTRIBUTE_OPERATION_UPDATE.equalsIgnoreCase(getOperationStatus());
    }

    @JsonIgnore
    public boolean isMarkedAdd() {
        return EXTRA_ATTRIBUTE_OPERATION_ADD.equalsIgnoreCase(getOperationStatus());
    }


    @JsonIgnore
    public Map<String, Object> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, Object> sqlMap) {
        this.sqlMap = sqlMap;
    }

    public void addSqlMapAttribute(String key,Object value){
        if(sqlMap == null){
            sqlMap = Maps.newHashMap();
        }
        sqlMap.put(key,value);
    }

    @JsonProperty
    public Map<String, Object> getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(Map<String, Object> extraAttributes) {
        this.extraAttributes = extraAttributes;
    }

    /**
     * 添加扩展属性用于前台UI显示
     * @param key
     * @param value
     */
    public void addExtraAttribute(String key, Object value) {
        if (extraAttributes == null) {
            extraAttributes = Maps.newHashMap();
        }
        extraAttributes.put(key, value);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
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
        BaseEntity that = (BaseEntity) obj;
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
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

}