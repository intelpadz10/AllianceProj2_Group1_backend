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
  `role_id` int(11) NOT NULL,
  `role_description` varchar(255) NOT NULL,
  `role_initials` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `status_id` int(11) NOT NULL,
  `status_name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT '"no description"',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `status` int(11) NOT NULL DEFAULT '1',
  `subject` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT 'no description',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deadline_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `document_path` varchar(1000) DEFAULT '"none"',
  PRIMARY KEY (`ticket_id`),
  KEY `ticket_class` (`ticket_category`),
  KEY `ticket_ibfk_1_idx` (`assignee_id`),
  KEY `ticket_ibfk_2_idx` (`sender_id`),
  KEY `ticket_ibfk_5_idx` (`status`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`assignee_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`sender_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`ticket_category`) REFERENCES `ticket_category` (`ticketcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticket_ibfk_5` FOREIGN KEY (`status`) REFERENCES `status` (`status_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,6,6,2,1,'New Creations','Acquisition of StartupEnt Inc.','2022-11-18 00:32:21','2022-11-18 00:32:21','2022-11-18 08:51:25','\"none\"'),(2,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:32:30','2022-11-18 00:32:30','2022-12-16 04:12:12','\"none\"'),(3,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:37:25','2022-11-18 00:37:25','2022-12-16 04:12:12','\"none\"'),(4,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:37:56','2022-11-18 00:37:56','2022-12-16 04:12:12','\"none\"'),(5,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:38:20','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(6,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:38:44','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(7,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:38:47','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(8,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:38:58','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(9,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:39:27','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(10,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:39:32','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(11,5,1,1,1,'Claiming Bonuses','My bonus for creating this application','2022-11-18 00:44:00','2022-11-20 11:40:09','2022-12-16 04:12:12','\"none\"'),(12,5,1,1,1,'FREE CAR','My bonus for creating this application','2022-11-18 01:02:02','2022-11-20 11:40:09','2022-12-31 17:01:01','\"none\"'),(13,2,1,11,3,'New Acquisition','Acquisition of StartupEnt Inc.','2022-11-18 00:32:21','2022-11-20 11:40:09','2022-11-18 08:25:50','\"none\"'),(14,2,2,11,3,'New Creations','Acquisition of StartupEnt Inc.','2022-11-18 00:32:21','2022-11-20 11:40:09','2022-11-18 08:43:45','\"none\"');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_category`
--

DROP TABLE IF EXISTS `ticket_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_category` (
  `ticketcategory_id` int(11) NOT NULL,
  `ticketcategory_name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `default_assignee` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticketcategory_id`),
  KEY `category_tbfk1_idx` (`default_assignee`),
  CONSTRAINT `category_tbfk1` FOREIGN KEY (`default_assignee`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON UPDATE CASCADE
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

-- Dump completed on 2022-11-20 21:34:09
