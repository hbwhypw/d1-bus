package com.tmtc.dao;

import com.tmtc.po.ShopInvoice;
import com.tmtc.po.ShopInvoiceRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopInvoiceDao {
    int countByExample(ShopInvoiceRepository example);

    int deleteByExample(ShopInvoiceRepository example);

    int deleteByPrimaryKey(String id);

    int insert(ShopInvoice record);

    int insertSelective(ShopInvoice record);

    List<ShopInvoice> selectByExample(ShopInvoiceRepository example);

    ShopInvoice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopInvoice record, @Param("example") ShopInvoiceRepository example);

    int updateByExample(@Param("record") ShopInvoice record, @Param("example") ShopInvoiceRepository example);

    int updateByPrimaryKeySelective(ShopInvoice record);

    int updateByPrimaryKey(ShopInvoice record);
}