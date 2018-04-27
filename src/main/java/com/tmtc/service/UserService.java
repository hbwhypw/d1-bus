package com.tmtc.service;

import com.tmtc.po.User;
import com.tmtc.po.UserRepository;

/**
 * Created: hbwhypw Date: 2015/10/15 14:17 Function:
 */
public interface UserService extends IService<User, UserRepository>, PageService<UserRepository> {
	
}
