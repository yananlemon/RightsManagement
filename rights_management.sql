-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: rights_management
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_permissions`
--

DROP TABLE IF EXISTS `t_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permissions` (
  `permission_code` varchar(20) NOT NULL COMMENT '权限编码，主键。',
  `parent_permission_code` varchar(20) DEFAULT NULL COMMENT '权限父编码',
  `permission_type` varchar(20) DEFAULT NULL,
  `permission_text` varchar(50) DEFAULT NULL COMMENT '权限文本',
  `permission_url` varchar(100) DEFAULT NULL COMMENT '权限url',
  PRIMARY KEY (`permission_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permissions`
--

LOCK TABLES `t_permissions` WRITE;
/*!40000 ALTER TABLE `t_permissions` DISABLE KEYS */;
INSERT INTO `t_permissions` VALUES ('01','root',NULL,'用户管理',NULL),('0101','01',NULL,'用户列表','/user/users?currentPage=1'),('0102','01',NULL,'新增用户','/user/create'),('0103','01',NULL,'修改用户','/user/update'),('0104','01',NULL,'删除用户','/user/delete'),('02','root',NULL,'角色管理',NULL),('0201','02',NULL,'角色列表','/role/roles?currentPage=1'),('0202','02',NULL,'新增角色',NULL);
/*!40000 ALTER TABLE `t_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `flag` int(1) DEFAULT NULL COMMENT '标识符,0:可用;1:禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(50) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'超级管理员','拥有系统所有权限',NULL,'2018-12-27 09:18:22',NULL,'0000-00-00 00:00:00',NULL),(2,'用户管理员','拥有系统',NULL,'2018-12-27 09:18:38',NULL,'0000-00-00 00:00:00',NULL);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_permissions`
--

DROP TABLE IF EXISTS `t_role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_permissions` (
  `role_id` int(8) DEFAULT NULL,
  `permission_code` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_permissions`
--

LOCK TABLES `t_role_permissions` WRITE;
/*!40000 ALTER TABLE `t_role_permissions` DISABLE KEYS */;
INSERT INTO `t_role_permissions` VALUES (1,'01'),(1,'0101'),(1,'0102'),(1,'0103'),(1,'0104');
/*!40000 ALTER TABLE `t_role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键，自动增长。',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','admin@126.com','19913657631','天安门','2018-12-26 07:49:29',NULL,'0000-00-00 00:00:00',NULL),(2,'yanan','$2a$10$aT6Ez/ZXxsJ.3N.YjWuC4etvqIiCiCTO8BXubUlmqgCPTm2P5IHFC','yanan@yeah.net','13564418187','河南省安阳县曲沟镇安车村','2018-12-26 08:51:54',NULL,'0000-00-00 00:00:00',NULL),(3,'yanan1','$2a$10$Ebsfr0IA62PTvRdwtxyFBuryONEmwSHzgt.tLYm7TYHq7/V/PSfFe','yanan@yeah.net','13564418187','河南省安阳县曲沟镇安车村','2018-12-26 08:56:35',NULL,'0000-00-00 00:00:00',NULL),(4,'令狐冲','$2a$10$VGfmiL4CkKA0y5baBDf6LuScIp5/ddqL2ayRqKJwY8audLDb9WgPq','chong.linghuo@126.com','13564418187','恒山','2018-12-27 08:42:09',NULL,'0000-00-00 00:00:00',NULL),(5,'令狐冲1','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-27 08:43:43',NULL,'0000-00-00 00:00:00',NULL),(6,'令狐冲2','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(7,'令狐冲3','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(8,'令狐冲4','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(9,'令狐冲5','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(10,'令狐冲6','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(11,'令狐冲7','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(12,'令狐冲8','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(13,'令狐冲9','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(14,'令狐冲10','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(15,'令狐冲11','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(16,'令狐冲12','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(17,'令狐冲13','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(18,'令狐冲14','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(19,'令狐冲15','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(20,'令狐冲16','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(36,'令狐冲17','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(37,'令狐冲19','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(38,'令狐冲19','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(39,'令狐冲20','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(40,'令狐冲21','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(41,'令狐冲22','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(42,'令狐冲23','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(43,'令狐冲24','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(44,'令狐冲25','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(45,'令狐冲26','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(46,'令狐冲27','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(47,'令狐冲28','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(48,'令狐冲29','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(49,'令狐冲30','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(50,'令狐冲31','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(51,'令狐冲32','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(52,'令狐冲33','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-31 14:58:08',NULL,'2018-12-27 08:43:43',NULL),(54,'张三','$2a$10$twukoOd3hr61ccUxTAlxNeAmqRkXz8QVzH2F0q/GLff1jffmShq2O','zhangsan@126.com','12345678901','fsljflsjflsjflsjfls','2018-12-31 17:58:35',NULL,'0000-00-00 00:00:00',NULL),(55,'李四','$2a$10$OFR/mSHvM4Cw0YZyRLWsBuTqsq3fuUXrhr1bCs.QrC8sBaH04lrZC','lisi@126.com','12345678999','jfsljflsjfslfjlsf','2018-12-31 18:04:08',NULL,'0000-00-00 00:00:00',NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,2,1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'rights_management'
--

--
-- Dumping routines for database 'rights_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-01 22:23:22
