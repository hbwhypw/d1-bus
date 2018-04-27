package com.tmtc.dao;

import com.tmtc.po.ProductType;
import com.tmtc.po.ProductTypeRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTypeDao {
    int countByExample(ProductTypeRepository example);

    int deleteByExample(ProductTypeRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeRepository example);

    ProductType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeRepository example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeRepository example);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}