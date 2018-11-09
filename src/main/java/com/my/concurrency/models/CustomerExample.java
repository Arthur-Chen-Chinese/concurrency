package com.my.concurrency.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andArrivedTimeIsNull() {
            addCriterion("arrived_time is null");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeIsNotNull() {
            addCriterion("arrived_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeEqualTo(Date value) {
            addCriterion("arrived_time =", value, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeNotEqualTo(Date value) {
            addCriterion("arrived_time <>", value, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeGreaterThan(Date value) {
            addCriterion("arrived_time >", value, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("arrived_time >=", value, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeLessThan(Date value) {
            addCriterion("arrived_time <", value, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeLessThanOrEqualTo(Date value) {
            addCriterion("arrived_time <=", value, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeIn(List<Date> values) {
            addCriterion("arrived_time in", values, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeNotIn(List<Date> values) {
            addCriterion("arrived_time not in", values, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeBetween(Date value1, Date value2) {
            addCriterion("arrived_time between", value1, value2, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andArrivedTimeNotBetween(Date value1, Date value2) {
            addCriterion("arrived_time not between", value1, value2, "arrivedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIsNull() {
            addCriterion("finished_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIsNotNull() {
            addCriterion("finished_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeEqualTo(Date value) {
            addCriterion("finished_time =", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotEqualTo(Date value) {
            addCriterion("finished_time <>", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeGreaterThan(Date value) {
            addCriterion("finished_time >", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finished_time >=", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeLessThan(Date value) {
            addCriterion("finished_time <", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeLessThanOrEqualTo(Date value) {
            addCriterion("finished_time <=", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIn(List<Date> values) {
            addCriterion("finished_time in", values, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotIn(List<Date> values) {
            addCriterion("finished_time not in", values, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeBetween(Date value1, Date value2) {
            addCriterion("finished_time between", value1, value2, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotBetween(Date value1, Date value2) {
            addCriterion("finished_time not between", value1, value2, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsIsNull() {
            addCriterion("num_of_products is null");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsIsNotNull() {
            addCriterion("num_of_products is not null");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsEqualTo(Integer value) {
            addCriterion("num_of_products =", value, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsNotEqualTo(Integer value) {
            addCriterion("num_of_products <>", value, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsGreaterThan(Integer value) {
            addCriterion("num_of_products >", value, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_of_products >=", value, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsLessThan(Integer value) {
            addCriterion("num_of_products <", value, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsLessThanOrEqualTo(Integer value) {
            addCriterion("num_of_products <=", value, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsIn(List<Integer> values) {
            addCriterion("num_of_products in", values, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsNotIn(List<Integer> values) {
            addCriterion("num_of_products not in", values, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsBetween(Integer value1, Integer value2) {
            addCriterion("num_of_products between", value1, value2, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsNotBetween(Integer value1, Integer value2) {
            addCriterion("num_of_products not between", value1, value2, "numOfProducts");
            return (Criteria) this;
        }

        public Criteria andLostFlagIsNull() {
            addCriterion("lost_flag is null");
            return (Criteria) this;
        }

        public Criteria andLostFlagIsNotNull() {
            addCriterion("lost_flag is not null");
            return (Criteria) this;
        }

        public Criteria andLostFlagEqualTo(Byte value) {
            addCriterion("lost_flag =", value, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagNotEqualTo(Byte value) {
            addCriterion("lost_flag <>", value, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagGreaterThan(Byte value) {
            addCriterion("lost_flag >", value, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("lost_flag >=", value, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagLessThan(Byte value) {
            addCriterion("lost_flag <", value, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagLessThanOrEqualTo(Byte value) {
            addCriterion("lost_flag <=", value, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagIn(List<Byte> values) {
            addCriterion("lost_flag in", values, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagNotIn(List<Byte> values) {
            addCriterion("lost_flag not in", values, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagBetween(Byte value1, Byte value2) {
            addCriterion("lost_flag between", value1, value2, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andLostFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("lost_flag not between", value1, value2, "lostFlag");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNull() {
            addCriterion("check_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNotNull() {
            addCriterion("check_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeEqualTo(Date value) {
            addCriterion("check_start_time =", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotEqualTo(Date value) {
            addCriterion("check_start_time <>", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThan(Date value) {
            addCriterion("check_start_time >", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_start_time >=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThan(Date value) {
            addCriterion("check_start_time <", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_start_time <=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIn(List<Date> values) {
            addCriterion("check_start_time in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotIn(List<Date> values) {
            addCriterion("check_start_time not in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeBetween(Date value1, Date value2) {
            addCriterion("check_start_time between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_start_time not between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("check_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("check_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterion("check_end_time =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterion("check_end_time <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterion("check_end_time >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_end_time >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterion("check_end_time <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_end_time <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterion("check_end_time in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterion("check_end_time not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_end_time between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_end_time not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdIsNull() {
            addCriterion("checkout_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdIsNotNull() {
            addCriterion("checkout_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdEqualTo(Integer value) {
            addCriterion("checkout_id =", value, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdNotEqualTo(Integer value) {
            addCriterion("checkout_id <>", value, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdGreaterThan(Integer value) {
            addCriterion("checkout_id >", value, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkout_id >=", value, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdLessThan(Integer value) {
            addCriterion("checkout_id <", value, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdLessThanOrEqualTo(Integer value) {
            addCriterion("checkout_id <=", value, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdIn(List<Integer> values) {
            addCriterion("checkout_id in", values, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdNotIn(List<Integer> values) {
            addCriterion("checkout_id not in", values, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdBetween(Integer value1, Integer value2) {
            addCriterion("checkout_id between", value1, value2, "checkoutId");
            return (Criteria) this;
        }

        public Criteria andCheckoutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("checkout_id not between", value1, value2, "checkoutId");
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