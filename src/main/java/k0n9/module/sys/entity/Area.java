package k0n9.module.sys.entity;

import k0n9.common.entity.TreeEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 区域实体
 * @author David Kong
 * @version 1.0
 */
public class Area extends TreeEntity<Area,Long> {

    private static final long serialVersionUID = 9189172673036252551L;

    private String code; //区域编码

    private String type; //区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）

    private String remarks;

    @Override
    public Area getParent() {
        return parent;
    }

    @Override
    public void setParent(Area parent) {
        this.parent = parent;
    }
    @Length(min=1, max=1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Length(min=0, max=100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
