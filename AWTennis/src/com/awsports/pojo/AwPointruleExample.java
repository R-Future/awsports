package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwPointruleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwPointruleExample() {
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

        public Criteria andTournamentidIsNull() {
            addCriterion("tournamentId is null");
            return (Criteria) this;
        }

        public Criteria andTournamentidIsNotNull() {
            addCriterion("tournamentId is not null");
            return (Criteria) this;
        }

        public Criteria andTournamentidEqualTo(Integer value) {
            addCriterion("tournamentId =", value, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidNotEqualTo(Integer value) {
            addCriterion("tournamentId <>", value, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidGreaterThan(Integer value) {
            addCriterion("tournamentId >", value, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tournamentId >=", value, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidLessThan(Integer value) {
            addCriterion("tournamentId <", value, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidLessThanOrEqualTo(Integer value) {
            addCriterion("tournamentId <=", value, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidIn(List<Integer> values) {
            addCriterion("tournamentId in", values, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidNotIn(List<Integer> values) {
            addCriterion("tournamentId not in", values, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidBetween(Integer value1, Integer value2) {
            addCriterion("tournamentId between", value1, value2, "tournamentid");
            return (Criteria) this;
        }

        public Criteria andTournamentidNotBetween(Integer value1, Integer value2) {
            addCriterion("tournamentId not between", value1, value2, "tournamentid");
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

        public Criteria andRoundEqualTo(Integer value) {
            addCriterion("round =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(Integer value) {
            addCriterion("round <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(Integer value) {
            addCriterion("round >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("round >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(Integer value) {
            addCriterion("round <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(Integer value) {
            addCriterion("round <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<Integer> values) {
            addCriterion("round in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<Integer> values) {
            addCriterion("round not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(Integer value1, Integer value2) {
            addCriterion("round between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("round not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andWinnerIsNull() {
            addCriterion("winner is null");
            return (Criteria) this;
        }

        public Criteria andWinnerIsNotNull() {
            addCriterion("winner is not null");
            return (Criteria) this;
        }

        public Criteria andWinnerEqualTo(Integer value) {
            addCriterion("winner =", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerNotEqualTo(Integer value) {
            addCriterion("winner <>", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerGreaterThan(Integer value) {
            addCriterion("winner >", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("winner >=", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerLessThan(Integer value) {
            addCriterion("winner <", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerLessThanOrEqualTo(Integer value) {
            addCriterion("winner <=", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerIn(List<Integer> values) {
            addCriterion("winner in", values, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerNotIn(List<Integer> values) {
            addCriterion("winner not in", values, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerBetween(Integer value1, Integer value2) {
            addCriterion("winner between", value1, value2, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerNotBetween(Integer value1, Integer value2) {
            addCriterion("winner not between", value1, value2, "winner");
            return (Criteria) this;
        }

        public Criteria andLoserIsNull() {
            addCriterion("loser is null");
            return (Criteria) this;
        }

        public Criteria andLoserIsNotNull() {
            addCriterion("loser is not null");
            return (Criteria) this;
        }

        public Criteria andLoserEqualTo(Integer value) {
            addCriterion("loser =", value, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserNotEqualTo(Integer value) {
            addCriterion("loser <>", value, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserGreaterThan(Integer value) {
            addCriterion("loser >", value, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserGreaterThanOrEqualTo(Integer value) {
            addCriterion("loser >=", value, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserLessThan(Integer value) {
            addCriterion("loser <", value, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserLessThanOrEqualTo(Integer value) {
            addCriterion("loser <=", value, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserIn(List<Integer> values) {
            addCriterion("loser in", values, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserNotIn(List<Integer> values) {
            addCriterion("loser not in", values, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserBetween(Integer value1, Integer value2) {
            addCriterion("loser between", value1, value2, "loser");
            return (Criteria) this;
        }

        public Criteria andLoserNotBetween(Integer value1, Integer value2) {
            addCriterion("loser not between", value1, value2, "loser");
            return (Criteria) this;
        }

        public Criteria andPenaltyIsNull() {
            addCriterion("penalty is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyIsNotNull() {
            addCriterion("penalty is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyEqualTo(Integer value) {
            addCriterion("penalty =", value, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyNotEqualTo(Integer value) {
            addCriterion("penalty <>", value, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyGreaterThan(Integer value) {
            addCriterion("penalty >", value, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyGreaterThanOrEqualTo(Integer value) {
            addCriterion("penalty >=", value, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyLessThan(Integer value) {
            addCriterion("penalty <", value, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyLessThanOrEqualTo(Integer value) {
            addCriterion("penalty <=", value, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyIn(List<Integer> values) {
            addCriterion("penalty in", values, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyNotIn(List<Integer> values) {
            addCriterion("penalty not in", values, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyBetween(Integer value1, Integer value2) {
            addCriterion("penalty between", value1, value2, "penalty");
            return (Criteria) this;
        }

        public Criteria andPenaltyNotBetween(Integer value1, Integer value2) {
            addCriterion("penalty not between", value1, value2, "penalty");
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