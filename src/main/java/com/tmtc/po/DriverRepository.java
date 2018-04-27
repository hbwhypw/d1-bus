package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class DriverRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverRepository() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andReal_nameEqualTo(String value) {
            addCriterion("real_name =", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThan(String value) {
            addCriterion("real_name >", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThan(String value) {
            addCriterion("real_name <", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLike(String value) {
            addCriterion("real_name like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotLike(String value) {
            addCriterion("real_name not like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameIn(List<String> values) {
            addCriterion("real_name in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andDriver_ageIsNull() {
            addCriterion("driver_age is null");
            return (Criteria) this;
        }

        public Criteria andDriver_ageIsNotNull() {
            addCriterion("driver_age is not null");
            return (Criteria) this;
        }

        public Criteria andDriver_ageEqualTo(Integer value) {
            addCriterion("driver_age =", value, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageNotEqualTo(Integer value) {
            addCriterion("driver_age <>", value, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageGreaterThan(Integer value) {
            addCriterion("driver_age >", value, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_age >=", value, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageLessThan(Integer value) {
            addCriterion("driver_age <", value, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageLessThanOrEqualTo(Integer value) {
            addCriterion("driver_age <=", value, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageIn(List<Integer> values) {
            addCriterion("driver_age in", values, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageNotIn(List<Integer> values) {
            addCriterion("driver_age not in", values, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageBetween(Integer value1, Integer value2) {
            addCriterion("driver_age between", value1, value2, "driver_age");
            return (Criteria) this;
        }

        public Criteria andDriver_ageNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_age not between", value1, value2, "driver_age");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andLicense_noIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicense_noIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_noEqualTo(String value) {
            addCriterion("license_no =", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noNotEqualTo(String value) {
            addCriterion("license_no <>", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noGreaterThan(String value) {
            addCriterion("license_no >", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noLessThan(String value) {
            addCriterion("license_no <", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noLike(String value) {
            addCriterion("license_no like", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noNotLike(String value) {
            addCriterion("license_no not like", value, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noIn(List<String> values) {
            addCriterion("license_no in", values, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noNotIn(List<String> values) {
            addCriterion("license_no not in", values, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_noNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "license_no");
            return (Criteria) this;
        }

        public Criteria andLicense_picIsNull() {
            addCriterion("license_pic is null");
            return (Criteria) this;
        }

        public Criteria andLicense_picIsNotNull() {
            addCriterion("license_pic is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_picEqualTo(String value) {
            addCriterion("license_pic =", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picNotEqualTo(String value) {
            addCriterion("license_pic <>", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picGreaterThan(String value) {
            addCriterion("license_pic >", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picGreaterThanOrEqualTo(String value) {
            addCriterion("license_pic >=", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picLessThan(String value) {
            addCriterion("license_pic <", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picLessThanOrEqualTo(String value) {
            addCriterion("license_pic <=", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picLike(String value) {
            addCriterion("license_pic like", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picNotLike(String value) {
            addCriterion("license_pic not like", value, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picIn(List<String> values) {
            addCriterion("license_pic in", values, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picNotIn(List<String> values) {
            addCriterion("license_pic not in", values, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picBetween(String value1, String value2) {
            addCriterion("license_pic between", value1, value2, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_picNotBetween(String value1, String value2) {
            addCriterion("license_pic not between", value1, value2, "license_pic");
            return (Criteria) this;
        }

        public Criteria andLicense_typeIsNull() {
            addCriterion("license_type is null");
            return (Criteria) this;
        }

        public Criteria andLicense_typeIsNotNull() {
            addCriterion("license_type is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_typeEqualTo(Integer value) {
            addCriterion("license_type =", value, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeNotEqualTo(Integer value) {
            addCriterion("license_type <>", value, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeGreaterThan(Integer value) {
            addCriterion("license_type >", value, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("license_type >=", value, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeLessThan(Integer value) {
            addCriterion("license_type <", value, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeLessThanOrEqualTo(Integer value) {
            addCriterion("license_type <=", value, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeIn(List<Integer> values) {
            addCriterion("license_type in", values, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeNotIn(List<Integer> values) {
            addCriterion("license_type not in", values, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeBetween(Integer value1, Integer value2) {
            addCriterion("license_type between", value1, value2, "license_type");
            return (Criteria) this;
        }

        public Criteria andLicense_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("license_type not between", value1, value2, "license_type");
            return (Criteria) this;
        }

        public Criteria andNative_placeIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNative_placeIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNative_placeEqualTo(String value) {
            addCriterion("native_place =", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeNotEqualTo(String value) {
            addCriterion("native_place <>", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeGreaterThan(String value) {
            addCriterion("native_place >", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeLessThan(String value) {
            addCriterion("native_place <", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeLike(String value) {
            addCriterion("native_place like", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeNotLike(String value) {
            addCriterion("native_place not like", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeIn(List<String> values) {
            addCriterion("native_place in", values, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeNotIn(List<String> values) {
            addCriterion("native_place not in", values, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "native_place");
            return (Criteria) this;
        }

        public Criteria andNative_placeNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "native_place");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceIsNull() {
            addCriterion("driver_source is null");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceIsNotNull() {
            addCriterion("driver_source is not null");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceEqualTo(Integer value) {
            addCriterion("driver_source =", value, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceNotEqualTo(Integer value) {
            addCriterion("driver_source <>", value, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceGreaterThan(Integer value) {
            addCriterion("driver_source >", value, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_source >=", value, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceLessThan(Integer value) {
            addCriterion("driver_source <", value, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceLessThanOrEqualTo(Integer value) {
            addCriterion("driver_source <=", value, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceIn(List<Integer> values) {
            addCriterion("driver_source in", values, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceNotIn(List<Integer> values) {
            addCriterion("driver_source not in", values, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceBetween(Integer value1, Integer value2) {
            addCriterion("driver_source between", value1, value2, "driver_source");
            return (Criteria) this;
        }

        public Criteria andDriver_sourceNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_source not between", value1, value2, "driver_source");
            return (Criteria) this;
        }

        public Criteria andCity_idIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCity_idIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCity_idEqualTo(Integer value) {
            addCriterion("city_id =", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idGreaterThan(Integer value) {
            addCriterion("city_id >", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idLessThan(Integer value) {
            addCriterion("city_id <", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idIn(List<Integer> values) {
            addCriterion("city_id in", values, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "city_id");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andBg_picIsNull() {
            addCriterion("bg_pic is null");
            return (Criteria) this;
        }

        public Criteria andBg_picIsNotNull() {
            addCriterion("bg_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBg_picEqualTo(String value) {
            addCriterion("bg_pic =", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picNotEqualTo(String value) {
            addCriterion("bg_pic <>", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picGreaterThan(String value) {
            addCriterion("bg_pic >", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picGreaterThanOrEqualTo(String value) {
            addCriterion("bg_pic >=", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picLessThan(String value) {
            addCriterion("bg_pic <", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picLessThanOrEqualTo(String value) {
            addCriterion("bg_pic <=", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picLike(String value) {
            addCriterion("bg_pic like", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picNotLike(String value) {
            addCriterion("bg_pic not like", value, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picIn(List<String> values) {
            addCriterion("bg_pic in", values, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picNotIn(List<String> values) {
            addCriterion("bg_pic not in", values, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picBetween(String value1, String value2) {
            addCriterion("bg_pic between", value1, value2, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andBg_picNotBetween(String value1, String value2) {
            addCriterion("bg_pic not between", value1, value2, "bg_pic");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andIs_checkIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIs_checkIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIs_checkEqualTo(Integer value) {
            addCriterion("is_check =", value, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkNotEqualTo(Integer value) {
            addCriterion("is_check <>", value, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkGreaterThan(Integer value) {
            addCriterion("is_check >", value, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_check >=", value, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkLessThan(Integer value) {
            addCriterion("is_check <", value, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkLessThanOrEqualTo(Integer value) {
            addCriterion("is_check <=", value, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkIn(List<Integer> values) {
            addCriterion("is_check in", values, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkNotIn(List<Integer> values) {
            addCriterion("is_check not in", values, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkBetween(Integer value1, Integer value2) {
            addCriterion("is_check between", value1, value2, "is_check");
            return (Criteria) this;
        }

        public Criteria andIs_checkNotBetween(Integer value1, Integer value2) {
            addCriterion("is_check not between", value1, value2, "is_check");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}