/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.25-log : Database - atomizer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`atomizer` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `atomizer`;

/*Table structure for table `tb_organization` */

DROP TABLE IF EXISTS `tb_organization`;

CREATE TABLE `tb_organization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(100) DEFAULT NULL COMMENT '组织/公司名称',
  `organizationCode` varchar(7) DEFAULT NULL COMMENT '组织编码',
  `organizationLevel` int(11) DEFAULT NULL COMMENT '组织等级',
  `parentOrganizationCode` varchar(7) DEFAULT NULL COMMENT '父级组织编码',
  `district` varchar(150) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_organization` */

insert  into `tb_organization`(`id`,`organizationName`,`organizationCode`,`organizationLevel`,`parentOrganizationCode`,`district`) values (13,'威斯巴特','0000001',1,NULL,'生产厂家');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) DEFAULT NULL,
  `roleType` int(2) DEFAULT NULL COMMENT '0:管理员；1：普通用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`roleName`,`roleType`) values (1,'管理员',0),(2,'普通用户',1);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `mobilePhone` varchar(30) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `organizationCode` varchar(11) DEFAULT NULL COMMENT '账号所属组织/公司编号',
  `post` varchar(30) DEFAULT NULL COMMENT '使用账号人员职务',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`account`,`password`,`mobilePhone`,`userName`,`email`,`organizationCode`,`post`,`status`) values (1,'u1','1','1','1','1','0000001','1',1);

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userIndex` int(11) DEFAULT NULL,
  `roleIndex` int(11) DEFAULT NULL,
  `organizationCode` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`id`,`userIndex`,`roleIndex`,`organizationCode`) values (1,1,1,'0000001');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
