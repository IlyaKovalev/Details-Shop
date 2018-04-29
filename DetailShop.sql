-- MySQL dump 10.16  Distrib 10.1.32-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: DetailShop
-- ------------------------------------------------------
-- Server version	10.1.32-MariaDB

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
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `name` varchar(70) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(55) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` int(11) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES ('Slavik','8-800-555-3535','Ex@mail.ru',355),('Ilya Kovalev','8-950-***-','Example@mail.ru',422),('Ilya','8-800-555-35-35','Load@mail.ru',-1986646271),('Krosh','555','re',3494868),('Коля','8-800-555-35','REX@mail.ru',-1530912774),('Dener','8-880-455','Shape@mail.ru',-1612171402);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detail`
--

DROP TABLE IF EXISTS `Detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detail`
--

LOCK TABLES `Detail` WRITE;
/*!40000 ALTER TABLE `Detail` DISABLE KEYS */;
INSERT INTO `Detail` VALUES (1,'Hammer','just hammer',1,500),(2,'Аккумулятор','Новая японская модель',-3,4000),(23,'Tree','something',40,233);
/*!40000 ALTER TABLE `Detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Shopping_list`
--

DROP TABLE IF EXISTS `Shopping_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Shopping_list` (
  `CustomerEmail` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `detailID` int(11) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `detailID` (`detailID`),
  KEY `Customer_fk` (`CustomerEmail`),
  CONSTRAINT `Customer_fk` FOREIGN KEY (`CustomerEmail`) REFERENCES `Customer` (`email`),
  CONSTRAINT `Shopping_list_ibfk_2` FOREIGN KEY (`detailID`) REFERENCES `Detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Shopping_list`
--

LOCK TABLES `Shopping_list` WRITE;
/*!40000 ALTER TABLE `Shopping_list` DISABLE KEYS */;
INSERT INTO `Shopping_list` VALUES (NULL,NULL,1,1),(NULL,NULL,1,2),(NULL,NULL,1,3),(NULL,2,2,4),(NULL,2,3,5),('REX@mail.ru',2,8,6),('REX@mail.ru',1,9,7),('REX@mail.ru',2,5,8),('REX@mail.ru',1,10,9),('REX@mail.ru',1,4,10),('REX@mail.ru',1,4,11),('REX@mail.ru',1,3,12),('REX@mail.ru',1,3,13),('REX@mail.ru',1,2,14),('REX@mail.ru',NULL,4,15),('REX@mail.ru',1,3,16),('REX@mail.ru',1,5,17),('REX@mail.ru',1,2,18),('REX@mail.ru',1,3,19),('REX@mail.ru',1,1,20),('REX@mail.ru',1,2,21),('REX@mail.ru',1,3,22),('REX@mail.ru',NULL,2,23),('REX@mail.ru',1,2,24),('REX@mail.ru',1,2,25),('REX@mail.ru',1,3,26),('REX@mail.ru',1,2,27),('REX@mail.ru',1,2,28),('REX@mail.ru',1,2,29),('REX@mail.ru',1,2,30),('REX@mail.ru',1,3,31),('Shape@mail.ru',1,3,32),('REX@mail.ru',1,2,33),('REX@mail.ru',1,12,34),('REX@mail.ru',1,0,35),('REX@mail.ru',1,0,36),('REX@mail.ru',1,2,37);
/*!40000 ALTER TABLE `Shopping_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-29 21:24:39
