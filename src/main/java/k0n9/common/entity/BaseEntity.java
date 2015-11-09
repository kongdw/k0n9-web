package k0n9.common.entity;

import java.io.Serializable;

/**
 * 增加乐观锁支持的实体
 * @author David Kong
 * @version 1.0
 */
public interface BaseEntity<ID extends Serializable> extends Serializable {

    /**
     * 获取业务对象唯一键
     * @return
     */
    ID getId();

    /**
     * 判断业务对象是否为新对象
     * @return
     */
    boolean isNew();
}
