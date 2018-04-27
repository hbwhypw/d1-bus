package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class ProductRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductRepository() {
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

        public Criteria andPro_nameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andPro_nameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andPro_nameEqualTo(String value) {
            addCriterion("pro_name =", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameGreaterThan(String value) {
            addCriterion("pro_name >", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameLessThan(String value) {
            addCriterion("pro_name <", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameLike(String value) {
            addCriterion("pro_name like", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameNotLike(String value) {
            addCriterion("pro_name not like", value, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameIn(List<String> values) {
            addCriterion("pro_name in", values, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_nameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "pro_name");
            return (Criteria) this;
        }

        public Criteria andPro_typeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andPro_typeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andPro_typeEqualTo(String value) {
            addCriterion("pro_type =", value, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeGreaterThan(String value) {
            addCriterion("pro_type >", value, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeLessThan(String value) {
            addCriterion("pro_type <", value, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeIn(List<String> values) {
            addCriterion("pro_type in", values, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "pro_type");
            return (Criteria) this;
        }

        public Criteria andPro_typeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "pro_type");
            return (Criteria) this;
        }

        public Criteria andRemote_urlIsNull() {
            addCriterion("remote_url is null");
            return (Criteria) this;
        }

        public Criteria andRemote_urlIsNotNull() {
            addCriterion("remote_url is not null");
            return (Criteria) this;
        }

        public Criteria andRemote_urlEqualTo(String value) {
            addCriterion("remote_url =", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlNotEqualTo(String value) {
            addCriterion("remote_url <>", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlGreaterThan(String value) {
            addCriterion("remote_url >", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlGreaterThanOrEqualTo(String value) {
            addCriterion("remote_url >=", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlLessThan(String value) {
            addCriterion("remote_url <", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlLessThanOrEqualTo(String value) {
            addCriterion("remote_url <=", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlLike(String value) {
            addCriterion("remote_url like", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlNotLike(String value) {
            addCriterion("remote_url not like", value, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlIn(List<String> values) {
            addCriterion("remote_url in", values, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlNotIn(List<String> values) {
            addCriterion("remote_url not in", values, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlBetween(String value1, String value2) {
            addCriterion("remote_url between", value1, value2, "remote_url");
            return (Criteria) this;
        }

        public Criteria andRemote_urlNotBetween(String value1, String value2) {
            addCriterion("remote_url not between", value1, value2, "remote_url");
            return (Criteria) this;
        }

        public Criteria andMarket_priceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarket_priceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarket_priceEqualTo(Double value) {
            addCriterion("market_price =", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceNotEqualTo(Double value) {
            addCriterion("market_price <>", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceGreaterThan(Double value) {
            addCriterion("market_price >", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("market_price >=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceLessThan(Double value) {
            addCriterion("market_price <", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceLessThanOrEqualTo(Double value) {
            addCriterion("market_price <=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceIn(List<Double> values) {
            addCriterion("market_price in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceNotIn(List<Double> values) {
            addCriterion("market_price not in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceBetween(Double value1, Double value2) {
            addCriterion("market_price between", value1, value2, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceNotBetween(Double value1, Double value2) {
            addCriterion("market_price not between", value1, value2, "market_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceIsNull() {
            addCriterion("shop_price is null");
            return (Criteria) this;
        }

        public Criteria andShop_priceIsNotNull() {
            addCriterion("shop_price is not null");
            return (Criteria) this;
        }

        public Criteria andShop_priceEqualTo(Double value) {
            addCriterion("shop_price =", value, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceNotEqualTo(Double value) {
            addCriterion("shop_price <>", value, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceGreaterThan(Double value) {
            addCriterion("shop_price >", value, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_price >=", value, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceLessThan(Double value) {
            addCriterion("shop_price <", value, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceLessThanOrEqualTo(Double value) {
            addCriterion("shop_price <=", value, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceIn(List<Double> values) {
            addCriterion("shop_price in", values, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceNotIn(List<Double> values) {
            addCriterion("shop_price not in", values, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceBetween(Double value1, Double value2) {
            addCriterion("shop_price between", value1, value2, "shop_price");
            return (Criteria) this;
        }

        public Criteria andShop_priceNotBetween(Double value1, Double value2) {
            addCriterion("shop_price not between", value1, value2, "shop_price");
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

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andSell_typeIsNull() {
            addCriterion("sell_type is null");
            return (Criteria) this;
        }

        public Criteria andSell_typeIsNotNull() {
            addCriterion("sell_type is not null");
            return (Criteria) this;
        }

        public Criteria andSell_typeEqualTo(Integer value) {
            addCriterion("sell_type =", value, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeNotEqualTo(Integer value) {
            addCriterion("sell_type <>", value, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeGreaterThan(Integer value) {
            addCriterion("sell_type >", value, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_type >=", value, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeLessThan(Integer value) {
            addCriterion("sell_type <", value, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeLessThanOrEqualTo(Integer value) {
            addCriterion("sell_type <=", value, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeIn(List<Integer> values) {
            addCriterion("sell_type in", values, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeNotIn(List<Integer> values) {
            addCriterion("sell_type not in", values, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeBetween(Integer value1, Integer value2) {
            addCriterion("sell_type between", value1, value2, "sell_type");
            return (Criteria) this;
        }

        public Criteria andSell_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_type not between", value1, value2, "sell_type");
            return (Criteria) this;
        }

        public Criteria andLimit_buyIsNull() {
            addCriterion("limit_buy is null");
            return (Criteria) this;
        }

        public Criteria andLimit_buyIsNotNull() {
            addCriterion("limit_buy is not null");
            return (Criteria) this;
        }

        public Criteria andLimit_buyEqualTo(Integer value) {
            addCriterion("limit_buy =", value, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyNotEqualTo(Integer value) {
            addCriterion("limit_buy <>", value, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyGreaterThan(Integer value) {
            addCriterion("limit_buy >", value, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_buy >=", value, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyLessThan(Integer value) {
            addCriterion("limit_buy <", value, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyLessThanOrEqualTo(Integer value) {
            addCriterion("limit_buy <=", value, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyIn(List<Integer> values) {
            addCriterion("limit_buy in", values, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyNotIn(List<Integer> values) {
            addCriterion("limit_buy not in", values, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyBetween(Integer value1, Integer value2) {
            addCriterion("limit_buy between", value1, value2, "limit_buy");
            return (Criteria) this;
        }

        public Criteria andLimit_buyNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_buy not between", value1, value2, "limit_buy");
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