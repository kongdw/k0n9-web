package k0n9.module.sys.entity;

import k0n9.common.entity.TreeEntity;

/**
 * 区域实体
 *
 * @author David Kong
 * @version 1.0
 */
public class Area extends TreeEntity<Long> {

    private static final long serialVersionUID = -5103053863938072888L;

    private Long id;

    private Long parentId;

    private String code;

    private String type;

    private String remarks;

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
