package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwSinglematchscoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwSinglematchscoreExample() {
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

        public Criteria andMatchidIsNull() {
            addCriterion("matchID is null");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNotNull() {
            addCriterion("matchID is not null");
            return (Criteria) this;
        }

        public Criteria andMatchidEqualTo(Integer value) {
            addCriterion("matchID =", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotEqualTo(Integer value) {
            addCriterion("matchID <>", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThan(Integer value) {
            addCriterion("matchID >", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchID >=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThan(Integer value) {
            addCriterion("matchID <", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThanOrEqualTo(Integer value) {
            addCriterion("matchID <=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidIn(List<Integer> values) {
            addCriterion("matchID in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotIn(List<Integer> values) {
            addCriterion("matchID not in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidBetween(Integer value1, Integer value2) {
            addCriterion("matchID between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotBetween(Integer value1, Integer value2) {
            addCriterion("matchID not between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andSetthIsNull() {
            addCriterion("setTH is null");
            return (Criteria) this;
        }

        public Criteria andSetthIsNotNull() {
            addCriterion("setTH is not null");
            return (Criteria) this;
        }

        public Criteria andSetthEqualTo(Integer value) {
            addCriterion("setTH =", value, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthNotEqualTo(Integer value) {
            addCriterion("setTH <>", value, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthGreaterThan(Integer value) {
            addCriterion("setTH >", value, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthGreaterThanOrEqualTo(Integer value) {
            addCriterion("setTH >=", value, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthLessThan(Integer value) {
            addCriterion("setTH <", value, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthLessThanOrEqualTo(Integer value) {
            addCriterion("setTH <=", value, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthIn(List<Integer> values) {
            addCriterion("setTH in", values, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthNotIn(List<Integer> values) {
            addCriterion("setTH not in", values, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthBetween(Integer value1, Integer value2) {
            addCriterion("setTH between", value1, value2, "setth");
            return (Criteria) this;
        }

        public Criteria andSetthNotBetween(Integer value1, Integer value2) {
            addCriterion("setTH not between", value1, value2, "setth");
            return (Criteria) this;
        }

        public Criteria andHcscoreIsNull() {
            addCriterion("HCScore is null");
            return (Criteria) this;
        }

        public Criteria andHcscoreIsNotNull() {
            addCriterion("HCScore is not null");
            return (Criteria) this;
        }

        public Criteria andHcscoreEqualTo(Integer value) {
            addCriterion("HCScore =", value, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreNotEqualTo(Integer value) {
            addCriterion("HCScore <>", value, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreGreaterThan(Integer value) {
            addCriterion("HCScore >", value, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("HCScore >=", value, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreLessThan(Integer value) {
            addCriterion("HCScore <", value, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreLessThanOrEqualTo(Integer value) {
            addCriterion("HCScore <=", value, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreIn(List<Integer> values) {
            addCriterion("HCScore in", values, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreNotIn(List<Integer> values) {
            addCriterion("HCScore not in", values, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreBetween(Integer value1, Integer value2) {
            addCriterion("HCScore between", value1, value2, "hcscore");
            return (Criteria) this;
        }

        public Criteria andHcscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("HCScore not between", value1, value2, "hcscore");
            return (Criteria) this;
        }

        public Criteria andApscoreIsNull() {
            addCriterion("APScore is null");
            return (Criteria) this;
        }

        public Criteria andApscoreIsNotNull() {
            addCriterion("APScore is not null");
            return (Criteria) this;
        }

        public Criteria andApscoreEqualTo(Integer value) {
            addCriterion("APScore =", value, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreNotEqualTo(Integer value) {
            addCriterion("APScore <>", value, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreGreaterThan(Integer value) {
            addCriterion("APScore >", value, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("APScore >=", value, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreLessThan(Integer value) {
            addCriterion("APScore <", value, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreLessThanOrEqualTo(Integer value) {
            addCriterion("APScore <=", value, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreIn(List<Integer> values) {
            addCriterion("APScore in", values, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreNotIn(List<Integer> values) {
            addCriterion("APScore not in", values, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreBetween(Integer value1, Integer value2) {
            addCriterion("APScore between", value1, value2, "apscore");
            return (Criteria) this;
        }

        public Criteria andApscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("APScore not between", value1, value2, "apscore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreIsNull() {
            addCriterion("HCTieScore is null");
            return (Criteria) this;
        }

        public Criteria andHctiescoreIsNotNull() {
            addCriterion("HCTieScore is not null");
            return (Criteria) this;
        }

        public Criteria andHctiescoreEqualTo(Integer value) {
            addCriterion("HCTieScore =", value, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreNotEqualTo(Integer value) {
            addCriterion("HCTieScore <>", value, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreGreaterThan(Integer value) {
            addCriterion("HCTieScore >", value, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("HCTieScore >=", value, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreLessThan(Integer value) {
            addCriterion("HCTieScore <", value, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreLessThanOrEqualTo(Integer value) {
            addCriterion("HCTieScore <=", value, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreIn(List<Integer> values) {
            addCriterion("HCTieScore in", values, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreNotIn(List<Integer> values) {
            addCriterion("HCTieScore not in", values, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreBetween(Integer value1, Integer value2) {
            addCriterion("HCTieScore between", value1, value2, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andHctiescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("HCTieScore not between", value1, value2, "hctiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreIsNull() {
            addCriterion("APTieScore is null");
            return (Criteria) this;
        }

        public Criteria andAptiescoreIsNotNull() {
            addCriterion("APTieScore is not null");
            return (Criteria) this;
        }

        public Criteria andAptiescoreEqualTo(Integer value) {
            addCriterion("APTieScore =", value, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreNotEqualTo(Integer value) {
            addCriterion("APTieScore <>", value, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreGreaterThan(Integer value) {
            addCriterion("APTieScore >", value, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("APTieScore >=", value, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreLessThan(Integer value) {
            addCriterion("APTieScore <", value, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreLessThanOrEqualTo(Integer value) {
            addCriterion("APTieScore <=", value, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreIn(List<Integer> values) {
            addCriterion("APTieScore in", values, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreNotIn(List<Integer> values) {
            addCriterion("APTieScore not in", values, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreBetween(Integer value1, Integer value2) {
            addCriterion("APTieScore between", value1, value2, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andAptiescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("APTieScore not between", value1, value2, "aptiescore");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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