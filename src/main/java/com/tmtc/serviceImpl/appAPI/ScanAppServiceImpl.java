package com.tmtc.serviceImpl.appAPI;

import java.util.Date;
import java.util.List;

import com.tmtc.dao.*;
import com.tmtc.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.PageResult;
import com.tmtc.service.appAPI.CarAppService;
import com.tmtc.service.appAPI.ScanAppService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.OrderNumUtil;
import com.tmtc.utils.VerificationUtil;

@Service
public class ScanAppServiceImpl implements ScanAppService {

    @Autowired
    ScanDao scanDao;

    @Autowired
    LineDao lineDao;

    @Autowired
    LineOrderDao lineOrderDao;

    @Autowired
    CarAppService carAppService;

    @Autowired
    UserDetailDao userDetailDao;

    @Autowired
    UserDao userDao;

    @Override
    public int count(ScanRepository example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(String id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(ScanRepository example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(Scan record) {
        return scanDao.insert(record);
    }

    @Override
    public List<Scan> select(ScanRepository example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scan selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(Scan record) {
        return scanDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(Scan record, ScanRepository example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public PageResult selectByPage(ScanRepository example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(String userId, String station_id, String time_line_id) {
        Scan scan = new Scan();
        scan.setId(IdWorker.nextId());
        scan.setUser_id(userId);
        scan.setStation_id(station_id);
        scan.setStatus(ParameterConstant.USER_STATUS_GETOFF);
        scan.setCreate_time(new Date());
        scan.setIs_check(ParameterConstant.IS_CHECK);
        scan.setLinetime_id(time_line_id);
        return scanDao.insert(scan);
    }

    @Override
    public int insertLineOrder(UserDetail userDetail, LineTime lineTime, String station_id, int userTypeCompany) {

        User user = userDao.selectByPrimaryKey(userDetail.getId());
        Line line1 = lineDao.selectByPrimaryKey(lineTime.getLine_id());
        if (null == user || null == line1 || !user.getCompany_id().equals(line1.getCompany_id())) {
            return 0;
        }

        ScanRepository scanRepository = new ScanRepository();
        com.tmtc.po.ScanRepository.Criteria createCriteria = scanRepository.createCriteria();
        createCriteria.andUser_idEqualTo(userDetail.getId());
        createCriteria.andLinetime_idEqualTo(lineTime.getId());
        createCriteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);

        List<Scan> list = scanDao.selectByExample(scanRepository);
        if (0 != VerificationUtil.size(list)) {
            return 2;
        }

        Line line = lineDao.selectByPrimaryKey(lineTime.getLine_id());
        if (null == line) {
            return 0;
        }
        int insert = 0;
        if (ParameterConstant.USER_TYPE_COMPANY == userTypeCompany) {
            LineOrder lineOrder = new LineOrder(IdWorker.nextId(), OrderNumUtil.getOrderByXL(), userDetail.getId(),
                    line.getCity_id(), line.getId(), lineTime.getId(), station_id, new Date(),
                    ParameterConstant.ORDER_STATUS, ParameterConstant.ORDER_EXP,
                    ParameterConstant.LINE_ORDER_TYPE_DIRECT, new Date(), ParameterConstant.IS_CHECK);
            insert = lineOrderDao.insert(lineOrder);

            //扫码送积分
            UserDetail upUser = new UserDetail();
            upUser.setId(userDetail.getId());
            upUser.setExp_score(userDetail.getExp_score() + ParameterConstant.ORDER_EXP);
            userDetailDao.updateByPrimaryKeySelective(upUser);
        }

        if (ParameterConstant.USER_TYPE_COMPANY_NORMAL_100 == userTypeCompany) {
            LineOrderRepository lineOrderRepository = new LineOrderRepository();
            LineOrderRepository.Criteria criteria = lineOrderRepository.createCriteria();
            criteria.andUser_idEqualTo(userDetail.getId());
            criteria.andTime_line_idEqualTo(lineTime.getId());
            criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
            criteria.andOrder_statusEqualTo(ParameterConstant.ORDER_STATUS_NOT);
            List<LineOrder> LineOrderList = lineOrderDao.selectByExample(lineOrderRepository);
            if (0 == LineOrderList.size()) {
                return 0;
            }

            LineOrder lineOrder = LineOrderList.get(0);
            lineOrder.setOrder_status(ParameterConstant.ORDER_STATUS);
            lineOrder.setScan_time(new Date());
            lineOrder.setStation_id(station_id);
            lineOrder.setOrder_exp(ParameterConstant.ORDER_EXP);
            insert = lineOrderDao.updateByPrimaryKeySelective(lineOrder);

            //扫码送积分
            UserDetail upUser = new UserDetail();
            upUser.setId(userDetail.getId());
            upUser.setExp_score(userDetail.getExp_score() + ParameterConstant.ORDER_EXP);
            userDetailDao.updateByPrimaryKeySelective(upUser);
        }

        if (0 < insert) {
            carAppService.updateSeat(lineTime.getId());
        }
        Scan scan = new Scan(IdWorker.nextId(), userDetail.getId(), lineTime.getId(), station_id, new Date(),
                ParameterConstant.SCAN_TYPE_FINISH, ParameterConstant.IS_CHECK);
        return insert(scan);
    }
}
