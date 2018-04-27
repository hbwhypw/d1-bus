package com.tmtc.serviceImpl;

import com.tmtc.dao.DictionaryDao;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created:  hbwhypw
 * Date: 2015/10/13 9:45
 * Function: 下拉选项辅助服务类
 */
@Service
public class ComboBoxServiceImpl {
    @Autowired
    DictionaryDao dictionaryDao;

    private List<Dictionary> getDictionarys(){
        return dictionaryDao.selectByExample(new DictionaryRepository());
    }

    protected String getNameByCode(int code){
        String name = null;
        List<Dictionary> listDictionary = getDictionarys();
        for(Dictionary dictionary : listDictionary){
            if(dictionary.getCode().equals(code)){
                name = dictionary.getName();
                break;
            }
        }
        return name;
    }
}
