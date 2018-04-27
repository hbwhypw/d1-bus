package com.tmtc.service;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.Log;
import com.tmtc.po.LogRepository;

/**
 * Created:  hbwhypw
 * Date: 2015/10/20 17:08
 * Function:
 */
public interface LogService extends IService<Log,LogRepository>, PageService<LogRepository> {
    int delete(String[] ids) throws ServiceException;
}
