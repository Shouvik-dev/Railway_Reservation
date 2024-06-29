CREATE DATABASE  IF NOT EXISTS `railway_project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `railway_project`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: railway_project
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` varchar(15) NOT NULL,
  `admin_name` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Email` varchar(65) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `age` int NOT NULL,
  `ph_number` decimal(10,0) NOT NULL,
  `Gender` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `sate` varchar(45) NOT NULL,
  `pincode` int NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_name_UNIQUE` (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1001','admin','admin','Admin Admin','shouvikdasshoumo@gmail.com','2006-05-24',18,123456,'Others','N/A','N/A','N/A',0);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasenger`
--

DROP TABLE IF EXISTS `pasenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasenger` (
  `PNR_No` int DEFAULT NULL,
  `Train_no` varchar(100) DEFAULT NULL,
  `Pasenger_Name` varchar(100) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Phone_no` varchar(45) DEFAULT NULL,
  `Seat_no` int DEFAULT NULL,
  `Class` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasenger`
--

LOCK TABLES `pasenger` WRITE;
/*!40000 ALTER TABLE `pasenger` DISABLE KEYS */;
INSERT INTO `pasenger` VALUES (1594751,'12301','SHOUVIK DAS',20,'MALE','7686874104',1,'General'),(9795804,'12857','SHOUVIK DAS',20,'MALE','7686874104',1,'General'),(7855643,'12857','SHOUVIK DAS',20,'MALE','1234567890',2,'General'),(7272492,'12301','SHOUVIK DAS',20,'MALE','1234567890',2,'General'),(3119137,'12311','SUBHADEEP DAS',20,'MALE','8981217897',101,'AC Chair car'),(3119137,'12311','ADRIJA',16,'MALE','89546129',102,'AC Chair car'),(3119137,'12311','SHOUVIK',20,'MALE','984755152',103,'AC Chair car'),(3119137,'12311','AYAN',89,'MALE','789784230',104,'AC Chair car');
/*!40000 ALTER TABLE `pasenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_data`
--

DROP TABLE IF EXISTS `seat_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_data` (
  `Train_no` varchar(45) NOT NULL,
  `Train Name` varchar(100) DEFAULT NULL,
  `Gen_seat_start` int DEFAULT NULL,
  `Gen_seat_cur` int DEFAULT NULL,
  `Gen_seat_end` int DEFAULT NULL,
  `Sleep_seat_start` int DEFAULT NULL,
  `Sleep_seat_cur` int DEFAULT NULL,
  `Sleep_seat_end` int DEFAULT NULL,
  `AC_seat_start` int DEFAULT NULL,
  `AC_seat_cur` int DEFAULT NULL,
  `AC_seat_end` int DEFAULT NULL,
  PRIMARY KEY (`Train_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_data`
--

LOCK TABLES `seat_data` WRITE;
/*!40000 ALTER TABLE `seat_data` DISABLE KEYS */;
INSERT INTO `seat_data` VALUES ('12301','Howrah - New Delhi Rajdhani Express',1,3,50,51,51,70,71,71,120),('12311',' Netaji Express',1,1,50,51,51,100,101,105,150),('12423','Rajdhani Express',5,5,10,6,6,20,7,7,30),('12559','Sapt Kranti Express',6,6,10,7,7,20,8,8,30),('12615','Grand Trunk Express',3,3,10,4,4,20,5,5,30),('12649','Sampark Kranti Express',1,1,10,11,11,20,21,21,30),('12723','Andhra Pradesh Express',7,7,10,8,8,20,9,9,30),('12857','Tamrolipta Express',1,3,50,0,0,0,51,51,150),('12903','Golden Temple Mail',2,2,10,3,3,20,4,4,30),('12951','Mumbai Central - New Delhi Rajdhani Express',1,1,50,51,51,90,91,91,120);
/*!40000 ALTER TABLE `seat_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `pnr_no` decimal(10,0) NOT NULL,
  `tr_no` varchar(45) DEFAULT NULL,
  `t_name` varchar(100) NOT NULL,
  `source` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `b_time` time DEFAULT NULL,
  `b_date` date DEFAULT NULL,
  `booked_by` varchar(65) DEFAULT NULL,
  `Distance` decimal(10,0) DEFAULT NULL,
  `fare` decimal(10,0) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pnr_no`),
  KEY `t_no` (`tr_no`),
  KEY `t_name` (`t_name`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`tr_no`) REFERENCES `train` (`TRAIN_NO`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`t_name`) REFERENCES `train` (`TRAIN_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1594751,'12301','Howrah - New Delhi Rajdhani Express','Howrah Junction',' New Delhi','13:05:45','2024-06-26','Admin Admin',10,1000,'confirm'),(3119137,'12311',' Netaji Express','Howrah Junction','Kalka','13:13:24','2024-06-28','admin',10,1000,'confirm'),(7272492,'12301','Howrah - New Delhi Rajdhani Express','Howrah Junction','New Delhi','21:05:06','2024-06-26','Example Name',10,1000,'confirm'),(7855643,'12857','Tamrolipta Express','Howrah Junction','Digha','20:33:58','2024-06-26','Admin Admin',10,1000,'confirm'),(9795804,'12857','Tamrolipta Express','Howrah Junction','Digha','15:48:47','2024-06-26','Example Name',10,1000,'confirm');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train` (
  `TRAIN_NO` varchar(45) NOT NULL,
  `TRAIN_NAME` varchar(100) NOT NULL,
  `SRCE` varchar(65) NOT NULL,
  `DEP_DATE` date NOT NULL,
  `DEP_TIME` varchar(15) NOT NULL,
  `DEST` varchar(65) NOT NULL,
  `ARV_DATE` date NOT NULL,
  `ARV_TIME` varchar(15) NOT NULL,
  `GEL_SEAT` int DEFAULT NULL,
  `GEN_SEAT_AV` int DEFAULT NULL,
  `gen_fare` decimal(10,0) NOT NULL,
  `SLE_SEAT` int DEFAULT NULL,
  `SLE_SEAT_AV` int DEFAULT NULL,
  `SLE_FARE` decimal(10,0) DEFAULT NULL,
  `AC_SEAT` int DEFAULT NULL,
  `AC_SEAT_AV` int DEFAULT NULL,
  `AC_FARE` decimal(10,0) DEFAULT NULL,
  `TOTAL_AVV_SEAT` int DEFAULT NULL,
  `TOTAL_SEAT` int DEFAULT NULL,
  `Distance` decimal(10,0) NOT NULL,
  PRIMARY KEY (`TRAIN_NO`),
  UNIQUE KEY `SEAT_NO_UNIQUE` (`TRAIN_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES ('12301','Howrah - New Delhi Rajdhani Express','Howrah Junction','2024-06-30','12:40 PM','New Delhi','2024-07-03','12:40 PM',50,48,100,20,20,200,50,50,300,120,120,1450),('12311',' Netaji Express','Howrah Junction','2024-06-28','03:26 PM','Kalka','2024-06-30','03:26 PM',50,50,100,50,50,200,50,46,300,150,150,1713),('12423','Rajdhani Express','Dibrugarh Town','2024-07-10','07:05 PM',' New Delhi','2024-07-10','07:05 PM',6,6,120,15,15,220,24,24,3856,45,45,2430),('12559','Sapt Kranti Express','Muzaffarpur Junction','2024-07-11','12:05 PM',' Anand Vihar Terminal','2024-07-12','12:05 PM',5,5,400,14,14,720,23,23,1140,42,42,1055),('12615','Grand Trunk Express','Chennai Central','2024-07-02','07:05 PM','New Delhi','2024-07-03','07:05 PM',8,8,465,17,17,830,26,26,3380,51,51,2180),('12649','Sampark Kranti Express',' Yeshvantpur Junction','2024-06-29','06:30 PM','Hazrat Nizamuddin','2024-06-30','06:30 PM',10,10,515,10,10,925,10,10,3505,30,30,244),('12723','Andhra Pradesh Express','Hyderabad Deccan','2024-07-12','12:05 PM','New Delhi','2024-06-14','12:05 PM',4,4,240,13,13,255,22,22,3465,39,39,244),('12857','Tamrolipta Express','Howrah Junction','2024-06-27','06:49 AM','Digha','2024-06-27','06:49 AM',50,48,105,0,0,0,100,100,355,150,150,185),('12903','Golden Temple Mail','Mumbai Central','2024-06-29','10:19 PM','Amritsar Junction','2024-07-01','10:19 PM',9,9,435,18,18,775,27,27,3145,54,54,1893),('12951','Mumbai Central - New Delhi Rajdhani Express','Mumbai Central','2024-08-01','10:30 AM','New Delhi','2024-06-02','10:30 AM',50,50,200,40,40,300,30,30,400,120,120,1386);
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(10) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Email` varchar(65) DEFAULT NULL,
  `DOB` date NOT NULL,
  `age` int DEFAULT NULL,
  `ph_no` decimal(10,0) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `pin_code` int NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1001','user','user','User User','shouvikdasshoumo@gmail.com','1970-01-01',54,123456,'Others','N/A','N/A','N/A',123),('12345600','Shouvik','123456','Shouvik Das','shoumodas2004@gmail.com','2006-06-26',18,7894561235,'Male','Kestopur','Kolkata','West Bengal',12345679);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28 23:59:43
