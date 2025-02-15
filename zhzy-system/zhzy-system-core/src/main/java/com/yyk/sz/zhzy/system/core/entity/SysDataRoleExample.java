package com.yyk.sz.zhzy.system.core.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDataRoleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public SysDataRoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
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

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateIsNull() {
            addCriterion("SysCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateIsNotNull() {
            addCriterion("SysCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateEqualTo(Date value) {
            addCriterion("SysCreateDate =", value, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateNotEqualTo(Date value) {
            addCriterion("SysCreateDate <>", value, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateGreaterThan(Date value) {
            addCriterion("SysCreateDate >", value, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("SysCreateDate >=", value, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateLessThan(Date value) {
            addCriterion("SysCreateDate <", value, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateLessThanOrEqualTo(Date value) {
            addCriterion("SysCreateDate <=", value, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateIn(List<Date> values) {
            addCriterion("SysCreateDate in", values, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateNotIn(List<Date> values) {
            addCriterion("SysCreateDate not in", values, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateBetween(Date value1, Date value2) {
            addCriterion("SysCreateDate between", value1, value2, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatedateNotBetween(Date value1, Date value2) {
            addCriterion("SysCreateDate not between", value1, value2, "syscreatedate");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyIsNull() {
            addCriterion("SysCreateBy is null");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyIsNotNull() {
            addCriterion("SysCreateBy is not null");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyEqualTo(String value) {
            addCriterion("SysCreateBy =", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyNotEqualTo(String value) {
            addCriterion("SysCreateBy <>", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyGreaterThan(String value) {
            addCriterion("SysCreateBy >", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyGreaterThanOrEqualTo(String value) {
            addCriterion("SysCreateBy >=", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyLessThan(String value) {
            addCriterion("SysCreateBy <", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyLessThanOrEqualTo(String value) {
            addCriterion("SysCreateBy <=", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyLike(String value) {
            addCriterion("SysCreateBy like", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyNotLike(String value) {
            addCriterion("SysCreateBy not like", value, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyIn(List<String> values) {
            addCriterion("SysCreateBy in", values, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyNotIn(List<String> values) {
            addCriterion("SysCreateBy not in", values, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyBetween(String value1, String value2) {
            addCriterion("SysCreateBy between", value1, value2, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSyscreatebyNotBetween(String value1, String value2) {
            addCriterion("SysCreateBy not between", value1, value2, "syscreateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateIsNull() {
            addCriterion("SysUpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateIsNotNull() {
            addCriterion("SysUpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateEqualTo(Date value) {
            addCriterion("SysUpdateDate =", value, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateNotEqualTo(Date value) {
            addCriterion("SysUpdateDate <>", value, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateGreaterThan(Date value) {
            addCriterion("SysUpdateDate >", value, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("SysUpdateDate >=", value, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateLessThan(Date value) {
            addCriterion("SysUpdateDate <", value, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateLessThanOrEqualTo(Date value) {
            addCriterion("SysUpdateDate <=", value, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateIn(List<Date> values) {
            addCriterion("SysUpdateDate in", values, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateNotIn(List<Date> values) {
            addCriterion("SysUpdateDate not in", values, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateBetween(Date value1, Date value2) {
            addCriterion("SysUpdateDate between", value1, value2, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatedateNotBetween(Date value1, Date value2) {
            addCriterion("SysUpdateDate not between", value1, value2, "sysupdatedate");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyIsNull() {
            addCriterion("SysUpdateBy is null");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyIsNotNull() {
            addCriterion("SysUpdateBy is not null");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyEqualTo(String value) {
            addCriterion("SysUpdateBy =", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyNotEqualTo(String value) {
            addCriterion("SysUpdateBy <>", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyGreaterThan(String value) {
            addCriterion("SysUpdateBy >", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyGreaterThanOrEqualTo(String value) {
            addCriterion("SysUpdateBy >=", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyLessThan(String value) {
            addCriterion("SysUpdateBy <", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyLessThanOrEqualTo(String value) {
            addCriterion("SysUpdateBy <=", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyLike(String value) {
            addCriterion("SysUpdateBy like", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyNotLike(String value) {
            addCriterion("SysUpdateBy not like", value, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyIn(List<String> values) {
            addCriterion("SysUpdateBy in", values, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyNotIn(List<String> values) {
            addCriterion("SysUpdateBy not in", values, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyBetween(String value1, String value2) {
            addCriterion("SysUpdateBy between", value1, value2, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andSysupdatebyNotBetween(String value1, String value2) {
            addCriterion("SysUpdateBy not between", value1, value2, "sysupdateby");
            return (Criteria) this;
        }

        public Criteria andVersionnumIsNull() {
            addCriterion("VersionNum is null");
            return (Criteria) this;
        }

        public Criteria andVersionnumIsNotNull() {
            addCriterion("VersionNum is not null");
            return (Criteria) this;
        }

        public Criteria andVersionnumEqualTo(Integer value) {
            addCriterion("VersionNum =", value, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumNotEqualTo(Integer value) {
            addCriterion("VersionNum <>", value, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumGreaterThan(Integer value) {
            addCriterion("VersionNum >", value, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("VersionNum >=", value, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumLessThan(Integer value) {
            addCriterion("VersionNum <", value, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumLessThanOrEqualTo(Integer value) {
            addCriterion("VersionNum <=", value, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumIn(List<Integer> values) {
            addCriterion("VersionNum in", values, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumNotIn(List<Integer> values) {
            addCriterion("VersionNum not in", values, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumBetween(Integer value1, Integer value2) {
            addCriterion("VersionNum between", value1, value2, "versionnum");
            return (Criteria) this;
        }

        public Criteria andVersionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("VersionNum not between", value1, value2, "versionnum");
            return (Criteria) this;
        }

        public Criteria andSysdelflagIsNull() {
            addCriterion("SysDelFlag is null");
            return (Criteria) this;
        }

        public Criteria andSysdelflagIsNotNull() {
            addCriterion("SysDelFlag is not null");
            return (Criteria) this;
        }

        public Criteria andSysdelflagEqualTo(String value) {
            addCriterion("SysDelFlag =", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagNotEqualTo(String value) {
            addCriterion("SysDelFlag <>", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagGreaterThan(String value) {
            addCriterion("SysDelFlag >", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagGreaterThanOrEqualTo(String value) {
            addCriterion("SysDelFlag >=", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagLessThan(String value) {
            addCriterion("SysDelFlag <", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagLessThanOrEqualTo(String value) {
            addCriterion("SysDelFlag <=", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagLike(String value) {
            addCriterion("SysDelFlag like", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagNotLike(String value) {
            addCriterion("SysDelFlag not like", value, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagIn(List<String> values) {
            addCriterion("SysDelFlag in", values, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagNotIn(List<String> values) {
            addCriterion("SysDelFlag not in", values, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagBetween(String value1, String value2) {
            addCriterion("SysDelFlag between", value1, value2, "sysdelflag");
            return (Criteria) this;
        }

        public Criteria andSysdelflagNotBetween(String value1, String value2) {
            addCriterion("SysDelFlag not between", value1, value2, "sysdelflag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_data_role
     *
     * @mbggenerated do_not_delete_during_merge Tue Dec 18 11:46:00 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_data_role
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
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