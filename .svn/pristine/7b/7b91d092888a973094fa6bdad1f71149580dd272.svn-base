package com.tmtc.service;

import java.text.ParseException;

import com.tmtc.frame.PageResult;
import com.tmtc.po.CardRecord;
import com.tmtc.po.CardRecordRepository;

public interface CardRecordService extends IService<CardRecord, CardRecordRepository>,PageService<CardRecordRepository>{
	PageResult selectByPage(Integer page,Integer rows,String userName,String cardName,String start,String end)throws ParseException;
}
