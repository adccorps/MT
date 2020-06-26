/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.23 : Database - mt_database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mt_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `mt_database`;

/*Table structure for table `cinema` */

DROP TABLE IF EXISTS `cinema`;

CREATE TABLE `cinema` (
  `cinema_id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` text COLLATE utf8mb4_bin,
  `phone` varchar(15) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`cinema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema` */

insert  into `cinema`(`cinema_id`,`cinema_name`,`address`,`phone`) values 
(1,'cenema1','sdjlkasjdsdasd','12312312333');

/*Table structure for table `cinema_control` */

DROP TABLE IF EXISTS `cinema_control`;

CREATE TABLE `cinema_control` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `cinema_id` int(11) NOT NULL,
  `is_show` tinyint(3) unsigned NOT NULL COMMENT '上映控制0下架,1上映',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema_control` */

/*Table structure for table `cinema_customer` */

DROP TABLE IF EXISTS `cinema_customer`;

CREATE TABLE `cinema_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) NOT NULL COMMENT '电影院id',
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '对应电影院的管理员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema_customer` */

insert  into `cinema_customer`(`id`,`cinema_id`,`customer_id`) values 
(1,1,'8224808968');

/*Table structure for table `cinema_hall` */

DROP TABLE IF EXISTS `cinema_hall`;

CREATE TABLE `cinema_hall` (
  `hall_id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) DEFAULT NULL,
  `max_seat` int(5) DEFAULT NULL COMMENT '最大座位数',
  `hall_name` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '影厅名称',
  PRIMARY KEY (`hall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema_hall` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '用户全局唯一ID',
  `customer_name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名称',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
  `permission_id` int(11) NOT NULL COMMENT '用户权限id',
  `phone` varchar(15) COLLATE utf8mb4_bin NOT NULL COMMENT '用户注册手机号',
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `avatar` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像,文件名',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`customer_name`,`password`,`permission_id`,`phone`,`email`,`avatar`) values 
('1047802993','user2','aec8a8e1715d58eb57c7f022ca865ded',5,'15811111111','xxx@xxx.xxx','string'),
('1187916612','userX','4d904405e69c66e6fd7871c8b507080e',5,'15811912936','xxx@xxx.xxx','2222'),
('4822137192','user1','237c0ce62412527595cfa684a36ff472',2,'15811111111','xxx@xxx.xxx','string111'),
('8224808968','ceshi1','79bd317642b9843cc16fcde4076ac1f3',1,'1101010101010','111@111.c11','111');

/*Table structure for table `film` */

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_name` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '电影名称',
  `create_time` datetime NOT NULL COMMENT '记录创建时间',
  `release_date` datetime NOT NULL COMMENT '上映时间',
  `actor` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '主演名称',
  `director` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '导演名',
  `poster` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电影海报,文件名',
  `introduction` text COLLATE utf8mb4_bin COMMENT '电影介绍',
  `type_id` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电影类型(,分割)',
  `language` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '电影语言',
  `duration` int(11) NOT NULL COMMENT '时长(分钟)',
  PRIMARY KEY (`film_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film` */

insert  into `film`(`film_id`,`film_name`,`create_time`,`release_date`,`actor`,`director`,`poster`,`introduction`,`type_id`,`language`,`duration`) values 
(1,'测试','2020-06-03 21:10:40','2020-06-03 21:10:43','11','11','111','3213213123123123','1','en',321321312);

/*Table structure for table `film_comment` */

DROP TABLE IF EXISTS `film_comment`;

CREATE TABLE `film_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `film_id` int(11) NOT NULL COMMENT '评论对应的电影',
  `content` text COLLATE utf8mb4_bin NOT NULL COMMENT '评论内容',
  `score` int(4) NOT NULL COMMENT '评分',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_comment` */

insert  into `film_comment`(`comment_id`,`customer_id`,`film_id`,`content`,`score`) values 
(1,'8224808968',1,'二娃二无群二群翁',5),
(2,'1047802993',1,'测试内容',3);

/*Table structure for table `film_order` */

DROP TABLE IF EXISTS `film_order`;

CREATE TABLE `film_order` (
  `order_id` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '订单id 有时间格式要求',
  `create_time` datetime NOT NULL COMMENT '订单创建时间',
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '订票顾客',
  `order_cost` decimal(10,2) NOT NULL COMMENT '总金额',
  `real_cost` decimal(10,2) NOT NULL COMMENT '实际支付金额',
  `status` int(2) NOT NULL COMMENT '订单状态',
  `schedule_id` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对应场次号',
  `seat_number` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '场次座位号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_order` */

/*Table structure for table `film_schedule` */

DROP TABLE IF EXISTS `film_schedule`;

CREATE TABLE `film_schedule` (
  `schedule_id` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  `film_id` int(11) DEFAULT NULL,
  `cinema_id` int(11) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `hall_id` int(11) DEFAULT NULL,
  `film_price` decimal(10,2) NOT NULL COMMENT '订票价格\r\n',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_schedule` */

/*Table structure for table `film_type` */

DROP TABLE IF EXISTS `film_type`;

CREATE TABLE `film_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_type` */

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `permission` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`permission`) values 
(1,'Sadmin'),
(2,'admin'),
(3,'SVIP'),
(4,'VIP'),
(5,'consumer'),
(6,'ceshi'),
(7,'1修改后');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
