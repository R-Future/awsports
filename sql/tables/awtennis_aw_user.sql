-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: awtennis
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `aw_user`
--

DROP TABLE IF EXISTS `aw_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aw_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(10) NOT NULL COMMENT '用户登陆名',
  `password` char(10) NOT NULL COMMENT '用户登陆密码',
  `nickname` char(10) DEFAULT NULL COMMENT '用户昵称',
  `portrait` char(30) DEFAULT NULL COMMENT '用户头像',
  `realName` char(10) DEFAULT NULL COMMENT '用户真实姓名',
  `idcard` char(20) DEFAULT NULL COMMENT '用户身份证号',
  `phone` char(10) DEFAULT NULL COMMENT '用户联系号码',
  `email` char(20) DEFAULT NULL COMMENT '用户邮箱',
  `sex` tinyint(1) NOT NULL COMMENT '0-男；1-女',
  `height` double DEFAULT NULL COMMENT '身高cm',
  `weight` double DEFAULT NULL COMMENT '体重kg',
  `level` double DEFAULT NULL COMMENT '技术水平,默认3.0',
  `playedYears` double DEFAULT '0' COMMENT '球龄,默认为0',
  `forehand` int(11) NOT NULL COMMENT '1-右手；2-左手；3-双手',
  `backhand` tinyint(1) NOT NULL COMMENT '0-双反；1-单反',
  `address` char(20) DEFAULT NULL COMMENT '现居地',
  `singleTitles` int(11) DEFAULT '0' COMMENT '单打冠军数',
  `doubleTitles` int(11) DEFAULT '0' COMMENT '双打冠军数',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `invalid` tinyint(1) DEFAULT '0' COMMENT '消息无效',
  `grade` varchar(10) DEFAULT NULL COMMENT '组别(如金组)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `index_ui_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户个人信息表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-17 17:50:03
