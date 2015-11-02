package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * 增加乐观锁支持的实体
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 8735316878185564089L;

    /** 当前用户对象sqlMapKey */
    public static final String SQLMAPKEY_CURRENTUSER = "_USER";

    /**  实体编号(唯一标识) */
    private ID id;

    /** 乐观锁版本，初始值为0 */
    private int version = 0;

    /** 自定义sqlMap(sql标识,值对象) */
    protected Map<String, Object> sqlMap;

    /** Entity本身无用，主要用于UI层辅助参数传递 */
    private Map<String, Object> extraAttributes;

    @JsonIgnore
    public boolean isNew() {
        if(id == null){
            return true;
        }
        if(id instanceof Integer){
            Integer i;
            return (i = (Integer)id) == null || i == 0;
        }
        if(id instanceof Long){
            Long i;
            return (i = (Long)id) == null || i == 0L;
        }
        return StringUtils.isBlank((String)id);
    }

    @JsonProperty
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @JsonProperty
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @JsonIgnore
    public Map<String, Object> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, Object> sqlMap) {
        this.sqlMap = sqlMap;
    }

    public Map<String, Object> getExtraAttributes() {
        return extraAttributes;
    }

    public void setExtraAttributes(Map<String, Object> extraAttributes) {
        this.extraAttributes = extraAttributes;
    }
}
