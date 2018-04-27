package com.tmtc.po;

import java.util.ArrayList;
import java.util.List;

public class BtnRepository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BtnRepository() {
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

        public Criteria andBtn_idIsNull() {
            addCriterion("btn_id is null");
            return (Criteria) this;
        }

        public Criteria andBtn_idIsNotNull() {
            addCriterion("btn_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtn_idEqualTo(String value) {
            addCriterion("btn_id =", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idNotEqualTo(String value) {
            addCriterion("btn_id <>", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idGreaterThan(String value) {
            addCriterion("btn_id >", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idGreaterThanOrEqualTo(String value) {
            addCriterion("btn_id >=", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idLessThan(String value) {
            addCriterion("btn_id <", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idLessThanOrEqualTo(String value) {
            addCriterion("btn_id <=", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idLike(String value) {
            addCriterion("btn_id like", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idNotLike(String value) {
            addCriterion("btn_id not like", value, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idIn(List<String> values) {
            addCriterion("btn_id in", values, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idNotIn(List<String> values) {
            addCriterion("btn_id not in", values, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idBetween(String value1, String value2) {
            addCriterion("btn_id between", value1, value2, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_idNotBetween(String value1, String value2) {
            addCriterion("btn_id not between", value1, value2, "btn_id");
            return (Criteria) this;
        }

        public Criteria andBtn_nameIsNull() {
            addCriterion("btn_name is null");
            return (Criteria) this;
        }

        public Criteria andBtn_nameIsNotNull() {
            addCriterion("btn_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtn_nameEqualTo(String value) {
            addCriterion("btn_name =", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameNotEqualTo(String value) {
            addCriterion("btn_name <>", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameGreaterThan(String value) {
            addCriterion("btn_name >", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameGreaterThanOrEqualTo(String value) {
            addCriterion("btn_name >=", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameLessThan(String value) {
            addCriterion("btn_name <", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameLessThanOrEqualTo(String value) {
            addCriterion("btn_name <=", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameLike(String value) {
            addCriterion("btn_name like", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameNotLike(String value) {
            addCriterion("btn_name not like", value, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameIn(List<String> values) {
            addCriterion("btn_name in", values, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameNotIn(List<String> values) {
            addCriterion("btn_name not in", values, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameBetween(String value1, String value2) {
            addCriterion("btn_name between", value1, value2, "btn_name");
            return (Criteria) this;
        }

        public Criteria andBtn_nameNotBetween(String value1, String value2) {
            addCriterion("btn_name not between", value1, value2, "btn_name");
            return (Criteria) this;
        }

        public Criteria andGroup_idIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroup_idIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroup_idEqualTo(String value) {
            addCriterion("group_id =", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotEqualTo(String value) {
            addCriterion("group_id <>", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idGreaterThan(String value) {
            addCriterion("group_id >", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idLessThan(String value) {
            addCriterion("group_id <", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idLike(String value) {
            addCriterion("group_id like", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotLike(String value) {
            addCriterion("group_id not like", value, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idIn(List<String> values) {
            addCriterion("group_id in", values, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotIn(List<String> values) {
            addCriterion("group_id not in", values, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_idNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "group_id");
            return (Criteria) this;
        }

        public Criteria andGroup_nameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroup_nameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroup_nameEqualTo(String value) {
            addCriterion("group_name =", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameGreaterThan(String value) {
            addCriterion("group_name >", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameLessThan(String value) {
            addCriterion("group_name <", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameLike(String value) {
            addCriterion("group_name like", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameNotLike(String value) {
            addCriterion("group_name not like", value, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameIn(List<String> values) {
            addCriterion("group_name in", values, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "group_name");
            return (Criteria) this;
        }

        public Criteria andGroup_nameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "group_name");
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