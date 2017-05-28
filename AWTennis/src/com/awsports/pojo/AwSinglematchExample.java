package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwSinglematchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwSinglematchExample() {
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

        public Criteria andHomecontestantIsNull() {
            addCriterion("homeContestant is null");
            return (Criteria) this;
        }

        public Criteria andHomecontestantIsNotNull() {
            addCriterion("homeContestant is not null");
            return (Criteria) this;
        }

        public Criteria andHomecontestantEqualTo(Integer value) {
            addCriterion("homeContestant =", value, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantNotEqualTo(Integer value) {
            addCriterion("homeContestant <>", value, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantGreaterThan(Integer value) {
            addCriterion("homeContestant >", value, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeContestant >=", value, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantLessThan(Integer value) {
            addCriterion("homeContestant <", value, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantLessThanOrEqualTo(Integer value) {
            addCriterion("homeContestant <=", value, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantIn(List<Integer> values) {
            addCriterion("homeContestant in", values, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantNotIn(List<Integer> values) {
            addCriterion("homeContestant not in", values, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantBetween(Integer value1, Integer value2) {
            addCriterion("homeContestant between", value1, value2, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andHomecontestantNotBetween(Integer value1, Integer value2) {
            addCriterion("homeContestant not between", value1, value2, "homecontestant");
            return (Criteria) this;
        }

        public Criteria andAwayplayerIsNull() {
            addCriterion("awayPlayer is null");
            return (Criteria) this;
        }

        public Criteria andAwayplayerIsNotNull() {
            addCriterion("awayPlayer is not null");
            return (Criteria) this;
        }

        public Criteria andAwayplayerEqualTo(Integer value) {
            addCriterion("awayPlayer =", value, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerNotEqualTo(Integer value) {
            addCriterion("awayPlayer <>", value, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerGreaterThan(Integer value) {
            addCriterion("awayPlayer >", value, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerGreaterThanOrEqualTo(Integer value) {
            addCriterion("awayPlayer >=", value, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerLessThan(Integer value) {
            addCriterion("awayPlayer <", value, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerLessThanOrEqualTo(Integer value) {
            addCriterion("awayPlayer <=", value, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerIn(List<Integer> values) {
            addCriterion("awayPlayer in", values, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerNotIn(List<Integer> values) {
            addCriterion("awayPlayer not in", values, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerBetween(Integer value1, Integer value2) {
            addCriterion("awayPlayer between", value1, value2, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andAwayplayerNotBetween(Integer value1, Integer value2) {
            addCriterion("awayPlayer not between", value1, value2, "awayplayer");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIsNull() {
            addCriterion("matchTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIsNotNull() {
            addCriterion("matchTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtimeEqualTo(Date value) {
            addCriterion("matchTime =", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotEqualTo(Date value) {
            addCriterion("matchTime <>", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeGreaterThan(Date value) {
            addCriterion("matchTime >", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchTime >=", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeLessThan(Date value) {
            addCriterion("matchTime <", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeLessThanOrEqualTo(Date value) {
            addCriterion("matchTime <=", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIn(List<Date> values) {
            addCriterion("matchTime in", values, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotIn(List<Date> values) {
            addCriterion("matchTime not in", values, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeBetween(Date value1, Date value2) {
            addCriterion("matchTime between", value1, value2, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotBetween(Date value1, Date value2) {
            addCriterion("matchTime not between", value1, value2, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchplaceIsNull() {
            addCriterion("matchPlace is null");
            return (Criteria) this;
        }

        public Criteria andMatchplaceIsNotNull() {
            addCriterion("matchPlace is not null");
            return (Criteria) this;
        }

        public Criteria andMatchplaceEqualTo(Integer value) {
            addCriterion("matchPlace =", value, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceNotEqualTo(Integer value) {
            addCriterion("matchPlace <>", value, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceGreaterThan(Integer value) {
            addCriterion("matchPlace >", value, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchPlace >=", value, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceLessThan(Integer value) {
            addCriterion("matchPlace <", value, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceLessThanOrEqualTo(Integer value) {
            addCriterion("matchPlace <=", value, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceIn(List<Integer> values) {
            addCriterion("matchPlace in", values, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceNotIn(List<Integer> values) {
            addCriterion("matchPlace not in", values, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceBetween(Integer value1, Integer value2) {
            addCriterion("matchPlace between", value1, value2, "matchplace");
            return (Criteria) this;
        }

        public Criteria andMatchplaceNotBetween(Integer value1, Integer value2) {
            addCriterion("matchPlace not between", value1, value2, "matchplace");
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

        public Criteria andSetsIsNull() {
            addCriterion("sets is null");
            return (Criteria) this;
        }

        public Criteria andSetsIsNotNull() {
            addCriterion("sets is not null");
            return (Criteria) this;
        }

        public Criteria andSetsEqualTo(Integer value) {
            addCriterion("sets =", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotEqualTo(Integer value) {
            addCriterion("sets <>", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsGreaterThan(Integer value) {
            addCriterion("sets >", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sets >=", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsLessThan(Integer value) {
            addCriterion("sets <", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsLessThanOrEqualTo(Integer value) {
            addCriterion("sets <=", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsIn(List<Integer> values) {
            addCriterion("sets in", values, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotIn(List<Integer> values) {
            addCriterion("sets not in", values, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsBetween(Integer value1, Integer value2) {
            addCriterion("sets between", value1, value2, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotBetween(Integer value1, Integer value2) {
            addCriterion("sets not between", value1, value2, "sets");
            return (Criteria) this;
        }

        public Criteria andOutcomeIsNull() {
            addCriterion("outcome is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeIsNotNull() {
            addCriterion("outcome is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeEqualTo(Boolean value) {
            addCriterion("outcome =", value, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeNotEqualTo(Boolean value) {
            addCriterion("outcome <>", value, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeGreaterThan(Boolean value) {
            addCriterion("outcome >", value, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("outcome >=", value, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeLessThan(Boolean value) {
            addCriterion("outcome <", value, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeLessThanOrEqualTo(Boolean value) {
            addCriterion("outcome <=", value, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeIn(List<Boolean> values) {
            addCriterion("outcome in", values, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeNotIn(List<Boolean> values) {
            addCriterion("outcome not in", values, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeBetween(Boolean value1, Boolean value2) {
            addCriterion("outcome between", value1, value2, "outcome");
            return (Criteria) this;
        }

        public Criteria andOutcomeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("outcome not between", value1, value2, "outcome");
            return (Criteria) this;
        }

        public Criteria andWinnerpointIsNull() {
            addCriterion("winnerPoint is null");
            return (Criteria) this;
        }

        public Criteria andWinnerpointIsNotNull() {
            addCriterion("winnerPoint is not null");
            return (Criteria) this;
        }

        public Criteria andWinnerpointEqualTo(Integer value) {
            addCriterion("winnerPoint =", value, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointNotEqualTo(Integer value) {
            addCriterion("winnerPoint <>", value, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointGreaterThan(Integer value) {
            addCriterion("winnerPoint >", value, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointGreaterThanOrEqualTo(Integer value) {
            addCriterion("winnerPoint >=", value, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointLessThan(Integer value) {
            addCriterion("winnerPoint <", value, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointLessThanOrEqualTo(Integer value) {
            addCriterion("winnerPoint <=", value, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointIn(List<Integer> values) {
            addCriterion("winnerPoint in", values, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointNotIn(List<Integer> values) {
            addCriterion("winnerPoint not in", values, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointBetween(Integer value1, Integer value2) {
            addCriterion("winnerPoint between", value1, value2, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andWinnerpointNotBetween(Integer value1, Integer value2) {
            addCriterion("winnerPoint not between", value1, value2, "winnerpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointIsNull() {
            addCriterion("loserPoint is null");
            return (Criteria) this;
        }

        public Criteria andLoserpointIsNotNull() {
            addCriterion("loserPoint is not null");
            return (Criteria) this;
        }

        public Criteria andLoserpointEqualTo(Integer value) {
            addCriterion("loserPoint =", value, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointNotEqualTo(Integer value) {
            addCriterion("loserPoint <>", value, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointGreaterThan(Integer value) {
            addCriterion("loserPoint >", value, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointGreaterThanOrEqualTo(Integer value) {
            addCriterion("loserPoint >=", value, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointLessThan(Integer value) {
            addCriterion("loserPoint <", value, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointLessThanOrEqualTo(Integer value) {
            addCriterion("loserPoint <=", value, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointIn(List<Integer> values) {
            addCriterion("loserPoint in", values, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointNotIn(List<Integer> values) {
            addCriterion("loserPoint not in", values, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointBetween(Integer value1, Integer value2) {
            addCriterion("loserPoint between", value1, value2, "loserpoint");
            return (Criteria) this;
        }

        public Criteria andLoserpointNotBetween(Integer value1, Integer value2) {
            addCriterion("loserPoint not between", value1, value2, "loserpoint");
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