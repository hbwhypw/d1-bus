package com.tmtc.dao;

import com.tmtc.po.AdPic;
import com.tmtc.po.AdPicRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdPicDao {
    int countByExample(AdPicRepository example);

    int deleteByExample(AdPicRepository example);

    int deleteByPrimaryKey(String id);

    int insert(AdPic record);

    int insertSelective(AdPic record);

    List<AdPic> selectByExample(AdPicRepository example);

    AdPic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdPic record, @Param("example") AdPicRepository example);

    int updateByExample(@Param("record") AdPic record, @Param("example") AdPicRepository example);

    int updateByPrimaryKeySelective(AdPic record);

    int updateByPrimaryKey(AdPic record);
}