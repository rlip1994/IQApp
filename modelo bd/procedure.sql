-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (7,'30001','Detalle 1 ID 1','Detalle 2 ID 1',5),(8,'30002','Detalle 1 ID 2','Detalle 2 ID 2',5),(9,'30003','Detalle 1 ID 3','Detalle 2 ID 3',5),(10,'30004','Detalle 1 ID 4','Detalle 2 ID 4',6),(11,'30005','Detalle 1 ID 5','Detalle 2 ID 5',7),(12,'30006','Detalle 1 ID 6','Detalle 2 ID 6',5);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,'anws1',4),(2,'answer 2',NULL),(3,'anws1',4),(4,'answer 4',NULL),(5,'anws',NULL),(6,'anws3',NULL),(7,'anws3',NULL),(8,'anws4',NULL),(9,'anws5',NULL);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Categoria 1 '),(2,'Categoria 2 '),(3,'Categoria 3 '),(4,'Categoria 4 '),(5,'categoria1'),(6,'categoria2'),(7,'categoria3'),(8,'categoria4'),(9,'categoria5'),(10,'categoria6'),(11,'categoria7'),(12,'categoria8');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (5,'Esparza',7),(6,'Nicoya',8),(7,'Liberia',8);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Costa Rica'),(2,'Mexico'),(3,'Canada'),(4,'Estados Unidos'),(5,'Francia'),(6,'Italia'),(7,'Honduras'),(8,'Guatemala'),(9,'Panama'),(10,'Colombia');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `eventstypes`
--

