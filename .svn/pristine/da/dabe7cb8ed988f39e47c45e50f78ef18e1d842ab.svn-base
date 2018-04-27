package com.tmtc.frame;

import java.io.Serializable;

public class PageResult implements Serializable {


    private Integer total;
    private Object rows;
    private Integer code;

    /**
     * jquery分页�?
     */
    private static final long serialVersionUID = -8283306469392942475L;

    public PageResult() {
        this.total = 0;
        this.code = 1;
        this.rows = null;
    }

    public PageResult(Integer total, Object rows, Integer code) {
        this.total = total;
        this.rows = rows;
        this.code = code;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
