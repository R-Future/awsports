package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwSinglesMatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwSinglesMatchExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEventidIsNull() {
            addCriterion("eventId is null");
            return (Criteria) this;
        }

        public Criteria andEventidIsNotNull() {
            addCriterion("eventId is not null");
            return (Criteria) this;
        }

        public Criteria andEventidEqualTo(Integer value) {
            addCriterion("eventId =", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotEqualTo(Integer value) {
            addCriterion("eventId <>", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidGreaterThan(Integer value) {
            addCriterion("eventId >", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eventId >=", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidLessThan(Integer value) {
            addCriterion("eventId <", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidLessThanOrEqualTo(Integer value) {
            addCriterion("eventId <=", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidIn(List<Integer> values) {
            addCriterion("eventId in", values, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotIn(List<Integer> values) {
            addCriterion("eventId not in", values, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidBetween(Integer value1, Integer value2) {
            addCriterion("eventId between", value1, value2, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotBetween(Integer value1, Integer value2) {
            addCriterion("eventId not between", value1, value2, "eventid");
            return (Criteria) this;
        }

        public Criteria andHomeidIsNull() {
            addCriterion("homeId is null");
            return (Criteria) this;
        }

        public Criteria andHomeidIsNotNull() {
            addCriterion("homeId is not null");
            return (Criteria) this;
        }

        public Criteria andHomeidEqualTo(Integer value) {
            addCriterion("homeId =", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidNotEqualTo(Integer value) {
            addCriterion("homeId <>", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidGreaterThan(Integer value) {
            addCriterion("homeId >", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeId >=", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidLessThan(Integer value) {
            addCriterion("homeId <", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidLessThanOrEqualTo(Integer value) {
            addCriterion("homeId <=", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidIn(List<Integer> values) {
            addCriterion("homeId in", values, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidNotIn(List<Integer> values) {
            addCriterion("homeId not in", values, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidBetween(Integer value1, Integer value2) {
            addCriterion("homeId between", value1, value2, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidNotBetween(Integer value1, Integer value2) {
            addCriterion("homeId not between", value1, value2, "homeid");
            return (Criteria) this;
        }

        public Criteria andGuestidIsNull() {
            addCriterion("guestId is null");
            return (Criteria) this;
        }

        public Criteria andGuestidIsNotNull() {
            addCriterion("guestId is not null");
            return (Criteria) this;
        }

        public Criteria andGuestidEqualTo(Integer value) {
            addCriterion("guestId =", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotEqualTo(Integer value) {
            addCriterion("guestId <>", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidGreaterThan(Integer value) {
            addCriterion("guestId >", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidGreaterThanOrEqualTo(Integer value) {
            addCriterion("guestId >=", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidLessThan(Integer value) {
            addCriterion("guestId <", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidLessThanOrEqualTo(Integer value) {
            addCriterion("guestId <=", value, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidIn(List<Integer> values) {
            addCriterion("guestId in", values, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotIn(List<Integer> values) {
            addCriterion("guestId not in", values, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidBetween(Integer value1, Integer value2) {
            addCriterion("guestId between", value1, value2, "guestid");
            return (Criteria) this;
        }

        public Criteria andGuestidNotBetween(Integer value1, Integer value2) {
            addCriterion("guestId not between", value1, value2, "guestid");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andRoundIsNull() {
            addCriterion("round is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("round is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(String value) {
            addCriterion("round =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(String value) {
            addCriterion("round <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(String value) {
            addCriterion("round >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(String value) {
            addCriterion("round >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(String value) {
            addCriterion("round <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(String value) {
            addCriterion("round <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLike(String value) {
            addCriterion("round like", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotLike(String value) {
            addCriterion("round not like", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<String> values) {
            addCriterion("round in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<String> values) {
            addCriterion("round not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(String value1, String value2) {
            addCriterion("round between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(String value1, String value2) {
            addCriterion("round not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredIsNull() {
            addCriterion("isHomeRetired is null");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredIsNotNull() {
            addCriterion("isHomeRetired is not null");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredEqualTo(Boolean value) {
            addCriterion("isHomeRetired =", value, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredNotEqualTo(Boolean value) {
            addCriterion("isHomeRetired <>", value, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredGreaterThan(Boolean value) {
            addCriterion("isHomeRetired >", value, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isHomeRetired >=", value, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredLessThan(Boolean value) {
            addCriterion("isHomeRetired <", value, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredLessThanOrEqualTo(Boolean value) {
            addCriterion("isHomeRetired <=", value, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredIn(List<Boolean> values) {
            addCriterion("isHomeRetired in", values, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredNotIn(List<Boolean> values) {
            addCriterion("isHomeRetired not in", values, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredBetween(Boolean value1, Boolean value2) {
            addCriterion("isHomeRetired between", value1, value2, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIshomeretiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isHomeRetired not between", value1, value2, "ishomeretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredIsNull() {
            addCriterion("isGuestRetired is null");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredIsNotNull() {
            addCriterion("isGuestRetired is not null");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredEqualTo(Boolean value) {
            addCriterion("isGuestRetired =", value, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredNotEqualTo(Boolean value) {
            addCriterion("isGuestRetired <>", value, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredGreaterThan(Boolean value) {
            addCriterion("isGuestRetired >", value, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isGuestRetired >=", value, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredLessThan(Boolean value) {
            addCriterion("isGuestRetired <", value, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredLessThanOrEqualTo(Boolean value) {
            addCriterion("isGuestRetired <=", value, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredIn(List<Boolean> values) {
            addCriterion("isGuestRetired in", values, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredNotIn(List<Boolean> values) {
            addCriterion("isGuestRetired not in", values, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredBetween(Boolean value1, Boolean value2) {
            addCriterion("isGuestRetired between", value1, value2, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andIsguestretiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isGuestRetired not between", value1, value2, "isguestretired");
            return (Criteria) this;
        }

        public Criteria andHomepointIsNull() {
            addCriterion("homePoint is null");
            return (Criteria) this;
        }

        public Criteria andHomepointIsNotNull() {
            addCriterion("homePoint is not null");
            return (Criteria) this;
        }

        public Criteria andHomepointEqualTo(Integer value) {
            addCriterion("homePoint =", value, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointNotEqualTo(Integer value) {
            addCriterion("homePoint <>", value, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointGreaterThan(Integer value) {
            addCriterion("homePoint >", value, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointGreaterThanOrEqualTo(Integer value) {
            addCriterion("homePoint >=", value, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointLessThan(Integer value) {
            addCriterion("homePoint <", value, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointLessThanOrEqualTo(Integer value) {
            addCriterion("homePoint <=", value, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointIn(List<Integer> values) {
            addCriterion("homePoint in", values, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointNotIn(List<Integer> values) {
            addCriterion("homePoint not in", values, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointBetween(Integer value1, Integer value2) {
            addCriterion("homePoint between", value1, value2, "homepoint");
            return (Criteria) this;
        }

        public Criteria andHomepointNotBetween(Integer value1, Integer value2) {
            addCriterion("homePoint not between", value1, value2, "homepoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointIsNull() {
            addCriterion("guestPoint is null");
            return (Criteria) this;
        }

        public Criteria andGuestpointIsNotNull() {
            addCriterion("guestPoint is not null");
            return (Criteria) this;
        }

        public Criteria andGuestpointEqualTo(Integer value) {
            addCriterion("guestPoint =", value, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointNotEqualTo(Integer value) {
            addCriterion("guestPoint <>", value, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointGreaterThan(Integer value) {
            addCriterion("guestPoint >", value, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointGreaterThanOrEqualTo(Integer value) {
            addCriterion("guestPoint >=", value, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointLessThan(Integer value) {
            addCriterion("guestPoint <", value, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointLessThanOrEqualTo(Integer value) {
            addCriterion("guestPoint <=", value, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointIn(List<Integer> values) {
            addCriterion("guestPoint in", values, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointNotIn(List<Integer> values) {
            addCriterion("guestPoint not in", values, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointBetween(Integer value1, Integer value2) {
            addCriterion("guestPoint between", value1, value2, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andGuestpointNotBetween(Integer value1, Integer value2) {
            addCriterion("guestPoint not between", value1, value2, "guestpoint");
            return (Criteria) this;
        }

        public Criteria andIshomewinIsNull() {
            addCriterion("isHomeWin is null");
            return (Criteria) this;
        }

        public Criteria andIshomewinIsNotNull() {
            addCriterion("isHomeWin is not null");
            return (Criteria) this;
        }

        public Criteria andIshomewinEqualTo(Boolean value) {
            addCriterion("isHomeWin =", value, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinNotEqualTo(Boolean value) {
            addCriterion("isHomeWin <>", value, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinGreaterThan(Boolean value) {
            addCriterion("isHomeWin >", value, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isHomeWin >=", value, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinLessThan(Boolean value) {
            addCriterion("isHomeWin <", value, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinLessThanOrEqualTo(Boolean value) {
            addCriterion("isHomeWin <=", value, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinIn(List<Boolean> values) {
            addCriterion("isHomeWin in", values, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinNotIn(List<Boolean> values) {
            addCriterion("isHomeWin not in", values, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinBetween(Boolean value1, Boolean value2) {
            addCriterion("isHomeWin between", value1, value2, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andIshomewinNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isHomeWin not between", value1, value2, "ishomewin");
            return (Criteria) this;
        }

        public Criteria andCreatedatIsNull() {
            addCriterion("createdAt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedatIsNotNull() {
            addCriterion("createdAt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedatEqualTo(Date value) {
            addCriterion("createdAt =", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotEqualTo(Date value) {
            addCriterion("createdAt <>", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatGreaterThan(Date value) {
            addCriterion("createdAt >", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatGreaterThanOrEqualTo(Date value) {
            addCriterion("createdAt >=", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatLessThan(Date value) {
            addCriterion("createdAt <", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatLessThanOrEqualTo(Date value) {
            addCriterion("createdAt <=", value, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatIn(List<Date> values) {
            addCriterion("createdAt in", values, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotIn(List<Date> values) {
            addCriterion("createdAt not in", values, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatBetween(Date value1, Date value2) {
            addCriterion("createdAt between", value1, value2, "createdat");
            return (Criteria) this;
        }

        public Criteria andCreatedatNotBetween(Date value1, Date value2) {
            addCriterion("createdAt not between", value1, value2, "createdat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIsNull() {
            addCriterion("updatedAt is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIsNotNull() {
            addCriterion("updatedAt is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedatEqualTo(Date value) {
            addCriterion("updatedAt =", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotEqualTo(Date value) {
            addCriterion("updatedAt <>", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatGreaterThan(Date value) {
            addCriterion("updatedAt >", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedAt >=", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatLessThan(Date value) {
            addCriterion("updatedAt <", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatLessThanOrEqualTo(Date value) {
            addCriterion("updatedAt <=", value, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatIn(List<Date> values) {
            addCriterion("updatedAt in", values, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotIn(List<Date> values) {
            addCriterion("updatedAt not in", values, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatBetween(Date value1, Date value2) {
            addCriterion("updatedAt between", value1, value2, "updatedat");
            return (Criteria) this;
        }

        public Criteria andUpdatedatNotBetween(Date value1, Date value2) {
            addCriterion("updatedAt not between", value1, value2, "updatedat");
            return (Criteria) this;
        }

        public Criteria andInvalidIsNull() {
            addCriterion("invalid is null");
            return (Criteria) this;
        }

        public Criteria andInvalidIsNotNull() {
            addCriterion("invalid is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidEqualTo(Boolean value) {
            addCriterion("invalid =", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotEqualTo(Boolean value) {
            addCriterion("invalid <>", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidGreaterThan(Boolean value) {
            addCriterion("invalid >", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("invalid >=", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidLessThan(Boolean value) {
            addCriterion("invalid <", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidLessThanOrEqualTo(Boolean value) {
            addCriterion("invalid <=", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidIn(List<Boolean> values) {
            addCriterion("invalid in", values, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotIn(List<Boolean> values) {
            addCriterion("invalid not in", values, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidBetween(Boolean value1, Boolean value2) {
            addCriterion("invalid between", value1, value2, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("invalid not between", value1, value2, "invalid");
            return (Criteria) this;
        }

        public Criteria andMirrorIsNull() {
            addCriterion("mirror is null");
            return (Criteria) this;
        }

        public Criteria andMirrorIsNotNull() {
            addCriterion("mirror is not null");
            return (Criteria) this;
        }

        public Criteria andMirrorEqualTo(String value) {
            addCriterion("mirror =", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotEqualTo(String value) {
            addCriterion("mirror <>", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorGreaterThan(String value) {
            addCriterion("mirror >", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorGreaterThanOrEqualTo(String value) {
            addCriterion("mirror >=", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorLessThan(String value) {
            addCriterion("mirror <", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorLessThanOrEqualTo(String value) {
            addCriterion("mirror <=", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorLike(String value) {
            addCriterion("mirror like", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotLike(String value) {
            addCriterion("mirror not like", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorIn(List<String> values) {
            addCriterion("mirror in", values, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotIn(List<String> values) {
            addCriterion("mirror not in", values, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorBetween(String value1, String value2) {
            addCriterion("mirror between", value1, value2, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotBetween(String value1, String value2) {
            addCriterion("mirror not between", value1, value2, "mirror");
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