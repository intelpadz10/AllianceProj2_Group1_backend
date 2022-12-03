CREATE DATABASE  IF NOT EXISTS `alliancedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `alliancedb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: alliancedb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_description` varchar(255) NOT NULL,
  `role_initials` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_description_UNIQUE` (`role_description`),
  UNIQUE KEY `role_initials_UNIQUE` (`role_initials`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'adminitrator','ADMIN'),(2,'human resources - admin','HRADMIN'),(3,'human resource','HR'),(4,'marketing','MAR'),(5,'dealer','DLR'),(6,'technical team','TECH'),(7,'finance','FIN'),(8,'research team','RES'),(9,'trainees','TRN'),(10,'customer','CUS');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT '"no description"',
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `status_name_UNIQUE` (`status_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'pending','ticket is waiting for updates'),(2,'in progress','ticket is currenty tended to'),(3,'on hold','ticket is on hold by users'),(4,'completed','ticket is marked completed'),(5,'cancelled','ticket  is cancelled'),(6,'archived','ticket is currenty tended to');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `assignee_id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `ticket_category` int(11) NOT NULL,
  `status_id` int(11) NOT NULL DEFAULT '1',
  `subject` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT 'no description',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deadline_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_location` varchar(455) DEFAULT 'none',
  PRIMARY KEY (`ticket_id`),
  KEY `ticket_ibfk_1_idx` (`assignee_id`),
  KEY `ticket_ibfk_2_idx` (`sender_id`),
  KEY `fk5_idx` (`status_id`),
  KEY `fk4_idx` (`ticket_category`),
  CONSTRAINT `fk4` FOREIGN KEY (`ticket_category`) REFERENCES `ticket_category` (`ticketcategory_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk5` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`assignee_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`sender_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,1,2,1,1,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(2,2,1,12,2,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(3,3,3,10,2,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(4,4,8,9,3,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(5,5,7,8,4,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(6,6,9,6,5,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(7,7,6,4,6,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(8,8,4,3,2,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(9,9,5,1,3,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(10,9,2,2,1,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(11,1,4,3,1,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(12,2,1,5,3,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(13,3,8,10,4,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(14,4,9,11,2,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(15,5,6,11,2,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(16,6,5,2,3,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(17,7,4,3,2,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(18,8,3,7,2,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(19,2,2,1,1,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(20,3,6,12,1,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(21,7,4,2,1,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(22,4,3,3,1,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(23,2,2,5,1,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(24,3,1,1,1,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path'),(25,5,2,6,1,'Deadline','Creation of Project','2022-11-23 00:05:18','2022-11-23 00:05:18','2022-11-29 08:51:25','content'),(26,9,7,9,1,'Deadline','Creation of Project','2022-11-23 00:24:44','2022-11-23 00:24:44','2022-11-29 08:51:25','content'),(27,1,6,11,1,'Deadline of Alliance Project','Deadline of Project sa alliance na giatay','2022-12-02 04:08:43','2022-12-02 04:08:43','2022-12-02 12:08:43','content-path');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_category`
--

DROP TABLE IF EXISTS `ticket_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_category` (
  `ticketcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticketcategory_name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `default_assignee` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticketcategory_id`),
  KEY `category_tbfk1_idx` (`default_assignee`),
  CONSTRAINT `category_tbfk1` FOREIGN KEY (`default_assignee`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_category`
--

LOCK TABLES `ticket_category` WRITE;
/*!40000 ALTER TABLE `ticket_category` DISABLE KEYS */;
INSERT INTO `ticket_category` VALUES (1,'Benefits','benefits',5),(2,'Payroll','payroll',6),(3,'Recruitment','recruitment',7),(4,'Training','training',9),(5,'PES','pes',9),(6,'Employee Relation','employee relation',5),(7,'Memo','memo',5),(8,'COE','coe',5),(9,'Engagement (RNR)','engagement',8),(10,'Policy','policy',5),(11,'Others','others',5),(12,'HR Business Partner','hr business partner',8);
/*!40000 ALTER TABLE `ticket_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_firstname` varchar(255) NOT NULL,
  `user_lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `image_link` varchar(425) DEFAULT 'https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  KEY `rolekeyforeign_idx` (`role_id`),
  CONSTRAINT `rolekeyforeign` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'carlgarcesblast1','Carl Benedict','Garces','admin@app.com','password','https://scontent.fceb1-3.fna.fbcdn.net/v/t39.30808-6/245082029_4951474298215767_923310700694901685_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=174925&_nc_eui2=AeEidj9Xjlzi8Kf8sn-YpbRd-rQYASCapGz6tBgBIJqkbGxLL8IXHKfs9s5eYsYRtXecU_Y1ZNycaapSf9nNqNMc&_nc_ohc=Gf1EoZGWAbQAX9g2Hvv&_nc_ht=scontent.fceb1-3.fna&oh=00_AT8SKfe22lGJ7aKsuo7x8KFKrJUS0LQ3_ff9tt12NYdcDw&oe=630BCAD8'),(2,1,'krystelpadigos','Krystel','Padigos','admin2@app.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(3,1,'petetiongzon','Pete','Tiongzon','admin3@app.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(4,1,'bessienacua','Bessie','Nacua','admin4@app.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(5,2,'saturninaalvarez','Saturnina','Alvarez','hr1@admin.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(6,2,'rejinealquisa','Rejine','Alquisa','hr2@admin.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(7,2,'pelisajaneligalig','Pelisa Jane','Ligalig','hr3@admin.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(8,2,'jasminepatalinghug','Jasmine','Patalinghug','hr4@admin.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png'),(9,2,'ma.gisellemabunga','Ma. Giselle','Mabunga','hr5@admin.com','password','https://user-images.githubusercontent.com/101482/29592647-40da86ca-875a-11e7-8bc3-941700b0a323.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'alliancedb'
--

--
-- Dumping routines for database 'alliancedb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04  0:14:11
