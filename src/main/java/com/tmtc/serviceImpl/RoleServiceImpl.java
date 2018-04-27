package com.tmtc.serviceImpl;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.BtnDao;
import com.tmtc.dao.ResourceDao;
import com.tmtc.dao.RoleDao;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.*;
import com.tmtc.service.RoleService;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.EasyuiTree.TreeNode;
import com.tmtc.vo.ResourceVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created:  hbwhypw
 * Date: 2015/9/24 9:31
 * Function: 角色服务层
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    ResourceDao resourceDao;
    @Autowired
    BtnDao btnDao;

    @Override
    public int count(RoleRepository example) {
        return roleDao.countByExample(example);
    }

    @Override
    public int delete(String id) {
        return roleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delete(RoleRepository example) {
        return roleDao.deleteByExample(example);
    }

    @Override
    public int insert(Role record) {
    	Integer is_check = record.getIs_check();
    	if(0 == VerificationUtil.integerIsNull(is_check)){
    		record.setIs_check(ParameterConstant.IS_CHECK);
    	}
        return roleDao.insert(record);
    }

    @Override
    public List<Role> select(RoleRepository example) {
        return roleDao.selectByExampleWithBLOBs(example);
    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Role record) {
        return roleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(Role record, RoleRepository example) {
        return roleDao.updateByExampleSelective(record, example);
    }

    @Override
    public PageResult selectByPage(RoleRepository example) {
        return new PageResult(count(example), select(example), 1);
    }

    @Override
    public List<Btn> selectBtn(String role_id) {
        String btn = "";
        if (StringUtils.isNotEmpty(role_id)) {
            Role role = selectByPrimaryKey(role_id);
            btn = role.getBtn();
        }
        List<String> list = new ArrayList<>(Arrays.asList(btn.split(",")));
        BtnRepository btnRepository = new BtnRepository();
        btnRepository.or().andIdIn(list);
        List<Btn> btns = btnDao.selectByExample(btnRepository);
        return btns;
    }

    @Override
    public List<TreeNode> selectTree(String id) {
        String resources = "";
        if (StringUtils.isNotEmpty(id)) {
            Role role = selectByPrimaryKey(id);
            resources = role.getResource();
        }
        ResourceRepository example = new ResourceRepository();
        example.or().andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        List<Resource> list = resourceDao.selectByExample(example);
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        TreeNode treeNode = null;
        TreeNode subTreeNode = null;
        int rootIndex = 0;
        for (int i = 0; i < list.size();i++){
            Resource resource = list.get(i);
            if(resource.getIs_root() == ParameterConstant.IS_ROOT) {
                rootIndex++;
                Map<String,String> attributes = buildAttributes(resource);
                treeNode = new TreeNode();
                treeNode.setId(String.valueOf(rootIndex));
                treeNode.setText(resource.getName());
                treeNode.setAttributes(attributes);
                treeNode.setState("closed");

                List<TreeNode> subTreeNodeList = new ArrayList<TreeNode>();
                int subIndex = 0;
                for (int j = 0; j < list.size(); j++) {
                    Resource subResource = list.get(j);
                    // 子资源必须是非根节点，同时该资源id是子资源的父id
                    if (subResource.getIs_root().equals(ParameterConstant.NOT_ROOT)
                            && resource.getId().equals(subResource.getParent())) {
                        subIndex++;
                        boolean checked = StringUtils.contains(resources, subResource.getId());
                        Map<String,String> subAttributes = buildAttributes(subResource);
                        subTreeNode = new TreeNode(String.valueOf(rootIndex) + String.valueOf(subIndex), subResource.getName(),
                                checked, String.valueOf(rootIndex), subAttributes, null, null, null);
                        subTreeNodeList.add(subTreeNode);
                    }
                }
                treeNode.setChildren(subTreeNodeList);
                treeNodeList.add(treeNode);
            }
        }
        return treeNodeList;
    }

    /**
     * 构建easyui自定义属性对象
     * @param resource
     * @return
     */
    private Map<String, String> buildAttributes(Resource resource){
        Map<String,String> attributes = new HashMap<String,String>();
        try {
            attributes =  BeanUtils.describe(resource);
            attributes.remove("class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return attributes;
    }

    public JsonResult selectResource(String role_id) {
        String resources = "";
        if (StringUtils.isNotEmpty(role_id)) {
            Role role = selectByPrimaryKey(role_id);
            resources = role.getResource();
        }
        ResourceRepository example = new ResourceRepository();
        example.or().andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        List<Resource> list = resourceDao.selectByExample(example);
        List<ResourceVo> listVo = new ArrayList<>();
        ResourceVo vo = null;
        for (Resource resource : list) {
            vo = new ResourceVo(resource);
            //若是根节点，添加子节点
            if (vo.getIs_root() == ParameterConstant.IS_ROOT) {
                List<Resource> subList = new ArrayList<>();
                for (Resource subResource : list) {
                    if (subResource.getIs_root() == ParameterConstant.NOT_ROOT
                            && vo.getId().equals(subResource.getParent())
                            && StringUtils.contains(resources, subResource.getId()))
                    {
                        subList.add(subResource);
                    }
                }
                vo.setChildren(subList);
                if (vo.getChildren().size() != 0) {
                    listVo.add(vo);
                }
            }
        }
        return new JsonResult(1, JsonResult.SUCCESS, listVo);
    }
}
