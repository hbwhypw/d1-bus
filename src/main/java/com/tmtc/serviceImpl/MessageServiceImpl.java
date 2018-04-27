package com.tmtc.serviceImpl;

import com.tmtc.dao.DictionaryDao;
import com.tmtc.dao.MessageDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.po.Message;
import com.tmtc.po.MessageRepository;
import com.tmtc.service.MessageService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.MessageVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/27 15:44
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;
    @Autowired
    DictionaryDao dictionaryDao;
    @Override
    public int count(MessageRepository example) {
        return messageDao.countByExample(example);
    }

    @Override
    public int delete(String id) {
        return messageDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delete(MessageRepository example) {
        return messageDao.deleteByExample(example);
    }

    @Override
    public int insert(Message record) {
        return messageDao.insert(record);
    }

    @Override
    public List<Message> select(MessageRepository example) {
        return messageDao.selectByExample(example);
    }

    @Override
    public Message selectByPrimaryKey(String id) {
        return messageDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Message record) {
        return messageDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(Message record, MessageRepository example) {
        return messageDao.updateByExampleSelective(record, example);
    }

    @Override
    public PageResult selectByPage(MessageRepository example) {
    	List<Message> listMessage = select(example);
    	List<MessageVo> listVo = new ArrayList<MessageVo>();
    	for(Message message:listMessage){
    		String type_name = null;
    		if(0 != VerificationUtil.integerIsNull(message.getType())){
    			type_name = getName(message.getType());
    		}
    		MessageVo mesageVo = new MessageVo(message, type_name);
    		listVo.add(mesageVo);
    	}
        return new PageResult(count(example), listVo, 1);
    }
    
    public String getName(Integer code){
		String name = null;
		List<Dictionary> listDictionary = dictionaryDao.selectByExample(new DictionaryRepository());
		for(Dictionary dictionary : listDictionary){
			if(dictionary.getCode().equals(code)){
				name = dictionary.getName();
			}
		}
		return name;
    }
}
