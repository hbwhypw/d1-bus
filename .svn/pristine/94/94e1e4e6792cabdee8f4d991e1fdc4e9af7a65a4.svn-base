package com.tmtc.service;

import com.tmtc.frame.PageResult;
import com.tmtc.po.Talk;

public interface TalkService {
	int insert(Talk talk);
	int update(Talk talk);
	PageResult select(Integer page,Integer rows,String type,String room_name,String company_id);
	
	/**
	 * 查询所有房间
	 * @param company_id 
	 * @return
	 */
	Talk select(String company_id);
}
