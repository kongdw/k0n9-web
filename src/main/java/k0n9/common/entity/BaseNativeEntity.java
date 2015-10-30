package k0n9.common.entity;

/**
 * 实现了一个的Native方式的主键策略
 * @author David Kong
 * @version 1.0
 */
public class BaseNativeEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = -4613300832241822713L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
