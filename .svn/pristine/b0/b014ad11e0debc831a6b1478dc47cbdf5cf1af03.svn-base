package com.tmtc.service;

import com.tmtc.frame.PageResult;
import com.tmtc.po.Admins;
import com.tmtc.po.AdminsRepository;
import com.tmtc.vo.AdminVo;

import java.util.List;
import java.util.Map;

/**
 * Creater: hbwhypw
 * Date: 2015/9/18 9:34
 * Function:
 */
public interface AdminsService extends IService<Admins, AdminsRepository>,PageService<AdminsRepository> {
    List<AdminVo> selectAdmins(Map map);

    Integer countAdmins(Map map);

    PageResult selectByPage(Map map);
    
    int updatePassWord(String id);
}
