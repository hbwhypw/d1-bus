package com.tmtc.service;

import com.tmtc.po.MessageRecord;
import com.tmtc.po.MessageRecordRepository;
import com.tmtc.vo.MessageRecordVo;

import java.util.List;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/27 15:38
 */
public interface MessageRecordService extends IService<MessageRecord, MessageRecordRepository>,
        PageService<MessageRecordRepository> {
       List<MessageRecordVo> selectVo(MessageRecordRepository example);
       
       List<MessageRecord> selectVo(String userId);
}