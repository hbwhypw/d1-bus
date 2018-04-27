package com.tmtc.dao;

import com.tmtc.po.Product;
import com.tmtc.po.ProductRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDao {
    int countByExample(ProductRepository example);

    int deleteByExample(ProductRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithBLOBs(ProductRepository example);

    List<Product> selectByExample(ProductRepository example);

    Product selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductRepository example);

    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductRepository example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductRepository example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Long> selectCompany();
}