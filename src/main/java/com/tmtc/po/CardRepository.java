package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardRepository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardRepository() {
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

        public Criteria andCard_nameIsNull() {
            addCriterion("card_name is null");
            return (Criteria) this;
        }

        public Criteria andCard_nameIsNotNull() {
            addCriterion("card_name is not null");
            return (Criteria) this;
        }

        public Criteria andCard_nameEqualTo(String value) {
            addCriterion("card_name =", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameNotEqualTo(String value) {
            addCriterion("card_name <>", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameGreaterThan(String value) {
            addCriterion("card_name >", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameGreaterThanOrEqualTo(String value) {
            addCriterion("card_name >=", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameLessThan(String value) {
            addCriterion("card_name <", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameLessThanOrEqualTo(String value) {
            addCriterion("card_name <=", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameLike(String value) {
            addCriterion("card_name like", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameNotLike(String value) {
            addCriterion("card_name not like", value, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameIn(List<String> values) {
            addCriterion("card_name in", values, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameNotIn(List<String> values) {
            addCriterion("card_name not in", values, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameBetween(String value1, String value2) {
            addCriterion("card_name between", value1, value2, "card_name");
            return (Criteria) this;
        }

        public Criteria andCard_nameNotBetween(String value1, String value2) {
            addCriterion("card_name not between", value1, value2, "card_name");
            return (Criteria) this;
        }

        public Criteria andExp_scoreIsNull() {
            addCriterion("exp_score is null");
            return (Criteria) this;
        }

        public Criteria andExp_scoreIsNotNull() {
            addCriterion("exp_score is not null");
            return (Criteria) this;
        }

        public Criteria andExp_scoreEqualTo(Integer value) {
            addCriterion("exp_score =", value, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreNotEqualTo(Integer value) {
            addCriterion("exp_score <>", value, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreGreaterThan(Integer value) {
            addCriterion("exp_score >", value, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("exp_score >=", value, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreLessThan(Integer value) {
            addCriterion("exp_score <", value, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreLessThanOrEqualTo(Integer value) {
            addCriterion("exp_score <=", value, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreIn(List<Integer> values) {
            addCriterion("exp_score in", values, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreNotIn(List<Integer> values) {
            addCriterion("exp_score not in", values, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreBetween(Integer value1, Integer value2) {
            addCriterion("exp_score between", value1, value2, "exp_score");
            return (Criteria) this;
        }

        public Criteria andExp_scoreNotBetween(Integer value1, Integer value2) {
            addCriterion("exp_score not between", value1, value2, "exp_score");
            return (Criteria) this;
        }

        public Criteria andCard_typeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCard_typeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCard_typeEqualTo(Integer value) {
            addCriterion("card_type =", value, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeNotEqualTo(Integer value) {
            addCriterion("card_type <>", value, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeGreaterThan(Integer value) {
            addCriterion("card_type >", value, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type >=", value, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeLessThan(Integer value) {
            addCriterion("card_type <", value, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeLessThanOrEqualTo(Integer value) {
            addCriterion("card_type <=", value, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeIn(List<Integer> values) {
            addCriterion("card_type in", values, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeNotIn(List<Integer> values) {
            addCriterion("card_type not in", values, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeBetween(Integer value1, Integer value2) {
            addCriterion("card_type between", value1, value2, "card_type");
            return (Criteria) this;
        }

        public Criteria andCard_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type not between", value1, value2, "card_type");
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

        public Criteria andEnd_effect_timeIsNull() {
            addCriterion("end_effect_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeIsNotNull() {
            addCriterion("end_effect_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeEqualTo(Date value) {
            addCriterion("end_effect_time =", value, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeNotEqualTo(Date value) {
            addCriterion("end_effect_time <>", value, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeGreaterThan(Date value) {
            addCriterion("end_effect_time >", value, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_effect_time >=", value, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeLessThan(Date value) {
            addCriterion("end_effect_time <", value, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_effect_time <=", value, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeIn(List<Date> values) {
            addCriterion("end_effect_time in", values, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeNotIn(List<Date> values) {
            addCriterion("end_effect_time not in", values, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeBetween(Date value1, Date value2) {
            addCriterion("end_effect_time between", value1, value2, "end_effect_time");
            return (Criteria) this;
        }

        public Criteria andEnd_effect_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_effect_time not between", value1, value2, "end_effect_time");
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