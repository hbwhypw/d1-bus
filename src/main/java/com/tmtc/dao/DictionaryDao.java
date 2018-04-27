package com.tmtc.dao;

import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryDao {
    int countByExample(DictionaryRepository example);

    int deleteByExample(DictionaryRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryRepository example);

    Dictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryRepository example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryRepository example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    Dictionary selectMax(@Param("code") Integer code);
    
    Dictionary selectRootMax();
    
    String selectNameByCode(int code);
}