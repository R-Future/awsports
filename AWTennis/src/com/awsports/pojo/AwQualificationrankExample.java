package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwQualificationrankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwQualificationrankExample() {
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

        public Criteria andCurrentrankIsNull() {
            addCriterion("currentRank is null");
            return (Criteria) this;
        }

        public Criteria andCurrentrankIsNotNull() {
            addCriterion("currentRank is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentrankEqualTo(Integer value) {
            addCriterion("currentRank =", value, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankNotEqualTo(Integer value) {
            addCriterion("currentRank <>", value, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankGreaterThan(Integer value) {
            addCriterion("currentRank >", value, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankGreaterThanOrEqualTo(Integer value) {
            addCriterion("currentRank >=", value, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankLessThan(Integer value) {
            addCriterion("currentRank <", value, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankLessThanOrEqualTo(Integer value) {
            addCriterion("currentRank <=", value, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankIn(List<Integer> values) {
            addCriterion("currentRank in", values, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankNotIn(List<Integer> values) {
            addCriterion("currentRank not in", values, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankBetween(Integer value1, Integer value2) {
            addCriterion("currentRank between", value1, value2, "currentrank");
            return (Criteria) this;
        }

        public Criteria andCurrentrankNotBetween(Integer value1, Integer value2) {
            addCriterion("currentRank not between", value1, value2, "currentrank");
            return (Criteria) this;
        }

        public Criteria andRankingchangeIsNull() {
            addCriterion("rankingChange is null");
            return (Criteria) this;
        }

        public Criteria andRankingchangeIsNotNull() {
            addCriterion("rankingChange is not null");
            return (Criteria) this;
        }

        public Criteria andRankingchangeEqualTo(Integer value) {
            addCriterion("rankingChange =", value, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeNotEqualTo(Integer value) {
            addCriterion("rankingChange <>", value, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeGreaterThan(Integer value) {
            addCriterion("rankingChange >", value, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rankingChange >=", value, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeLessThan(Integer value) {
            addCriterion("rankingChange <", value, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeLessThanOrEqualTo(Integer value) {
            addCriterion("rankingChange <=", value, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeIn(List<Integer> values) {
            addCriterion("rankingChange in", values, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeNotIn(List<Integer> values) {
            addCriterion("rankingChange not in", values, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeBetween(Integer value1, Integer value2) {
            addCriterion("rankingChange between", value1, value2, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andRankingchangeNotBetween(Integer value1, Integer value2) {
            addCriterion("rankingChange not between", value1, value2, "rankingchange");
            return (Criteria) this;
        }

        public Criteria andTotalpointIsNull() {
            addCriterion("totalPoint is null");
            return (Criteria) this;
        }

        public Criteria andTotalpointIsNotNull() {
            addCriterion("totalPoint is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpointEqualTo(Double value) {
            addCriterion("totalPoint =", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointNotEqualTo(Double value) {
            addCriterion("totalPoint <>", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointGreaterThan(Double value) {
            addCriterion("totalPoint >", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPoint >=", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointLessThan(Double value) {
            addCriterion("totalPoint <", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointLessThanOrEqualTo(Double value) {
            addCriterion("totalPoint <=", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointIn(List<Double> values) {
            addCriterion("totalPoint in", values, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointNotIn(List<Double> values) {
            addCriterion("totalPoint not in", values, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointBetween(Double value1, Double value2) {
            addCriterion("totalPoint between", value1, value2, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointNotBetween(Double value1, Double value2) {
            addCriterion("totalPoint not between", value1, value2, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalwinsIsNull() {
            addCriterion("totalWins is null");
            return (Criteria) this;
        }

        public Criteria andTotalwinsIsNotNull() {
            addCriterion("totalWins is not null");
            return (Criteria) this;
        }

        public Criteria andTotalwinsEqualTo(Integer value) {
            addCriterion("totalWins =", value, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsNotEqualTo(Integer value) {
            addCriterion("totalWins <>", value, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsGreaterThan(Integer value) {
            addCriterion("totalWins >", value, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalWins >=", value, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsLessThan(Integer value) {
            addCriterion("totalWins <", value, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsLessThanOrEqualTo(Integer value) {
            addCriterion("totalWins <=", value, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsIn(List<Integer> values) {
            addCriterion("totalWins in", values, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsNotIn(List<Integer> values) {
            addCriterion("totalWins not in", values, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsBetween(Integer value1, Integer value2) {
            addCriterion("totalWins between", value1, value2, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalwinsNotBetween(Integer value1, Integer value2) {
            addCriterion("totalWins not between", value1, value2, "totalwins");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsIsNull() {
            addCriterion("totalMatchs is null");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsIsNotNull() {
            addCriterion("totalMatchs is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsEqualTo(Integer value) {
            addCriterion("totalMatchs =", value, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsNotEqualTo(Integer value) {
            addCriterion("totalMatchs <>", value, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsGreaterThan(Integer value) {
            addCriterion("totalMatchs >", value, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalMatchs >=", value, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsLessThan(Integer value) {
            addCriterion("totalMatchs <", value, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsLessThanOrEqualTo(Integer value) {
            addCriterion("totalMatchs <=", value, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsIn(List<Integer> values) {
            addCriterion("totalMatchs in", values, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsNotIn(List<Integer> values) {
            addCriterion("totalMatchs not in", values, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsBetween(Integer value1, Integer value2) {
            addCriterion("totalMatchs between", value1, value2, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmatchsNotBetween(Integer value1, Integer value2) {
            addCriterion("totalMatchs not between", value1, value2, "totalmatchs");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauIsNull() {
            addCriterion("totalMarginBureau is null");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauIsNotNull() {
            addCriterion("totalMarginBureau is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauEqualTo(Integer value) {
            addCriterion("totalMarginBureau =", value, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauNotEqualTo(Integer value) {
            addCriterion("totalMarginBureau <>", value, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauGreaterThan(Integer value) {
            addCriterion("totalMarginBureau >", value, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalMarginBureau >=", value, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauLessThan(Integer value) {
            addCriterion("totalMarginBureau <", value, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauLessThanOrEqualTo(Integer value) {
            addCriterion("totalMarginBureau <=", value, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauIn(List<Integer> values) {
            addCriterion("totalMarginBureau in", values, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauNotIn(List<Integer> values) {
            addCriterion("totalMarginBureau not in", values, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauBetween(Integer value1, Integer value2) {
            addCriterion("totalMarginBureau between", value1, value2, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andTotalmarginbureauNotBetween(Integer value1, Integer value2) {
            addCriterion("totalMarginBureau not between", value1, value2, "totalmarginbureau");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(Integer value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(Integer value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(Integer value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(Integer value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(Integer value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<Integer> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<Integer> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(Integer value1, Integer value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("week not between", value1, value2, "week");
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