package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopInvoiceRepository extends PageRespository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopInvoiceRepository() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeEqualTo(Integer value) {
            addCriterion("invoice_type =", value, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeNotEqualTo(Integer value) {
            addCriterion("invoice_type <>", value, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeGreaterThan(Integer value) {
            addCriterion("invoice_type >", value, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_type >=", value, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeLessThan(Integer value) {
            addCriterion("invoice_type <", value, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_type <=", value, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeIn(List<Integer> values) {
            addCriterion("invoice_type in", values, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeNotIn(List<Integer> values) {
            addCriterion("invoice_type not in", values, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type between", value1, value2, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type not between", value1, value2, "invoice_type");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleLike(String value) {
            addCriterion("invoice_title like", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_titleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoice_title");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsIsNull() {
            addCriterion("invoice_details is null");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsIsNotNull() {
            addCriterion("invoice_details is not null");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsEqualTo(String value) {
            addCriterion("invoice_details =", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsNotEqualTo(String value) {
            addCriterion("invoice_details <>", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsGreaterThan(String value) {
            addCriterion("invoice_details >", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_details >=", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsLessThan(String value) {
            addCriterion("invoice_details <", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsLessThanOrEqualTo(String value) {
            addCriterion("invoice_details <=", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsLike(String value) {
            addCriterion("invoice_details like", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsNotLike(String value) {
            addCriterion("invoice_details not like", value, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsIn(List<String> values) {
            addCriterion("invoice_details in", values, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsNotIn(List<String> values) {
            addCriterion("invoice_details not in", values, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsBetween(String value1, String value2) {
            addCriterion("invoice_details between", value1, value2, "invoice_details");
            return (Criteria) this;
        }

        public Criteria andInvoice_detailsNotBetween(String value1, String value2) {
            addCriterion("invoice_details not between", value1, value2, "invoice_details");
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