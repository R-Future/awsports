package com.awsports.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwEventWorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwEventWorkerExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUseravatarIsNull() {
            addCriterion("userAvatar is null");
            return (Criteria) this;
        }

        public Criteria andUseravatarIsNotNull() {
            addCriterion("userAvatar is not null");
            return (Criteria) this;
        }

        public Criteria andUseravatarEqualTo(String value) {
            addCriterion("userAvatar =", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotEqualTo(String value) {
            addCriterion("userAvatar <>", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarGreaterThan(String value) {
            addCriterion("userAvatar >", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarGreaterThanOrEqualTo(String value) {
            addCriterion("userAvatar >=", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarLessThan(String value) {
            addCriterion("userAvatar <", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarLessThanOrEqualTo(String value) {
            addCriterion("userAvatar <=", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarLike(String value) {
            addCriterion("userAvatar like", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotLike(String value) {
            addCriterion("userAvatar not like", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarIn(List<String> values) {
            addCriterion("userAvatar in", values, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotIn(List<String> values) {
            addCriterion("userAvatar not in", values, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarBetween(String value1, String value2) {
            addCriterion("userAvatar between", value1, value2, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotBetween(String value1, String value2) {
            addCriterion("userAvatar not between", value1, value2, "useravatar");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIsNull() {
            addCriterion("privilege is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIsNotNull() {
            addCriterion("privilege is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeEqualTo(Integer value) {
            addCriterion("privilege =", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotEqualTo(Integer value) {
            addCriterion("privilege <>", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeGreaterThan(Integer value) {
            addCriterion("privilege >", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeGreaterThanOrEqualTo(Integer value) {
            addCriterion("privilege >=", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLessThan(Integer value) {
            addCriterion("privilege <", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLessThanOrEqualTo(Integer value) {
            addCriterion("privilege <=", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIn(List<Integer> values) {
            addCriterion("privilege in", values, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotIn(List<Integer> values) {
            addCriterion("privilege not in", values, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeBetween(Integer value1, Integer value2) {
            addCriterion("privilege between", value1, value2, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotBetween(Integer value1, Integer value2) {
            addCriterion("privilege not between", value1, value2, "privilege");
            return (Criteria) this;
        }

        public Criteria andIsrefereeIsNull() {
            addCriterion("isReferee is null");
            return (Criteria) this;
        }

        public Criteria andIsrefereeIsNotNull() {
            addCriterion("isReferee is not null");
            return (Criteria) this;
        }

        public Criteria andIsrefereeEqualTo(Boolean value) {
            addCriterion("isReferee =", value, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeNotEqualTo(Boolean value) {
            addCriterion("isReferee <>", value, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeGreaterThan(Boolean value) {
            addCriterion("isReferee >", value, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isReferee >=", value, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeLessThan(Boolean value) {
            addCriterion("isReferee <", value, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeLessThanOrEqualTo(Boolean value) {
            addCriterion("isReferee <=", value, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeIn(List<Boolean> values) {
            addCriterion("isReferee in", values, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeNotIn(List<Boolean> values) {
            addCriterion("isReferee not in", values, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeBetween(Boolean value1, Boolean value2) {
            addCriterion("isReferee between", value1, value2, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIsrefereeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isReferee not between", value1, value2, "isreferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeIsNull() {
            addCriterion("isLineReferee is null");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeIsNotNull() {
            addCriterion("isLineReferee is not null");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeEqualTo(Boolean value) {
            addCriterion("isLineReferee =", value, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeNotEqualTo(Boolean value) {
            addCriterion("isLineReferee <>", value, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeGreaterThan(Boolean value) {
            addCriterion("isLineReferee >", value, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isLineReferee >=", value, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeLessThan(Boolean value) {
            addCriterion("isLineReferee <", value, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeLessThanOrEqualTo(Boolean value) {
            addCriterion("isLineReferee <=", value, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeIn(List<Boolean> values) {
            addCriterion("isLineReferee in", values, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeNotIn(List<Boolean> values) {
            addCriterion("isLineReferee not in", values, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeBetween(Boolean value1, Boolean value2) {
            addCriterion("isLineReferee between", value1, value2, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIslinerefereeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isLineReferee not between", value1, value2, "islinereferee");
            return (Criteria) this;
        }

        public Criteria andIscaddyIsNull() {
            addCriterion("isCaddy is null");
            return (Criteria) this;
        }

        public Criteria andIscaddyIsNotNull() {
            addCriterion("isCaddy is not null");
            return (Criteria) this;
        }

        public Criteria andIscaddyEqualTo(Boolean value) {
            addCriterion("isCaddy =", value, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyNotEqualTo(Boolean value) {
            addCriterion("isCaddy <>", value, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyGreaterThan(Boolean value) {
            addCriterion("isCaddy >", value, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isCaddy >=", value, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyLessThan(Boolean value) {
            addCriterion("isCaddy <", value, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyLessThanOrEqualTo(Boolean value) {
            addCriterion("isCaddy <=", value, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyIn(List<Boolean> values) {
            addCriterion("isCaddy in", values, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyNotIn(List<Boolean> values) {
            addCriterion("isCaddy not in", values, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyBetween(Boolean value1, Boolean value2) {
            addCriterion("isCaddy between", value1, value2, "iscaddy");
            return (Criteria) this;
        }

        public Criteria andIscaddyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isCaddy not between", value1, value2, "iscaddy");
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