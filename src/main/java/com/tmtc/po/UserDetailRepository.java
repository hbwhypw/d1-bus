package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDetailRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDetailRepository() {
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

        public Criteria andLink_numIsNull() {
            addCriterion("link_num is null");
            return (Criteria) this;
        }

        public Criteria andLink_numIsNotNull() {
            addCriterion("link_num is not null");
            return (Criteria) this;
        }

        public Criteria andLink_numEqualTo(String value) {
            addCriterion("link_num =", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numNotEqualTo(String value) {
            addCriterion("link_num <>", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numGreaterThan(String value) {
            addCriterion("link_num >", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numGreaterThanOrEqualTo(String value) {
            addCriterion("link_num >=", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numLessThan(String value) {
            addCriterion("link_num <", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numLessThanOrEqualTo(String value) {
            addCriterion("link_num <=", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numLike(String value) {
            addCriterion("link_num like", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numNotLike(String value) {
            addCriterion("link_num not like", value, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numIn(List<String> values) {
            addCriterion("link_num in", values, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numNotIn(List<String> values) {
            addCriterion("link_num not in", values, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numBetween(String value1, String value2) {
            addCriterion("link_num between", value1, value2, "link_num");
            return (Criteria) this;
        }

        public Criteria andLink_numNotBetween(String value1, String value2) {
            addCriterion("link_num not between", value1, value2, "link_num");
            return (Criteria) this;
        }

        public Criteria andRegister_timeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegister_timeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegister_timeEqualTo(Date value) {
            addCriterion("register_time =", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeGreaterThan(Date value) {
            addCriterion("register_time >", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeLessThan(Date value) {
            addCriterion("register_time <", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeIn(List<Date> values) {
            addCriterion("register_time in", values, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_timeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "register_time");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceIsNull() {
            addCriterion("register_source is null");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceIsNotNull() {
            addCriterion("register_source is not null");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceEqualTo(Integer value) {
            addCriterion("register_source =", value, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceNotEqualTo(Integer value) {
            addCriterion("register_source <>", value, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceGreaterThan(Integer value) {
            addCriterion("register_source >", value, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_source >=", value, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceLessThan(Integer value) {
            addCriterion("register_source <", value, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceLessThanOrEqualTo(Integer value) {
            addCriterion("register_source <=", value, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceIn(List<Integer> values) {
            addCriterion("register_source in", values, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceNotIn(List<Integer> values) {
            addCriterion("register_source not in", values, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceBetween(Integer value1, Integer value2) {
            addCriterion("register_source between", value1, value2, "register_source");
            return (Criteria) this;
        }

        public Criteria andRegister_sourceNotBetween(Integer value1, Integer value2) {
            addCriterion("register_source not between", value1, value2, "register_source");
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

        public Criteria andNick_nameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNick_nameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNick_nameEqualTo(String value) {
            addCriterion("nick_name =", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLessThan(String value) {
            addCriterion("nick_name <", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLike(String value) {
            addCriterion("nick_name like", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotLike(String value) {
            addCriterion("nick_name not like", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameIn(List<String> values) {
            addCriterion("nick_name in", values, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nick_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andReal_nameEqualTo(String value) {
            addCriterion("real_name =", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThan(String value) {
            addCriterion("real_name >", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThan(String value) {
            addCriterion("real_name <", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLike(String value) {
            addCriterion("real_name like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotLike(String value) {
            addCriterion("real_name not like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameIn(List<String> values) {
            addCriterion("real_name in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andQr_codeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQr_codeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQr_codeEqualTo(String value) {
            addCriterion("qr_code =", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeLessThan(String value) {
            addCriterion("qr_code <", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeLike(String value) {
            addCriterion("qr_code like", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeNotLike(String value) {
            addCriterion("qr_code not like", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeIn(List<String> values) {
            addCriterion("qr_code in", values, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_codeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretIsNull() {
            addCriterion("qr_code_secret is null");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretIsNotNull() {
            addCriterion("qr_code_secret is not null");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretEqualTo(String value) {
            addCriterion("qr_code_secret =", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretNotEqualTo(String value) {
            addCriterion("qr_code_secret <>", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretGreaterThan(String value) {
            addCriterion("qr_code_secret >", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code_secret >=", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretLessThan(String value) {
            addCriterion("qr_code_secret <", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretLessThanOrEqualTo(String value) {
            addCriterion("qr_code_secret <=", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretLike(String value) {
            addCriterion("qr_code_secret like", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretNotLike(String value) {
            addCriterion("qr_code_secret not like", value, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretIn(List<String> values) {
            addCriterion("qr_code_secret in", values, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretNotIn(List<String> values) {
            addCriterion("qr_code_secret not in", values, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretBetween(String value1, String value2) {
            addCriterion("qr_code_secret between", value1, value2, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andQr_code_secretNotBetween(String value1, String value2) {
            addCriterion("qr_code_secret not between", value1, value2, "qr_code_secret");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andId_codeIsNull() {
            addCriterion("id_code is null");
            return (Criteria) this;
        }

        public Criteria andId_codeIsNotNull() {
            addCriterion("id_code is not null");
            return (Criteria) this;
        }

        public Criteria andId_codeEqualTo(String value) {
            addCriterion("id_code =", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeNotEqualTo(String value) {
            addCriterion("id_code <>", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeGreaterThan(String value) {
            addCriterion("id_code >", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeGreaterThanOrEqualTo(String value) {
            addCriterion("id_code >=", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeLessThan(String value) {
            addCriterion("id_code <", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeLessThanOrEqualTo(String value) {
            addCriterion("id_code <=", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeLike(String value) {
            addCriterion("id_code like", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeNotLike(String value) {
            addCriterion("id_code not like", value, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeIn(List<String> values) {
            addCriterion("id_code in", values, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeNotIn(List<String> values) {
            addCriterion("id_code not in", values, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeBetween(String value1, String value2) {
            addCriterion("id_code between", value1, value2, "id_code");
            return (Criteria) this;
        }

        public Criteria andId_codeNotBetween(String value1, String value2) {
            addCriterion("id_code not between", value1, value2, "id_code");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
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

        public Criteria andPortraitIsNull() {
            addCriterion("portrait is null");
            return (Criteria) this;
        }

        public Criteria andPortraitIsNotNull() {
            addCriterion("portrait is not null");
            return (Criteria) this;
        }

        public Criteria andPortraitEqualTo(String value) {
            addCriterion("portrait =", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotEqualTo(String value) {
            addCriterion("portrait <>", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitGreaterThan(String value) {
            addCriterion("portrait >", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("portrait >=", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitLessThan(String value) {
            addCriterion("portrait <", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitLessThanOrEqualTo(String value) {
            addCriterion("portrait <=", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitLike(String value) {
            addCriterion("portrait like", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotLike(String value) {
            addCriterion("portrait not like", value, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitIn(List<String> values) {
            addCriterion("portrait in", values, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotIn(List<String> values) {
            addCriterion("portrait not in", values, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitBetween(String value1, String value2) {
            addCriterion("portrait between", value1, value2, "portrait");
            return (Criteria) this;
        }

        public Criteria andPortraitNotBetween(String value1, String value2) {
            addCriterion("portrait not between", value1, value2, "portrait");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNull() {
            addCriterion("background is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNotNull() {
            addCriterion("background is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEqualTo(String value) {
            addCriterion("background =", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotEqualTo(String value) {
            addCriterion("background <>", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThan(String value) {
            addCriterion("background >", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("background >=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThan(String value) {
            addCriterion("background <", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThanOrEqualTo(String value) {
            addCriterion("background <=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLike(String value) {
            addCriterion("background like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotLike(String value) {
            addCriterion("background not like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundIn(List<String> values) {
            addCriterion("background in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotIn(List<String> values) {
            addCriterion("background not in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundBetween(String value1, String value2) {
            addCriterion("background between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotBetween(String value1, String value2) {
            addCriterion("background not between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Integer value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Integer value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Integer value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Integer value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Integer> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Integer> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Integer value1, Integer value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("balance not between", value1, value2, "balance");
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

        public Criteria andInvitation_codeIsNull() {
            addCriterion("invitation_code is null");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeIsNotNull() {
            addCriterion("invitation_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeEqualTo(String value) {
            addCriterion("invitation_code =", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeNotEqualTo(String value) {
            addCriterion("invitation_code <>", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeGreaterThan(String value) {
            addCriterion("invitation_code >", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_code >=", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeLessThan(String value) {
            addCriterion("invitation_code <", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeLessThanOrEqualTo(String value) {
            addCriterion("invitation_code <=", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeLike(String value) {
            addCriterion("invitation_code like", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeNotLike(String value) {
            addCriterion("invitation_code not like", value, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeIn(List<String> values) {
            addCriterion("invitation_code in", values, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeNotIn(List<String> values) {
            addCriterion("invitation_code not in", values, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeBetween(String value1, String value2) {
            addCriterion("invitation_code between", value1, value2, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andInvitation_codeNotBetween(String value1, String value2) {
            addCriterion("invitation_code not between", value1, value2, "invitation_code");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeIsNull() {
            addCriterion("last_order_time is null");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeIsNotNull() {
            addCriterion("last_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeEqualTo(Date value) {
            addCriterion("last_order_time =", value, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeNotEqualTo(Date value) {
            addCriterion("last_order_time <>", value, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeGreaterThan(Date value) {
            addCriterion("last_order_time >", value, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_order_time >=", value, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeLessThan(Date value) {
            addCriterion("last_order_time <", value, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeLessThanOrEqualTo(Date value) {
            addCriterion("last_order_time <=", value, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeIn(List<Date> values) {
            addCriterion("last_order_time in", values, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeNotIn(List<Date> values) {
            addCriterion("last_order_time not in", values, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeBetween(Date value1, Date value2) {
            addCriterion("last_order_time between", value1, value2, "last_order_time");
            return (Criteria) this;
        }

        public Criteria andLast_order_timeNotBetween(Date value1, Date value2) {
            addCriterion("last_order_time not between", value1, value2, "last_order_time");
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