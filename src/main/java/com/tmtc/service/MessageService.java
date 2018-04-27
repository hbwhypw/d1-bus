package com.tmtc.service;

import com.tmtc.po.Message;
import com.tmtc.po.MessageRepository;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/27 15:38
 */
public interface MessageService extends IService<Message,MessageRepository>,PageService<MessageRepository> {
}
