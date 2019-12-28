

DROP TABLE IF EXISTS `appmanagers`;

CREATE TABLE `appmanagers` (
    `firstName` VARCHAR(45) DEFAULT NULL,
    `lastName` VARCHAR(45) DEFAULT NULL,
    `userName` VARCHAR(45) DEFAULT NULL,
    `password` VARCHAR(45) DEFAULT NULL,
    `id` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
);

--
-- Dumping data for table `appmanagers`
--

LOCK TABLES `appmanagers` WRITE;
INSERT INTO `appmanagers` VALUES ('orhan','şakar','orhan','123',1),('ali','veli','ali','123',2),('mete','arslan','Mete','1234',5);
UNLOCK TABLES;



-- Dump completed on 2019-11-19 13:36:42
