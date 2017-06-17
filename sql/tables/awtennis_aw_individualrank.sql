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
-- Table structure for table `aw_individualrank`
--

DROP TABLE IF EXISTS `aw_individualrank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aw_individualrank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '选手ID',
  `entry` int(11) NOT NULL COMMENT '参赛项目(包括男单、女单、混合单打、双打个人)',
  `totalPoint` double DEFAULT '0' COMMENT '当前赛季总积分',
  `currentRank` int(11) DEFAULT NULL COMMENT '当前排名',
  `rankingChange` int(11) DEFAULT '0' COMMENT '当周排名变化',
  `wins` int(11) DEFAULT NULL COMMENT '当前赛季总胜场数',
  `totalMatchs` int(11) DEFAULT NULL COMMENT '当前赛季总参赛场数',
  `totalMarginBureau` int(11) DEFAULT NULL COMMENT '当前赛季总净胜局',
  `year` int(11) NOT NULL COMMENT '年份',
  `week` int(11) NOT NULL COMMENT '第几周',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `invalid` tinyint(1) DEFAULT '0' COMMENT '记录无效',
  `note` text COMMENT '注释',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `index_ir_userID` (`userId`),
  KEY `index_ir_entry` (`entry`),
  KEY `index_ir_year` (`year`),
  KEY `index_ir_week` (`week`),
  CONSTRAINT `ir_userID` FOREIGN KEY (`userId`) REFERENCES `aw_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛季个人排名表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-17 17:50:01
