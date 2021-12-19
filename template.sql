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
  `parentId` int(11) DEFAULT '-1',
  `modularLevel` varchar(10) DEFAULT NULL COMMENT '模块菜单在UI中的第几级',
  `modularIndex` int(11) DEFAULT NULL COMMENT '相同级数中的索引位置',
  `url` varchar(200) DEFAULT NULL COMMENT '对应的后台地址',
  `icon` varchar(20) DEFAULT NULL,
  `uiName` varchar(20) DEFAULT NULL,
  `isForward` tinyint(1) DEFAULT '1' COMMENT '是否可跳转页面0:不可跳转1:跳转',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

/*Data for the table `tb_modularmenu` */

insert  into `tb_modularmenu`(`id`,`modularName`,`parentId`,`modularLevel`,`modularIndex`,`url`,`icon`,`uiName`,`isForward`) values (1,'数据接入',0,'0',1,NULL,NULL,NULL,0),(2,'综合监测',0,'0',2,NULL,NULL,NULL,0),(3,'异常预警',0,'0',3,NULL,NULL,NULL,0),(4,'风险研判',0,'0',4,NULL,NULL,NULL,0),(5,'趋势分析',0,'0',5,NULL,NULL,NULL,0),(6,'承诺公告',0,'0',6,NULL,NULL,NULL,0),(7,'综合评估',0,'0',7,NULL,NULL,NULL,0),(8,'基础数据',1,'1',1,'user',NULL,NULL,0),(9,'生产状态与隐患监察',1,'1',2,NULL,NULL,NULL,0),(10,'感知信息',1,'1',3,NULL,NULL,NULL,0),(11,'视频图像',1,'1',4,NULL,NULL,NULL,0),(12,'共享数据',1,'1',5,NULL,NULL,NULL,0),(13,'数据传输',1,'1',6,NULL,NULL,NULL,0),(14,'企业分布',2,'1',1,NULL,NULL,NULL,0),(15,'基础信息报警预警',3,'1',1,NULL,NULL,NULL,0),(16,'感知数据报警预警',3,'1',2,NULL,NULL,NULL,0),(17,'设备运行状态报警预警',3,'1',3,NULL,NULL,NULL,0),(18,'企业风险研判',4,'1',1,NULL,NULL,NULL,0),(19,'区域风险研判',4,'1',2,NULL,NULL,NULL,0),(20,'企业风险趋势',5,'1',1,NULL,NULL,NULL,0),(21,'区域风险趋势',5,'1',2,NULL,NULL,NULL,0),(22,'安全承诺公告',6,'1',1,NULL,NULL,NULL,0),(23,'安全承诺公告统计',6,'1',2,NULL,NULL,NULL,0),(24,'企业数量变化情况',7,'1',1,NULL,NULL,NULL,0),(25,'系统联网在线情况',7,'1',2,NULL,NULL,NULL,0),(26,'视频在线情况',7,'1',3,NULL,NULL,NULL,0),(27,'感知设备在线情况',7,'1',4,NULL,NULL,NULL,0),(28,'报警处置情况',7,'1',5,NULL,NULL,NULL,0),(29,'企业相关证书情况',7,'1',6,NULL,NULL,NULL,0),(30,'第三方报告情况',7,'1',7,NULL,NULL,NULL,0),(31,'风险变化历史趋势',7,'1',8,NULL,NULL,NULL,0),(32,'定期分析报告',7,'1',9,NULL,NULL,NULL,0),(33,'专项监管监察',7,'1',10,NULL,NULL,NULL,0),(34,'企业信息',8,'2',1,NULL,NULL,NULL,0),(35,'许可证信息',8,'2',2,NULL,NULL,NULL,0),(36,'工库房信息',8,'2',3,NULL,NULL,NULL,0),(37,'设备信息',8,'2',4,NULL,NULL,NULL,0),(38,'人员信息',8,'2',5,NULL,NULL,NULL,0),(39,'第三方单位信息',8,'2',6,NULL,NULL,NULL,0),(40,'生产状态信息',9,'2',1,NULL,NULL,NULL,0),(41,'安全隐患信息',9,'2',2,NULL,NULL,NULL,0),(42,'监管检查数据',9,'2',3,NULL,NULL,NULL,0),(43,'事故时间信息',9,'2',4,NULL,NULL,NULL,0),(44,'温度传感器',10,'2',1,NULL,NULL,NULL,0),(45,'湿度传感器',10,'2',2,NULL,NULL,NULL,0),(46,'静电释放传感器',10,'2',3,NULL,NULL,NULL,0),(47,'气象数据',12,'2',1,NULL,NULL,NULL,0),(48,'周边环境数据',12,'2',2,NULL,NULL,NULL,0),(49,'首页',0,'0',8,'/','home',NULL,1),(50,'安全管理',0,'0',9,'/security','security',NULL,0),(51,'设置',0,'0',10,'/set','sz',NULL,0),(52,'用户管理',50,'1',1,'/user','user',NULL,1),(53,'权限管理',50,'1',2,'/jurisdiction','qx',NULL,1),(54,'日志管理',50,'1',3,'/log','log',NULL,1),(55,'门禁管理',51,'1',1,'/door','mjgl',NULL,1),(56,'人员设置',51,'1',2,'/personnel','rysz',NULL,1),(57,'人证合一',51,'1',3,'/certificate','rxhy',NULL,1),(58,'人证合一记录',51,'1',4,'/certificateInfo','rzjl',NULL,1),(59,'配置管理',51,'1',5,'/configure','pzgl',NULL,1),(60,'资源管理',0,'0',11,'/resource','zygl',NULL,0),(61,'企业信息',60,'1',1,'/enterpriseInfo','qyxx',NULL,1),(62,'监控场所',60,'1',2,'/monitoring','jkcs',NULL,1),(63,'库房名称/生产车间',60,'1',3,'/workshop','kfmc',NULL,1),(64,'设备管理',60,'1',4,'/device','device',NULL,1),(65,'设备类型管理',60,'1',5,'/deviceType','sblx',NULL,1),(66,'设备详情',60,'1',6,'/deviceDetails','sbxq',NULL,1),(67,'点位管理',0,'0',12,'/point','dwgl',NULL,0),(68,'风险管控',0,'0',13,'/risk','fxgk',NULL,0),(69,'隐患治理',0,'0',14,'/hiddenDanger','yhzl',NULL,0),(70,'告警管理',0,'0',15,'/alarm','gjgl',NULL,0),(71,'分组管理',67,'1',1,'/group','fzgl',NULL,1),(72,'数据字典',67,'1',2,NULL,NULL,NULL,0),(73,'摄像头',67,'1',3,'/camera','sxt',NULL,1),(74,'巡检任务',68,'1',1,'/inspection','xjrw',NULL,1),(75,'风险查看',68,'1',2,'/riskView','fxck',NULL,1),(76,'派单',69,'1',1,'/order','pd',NULL,1),(77,'隐患治理',69,'1',2,'/danger','yhzl',NULL,1),(78,'告警处理',70,'1',1,'/alarmHandling','gjgl',NULL,1),(79,'t5',0,'0',1,NULL,NULL,NULL,0),(80,'t6',79,'1',1,NULL,NULL,NULL,0),(81,'t7',80,'2',1,NULL,NULL,NULL,0),(82,'t8',81,'3',1,NULL,NULL,NULL,1),(83,'t9',81,'3',2,NULL,NULL,NULL,1),(84,'超限告警统计',0,'0',16,'/overrunAlarm','gjgl',NULL,1),(86,'温度告警统计',0,'0',17,'/temAlarm','gjgl',NULL,1),(87,'湿度告警统计',0,'0',18,'/humidityAlarm','gjgl',NULL,1),(88,'静电释放告警统计',0,'0',19,'/staticAlarm','gjgl',NULL,1);

