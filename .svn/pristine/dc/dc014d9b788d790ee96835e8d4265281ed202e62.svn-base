/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.62-community : Database - goskiing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`goskiing` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `goskiing`;

/*Table structure for table `club` */

DROP TABLE IF EXISTS `club`;

CREATE TABLE `club` (
  `club_id` varchar(64) DEFAULT NULL,
  `club_name` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `club` */

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `coach_id` varchar(64) NOT NULL,
  `niseko_id` varchar(64) DEFAULT NULL,
  `coach_name` varchar(64) DEFAULT NULL,
  `coach_teaching` varchar(64) DEFAULT NULL,
  `coach_status` varchar(64) DEFAULT NULL,
  `coach_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`coach_id`),
  KEY `FK_Reference_10` (`niseko_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`niseko_id`) REFERENCES `nisekomessage` (`niseko_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `coach` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_id` varchar(64) NOT NULL,
  `coach_id` varchar(64) DEFAULT NULL,
  `course_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_Reference_9` (`coach_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`coach_id`) REFERENCES `coach` (`coach_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

/*Table structure for table `discussion` */

DROP TABLE IF EXISTS `discussion`;

CREATE TABLE `discussion` (
  `dis_id` varchar(64) NOT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  `dis_text` varchar(256) DEFAULT NULL,
  `dis_way` varchar(512) DEFAULT NULL,
  `dis_likeUp` varchar(64) DEFAULT NULL,
  `dis_likeDown` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`dis_id`),
  KEY `FK_Reference_3` (`user_mail`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `discussion` */

insert  into `discussion`(`dis_id`,`user_mail`,`dis_text`,`dis_way`,`dis_likeUp`,`dis_likeDown`) values ('11111','1652185936@qq.com','测试的数据','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577685465293&di=c892b4ac08df1a8623267f09163505fc&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F7%2F53d5fa498745a.jpg',NULL,NULL),('123','1652185936@qq.com','123','http://a.hiphotos.baidu.com/image/pic/item/0ff41bd5ad6eddc40189fc4133dbb6fd52663319.jpg',NULL,NULL),('1234','1652185936@qq.com','1234','http://h.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb1354c94a704ac1ea8d3fd1f4439.jpg',NULL,NULL),('12345','1652185936@qq.com','12345','http://h.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb1354c94a704ac1ea8d3fd1f4439.jpg',NULL,NULL),('123456','1652185936@qq.com','123456','http://g.hiphotos.baidu.com/image/pic/item/21a4462309f7905296a7578106f3d7ca7acbd5d0.jpg',NULL,NULL),('1234567','1652185936@qq.com','1234567','http://b.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11cb2d45bfb312c8fcc2ce2d91.jpg',NULL,NULL),('2e04ca','1652185936@qq.com','aaa','http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg','100','15'),('8e86f4','1404822402@qq.com','今天天气','http://e.hiphotos.baidu.com/image/pic/item/dc54564e9258d1092f7663c9db58ccbf6c814d30.jpg','200','17'),('a2a22','1652185936@qq.com','aaaaa1231aae1','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577633563763&di=16eb36a713ac0bc577caf3fde5850354&imgtype=0&src=http%3A%2F%2Ffile03.16sucai.com%2F2016%2F10%2F1100%2F16sucai_p20161005036_0d4.JPG',NULL,NULL),('b66f2d','1652185936@qq.com','这是我发表的一个帖子','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577685465291&di=3a9e0dfcec367a49754b40f08096acd3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F1%2F53d5fb0de0a58.jpg',NULL,NULL),('d00569','1652185936@qq.com','今天天气123456','http://e.hiphotos.baidu.com/image/pic/item/b812c8fcc3cec3fdb850efcfdc88d43f87942719.jpg','30','20');

/*Table structure for table `fans` */

DROP TABLE IF EXISTS `fans`;

CREATE TABLE `fans` (
  `user_mail` varchar(64) DEFAULT NULL,
  `focus_on` text,
  `fans` text,
  KEY `FK_Reference_2` (`user_mail`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fans` */

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `info_id` varchar(64) NOT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  `info_text` varchar(256) DEFAULT NULL,
  `info_bywiter` varchar(64) DEFAULT NULL,
  `info_status` varchar(64) DEFAULT NULL,
  `info_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `FK_Reference_5` (`user_mail`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`info_id`,`user_mail`,`info_text`,`info_bywiter`,`info_status`,`info_time`) values ('1001','1404822402@qq.com','(1-0代表没有查看)','1652185936@qq.com','1_1','1577323372727'),('100110','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('100111','1404822402@qq.com','私人信息','1652185936@qq.com','2_1','1567323372727'),('100112','1404822402@qq.com','私人信息','1652185936@qq.com','2_1','1567323372727'),('100113','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('100114','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10012','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10013','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10014','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10015','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10016','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10017','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10018','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('10019','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('1002','1652185936@qq.com','啊啊啊啊啊啊啊啊','1404822402@qq.com','1_0','1567323372727'),('1003','1404822402@qq.com','你好啊','1652185936@qq.com','1_1','1567323372727'),('1004','1404822402@qq.com','1-1代表查看了','1652185936@qq.com','1_1','1567323372727'),('1005','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('1006','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('1007','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727'),('1008','1404822402@qq.com','私人信息','1652185936@qq.com','1_1','1567323372727');

/*Table structure for table `lease` */

DROP TABLE IF EXISTS `lease`;

CREATE TABLE `lease` (
  `lease_id` varchar(64) DEFAULT NULL,
  `lease_introduction` varchar(256) DEFAULT NULL,
  `lease_img` varchar(64) DEFAULT NULL,
  `lease_brand` varchar(64) DEFAULT NULL,
  `lease_price` varchar(64) DEFAULT NULL,
  `lease_percent` varchar(64) DEFAULT NULL,
  `lease_color` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lease` */

insert  into `lease`(`lease_id`,`lease_introduction`,`lease_img`,`lease_brand`,`lease_price`,`lease_percent`,`lease_color`) values ('1111','1111','1111','1111','1111','1111','红色');

/*Table structure for table `lease_info` */

DROP TABLE IF EXISTS `lease_info`;

CREATE TABLE `lease_info` (
  `lease_id` varchar(64) NOT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`lease_id`),
  KEY `FK_Reference_6` (`user_mail`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lease_info` */

/*Table structure for table `leavemessage` */

DROP TABLE IF EXISTS `leavemessage`;

CREATE TABLE `leavemessage` (
  `dis_id` varchar(64) DEFAULT NULL,
  `leave_text` varchar(256) DEFAULT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  KEY `FK_Reference_4` (`dis_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`dis_id`) REFERENCES `discussion` (`dis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leavemessage` */

insert  into `leavemessage`(`dis_id`,`leave_text`,`user_mail`) values ('d00569','这条评论666','1652185936@qq.com'),('d00569','也是分666','1652185936@qq.com'),('2e04ca','66666666666666666',NULL),('2e04ca','9999999999999999999999999','1652185936@qq.com'),('2e04ca','9999999999999999999999999','1652185936@qq.com'),('2e04ca','9999999999999999999999999','1652185936@qq.com'),('2e04ca','9999999999999999999999999','1652185936@qq.com'),('2e04ca','9999999999999999999999999','1652185936@qq.com');

/*Table structure for table `loginmessage` */

DROP TABLE IF EXISTS `loginmessage`;

CREATE TABLE `loginmessage` (
  `user_mail` varchar(64) NOT NULL,
  `user_pwd` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `loginmessage` */

insert  into `loginmessage`(`user_mail`,`user_pwd`) values ('123456789@qq.com','123456'),('13081079870','123456'),('1404822402@qq.com','123456'),('1652185936@qq.com','123456'),('2468863514@qq.com','123456'),('lucky_dog0@163.com','123321');

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `manager_id` varchar(64) DEFAULT NULL,
  `manager_name` varchar(64) DEFAULT NULL,
  `manager_pwd` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

/*Table structure for table `nisekomessage` */

DROP TABLE IF EXISTS `nisekomessage`;

CREATE TABLE `nisekomessage` (
  `niseko_id` varchar(64) NOT NULL,
  `niseko_name` varchar(64) DEFAULT NULL,
  `niseko_photo` varchar(64) DEFAULT NULL,
  `niseko_address` varchar(256) DEFAULT NULL,
  `niseko_tel` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`niseko_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `nisekomessage` */

/*Table structure for table `preowned` */

DROP TABLE IF EXISTS `preowned`;

CREATE TABLE `preowned` (
  `preowned_id` varchar(64) NOT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`preowned_id`),
  KEY `FK_preowned` (`user_mail`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `preowned` */

insert  into `preowned`(`preowned_id`,`user_mail`) values ('08d18c','123456789@qq.com'),('27d806','123456789@qq.com'),('411519','123456789@qq.com'),('4439c2','123456789@qq.com'),('75a87e','123456789@qq.com'),('a0daf5','123456789@qq.com'),('222','1404822402@qq.com'),('111','1652185936@qq.com'),('3ae7bf','1652185936@qq.com'),('6bcbd7','1652185936@qq.com');

/*Table structure for table `preowned_list` */

DROP TABLE IF EXISTS `preowned_list`;

CREATE TABLE `preowned_list` (
  `preowned_id` varchar(64) DEFAULT NULL,
  `preownedd_list_picture` varchar(256) DEFAULT NULL,
  `preownedd_list_type` varchar(64) DEFAULT NULL,
  `preownedd_list_introduction` varchar(256) DEFAULT NULL,
  `preowned_list_pirce` varchar(64) DEFAULT NULL,
  `preowned_list_percent` varchar(64) DEFAULT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  KEY `FK_preowned_list` (`preowned_id`),
  CONSTRAINT `FK_preowned_list` FOREIGN KEY (`preowned_id`) REFERENCES `preowned` (`preowned_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `preowned_list` */

insert  into `preowned_list`(`preowned_id`,`preownedd_list_picture`,`preownedd_list_type`,`preownedd_list_introduction`,`preowned_list_pirce`,`preowned_list_percent`,`user_mail`) values ('6bcbd7','8da6d148-c06f-4ac5-b201-46e734b7cfe9.jpg,8c408e91-c4ce-4a8c-be21-f1115739958b.jpg,fcb3d8ad-23f1-4ebb-892f-96eedf633e57.jpg','头盔','这是一个头盔','9999','8成新','1652185936@qq.com'),('111','8da6d148-c06f-4ac5-b201-46e734b7cfe9.jpg,8c408e91-c4ce-4a8c-be21-f1115739958b.jpg,fcb3d8ad-23f1-4ebb-892f-96eedf633e57.jpg','11','111','11','1','1404822402@qq.com'),('222','8da6d148-c06f-4ac5-b201-46e734b7cfe9.jpg,8c408e91-c4ce-4a8c-be21-f1115739958b.jpg,fcb3d8ad-23f1-4ebb-892f-96eedf633e57.jpg','22','22','22','22',NULL),('75a87e','4714923e-06a7-48cb-8edf-a15037a15783.jpg,202839c4-f538-455a-a357-3ad0fef96690.jpg,db03846a-2133-47b5-9d86-29619c0492f3.jpg','手套','这是一个手套','9999','8成新','123456789@qq.com'),('27d806','b7b54832-f188-4796-a402-99f892c0e7e7.jpg,0348e038-13e4-49e1-a682-b70dba659945.jpg,d294f864-926f-4443-a075-f236a8416819.jpg','手套','这是一个手套','9999','8成新','123456789@qq.com'),('3ae7bf','4f7aceea-bd93-4e76-8dfc-9524be9f5d0a.jpg,db299bc6-2845-41ff-a2b0-1443b0984875.jpg,e4aed755-58b4-43d1-a6a1-cc39efeb08a7.jpg','头盔','这是一个头盔','9999','null','1652185936@qq.com');

/*Table structure for table `preownedmessage` */

DROP TABLE IF EXISTS `preownedmessage`;

CREATE TABLE `preownedmessage` (
  `preowned_id` varchar(64) DEFAULT NULL,
  `preownedMessage_content` varchar(256) DEFAULT NULL,
  `user_mail` varchar(64) DEFAULT NULL,
  KEY `FK_Reference_13` (`preowned_id`),
  KEY `FK_Reference_14` (`user_mail`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`preowned_id`) REFERENCES `preowned` (`preowned_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `preownedmessage` */

/*Table structure for table `usermessage` */

DROP TABLE IF EXISTS `usermessage`;

CREATE TABLE `usermessage` (
  `user_mail` varchar(64) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_motto` varchar(256) DEFAULT NULL,
  `user_sex` varchar(64) DEFAULT NULL,
  `user_address` varchar(64) DEFAULT NULL,
  `user_photo` varchar(512) DEFAULT NULL,
  `user_img` varchar(512) DEFAULT NULL,
  KEY `FK_Reference_1` (`user_mail`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_mail`) REFERENCES `loginmessage` (`user_mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usermessage` */

insert  into `usermessage`(`user_mail`,`user_name`,`user_motto`,`user_sex`,`user_address`,`user_photo`,`user_img`) values ('1652185936@qq.com','杨核心','我是杨核心啦啦啦','0','asdf','http://10.2.32.1:8089/GoSkiings/Skiings/returnimg.do?imgname=925c4731-0e07-409a-9e2d-3f4e0ab9fea1.jpg','1111'),('1404822402@qq.com','用户66d7c6','111111','0','','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1596632485,1021460307&fm=26&gp=0.jpg','default_img.jpg'),('2468863514@qq.com','用户a0b731','','0','','http://imgsrc.baidu.com/forum/w=580/sign=0dba01b70355b3199cf9827d73a88286/037768a1cd11728be569c194c1fcc3cec2fd2cbc.jpg','default_img.jpg'),('123456789@qq.com','1235',NULL,NULL,NULL,'http://img3.imgtn.bdimg.com/it/u=2800948364,810107563&fm=26&gp=0.jpg',NULL),('lucky_dog0@163.com','用户_e6707c','','','0','http://img1.imgtn.bdimg.com/it/u=2723316316,3898818499&fm=26&gp=0.jpg','default_img.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
