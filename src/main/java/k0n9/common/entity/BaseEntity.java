package k0n9.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 增加乐观锁支持的实体
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseEntity<ID extends Serializable> extends PersistableEntity<ID> {

    private static final long serialVersionUID = 8735316878185564089L;
    /**
     * 乐观锁版本，初始值为0
     */
    private int version = 0;

    protected ID id;

    public abstract void setId(final ID id);

    @JsonProperty
    public int getVersion(){
        return version;
    }

    public void setVersion(int version){
        this.version = version;
    }

    /**
     * 快速复制实体时快速初始化
     */
    public void resetCommonProperties() {
        setId(null);
        version = 0;
        addExtraAttribute(PersistableEntity.EXTRA_ATTRIBUTE_DIRTY_ROW, true);
    }

    private static final String[] PROPERTY_LIST = new String[] { "id", "version" };

    public String[] retriveCommonProperties() {
        return PROPERTY_LIST;
    }

    @Override
    @JsonProperty
    public String getDisplay() {
        return "[" + getId() + "]" + this.getClass().getSimpleName();
    }
}
