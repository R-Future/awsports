package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwTeamrankestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwTeamrankestExample() {
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

        public Criteria andTeamidIsNull() {
            addCriterion("teamID is null");
            return (Criteria) this;
        }

        public Criteria andTeamidIsNotNull() {
            addCriterion("teamID is not null");
            return (Criteria) this;
        }

        public Criteria andTeamidEqualTo(Integer value) {
            addCriterion("teamID =", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotEqualTo(Integer value) {
            addCriterion("teamID <>", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThan(Integer value) {
            addCriterion("teamID >", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("teamID >=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThan(Integer value) {
            addCriterion("teamID <", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThanOrEqualTo(Integer value) {
            addCriterion("teamID <=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidIn(List<Integer> values) {
            addCriterion("teamID in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotIn(List<Integer> values) {
            addCriterion("teamID not in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidBetween(Integer value1, Integer value2) {
            addCriterion("teamID between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotBetween(Integer value1, Integer value2) {
            addCriterion("teamID not between", value1, value2, "teamid");
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

        public Criteria andNo1continiousweeksIsNull() {
            addCriterion("NO1ContiniousWeeks is null");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksIsNotNull() {
            addCriterion("NO1ContiniousWeeks is not null");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksEqualTo(Integer value) {
            addCriterion("NO1ContiniousWeeks =", value, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksNotEqualTo(Integer value) {
            addCriterion("NO1ContiniousWeeks <>", value, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksGreaterThan(Integer value) {
            addCriterion("NO1ContiniousWeeks >", value, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO1ContiniousWeeks >=", value, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksLessThan(Integer value) {
            addCriterion("NO1ContiniousWeeks <", value, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksLessThanOrEqualTo(Integer value) {
            addCriterion("NO1ContiniousWeeks <=", value, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksIn(List<Integer> values) {
            addCriterion("NO1ContiniousWeeks in", values, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksNotIn(List<Integer> values) {
            addCriterion("NO1ContiniousWeeks not in", values, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksBetween(Integer value1, Integer value2) {
            addCriterion("NO1ContiniousWeeks between", value1, value2, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1continiousweeksNotBetween(Integer value1, Integer value2) {
            addCriterion("NO1ContiniousWeeks not between", value1, value2, "no1continiousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksIsNull() {
            addCriterion("NO1LongestContiniousWeeks is null");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksIsNotNull() {
            addCriterion("NO1LongestContiniousWeeks is not null");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksEqualTo(Integer value) {
            addCriterion("NO1LongestContiniousWeeks =", value, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksNotEqualTo(Integer value) {
            addCriterion("NO1LongestContiniousWeeks <>", value, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksGreaterThan(Integer value) {
            addCriterion("NO1LongestContiniousWeeks >", value, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO1LongestContiniousWeeks >=", value, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksLessThan(Integer value) {
            addCriterion("NO1LongestContiniousWeeks <", value, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksLessThanOrEqualTo(Integer value) {
            addCriterion("NO1LongestContiniousWeeks <=", value, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksIn(List<Integer> values) {
            addCriterion("NO1LongestContiniousWeeks in", values, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksNotIn(List<Integer> values) {
            addCriterion("NO1LongestContiniousWeeks not in", values, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksBetween(Integer value1, Integer value2) {
            addCriterion("NO1LongestContiniousWeeks between", value1, value2, "no1longestcontiniousweeks");
            return (Criteria) this;
        }

        public Criteria andNo1longestcontiniousweeksNotBetween(Integer value1, Integer value2) {
            addCriterion("NO1LongestContiniousWeeks not between", value1, value2, "no1longestcontiniousweeks");
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