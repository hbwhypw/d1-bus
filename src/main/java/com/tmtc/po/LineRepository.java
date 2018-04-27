package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class LineRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineRepository() {
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

        public Criteria andLine_nameIsNull() {
            addCriterion("line_name is null");
            return (Criteria) this;
        }

        public Criteria andLine_nameIsNotNull() {
            addCriterion("line_name is not null");
            return (Criteria) this;
        }

        public Criteria andLine_nameEqualTo(String value) {
            addCriterion("line_name =", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotEqualTo(String value) {
            addCriterion("line_name <>", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameGreaterThan(String value) {
            addCriterion("line_name >", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameGreaterThanOrEqualTo(String value) {
            addCriterion("line_name >=", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameLessThan(String value) {
            addCriterion("line_name <", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameLessThanOrEqualTo(String value) {
            addCriterion("line_name <=", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameLike(String value) {
            addCriterion("line_name like", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotLike(String value) {
            addCriterion("line_name not like", value, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameIn(List<String> values) {
            addCriterion("line_name in", values, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotIn(List<String> values) {
            addCriterion("line_name not in", values, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameBetween(String value1, String value2) {
            addCriterion("line_name between", value1, value2, "line_name");
            return (Criteria) this;
        }

        public Criteria andLine_nameNotBetween(String value1, String value2) {
            addCriterion("line_name not between", value1, value2, "line_name");
            return (Criteria) this;
        }

        public Criteria andStart_idIsNull() {
            addCriterion("start_id is null");
            return (Criteria) this;
        }

        public Criteria andStart_idIsNotNull() {
            addCriterion("start_id is not null");
            return (Criteria) this;
        }

        public Criteria andStart_idEqualTo(String value) {
            addCriterion("start_id =", value, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idNotEqualTo(String value) {
            addCriterion("start_id <>", value, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idGreaterThan(String value) {
            addCriterion("start_id >", value, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idGreaterThanOrEqualTo(String value) {
            addCriterion("start_id >=", value, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idLessThan(String value) {
            addCriterion("start_id <", value, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idLessThanOrEqualTo(String value) {
            addCriterion("start_id <=", value, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idIn(List<String> values) {
            addCriterion("start_id in", values, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idNotIn(List<String> values) {
            addCriterion("start_id not in", values, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idBetween(String value1, String value2) {
            addCriterion("start_id between", value1, value2, "start_id");
            return (Criteria) this;
        }

        public Criteria andStart_idNotBetween(String value1, String value2) {
            addCriterion("start_id not between", value1, value2, "start_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idIsNull() {
            addCriterion("end_id is null");
            return (Criteria) this;
        }

        public Criteria andEnd_idIsNotNull() {
            addCriterion("end_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_idEqualTo(String value) {
            addCriterion("end_id =", value, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idNotEqualTo(String value) {
            addCriterion("end_id <>", value, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idGreaterThan(String value) {
            addCriterion("end_id >", value, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idGreaterThanOrEqualTo(String value) {
            addCriterion("end_id >=", value, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idLessThan(String value) {
            addCriterion("end_id <", value, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idLessThanOrEqualTo(String value) {
            addCriterion("end_id <=", value, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idIn(List<String> values) {
            addCriterion("end_id in", values, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idNotIn(List<String> values) {
            addCriterion("end_id not in", values, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idBetween(String value1, String value2) {
            addCriterion("end_id between", value1, value2, "end_id");
            return (Criteria) this;
        }

        public Criteria andEnd_idNotBetween(String value1, String value2) {
            addCriterion("end_id not between", value1, value2, "end_id");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andKmIsNull() {
            addCriterion("km is null");
            return (Criteria) this;
        }

        public Criteria andKmIsNotNull() {
            addCriterion("km is not null");
            return (Criteria) this;
        }

        public Criteria andKmEqualTo(Double value) {
            addCriterion("km =", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotEqualTo(Double value) {
            addCriterion("km <>", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmGreaterThan(Double value) {
            addCriterion("km >", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmGreaterThanOrEqualTo(Double value) {
            addCriterion("km >=", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmLessThan(Double value) {
            addCriterion("km <", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmLessThanOrEqualTo(Double value) {
            addCriterion("km <=", value, "km");
            return (Criteria) this;
        }

        public Criteria andKmIn(List<Double> values) {
            addCriterion("km in", values, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotIn(List<Double> values) {
            addCriterion("km not in", values, "km");
            return (Criteria) this;
        }

        public Criteria andKmBetween(Double value1, Double value2) {
            addCriterion("km between", value1, value2, "km");
            return (Criteria) this;
        }

        public Criteria andKmNotBetween(Double value1, Double value2) {
            addCriterion("km not between", value1, value2, "km");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateIsNull() {
            addCriterion("on_time_rate is null");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateIsNotNull() {
            addCriterion("on_time_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateEqualTo(Double value) {
            addCriterion("on_time_rate =", value, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateNotEqualTo(Double value) {
            addCriterion("on_time_rate <>", value, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateGreaterThan(Double value) {
            addCriterion("on_time_rate >", value, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateGreaterThanOrEqualTo(Double value) {
            addCriterion("on_time_rate >=", value, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateLessThan(Double value) {
            addCriterion("on_time_rate <", value, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateLessThanOrEqualTo(Double value) {
            addCriterion("on_time_rate <=", value, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateIn(List<Double> values) {
            addCriterion("on_time_rate in", values, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateNotIn(List<Double> values) {
            addCriterion("on_time_rate not in", values, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateBetween(Double value1, Double value2) {
            addCriterion("on_time_rate between", value1, value2, "on_time_rate");
            return (Criteria) this;
        }

        public Criteria andOn_time_rateNotBetween(Double value1, Double value2) {
            addCriterion("on_time_rate not between", value1, value2, "on_time_rate");
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

        public Criteria andLine_categoryIsNull() {
            addCriterion("line_category is null");
            return (Criteria) this;
        }

        public Criteria andLine_categoryIsNotNull() {
            addCriterion("line_category is not null");
            return (Criteria) this;
        }

        public Criteria andLine_categoryEqualTo(Integer value) {
            addCriterion("line_category =", value, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryNotEqualTo(Integer value) {
            addCriterion("line_category <>", value, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryGreaterThan(Integer value) {
            addCriterion("line_category >", value, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_category >=", value, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryLessThan(Integer value) {
            addCriterion("line_category <", value, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryLessThanOrEqualTo(Integer value) {
            addCriterion("line_category <=", value, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryIn(List<Integer> values) {
            addCriterion("line_category in", values, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryNotIn(List<Integer> values) {
            addCriterion("line_category not in", values, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryBetween(Integer value1, Integer value2) {
            addCriterion("line_category between", value1, value2, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_categoryNotBetween(Integer value1, Integer value2) {
            addCriterion("line_category not between", value1, value2, "line_category");
            return (Criteria) this;
        }

        public Criteria andLine_typeIsNull() {
            addCriterion("line_type is null");
            return (Criteria) this;
        }

        public Criteria andLine_typeIsNotNull() {
            addCriterion("line_type is not null");
            return (Criteria) this;
        }

        public Criteria andLine_typeEqualTo(Integer value) {
            addCriterion("line_type =", value, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeNotEqualTo(Integer value) {
            addCriterion("line_type <>", value, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeGreaterThan(Integer value) {
            addCriterion("line_type >", value, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_type >=", value, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeLessThan(Integer value) {
            addCriterion("line_type <", value, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeLessThanOrEqualTo(Integer value) {
            addCriterion("line_type <=", value, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeIn(List<Integer> values) {
            addCriterion("line_type in", values, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeNotIn(List<Integer> values) {
            addCriterion("line_type not in", values, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeBetween(Integer value1, Integer value2) {
            addCriterion("line_type between", value1, value2, "line_type");
            return (Criteria) this;
        }

        public Criteria andLine_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("line_type not between", value1, value2, "line_type");
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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