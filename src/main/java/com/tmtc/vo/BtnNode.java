package com.tmtc.vo;

import com.tmtc.po.Btn;

import java.util.List;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015-11-15 17:27
 */
public class BtnNode extends Btn{
    private List<Btn> children;

    public List<Btn> getChildren() {
        return children;
    }

    public void setChildren(List<Btn> children) {
        this.children = children;
    }

    public BtnNode() { }


    public BtnNode(List<Btn> children) {
        this.children = children;
    }

    public BtnNode(String id, String btn_id, String btn_name, String group_id, String group_name, String remark, List<Btn> children) {
        super(id, btn_id, btn_name, group_id, group_name, remark);
        this.children = children;
    }
}
