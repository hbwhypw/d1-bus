package com.tmtc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tmtc.po.page.PageRespository;

public class LineStationRepository extends PageRespository{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineStationRepository() {
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

        public Criteria andLine_idIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLine_idIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLine_idEqualTo(String value) {
            addCriterion("line_id =", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotEqualTo(String value) {
            addCriterion("line_id <>", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idGreaterThan(String value) {
            addCriterion("line_id >", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLessThan(String value) {
            addCriterion("line_id <", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idIn(List<String> values) {
            addCriterion("line_id in", values, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotIn(List<String> values) {
            addCriterion("line_id not in", values, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "line_id");
            return (Criteria) this;
        }

        public Criteria andStation_nameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStation_nameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStation_nameEqualTo(String value) {
            addCriterion("station_name =", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameGreaterThan(String value) {
            addCriterion("station_name >", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameLessThan(String value) {
            addCriterion("station_name <", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameLike(String value) {
            addCriterion("station_name like", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameNotLike(String value) {
            addCriterion("station_name not like", value, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameIn(List<String> values) {
            addCriterion("station_name in", values, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "station_name");
            return (Criteria) this;
        }

        public Criteria andStation_nameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "station_name");
            return (Criteria) this;
        }

        public Criteria andNext_timeIsNull() {
            addCriterion("next_time is null");
            return (Criteria) this;
        }

        public Criteria andNext_timeIsNotNull() {
            addCriterion("next_time is not null");
            return (Criteria) this;
        }

        public Criteria andNext_timeEqualTo(Integer value) {
            addCriterion("next_time =", value, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeNotEqualTo(Integer value) {
            addCriterion("next_time <>", value, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeGreaterThan(Integer value) {
            addCriterion("next_time >", value, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_time >=", value, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeLessThan(Integer value) {
            addCriterion("next_time <", value, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeLessThanOrEqualTo(Integer value) {
            addCriterion("next_time <=", value, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeIn(List<Integer> values) {
            addCriterion("next_time in", values, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeNotIn(List<Integer> values) {
            addCriterion("next_time not in", values, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeBetween(Integer value1, Integer value2) {
            addCriterion("next_time between", value1, value2, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("next_time not between", value1, value2, "next_time");
            return (Criteria) this;
        }

        public Criteria andNext_kmIsNull() {
            addCriterion("next_km is null");
            return (Criteria) this;
        }

        public Criteria andNext_kmIsNotNull() {
            addCriterion("next_km is not null");
            return (Criteria) this;
        }

        public Criteria andNext_kmEqualTo(Double value) {
            addCriterion("next_km =", value, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmNotEqualTo(Double value) {
            addCriterion("next_km <>", value, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmGreaterThan(Double value) {
            addCriterion("next_km >", value, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmGreaterThanOrEqualTo(Double value) {
            addCriterion("next_km >=", value, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmLessThan(Double value) {
            addCriterion("next_km <", value, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmLessThanOrEqualTo(Double value) {
            addCriterion("next_km <=", value, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmIn(List<Double> values) {
            addCriterion("next_km in", values, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmNotIn(List<Double> values) {
            addCriterion("next_km not in", values, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmBetween(Double value1, Double value2) {
            addCriterion("next_km between", value1, value2, "next_km");
            return (Criteria) this;
        }

        public Criteria andNext_kmNotBetween(Double value1, Double value2) {
            addCriterion("next_km not between", value1, value2, "next_km");
            return (Criteria) this;
        }

        public Criteria andPrev_idIsNull() {
            addCriterion("prev_id is null");
            return (Criteria) this;
        }

        public Criteria andPrev_idIsNotNull() {
            addCriterion("prev_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrev_idEqualTo(String value) {
            addCriterion("prev_id =", value, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idNotEqualTo(String value) {
            addCriterion("prev_id <>", value, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idGreaterThan(String value) {
            addCriterion("prev_id >", value, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idGreaterThanOrEqualTo(String value) {
            addCriterion("prev_id >=", value, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idLessThan(String value) {
            addCriterion("prev_id <", value, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idLessThanOrEqualTo(String value) {
            addCriterion("prev_id <=", value, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idIn(List<String> values) {
            addCriterion("prev_id in", values, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idNotIn(List<String> values) {
            addCriterion("prev_id not in", values, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idBetween(String value1, String value2) {
            addCriterion("prev_id between", value1, value2, "prev_id");
            return (Criteria) this;
        }

        public Criteria andPrev_idNotBetween(String value1, String value2) {
            addCriterion("prev_id not between", value1, value2, "prev_id");
            return (Criteria) this;
        }

        public Criteria andNext_idIsNull() {
            addCriterion("next_id is null");
            return (Criteria) this;
        }

        public Criteria andNext_idIsNotNull() {
            addCriterion("next_id is not null");
            return (Criteria) this;
        }

        public Criteria andNext_idEqualTo(String value) {
            addCriterion("next_id =", value, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idNotEqualTo(String value) {
            addCriterion("next_id <>", value, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idGreaterThan(String value) {
            addCriterion("next_id >", value, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idGreaterThanOrEqualTo(String value) {
            addCriterion("next_id >=", value, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idLessThan(String value) {
            addCriterion("next_id <", value, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idLessThanOrEqualTo(String value) {
            addCriterion("next_id <=", value, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idIn(List<String> values) {
            addCriterion("next_id in", values, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idNotIn(List<String> values) {
            addCriterion("next_id not in", values, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idBetween(String value1, String value2) {
            addCriterion("next_id between", value1, value2, "next_id");
            return (Criteria) this;
        }

        public Criteria andNext_idNotBetween(String value1, String value2) {
            addCriterion("next_id not between", value1, value2, "next_id");
            return (Criteria) this;
        }

        public Criteria andX_pointIsNull() {
            addCriterion("x_point is null");
            return (Criteria) this;
        }

        public Criteria andX_pointIsNotNull() {
            addCriterion("x_point is not null");
            return (Criteria) this;
        }

        public Criteria andX_pointEqualTo(Double value) {
            addCriterion("x_point =", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointNotEqualTo(Double value) {
            addCriterion("x_point <>", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointGreaterThan(Double value) {
            addCriterion("x_point >", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointGreaterThanOrEqualTo(Double value) {
            addCriterion("x_point >=", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointLessThan(Double value) {
            addCriterion("x_point <", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointLessThanOrEqualTo(Double value) {
            addCriterion("x_point <=", value, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointIn(List<Double> values) {
            addCriterion("x_point in", values, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointNotIn(List<Double> values) {
            addCriterion("x_point not in", values, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointBetween(Double value1, Double value2) {
            addCriterion("x_point between", value1, value2, "x_point");
            return (Criteria) this;
        }

        public Criteria andX_pointNotBetween(Double value1, Double value2) {
            addCriterion("x_point not between", value1, value2, "x_point");
            return (Criteria) this;
        }

        public Criteria andY_pointIsNull() {
            addCriterion("y_point is null");
            return (Criteria) this;
        }

        public Criteria andY_pointIsNotNull() {
            addCriterion("y_point is not null");
            return (Criteria) this;
        }

        public Criteria andY_pointEqualTo(Double value) {
            addCriterion("y_point =", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointNotEqualTo(Double value) {
            addCriterion("y_point <>", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointGreaterThan(Double value) {
            addCriterion("y_point >", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointGreaterThanOrEqualTo(Double value) {
            addCriterion("y_point >=", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointLessThan(Double value) {
            addCriterion("y_point <", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointLessThanOrEqualTo(Double value) {
            addCriterion("y_point <=", value, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointIn(List<Double> values) {
            addCriterion("y_point in", values, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointNotIn(List<Double> values) {
            addCriterion("y_point not in", values, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointBetween(Double value1, Double value2) {
            addCriterion("y_point between", value1, value2, "y_point");
            return (Criteria) this;
        }

        public Criteria andY_pointNotBetween(Double value1, Double value2) {
            addCriterion("y_point not between", value1, value2, "y_point");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNull() {
            addCriterion("qrcode is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNotNull() {
            addCriterion("qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEqualTo(String value) {
            addCriterion("qrcode =", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotEqualTo(String value) {
            addCriterion("qrcode <>", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThan(String value) {
            addCriterion("qrcode >", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode >=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThan(String value) {
            addCriterion("qrcode <", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThanOrEqualTo(String value) {
            addCriterion("qrcode <=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLike(String value) {
            addCriterion("qrcode like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotLike(String value) {
            addCriterion("qrcode not like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeIn(List<String> values) {
            addCriterion("qrcode in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotIn(List<String> values) {
            addCriterion("qrcode not in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeBetween(String value1, String value2) {
            addCriterion("qrcode between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotBetween(String value1, String value2) {
            addCriterion("qrcode not between", value1, value2, "qrcode");
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

        public Criteria andWillnumIsNull() {
            addCriterion("willnum is null");
            return (Criteria) this;
        }

        public Criteria andWillnumIsNotNull() {
            addCriterion("willnum is not null");
            return (Criteria) this;
        }

        public Criteria andWillnumEqualTo(Integer value) {
            addCriterion("willnum =", value, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumNotEqualTo(Integer value) {
            addCriterion("willnum <>", value, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumGreaterThan(Integer value) {
            addCriterion("willnum >", value, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("willnum >=", value, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumLessThan(Integer value) {
            addCriterion("willnum <", value, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumLessThanOrEqualTo(Integer value) {
            addCriterion("willnum <=", value, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumIn(List<Integer> values) {
            addCriterion("willnum in", values, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumNotIn(List<Integer> values) {
            addCriterion("willnum not in", values, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumBetween(Integer value1, Integer value2) {
            addCriterion("willnum between", value1, value2, "willnum");
            return (Criteria) this;
        }

        public Criteria andWillnumNotBetween(Integer value1, Integer value2) {
            addCriterion("willnum not between", value1, value2, "willnum");
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