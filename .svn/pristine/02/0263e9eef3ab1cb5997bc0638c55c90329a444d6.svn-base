package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarLocationRepository extends PageRespository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarLocationRepository() {
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

        public Criteria andX_pointIsNull() {
            addCriterion("x_point is null");
            return (Criteria) this;
        }

        public Criteria andX_pointIsNotNull() {
            addCriterion("x_point is not null");
            return (Criteria) this;
        }

        public Criteria andX_pointEqualTo(Double value) {
            addCriterion("x_point =", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointNotEqualTo(Double value) {
            addCriterion("x_point <>", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointGreaterThan(Double value) {
            addCriterion("x_point >", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointGreaterThanOrEqualTo(Double value) {
            addCriterion("x_point >=", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointLessThan(Double value) {
            addCriterion("x_point <", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointLessThanOrEqualTo(Double value) {
            addCriterion("x_point <=", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointIn(List<Double> values) {
            addCriterion("x_point in", values, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointNotIn(List<Double> values) {
            addCriterion("x_point not in", values, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointBetween(Double value1, Double value2) {
            addCriterion("x_point between", value1, value2, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointNotBetween(Double value1, Double value2) {
            addCriterion("x_point not between", value1, value2, "x_point");
            return (Criteria) this;
        }

        public Criteria andY_pointIsNull() {
            addCriterion("y_point is null");
            return (Criteria) this;
        }

        public Criteria andY_pointIsNotNull() {
            addCriterion("y_point is not null");
            return (Criteria) this;
        }

        public Criteria andY_pointEqualTo(Double value) {
            addCriterion("y_point =", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointNotEqualTo(Double value) {
            addCriterion("y_point <>", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointGreaterThan(Double value) {
            addCriterion("y_point >", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointGreaterThanOrEqualTo(Double value) {
            addCriterion("y_point >=", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointLessThan(Double value) {
            addCriterion("y_point <", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointLessThanOrEqualTo(Double value) {
            addCriterion("y_point <=", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointIn(List<Double> values) {
            addCriterion("y_point in", values, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointNotIn(List<Double> values) {
            addCriterion("y_point not in", values, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointBetween(Double value1, Double value2) {
            addCriterion("y_point between", value1, value2, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointNotBetween(Double value1, Double value2) {
            addCriterion("y_point not between", value1, value2, "y_point");
            return (Criteria) this;
        }

        public Criteria andDevice_idIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDevice_idIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevice_idEqualTo(String value) {
            addCriterion("device_id =", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idNotEqualTo(String value) {
            addCriterion("device_id <>", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idGreaterThan(String value) {
            addCriterion("device_id >", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idLessThan(String value) {
            addCriterion("device_id <", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idLike(String value) {
            addCriterion("device_id like", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idNotLike(String value) {
            addCriterion("device_id not like", value, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idIn(List<String> values) {
            addCriterion("device_id in", values, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idNotIn(List<String> values) {
            addCriterion("device_id not in", values, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "device_id");
            return (Criteria) this;
        }

        public Criteria andDevice_idNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "device_id");
            return (Criteria) this;
        }

        public Criteria andUpload_timeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUpload_timeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpload_timeEqualTo(Date value) {
            addCriterion("upload_time =", value, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeLessThan(Date value) {
            addCriterion("upload_time <", value, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeIn(List<Date> values) {
            addCriterion("upload_time in", values, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "upload_time");
            return (Criteria) this;
        }

        public Criteria andUpload_timeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "upload_time");
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