/*Table structure for table `tb_organization` */

DROP TABLE IF EXISTS `tb_organization`;

CREATE TABLE `tb_organization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(100) DEFAULT NULL COMMENT '组织/公司名称',
  `organizationCode` varchar(7) DEFAULT NULL,
  `organizationLevel` int(11) DEFAULT NULL COMMENT '组织级别1表示本级，有子级的 本级用0表示【不显示本级】',
  `parentOrganizationCode` varchar(7) DEFAULT NULL,
  `districtIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tb_organization` */

insert  into `tb_organization`(`id`,`organizationName`,`organizationCode`,`organizationLevel`,`parentOrganizationCode`,`districtIndex`) values (5,'shbd','0000014',3,'0000016',NULL),(6,'江苏','000001',1,'0000000',2015),(7,'aed','0000015',3,'0000017',NULL),(8,'a1','0000016',2,'000001',NULL),(9,'b1','0000017',2,'000001',NULL);

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

insert  into `tb_role`(`id`,`roleName`,`organizationIndex`,`organizationCode`,`c_describe`,`createDateTime`,`modifyDateTime`,`createAccount`,`modifyAccount`) values (18,'测试',5,NULL,'111','2021-09-22 16:02:30',NULL,'5',NULL),(19,'333',5,NULL,'22',NULL,NULL,NULL,NULL),(20,'33',5,NULL,'','2021-09-24 16:18:13',NULL,'5',NULL),(21,'政府',6,NULL,'11',NULL,NULL,NULL,NULL),(22,'r1',0,'r2','ddd',NULL,NULL,NULL,NULL),(25,'r3',0,'r1','ddd',NULL,NULL,NULL,NULL),(26,'r3',0,'r2','ddd',NULL,NULL,NULL,NULL);

/*Table structure for table `tb_role_modular` */

DROP TABLE IF EXISTS `tb_role_modular`;

CREATE TABLE `tb_role_modular` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roleIndex` int(11) DEFAULT NULL,
  `modularIndex` int(11) DEFAULT NULL,
  `organizationIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=472 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role_modular` */

