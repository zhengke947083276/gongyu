package org.com.entity;

import java.util.ArrayList;
import java.util.List;

public class TblAdministratorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblAdministratorExample() {
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

        public Criteria andAdmIdIsNull() {
            addCriterion("adm_id is null");
            return (Criteria) this;
        }

        public Criteria andAdmIdIsNotNull() {
            addCriterion("adm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdmIdEqualTo(Integer value) {
            addCriterion("adm_id =", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotEqualTo(Integer value) {
            addCriterion("adm_id <>", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdGreaterThan(Integer value) {
            addCriterion("adm_id >", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adm_id >=", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdLessThan(Integer value) {
            addCriterion("adm_id <", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdLessThanOrEqualTo(Integer value) {
            addCriterion("adm_id <=", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdIn(List<Integer> values) {
            addCriterion("adm_id in", values, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotIn(List<Integer> values) {
            addCriterion("adm_id not in", values, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdBetween(Integer value1, Integer value2) {
            addCriterion("adm_id between", value1, value2, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adm_id not between", value1, value2, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmUserIsNull() {
            addCriterion("adm_user is null");
            return (Criteria) this;
        }

        public Criteria andAdmUserIsNotNull() {
            addCriterion("adm_user is not null");
            return (Criteria) this;
        }

        public Criteria andAdmUserEqualTo(String value) {
            addCriterion("adm_user =", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserNotEqualTo(String value) {
            addCriterion("adm_user <>", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserGreaterThan(String value) {
            addCriterion("adm_user >", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserGreaterThanOrEqualTo(String value) {
            addCriterion("adm_user >=", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserLessThan(String value) {
            addCriterion("adm_user <", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserLessThanOrEqualTo(String value) {
            addCriterion("adm_user <=", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserLike(String value) {
            addCriterion("adm_user like", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserNotLike(String value) {
            addCriterion("adm_user not like", value, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserIn(List<String> values) {
            addCriterion("adm_user in", values, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserNotIn(List<String> values) {
            addCriterion("adm_user not in", values, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserBetween(String value1, String value2) {
            addCriterion("adm_user between", value1, value2, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmUserNotBetween(String value1, String value2) {
            addCriterion("adm_user not between", value1, value2, "admUser");
            return (Criteria) this;
        }

        public Criteria andAdmPassIsNull() {
            addCriterion("adm_pass is null");
            return (Criteria) this;
        }

        public Criteria andAdmPassIsNotNull() {
            addCriterion("adm_pass is not null");
            return (Criteria) this;
        }

        public Criteria andAdmPassEqualTo(String value) {
            addCriterion("adm_pass =", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassNotEqualTo(String value) {
            addCriterion("adm_pass <>", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassGreaterThan(String value) {
            addCriterion("adm_pass >", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassGreaterThanOrEqualTo(String value) {
            addCriterion("adm_pass >=", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassLessThan(String value) {
            addCriterion("adm_pass <", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassLessThanOrEqualTo(String value) {
            addCriterion("adm_pass <=", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassLike(String value) {
            addCriterion("adm_pass like", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassNotLike(String value) {
            addCriterion("adm_pass not like", value, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassIn(List<String> values) {
            addCriterion("adm_pass in", values, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassNotIn(List<String> values) {
            addCriterion("adm_pass not in", values, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassBetween(String value1, String value2) {
            addCriterion("adm_pass between", value1, value2, "admPass");
            return (Criteria) this;
        }

        public Criteria andAdmPassNotBetween(String value1, String value2) {
            addCriterion("adm_pass not between", value1, value2, "admPass");
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