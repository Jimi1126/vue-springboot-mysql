ALTER TABLE `sms`.`ic_sms_customer` 
CHANGE COLUMN `code` `code` VARCHAR(16) NULL DEFAULT NULL ;

ALTER TABLE `sms`.`ic_sms_customer` 
CHANGE COLUMN `remark` `remark` VARCHAR(256) NULL DEFAULT NULL ;
ALTER TABLE `sms`.`ic_sms_customer` 
CHANGE COLUMN `name` `name` VARCHAR(128) NULL DEFAULT NULL ,
CHANGE COLUMN `address` `address` VARCHAR(256) NULL DEFAULT NULL ;
ALTER TABLE `sms`.`ic_sms_customer` 
CHANGE COLUMN `country` `country` VARCHAR(22) NULL DEFAULT NULL ,
CHANGE COLUMN `province` `province` VARCHAR(22) NULL DEFAULT NULL ,
CHANGE COLUMN `city` `city` VARCHAR(22) NULL DEFAULT NULL ;