LOCK TABLES `eventstypes` WRITE;
/*!40000 ALTER TABLE `eventstypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventstypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gamesxquestions`
--

LOCK TABLES `gamesxquestions` WRITE;
/*!40000 ALTER TABLE `gamesxquestions` DISABLE KEYS */;
/*!40000 ALTER TABLE `gamesxquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (1,'1'),(2,'2'),(3,'3'),(4,'4'),(5,'5'),(6,'6'),(7,'1'),(8,'2'),(9,'3'),(10,'4'),(11,'5'),(12,'6');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,NULL),(2,NULL),(3,NULL),(4,NULL);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `loggers`
--

LOCK TABLES `loggers` WRITE;
/*!40000 ALTER TABLE `loggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `loggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'Fulano',8,2,'apellido1','apellido2',1),(2,'Sutano',10,4,'apellido1','apellido2',2),(3,'Mengano',12,6,'apellido1','apellido2',3),(4,'Paco',9,3,'apellido1','apellido2',4),(5,'Lola',11,5,'apellido1','apellido2',5),(6,'Jeff',10,4,'apellido1','apellido2',6),(7,'Saul',8,2,'apellido1','apellido2',7);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `playersxaddresses`
--

LOCK TABLES `playersxaddresses` WRITE;
/*!40000 ALTER TABLE `playersxaddresses` DISABLE KEYS */;
INSERT INTO `playersxaddresses` VALUES (1,9,NULL,NULL),(2,10,NULL,NULL),(3,7,NULL,NULL),(4,8,NULL,NULL);
/*!40000 ALTER TABLE `playersxaddresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `playersxschools`
--

LOCK TABLES `playersxschools` WRITE;
/*!40000 ALTER TABLE `playersxschools` DISABLE KEYS */;
INSERT INTO `playersxschools` VALUES (2,1,1),(3,2,1),(4,3,2),(5,4,2);
/*!40000 ALTER TABLE `playersxschools` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `playersxusers`
--

LOCK TABLES `playersxusers` WRITE;
/*!40000 ALTER TABLE `playersxusers` DISABLE KEYS */;
INSERT INTO `playersxusers` VALUES (1,2),(2,2),(3,2),(4,2),(5,2);
/*!40000 ALTER TABLE `playersxusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (4,'pregunta1',1,1,3,NULL,NULL),(7,'pregunta2',2,2,2,NULL,NULL),(8,'pregunta3',3,3,3,NULL,NULL),(10,'pregunta4',4,4,4,NULL,NULL),(11,'pregunta5',5,5,5,NULL,NULL),(12,'pregunta6',6,6,6,NULL,NULL),(13,'pregunta7',7,1,5,NULL,NULL),(14,'pregunta8',8,2,2,NULL,NULL),(15,'pregunta9',1,3,3,NULL,NULL),(16,'pregunta10',9,3,3,NULL,NULL),(17,'pregunta11',9,3,3,NULL,NULL),(18,'pregunta12',11,3,3,NULL,NULL),(19,'pregunta 13 ',1,3,2,NULL,NULL),(20,'pregunta 20 ',1,3,4,NULL,NULL),(21,'pregunta 21 ',1,3,5,NULL,NULL),(22,'pregunta 22',1,3,4,NULL,NULL),(23,'pregunta 23',1,3,2,NULL,NULL),(24,'pregunta 24',1,3,3,NULL,NULL),(25,'pregunta 25',1,3,2,NULL,NULL),(26,'pregunta 26',1,3,4,NULL,NULL),(27,'pregunta 27',1,3,5,NULL,NULL),(28,'pregunta 28',1,3,4,NULL,NULL);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (5,'Alajuela',1),(6,'Turin',1),(7,'Paris',1),(8,'Heredia',1),(9,'Puntarenas',1),(10,'Guanacaste',1),(11,'Limon',1),(12,'Cartago',1);
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `schools`
--

LOCK TABLES `schools` WRITE;
/*!40000 ALTER TABLE `schools` DISABLE KEYS */;
INSERT INTO `schools` VALUES (1,'Escuela 1 ',7),(2,'Escuela 2',8),(3,'Escuela 3',9);
/*!40000 ALTER TABLE `schools` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `severities`
--

LOCK TABLES `severities` WRITE;
/*!40000 ALTER TABLE `severities` DISABLE KEYS */;
/*!40000 ALTER TABLE `severities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `times`
--

LOCK TABLES `times` WRITE;
/*!40000 ALTER TABLE `times` DISABLE KEYS */;
/*!40000 ALTER TABLE `times` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,'unit1'),(2,'unit2'),(3,'unit3'),(4,'unit4'),(5,'unit5'),(6,'unit6'),(7,'unit7');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'usernam1','email1@correo.com','1234',2,0),(3,'usernam2','email2@correo.com','5678',5,1),(4,'usernam3','email3@correo.com','1379',3,0),(5,'usernam4','email4@correo.com','2468',1,1),(6,'usernam5','email5@correo.com','12345',2,0),(7,'usernam5','email6@correo.com','123456',3,1),(8,'usernam6','email7@correo.com','1234567',4,0),(9,'usernam7','email8@correo.com','12345678',1,1),(10,'usernam7','email8@correo.com','12345678',1,1),(11,'usernam7','email8@correo.com','12345678',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `userstypes`
--

LOCK TABLES `userstypes` WRITE;
/*!40000 ALTER TABLE `userstypes` DISABLE KEYS */;
INSERT INTO `userstypes` VALUES (1,'tipoUsuario1'),(2,'tipoUsuario2'),(3,'tipoUsuario3'),(4,'tipoUsuario4'),(5,'tipoUsuario5');
/*!40000 ALTER TABLE `userstypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mydb'
--
/*!50003 DROP PROCEDURE IF EXISTS `getAllCategories` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCategories`()
BEGIN

SELECT * FROM mydb.`categories`;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllKidsxUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllKidsxUser`(pUserId INT)
BEGIN
	Select p.idplayer, concat(p. name , ' ', p.lastname1) as playername,p.idGrade,s.name as schoolname
	FROM playersxusers  pu INNER JOIN players p ON 
    pu.iduser = pUserId 
    AND pu.idplayer = p.idplayer
    INNER JOIN playersxschools ps ON 
    ps.idplayer = p.idplayer 
    INNER JOIN schools s ON 
    ps.idSchool = s.idSchool;
    -- AND p.enable ; Need add this sentence
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGroupQuestionsxCategory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGroupQuestionsxCategory`(pCategoryId INT,pGradeId INT)
BEGIN
	SELECT q.idquestion,q.description,q.idgrade,a.idanswer, a.value 
	FROM Questions q INNER JOIN Answers a ON q.idanswer = a.idanswer 
	AND q.idcategory = pCategoryId 
	AND q.idgrade = pGradeId
	ORDER BY RAND()
	LIMIT 10;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGroupQuestionsxCategoryText` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGroupQuestionsxCategoryText`(pCategoryId INT,pGradeId INT)
BEGIN
	SELECT q.idquestion,q.description,q.idgrade,a.idanswer, a.value 
	FROM Questions q INNER JOIN Answers a ON q.idanswer = a.idanswer 
	AND q.idcategory = pCategoryId 
	AND q.idgrade = pGradeId
	ORDER BY RAND()
	LIMIT 10;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-20 23:25:22
