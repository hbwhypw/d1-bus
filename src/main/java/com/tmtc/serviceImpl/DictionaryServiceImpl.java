package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.DictionaryDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.service.DictionaryService;
import com.tmtc.vo.DictionaryVo;

@Service
public class DictionaryServiceImpl implements DictionaryService{
	
	@Autowired
	DictionaryDao dictionaryDao;
	
	@Override
	public int count(DictionaryRepository example) {
		return dictionaryDao.countByExample(example);
	}
	@Override
	public int delete(String id) {
		return 0;
	}
	@Override
	public int delete(Dictionary dictionary) {
		return dictionaryDao.updateByPrimaryKeySelective(dictionary);
	}
	@Override
	public int delete(DictionaryRepository example) {
		return 0;
	}
	@Override
	public int insert(Dictionary record) {
		return dictionaryDao.insert(record);
	}
	@Override
	public List<Dictionary> select(DictionaryRepository example) {
		return dictionaryDao.selectByExample(example);
	}
	@Override
	public Dictionary selectByPrimaryKey(String id) {
		return null;
	}
	@Override
	public int update(Dictionary record) {
		return dictionaryDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public int update(Dictionary record, DictionaryRepository example) {
		return 0;
	}
	@Override
	public PageResult selectByPage(DictionaryRepository example) {
		List<Dictionary> list = select(example);
        List<DictionaryVo> listVo = new ArrayList<>();
        DictionaryVo vo = null;
        for (Dictionary dictionary : list) {
            vo = new DictionaryVo(dictionary);
            //若是根节点，添加子节点
            if (vo.getIs_sub() == ParameterConstant.NOT_SUB) {
                List<Dictionary> subList = new ArrayList<>();
                for (Dictionary subDictionary : list) {
                    if (subDictionary.getIs_sub() == ParameterConstant.IS_SUB
                    		&& vo.getCode() == subDictionary.getCode()/100) {
                        subList.add(subDictionary);
                    }
                }
                vo.setChildren(subList);
                listVo.add(vo);
            }
        }
        return new PageResult(count(example),listVo, 1);
	}
	@Override
	public List<Dictionary> selectByCode(DictionaryRepository example) {
        return dictionaryDao.selectByExample(example);
	}
	@Override
	public Dictionary selectMax(int code) {
		Dictionary dictionary = dictionaryDao.selectMax(code);
		return dictionary;
	}
	@Override
	public Dictionary selectRootMax() {
		Dictionary dictionary = dictionaryDao.selectRootMax();
		return dictionary;
	}
	@Override
	public int updateRecover(String id) {
		Dictionary dictionary = dictionaryDao.selectByPrimaryKey(id);
		dictionary.setIs_check(ParameterConstant.IS_CHECK);
		return dictionaryDao.updateByPrimaryKeySelective(dictionary);
	}
	@Override
	public int deleteForEver(String id) {
		return dictionaryDao.deleteByPrimaryKey(id);
	}
}
