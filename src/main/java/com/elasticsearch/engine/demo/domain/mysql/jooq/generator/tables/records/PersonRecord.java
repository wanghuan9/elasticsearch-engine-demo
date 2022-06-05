/*
 * This file is generated by jOOQ.
 */
package com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.records;


import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.Person;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


/**
 * 人员表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonRecord extends UpdatableRecordImpl<PersonRecord> implements Record11<ULong, String, String, Long, BigDecimal, String, Byte, Byte, String, LocalDateTime, String> {

    private static final long serialVersionUID = -1686146085;

    /**
     * Setter for <code>user.person.id</code>. 自增id
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>user.person.id</code>. 自增id
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>user.person.person_no</code>. 用户编码
     */
    public void setPersonNo(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>user.person.person_no</code>. 用户编码
     */
    public String getPersonNo() {
        return (String) get(1);
    }

    /**
     * Setter for <code>user.person.person_name</code>. 用户名
     */
    public void setPersonName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>user.person.person_name</code>. 用户名
     */
    public String getPersonName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>user.person.phone</code>. 用户手机
     */
    public void setPhone(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>user.person.phone</code>. 用户手机
     */
    public Long getPhone() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>user.person.salary</code>. 工资
     */
    public void setSalary(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>user.person.salary</code>. 工资
     */
    public BigDecimal getSalary() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>user.person.company</code>. 公司
     */
    public void setCompany(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>user.person.company</code>. 公司
     */
    public String getCompany() {
        return (String) get(5);
    }

    /**
     * Setter for <code>user.person.status</code>. 状态
     */
    public void setStatus(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>user.person.status</code>. 状态
     */
    public Byte getStatus() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>user.person.sex</code>. 状态
     */
    public void setSex(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>user.person.sex</code>. 状态
     */
    public Byte getSex() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>user.person.address</code>. 地址
     */
    public void setAddress(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>user.person.address</code>. 地址
     */
    public String getAddress() {
        return (String) get(8);
    }

    /**
     * Setter for <code>user.person.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(9, value);
    }

    /**
     * Getter for <code>user.person.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(9);
    }

    /**
     * Setter for <code>user.person.create_user</code>. 创建人
     */
    public void setCreateUser(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>user.person.create_user</code>. 创建人
     */
    public String getCreateUser() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<ULong, String, String, Long, BigDecimal, String, Byte, Byte, String, LocalDateTime, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<ULong, String, String, Long, BigDecimal, String, Byte, Byte, String, LocalDateTime, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return Person.PERSON.ID;
    }

    @Override
    public Field<String> field2() {
        return Person.PERSON.PERSON_NO;
    }

    @Override
    public Field<String> field3() {
        return Person.PERSON.PERSON_NAME;
    }

    @Override
    public Field<Long> field4() {
        return Person.PERSON.PHONE;
    }

    @Override
    public Field<BigDecimal> field5() {
        return Person.PERSON.SALARY;
    }

    @Override
    public Field<String> field6() {
        return Person.PERSON.COMPANY;
    }

    @Override
    public Field<Byte> field7() {
        return Person.PERSON.STATUS;
    }

    @Override
    public Field<Byte> field8() {
        return Person.PERSON.SEX;
    }

    @Override
    public Field<String> field9() {
        return Person.PERSON.ADDRESS;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return Person.PERSON.CREATE_TIME;
    }

    @Override
    public Field<String> field11() {
        return Person.PERSON.CREATE_USER;
    }

    @Override
    public ULong component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPersonNo();
    }

    @Override
    public String component3() {
        return getPersonName();
    }

    @Override
    public Long component4() {
        return getPhone();
    }

    @Override
    public BigDecimal component5() {
        return getSalary();
    }

    @Override
    public String component6() {
        return getCompany();
    }

    @Override
    public Byte component7() {
        return getStatus();
    }

    @Override
    public Byte component8() {
        return getSex();
    }

    @Override
    public String component9() {
        return getAddress();
    }

    @Override
    public LocalDateTime component10() {
        return getCreateTime();
    }

    @Override
    public String component11() {
        return getCreateUser();
    }

    @Override
    public ULong value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPersonNo();
    }

    @Override
    public String value3() {
        return getPersonName();
    }

    @Override
    public Long value4() {
        return getPhone();
    }

    @Override
    public BigDecimal value5() {
        return getSalary();
    }

    @Override
    public String value6() {
        return getCompany();
    }

    @Override
    public Byte value7() {
        return getStatus();
    }

    @Override
    public Byte value8() {
        return getSex();
    }

    @Override
    public String value9() {
        return getAddress();
    }

    @Override
    public LocalDateTime value10() {
        return getCreateTime();
    }

    @Override
    public String value11() {
        return getCreateUser();
    }

    @Override
    public PersonRecord value1(ULong value) {
        setId(value);
        return this;
    }

    @Override
    public PersonRecord value2(String value) {
        setPersonNo(value);
        return this;
    }

    @Override
    public PersonRecord value3(String value) {
        setPersonName(value);
        return this;
    }

    @Override
    public PersonRecord value4(Long value) {
        setPhone(value);
        return this;
    }

    @Override
    public PersonRecord value5(BigDecimal value) {
        setSalary(value);
        return this;
    }

    @Override
    public PersonRecord value6(String value) {
        setCompany(value);
        return this;
    }

    @Override
    public PersonRecord value7(Byte value) {
        setStatus(value);
        return this;
    }

    @Override
    public PersonRecord value8(Byte value) {
        setSex(value);
        return this;
    }

    @Override
    public PersonRecord value9(String value) {
        setAddress(value);
        return this;
    }

    @Override
    public PersonRecord value10(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public PersonRecord value11(String value) {
        setCreateUser(value);
        return this;
    }

    @Override
    public PersonRecord values(ULong value1, String value2, String value3, Long value4, BigDecimal value5, String value6, Byte value7, Byte value8, String value9, LocalDateTime value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(ULong id, String personNo, String personName, Long phone, BigDecimal salary, String company, Byte status, Byte sex, String address, LocalDateTime createTime, String createUser) {
        super(Person.PERSON);

        set(0, id);
        set(1, personNo);
        set(2, personName);
        set(3, phone);
        set(4, salary);
        set(5, company);
        set(6, status);
        set(7, sex);
        set(8, address);
        set(9, createTime);
        set(10, createUser);
    }
}
