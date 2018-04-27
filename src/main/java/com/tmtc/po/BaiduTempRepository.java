package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaiduTempRepository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaiduTempRepository() {
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

        public Criteria andLine_time_idIsNull() {
            addCriterion("line_time_id is null");
            return (Criteria) this;
        }

        public Criteria andLine_time_idIsNotNull() {
            addCriterion("line_time_id is not null");
            return (Criteria) this;
        }

        public Criteria andLine_time_idEqualTo(String value) {
            addCriterion("line_time_id =", value, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idNotEqualTo(String value) {
            addCriterion("line_time_id <>", value, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idGreaterThan(String value) {
            addCriterion("line_time_id >", value, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idGreaterThanOrEqualTo(String value) {
            addCriterion("line_time_id >=", value, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idLessThan(String value) {
            addCriterion("line_time_id <", value, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idLessThanOrEqualTo(String value) {
            addCriterion("line_time_id <=", value, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idIn(List<String> values) {
            addCriterion("line_time_id in", values, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idNotIn(List<String> values) {
            addCriterion("line_time_id not in", values, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idBetween(String value1, String value2) {
            addCriterion("line_time_id between", value1, value2, "line_time_id");
            return (Criteria) this;
        }

        public Criteria andLine_time_idNotBetween(String value1, String value2) {
            addCriterion("line_time_id not between", value1, value2, "line_time_id");
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

        public Criteria andLine_station_idIsNull() {
            addCriterion("line_station_id is null");
            return (Criteria) this;
        }

        public Criteria andLine_station_idIsNotNull() {
            addCriterion("line_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andLine_station_idEqualTo(String value) {
            addCriterion("line_station_id =", value, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idNotEqualTo(String value) {
            addCriterion("line_station_id <>", value, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idGreaterThan(String value) {
            addCriterion("line_station_id >", value, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idGreaterThanOrEqualTo(String value) {
            addCriterion("line_station_id >=", value, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idLessThan(String value) {
            addCriterion("line_station_id <", value, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idLessThanOrEqualTo(String value) {
            addCriterion("line_station_id <=", value, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idIn(List<String> values) {
            addCriterion("line_station_id in", values, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idNotIn(List<String> values) {
            addCriterion("line_station_id not in", values, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idBetween(String value1, String value2) {
            addCriterion("line_station_id between", value1, value2, "line_station_id");
            return (Criteria) this;
        }

        public Criteria andLine_station_idNotBetween(String value1, String value2) {
            addCriterion("line_station_id not between", value1, value2, "line_station_id");
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

        public Criteria andCard_numIsNull() {
            addCriterion("card_num is null");
            return (Criteria) this;
        }

        public Criteria andCard_numIsNotNull() {
            addCriterion("card_num is not null");
            return (Criteria) this;
        }

        public Criteria andCard_numEqualTo(String value) {
            addCriterion("card_num =", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numNotEqualTo(String value) {
            addCriterion("card_num <>", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numGreaterThan(String value) {
            addCriterion("card_num >", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numGreaterThanOrEqualTo(String value) {
            addCriterion("card_num >=", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numLessThan(String value) {
            addCriterion("card_num <", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numLessThanOrEqualTo(String value) {
            addCriterion("card_num <=", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numLike(String value) {
            addCriterion("card_num like", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numNotLike(String value) {
            addCriterion("card_num not like", value, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numIn(List<String> values) {
            addCriterion("card_num in", values, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numNotIn(List<String> values) {
            addCriterion("card_num not in", values, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numBetween(String value1, String value2) {
            addCriterion("card_num between", value1, value2, "card_num");
            return (Criteria) this;
        }

        public Criteria andCard_numNotBetween(String value1, String value2) {
            addCriterion("card_num not between", value1, value2, "card_num");
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

        public Criteria andDriver_nameIsNull() {
            addCriterion("driver_name is null");
            return (Criteria) this;
        }

        public Criteria andDriver_nameIsNotNull() {
            addCriterion("driver_name is not null");
            return (Criteria) this;
        }

        public Criteria andDriver_nameEqualTo(String value) {
            addCriterion("driver_name =", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameNotEqualTo(String value) {
            addCriterion("driver_name <>", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameGreaterThan(String value) {
            addCriterion("driver_name >", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameGreaterThanOrEqualTo(String value) {
            addCriterion("driver_name >=", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameLessThan(String value) {
            addCriterion("driver_name <", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameLessThanOrEqualTo(String value) {
            addCriterion("driver_name <=", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameLike(String value) {
            addCriterion("driver_name like", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameNotLike(String value) {
            addCriterion("driver_name not like", value, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameIn(List<String> values) {
            addCriterion("driver_name in", values, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameNotIn(List<String> values) {
            addCriterion("driver_name not in", values, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameBetween(String value1, String value2) {
            addCriterion("driver_name between", value1, value2, "driver_name");
            return (Criteria) this;
        }

        public Criteria andDriver_nameNotBetween(String value1, String value2) {
            addCriterion("driver_name not between", value1, value2, "driver_name");
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

        public Criteria andLine_nameIsNull() {
            addCriterion("line_name is null");
            return (Criteria) this;
        }

        public Criteria andLine_nameIsNotNull() {
            addCriterion("line_name is not null");
            return (Criteria) this;
        }

        public Criteria andLine_nameEqualTo(String value) {
            addCriterion("line_name =", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotEqualTo(String value) {
            addCriterion("line_name <>", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameGreaterThan(String value) {
            addCriterion("line_name >", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameGreaterThanOrEqualTo(String value) {
            addCriterion("line_name >=", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameLessThan(String value) {
            addCriterion("line_name <", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameLessThanOrEqualTo(String value) {
            addCriterion("line_name <=", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameLike(String value) {
            addCriterion("line_name like", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotLike(String value) {
            addCriterion("line_name not like", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameIn(List<String> values) {
            addCriterion("line_name in", values, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotIn(List<String> values) {
            addCriterion("line_name not in", values, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameBetween(String value1, String value2) {
            addCriterion("line_name between", value1, value2, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotBetween(String value1, String value2) {
            addCriterion("line_name not between", value1, value2, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameIsNull() {
            addCriterion("line_station_name is null");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameIsNotNull() {
            addCriterion("line_station_name is not null");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameEqualTo(String value) {
            addCriterion("line_station_name =", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameNotEqualTo(String value) {
            addCriterion("line_station_name <>", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameGreaterThan(String value) {
            addCriterion("line_station_name >", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameGreaterThanOrEqualTo(String value) {
            addCriterion("line_station_name >=", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameLessThan(String value) {
            addCriterion("line_station_name <", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameLessThanOrEqualTo(String value) {
            addCriterion("line_station_name <=", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameLike(String value) {
            addCriterion("line_station_name like", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameNotLike(String value) {
            addCriterion("line_station_name not like", value, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameIn(List<String> values) {
            addCriterion("line_station_name in", values, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameNotIn(List<String> values) {
            addCriterion("line_station_name not in", values, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameBetween(String value1, String value2) {
            addCriterion("line_station_name between", value1, value2, "line_station_name");
            return (Criteria) this;
        }

        public Criteria andLine_station_nameNotBetween(String value1, String value2) {
            addCriterion("line_station_name not between", value1, value2, "line_station_name");
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

        public Criteria andYuliu1IsNull() {
            addCriterion("yuliu1 is null");
            return (Criteria) this;
        }

        public Criteria andYuliu1IsNotNull() {
            addCriterion("yuliu1 is not null");
            return (Criteria) this;
        }

        public Criteria andYuliu1EqualTo(String value) {
            addCriterion("yuliu1 =", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1NotEqualTo(String value) {
            addCriterion("yuliu1 <>", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1GreaterThan(String value) {
            addCriterion("yuliu1 >", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1GreaterThanOrEqualTo(String value) {
            addCriterion("yuliu1 >=", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1LessThan(String value) {
            addCriterion("yuliu1 <", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1LessThanOrEqualTo(String value) {
            addCriterion("yuliu1 <=", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1Like(String value) {
            addCriterion("yuliu1 like", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1NotLike(String value) {
            addCriterion("yuliu1 not like", value, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1In(List<String> values) {
            addCriterion("yuliu1 in", values, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1NotIn(List<String> values) {
            addCriterion("yuliu1 not in", values, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1Between(String value1, String value2) {
            addCriterion("yuliu1 between", value1, value2, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu1NotBetween(String value1, String value2) {
            addCriterion("yuliu1 not between", value1, value2, "yuliu1");
            return (Criteria) this;
        }

        public Criteria andYuliu2IsNull() {
            addCriterion("yuliu2 is null");
            return (Criteria) this;
        }

        public Criteria andYuliu2IsNotNull() {
            addCriterion("yuliu2 is not null");
            return (Criteria) this;
        }

        public Criteria andYuliu2EqualTo(String value) {
            addCriterion("yuliu2 =", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2NotEqualTo(String value) {
            addCriterion("yuliu2 <>", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2GreaterThan(String value) {
            addCriterion("yuliu2 >", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2GreaterThanOrEqualTo(String value) {
            addCriterion("yuliu2 >=", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2LessThan(String value) {
            addCriterion("yuliu2 <", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2LessThanOrEqualTo(String value) {
            addCriterion("yuliu2 <=", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2Like(String value) {
            addCriterion("yuliu2 like", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2NotLike(String value) {
            addCriterion("yuliu2 not like", value, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2In(List<String> values) {
            addCriterion("yuliu2 in", values, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2NotIn(List<String> values) {
            addCriterion("yuliu2 not in", values, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2Between(String value1, String value2) {
            addCriterion("yuliu2 between", value1, value2, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu2NotBetween(String value1, String value2) {
            addCriterion("yuliu2 not between", value1, value2, "yuliu2");
            return (Criteria) this;
        }

        public Criteria andYuliu3IsNull() {
            addCriterion("yuliu3 is null");
            return (Criteria) this;
        }

        public Criteria andYuliu3IsNotNull() {
            addCriterion("yuliu3 is not null");
            return (Criteria) this;
        }

        public Criteria andYuliu3EqualTo(String value) {
            addCriterion("yuliu3 =", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3NotEqualTo(String value) {
            addCriterion("yuliu3 <>", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3GreaterThan(String value) {
            addCriterion("yuliu3 >", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3GreaterThanOrEqualTo(String value) {
            addCriterion("yuliu3 >=", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3LessThan(String value) {
            addCriterion("yuliu3 <", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3LessThanOrEqualTo(String value) {
            addCriterion("yuliu3 <=", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3Like(String value) {
            addCriterion("yuliu3 like", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3NotLike(String value) {
            addCriterion("yuliu3 not like", value, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3In(List<String> values) {
            addCriterion("yuliu3 in", values, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3NotIn(List<String> values) {
            addCriterion("yuliu3 not in", values, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3Between(String value1, String value2) {
            addCriterion("yuliu3 between", value1, value2, "yuliu3");
            return (Criteria) this;
        }

        public Criteria andYuliu3NotBetween(String value1, String value2) {
            addCriterion("yuliu3 not between", value1, value2, "yuliu3");
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