package com.tmtc.po.page;

/**
 * Created:  hbwhypw
 * Date: 2015/9/21 18:03
 * Function: 分页辅助查询类
 */
public class PageRespository {
    private Integer rowIndex;
    private Integer pageSize;

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
