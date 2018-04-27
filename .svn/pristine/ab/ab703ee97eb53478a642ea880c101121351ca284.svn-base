package com.tmtc.serviceImpl;

import com.tmtc.dao.BtnDao;
import com.tmtc.po.Btn;
import com.tmtc.po.BtnRepository;
import com.tmtc.service.BtnService;
import com.tmtc.vo.BtnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015-11-14 17:09
 */
@Service
public class BtnServiceImpl implements BtnService {
    @Autowired
    BtnDao btnDao;

    @Override
    public int count(BtnRepository example) {
        return btnDao.countByExample(example);
    }

    @Override
    public int delete(String id) {
        return btnDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delete(BtnRepository example) {
        return btnDao.deleteByExample(example);
    }

    @Override
    public int insert(Btn record) {
        return btnDao.insert(record);
    }

    @Override
    public List<Btn> select(BtnRepository example) {
        return btnDao.selectByExample(example);
    }

    @Override
    public Btn selectByPrimaryKey(String id) {
        return btnDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Btn record) {
        return btnDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(Btn record, BtnRepository example) {
        return btnDao.updateByExampleSelective(record, example);
    }

    @Override
    public List<BtnNode> selectGroupBtn(BtnRepository example) {
        List<Btn> groupIds = btnDao.selectGroupId();
        List<Btn> btns = select(example);
        List<BtnNode> btnNodes = new ArrayList<>();
        for (Btn groupId : groupIds) {
            BtnNode btnNode = new BtnNode(groupId.getId(), groupId.getBtn_id(), groupId.getBtn_name(), groupId.getGroup_id(), groupId.getGroup_name(), groupId.getRemark(), null);
            List<Btn> children = new ArrayList<>();
            for (Btn btn : btns) {
                if (btn.getGroup_id().equals(groupId.getGroup_id())) {
                    children.add(btn);
                }
            }
            btnNode.setChildren(children);
            btnNodes.add(btnNode);
        }//
        return btnNodes;
    }
}
