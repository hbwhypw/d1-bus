package com.tmtc.po;

public class Resource {
    private String id;

    private String name;

    private String url;

    private String parent;

    private Integer is_root;

    private String remark;

    private Integer is_check;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getIs_root() {
        return is_root;
    }

    public void setIs_root(Integer is_root) {
        this.is_root = is_root;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }

    public Resource() {
    }

    public Resource(String id, String name, String url, String parent, Integer is_root, String remark, Integer is_check) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.parent = parent;
        this.is_root = is_root;
        this.remark = remark;
        this.is_check = is_check;
    }
}