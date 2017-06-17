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
-- Table structure for table `aw_singlematch`
--

DROP TABLE IF EXISTS `aw_singlematch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aw_singlematch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `homeContestant` int(11) NOT NULL COMMENT '主场选手',
  `awayPlayer` int(11) NOT NULL COMMENT '客场选手',
  `matchTime` datetime NOT NULL COMMENT '比赛时间',
  `matchPlace` int(11) NOT NULL COMMENT '比赛地点',
  `tournamentId` int(11) NOT NULL COMMENT '该比赛所属赛事',
  `entry` int(11) NOT NULL COMMENT '参赛项目:1-男单；2-女单；3-混单',
  `round` int(11) NOT NULL COMMENT '该比赛所属轮次',
  `sets` int(11) NOT NULL COMMENT '比赛盘数',
  `outcome` char(1) DEFAULT NULL,
  `HCPoint` int(11) NOT NULL COMMENT '主场选手积分',
  `APPoint` int(11) NOT NULL COMMENT '客场选手积分',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `invalid` tinyint(1) DEFAULT '0' COMMENT '记录无效',
  `note` text COMMENT '注释',
  `HCRetired` tinyint(1) NOT NULL DEFAULT '0' COMMENT '主场选手退赛',
  `APRetired` tinyint(1) NOT NULL DEFAULT '0' COMMENT '客场选手退赛',
  `isHCChallenger` tinyint(1) NOT NULL DEFAULT '0' COMMENT '主场选手为挑战者',
  `isAPChallenger` tinyint(1) NOT NULL DEFAULT '0' COMMENT '客场选手为挑战者',
  UNIQUE KEY `id` (`id`),
  KEY `sm_matchPlace` (`matchPlace`),
  KEY `sm_tournamentID` (`tournamentId`),
  KEY `index_sm_hc` (`homeContestant`),
  KEY `index_sm_ap` (`awayPlayer`),
  CONSTRAINT `sm_awayPlayer` FOREIGN KEY (`awayPlayer`) REFERENCES `aw_user` (`id`),
  CONSTRAINT `sm_homeContestant` FOREIGN KEY (`homeContestant`) REFERENCES `aw_user` (`id`),
  CONSTRAINT `sm_matchPlace` FOREIGN KEY (`matchPlace`) REFERENCES `aw_arena` (`id`),
  CONSTRAINT `sm_tournamentID` FOREIGN KEY (`tournamentId`) REFERENCES `aw_tournament` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='单打比赛记录表';
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
