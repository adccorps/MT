/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.6.41 : Database - mt_database
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema` */

insert  into `cinema`(`cinema_id`,`cinema_name`,`address`,`phone`) values (1,'万达影院','广州增城','123456'),(2,'string','string','string'),(3,'test','sontan','123456'),(4,'test','sontan','123456'),(5,'string','string','string');

/*Table structure for table `cinema_control` */

DROP TABLE IF EXISTS `cinema_control`;

CREATE TABLE `cinema_control` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `cinema_id` int(11) NOT NULL,
  `is_show` tinyint(3) unsigned NOT NULL COMMENT '上映控制0下架,1上映',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema_control` */

insert  into `cinema_control`(`id`,`film_id`,`cinema_id`,`is_show`) values (1,4,1,1),(2,2,1,0),(3,1,1,0),(4,1,1,0),(5,2,1,0),(6,1,1,0),(7,1,1,0),(8,1,1,0),(9,1,1,0);

/*Table structure for table `cinema_customer` */

DROP TABLE IF EXISTS `cinema_customer`;

CREATE TABLE `cinema_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) NOT NULL COMMENT '电影院id',
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '对应电影院的管理员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema_customer` */

/*Table structure for table `cinema_hall` */

DROP TABLE IF EXISTS `cinema_hall`;

CREATE TABLE `cinema_hall` (
  `hall_id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) DEFAULT NULL,
  `max_seat` int(5) DEFAULT NULL COMMENT '最大座位数',
  `hall_name` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '影厅名称',
  PRIMARY KEY (`hall_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `cinema_hall` */

insert  into `cinema_hall`(`hall_id`,`cinema_id`,`max_seat`,`hall_name`) values (1,1,100,'三号厅'),(2,1,55,'2号厅'),(3,1,200,'string');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '用户全局唯一ID',
  `customer_name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名称',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
  `permission` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '用户权限',
  `phone` varchar(15) COLLATE utf8mb4_bin NOT NULL COMMENT '用户注册手机号',
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `avatar` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像,文件名',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`customer_name`,`password`,`permission`,`phone`,`email`,`avatar`) values ('8224808968','ceshi1','79bd317642b9843cc16fcde4076ac1f3','1','1101010101010','111@111.c11','111');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film` */

insert  into `film`(`film_id`,`film_name`,`create_time`,`release_date`,`actor`,`director`,`poster`,`introduction`,`type_id`,`language`,`duration`) values (4,'你的名字','2020-06-01 21:36:00','2017-08-26 21:36:00','神木隆之介，上白石萌音','新海诚','haibao.jpg','你的名字。》是由新海诚执导，由神木隆之介、上白石萌音担任主要配音的一部原创日本动画电影 [1]  。作品于2016年8月26日在日本上映。中国内地于2016年12月2日上映。作品讲述了男女高中生在梦中相遇，并寻找彼此的故事。','1,2,3','日文',107),(5,'你的名字','2020-06-01 21:36:00','2017-08-26 21:36:00','神木隆之介，上白石萌音','新海诚','haibao.jpg','你的名字。》是由新海诚执导，由神木隆之介、上白石萌音担任主要配音的一部原创日本动画电影 [1]  。作品于2016年8月26日在日本上映。中国内地于2016年12月2日上映。作品讲述了男女高中生在梦中相遇，并寻找彼此的故事。','1,2,3','日文',107);

/*Table structure for table `film_comment` */

DROP TABLE IF EXISTS `film_comment`;

CREATE TABLE `film_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `content` text COLLATE utf8mb4_bin NOT NULL COMMENT '评论内容',
  `score` int(4) NOT NULL COMMENT '评分',
  `film_id` int(11) NOT NULL COMMENT '评论对应的电影',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_comment` */

insert  into `film_comment`(`comment_id`,`customer_id`,`content`,`score`,`film_id`) values (1,'8224808968','3123123',2,4);

/*Table structure for table `film_schedule` */

DROP TABLE IF EXISTS `film_schedule`;

CREATE TABLE `film_schedule` (
  `schedule_id` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  `film_id` int(11) DEFAULT NULL,
  `cinema_id` int(11) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `hall_name` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL,
  `film_price` decimal(10,2) NOT NULL COMMENT '订票价格\r\n',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_schedule` */

insert  into `film_schedule`(`schedule_id`,`film_id`,`cinema_id`,`begin_time`,`end_time`,`hall_name`,`film_price`) values ('',4,1,NULL,NULL,NULL,'45.00');

/*Table structure for table `film_type` */

DROP TABLE IF EXISTS `film_type`;

CREATE TABLE `film_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `film_type` */

insert  into `film_type`(`type_id`,`type`) values (1,'喜剧'),(2,'惊悚'),(3,'3D'),(4,'2D'),(5,'动漫'),(6,'玄幻');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '订单id 有时间格式要求',
  `create_time` datetime NOT NULL COMMENT '订单创建时间',
  `customer_id` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '订票顾客',
  `order_cost` decimal(10,2) NOT NULL COMMENT '总金额',
  `real_cost` decimal(10,2) NOT NULL COMMENT '实际支付金额',
  `status` int(2) NOT NULL COMMENT '订单状态',
  `schedule_id` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对应场次号',
  `seat_number` int(20) DEFAULT NULL COMMENT '场次座位号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `order` */

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `permission` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`permission`) values (1,'Sadmin'),(2,'admin'),(3,'SVIP'),(4,'VIP'),(5,'consumer'),(6,'newone');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
