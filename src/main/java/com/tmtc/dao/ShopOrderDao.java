package com.tmtc.dao;

import com.tmtc.po.Company;
import com.tmtc.po.Product;
import com.tmtc.po.ShopOrder;
import com.tmtc.po.ShopOrderRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopOrderDao {
    int countByExample(ShopOrderRepository example);

    int deleteByExample(ShopOrderRepository example);

    int deleteByPrimaryKey(String id);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    List<ShopOrder> selectByExample(ShopOrderRepository example);

    ShopOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopOrder record, @Param("example") ShopOrderRepository example);

    int updateByExample(@Param("record") ShopOrder record, @Param("example") ShopOrderRepository example);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);
    
    List<Company> selectCompanyById(@Param("pro_id") String pro_id);
    
    List<Product> selectProductByCompanyId(@Param("company_id") String company_id,@Param("pro_id") String pro_id);
}