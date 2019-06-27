/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/6/27 9:10:21                            */
/*==============================================================*/


drop table if exists ic_sms_access_control;

drop table if exists ic_sms_authority;

drop table if exists ic_sms_bid;

drop table if exists ic_sms_business_visit;

drop table if exists ic_sms_come_visit;

drop table if exists ic_sms_config_menu;

drop table if exists ic_sms_contract;

drop table if exists ic_sms_customer;

drop table if exists ic_sms_customer_activity;

drop table if exists ic_sms_customer_contact;

drop table if exists ic_sms_enum;

drop table if exists ic_sms_meeting;

drop table if exists ic_sms_purchase;

drop table if exists ic_sms_pwd;

drop table if exists ic_sms_user;

drop table if exists ic_sms_work_feedback;

drop table if exists ic_sms_work_remind;

/*==============================================================*/
/* Table: ic_sms_access_control                                 */
/*==============================================================*/
create table ic_sms_access_control
(
   gid                  varchar(32) not null,
   authid               varchar(640),
   authname             varchar(640),
   userid               varchar(640),
   username             varchar(640),
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

/*==============================================================*/
/* Table: ic_sms_bid                                            */
/*==============================================================*/
create table ic_sms_bid
(
   gid                  varchar(32) not null,
   year                 varchar(8),
   bid_time             varchar(19),
   name                 varchar(32),
   trade                varchar(32),
   project              varchar(32),
   attend_company       varchar(32),
   hl_name              varchar(32),
   result               varchar(32),
   remark               varchar(320),
   primary key (gid)
);

alter table ic_sms_bid comment '投标';

/*==============================================================*/
/* Table: ic_sms_business_visit                                 */
/*==============================================================*/
create table ic_sms_business_visit
(
   gid                  varchar(32) not null,
   year                 varchar(8),
   visit_time           varchar(32),
   visit_unit           varchar(32),
   province             varchar(16),
   city                 varchar(16),
   objective            varchar(64),
   c_user               varchar(32),
   hl_user              varchar(32),
   result               varchar(64),
   remark               varchar(64),
   uid                  varchar(32),
   primary key (gid)
);

alter table ic_sms_business_visit comment '出差拜访';

/*==============================================================*/
/* Table: ic_sms_come_visit                                     */
/*==============================================================*/
create table ic_sms_come_visit
(
   gid                  varchar(32) not null,
   year                 varchar(8),
   visit_time           varchar(32),
   visit_unit           varchar(32),
   objective            varchar(32),
   c_user               varchar(32),
   hl_user              varchar(32),
   result               varchar(32),
   remark               varchar(320),
   uid                  varchar(32),
   primary key (gid)
);

alter table ic_sms_come_visit comment '客户来访';

/*==============================================================*/
/* Table: ic_sms_config_menu                                    */
/*==============================================================*/
create table ic_sms_config_menu
(
   gid                  varchar(32) not null,
   pid                  varchar(32),
   name                 varchar(32),
   code                 varchar(32),
   description          varchar(128),
   primary key (gid)
);

alter table ic_sms_config_menu comment '系统配置';

/*==============================================================*/
/* Table: ic_sms_contract                                       */
/*==============================================================*/
create table ic_sms_contract
(
   gid                  varchar(32) not null,
   customer_name        varchar(32),
   name                 varchar(32),
   type                 varchar(4),
   trade                varchar(4),
   term                 varchar(32),
   contract_time        varchar(19),
   over_time            varchar(19),
   status               varchar(32),
   cooperation_type     varchar(32),
   return_time          varchar(19),
   quality              varchar(32),
   remark               varchar(32),
   uid                  varchar(32),
   primary key (gid)
);

alter table ic_sms_contract comment '合同管理';

/*==============================================================*/
/* Table: ic_sms_customer                                       */
/*==============================================================*/
create table ic_sms_customer
(
   gid                  varchar(32) not null,
   code                 varchar(16),
   postalcode           varchar(32),
   name                 varchar(128),
   create_time          varchar(19),
   area                 varchar(128),
   address              varchar(640),
   site                 varchar(128),
   origin               varchar(32),
   grade                varchar(32),
   stff_name            varchar(32),
   uid                  varchar(32),
   trade                varchar(32),
   status               varchar(4),
   reg_date             varchar(19),
   remark               varchar(320),
   country              varchar(16),
   province             varchar(16),
   city                 varchar(32),
   next_time            varchar(19),
   last_time            varchar(19),
   primary key (gid)
);

alter table ic_sms_customer comment '客户|电话扩张管理';

/*==============================================================*/
/* Table: ic_sms_customer_activity                              */
/*==============================================================*/
create table ic_sms_customer_activity
(
   gid                  varchar(32) not null,
   cid                  varchar(32),
   subject              varchar(320),
   contact              varchar(32),
   touch_time           varchar(19),
   record               varchar(128),
   type                 varchar(4),
   next_time            varchar(19),
   potential            varchar(32),
   remark               varchar(320),
   create_time          varchar(19),
   primary key (gid)
);

alter table ic_sms_customer_activity comment '客户|活动';

/*==============================================================*/
/* Table: ic_sms_customer_contact                               */
/*==============================================================*/
create table ic_sms_customer_contact
(
   gid                  varchar(32) not null,
   cid                  varchar(32),
   name                 varchar(32),
   sex                  int,
   department           varchar(32),
   position             varchar(32),
   quhao                varchar(8),
   phone                varchar(16),
   extension            varchar(8),
   mobile               varchar(16),
   qq                   varchar(16),
   msn                  varchar(32),
   icq                  varchar(32),
   email                varchar(32),
   is_important         varchar(32),
   remark               varchar(320),
   create_time          varchar(19),
   fax                  varchar(32),
   area_code            varchar(32),
   area                 varchar(128),
   main_contact         int,
   primary key (gid)
);

alter table ic_sms_customer_contact comment '客户联系人';

/*==============================================================*/
/* Table: ic_sms_enum                                           */
/*==============================================================*/
create table ic_sms_enum
(
   gid                  varchar(32) not null,
   type                 varchar(4),
   type_name            varchar(32),
   code                 varchar(4),
   name                 varchar(32),
   primary key (gid)
);

alter table ic_sms_enum comment '枚举表';

/*==============================================================*/
/* Table: ic_sms_meeting                                        */
/*==============================================================*/
create table ic_sms_meeting
(
   gid                  varchar(32) not null,
   year                 varchar(32),
   meeting_time         varchar(19),
   provience            varchar(32),
   city                 varchar(32),
   theme                varchar(64),
   c_user               varchar(32),
   hl_user              varchar(32),
   objective            varchar(64),
   remark               varchar(128),
   primary key (gid)
);

alter table ic_sms_meeting comment '会议';

/*==============================================================*/
/* Table: ic_sms_purchase                                       */
/*==============================================================*/
create table ic_sms_purchase
(
   gid                  varchar(32) not null,
   name                 varchar(32),
   usercode             varchar(32),
   password             varchar(32),
   site                 varchar(128),
   uid                  varchar(32),
   create_time          varchar(19),
   reg_time             varchar(19),
   primary key (gid)
);

alter table ic_sms_purchase comment '客户采购';

/*==============================================================*/
/* Table: ic_sms_pwd                                            */
/*==============================================================*/
create table ic_sms_pwd
(
   gid                  varchar(32),
   pwd                  varchar(128),
   rid                  varchar(32),
   type                 varchar(16)
);

alter table ic_sms_pwd comment '密码表';

/*==============================================================*/
/* Table: ic_sms_user                                           */
/*==============================================================*/
create table ic_sms_user
(
   gid                  varchar(32) not null,
   code                 varchar(32),
   name                 varchar(32),
   password             varchar(128),
   rid                  varchar(32),
   pid                  varchar(32),
   status               varchar(4),
   primary key (gid)
);

alter table ic_sms_user comment '用户表';

/*==============================================================*/
/* Table: ic_sms_work_feedback                                  */
/*==============================================================*/
create table ic_sms_work_feedback
(
   gid                  varchar(32) not null,
   theme                varchar(19),
   update_time          varchar(32),
   uid                  varchar(32),
   work_time            varchar(19),
   type                 varchar(8),
   message              varchar(32),
   primary key (gid)
);

alter table ic_sms_work_feedback comment '工作反馈';

/*==============================================================*/
/* Table: ic_sms_work_remind                                    */
/*==============================================================*/
create table ic_sms_work_remind
(
   gid                  varchar(32) not null,
   theme                varchar(19),
   update_time          varchar(32),
   uid                  varchar(32),
   start_time           varchar(19),
   over_time            varchar(19),
   remarks              varchar(32),
   status               varchar(32),
   primary key (gid)
);

alter table ic_sms_work_remind comment '工作提醒';

