package com.tmtc.serviceImpl;

import com.tmtc.dao.LogDao;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.frame.ServiceExceptionEnum;
import com.tmtc.po.Log;
import com.tmtc.po.LogRepository;
import com.tmtc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created:  hbwhypw
 * Date: 2015/10/20 17:08
 * Function:
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    @Override
    public int count(LogRepository example) {
        return logDao.countByExample(example);
    }

    @Override
    public int delete(String id) {
        return logDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delete(LogRepository example) {
        return logDao.deleteByExample(example);
    }

    @Override
    public int insert(Log record) {
        return logDao.insert(record);
    }

    @Override
    public List<Log> select(LogRepository example) {
        return logDao.selectByExample(example);
    }

    @Override
    public Log selectByPrimaryKey(String id) {
        return logDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Log record) {
        return logDao.updateByPrimaryKey(record);
    }

    @Override
    public int update(Log record, LogRepository example) {
        return logDao.updateByExampleSelective(record, example);
    }

    @Override
    public PageResult selectByPage(LogRepository example) {
        return new PageResult(count(example), select(example), 1);
    }

    @Override
    public int delete(String[] ids) throws ServiceException {
        int i = 1;
        for (String id : ids) {
            if (delete(id) == 0) {
                throw new ServiceException(ServiceExceptionEnum.DELETE_FAIL);
            }
        }
        return i;
    }
}
