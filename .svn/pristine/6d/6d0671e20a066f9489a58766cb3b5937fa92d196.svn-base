package com.tmtc.vo;

import com.tmtc.po.Resource;

import java.util.List;

/**
 * Created:  hbwhypw
 * Date: 2015/9/29 17:24
 * Function:
 */
public class ResourceVo extends Resource {
    private String state = "closed";
    private List<Resource> children;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }

    public ResourceVo() {
    }

    public ResourceVo(String id, String name, String url, String parent, Integer is_root, String remark, Integer is_check) {
        super(id, name, url, parent, is_root, remark, is_check);
    }

    public ResourceVo(Resource resource) {
        setId(resource.getId());
        setName(resource.getName());
        setUrl(resource.getUrl());
        setParent(resource.getParent());
        setRemark(resource.getRemark());
        setIs_check(resource.getIs_check());
        setIs_root(resource.getIs_root());
    }

    @Override
    public String toString() {
        return "ResourceVo{" +
                "children=" + children +
                "} " + super.toString();
    }
}
