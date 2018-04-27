package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class LineOrderRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineOrderRepository() {
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

        public Criteria andOrder_noIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrder_noIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_noEqualTo(String value) {
            addCriterion("order_no =", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotEqualTo(String value) {
            addCriterion("order_no <>", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noGreaterThan(String value) {
            addCriterion("order_no >", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noLessThan(String value) {
            addCriterion("order_no <", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noLike(String value) {
            addCriterion("order_no like", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotLike(String value) {
            addCriterion("order_no not like", value, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noIn(List<String> values) {
            addCriterion("order_no in", values, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotIn(List<String> values) {
            addCriterion("order_no not in", values, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "order_no");
            return (Criteria) this;
        }

        public Criteria andOrder_noNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "order_no");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(String value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(String value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(String value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(String value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<String> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<String> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
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

        public Criteria andLine_idIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLine_idIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLine_idEqualTo(String value) {
            addCriterion("line_id =", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotEqualTo(String value) {
            addCriterion("line_id <>", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idGreaterThan(String value) {
            addCriterion("line_id >", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLessThan(String value) {
            addCriterion("line_id <", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idIn(List<String> values) {
            addCriterion("line_id in", values, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotIn(List<String> values) {
            addCriterion("line_id not in", values, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idIsNull() {
            addCriterion("time_line_id is null");
            return (Criteria) this;
        }

        public Criteria andTime_line_idIsNotNull() {
            addCriterion("time_line_id is not null");
            return (Criteria) this;
        }

        public Criteria andTime_line_idEqualTo(String value) {
            addCriterion("time_line_id =", value, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idNotEqualTo(String value) {
            addCriterion("time_line_id <>", value, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idGreaterThan(String value) {
            addCriterion("time_line_id >", value, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idGreaterThanOrEqualTo(String value) {
            addCriterion("time_line_id >=", value, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idLessThan(String value) {
            addCriterion("time_line_id <", value, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idLessThanOrEqualTo(String value) {
            addCriterion("time_line_id <=", value, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idIn(List<String> values) {
            addCriterion("time_line_id in", values, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idNotIn(List<String> values) {
            addCriterion("time_line_id not in", values, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idBetween(String value1, String value2) {
            addCriterion("time_line_id between", value1, value2, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andTime_line_idNotBetween(String value1, String value2) {
            addCriterion("time_line_id not between", value1, value2, "time_line_id");
            return (Criteria) this;
        }

        public Criteria andStation_idIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStation_idIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStation_idEqualTo(String value) {
            addCriterion("station_id =", value, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idNotEqualTo(String value) {
            addCriterion("station_id <>", value, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idGreaterThan(String value) {
            addCriterion("station_id >", value, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idGreaterThanOrEqualTo(String value) {
            addCriterion("station_id >=", value, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idLessThan(String value) {
            addCriterion("station_id <", value, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idLessThanOrEqualTo(String value) {
            addCriterion("station_id <=", value, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idIn(List<String> values) {
            addCriterion("station_id in", values, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idNotIn(List<String> values) {
            addCriterion("station_id not in", values, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idBetween(String value1, String value2) {
            addCriterion("station_id between", value1, value2, "station_id");
            return (Criteria) this;
        }

        public Criteria andStation_idNotBetween(String value1, String value2) {
            addCriterion("station_id not between", value1, value2, "station_id");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeEqualTo(Date value) {
            addCriterion("order_time =", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThan(Date value) {
            addCriterion("order_time >", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThan(Date value) {
            addCriterion("order_time <", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIn(List<Date> values) {
            addCriterion("order_time in", values, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(Integer value) {
            addCriterion("order_status =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(Integer value) {
            addCriterion("order_status <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<Integer> values) {
            addCriterion("order_status in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_expIsNull() {
            addCriterion("order_exp is null");
            return (Criteria) this;
        }

        public Criteria andOrder_expIsNotNull() {
            addCriterion("order_exp is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_expEqualTo(Integer value) {
            addCriterion("order_exp =", value, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expNotEqualTo(Integer value) {
            addCriterion("order_exp <>", value, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expGreaterThan(Integer value) {
            addCriterion("order_exp >", value, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_exp >=", value, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expLessThan(Integer value) {
            addCriterion("order_exp <", value, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expLessThanOrEqualTo(Integer value) {
            addCriterion("order_exp <=", value, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expIn(List<Integer> values) {
            addCriterion("order_exp in", values, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expNotIn(List<Integer> values) {
            addCriterion("order_exp not in", values, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expBetween(Integer value1, Integer value2) {
            addCriterion("order_exp between", value1, value2, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_expNotBetween(Integer value1, Integer value2) {
            addCriterion("order_exp not between", value1, value2, "order_exp");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeEqualTo(Integer value) {
            addCriterion("order_type =", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThan(Integer value) {
            addCriterion("order_type <", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIn(List<Integer> values) {
            addCriterion("order_type in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andScan_timeIsNull() {
            addCriterion("scan_time is null");
            return (Criteria) this;
        }

        public Criteria andScan_timeIsNotNull() {
            addCriterion("scan_time is not null");
            return (Criteria) this;
        }

        public Criteria andScan_timeEqualTo(Date value) {
            addCriterion("scan_time =", value, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeNotEqualTo(Date value) {
            addCriterion("scan_time <>", value, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeGreaterThan(Date value) {
            addCriterion("scan_time >", value, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("scan_time >=", value, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeLessThan(Date value) {
            addCriterion("scan_time <", value, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeLessThanOrEqualTo(Date value) {
            addCriterion("scan_time <=", value, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeIn(List<Date> values) {
            addCriterion("scan_time in", values, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeNotIn(List<Date> values) {
            addCriterion("scan_time not in", values, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeBetween(Date value1, Date value2) {
            addCriterion("scan_time between", value1, value2, "scan_time");
            return (Criteria) this;
        }

        public Criteria andScan_timeNotBetween(Date value1, Date value2) {
            addCriterion("scan_time not between", value1, value2, "scan_time");
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