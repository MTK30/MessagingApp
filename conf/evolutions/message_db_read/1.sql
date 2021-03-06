# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- init script create procs
-- Inital script to create stored procedures etc for mysql platform
DROP PROCEDURE IF EXISTS usp_ebean_drop_foreign_keys;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_foreign_keys TABLE, COLUMN
-- deletes all constraints and foreign keys referring to TABLE.COLUMN
--
CREATE PROCEDURE usp_ebean_drop_foreign_keys(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE c_fk_name CHAR(255);
  DECLARE curs CURSOR FOR SELECT CONSTRAINT_NAME from information_schema.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE() and TABLE_NAME = p_table_name and COLUMN_NAME = p_column_name
      AND REFERENCED_TABLE_NAME IS NOT NULL;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN curs;

  read_loop: LOOP
    FETCH curs INTO c_fk_name;
    IF done THEN
      LEAVE read_loop;
    END IF;
    SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP FOREIGN KEY ', c_fk_name);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
  END LOOP;

  CLOSE curs;
END
$$

DROP PROCEDURE IF EXISTS usp_ebean_drop_column;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_column TABLE, COLUMN
-- deletes the column and ensures that all indices and constraints are dropped first
--
CREATE PROCEDURE usp_ebean_drop_column(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  CALL usp_ebean_drop_foreign_keys(p_table_name, p_column_name);
  SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP COLUMN ', p_column_name);
  PREPARE stmt FROM @sql;
  EXECUTE stmt;
END
$$
create table answer (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  question_id                   bigint,
  answer                        varchar(255),
  date_of_answer                datetime(6),
  date_of_update                datetime(6),
  like_count                    integer,
  dislike_count                 integer,
  constraint pk_answer primary key (id)
);

create table contacts (
  id                            bigint auto_increment not null,
  userid                        bigint,
  contactid                     bigint,
  constraint pk_contacts primary key (id)
);

create table feedback (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  entity_id                     bigint,
  entity_type                   varchar(255),
  like_dislike                  integer,
  constraint pk_feedback primary key (id)
);

create table group_tbl (
  id                            bigint auto_increment not null,
  grpname                       varchar(255),
  description                   varchar(255),
  createdat                     time,
  updatedat                     time,
  constraint pk_group_tbl primary key (id)
);

create table login_credentials (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  user_name                     varchar(255),
  pwd                           varchar(255),
  constraint pk_login_credentials primary key (id)
);

create table messages (
  id                            bigint auto_increment not null,
  fromuserid                    bigint,
  receiversid                   bigint,
  message                       varchar(255),
  createdat                     datetime(6),
  updatedat                     datetime(6),
  isgroupid                     tinyint(1),
  constraint pk_messages primary key (id)
);

create table question (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  question                      varchar(255),
  tagging                       varchar(255),
  date_of_question              datetime(6),
  like_count                    integer,
  dislike_count                 integer,
  constraint pk_question primary key (id)
);

create table test (
  id                            bigint,
  name                          varchar(255),
  text                          varchar(255)
);

create table user (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  isonline                      tinyint(1),
  mobileno                      bigint,
  constraint pk_user primary key (id)
);

create table user_grp_mapping (
  id                            bigint auto_increment not null,
  groupid                       bigint,
  userid                        bigint,
  isadmin                       tinyint(1),
  createdat                     datetime(6),
  updatedat                     datetime(6),
  constraint pk_user_grp_mapping primary key (id)
);


# --- !Downs

drop table if exists answer;

drop table if exists contacts;

drop table if exists feedback;

drop table if exists group_tbl;

drop table if exists login_credentials;

drop table if exists messages;

drop table if exists question;

drop table if exists test;

drop table if exists user;

drop table if exists user_grp_mapping;

