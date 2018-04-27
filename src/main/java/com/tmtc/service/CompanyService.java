package com.tmtc.service;

import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.Company;
import com.tmtc.po.CompanyRepository;
import com.tmtc.vo.CompanyVo;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created:  hbwhypw
 * Date: 2015/10/12 9:54
 * Function:
 */
public interface CompanyService extends IService<Company,CompanyRepository> ,PageService<CompanyRepository>{
    List<CompanyVo> selectVo(CompanyRepository example);
    int insert(Company record,CommonsMultipartFile logo_pic,CommonsMultipartFile business_license) throws ServiceException;
    int update(Company record,CommonsMultipartFile logo_pic_file,CommonsMultipartFile business_license_file) throws ServiceException;
    List<CompanyVo> selectDetail(CompanyRepository example);
    PageResult select();
}
