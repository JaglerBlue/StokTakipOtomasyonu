

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;

CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tcNo` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
INSERT INTO `patients` VALUES (1,'12345','asdfsd','gfdhdf'),(2,'2343','asdfsd','gfdhdf'),(3,'23463','asdfsd','gfdhdf'),(4,'23333','wedge','gdfgdf'),(5,'23943','sadfg','dfgh');
UNLOCK TABLES;

-- Dump completed on 2019-11-19 13:36:42