insert  into `tb_role_modular`(`id`,`roleIndex`,`modularIndex`,`organizationIndex`) values (235,0,70,5),(393,1,72,5),(410,1,84,5),(441,18,57,5),(442,18,58,5),(443,18,59,5),(444,18,70,5),(445,18,53,5),(446,18,76,5),(447,18,54,5),(448,18,75,5),(449,18,55,5),(450,18,78,5),(451,18,56,5),(452,18,77,5),(453,18,50,5),(454,18,71,5),(455,18,51,5),(456,18,74,5),(457,18,73,5),(458,18,52,5),(459,18,49,5),(460,18,68,5),(461,18,69,5),(462,18,64,5),(463,18,65,5),(464,18,66,5),(465,18,67,5),(466,18,60,5),(467,18,61,5),(468,18,62,5),(469,18,63,5),(470,1,84,5),(471,1,86,5);

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

insert  into `tb_user`(`id`,`account`,`password`,`organizationIndex`,`organizationCode`,`createAccount`,`modifyAccount`,`createDateTime`,`modifyDateTime`) values (13,'p1','p2',NULL,'p3',NULL,NULL,NULL,NULL),(14,'x','a',NULL,'b','c',NULL,'d',NULL),(16,'x','a',NULL,'b','c',NULL,'d',NULL),(17,'x6','qqq4',NULL,'b','c','x6','d','tttt'),(18,'x1','a',NULL,'b','c',NULL,'d',NULL),(21,'x31','qqq4',NULL,'b','c','x6','d','tttt'),(22,'x31','qqq4',NULL,'bs','c','x6','d','tttt');

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `organizationIndex` int(11) DEFAULT NULL COMMENT '组织索引',
  `roleIndex` int(11) DEFAULT NULL COMMENT '角色索引',
  `userIndex` int(11) DEFAULT NULL COMMENT '用户索引',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`id`,`organizationIndex`,`roleIndex`,`userIndex`) values (12,5,50,18),(13,5,53,18),(14,6,84,21),(19,0,18,10),(20,0,19,10),(21,0,20,10),(22,0,21,10),(30,0,18,11),(31,0,19,11),(32,0,20,11);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
