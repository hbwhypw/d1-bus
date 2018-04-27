package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class CardRecordRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardRecordRepository() {
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

        public Criteria andCard_idIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCard_idIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCard_idEqualTo(String value) {
            addCriterion("card_id =", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotEqualTo(String value) {
            addCriterion("card_id <>", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idGreaterThan(String value) {
            addCriterion("card_id >", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idLessThan(String value) {
            addCriterion("card_id <", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idIn(List<String> values) {
            addCriterion("card_id in", values, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotIn(List<String> values) {
            addCriterion("card_id not in", values, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "card_id");
            return (Criteria) this;
        }

        public Criteria andIs_useIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIs_useIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIs_useEqualTo(Integer value) {
            addCriterion("is_use =", value, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useNotEqualTo(Integer value) {
            addCriterion("is_use <>", value, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useGreaterThan(Integer value) {
            addCriterion("is_use >", value, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_use >=", value, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useLessThan(Integer value) {
            addCriterion("is_use <", value, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useLessThanOrEqualTo(Integer value) {
            addCriterion("is_use <=", value, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useIn(List<Integer> values) {
            addCriterion("is_use in", values, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useNotIn(List<Integer> values) {
            addCriterion("is_use not in", values, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useBetween(Integer value1, Integer value2) {
            addCriterion("is_use between", value1, value2, "is_use");
            return (Criteria) this;
        }

        public Criteria andIs_useNotBetween(Integer value1, Integer value2) {
            addCriterion("is_use not between", value1, value2, "is_use");
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