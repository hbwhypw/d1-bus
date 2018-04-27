package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class LineTimeRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineTimeRepository() {
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

        public Criteria andDriver_idIsNull() {
            addCriterion("driver_id is null");
            return (Criteria) this;
        }

        public Criteria andDriver_idIsNotNull() {
            addCriterion("driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriver_idEqualTo(String value) {
            addCriterion("driver_id =", value, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idNotEqualTo(String value) {
            addCriterion("driver_id <>", value, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idGreaterThan(String value) {
            addCriterion("driver_id >", value, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idGreaterThanOrEqualTo(String value) {
            addCriterion("driver_id >=", value, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idLessThan(String value) {
            addCriterion("driver_id <", value, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idLessThanOrEqualTo(String value) {
            addCriterion("driver_id <=", value, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idIn(List<String> values) {
            addCriterion("driver_id in", values, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idNotIn(List<String> values) {
            addCriterion("driver_id not in", values, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idBetween(String value1, String value2) {
            addCriterion("driver_id between", value1, value2, "driver_id");
            return (Criteria) this;
        }

        public Criteria andDriver_idNotBetween(String value1, String value2) {
            addCriterion("driver_id not between", value1, value2, "driver_id");
            return (Criteria) this;
        }

        public Criteria andCar_idIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCar_idIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCar_idEqualTo(String value) {
            addCriterion("car_id =", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idNotEqualTo(String value) {
            addCriterion("car_id <>", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idGreaterThan(String value) {
            addCriterion("car_id >", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idGreaterThanOrEqualTo(String value) {
            addCriterion("car_id >=", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idLessThan(String value) {
            addCriterion("car_id <", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idLessThanOrEqualTo(String value) {
            addCriterion("car_id <=", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idIn(List<String> values) {
            addCriterion("car_id in", values, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idNotIn(List<String> values) {
            addCriterion("car_id not in", values, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idBetween(String value1, String value2) {
            addCriterion("car_id between", value1, value2, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idNotBetween(String value1, String value2) {
            addCriterion("car_id not between", value1, value2, "car_id");
            return (Criteria) this;
        }

        public Criteria andDepart_timeIsNull() {
            addCriterion("depart_time is null");
            return (Criteria) this;
        }

        public Criteria andDepart_timeIsNotNull() {
            addCriterion("depart_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepart_timeEqualTo(Date value) {
            addCriterion("depart_time =", value, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeNotEqualTo(Date value) {
            addCriterion("depart_time <>", value, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeGreaterThan(Date value) {
            addCriterion("depart_time >", value, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("depart_time >=", value, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeLessThan(Date value) {
            addCriterion("depart_time <", value, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeLessThanOrEqualTo(Date value) {
            addCriterion("depart_time <=", value, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeIn(List<Date> values) {
            addCriterion("depart_time in", values, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeNotIn(List<Date> values) {
            addCriterion("depart_time not in", values, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeBetween(Date value1, Date value2) {
            addCriterion("depart_time between", value1, value2, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_timeNotBetween(Date value1, Date value2) {
            addCriterion("depart_time not between", value1, value2, "depart_time");
            return (Criteria) this;
        }

        public Criteria andDepart_hourIsNull() {
            addCriterion("depart_hour is null");
            return (Criteria) this;
        }

        public Criteria andDepart_hourIsNotNull() {
            addCriterion("depart_hour is not null");
            return (Criteria) this;
        }

        public Criteria andDepart_hourEqualTo(Date value) {
            addCriterion("depart_hour =", value, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourNotEqualTo(Date value) {
            addCriterion("depart_hour <>", value, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourGreaterThan(Date value) {
            addCriterion("depart_hour >", value, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourGreaterThanOrEqualTo(Date value) {
            addCriterion("depart_hour >=", value, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourLessThan(Date value) {
            addCriterion("depart_hour <", value, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourLessThanOrEqualTo(Date value) {
            addCriterion("depart_hour <=", value, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourIn(List<Date> values) {
            addCriterion("depart_hour in", values, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourNotIn(List<Date> values) {
            addCriterion("depart_hour not in", values, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourBetween(Date value1, Date value2) {
            addCriterion("depart_hour between", value1, value2, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andDepart_hourNotBetween(Date value1, Date value2) {
            addCriterion("depart_hour not between", value1, value2, "depart_hour");
            return (Criteria) this;
        }

        public Criteria andArrival_timeIsNull() {
            addCriterion("arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrival_timeIsNotNull() {
            addCriterion("arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrival_timeEqualTo(Date value) {
            addCriterion("arrival_time =", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotEqualTo(Date value) {
            addCriterion("arrival_time <>", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeGreaterThan(Date value) {
            addCriterion("arrival_time >", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("arrival_time >=", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeLessThan(Date value) {
            addCriterion("arrival_time <", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeLessThanOrEqualTo(Date value) {
            addCriterion("arrival_time <=", value, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeIn(List<Date> values) {
            addCriterion("arrival_time in", values, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotIn(List<Date> values) {
            addCriterion("arrival_time not in", values, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeBetween(Date value1, Date value2) {
            addCriterion("arrival_time between", value1, value2, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andArrival_timeNotBetween(Date value1, Date value2) {
            addCriterion("arrival_time not between", value1, value2, "arrival_time");
            return (Criteria) this;
        }

        public Criteria andDriving_stateIsNull() {
            addCriterion("driving_state is null");
            return (Criteria) this;
        }

        public Criteria andDriving_stateIsNotNull() {
            addCriterion("driving_state is not null");
            return (Criteria) this;
        }

        public Criteria andDriving_stateEqualTo(Integer value) {
            addCriterion("driving_state =", value, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateNotEqualTo(Integer value) {
            addCriterion("driving_state <>", value, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateGreaterThan(Integer value) {
            addCriterion("driving_state >", value, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateGreaterThanOrEqualTo(Integer value) {
            addCriterion("driving_state >=", value, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateLessThan(Integer value) {
            addCriterion("driving_state <", value, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateLessThanOrEqualTo(Integer value) {
            addCriterion("driving_state <=", value, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateIn(List<Integer> values) {
            addCriterion("driving_state in", values, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateNotIn(List<Integer> values) {
            addCriterion("driving_state not in", values, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateBetween(Integer value1, Integer value2) {
            addCriterion("driving_state between", value1, value2, "driving_state");
            return (Criteria) this;
        }

        public Criteria andDriving_stateNotBetween(Integer value1, Integer value2) {
            addCriterion("driving_state not between", value1, value2, "driving_state");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortIsNull() {
            addCriterion("line_station_sort is null");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortIsNotNull() {
            addCriterion("line_station_sort is not null");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortEqualTo(Integer value) {
            addCriterion("line_station_sort =", value, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortNotEqualTo(Integer value) {
            addCriterion("line_station_sort <>", value, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortGreaterThan(Integer value) {
            addCriterion("line_station_sort >", value, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_station_sort >=", value, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortLessThan(Integer value) {
            addCriterion("line_station_sort <", value, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortLessThanOrEqualTo(Integer value) {
            addCriterion("line_station_sort <=", value, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortIn(List<Integer> values) {
            addCriterion("line_station_sort in", values, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortNotIn(List<Integer> values) {
            addCriterion("line_station_sort not in", values, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortBetween(Integer value1, Integer value2) {
            addCriterion("line_station_sort between", value1, value2, "line_station_sort");
            return (Criteria) this;
        }

        public Criteria andLine_station_sortNotBetween(Integer value1, Integer value2) {
            addCriterion("line_station_sort not between", value1, value2, "line_station_sort");
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