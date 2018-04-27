package com.tmtc.dao;

import com.tmtc.po.BaiduTemp;
import com.tmtc.po.BaiduTempRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaiduTempDao {
    int countByExample(BaiduTempRepository example);

    int deleteByExample(BaiduTempRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(BaiduTemp record);

    int insertSelective(BaiduTemp record);

    List<BaiduTemp> selectByExample(BaiduTempRepository example);

    BaiduTemp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaiduTemp record, @Param("example") BaiduTempRepository example);

    int updateByExample(@Param("record") BaiduTemp record, @Param("example") BaiduTempRepository example);

    int updateByPrimaryKeySelective(BaiduTemp record);

    int updateByPrimaryKey(BaiduTemp record);
}