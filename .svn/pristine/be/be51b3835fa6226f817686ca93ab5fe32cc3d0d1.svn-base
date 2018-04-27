package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineApplyRepository extends PageRespository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineApplyRepository() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
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

        public Criteria andStart_stationIsNull() {
            addCriterion("start_station is null");
            return (Criteria) this;
        }

        public Criteria andStart_stationIsNotNull() {
            addCriterion("start_station is not null");
            return (Criteria) this;
        }

        public Criteria andStart_stationEqualTo(Long value) {
            addCriterion("start_station =", value, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationNotEqualTo(Long value) {
            addCriterion("start_station <>", value, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationGreaterThan(Long value) {
            addCriterion("start_station >", value, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationGreaterThanOrEqualTo(Long value) {
            addCriterion("start_station >=", value, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationLessThan(Long value) {
            addCriterion("start_station <", value, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationLessThanOrEqualTo(Long value) {
            addCriterion("start_station <=", value, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationIn(List<Long> values) {
            addCriterion("start_station in", values, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationNotIn(List<Long> values) {
            addCriterion("start_station not in", values, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationBetween(Long value1, Long value2) {
            addCriterion("start_station between", value1, value2, "start_station");
            return (Criteria) this;
        }

        public Criteria andStart_stationNotBetween(Long value1, Long value2) {
            addCriterion("start_station not between", value1, value2, "start_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationIsNull() {
            addCriterion("end_station is null");
            return (Criteria) this;
        }

        public Criteria andEnd_stationIsNotNull() {
            addCriterion("end_station is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_stationEqualTo(Long value) {
            addCriterion("end_station =", value, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationNotEqualTo(Long value) {
            addCriterion("end_station <>", value, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationGreaterThan(Long value) {
            addCriterion("end_station >", value, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationGreaterThanOrEqualTo(Long value) {
            addCriterion("end_station >=", value, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationLessThan(Long value) {
            addCriterion("end_station <", value, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationLessThanOrEqualTo(Long value) {
            addCriterion("end_station <=", value, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationIn(List<Long> values) {
            addCriterion("end_station in", values, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationNotIn(List<Long> values) {
            addCriterion("end_station not in", values, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationBetween(Long value1, Long value2) {
            addCriterion("end_station between", value1, value2, "end_station");
            return (Criteria) this;
        }

        public Criteria andEnd_stationNotBetween(Long value1, Long value2) {
            addCriterion("end_station not between", value1, value2, "end_station");
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

        public Criteria andDepart_rateIsNull() {
            addCriterion("depart_rate is null");
            return (Criteria) this;
        }

        public Criteria andDepart_rateIsNotNull() {
            addCriterion("depart_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDepart_rateEqualTo(Integer value) {
            addCriterion("depart_rate =", value, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateNotEqualTo(Integer value) {
            addCriterion("depart_rate <>", value, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateGreaterThan(Integer value) {
            addCriterion("depart_rate >", value, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateGreaterThanOrEqualTo(Integer value) {
            addCriterion("depart_rate >=", value, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateLessThan(Integer value) {
            addCriterion("depart_rate <", value, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateLessThanOrEqualTo(Integer value) {
            addCriterion("depart_rate <=", value, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateIn(List<Integer> values) {
            addCriterion("depart_rate in", values, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateNotIn(List<Integer> values) {
            addCriterion("depart_rate not in", values, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateBetween(Integer value1, Integer value2) {
            addCriterion("depart_rate between", value1, value2, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andDepart_rateNotBetween(Integer value1, Integer value2) {
            addCriterion("depart_rate not between", value1, value2, "depart_rate");
            return (Criteria) this;
        }

        public Criteria andCommite_timeIsNull() {
            addCriterion("commite_time is null");
            return (Criteria) this;
        }

        public Criteria andCommite_timeIsNotNull() {
            addCriterion("commite_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommite_timeEqualTo(Date value) {
            addCriterion("commite_time =", value, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeNotEqualTo(Date value) {
            addCriterion("commite_time <>", value, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeGreaterThan(Date value) {
            addCriterion("commite_time >", value, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("commite_time >=", value, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeLessThan(Date value) {
            addCriterion("commite_time <", value, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeLessThanOrEqualTo(Date value) {
            addCriterion("commite_time <=", value, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeIn(List<Date> values) {
            addCriterion("commite_time in", values, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeNotIn(List<Date> values) {
            addCriterion("commite_time not in", values, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeBetween(Date value1, Date value2) {
            addCriterion("commite_time between", value1, value2, "commite_time");
            return (Criteria) this;
        }

        public Criteria andCommite_timeNotBetween(Date value1, Date value2) {
            addCriterion("commite_time not between", value1, value2, "commite_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
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