package com.tmtc.vo;

import com.tmtc.po.Admins;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015-11-09 14:26
 */
public class AdminVo extends Admins {
    private String cityName;
    private String roleName;
    private String companyName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AdminVo() {
    }

    public AdminVo(Admins admins,String cityName, String roleName, String companyName) {
        setId(admins.getId());
        setLogin_date(admins.getLogin_date());
        setCreate_time(admins.getCreate_time());
        setCity_id(admins.getCity_id());
        setCompany_id(admins.getCompany_id());
        setEmail(admins.getEmail());
        setUsername(admins.getUsername());
        setNick_name(admins.getNick_name());
        setLock_time(admins.getLock_time());
        setLogin_cunt(admins.getLogin_cunt());
        setType(admins.getType());
        this.cityName = cityName;
        this.roleName = roleName;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "cityName='" + cityName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", companyName='" + companyName + '\'' +
                "} " + super.toString();
    }
}
