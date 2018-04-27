package com.tmtc.service;

import com.tmtc.frame.PageResult;
import com.tmtc.po.Card;
import com.tmtc.po.CardRepository;

public interface CardService extends IService<Card, CardRepository> {

	PageResult query(String card_name, Integer page, Integer rows);

	/**
	 * 领取积分
	 * @param id
	 * @param phone
	 * @return
	 */
	int addExpGet(String id, String phone);

}
