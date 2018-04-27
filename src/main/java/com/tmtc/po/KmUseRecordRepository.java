package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KmUseRecordRepository extends PageRespository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KmUseRecordRepository() {
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

        public Criteria andUse_kmIsNull() {
            addCriterion("use_km is null");
            return (Criteria) this;
        }

        public Criteria andUse_kmIsNotNull() {
            addCriterion("use_km is not null");
            return (Criteria) this;
        }

        public Criteria andUse_kmEqualTo(Integer value) {
            addCriterion("use_km =", value, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmNotEqualTo(Integer value) {
            addCriterion("use_km <>", value, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmGreaterThan(Integer value) {
            addCriterion("use_km >", value, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_km >=", value, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmLessThan(Integer value) {
            addCriterion("use_km <", value, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmLessThanOrEqualTo(Integer value) {
            addCriterion("use_km <=", value, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmIn(List<Integer> values) {
            addCriterion("use_km in", values, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmNotIn(List<Integer> values) {
            addCriterion("use_km not in", values, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmBetween(Integer value1, Integer value2) {
            addCriterion("use_km between", value1, value2, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_kmNotBetween(Integer value1, Integer value2) {
            addCriterion("use_km not between", value1, value2, "use_km");
            return (Criteria) this;
        }

        public Criteria andUse_typeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUse_typeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUse_typeEqualTo(Integer value) {
            addCriterion("use_type =", value, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeNotEqualTo(Integer value) {
            addCriterion("use_type <>", value, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeGreaterThan(Integer value) {
            addCriterion("use_type >", value, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_type >=", value, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeLessThan(Integer value) {
            addCriterion("use_type <", value, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeLessThanOrEqualTo(Integer value) {
            addCriterion("use_type <=", value, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeIn(List<Integer> values) {
            addCriterion("use_type in", values, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeNotIn(List<Integer> values) {
            addCriterion("use_type not in", values, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeBetween(Integer value1, Integer value2) {
            addCriterion("use_type between", value1, value2, "use_type");
            return (Criteria) this;
        }

        public Criteria andUse_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("use_type not between", value1, value2, "use_type");
            return (Criteria) this;
        }

        public Criteria andOpt_timeIsNull() {
            addCriterion("opt_time is null");
            return (Criteria) this;
        }

        public Criteria andOpt_timeIsNotNull() {
            addCriterion("opt_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpt_timeEqualTo(Date value) {
            addCriterion("opt_time =", value, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeNotEqualTo(Date value) {
            addCriterion("opt_time <>", value, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeGreaterThan(Date value) {
            addCriterion("opt_time >", value, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("opt_time >=", value, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeLessThan(Date value) {
            addCriterion("opt_time <", value, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeLessThanOrEqualTo(Date value) {
            addCriterion("opt_time <=", value, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeIn(List<Date> values) {
            addCriterion("opt_time in", values, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeNotIn(List<Date> values) {
            addCriterion("opt_time not in", values, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeBetween(Date value1, Date value2) {
            addCriterion("opt_time between", value1, value2, "opt_time");
            return (Criteria) this;
        }

        public Criteria andOpt_timeNotBetween(Date value1, Date value2) {
            addCriterion("opt_time not between", value1, value2, "opt_time");
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