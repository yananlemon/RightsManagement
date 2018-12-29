/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - rights_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rights_management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rights_management`;

/*Table structure for table `t_permissions` */

DROP TABLE IF EXISTS `t_permissions`;

CREATE TABLE `t_permissions` (
  `permission_code` varchar(20) NOT NULL COMMENT '权限编码，主键。',
  `parent_permission_code` varchar(20) DEFAULT NULL COMMENT '权限父编码',
  `permission_type` varchar(20) DEFAULT NULL,
  `permission_text` varchar(50) DEFAULT NULL COMMENT '权限文本',
  `permission_url` varchar(100) DEFAULT NULL COMMENT '权限url',
  PRIMARY KEY (`permission_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_permissions` */

insert  into `t_permissions`(`permission_code`,`parent_permission_code`,`permission_type`,`permission_text`,`permission_url`) values ('01','root',NULL,'用户管理',NULL),('0101','01',NULL,'用户列表','/user/users'),('0102','01',NULL,'新增用户','/user/create'),('0103','01',NULL,'修改用户','/user/update'),('0104','01',NULL,'删除用户','/user/delete');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

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

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_name`,`role_desc`,`flag`,`create_time`,`create_by`,`update_time`,`update_by`) values (1,'超级管理员','拥有系统所有权限',NULL,'2018-12-27 17:18:22',NULL,'0000-00-00 00:00:00',NULL),(2,'用户管理员','拥有系统',NULL,'2018-12-27 17:18:38',NULL,'0000-00-00 00:00:00',NULL);

/*Table structure for table `t_role_permissions` */

DROP TABLE IF EXISTS `t_role_permissions`;

CREATE TABLE `t_role_permissions` (
  `role_id` int(8) DEFAULT NULL,
  `permission_code` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permissions` */

insert  into `t_role_permissions`(`role_id`,`permission_code`) values (1,'01'),(1,'0101'),(1,'0102'),(1,'0103'),(1,'0104');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`,`mobile`,`address`,`create_time`,`create_by`,`update_time`,`update_by`) values (1,'admin','admin','admin@126.com','19913657631','天安门','2018-12-26 15:49:29',NULL,'0000-00-00 00:00:00',NULL),(2,'yanan','$2a$10$aT6Ez/ZXxsJ.3N.YjWuC4etvqIiCiCTO8BXubUlmqgCPTm2P5IHFC','yanan@yeah.net','13564418187','河南省安阳县曲沟镇安车村','2018-12-26 16:51:54',NULL,'0000-00-00 00:00:00',NULL),(3,'yanan1','$2a$10$Ebsfr0IA62PTvRdwtxyFBuryONEmwSHzgt.tLYm7TYHq7/V/PSfFe','yanan@yeah.net','13564418187','河南省安阳县曲沟镇安车村','2018-12-26 16:56:35',NULL,'0000-00-00 00:00:00',NULL),(4,'令狐冲','$2a$10$VGfmiL4CkKA0y5baBDf6LuScIp5/ddqL2ayRqKJwY8audLDb9WgPq','chong.linghuo@126.com','13564418187','恒山','2018-12-27 16:42:09',NULL,'0000-00-00 00:00:00',NULL),(5,'令狐冲1','$2a$10$EFroeXysy9Y7Tnl3/EiQHOFrnJAcW1f5Z8PiNTQuLBmMwYYsgmkzC','chong1.linghuo@126.com','13564418187','恒山1','2018-12-27 16:43:43',NULL,'0000-00-00 00:00:00',NULL);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values (1,2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
