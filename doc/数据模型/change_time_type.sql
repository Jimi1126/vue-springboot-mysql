/*==============================================================*/
/* remark: 修改时间类型ic_sms_user
/* date: 2019-05-30
/*==============================================================*/
ALTER TABLE `sms`.`ic_sms_bid` 
CHANGE COLUMN `bid_time` `bid_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_business_visit` 
CHANGE COLUMN `visit_unit` `visit_unit` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_come_visit` 
CHANGE COLUMN `visit_time` `visit_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_contract` 
CHANGE COLUMN `contract_time` `contract_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `over_time` `over_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_customer` 
CHANGE COLUMN `create_time` `create_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `reg_date` `reg_date` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `next_time` `next_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `last_time` `last_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_customer_activity` 
CHANGE COLUMN `touch_time` `touch_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `next_time` `next_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `create_time` `create_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_customer_contact` 
CHANGE COLUMN `sex` `sex` BINARY(1) NULL DEFAULT NULL ,
CHANGE COLUMN `create_time` `create_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_dict` 
CHANGE COLUMN `update_time` `update_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_meeting` 
CHANGE COLUMN `meeting_time` `meeting_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_purchase` 
CHANGE COLUMN `create_time` `create_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `reg_time` `reg_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_user` 
CHANGE COLUMN `password` `password` VARCHAR(128) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_work_feedback` 
CHANGE COLUMN `update_time` `update_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `work_time` `work_time` VARCHAR(19) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_work_remind` 
CHANGE COLUMN `update_time` `update_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `start_time` `start_time` VARCHAR(19) NULL DEFAULT NULL ,
CHANGE COLUMN `over_time` `over_time` VARCHAR(19) NULL DEFAULT NULL ;
