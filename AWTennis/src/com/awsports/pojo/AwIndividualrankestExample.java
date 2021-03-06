package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwIndividualrankestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwIndividualrankestExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andEntryIsNull() {
            addCriterion("entry is null");
            return (Criteria) this;
        }

        public Criteria andEntryIsNotNull() {
            addCriterion("entry is not null");
            return (Criteria) this;
        }

        public Criteria andEntryEqualTo(Integer value) {
            addCriterion("entry =", value, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryNotEqualTo(Integer value) {
            addCriterion("entry <>", value, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryGreaterThan(Integer value) {
            addCriterion("entry >", value, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryGreaterThanOrEqualTo(Integer value) {
            addCriterion("entry >=", value, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryLessThan(Integer value) {
            addCriterion("entry <", value, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryLessThanOrEqualTo(Integer value) {
            addCriterion("entry <=", value, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryIn(List<Integer> values) {
            addCriterion("entry in", values, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryNotIn(List<Integer> values) {
            addCriterion("entry not in", values, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryBetween(Integer value1, Integer value2) {
            addCriterion("entry between", value1, value2, "entry");
            return (Criteria) this;
        }

        public Criteria andEntryNotBetween(Integer value1, Integer value2) {
            addCriterion("entry not between", value1, value2, "entry");
            return (Criteria) this;
        }

        public Criteria andHighestrankingIsNull() {
            addCriterion("highestRanking is null");
            return (Criteria) this;
        }

        public Criteria andHighestrankingIsNotNull() {
            addCriterion("highestRanking is not null");
            return (Criteria) this;
        }

        public Criteria andHighestrankingEqualTo(Integer value) {
            addCriterion("highestRanking =", value, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingNotEqualTo(Integer value) {
            addCriterion("highestRanking <>", value, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingGreaterThan(Integer value) {
            addCriterion("highestRanking >", value, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("highestRanking >=", value, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingLessThan(Integer value) {
            addCriterion("highestRanking <", value, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingLessThanOrEqualTo(Integer value) {
            addCriterion("highestRanking <=", value, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingIn(List<Integer> values) {
            addCriterion("highestRanking in", values, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingNotIn(List<Integer> values) {
            addCriterion("highestRanking not in", values, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingBetween(Integer value1, Integer value2) {
            addCriterion("highestRanking between", value1, value2, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHighestrankingNotBetween(Integer value1, Integer value2) {
            addCriterion("highestRanking not between", value1, value2, "highestranking");
            return (Criteria) this;
        }

        public Criteria andHrstartedatIsNull() {
            addCriterion("HRStartedAt is null");
            return (Criteria) this;
        }

        public Criteria andHrstartedatIsNotNull() {
            addCriterion("HRStartedAt is not null");
            return (Criteria) this;
        }

        public Criteria andHrstartedatEqualTo(Date value) {
            addCriterion("HRStartedAt =", value, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatNotEqualTo(Date value) {
            addCriterion("HRStartedAt <>", value, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatGreaterThan(Date value) {
            addCriterion("HRStartedAt >", value, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatGreaterThanOrEqualTo(Date value) {
            addCriterion("HRStartedAt >=", value, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatLessThan(Date value) {
            addCriterion("HRStartedAt <", value, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatLessThanOrEqualTo(Date value) {
            addCriterion("HRStartedAt <=", value, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatIn(List<Date> values) {
            addCriterion("HRStartedAt in", values, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatNotIn(List<Date> values) {
            addCriterion("HRStartedAt not in", values, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatBetween(Date value1, Date value2) {
            addCriterion("HRStartedAt between", value1, value2, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andHrstartedatNotBetween(Date value1, Date value2) {
            addCriterion("HRStartedAt not between", value1, value2, "hrstartedat");
            return (Criteria) this;
        }

        public Criteria andNo1weeksIsNull() {
            addCriterion("NO1Weeks is null");
            return (Criteria) this;
        }

        public Criteria andNo1weeksIsNotNull() {
            addCriterion("NO1Weeks is not null");
            return (Criteria) this;
        }

        public Criteria andNo1weeksEqualTo(Integer value) {
            addCriterion("NO1Weeks =", value, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksNotEqualTo(Integer value) {
            addCriterion("NO1Weeks <>", value, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksGreaterThan(Integer value) {
            addCriterion("NO1Weeks >", value, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO1Weeks >=", value, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksLessThan(Integer value) {
            addCriterion("NO1Weeks <", value, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksLessThanOrEqualTo(Integer value) {
            addCriterion("NO1Weeks <=", value, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksIn(List<Integer> values) {
            addCriterion("NO1Weeks in", values, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksNotIn(List<Integer> values) {
            addCriterion("NO1Weeks not in", values, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksBetween(Integer value1, Integer value2) {
            addCriterion("NO1Weeks between", value1, value2, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1weeksNotBetween(Integer value1, Integer value2) {
            addCriterion("NO1Weeks not between", value1, value2, "no1weeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksIsNull() {
            addCriterion("NO1ContinuousWeeks is null");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksIsNotNull() {
            addCriterion("NO1ContinuousWeeks is not null");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksEqualTo(Integer value) {
            addCriterion("NO1ContinuousWeeks =", value, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksNotEqualTo(Integer value) {
            addCriterion("NO1ContinuousWeeks <>", value, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksGreaterThan(Integer value) {
            addCriterion("NO1ContinuousWeeks >", value, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO1ContinuousWeeks >=", value, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksLessThan(Integer value) {
            addCriterion("NO1ContinuousWeeks <", value, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksLessThanOrEqualTo(Integer value) {
            addCriterion("NO1ContinuousWeeks <=", value, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksIn(List<Integer> values) {
            addCriterion("NO1ContinuousWeeks in", values, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksNotIn(List<Integer> values) {
            addCriterion("NO1ContinuousWeeks not in", values, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksBetween(Integer value1, Integer value2) {
            addCriterion("NO1ContinuousWeeks between", value1, value2, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continuousweeksNotBetween(Integer value1, Integer value2) {
            addCriterion("NO1ContinuousWeeks not between", value1, value2, "no1continuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksIsNull() {
            addCriterion("NO1LongestContinuousWeeks is null");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksIsNotNull() {
            addCriterion("NO1LongestContinuousWeeks is not null");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksEqualTo(Integer value) {
            addCriterion("NO1LongestContinuousWeeks =", value, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksNotEqualTo(Integer value) {
            addCriterion("NO1LongestContinuousWeeks <>", value, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksGreaterThan(Integer value) {
            addCriterion("NO1LongestContinuousWeeks >", value, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO1LongestContinuousWeeks >=", value, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksLessThan(Integer value) {
            addCriterion("NO1LongestContinuousWeeks <", value, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksLessThanOrEqualTo(Integer value) {
            addCriterion("NO1LongestContinuousWeeks <=", value, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksIn(List<Integer> values) {
            addCriterion("NO1LongestContinuousWeeks in", values, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksNotIn(List<Integer> values) {
            addCriterion("NO1LongestContinuousWeeks not in", values, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksBetween(Integer value1, Integer value2) {
            addCriterion("NO1LongestContinuousWeeks between", value1, value2, "no1longestcontinuousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontinuousweeksNotBetween(Integer value1, Integer value2) {
            addCriterion("NO1LongestContinuousWeeks not between", value1, value2, "no1longestcontinuousweeks");
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