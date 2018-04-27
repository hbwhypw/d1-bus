package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class TalkRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TalkRepository() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCompany_idIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompany_idIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_idEqualTo(String value) {
            addCriterion("company_id =", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotEqualTo(String value) {
            addCriterion("company_id <>", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idGreaterThan(String value) {
            addCriterion("company_id >", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idLessThan(String value) {
            addCriterion("company_id <", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idIn(List<String> values) {
            addCriterion("company_id in", values, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotIn(List<String> values) {
            addCriterion("company_id not in", values, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "company_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoom_idIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoom_idEqualTo(String value) {
            addCriterion("room_id =", value, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idNotEqualTo(String value) {
            addCriterion("room_id <>", value, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idGreaterThan(String value) {
            addCriterion("room_id >", value, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idLessThan(String value) {
            addCriterion("room_id <", value, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idIn(List<String> values) {
            addCriterion("room_id in", values, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idNotIn(List<String> values) {
            addCriterion("room_id not in", values, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_idNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "room_id");
            return (Criteria) this;
        }

        public Criteria andRoom_nameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoom_nameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoom_nameEqualTo(String value) {
            addCriterion("room_name =", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameGreaterThan(String value) {
            addCriterion("room_name >", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameLessThan(String value) {
            addCriterion("room_name <", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameLike(String value) {
            addCriterion("room_name like", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameNotLike(String value) {
            addCriterion("room_name not like", value, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameIn(List<String> values) {
            addCriterion("room_name in", values, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "room_name");
            return (Criteria) this;
        }

        public Criteria andRoom_nameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "room_name");
            return (Criteria) this;
        }

        public Criteria andRomm_desIsNull() {
            addCriterion("romm_des is null");
            return (Criteria) this;
        }

        public Criteria andRomm_desIsNotNull() {
            addCriterion("romm_des is not null");
            return (Criteria) this;
        }

        public Criteria andRomm_desEqualTo(String value) {
            addCriterion("romm_des =", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desNotEqualTo(String value) {
            addCriterion("romm_des <>", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desGreaterThan(String value) {
            addCriterion("romm_des >", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desGreaterThanOrEqualTo(String value) {
            addCriterion("romm_des >=", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desLessThan(String value) {
            addCriterion("romm_des <", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desLessThanOrEqualTo(String value) {
            addCriterion("romm_des <=", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desLike(String value) {
            addCriterion("romm_des like", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desNotLike(String value) {
            addCriterion("romm_des not like", value, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desIn(List<String> values) {
            addCriterion("romm_des in", values, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desNotIn(List<String> values) {
            addCriterion("romm_des not in", values, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desBetween(String value1, String value2) {
            addCriterion("romm_des between", value1, value2, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRomm_desNotBetween(String value1, String value2) {
            addCriterion("romm_des not between", value1, value2, "romm_des");
            return (Criteria) this;
        }

        public Criteria andRoom_numIsNull() {
            addCriterion("room_num is null");
            return (Criteria) this;
        }

        public Criteria andRoom_numIsNotNull() {
            addCriterion("room_num is not null");
            return (Criteria) this;
        }

        public Criteria andRoom_numEqualTo(Integer value) {
            addCriterion("room_num =", value, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numNotEqualTo(Integer value) {
            addCriterion("room_num <>", value, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numGreaterThan(Integer value) {
            addCriterion("room_num >", value, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_num >=", value, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numLessThan(Integer value) {
            addCriterion("room_num <", value, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numLessThanOrEqualTo(Integer value) {
            addCriterion("room_num <=", value, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numIn(List<Integer> values) {
            addCriterion("room_num in", values, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numNotIn(List<Integer> values) {
            addCriterion("room_num not in", values, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numBetween(Integer value1, Integer value2) {
            addCriterion("room_num between", value1, value2, "room_num");
            return (Criteria) this;
        }

        public Criteria andRoom_numNotBetween(Integer value1, Integer value2) {
            addCriterion("room_num not between", value1, value2, "room_num");
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