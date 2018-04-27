package com.tmtc.service;

import com.tmtc.po.Btn;
import com.tmtc.po.BtnRepository;
import com.tmtc.vo.BtnNode;

import java.util.List;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015-11-14 17:08
 */
public interface BtnService extends IService<Btn, BtnRepository> {
    List<BtnNode> selectGroupBtn(BtnRepository example);
}
