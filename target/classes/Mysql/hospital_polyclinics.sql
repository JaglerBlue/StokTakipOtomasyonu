-- Table structure for table `polyclinics`
--

DROP TABLE IF EXISTS `polyclinics`;

CREATE TABLE `polyclinics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);


--
-- Dumping data for table `polyclinics`
--

LOCK TABLES `polyclinics` WRITE;
INSERT INTO `polyclinics` VALUES (1,'kulak'),(2,'burun'),(3,'bogaz'),(4,'goz');
UNLOCK TABLES;


-- Dump completed on 2019-11-19 13:36:43
