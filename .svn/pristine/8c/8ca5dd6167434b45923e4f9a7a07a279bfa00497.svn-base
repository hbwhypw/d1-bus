package com.tmtc.dao;

import com.tmtc.po.Talk;
import com.tmtc.po.TalkRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalkDao {
    int countByExample(TalkRepository example);

    int deleteByExample(TalkRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Talk record);

    int insertSelective(Talk record);

    List<Talk> selectByExample(TalkRepository example);

    Talk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Talk record, @Param("example") TalkRepository example);

    int updateByExample(@Param("record") Talk record, @Param("example") TalkRepository example);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKey(Talk record);
}