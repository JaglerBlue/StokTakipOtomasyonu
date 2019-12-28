

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;

CREATE TABLE `doctors` (
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `doctorCode` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
INSERT INTO `doctors` VALUES ('orhan','şakar',NULL,1),('ali','veli',NULL,2),('asdff','dghdfgh','asd2314',3),('asdff','dghdfgh','1asd2314',4);
UNLOCK TABLES;


-- Dump completed on 2019-11-19 13:36:43
