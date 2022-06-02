CREATE TABLE `person`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `person_no`   VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '用户编码',
    `person_name` VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '用户名',
    `phone`       BIGINT(20)          NOT NULL DEFAULT 0 COMMENT '用户手机',
    `salary`      DECIMAL(10, 2)               DEFAULT NULL COMMENT '工资',
    `company`     VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '公司',
    `status`      TINYINT(4)          NOT NULL DEFAULT '0' COMMENT '状态',
    `sex`         TINYINT(4)          NOT NULL DEFAULT '0' COMMENT '状态',
    `address`     VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '地址',
    `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user` VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '创建人',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_person_no` (`person_no`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT = '人员表';

CREATE TABLE `person_extend`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `person_no`   VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '用户编码',
    `mail`        VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '邮箱',
    `hobby`       VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '爱好',
    `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_person_no` (`person_no`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT = '人员扩展表';