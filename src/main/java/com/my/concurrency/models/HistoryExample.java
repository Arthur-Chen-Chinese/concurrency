package com.my.concurrency.models;

import java.util.ArrayList;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
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

        public Criteria andCusStartIdIsNull() {
            addCriterion("cus_start_id is null");
            return (Criteria) this;
        }

        public Criteria andCusStartIdIsNotNull() {
            addCriterion("cus_start_id is not null");
            return (Criteria) this;
        }

        public Criteria andCusStartIdEqualTo(Integer value) {
            addCriterion("cus_start_id =", value, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdNotEqualTo(Integer value) {
            addCriterion("cus_start_id <>", value, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdGreaterThan(Integer value) {
            addCriterion("cus_start_id >", value, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cus_start_id >=", value, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdLessThan(Integer value) {
            addCriterion("cus_start_id <", value, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cus_start_id <=", value, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdIn(List<Integer> values) {
            addCriterion("cus_start_id in", values, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdNotIn(List<Integer> values) {
            addCriterion("cus_start_id not in", values, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdBetween(Integer value1, Integer value2) {
            addCriterion("cus_start_id between", value1, value2, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusStartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cus_start_id not between", value1, value2, "cusStartId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdIsNull() {
            addCriterion("cus_end_id is null");
            return (Criteria) this;
        }

        public Criteria andCusEndIdIsNotNull() {
            addCriterion("cus_end_id is not null");
            return (Criteria) this;
        }

        public Criteria andCusEndIdEqualTo(Integer value) {
            addCriterion("cus_end_id =", value, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdNotEqualTo(Integer value) {
            addCriterion("cus_end_id <>", value, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdGreaterThan(Integer value) {
            addCriterion("cus_end_id >", value, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cus_end_id >=", value, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdLessThan(Integer value) {
            addCriterion("cus_end_id <", value, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdLessThanOrEqualTo(Integer value) {
            addCriterion("cus_end_id <=", value, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdIn(List<Integer> values) {
            addCriterion("cus_end_id in", values, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdNotIn(List<Integer> values) {
            addCriterion("cus_end_id not in", values, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdBetween(Integer value1, Integer value2) {
            addCriterion("cus_end_id between", value1, value2, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCusEndIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cus_end_id not between", value1, value2, "cusEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdIsNull() {
            addCriterion("checkout_start_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdIsNotNull() {
            addCriterion("checkout_start_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdEqualTo(Integer value) {
            addCriterion("checkout_start_id =", value, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdNotEqualTo(Integer value) {
            addCriterion("checkout_start_id <>", value, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdGreaterThan(Integer value) {
            addCriterion("checkout_start_id >", value, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkout_start_id >=", value, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdLessThan(Integer value) {
            addCriterion("checkout_start_id <", value, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdLessThanOrEqualTo(Integer value) {
            addCriterion("checkout_start_id <=", value, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdIn(List<Integer> values) {
            addCriterion("checkout_start_id in", values, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdNotIn(List<Integer> values) {
            addCriterion("checkout_start_id not in", values, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdBetween(Integer value1, Integer value2) {
            addCriterion("checkout_start_id between", value1, value2, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutStartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("checkout_start_id not between", value1, value2, "checkoutStartId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdIsNull() {
            addCriterion("checkout_end_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdIsNotNull() {
            addCriterion("checkout_end_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdEqualTo(Integer value) {
            addCriterion("checkout_end_id =", value, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdNotEqualTo(Integer value) {
            addCriterion("checkout_end_id <>", value, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdGreaterThan(Integer value) {
            addCriterion("checkout_end_id >", value, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkout_end_id >=", value, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdLessThan(Integer value) {
            addCriterion("checkout_end_id <", value, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdLessThanOrEqualTo(Integer value) {
            addCriterion("checkout_end_id <=", value, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdIn(List<Integer> values) {
            addCriterion("checkout_end_id in", values, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdNotIn(List<Integer> values) {
            addCriterion("checkout_end_id not in", values, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdBetween(Integer value1, Integer value2) {
            addCriterion("checkout_end_id between", value1, value2, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andCheckoutEndIdNotBetween(Integer value1, Integer value2) {
            addCriterion("checkout_end_id not between", value1, value2, "checkoutEndId");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsIsNull() {
            addCriterion("num_of_checkouts is null");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsIsNotNull() {
            addCriterion("num_of_checkouts is not null");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsEqualTo(Integer value) {
            addCriterion("num_of_checkouts =", value, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsNotEqualTo(Integer value) {
            addCriterion("num_of_checkouts <>", value, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsGreaterThan(Integer value) {
            addCriterion("num_of_checkouts >", value, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_of_checkouts >=", value, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsLessThan(Integer value) {
            addCriterion("num_of_checkouts <", value, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsLessThanOrEqualTo(Integer value) {
            addCriterion("num_of_checkouts <=", value, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsIn(List<Integer> values) {
            addCriterion("num_of_checkouts in", values, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsNotIn(List<Integer> values) {
            addCriterion("num_of_checkouts not in", values, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsBetween(Integer value1, Integer value2) {
            addCriterion("num_of_checkouts between", value1, value2, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfCheckoutsNotBetween(Integer value1, Integer value2) {
            addCriterion("num_of_checkouts not between", value1, value2, "numOfCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyIsNull() {
            addCriterion("num_of_products_in_trolley is null");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyIsNotNull() {
            addCriterion("num_of_products_in_trolley is not null");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyEqualTo(String value) {
            addCriterion("num_of_products_in_trolley =", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyNotEqualTo(String value) {
            addCriterion("num_of_products_in_trolley <>", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyGreaterThan(String value) {
            addCriterion("num_of_products_in_trolley >", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyGreaterThanOrEqualTo(String value) {
            addCriterion("num_of_products_in_trolley >=", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyLessThan(String value) {
            addCriterion("num_of_products_in_trolley <", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyLessThanOrEqualTo(String value) {
            addCriterion("num_of_products_in_trolley <=", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyLike(String value) {
            addCriterion("num_of_products_in_trolley like", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyNotLike(String value) {
            addCriterion("num_of_products_in_trolley not like", value, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyIn(List<String> values) {
            addCriterion("num_of_products_in_trolley in", values, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyNotIn(List<String> values) {
            addCriterion("num_of_products_in_trolley not in", values, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyBetween(String value1, String value2) {
            addCriterion("num_of_products_in_trolley between", value1, value2, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andNumOfProductsInTrolleyNotBetween(String value1, String value2) {
            addCriterion("num_of_products_in_trolley not between", value1, value2, "numOfProductsInTrolley");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductIsNull() {
            addCriterion("time_for_each_product is null");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductIsNotNull() {
            addCriterion("time_for_each_product is not null");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductEqualTo(String value) {
            addCriterion("time_for_each_product =", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductNotEqualTo(String value) {
            addCriterion("time_for_each_product <>", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductGreaterThan(String value) {
            addCriterion("time_for_each_product >", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductGreaterThanOrEqualTo(String value) {
            addCriterion("time_for_each_product >=", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductLessThan(String value) {
            addCriterion("time_for_each_product <", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductLessThanOrEqualTo(String value) {
            addCriterion("time_for_each_product <=", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductLike(String value) {
            addCriterion("time_for_each_product like", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductNotLike(String value) {
            addCriterion("time_for_each_product not like", value, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductIn(List<String> values) {
            addCriterion("time_for_each_product in", values, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductNotIn(List<String> values) {
            addCriterion("time_for_each_product not in", values, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductBetween(String value1, String value2) {
            addCriterion("time_for_each_product between", value1, value2, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andTimeForEachProductNotBetween(String value1, String value2) {
            addCriterion("time_for_each_product not between", value1, value2, "timeForEachProduct");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsIsNull() {
            addCriterion("num_of_5_or_less_checkouts is null");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsIsNotNull() {
            addCriterion("num_of_5_or_less_checkouts is not null");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsEqualTo(Integer value) {
            addCriterion("num_of_5_or_less_checkouts =", value, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsNotEqualTo(Integer value) {
            addCriterion("num_of_5_or_less_checkouts <>", value, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsGreaterThan(Integer value) {
            addCriterion("num_of_5_or_less_checkouts >", value, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_of_5_or_less_checkouts >=", value, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsLessThan(Integer value) {
            addCriterion("num_of_5_or_less_checkouts <", value, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsLessThanOrEqualTo(Integer value) {
            addCriterion("num_of_5_or_less_checkouts <=", value, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsIn(List<Integer> values) {
            addCriterion("num_of_5_or_less_checkouts in", values, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsNotIn(List<Integer> values) {
            addCriterion("num_of_5_or_less_checkouts not in", values, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsBetween(Integer value1, Integer value2) {
            addCriterion("num_of_5_or_less_checkouts between", value1, value2, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andNumOf5OrLessCheckoutsNotBetween(Integer value1, Integer value2) {
            addCriterion("num_of_5_or_less_checkouts not between", value1, value2, "numOf5OrLessCheckouts");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeIsNull() {
            addCriterion("specific_rate_range is null");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeIsNotNull() {
            addCriterion("specific_rate_range is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeEqualTo(String value) {
            addCriterion("specific_rate_range =", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeNotEqualTo(String value) {
            addCriterion("specific_rate_range <>", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeGreaterThan(String value) {
            addCriterion("specific_rate_range >", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeGreaterThanOrEqualTo(String value) {
            addCriterion("specific_rate_range >=", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeLessThan(String value) {
            addCriterion("specific_rate_range <", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeLessThanOrEqualTo(String value) {
            addCriterion("specific_rate_range <=", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeLike(String value) {
            addCriterion("specific_rate_range like", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeNotLike(String value) {
            addCriterion("specific_rate_range not like", value, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeIn(List<String> values) {
            addCriterion("specific_rate_range in", values, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeNotIn(List<String> values) {
            addCriterion("specific_rate_range not in", values, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeBetween(String value1, String value2) {
            addCriterion("specific_rate_range between", value1, value2, "specificRateRange");
            return (Criteria) this;
        }

        public Criteria andSpecificRateRangeNotBetween(String value1, String value2) {
            addCriterion("specific_rate_range not between", value1, value2, "specificRateRange");
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