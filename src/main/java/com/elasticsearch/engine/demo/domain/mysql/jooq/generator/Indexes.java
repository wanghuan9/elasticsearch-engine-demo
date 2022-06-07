/*
 * This file is generated by jOOQ.
 */
package com.elasticsearch.engine.demo.domain.mysql.jooq.generator;


import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.Person;
import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.PersonExtend;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>user</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PERSON_PRIMARY = Indexes0.PERSON_PRIMARY;
    public static final Index PERSON_UK_PERSON_NO = Indexes0.PERSON_UK_PERSON_NO;
    public static final Index PERSON_EXTEND_PRIMARY = Indexes0.PERSON_EXTEND_PRIMARY;
    public static final Index PERSON_EXTEND_UK_PERSON_NO = Indexes0.PERSON_EXTEND_UK_PERSON_NO;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PERSON_PRIMARY = Internal.createIndex("PRIMARY", Person.PERSON, new OrderField[] { Person.PERSON.ID }, true);
        public static Index PERSON_UK_PERSON_NO = Internal.createIndex("uk_person_no", Person.PERSON, new OrderField[] { Person.PERSON.PERSON_NO }, true);
        public static Index PERSON_EXTEND_PRIMARY = Internal.createIndex("PRIMARY", PersonExtend.PERSON_EXTEND, new OrderField[] { PersonExtend.PERSON_EXTEND.ID }, true);
        public static Index PERSON_EXTEND_UK_PERSON_NO = Internal.createIndex("uk_person_no", PersonExtend.PERSON_EXTEND, new OrderField[] { PersonExtend.PERSON_EXTEND.PERSON_NO }, true);
    }
}