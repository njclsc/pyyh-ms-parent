/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.25 : Database - template
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`template` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `template`;

/*Table structure for table `tb_modularmenu` */

DROP TABLE IF EXISTS `tb_modularmenu`;

CREATE TABLE `tb_modularmenu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `modularName` varchar(30) DEFAULT NULL,
  `parentId` int(11) DEFAULT '-1' COMMENT '模块父级菜单索引没有父级用1表示',
  `modularLevel` varchar(10) DEFAULT NULL COMMENT '模块菜单在UI中的第几级',
  `modularIndex` int(11) DEFAULT NULL COMMENT '相同级数中的索引位置',
  `url` varchar(200) DEFAULT NULL COMMENT '对应的后台地址',
  `icon` varchar(20) DEFAULT NULL,
  `uiName` varchar(20) DEFAULT NULL,
  `isAction` tinyint(1) DEFAULT '0' COMMENT '是否是可操作菜单0:不是 1:是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Data for the table `tb_modularmenu` */

insert  into `tb_modularmenu`(`id`,`modularName`,`parentId`,`modularLevel`,`modularIndex`,`url`,`icon`,`uiName`,`isAction`) values (89,'t1',1,'1',1,NULL,NULL,NULL,0),(90,'t11',89,'2',1,NULL,NULL,NULL,0),(91,'a1',90,'3',1,NULL,NULL,NULL,1),(92,'a11',90,'3',2,NULL,NULL,NULL,1);

/*Table structure for table `tb_organization` */

DROP TABLE IF EXISTS `tb_organization`;

CREATE TABLE `tb_organization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(100) DEFAULT NULL COMMENT '组织/公司名称',
  `organizationCode` varchar(7) DEFAULT NULL,
  `organizationLevel` int(11) DEFAULT NULL,
  `parentOrganizationCode` varchar(7) DEFAULT NULL,
  `district` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tb_organization` */

insert  into `tb_organization`(`id`,`organizationName`,`organizationCode`,`organizationLevel`,`parentOrganizationCode`,`district`) values (5,'shbd','0000014',3,'0000016',NULL),(6,'江苏','000001',1,'0000000','2015'),(7,'aed','0000015',3,'0000017',NULL),(8,'111','222',33,'44','55'),(9,'b1','0000017',2,'000001',NULL),(10,'11','22',33,'44','55'),(12,'111','222',33,'44','55');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) DEFAULT NULL,
  `organizationIndex` int(11) DEFAULT NULL,
  `organizationCode` varchar(50) DEFAULT NULL,
  `c_describe` varchar(250) DEFAULT NULL,
  `createDateTime` varchar(30) DEFAULT NULL,
  `modifyDateTime` varchar(30) DEFAULT NULL,
  `createAccount` varchar(30) DEFAULT NULL,
  `modifyAccount` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`roleName`,`organizationIndex`,`organizationCode`,`c_describe`,`createDateTime`,`modifyDateTime`,`createAccount`,`modifyAccount`) values (18,'1',5,'1',NULL,'2021-09-22 16:02:30',NULL,'5',NULL),(19,'2',5,'2',NULL,NULL,NULL,NULL,NULL),(20,'3',5,'3',NULL,'2021-09-24 16:18:13',NULL,'5',NULL),(21,'4',6,'3',NULL,NULL,NULL,NULL,NULL),(22,'5',0,'3',NULL,NULL,NULL,NULL,NULL),(25,'6',0,'6',NULL,NULL,NULL,NULL,NULL),(26,'7',0,'6',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_role_modular` */

DROP TABLE IF EXISTS `tb_role_modular`;

CREATE TABLE `tb_role_modular` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roleIndex` int(11) DEFAULT NULL,
  `modularIndex` int(11) DEFAULT NULL,
  `organizationIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role_modular` */

insert  into `tb_role_modular`(`id`,`roleIndex`,`modularIndex`,`organizationIndex`) values (1,18,92,5);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `organizationIndex` int(11) DEFAULT NULL,
  `organizationCode` varchar(30) DEFAULT NULL,
  `createAccount` varchar(30) DEFAULT NULL,
  `modifyAccount` varchar(30) DEFAULT NULL,
  `createDateTime` varchar(30) DEFAULT NULL,
  `modifyDateTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`account`,`password`,`organizationIndex`,`organizationCode`,`createAccount`,`modifyAccount`,`createDateTime`,`modifyDateTime`) values (13,'p1','p2',5,'0000014',NULL,NULL,NULL,NULL),(14,'x','a',NULL,'b','c',NULL,'d',NULL),(16,'x','a',NULL,'b','c',NULL,'d',NULL),(17,'x6','qqq4',NULL,'b','c','x6','d','tttt'),(18,'x1','a',NULL,'b','c',NULL,'d',NULL),(21,'x31','qqq4',NULL,'b','c','x6','d','tttt'),(22,'x31','qqq4',NULL,'bs','c','x6','d','tttt');

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `organizationIndex` int(11) DEFAULT NULL COMMENT '组织索引',
  `roleIndex` int(11) DEFAULT NULL COMMENT '角色索引',
  `userIndex` int(11) DEFAULT NULL COMMENT '用户索引',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`id`,`organizationIndex`,`roleIndex`,`userIndex`) values (14,5,18,13),(30,0,18,11),(31,5,19,13),(32,0,20,11),(33,1,2,3),(34,11,2,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
