
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `doctorid` int(11) DEFAULT NULL,
  `patientid` int(11) DEFAULT NULL,
  `polyclinicid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `doctorid` (`doctorid`),
  KEY `patientid` (`patientid`),
  KEY `polyclinicid` (`polyclinicid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
INSERT INTO `appointments` VALUES (1, DATE('2033-10-01'),1,1,1),(2,DATE('2023-10-12'),1,2,2),(3,DATE('2035-11-01'),1,3,1);
UNLOCK TABLES;


-- Dump completed on 2019-11-19 13:36:43
