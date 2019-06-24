/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/6/11 9:53:01                            */
/*==============================================================*/
use sms;

drop table if exists ic_sms_access_control;

drop table if exists ic_sms_authority;

/*==============================================================*/
/* Table: ic_sms_access_control                                 */
/*==============================================================*/
create table ic_sms_access_control
(
   gid                  varchar(32) not null,
   authid               varchar(32),
   authname             varchar(32),
   userid               varchar(32),
   usercode             varchar(32),
   state                varchar(4),
   primary key (gid)
);

alter table ic_sms_access_control comment '权限控制表';

/*==============================================================*/
/* Table: ic_sms_authority                                      */
/*==============================================================*/
create table ic_sms_authority
(
   gid                  varchar(32) not null,
   name                 varchar(32),
   keyword              varchar(32) comment '作为权限控制的关键依据，一般地为路由主键',
   machine              varchar(4) comment '该权限控制是否自动生效，或为手动为用户添加',
   roles                varchar(32) comment '在自动控制机制下，所定义的控制范围',
   state                varchar(4),
   primary key (gid)
);

alter table ic_sms_authority comment '权限定义';
