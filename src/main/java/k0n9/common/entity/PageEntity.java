package k0n9.common.entity;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
public class PageEntity<T extends BaseEntity> implements Serializable {

    private static final long serialVersionUID = -461549547891006765L;

    private Integer draw;
    private List<T> data;
    private Long recordsTotal;
    private Long recordsFiltered;
    private String customActionMessage;
    private String customActionStatus;

    public PageEntity(PageInfo<T> pageInfo) {
        this.draw = pageInfo.getPageNum();
        this.data = pageInfo.getList();
        this.recordsTotal = pageInfo.getTotal();
        this.recordsFiltered = pageInfo.getTotal();
        this.customActionMessage = "查询完毕";
        this.customActionStatus = "OK";
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getCustomActionMessage() {
        return customActionMessage;
    }

    public void setCustomActionMessage(String customActionMessage) {
        this.customActionMessage = customActionMessage;
    }

    public String getCustomActionStatus() {
        return customActionStatus;
    }

    public void setCustomActionStatus(String customActionStatus) {
        this.customActionStatus = customActionStatus;
    }
}
