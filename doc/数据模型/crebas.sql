/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/27 14:49:54                           */
/*==============================================================*/


drop table if exists ic_sms_bid;

drop table if exists ic_sms_business_visit;

drop table if exists ic_sms_come_visit;

drop table if exists ic_sms_config_menu;

drop table if exists ic_sms_contract;

drop table if exists ic_sms_customer;

drop table if exists ic_sms_customer_activity;

drop table if exists ic_sms_customer_contact;

drop table if exists ic_sms_dict;

drop table if exists ic_sms_enum;

drop table if exists ic_sms_meeting;

drop table if exists ic_sms_purchase;

drop table if exists ic_sms_user;

drop table if exists ic_sms_work_feedback;

drop table if exists ic_sms_work_remind;

/*==============================================================*/
/* Table: ic_sms_bid                                            */
/*==============================================================*/
create table ic_sms_bid
(
   gid                  varchar(32) not null,
   year                 varchar(8),
   bid_time             timestamp,
   name                 varchar(32),
   trade                varchar(32),
   project              varchar(32),
   attend_company       varchar(32),
   hl_name              varchar(32),
   result               varchar(32),
   remark               varchar(64),
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_business_visit                                 */
/*==============================================================*/
create table ic_sms_business_visit
(
   gid                  varchar(32) not null,
   year                 varchar(8),
   visit_time           varchar(32),
   visit_unit           timestamp,
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

/*==============================================================*/
/* Table: ic_sms_come_visit                                     */
/*==============================================================*/
create table ic_sms_come_visit
(
   gid                  varchar(32) not null,
   year                 varchar(8),
   visit_time           timestamp,
   visit_unit           varchar(32),
   objective            varchar(32),
   c_user               varchar(32),
   hl_user              varchar(32),
   result               varchar(32),
   remark               varchar(64),
   uid                  varchar(32),
   primary key (gid)
);

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
   contract_time        timestamp,
   over_time            timestamp,
   status               varchar(32),
   cooperation_type     varchar(32),
   return_time          varchar(32),
   quality              varchar(32),
   remark               varchar(32),
   uid                  varchar(32),
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_customer                                       */
/*==============================================================*/
create table ic_sms_customer
(
   gid                  varchar(32) not null,
   code                 varchar(8),
   postalcode           varchar(32),
   name                 varchar(32),
   create_time          timestamp,
   area                 varchar(128),
   address              varchar(128),
   site                 varchar(128),
   origin               varchar(32),
   grade                varchar(32),
   stff_name            varchar(32),
   uid                  varchar(32),
   trade                varchar(32),
   status               varchar(4),
   reg_date             timestamp,
   remark               varchar(32),
   country              varchar(16),
   province             varchar(16),
   city                 varchar(16),
   next_time            timestamp,
   last_time            timestamp,
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_customer_activity                              */
/*==============================================================*/
create table ic_sms_customer_activity
(
   gid                  varchar(32) not null,
   cid                  varchar(32),
   subject              varchar(128),
   contact              varchar(32),
   touch_time           timestamp,
   record               varchar(32),
   type                 varchar(4),
   next_time            timestamp,
   grade                varchar(4),
   potential            varchar(32),
   remark               varchar(32),
   create_time          timestamp,
   primary key (gid)
);

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
   phone                varchar(32),
   mobile               varchar(32),
   qq                   varchar(32),
   msn                  varchar(32),
   icq                  varchar(32),
   email                varchar(32),
   is_important         varchar(32),
   remark               varchar(32),
   create_time          timestamp,
   fax                  varchar(32),
   area_code            varchar(32),
   extension            varchar(32),
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_dict                                           */
/*==============================================================*/
create table ic_sms_dict
(
   gid                  varchar(32) not null,
   type                 varchar(4),
   name                 varchar(32),
   idx                  varchar(32),
   value                varchar(32),
   update_time          timestamp,
   remark               varchar(32),
   primary key (gid)
);

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

/*==============================================================*/
/* Table: ic_sms_meeting                                        */
/*==============================================================*/
create table ic_sms_meeting
(
   gid                  varchar(32) not null,
   year                 varchar(32),
   meeting_time         timestamp,
   provience            varchar(32),
   city                 varchar(32),
   theme                varchar(32),
   c_user               varchar(32),
   hl_user              varchar(32),
   objective            varchar(32),
   remark               varchar(64),
   primary key (gid)
);

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
   create_time          timestamp,
   reg_time             timestamp,
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_user                                           */
/*==============================================================*/
create table ic_sms_user
(
   gid                  varchar(32) not null,
   code                 varchar(32),
   name                 varchar(32),
   passowrd             varchar(128),
   rid                  varchar(32),
   pid                  varchar(32),
   status               varchar(4),
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_work_feedback                                  */
/*==============================================================*/
create table ic_sms_work_feedback
(
   gid                  varchar(32) not null,
   theme                varchar(32),
   update_time          timestamp,
   uid                  varchar(32),
   work_time            timestamp,
   type                 varchar(8),
   message              varchar(32),
   primary key (gid)
);

/*==============================================================*/
/* Table: ic_sms_work_remind                                    */
/*==============================================================*/
create table ic_sms_work_remind
(
   gid                  varchar(32) not null,
   theme                varchar(32),
   update_time          timestamp,
   uid                  varchar(32),
   start_time           timestamp,
   over_time            timestamp,
   remarks              varchar(32),
   status               varchar(32),
   primary key (gid)
);

