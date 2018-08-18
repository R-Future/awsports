package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwStatisticExample() {
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
            addCriterion("matchId is null");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNotNull() {
            addCriterion("matchId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchidEqualTo(String value) {
            addCriterion("matchId =", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotEqualTo(String value) {
            addCriterion("matchId <>", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThan(String value) {
            addCriterion("matchId >", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThanOrEqualTo(String value) {
            addCriterion("matchId >=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThan(String value) {
            addCriterion("matchId <", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThanOrEqualTo(String value) {
            addCriterion("matchId <=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLike(String value) {
            addCriterion("matchId like", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotLike(String value) {
            addCriterion("matchId not like", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidIn(List<String> values) {
            addCriterion("matchId in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotIn(List<String> values) {
            addCriterion("matchId not in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidBetween(String value1, String value2) {
            addCriterion("matchId between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotBetween(String value1, String value2) {
            addCriterion("matchId not between", value1, value2, "matchid");
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

        public Criteria andAcesIsNull() {
            addCriterion("aces is null");
            return (Criteria) this;
        }

        public Criteria andAcesIsNotNull() {
            addCriterion("aces is not null");
            return (Criteria) this;
        }

        public Criteria andAcesEqualTo(Integer value) {
            addCriterion("aces =", value, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesNotEqualTo(Integer value) {
            addCriterion("aces <>", value, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesGreaterThan(Integer value) {
            addCriterion("aces >", value, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesGreaterThanOrEqualTo(Integer value) {
            addCriterion("aces >=", value, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesLessThan(Integer value) {
            addCriterion("aces <", value, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesLessThanOrEqualTo(Integer value) {
            addCriterion("aces <=", value, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesIn(List<Integer> values) {
            addCriterion("aces in", values, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesNotIn(List<Integer> values) {
            addCriterion("aces not in", values, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesBetween(Integer value1, Integer value2) {
            addCriterion("aces between", value1, value2, "aces");
            return (Criteria) this;
        }

        public Criteria andAcesNotBetween(Integer value1, Integer value2) {
            addCriterion("aces not between", value1, value2, "aces");
            return (Criteria) this;
        }

        public Criteria andFirstservicesIsNull() {
            addCriterion("firstServices is null");
            return (Criteria) this;
        }

        public Criteria andFirstservicesIsNotNull() {
            addCriterion("firstServices is not null");
            return (Criteria) this;
        }

        public Criteria andFirstservicesEqualTo(Integer value) {
            addCriterion("firstServices =", value, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesNotEqualTo(Integer value) {
            addCriterion("firstServices <>", value, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesGreaterThan(Integer value) {
            addCriterion("firstServices >", value, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesGreaterThanOrEqualTo(Integer value) {
            addCriterion("firstServices >=", value, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesLessThan(Integer value) {
            addCriterion("firstServices <", value, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesLessThanOrEqualTo(Integer value) {
            addCriterion("firstServices <=", value, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesIn(List<Integer> values) {
            addCriterion("firstServices in", values, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesNotIn(List<Integer> values) {
            addCriterion("firstServices not in", values, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesBetween(Integer value1, Integer value2) {
            addCriterion("firstServices between", value1, value2, "firstservices");
            return (Criteria) this;
        }

        public Criteria andFirstservicesNotBetween(Integer value1, Integer value2) {
            addCriterion("firstServices not between", value1, value2, "firstservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesIsNull() {
            addCriterion("secondServices is null");
            return (Criteria) this;
        }

        public Criteria andSecondservicesIsNotNull() {
            addCriterion("secondServices is not null");
            return (Criteria) this;
        }

        public Criteria andSecondservicesEqualTo(Integer value) {
            addCriterion("secondServices =", value, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesNotEqualTo(Integer value) {
            addCriterion("secondServices <>", value, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesGreaterThan(Integer value) {
            addCriterion("secondServices >", value, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesGreaterThanOrEqualTo(Integer value) {
            addCriterion("secondServices >=", value, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesLessThan(Integer value) {
            addCriterion("secondServices <", value, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesLessThanOrEqualTo(Integer value) {
            addCriterion("secondServices <=", value, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesIn(List<Integer> values) {
            addCriterion("secondServices in", values, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesNotIn(List<Integer> values) {
            addCriterion("secondServices not in", values, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesBetween(Integer value1, Integer value2) {
            addCriterion("secondServices between", value1, value2, "secondservices");
            return (Criteria) this;
        }

        public Criteria andSecondservicesNotBetween(Integer value1, Integer value2) {
            addCriterion("secondServices not between", value1, value2, "secondservices");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsIsNull() {
            addCriterion("doubleFaults is null");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsIsNotNull() {
            addCriterion("doubleFaults is not null");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsEqualTo(Integer value) {
            addCriterion("doubleFaults =", value, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsNotEqualTo(Integer value) {
            addCriterion("doubleFaults <>", value, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsGreaterThan(Integer value) {
            addCriterion("doubleFaults >", value, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsGreaterThanOrEqualTo(Integer value) {
            addCriterion("doubleFaults >=", value, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsLessThan(Integer value) {
            addCriterion("doubleFaults <", value, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsLessThanOrEqualTo(Integer value) {
            addCriterion("doubleFaults <=", value, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsIn(List<Integer> values) {
            addCriterion("doubleFaults in", values, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsNotIn(List<Integer> values) {
            addCriterion("doubleFaults not in", values, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsBetween(Integer value1, Integer value2) {
            addCriterion("doubleFaults between", value1, value2, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andDoublefaultsNotBetween(Integer value1, Integer value2) {
            addCriterion("doubleFaults not between", value1, value2, "doublefaults");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsIsNull() {
            addCriterion("firstGoals is null");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsIsNotNull() {
            addCriterion("firstGoals is not null");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsEqualTo(Integer value) {
            addCriterion("firstGoals =", value, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsNotEqualTo(Integer value) {
            addCriterion("firstGoals <>", value, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsGreaterThan(Integer value) {
            addCriterion("firstGoals >", value, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsGreaterThanOrEqualTo(Integer value) {
            addCriterion("firstGoals >=", value, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsLessThan(Integer value) {
            addCriterion("firstGoals <", value, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsLessThanOrEqualTo(Integer value) {
            addCriterion("firstGoals <=", value, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsIn(List<Integer> values) {
            addCriterion("firstGoals in", values, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsNotIn(List<Integer> values) {
            addCriterion("firstGoals not in", values, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsBetween(Integer value1, Integer value2) {
            addCriterion("firstGoals between", value1, value2, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andFirstgoalsNotBetween(Integer value1, Integer value2) {
            addCriterion("firstGoals not between", value1, value2, "firstgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsIsNull() {
            addCriterion("secondGoals is null");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsIsNotNull() {
            addCriterion("secondGoals is not null");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsEqualTo(Integer value) {
            addCriterion("secondGoals =", value, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsNotEqualTo(Integer value) {
            addCriterion("secondGoals <>", value, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsGreaterThan(Integer value) {
            addCriterion("secondGoals >", value, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsGreaterThanOrEqualTo(Integer value) {
            addCriterion("secondGoals >=", value, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsLessThan(Integer value) {
            addCriterion("secondGoals <", value, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsLessThanOrEqualTo(Integer value) {
            addCriterion("secondGoals <=", value, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsIn(List<Integer> values) {
            addCriterion("secondGoals in", values, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsNotIn(List<Integer> values) {
            addCriterion("secondGoals not in", values, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsBetween(Integer value1, Integer value2) {
            addCriterion("secondGoals between", value1, value2, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSecondgoalsNotBetween(Integer value1, Integer value2) {
            addCriterion("secondGoals not between", value1, value2, "secondgoals");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsIsNull() {
            addCriterion("saveBreakPoints is null");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsIsNotNull() {
            addCriterion("saveBreakPoints is not null");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsEqualTo(Integer value) {
            addCriterion("saveBreakPoints =", value, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsNotEqualTo(Integer value) {
            addCriterion("saveBreakPoints <>", value, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsGreaterThan(Integer value) {
            addCriterion("saveBreakPoints >", value, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("saveBreakPoints >=", value, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsLessThan(Integer value) {
            addCriterion("saveBreakPoints <", value, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsLessThanOrEqualTo(Integer value) {
            addCriterion("saveBreakPoints <=", value, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsIn(List<Integer> values) {
            addCriterion("saveBreakPoints in", values, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsNotIn(List<Integer> values) {
            addCriterion("saveBreakPoints not in", values, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsBetween(Integer value1, Integer value2) {
            addCriterion("saveBreakPoints between", value1, value2, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andSavebreakpointsNotBetween(Integer value1, Integer value2) {
            addCriterion("saveBreakPoints not between", value1, value2, "savebreakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsIsNull() {
            addCriterion("breakPoints is null");
            return (Criteria) this;
        }

        public Criteria andBreakpointsIsNotNull() {
            addCriterion("breakPoints is not null");
            return (Criteria) this;
        }

        public Criteria andBreakpointsEqualTo(Integer value) {
            addCriterion("breakPoints =", value, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsNotEqualTo(Integer value) {
            addCriterion("breakPoints <>", value, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsGreaterThan(Integer value) {
            addCriterion("breakPoints >", value, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("breakPoints >=", value, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsLessThan(Integer value) {
            addCriterion("breakPoints <", value, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsLessThanOrEqualTo(Integer value) {
            addCriterion("breakPoints <=", value, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsIn(List<Integer> values) {
            addCriterion("breakPoints in", values, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsNotIn(List<Integer> values) {
            addCriterion("breakPoints not in", values, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsBetween(Integer value1, Integer value2) {
            addCriterion("breakPoints between", value1, value2, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andBreakpointsNotBetween(Integer value1, Integer value2) {
            addCriterion("breakPoints not between", value1, value2, "breakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsIsNull() {
            addCriterion("serviceBreakPoints is null");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsIsNotNull() {
            addCriterion("serviceBreakPoints is not null");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsEqualTo(Integer value) {
            addCriterion("serviceBreakPoints =", value, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsNotEqualTo(Integer value) {
            addCriterion("serviceBreakPoints <>", value, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsGreaterThan(Integer value) {
            addCriterion("serviceBreakPoints >", value, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("serviceBreakPoints >=", value, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsLessThan(Integer value) {
            addCriterion("serviceBreakPoints <", value, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsLessThanOrEqualTo(Integer value) {
            addCriterion("serviceBreakPoints <=", value, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsIn(List<Integer> values) {
            addCriterion("serviceBreakPoints in", values, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsNotIn(List<Integer> values) {
            addCriterion("serviceBreakPoints not in", values, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsBetween(Integer value1, Integer value2) {
            addCriterion("serviceBreakPoints between", value1, value2, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andServicebreakpointsNotBetween(Integer value1, Integer value2) {
            addCriterion("serviceBreakPoints not between", value1, value2, "servicebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsIsNull() {
            addCriterion("receiveBreakPoints is null");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsIsNotNull() {
            addCriterion("receiveBreakPoints is not null");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsEqualTo(Integer value) {
            addCriterion("receiveBreakPoints =", value, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsNotEqualTo(Integer value) {
            addCriterion("receiveBreakPoints <>", value, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsGreaterThan(Integer value) {
            addCriterion("receiveBreakPoints >", value, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiveBreakPoints >=", value, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsLessThan(Integer value) {
            addCriterion("receiveBreakPoints <", value, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsLessThanOrEqualTo(Integer value) {
            addCriterion("receiveBreakPoints <=", value, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsIn(List<Integer> values) {
            addCriterion("receiveBreakPoints in", values, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsNotIn(List<Integer> values) {
            addCriterion("receiveBreakPoints not in", values, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsBetween(Integer value1, Integer value2) {
            addCriterion("receiveBreakPoints between", value1, value2, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andReceivebreakpointsNotBetween(Integer value1, Integer value2) {
            addCriterion("receiveBreakPoints not between", value1, value2, "receivebreakpoints");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsIsNull() {
            addCriterion("firstReturnGoals is null");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsIsNotNull() {
            addCriterion("firstReturnGoals is not null");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsEqualTo(Integer value) {
            addCriterion("firstReturnGoals =", value, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsNotEqualTo(Integer value) {
            addCriterion("firstReturnGoals <>", value, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsGreaterThan(Integer value) {
            addCriterion("firstReturnGoals >", value, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsGreaterThanOrEqualTo(Integer value) {
            addCriterion("firstReturnGoals >=", value, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsLessThan(Integer value) {
            addCriterion("firstReturnGoals <", value, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsLessThanOrEqualTo(Integer value) {
            addCriterion("firstReturnGoals <=", value, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsIn(List<Integer> values) {
            addCriterion("firstReturnGoals in", values, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsNotIn(List<Integer> values) {
            addCriterion("firstReturnGoals not in", values, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsBetween(Integer value1, Integer value2) {
            addCriterion("firstReturnGoals between", value1, value2, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andFirstreturngoalsNotBetween(Integer value1, Integer value2) {
            addCriterion("firstReturnGoals not between", value1, value2, "firstreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsIsNull() {
            addCriterion("secondReturnGoals is null");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsIsNotNull() {
            addCriterion("secondReturnGoals is not null");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsEqualTo(Integer value) {
            addCriterion("secondReturnGoals =", value, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsNotEqualTo(Integer value) {
            addCriterion("secondReturnGoals <>", value, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsGreaterThan(Integer value) {
            addCriterion("secondReturnGoals >", value, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsGreaterThanOrEqualTo(Integer value) {
            addCriterion("secondReturnGoals >=", value, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsLessThan(Integer value) {
            addCriterion("secondReturnGoals <", value, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsLessThanOrEqualTo(Integer value) {
            addCriterion("secondReturnGoals <=", value, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsIn(List<Integer> values) {
            addCriterion("secondReturnGoals in", values, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsNotIn(List<Integer> values) {
            addCriterion("secondReturnGoals not in", values, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsBetween(Integer value1, Integer value2) {
            addCriterion("secondReturnGoals between", value1, value2, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andSecondreturngoalsNotBetween(Integer value1, Integer value2) {
            addCriterion("secondReturnGoals not between", value1, value2, "secondreturngoals");
            return (Criteria) this;
        }

        public Criteria andServicesIsNull() {
            addCriterion("services is null");
            return (Criteria) this;
        }

        public Criteria andServicesIsNotNull() {
            addCriterion("services is not null");
            return (Criteria) this;
        }

        public Criteria andServicesEqualTo(Integer value) {
            addCriterion("services =", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotEqualTo(Integer value) {
            addCriterion("services <>", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThan(Integer value) {
            addCriterion("services >", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThanOrEqualTo(Integer value) {
            addCriterion("services >=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThan(Integer value) {
            addCriterion("services <", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThanOrEqualTo(Integer value) {
            addCriterion("services <=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesIn(List<Integer> values) {
            addCriterion("services in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotIn(List<Integer> values) {
            addCriterion("services not in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesBetween(Integer value1, Integer value2) {
            addCriterion("services between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotBetween(Integer value1, Integer value2) {
            addCriterion("services not between", value1, value2, "services");
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