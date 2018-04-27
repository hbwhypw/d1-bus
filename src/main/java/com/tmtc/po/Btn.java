package com.tmtc.po;

public class Btn {
    private String id;

    private String btn_id;

    private String btn_name;

    private String group_id;

    private String group_name;

    private String remark;

    public Btn() { }

    public Btn(String id, String btn_id, String btn_name, String group_id, String group_name, String remark) {
        this.id = id;
        this.btn_id = btn_id;
        this.btn_name = btn_name;
        this.group_id = group_id;
        this.group_name = group_name;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Btn{" +
                "id='" + id + '\'' +
                ", btn_id='" + btn_id + '\'' +
                ", btn_name='" + btn_name + '\'' +
                ", group_id='" + group_id + '\'' +
                ", group_name='" + group_name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBtn_id() {
        return btn_id;
    }

    public void setBtn_id(String btn_id) {
        this.btn_id = btn_id;
    }

    public String getBtn_name() {
        return btn_name;
    }

    public void setBtn_name(String btn_name) {
        this.btn_name = btn_name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}