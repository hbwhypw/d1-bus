package com.tmtc.service;

import com.tmtc.frame.JsonResult;
import com.tmtc.po.Btn;
import com.tmtc.po.Role;
import com.tmtc.po.RoleRepository;
import com.tmtc.utils.EasyuiTree.TreeNode;

import java.util.List;

/**
 * Created:  hbwhypw
 * Date: 2015/9/24 9:22
 * Function:
 */
public interface RoleService extends IService<Role, RoleRepository>,PageService<RoleRepository> {
    List<TreeNode> selectTree(String id);
    List<Btn> selectBtn(String role_id);
    JsonResult selectResource(String id);
}
