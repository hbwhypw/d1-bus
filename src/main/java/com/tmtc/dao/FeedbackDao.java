package com.tmtc.dao;

import com.tmtc.po.Feedback;
import com.tmtc.po.FeedbackRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackDao {
    int countByExample(FeedbackRepository example);

    int deleteByExample(FeedbackRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExample(FeedbackRepository example);

    Feedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackRepository example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackRepository example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}