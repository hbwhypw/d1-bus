package com.tmtc.service;

import java.util.List;

import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;

public interface DictionaryService extends IService<Dictionary, DictionaryRepository>,PageService<DictionaryRepository>{
	public int delete(Dictionary dictionary);
	public Dictionary selectMax(int code);
	public Dictionary selectRootMax();
	public List<Dictionary> selectByCode(DictionaryRepository example);
	public int updateRecover(String id);
	int deleteForEver(String id);
}
