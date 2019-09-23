-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dbo.KHACH_HANG`
--

DROP TABLE IF EXISTS `dbo.KHACH_HANG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.KHACH_HANG` (
  `Ma_Khach_hang` varchar(10) DEFAULT NULL,
  `Password` varchar(4) DEFAULT NULL,
  `Ten_Khach_hang` varchar(16) DEFAULT NULL,
  `Ngay_sinh` varchar(10) DEFAULT NULL,
  `Dia_Chi` varchar(6) DEFAULT NULL,
  `Phone` bigint(20) DEFAULT NULL,
  `Name` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.KHACH_HANG`
--

LOCK TABLES `dbo.KHACH_HANG` WRITE;
/*!40000 ALTER TABLE `dbo.KHACH_HANG` DISABLE KEYS */;
INSERT INTO `dbo.KHACH_HANG` VALUES ('KH01      ','kh01','Nguyễn Hoàng Hải','1995-10-20','Hà Nội',963210438,'Nguyễn Hoàng Hải'),('KH02      ','kh02','Nguyễn Thị Huệ','1993-03-23','Hà Nội',989485719,'Nguyễn Hoàng Hải'),('KH03      ','kh03','Mai Thị Giang','2000-10-20','Hà Nội',123123123,'Nguyễn Hoàng Hải'),('KH04      ','kh04','Uchiha Itachi','2000-01-01','Konoha',123456789,'Nguyễn Hoàng Hải'),('KH05      ','kh05','Gaara','1970-01-01','Sand',123123321,'');
/*!40000 ALTER TABLE `dbo.KHACH_HANG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.PHIEU_MUON`
--

DROP TABLE IF EXISTS `dbo.PHIEU_MUON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.PHIEU_MUON` (
  `Ma_Phieu_muon` varchar(10) DEFAULT NULL,
  `Ma_Khach_hang` varchar(10) DEFAULT NULL,
  `Ma_Sach` varchar(10) DEFAULT NULL,
  `Ngay_muon` varchar(10) DEFAULT NULL,
  `Han_tra` varchar(10) DEFAULT NULL,
  `Name` varchar(16) DEFAULT NULL,
  `Ngaytra` varchar(10) DEFAULT NULL,
  `TienDatCoc` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.PHIEU_MUON`
--

LOCK TABLES `dbo.PHIEU_MUON` WRITE;
/*!40000 ALTER TABLE `dbo.PHIEU_MUON` DISABLE KEYS */;
INSERT INTO `dbo.PHIEU_MUON` VALUES ('PM01      ','KH01      ','MS02      ','2015-10-16','2016-10-16','Nguyễn Hoàng Hải','',1),('PM02      ','KH03      ','MS01      ','2015-10-21','2016-10-21','Nguyễn Hoàng Hải','',2),('PM03      ','KH02      ','MS01      ','2015-10-10','2015-10-12','Nguyễn Hoàng Hải','',3),('PM04      ','KH01      ','MS05      ','2015-10-16','2016-10-16','Nguyễn Hoàng Hải','2015-11-05',4),('PM05      ','KH01      ','MS01      ','2014-10-16','2015-01-01','Nguyễn Hoàng Hải','2015-11-05',5);
/*!40000 ALTER TABLE `dbo.PHIEU_MUON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.QUAN_TRI`
--

DROP TABLE IF EXISTS `dbo.QUAN_TRI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.QUAN_TRI` (
  `Ma_Admin` varchar(10) DEFAULT NULL,
  `Password` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.QUAN_TRI`
--

LOCK TABLES `dbo.QUAN_TRI` WRITE;
/*!40000 ALTER TABLE `dbo.QUAN_TRI` DISABLE KEYS */;
INSERT INTO `dbo.QUAN_TRI` VALUES ('admin     ','admin');
/*!40000 ALTER TABLE `dbo.QUAN_TRI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.SACH`
--

DROP TABLE IF EXISTS `dbo.SACH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.SACH` (
  `Ma_Sach` varchar(10) DEFAULT NULL,
  `Ten_Sach` varchar(40) DEFAULT NULL,
  `Ten_Tac_gia` varchar(17) DEFAULT NULL,
  `Nha_xb` varchar(4) DEFAULT NULL,
  `Gia_tien` mediumint(9) DEFAULT NULL,
  `So_luong` tinyint(4) DEFAULT NULL,
  `Name` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.SACH`
--

LOCK TABLES `dbo.SACH` WRITE;
/*!40000 ALTER TABLE `dbo.SACH` DISABLE KEYS */;
INSERT INTO `dbo.SACH` VALUES ('MS01      ','Lập trình hướng đối tượng','Cao Tuấn Dũng','BKHN',20000,20,'Nguyễn Hoàng Hải'),('MS02      ','Project','Lê Thị Hoa','BKHN',22000,20,'Nguyễn Hoàng Hải'),('MS03      ','Phân tích và thiết kế hệ thống thông tin','Nguyễn Thanh Hùng','BKHN',24000,30,'Nguyễn Hoàng Hải'),('MS04      ','Toán rời rạc','Nguyễn Đức Nghĩa','KHTN',30000,25,'Nguyễn Hoàng Hải'),('MS05      ','Tin học đại cương','Nguyễn Bá Ngọc','BKHN',40000,50,''),('MS06      ','Tán gái đại cương','Nguyễn Hoàng Hải','BKAV',1000,1,'Nguyễn Hoàng Hải');
/*!40000 ALTER TABLE `dbo.SACH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.sysdiagrams`
--

DROP TABLE IF EXISTS `dbo.sysdiagrams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.sysdiagrams` (
  `name` varchar(0) DEFAULT NULL,
  `principal_id` varchar(0) DEFAULT NULL,
  `diagram_id` varchar(0) DEFAULT NULL,
  `version` varchar(0) DEFAULT NULL,
  `definition` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.sysdiagrams`
--

LOCK TABLES `dbo.sysdiagrams` WRITE;
/*!40000 ALTER TABLE `dbo.sysdiagrams` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.sysdiagrams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-22 15:20:25
