package com.tmtc.frame;

import com.tmtc.po.page.PageRespository;
import com.tmtc.utils.VerificationUtil;

public class BasePage {

	/**
     * 设置分页参数
     * @param pageRespository 分页参数
     * @param page 页数
     * @param rows 条数
     */
    protected void setPageParams(PageRespository pageRespository,Integer page,Integer rows){
        if (0 < VerificationUtil.integerIsNull(page) && 0 < VerificationUtil.integerIsNull(rows)) {
            pageRespository.setRowIndex((page - 1) * rows);
            pageRespository.setPageSize(rows);
        }
    }
    
}
