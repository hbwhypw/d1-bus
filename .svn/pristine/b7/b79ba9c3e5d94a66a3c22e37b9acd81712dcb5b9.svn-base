package com.tmtc.po;

import com.tmtc.po.page.PageRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyRepository extends PageRespository {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyRepository() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andChairman_nameIsNull() {
            addCriterion("chairman_name is null");
            return (Criteria) this;
        }

        public Criteria andChairman_nameIsNotNull() {
            addCriterion("chairman_name is not null");
            return (Criteria) this;
        }

        public Criteria andChairman_nameEqualTo(String value) {
            addCriterion("chairman_name =", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameNotEqualTo(String value) {
            addCriterion("chairman_name <>", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameGreaterThan(String value) {
            addCriterion("chairman_name >", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameGreaterThanOrEqualTo(String value) {
            addCriterion("chairman_name >=", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameLessThan(String value) {
            addCriterion("chairman_name <", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameLessThanOrEqualTo(String value) {
            addCriterion("chairman_name <=", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameLike(String value) {
            addCriterion("chairman_name like", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameNotLike(String value) {
            addCriterion("chairman_name not like", value, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameIn(List<String> values) {
            addCriterion("chairman_name in", values, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameNotIn(List<String> values) {
            addCriterion("chairman_name not in", values, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameBetween(String value1, String value2) {
            addCriterion("chairman_name between", value1, value2, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_nameNotBetween(String value1, String value2) {
            addCriterion("chairman_name not between", value1, value2, "chairman_name");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneIsNull() {
            addCriterion("chairman_phone is null");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneIsNotNull() {
            addCriterion("chairman_phone is not null");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneEqualTo(String value) {
            addCriterion("chairman_phone =", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneNotEqualTo(String value) {
            addCriterion("chairman_phone <>", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneGreaterThan(String value) {
            addCriterion("chairman_phone >", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("chairman_phone >=", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneLessThan(String value) {
            addCriterion("chairman_phone <", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneLessThanOrEqualTo(String value) {
            addCriterion("chairman_phone <=", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneLike(String value) {
            addCriterion("chairman_phone like", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneNotLike(String value) {
            addCriterion("chairman_phone not like", value, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneIn(List<String> values) {
            addCriterion("chairman_phone in", values, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneNotIn(List<String> values) {
            addCriterion("chairman_phone not in", values, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneBetween(String value1, String value2) {
            addCriterion("chairman_phone between", value1, value2, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andChairman_phoneNotBetween(String value1, String value2) {
            addCriterion("chairman_phone not between", value1, value2, "chairman_phone");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanIsNull() {
            addCriterion("company_chairman is null");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanIsNotNull() {
            addCriterion("company_chairman is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanEqualTo(String value) {
            addCriterion("company_chairman =", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanNotEqualTo(String value) {
            addCriterion("company_chairman <>", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanGreaterThan(String value) {
            addCriterion("company_chairman >", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanGreaterThanOrEqualTo(String value) {
            addCriterion("company_chairman >=", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanLessThan(String value) {
            addCriterion("company_chairman <", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanLessThanOrEqualTo(String value) {
            addCriterion("company_chairman <=", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanLike(String value) {
            addCriterion("company_chairman like", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanNotLike(String value) {
            addCriterion("company_chairman not like", value, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanIn(List<String> values) {
            addCriterion("company_chairman in", values, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanNotIn(List<String> values) {
            addCriterion("company_chairman not in", values, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanBetween(String value1, String value2) {
            addCriterion("company_chairman between", value1, value2, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_chairmanNotBetween(String value1, String value2) {
            addCriterion("company_chairman not between", value1, value2, "company_chairman");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneIsNull() {
            addCriterion("company_telphone is null");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneIsNotNull() {
            addCriterion("company_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneEqualTo(String value) {
            addCriterion("company_telphone =", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneNotEqualTo(String value) {
            addCriterion("company_telphone <>", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneGreaterThan(String value) {
            addCriterion("company_telphone >", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneGreaterThanOrEqualTo(String value) {
            addCriterion("company_telphone >=", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneLessThan(String value) {
            addCriterion("company_telphone <", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneLessThanOrEqualTo(String value) {
            addCriterion("company_telphone <=", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneLike(String value) {
            addCriterion("company_telphone like", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneNotLike(String value) {
            addCriterion("company_telphone not like", value, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneIn(List<String> values) {
            addCriterion("company_telphone in", values, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneNotIn(List<String> values) {
            addCriterion("company_telphone not in", values, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneBetween(String value1, String value2) {
            addCriterion("company_telphone between", value1, value2, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andCompany_telphoneNotBetween(String value1, String value2) {
            addCriterion("company_telphone not between", value1, value2, "company_telphone");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
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

        public Criteria andBusiness_faxIsNull() {
            addCriterion("business_fax is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxIsNotNull() {
            addCriterion("business_fax is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxEqualTo(String value) {
            addCriterion("business_fax =", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxNotEqualTo(String value) {
            addCriterion("business_fax <>", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxGreaterThan(String value) {
            addCriterion("business_fax >", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxGreaterThanOrEqualTo(String value) {
            addCriterion("business_fax >=", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxLessThan(String value) {
            addCriterion("business_fax <", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxLessThanOrEqualTo(String value) {
            addCriterion("business_fax <=", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxLike(String value) {
            addCriterion("business_fax like", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxNotLike(String value) {
            addCriterion("business_fax not like", value, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxIn(List<String> values) {
            addCriterion("business_fax in", values, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxNotIn(List<String> values) {
            addCriterion("business_fax not in", values, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxBetween(String value1, String value2) {
            addCriterion("business_fax between", value1, value2, "business_fax");
            return (Criteria) this;
        }

        public Criteria andBusiness_faxNotBetween(String value1, String value2) {
            addCriterion("business_fax not between", value1, value2, "business_fax");
            return (Criteria) this;
        }

        public Criteria andCompany_typeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompany_typeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_typeEqualTo(Integer value) {
            addCriterion("company_type =", value, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeNotEqualTo(Integer value) {
            addCriterion("company_type <>", value, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeGreaterThan(Integer value) {
            addCriterion("company_type >", value, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_type >=", value, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeLessThan(Integer value) {
            addCriterion("company_type <", value, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeLessThanOrEqualTo(Integer value) {
            addCriterion("company_type <=", value, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeIn(List<Integer> values) {
            addCriterion("company_type in", values, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeNotIn(List<Integer> values) {
            addCriterion("company_type not in", values, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeBetween(Integer value1, Integer value2) {
            addCriterion("company_type between", value1, value2, "company_type");
            return (Criteria) this;
        }

        public Criteria andCompany_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("company_type not between", value1, value2, "company_type");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_timeEqualTo(Date value) {
            addCriterion("start_time =", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThan(Date value) {
            addCriterion("start_time >", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThan(Date value) {
            addCriterion("start_time <", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIn(List<Date> values) {
            addCriterion("start_time in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andLogo_picIsNull() {
            addCriterion("logo_pic is null");
            return (Criteria) this;
        }

        public Criteria andLogo_picIsNotNull() {
            addCriterion("logo_pic is not null");
            return (Criteria) this;
        }

        public Criteria andLogo_picEqualTo(String value) {
            addCriterion("logo_pic =", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picNotEqualTo(String value) {
            addCriterion("logo_pic <>", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picGreaterThan(String value) {
            addCriterion("logo_pic >", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picGreaterThanOrEqualTo(String value) {
            addCriterion("logo_pic >=", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picLessThan(String value) {
            addCriterion("logo_pic <", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picLessThanOrEqualTo(String value) {
            addCriterion("logo_pic <=", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picLike(String value) {
            addCriterion("logo_pic like", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picNotLike(String value) {
            addCriterion("logo_pic not like", value, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picIn(List<String> values) {
            addCriterion("logo_pic in", values, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picNotIn(List<String> values) {
            addCriterion("logo_pic not in", values, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picBetween(String value1, String value2) {
            addCriterion("logo_pic between", value1, value2, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andLogo_picNotBetween(String value1, String value2) {
            addCriterion("logo_pic not between", value1, value2, "logo_pic");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseEqualTo(String value) {
            addCriterion("business_license =", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseGreaterThan(String value) {
            addCriterion("business_license >", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseLessThan(String value) {
            addCriterion("business_license <", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseLike(String value) {
            addCriterion("business_license like", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseNotLike(String value) {
            addCriterion("business_license not like", value, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseIn(List<String> values) {
            addCriterion("business_license in", values, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "business_license");
            return (Criteria) this;
        }

        public Criteria andBusiness_licenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "business_license");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andCreat_timeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreat_timeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreat_timeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeLessThan(Date value) {
            addCriterion("creat_time <", value, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creat_time");
            return (Criteria) this;
        }

        public Criteria andCreat_timeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creat_time");
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