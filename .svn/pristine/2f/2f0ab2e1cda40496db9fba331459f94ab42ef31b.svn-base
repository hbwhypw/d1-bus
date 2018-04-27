package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepository extends PageRespository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRepository() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUser_typeEqualTo(Integer value) {
            addCriterion("user_type =", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThan(Integer value) {
            addCriterion("user_type <", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeIn(List<Integer> values) {
            addCriterion("user_type in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceIsNull() {
            addCriterion("login_source is null");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceIsNotNull() {
            addCriterion("login_source is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceEqualTo(Integer value) {
            addCriterion("login_source =", value, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceNotEqualTo(Integer value) {
            addCriterion("login_source <>", value, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceGreaterThan(Integer value) {
            addCriterion("login_source >", value, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_source >=", value, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceLessThan(Integer value) {
            addCriterion("login_source <", value, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceLessThanOrEqualTo(Integer value) {
            addCriterion("login_source <=", value, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceIn(List<Integer> values) {
            addCriterion("login_source in", values, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceNotIn(List<Integer> values) {
            addCriterion("login_source not in", values, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceBetween(Integer value1, Integer value2) {
            addCriterion("login_source between", value1, value2, "login_source");
            return (Criteria) this;
        }

        public Criteria andLogin_sourceNotBetween(Integer value1, Integer value2) {
            addCriterion("login_source not between", value1, value2, "login_source");
            return (Criteria) this;
        }

        public Criteria andLock_timeIsNull() {
            addCriterion("lock_time is null");
            return (Criteria) this;
        }

        public Criteria andLock_timeIsNotNull() {
            addCriterion("lock_time is not null");
            return (Criteria) this;
        }

        public Criteria andLock_timeEqualTo(Integer value) {
            addCriterion("lock_time =", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeNotEqualTo(Integer value) {
            addCriterion("lock_time <>", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeGreaterThan(Integer value) {
            addCriterion("lock_time >", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_time >=", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeLessThan(Integer value) {
            addCriterion("lock_time <", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeLessThanOrEqualTo(Integer value) {
            addCriterion("lock_time <=", value, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeIn(List<Integer> values) {
            addCriterion("lock_time in", values, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeNotIn(List<Integer> values) {
            addCriterion("lock_time not in", values, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeBetween(Integer value1, Integer value2) {
            addCriterion("lock_time between", value1, value2, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_time not between", value1, value2, "lock_time");
            return (Criteria) this;
        }

        public Criteria andLock_cntIsNull() {
            addCriterion("lock_cnt is null");
            return (Criteria) this;
        }

        public Criteria andLock_cntIsNotNull() {
            addCriterion("lock_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andLock_cntEqualTo(Integer value) {
            addCriterion("lock_cnt =", value, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntNotEqualTo(Integer value) {
            addCriterion("lock_cnt <>", value, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntGreaterThan(Integer value) {
            addCriterion("lock_cnt >", value, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_cnt >=", value, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntLessThan(Integer value) {
            addCriterion("lock_cnt <", value, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntLessThanOrEqualTo(Integer value) {
            addCriterion("lock_cnt <=", value, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntIn(List<Integer> values) {
            addCriterion("lock_cnt in", values, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntNotIn(List<Integer> values) {
            addCriterion("lock_cnt not in", values, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntBetween(Integer value1, Integer value2) {
            addCriterion("lock_cnt between", value1, value2, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLock_cntNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_cnt not between", value1, value2, "lock_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_timeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLogin_timeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_timeEqualTo(Date value) {
            addCriterion("login_time =", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeGreaterThan(Date value) {
            addCriterion("login_time >", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeLessThan(Date value) {
            addCriterion("login_time <", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeIn(List<Date> values) {
            addCriterion("login_time in", values, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_cntIsNull() {
            addCriterion("login_cnt is null");
            return (Criteria) this;
        }

        public Criteria andLogin_cntIsNotNull() {
            addCriterion("login_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_cntEqualTo(Integer value) {
            addCriterion("login_cnt =", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntNotEqualTo(Integer value) {
            addCriterion("login_cnt <>", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntGreaterThan(Integer value) {
            addCriterion("login_cnt >", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_cnt >=", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntLessThan(Integer value) {
            addCriterion("login_cnt <", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntLessThanOrEqualTo(Integer value) {
            addCriterion("login_cnt <=", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntIn(List<Integer> values) {
            addCriterion("login_cnt in", values, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntNotIn(List<Integer> values) {
            addCriterion("login_cnt not in", values, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntBetween(Integer value1, Integer value2) {
            addCriterion("login_cnt between", value1, value2, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntNotBetween(Integer value1, Integer value2) {
            addCriterion("login_cnt not between", value1, value2, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andIp_addressIsNull() {
            addCriterion("ip_address is null");
            return (Criteria) this;
        }

        public Criteria andIp_addressIsNotNull() {
            addCriterion("ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andIp_addressEqualTo(String value) {
            addCriterion("ip_address =", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressNotEqualTo(String value) {
            addCriterion("ip_address <>", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressGreaterThan(String value) {
            addCriterion("ip_address >", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressGreaterThanOrEqualTo(String value) {
            addCriterion("ip_address >=", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressLessThan(String value) {
            addCriterion("ip_address <", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressLessThanOrEqualTo(String value) {
            addCriterion("ip_address <=", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressLike(String value) {
            addCriterion("ip_address like", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressNotLike(String value) {
            addCriterion("ip_address not like", value, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressIn(List<String> values) {
            addCriterion("ip_address in", values, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressNotIn(List<String> values) {
            addCriterion("ip_address not in", values, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressBetween(String value1, String value2) {
            addCriterion("ip_address between", value1, value2, "ip_address");
            return (Criteria) this;
        }

        public Criteria andIp_addressNotBetween(String value1, String value2) {
            addCriterion("ip_address not between", value1, value2, "ip_address");
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