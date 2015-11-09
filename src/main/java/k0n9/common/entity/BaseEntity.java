package k0n9.common.entity;

import java.io.Serializable;

/**
 * 增加乐观锁支持的实体
 * @author David Kong
 * @version 1.0
 */
public interface BaseEntity<ID extends Serializable> extends Serializable {

    ID getId();

    boolean isNew();
}
