--
-- Table structure for table `Cars`
--
DROP TABLE IF EXISTS `Cars`;
CREATE TABLE `Cars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Cars`
--
INSERT INTO `Cars` VALUES (1,'Audi',52642),(2,'Mercedes',57127),(3,'Skoda',9000),(4,'Volvo',29000),(5,'Bentley',350000),(6,'Citroen',21000),(7,'Hummer',41400),(8,'Volkswagen',21600);