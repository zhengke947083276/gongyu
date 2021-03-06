package org.com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblVisitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblVisitExample() {
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

        public Criteria andVisIdIsNull() {
            addCriterion("vis_id is null");
            return (Criteria) this;
        }

        public Criteria andVisIdIsNotNull() {
            addCriterion("vis_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisIdEqualTo(Integer value) {
            addCriterion("vis_id =", value, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdNotEqualTo(Integer value) {
            addCriterion("vis_id <>", value, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdGreaterThan(Integer value) {
            addCriterion("vis_id >", value, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vis_id >=", value, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdLessThan(Integer value) {
            addCriterion("vis_id <", value, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdLessThanOrEqualTo(Integer value) {
            addCriterion("vis_id <=", value, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdIn(List<Integer> values) {
            addCriterion("vis_id in", values, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdNotIn(List<Integer> values) {
            addCriterion("vis_id not in", values, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdBetween(Integer value1, Integer value2) {
            addCriterion("vis_id between", value1, value2, "visId");
            return (Criteria) this;
        }

        public Criteria andVisIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vis_id not between", value1, value2, "visId");
            return (Criteria) this;
        }

        public Criteria andVisNameIsNull() {
            addCriterion("vis_name is null");
            return (Criteria) this;
        }

        public Criteria andVisNameIsNotNull() {
            addCriterion("vis_name is not null");
            return (Criteria) this;
        }

        public Criteria andVisNameEqualTo(String value) {
            addCriterion("vis_name =", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameNotEqualTo(String value) {
            addCriterion("vis_name <>", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameGreaterThan(String value) {
            addCriterion("vis_name >", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameGreaterThanOrEqualTo(String value) {
            addCriterion("vis_name >=", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameLessThan(String value) {
            addCriterion("vis_name <", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameLessThanOrEqualTo(String value) {
            addCriterion("vis_name <=", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameLike(String value) {
            addCriterion("vis_name like", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameNotLike(String value) {
            addCriterion("vis_name not like", value, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameIn(List<String> values) {
            addCriterion("vis_name in", values, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameNotIn(List<String> values) {
            addCriterion("vis_name not in", values, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameBetween(String value1, String value2) {
            addCriterion("vis_name between", value1, value2, "visName");
            return (Criteria) this;
        }

        public Criteria andVisNameNotBetween(String value1, String value2) {
            addCriterion("vis_name not between", value1, value2, "visName");
            return (Criteria) this;
        }

        public Criteria andVisCardIsNull() {
            addCriterion("vis_card is null");
            return (Criteria) this;
        }

        public Criteria andVisCardIsNotNull() {
            addCriterion("vis_card is not null");
            return (Criteria) this;
        }

        public Criteria andVisCardEqualTo(String value) {
            addCriterion("vis_card =", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardNotEqualTo(String value) {
            addCriterion("vis_card <>", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardGreaterThan(String value) {
            addCriterion("vis_card >", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardGreaterThanOrEqualTo(String value) {
            addCriterion("vis_card >=", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardLessThan(String value) {
            addCriterion("vis_card <", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardLessThanOrEqualTo(String value) {
            addCriterion("vis_card <=", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardLike(String value) {
            addCriterion("vis_card like", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardNotLike(String value) {
            addCriterion("vis_card not like", value, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardIn(List<String> values) {
            addCriterion("vis_card in", values, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardNotIn(List<String> values) {
            addCriterion("vis_card not in", values, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardBetween(String value1, String value2) {
            addCriterion("vis_card between", value1, value2, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisCardNotBetween(String value1, String value2) {
            addCriterion("vis_card not between", value1, value2, "visCard");
            return (Criteria) this;
        }

        public Criteria andVisTimeIsNull() {
            addCriterion("vis_time is null");
            return (Criteria) this;
        }

        public Criteria andVisTimeIsNotNull() {
            addCriterion("vis_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisTimeEqualTo(Date value) {
            addCriterion("vis_time =", value, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeNotEqualTo(Date value) {
            addCriterion("vis_time <>", value, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeGreaterThan(Date value) {
            addCriterion("vis_time >", value, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vis_time >=", value, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeLessThan(Date value) {
            addCriterion("vis_time <", value, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeLessThanOrEqualTo(Date value) {
            addCriterion("vis_time <=", value, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeIn(List<Date> values) {
            addCriterion("vis_time in", values, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeNotIn(List<Date> values) {
            addCriterion("vis_time not in", values, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeBetween(Date value1, Date value2) {
            addCriterion("vis_time between", value1, value2, "visTime");
            return (Criteria) this;
        }

        public Criteria andVisTimeNotBetween(Date value1, Date value2) {
            addCriterion("vis_time not between", value1, value2, "visTime");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionIsNull() {
            addCriterion("vis_description is null");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionIsNotNull() {
            addCriterion("vis_description is not null");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionEqualTo(String value) {
            addCriterion("vis_description =", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionNotEqualTo(String value) {
            addCriterion("vis_description <>", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionGreaterThan(String value) {
            addCriterion("vis_description >", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("vis_description >=", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionLessThan(String value) {
            addCriterion("vis_description <", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionLessThanOrEqualTo(String value) {
            addCriterion("vis_description <=", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionLike(String value) {
            addCriterion("vis_description like", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionNotLike(String value) {
            addCriterion("vis_description not like", value, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionIn(List<String> values) {
            addCriterion("vis_description in", values, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionNotIn(List<String> values) {
            addCriterion("vis_description not in", values, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionBetween(String value1, String value2) {
            addCriterion("vis_description between", value1, value2, "visDescription");
            return (Criteria) this;
        }

        public Criteria andVisDescriptionNotBetween(String value1, String value2) {
            addCriterion("vis_description not between", value1, value2, "visDescription");
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