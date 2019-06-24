-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: sms
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ic_sms_enum`
--

DROP TABLE IF EXISTS `ic_sms_enum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ic_sms_enum` (
  `gid` varchar(32) NOT NULL,
  `type` varchar(4) DEFAULT NULL,
  `type_name` varchar(32) DEFAULT NULL,
  `code` varchar(4) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ic_sms_enum`
--
-- WHERE:  1=1

LOCK TABLES `ic_sms_enum` WRITE;
/*!40000 ALTER TABLE `ic_sms_enum` DISABLE KEYS */;
INSERT INTO `ic_sms_enum` (`gid`, `type`, `type_name`, `code`, `name`) VALUES ('0NeRN0KBH8am9YWJGZgPXeQZ9Jf8Dg0a','0003','客户状态','0003','搁置客户'),('21fhlVK2QDBKVpiYlI1OfhXcEZnSdPX8','0006','行业','0007','租赁金融'),('2b0BJhTgBXVoWaPGa6ZAZ2pn2SRUJSP4','0007','是否','0002','否'),('2HMTIp8S3knEG3MYVUmGoM5ohpPZ3mYZ','0012','合作类型','0002','保全'),('4d0IlFhhh34AS3jT7e1fKnIdPVmgRFm5','0006','行业','0006','消费金融'),('4G6JFBfV2EU8mXSdI9KI1enfpWX7J64a','0007','是否','0001','是'),('7955L4X7CiVC1BlVcSIFk8mNQNY7YokW','0010','联系类型','0005','会议'),('85SAnLmaBdlJGHjcnAomFhd0pZXMiSMa','0010','联系类型','0006','其他'),('9DdHVhSM73KpHgL9Kj1F1OcQ89hLoa7M','0003','客户状态','0005','合同到期'),('9Fd0oQimX6i82SBGEHJiJaE7ZHPUhWf4','0011','部门','0001','软件'),('9nGeUbpThn86EL0k2WjbIZ6SGf0OXk0A','0012','合作类型','0005','契约影像审核'),('AbEANfJenSDbcQIRHLlLga1KHZGT6gmO','0013','合同类型','0002','补充协议'),('AdabDJNnTFUgnhISZBhcTOAVKM4RcnE4','0006','行业','0004','信托公司'),('AIQAHCBeNNANQog6Dk0DCm4fBG1V0Zba','0006','行业','0010','政府机构'),('ANCYm87coA6HG1I7FiJe4YXNaC7QfJfo','0011','部门','0002','咨询'),('ASabFI18DZBmfGO4doJRKAgnebQACofE','0010','联系类型','0001','电话'),('aVT6J8XpbYiTl9WSQGCL72lZcjPPcMX1','0004','客户来源','0001','网络'),('b85CeleQd07O0VSZU5HVEp8pNJD5QDDB','0001','角色','0001','总监'),('BJd5FX4E0SPmo7YnBPFl9GfgQRoTe53L','0002','职位','0002','测试'),('CgmpXeW05W6ARhiKiWNe9HTnhO7jSn8S','0006','行业','0008','快递公司'),('cSCDbSg2VeTXROASBpAK5pfNa636fTcO','0009','关系等级','0002','好'),('D1JoVS5iFQETEN94iTbmDfE1bJh2p4jY','0009','关系等级','0001','非常好'),('DBjElIflc7GCQUVb8cX8NHP24WCICe6F','0012','合作类型','0009','费用报销'),('DbUK2BAUOO1dIKBXpDnBaB9JkDeeokWX','0006','行业','0011','其他行业'),('DGSJ6m3gFFVhdL7EmeAaUPEnmkkLbFYH','0012','合作类型','0008','理算文档扫描整理'),('E887kZEAbQgBPDWjFReSWDnOm7I04P87','0011','部门','0004','交付'),('EdFncaOTYCD038P62V17D2f4eBELL1XX','0006','行业','0003','证券业'),('EG4Vjf25l7ZSWDj7jWgdLRpd6dDT5hTG','0012','合作类型','0006','保全影像审核'),('EUDKUV2HNJLH3O8kN6oec8CXK9oLeLDf','0004','客户来源','0003','参会'),('EWDUXIQUnpRKkbkQSbOUGISMm49oNMKK','0012','合作类型','0004','双录'),('eZbAChelHOj4B3gcLdJMfCD6EiG9k8LZ','0009','关系等级','0003','一般'),('FB1n5O6HFpYiPiAD05KjAfmSBG4QopJp','0006','行业','0005','财务公司'),('FkiU9LM4Ze58BFo3LbReNA6np6L9A0UJ','0011','部门','0003','PT'),('FRfGlilF3Op2ni7iZGWa3bMNWiC8D6pM','0002','职位','0004','销售'),('hibSAlFKRGIjdklhBHdecJVOIoCAGg9J','0014','合作状态','0002','合同到期'),('HYncBaGhTNFUYNLleZZ7mkYRW0NVKc29','0010','联系类型','0003','投标'),('iHWlA77GlXmk4W5i1e1l9HGO2p2cTV6T','0008','性别','0001','男'),('IkJan8Vh6l87NYWplNbVePIY1L5Xjhcg','0013','合同类型','0001','主合同'),('iR25B23j79AFEV3mCcemYBACLnNoXSdO','0008','性别','0002','女'),('j2KUlF5cLD2fdV38TCdDLC2CpIpI2JWJ','0012','合作类型','0007','理赔影像审核'),('j5809cRH1IgJEOg1ah5pCRDhFJDR6lFP','0009','关系等级','0004','差'),('jbRPPj6Ne8F4ApHOHU6ZKQZSNZcQcK9K','0010','联系类型','0004','餐叙'),('kgmLRgiDoKV6D1mAidK39cfeWJW9VLXa','0002','职位','0003','需求'),('lAIa7DUojCNhi664U1M6eNVcDU3ZgfeW','0003','客户状态','0002','意向客户'),('li9SYJSOZEOCD2nQgA3HKZZ8gkmj5L4U','0006','行业','0009','医疗机构'),('NHTAYEDBFKaCmWZM9BncUYGkcHTUV9Nh','0004','客户来源','0005','直接联系'),('o3OgWlUAmQ3PCjVBn5XN7CGgQA4Z1eWp','0002','职位','0001','开发'),('ORQZnHcU5mMhI1PZgS4pHa7iN5BdlhF5','0004','客户来源','0002','电话'),('p1MRbNflcTbdY6a8K7kan5dJHn65M51T','0005','员工状态','0002','离职'),('pO1LR4PUm4PHchQMpgYAiThblnUIKTEB','0010','联系类型','0002','面访'),('Q3ImaFl2ffpM86GlpVoonfjRPEZN1IeX','0014','合作状态','0001','合作中'),('RbObeVFCTi9ZDULj2gHHE4ebJYhaEEoC','0012','合作类型','0001','契约'),('RHoKGnHgWfDI7Zg8iMn2oU3J7QJTSnUH','0003','客户状态','0001','初步接触'),('ShC7QTGm70QPnFkUC87ESj4n5HR08iTf','0006','行业','0002','银行'),('TDIcSKoj5An73URI95N2N63kDWGmb0P6','0001','角色','0002','经理'),('TL2eeUMfUgjGGgOdJWSR8P1Sjf9a5N9Z','0001','角色','0003','专员'),('U4cmAFHAdIgHYXU33GKKAcNWpPEIT5j2','0006','行业','0001','保险'),('WbgcNO26oYQ7QHSXf9n4Y9VfC7T8o9fT','0004','客户来源','0004','客户介绍'),('XLp4SNWP3MoFm1VgoJ1O07PBZjnQVehK','0012','合作类型','0003','理赔'),('YI0AXca8CIFV9TF7DNSNl1ojM1pJcPPG','0003','客户状态','0004','已合作'),('ZQM8i6YZOOSPB38UJJ3Aoccn5nEIRo59','0005','员工状态','0001','在职');
/*!40000 ALTER TABLE `ic_sms_enum` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-10 14:50:42
