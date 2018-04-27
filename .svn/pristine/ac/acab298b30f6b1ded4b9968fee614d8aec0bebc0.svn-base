package com.tmtc.serviceImpl;

import com.tmtc.dao.UserDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.User;
import com.tmtc.po.UserRepository;
import com.tmtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int count(UserRepository example) {
        return userDao.countByExample(example);
    }

    @Override
    public int delete(String id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delete(UserRepository example) {
        return userDao.deleteByExample(example);
    }

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

    @Override
    public List<User> select(UserRepository example) {
        return userDao.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(User record, UserRepository example) {
        return userDao.updateByExampleSelective(record, example);
    }

    @Override
    public PageResult selectByPage(UserRepository example) {
    	return new PageResult(count(example), select(example), 1);
    }
}
