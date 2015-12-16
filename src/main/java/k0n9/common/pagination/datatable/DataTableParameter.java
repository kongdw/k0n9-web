package k0n9.common.pagination.datatable;

import java.io.Serializable;
import java.util.List;

/**
 * dataTable 请求参数封装
 * {
 * "draw":1,
 * "columns":[
 * {"data":"username","name":"","searchable":true,"orderable":true,"search":{"value":"","regex":false}},
 * {"data":"username","name":"","searchable":true,"orderable":true,"search":{"value":"","regex":false}}
 * ],
 * "order":[
 * {"column":1,"dir":"asc"}
 * ],
 * "start":0,
 * "length":10,
 * "search":{"value":"","regex":false}
 * }
 *
 * @author David Kong
 * @version 1.0
 */
public class DataTableParameter implements Serializable {

    private static final long serialVersionUID = 5175950216914643869L;

    private int draw;

    private int start;

    private int length;

    private List<Column> columns;

    private List<Order> order;

    private Search search;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    private static class Column implements Serializable {

        private static final long serialVersionUID = 4903264849573627321L;

        private String data;

        private String name;

        private Boolean searchable;

        private Boolean orderable;

        private Search search;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getSearchable() {
            return searchable;
        }

        public void setSearchable(Boolean searchable) {
            this.searchable = searchable;
        }

        public Boolean getOrderable() {
            return orderable;
        }

        public void setOrderable(Boolean orderable) {
            this.orderable = orderable;
        }

        public Search getSearch() {
            return search;
        }

        public void setSearch(Search search) {
            this.search = search;
        }
    }

    private static class Order implements Serializable {

        private static final long serialVersionUID = 7711010408302631700L;

        private int column;

        private String dir;

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }
    }

    private static class Search implements Serializable {

        private static final long serialVersionUID = -4306184150539182847L;

        private String value;

        private Boolean regex;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Boolean getRegex() {
            return regex;
        }

        public void setRegex(Boolean regex) {
            this.regex = regex;
        }
    }

}
