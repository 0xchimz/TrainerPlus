# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_account (
  id                        bigint auto_increment not null,
  username                  varchar(255) not null,
  password                  varchar(255) not null,
  constraint uq_user_account_username unique (username),
  constraint pk_user_account primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user_account;

SET FOREIGN_KEY_CHECKS=1;

