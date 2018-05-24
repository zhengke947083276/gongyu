package org.com.entity;

import java.util.ArrayList;
import java.util.List;

public class TblSpecialtyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblSpecialtyExample() {
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

        public Criteria andSpeIdIsNull() {
            addCriterion("spe_id is null");
            return (Criteria) this;
        }

        public Criteria andSpeIdIsNotNull() {
            addCriterion("spe_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpeIdEqualTo(Integer value) {
            addCriterion("spe_id =", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotEqualTo(Integer value) {
            addCriterion("spe_id <>", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdGreaterThan(Integer value) {
            addCriterion("spe_id >", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("spe_id >=", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdLessThan(Integer value) {
            addCriterion("spe_id <", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdLessThanOrEqualTo(Integer value) {
            addCriterion("spe_id <=", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdIn(List<Integer> values) {
            addCriterion("spe_id in", values, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotIn(List<Integer> values) {
            addCriterion("spe_id not in", values, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdBetween(Integer value1, Integer value2) {
            addCriterion("spe_id between", value1, value2, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("spe_id not between", value1, value2, "speId");
            return (Criteria) this;
        }

        public Criteria andFacIdIsNull() {
            addCriterion("fac_id is null");
            return (Criteria) this;
        }

        public Criteria andFacIdIsNotNull() {
            addCriterion("fac_id is not null");
            return (Criteria) this;
        }

        public Criteria andFacIdEqualTo(Integer value) {
            addCriterion("fac_id =", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdNotEqualTo(Integer value) {
            addCriterion("fac_id <>", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdGreaterThan(Integer value) {
            addCriterion("fac_id >", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fac_id >=", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdLessThan(Integer value) {
            addCriterion("fac_id <", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdLessThanOrEqualTo(Integer value) {
            addCriterion("fac_id <=", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdIn(List<Integer> values) {
            addCriterion("fac_id in", values, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdNotIn(List<Integer> values) {
            addCriterion("fac_id not in", values, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdBetween(Integer value1, Integer value2) {
            addCriterion("fac_id between", value1, value2, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fac_id not between", value1, value2, "facId");
            return (Criteria) this;
        }

        public Criteria andSpeNameIsNull() {
            addCriterion("spe_name is null");
            return (Criteria) this;
        }

        public Criteria andSpeNameIsNotNull() {
            addCriterion("spe_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpeNameEqualTo(String value) {
            addCriterion("spe_name =", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotEqualTo(String value) {
            addCriterion("spe_name <>", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameGreaterThan(String value) {
            addCriterion("spe_name >", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameGreaterThanOrEqualTo(String value) {
            addCriterion("spe_name >=", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameLessThan(String value) {
            addCriterion("spe_name <", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameLessThanOrEqualTo(String value) {
            addCriterion("spe_name <=", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameLike(String value) {
            addCriterion("spe_name like", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotLike(String value) {
            addCriterion("spe_name not like", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameIn(List<String> values) {
            addCriterion("spe_name in", values, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotIn(List<String> values) {
            addCriterion("spe_name not in", values, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameBetween(String value1, String value2) {
            addCriterion("spe_name between", value1, value2, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotBetween(String value1, String value2) {
            addCriterion("spe_name not between", value1, value2, "speName");
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