package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class CarRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarRepository() {
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

        public Criteria andCar_numIsNull() {
            addCriterion("car_num is null");
            return (Criteria) this;
        }

        public Criteria andCar_numIsNotNull() {
            addCriterion("car_num is not null");
            return (Criteria) this;
        }

        public Criteria andCar_numEqualTo(String value) {
            addCriterion("car_num =", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numNotEqualTo(String value) {
            addCriterion("car_num <>", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numGreaterThan(String value) {
            addCriterion("car_num >", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numGreaterThanOrEqualTo(String value) {
            addCriterion("car_num >=", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numLessThan(String value) {
            addCriterion("car_num <", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numLessThanOrEqualTo(String value) {
            addCriterion("car_num <=", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numLike(String value) {
            addCriterion("car_num like", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numNotLike(String value) {
            addCriterion("car_num not like", value, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numIn(List<String> values) {
            addCriterion("car_num in", values, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numNotIn(List<String> values) {
            addCriterion("car_num not in", values, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numBetween(String value1, String value2) {
            addCriterion("car_num between", value1, value2, "car_num");
            return (Criteria) this;
        }

        public Criteria andCar_numNotBetween(String value1, String value2) {
            addCriterion("car_num not between", value1, value2, "car_num");
            return (Criteria) this;
        }

        public Criteria andSeatIsNull() {
            addCriterion("seat is null");
            return (Criteria) this;
        }

        public Criteria andSeatIsNotNull() {
            addCriterion("seat is not null");
            return (Criteria) this;
        }

        public Criteria andSeatEqualTo(Integer value) {
            addCriterion("seat =", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotEqualTo(Integer value) {
            addCriterion("seat <>", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatGreaterThan(Integer value) {
            addCriterion("seat >", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("seat >=", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLessThan(Integer value) {
            addCriterion("seat <", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLessThanOrEqualTo(Integer value) {
            addCriterion("seat <=", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatIn(List<Integer> values) {
            addCriterion("seat in", values, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotIn(List<Integer> values) {
            addCriterion("seat not in", values, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatBetween(Integer value1, Integer value2) {
            addCriterion("seat between", value1, value2, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotBetween(Integer value1, Integer value2) {
            addCriterion("seat not between", value1, value2, "seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatIsNull() {
            addCriterion("total_seat is null");
            return (Criteria) this;
        }

        public Criteria andTotal_seatIsNotNull() {
            addCriterion("total_seat is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_seatEqualTo(Integer value) {
            addCriterion("total_seat =", value, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatNotEqualTo(Integer value) {
            addCriterion("total_seat <>", value, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatGreaterThan(Integer value) {
            addCriterion("total_seat >", value, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_seat >=", value, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatLessThan(Integer value) {
            addCriterion("total_seat <", value, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatLessThanOrEqualTo(Integer value) {
            addCriterion("total_seat <=", value, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatIn(List<Integer> values) {
            addCriterion("total_seat in", values, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatNotIn(List<Integer> values) {
            addCriterion("total_seat not in", values, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatBetween(Integer value1, Integer value2) {
            addCriterion("total_seat between", value1, value2, "total_seat");
            return (Criteria) this;
        }

        public Criteria andTotal_seatNotBetween(Integer value1, Integer value2) {
            addCriterion("total_seat not between", value1, value2, "total_seat");
            return (Criteria) this;
        }

        public Criteria andCar_typeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCar_typeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCar_typeEqualTo(Integer value) {
            addCriterion("car_type =", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotEqualTo(Integer value) {
            addCriterion("car_type <>", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeGreaterThan(Integer value) {
            addCriterion("car_type >", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_type >=", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeLessThan(Integer value) {
            addCriterion("car_type <", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeLessThanOrEqualTo(Integer value) {
            addCriterion("car_type <=", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeIn(List<Integer> values) {
            addCriterion("car_type in", values, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotIn(List<Integer> values) {
            addCriterion("car_type not in", values, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeBetween(Integer value1, Integer value2) {
            addCriterion("car_type between", value1, value2, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("car_type not between", value1, value2, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_brandIsNull() {
            addCriterion("car_brand is null");
            return (Criteria) this;
        }

        public Criteria andCar_brandIsNotNull() {
            addCriterion("car_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCar_brandEqualTo(String value) {
            addCriterion("car_brand =", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandNotEqualTo(String value) {
            addCriterion("car_brand <>", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandGreaterThan(String value) {
            addCriterion("car_brand >", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandGreaterThanOrEqualTo(String value) {
            addCriterion("car_brand >=", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandLessThan(String value) {
            addCriterion("car_brand <", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandLessThanOrEqualTo(String value) {
            addCriterion("car_brand <=", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandLike(String value) {
            addCriterion("car_brand like", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandNotLike(String value) {
            addCriterion("car_brand not like", value, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandIn(List<String> values) {
            addCriterion("car_brand in", values, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandNotIn(List<String> values) {
            addCriterion("car_brand not in", values, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandBetween(String value1, String value2) {
            addCriterion("car_brand between", value1, value2, "car_brand");
            return (Criteria) this;
        }

        public Criteria andCar_brandNotBetween(String value1, String value2) {
            addCriterion("car_brand not between", value1, value2, "car_brand");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNull() {
            addCriterion("device is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotNull() {
            addCriterion("device is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceEqualTo(String value) {
            addCriterion("device =", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotEqualTo(String value) {
            addCriterion("device <>", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThan(String value) {
            addCriterion("device >", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("device >=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThan(String value) {
            addCriterion("device <", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThanOrEqualTo(String value) {
            addCriterion("device <=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLike(String value) {
            addCriterion("device like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotLike(String value) {
            addCriterion("device not like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceIn(List<String> values) {
            addCriterion("device in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotIn(List<String> values) {
            addCriterion("device not in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceBetween(String value1, String value2) {
            addCriterion("device between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotBetween(String value1, String value2) {
            addCriterion("device not between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBuy_dateIsNull() {
            addCriterion("buy_date is null");
            return (Criteria) this;
        }

        public Criteria andBuy_dateIsNotNull() {
            addCriterion("buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuy_dateEqualTo(Date value) {
            addCriterion("buy_date =", value, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateNotEqualTo(Date value) {
            addCriterion("buy_date <>", value, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateGreaterThan(Date value) {
            addCriterion("buy_date >", value, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("buy_date >=", value, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateLessThan(Date value) {
            addCriterion("buy_date <", value, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateLessThanOrEqualTo(Date value) {
            addCriterion("buy_date <=", value, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateIn(List<Date> values) {
            addCriterion("buy_date in", values, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateNotIn(List<Date> values) {
            addCriterion("buy_date not in", values, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateBetween(Date value1, Date value2) {
            addCriterion("buy_date between", value1, value2, "buy_date");
            return (Criteria) this;
        }

        public Criteria andBuy_dateNotBetween(Date value1, Date value2) {
            addCriterion("buy_date not between", value1, value2, "buy_date");
            return (Criteria) this;
        }

        public Criteria andFrom_companyIsNull() {
            addCriterion("from_company is null");
            return (Criteria) this;
        }

        public Criteria andFrom_companyIsNotNull() {
            addCriterion("from_company is not null");
            return (Criteria) this;
        }

        public Criteria andFrom_companyEqualTo(Integer value) {
            addCriterion("from_company =", value, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyNotEqualTo(Integer value) {
            addCriterion("from_company <>", value, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyGreaterThan(Integer value) {
            addCriterion("from_company >", value, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_company >=", value, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyLessThan(Integer value) {
            addCriterion("from_company <", value, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyLessThanOrEqualTo(Integer value) {
            addCriterion("from_company <=", value, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyIn(List<Integer> values) {
            addCriterion("from_company in", values, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyNotIn(List<Integer> values) {
            addCriterion("from_company not in", values, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyBetween(Integer value1, Integer value2) {
            addCriterion("from_company between", value1, value2, "from_company");
            return (Criteria) this;
        }

        public Criteria andFrom_companyNotBetween(Integer value1, Integer value2) {
            addCriterion("from_company not between", value1, value2, "from_company");
            return (Criteria) this;
        }

        public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("imei in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("imei not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andCar_picIsNull() {
            addCriterion("car_pic is null");
            return (Criteria) this;
        }

        public Criteria andCar_picIsNotNull() {
            addCriterion("car_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCar_picEqualTo(String value) {
            addCriterion("car_pic =", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picNotEqualTo(String value) {
            addCriterion("car_pic <>", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picGreaterThan(String value) {
            addCriterion("car_pic >", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picGreaterThanOrEqualTo(String value) {
            addCriterion("car_pic >=", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picLessThan(String value) {
            addCriterion("car_pic <", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picLessThanOrEqualTo(String value) {
            addCriterion("car_pic <=", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picLike(String value) {
            addCriterion("car_pic like", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picNotLike(String value) {
            addCriterion("car_pic not like", value, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picIn(List<String> values) {
            addCriterion("car_pic in", values, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picNotIn(List<String> values) {
            addCriterion("car_pic not in", values, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picBetween(String value1, String value2) {
            addCriterion("car_pic between", value1, value2, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_picNotBetween(String value1, String value2) {
            addCriterion("car_pic not between", value1, value2, "car_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picIsNull() {
            addCriterion("car_registration_pic is null");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picIsNotNull() {
            addCriterion("car_registration_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picEqualTo(String value) {
            addCriterion("car_registration_pic =", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picNotEqualTo(String value) {
            addCriterion("car_registration_pic <>", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picGreaterThan(String value) {
            addCriterion("car_registration_pic >", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picGreaterThanOrEqualTo(String value) {
            addCriterion("car_registration_pic >=", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picLessThan(String value) {
            addCriterion("car_registration_pic <", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picLessThanOrEqualTo(String value) {
            addCriterion("car_registration_pic <=", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picLike(String value) {
            addCriterion("car_registration_pic like", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picNotLike(String value) {
            addCriterion("car_registration_pic not like", value, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picIn(List<String> values) {
            addCriterion("car_registration_pic in", values, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picNotIn(List<String> values) {
            addCriterion("car_registration_pic not in", values, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picBetween(String value1, String value2) {
            addCriterion("car_registration_pic between", value1, value2, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andCar_registration_picNotBetween(String value1, String value2) {
            addCriterion("car_registration_pic not between", value1, value2, "car_registration_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picIsNull() {
            addCriterion("appearance_pic is null");
            return (Criteria) this;
        }

        public Criteria andAppearance_picIsNotNull() {
            addCriterion("appearance_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAppearance_picEqualTo(String value) {
            addCriterion("appearance_pic =", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picNotEqualTo(String value) {
            addCriterion("appearance_pic <>", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picGreaterThan(String value) {
            addCriterion("appearance_pic >", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picGreaterThanOrEqualTo(String value) {
            addCriterion("appearance_pic >=", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picLessThan(String value) {
            addCriterion("appearance_pic <", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picLessThanOrEqualTo(String value) {
            addCriterion("appearance_pic <=", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picLike(String value) {
            addCriterion("appearance_pic like", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picNotLike(String value) {
            addCriterion("appearance_pic not like", value, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picIn(List<String> values) {
            addCriterion("appearance_pic in", values, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picNotIn(List<String> values) {
            addCriterion("appearance_pic not in", values, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picBetween(String value1, String value2) {
            addCriterion("appearance_pic between", value1, value2, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andAppearance_picNotBetween(String value1, String value2) {
            addCriterion("appearance_pic not between", value1, value2, "appearance_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picIsNull() {
            addCriterion("trim_pic is null");
            return (Criteria) this;
        }

        public Criteria andTrim_picIsNotNull() {
            addCriterion("trim_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTrim_picEqualTo(String value) {
            addCriterion("trim_pic =", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picNotEqualTo(String value) {
            addCriterion("trim_pic <>", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picGreaterThan(String value) {
            addCriterion("trim_pic >", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picGreaterThanOrEqualTo(String value) {
            addCriterion("trim_pic >=", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picLessThan(String value) {
            addCriterion("trim_pic <", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picLessThanOrEqualTo(String value) {
            addCriterion("trim_pic <=", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picLike(String value) {
            addCriterion("trim_pic like", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picNotLike(String value) {
            addCriterion("trim_pic not like", value, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picIn(List<String> values) {
            addCriterion("trim_pic in", values, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picNotIn(List<String> values) {
            addCriterion("trim_pic not in", values, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picBetween(String value1, String value2) {
            addCriterion("trim_pic between", value1, value2, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andTrim_picNotBetween(String value1, String value2) {
            addCriterion("trim_pic not between", value1, value2, "trim_pic");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateIsNull() {
            addCriterion("insure_end_date is null");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateIsNotNull() {
            addCriterion("insure_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateEqualTo(Date value) {
            addCriterion("insure_end_date =", value, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateNotEqualTo(Date value) {
            addCriterion("insure_end_date <>", value, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateGreaterThan(Date value) {
            addCriterion("insure_end_date >", value, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("insure_end_date >=", value, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateLessThan(Date value) {
            addCriterion("insure_end_date <", value, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateLessThanOrEqualTo(Date value) {
            addCriterion("insure_end_date <=", value, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateIn(List<Date> values) {
            addCriterion("insure_end_date in", values, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateNotIn(List<Date> values) {
            addCriterion("insure_end_date not in", values, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateBetween(Date value1, Date value2) {
            addCriterion("insure_end_date between", value1, value2, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andInsure_end_dateNotBetween(Date value1, Date value2) {
            addCriterion("insure_end_date not between", value1, value2, "insure_end_date");
            return (Criteria) this;
        }

        public Criteria andCar_statusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCar_statusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCar_statusEqualTo(Integer value) {
            addCriterion("car_status =", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotEqualTo(Integer value) {
            addCriterion("car_status <>", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusGreaterThan(Integer value) {
            addCriterion("car_status >", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_status >=", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusLessThan(Integer value) {
            addCriterion("car_status <", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusLessThanOrEqualTo(Integer value) {
            addCriterion("car_status <=", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusIn(List<Integer> values) {
            addCriterion("car_status in", values, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotIn(List<Integer> values) {
            addCriterion("car_status not in", values, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusBetween(Integer value1, Integer value2) {
            addCriterion("car_status between", value1, value2, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("car_status not between", value1, value2, "car_status");
            return (Criteria) this;
        }

        public Criteria andInspection_dateIsNull() {
            addCriterion("inspection_date is null");
            return (Criteria) this;
        }

        public Criteria andInspection_dateIsNotNull() {
            addCriterion("inspection_date is not null");
            return (Criteria) this;
        }

        public Criteria andInspection_dateEqualTo(Date value) {
            addCriterion("inspection_date =", value, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateNotEqualTo(Date value) {
            addCriterion("inspection_date <>", value, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateGreaterThan(Date value) {
            addCriterion("inspection_date >", value, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("inspection_date >=", value, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateLessThan(Date value) {
            addCriterion("inspection_date <", value, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateLessThanOrEqualTo(Date value) {
            addCriterion("inspection_date <=", value, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateIn(List<Date> values) {
            addCriterion("inspection_date in", values, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateNotIn(List<Date> values) {
            addCriterion("inspection_date not in", values, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateBetween(Date value1, Date value2) {
            addCriterion("inspection_date between", value1, value2, "inspection_date");
            return (Criteria) this;
        }

        public Criteria andInspection_dateNotBetween(Date value1, Date value2) {
            addCriterion("inspection_date not between", value1, value2, "inspection_date");
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