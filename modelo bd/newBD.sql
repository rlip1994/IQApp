-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`countries` (
  `idCountry` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`idCountry`))
ENGINE = InnoDB
AUTO_INCREMENT = 53
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`regions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`regions` (
  `idRegion` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `idCountry` INT(11) NOT NULL,
  PRIMARY KEY (`idRegion`),
  INDEX `fk_Regions_Countries1_idx` (`idCountry` ASC),
  CONSTRAINT `fk_Regions_Countries1`
    FOREIGN KEY (`idCountry`)
    REFERENCES `mydb`.`countries` (`idCountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cities` (
  `idCitiy` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `idRegion` INT(11) NOT NULL,
  PRIMARY KEY (`idCitiy`),
  INDEX `fk_Cities_Regions1_idx` (`idRegion` ASC),
  CONSTRAINT `fk_Cities_Regions1`
    FOREIGN KEY (`idRegion`)
    REFERENCES `mydb`.`regions` (`idRegion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`addresses` (
  `idAddress` INT(11) NOT NULL AUTO_INCREMENT,
  `zipCode` VARCHAR(15) NOT NULL,
  `detail1` VARCHAR(300) NOT NULL,
  `detail2` VARCHAR(45) NULL DEFAULT NULL,
  `idCitiy` INT(11) NOT NULL,
  PRIMARY KEY (`idAddress`),
  INDEX `fk_Addresses_Cities1_idx` (`idCitiy` ASC),
  CONSTRAINT `fk_Addresses_Cities1`
    FOREIGN KEY (`idCitiy`)
    REFERENCES `mydb`.`cities` (`idCitiy`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`images`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`images` (
  `idimage` INT(11) NOT NULL AUTO_INCREMENT,
  `value` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`idimage`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`answers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`answers` (
  `idanswer` INT(11) NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(50) NOT NULL,
  `idimage` INT(11) NOT NULL,
  PRIMARY KEY (`idanswer`),
  INDEX `fk_Answers_Images1_idx` (`idimage` ASC),
  CONSTRAINT `fk_Answers_Images1`
    FOREIGN KEY (`idimage`)
    REFERENCES `mydb`.`images` (`idimage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categories` (
  `idcategory` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`severities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`severities` (
  `idseverity` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idseverity`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`eventstypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`eventstypes` (
  `ideventType` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `idseverity` INT(11) NOT NULL,
  PRIMARY KEY (`ideventType`),
  INDEX `fk_eventType_severity1_idx` (`idseverity` ASC),
  CONSTRAINT `fk_eventType_severity1`
    FOREIGN KEY (`idseverity`)
    REFERENCES `mydb`.`severities` (`idseverity`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`grades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`grades` (
  `idgrade` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idgrade`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`players` (
  `idplayer` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `age` INT(11) NOT NULL,
  `idgrade` INT(11) NOT NULL,
  `lastname1` VARCHAR(50) NOT NULL,
  `lastname2` VARCHAR(50) NULL DEFAULT NULL,
  `enable` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idplayer`),
  INDEX `fk_Players_Grades1_idx` (`idgrade` ASC),
  CONSTRAINT `fk_Players_Grades1`
    FOREIGN KEY (`idgrade`)
    REFERENCES `mydb`.`grades` (`idgrade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`games` (
  `idgame` INT(11) NOT NULL AUTO_INCREMENT,
  `idplayer` INT(11) NOT NULL,
  `totalPoints` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`idgame`),
  INDEX `fk_game_player1_idx` (`idplayer` ASC),
  CONSTRAINT `fk_game_player1`
    FOREIGN KEY (`idplayer`)
    REFERENCES `mydb`.`players` (`idplayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`units`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`units` (
  `idUnit` INT(11) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idUnit`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`times`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`times` (
  `idTime` INT(11) NOT NULL,
  `value` DECIMAL(10,0) NOT NULL,
  `idUnit` INT(11) NOT NULL,
  PRIMARY KEY (`idTime`),
  INDEX `fk_Times_Units1_idx` (`idUnit` ASC),
  CONSTRAINT `fk_Times_Units1`
    FOREIGN KEY (`idUnit`)
    REFERENCES `mydb`.`units` (`idUnit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`questions` (
  `idquestion` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(350) NOT NULL,
  `idcategory` INT(11) NOT NULL,
  `idgrade` INT(11) NOT NULL,
  `idanswer` INT(11) NOT NULL,
  `points` DECIMAL(10,0) NOT NULL,
  `idTime` INT(11) NOT NULL,
  PRIMARY KEY (`idquestion`),
  INDEX `fk_question_category_idx` (`idcategory` ASC),
  INDEX `fk_question_answer1_idx` (`idanswer` ASC),
  INDEX `fk_question_grade1_idx` (`idgrade` ASC),
  INDEX `fk_Questions_Times1_idx` (`idTime` ASC),
  CONSTRAINT `fk_Questions_Times1`
    FOREIGN KEY (`idTime`)
    REFERENCES `mydb`.`times` (`idTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_answer1`
    FOREIGN KEY (`idanswer`)
    REFERENCES `mydb`.`answers` (`idanswer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_category`
    FOREIGN KEY (`idcategory`)
    REFERENCES `mydb`.`categories` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_grade1`
    FOREIGN KEY (`idgrade`)
    REFERENCES `mydb`.`grades` (`idgrade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`gamesxquestions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gamesxquestions` (
  `idGameXQuestion` INT(11) NOT NULL AUTO_INCREMENT,
  `idgame` INT(11) NOT NULL,
  `idquestion` INT(11) NOT NULL,
  `points` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`idGameXQuestion`, `idgame`, `idquestion`),
  INDEX `fk_GamesXQuestions_Games1_idx` (`idgame` ASC),
  INDEX `fk_GamesXQuestions_Questions1_idx` (`idquestion` ASC),
  CONSTRAINT `fk_GamesXQuestions_Games1`
    FOREIGN KEY (`idgame`)
    REFERENCES `mydb`.`games` (`idgame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GamesXQuestions_Questions1`
    FOREIGN KEY (`idquestion`)
    REFERENCES `mydb`.`questions` (`idquestion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`loggers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`loggers` (
  `idlogger` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(300) NOT NULL,
  `date` DATE NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `computerName` VARCHAR(30) NOT NULL,
  `postDate` DATE NOT NULL,
  `checksum` BINARY(150) NOT NULL,
  `ideventType` INT(11) NOT NULL,
  PRIMARY KEY (`idlogger`),
  INDEX `fk_logger_eventType1_idx` (`ideventType` ASC),
  CONSTRAINT `fk_logger_eventType1`
    FOREIGN KEY (`ideventType`)
    REFERENCES `mydb`.`eventstypes` (`ideventType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`playersxaddresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playersxaddresses` (
  `idplayer` INT(11) NOT NULL,
  `idAddress` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  `enable` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idplayer`, `idAddress`),
  INDEX `fk_Players_has_Addresses_Addresses1_idx` (`idAddress` ASC),
  INDEX `fk_Players_has_Addresses_Players1_idx` (`idplayer` ASC),
  CONSTRAINT `fk_Players_has_Addresses_Addresses1`
    FOREIGN KEY (`idAddress`)
    REFERENCES `mydb`.`addresses` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Players_has_Addresses_Players1`
    FOREIGN KEY (`idplayer`)
    REFERENCES `mydb`.`players` (`idplayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`schools`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schools` (
  `idSchool` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `idAddress` INT(11) NOT NULL,
  PRIMARY KEY (`idSchool`),
  INDEX `fk_Schools_Addresses1_idx` (`idAddress` ASC),
  CONSTRAINT `fk_Schools_Addresses1`
    FOREIGN KEY (`idAddress`)
    REFERENCES `mydb`.`addresses` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`playersxschools`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playersxschools` (
  `idPlayerXSchool` INT(11) NOT NULL AUTO_INCREMENT,
  `idplayer` INT(11) NOT NULL,
  `idSchool` INT(11) NOT NULL,
  PRIMARY KEY (`idPlayerXSchool`, `idplayer`, `idSchool`),
  INDEX `fk_Players_has_Schools_Schools1_idx` (`idSchool` ASC),
  INDEX `fk_Players_has_Schools_Players1_idx` (`idplayer` ASC),
  CONSTRAINT `fk_Players_has_Schools_Players1`
    FOREIGN KEY (`idplayer`)
    REFERENCES `mydb`.`players` (`idplayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Players_has_Schools_Schools1`
    FOREIGN KEY (`idSchool`)
    REFERENCES `mydb`.`schools` (`idSchool`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`userstypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`userstypes` (
  `iduserType` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`iduserType`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARBINARY(60) NOT NULL,
  `iduserType` INT(11) NOT NULL,
  `enable` TINYINT(4) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `lastname1` VARCHAR(50) NOT NULL,
  `lastname2` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`iduser`),
  INDEX `fk_user_userType1_idx` (`iduserType` ASC),
  CONSTRAINT `fk_user_userType1`
    FOREIGN KEY (`iduserType`)
    REFERENCES `mydb`.`userstypes` (`iduserType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`playersxusers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playersxusers` (
  `idplayer` INT(11) NOT NULL,
  `iduser` INT(11) NOT NULL,
  PRIMARY KEY (`idplayer`, `iduser`),
  INDEX `fk_Players_has_Users_Users1_idx` (`iduser` ASC),
  INDEX `fk_Players_has_Users_Players1_idx` (`idplayer` ASC),
  CONSTRAINT `fk_Players_has_Users_Players1`
    FOREIGN KEY (`idplayer`)
    REFERENCES `mydb`.`players` (`idplayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Players_has_Users_Users1`
    FOREIGN KEY (`iduser`)
    REFERENCES `mydb`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `mydb` ;

-- -----------------------------------------------------
-- procedure getAllCategories
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCategories`()
BEGIN

SELECT name FROM mydb.categories;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getAllKidsxUser
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllKidsxUser`(pUserName nvarchar(16))
BEGIN

Select players.idplayer,players.name, players.age, players.idgrade, players.lastname1, players.lastname2 from mydb.playersxusers inner join mydb.players on players.idPlayer=playersxusers.idPlayer inner join mydb.users on users.iduser=playersxusers.iduser where username=pUserName and players.enable=True ;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getGroupQuestionsxCategory
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGroupQuestionsxCategory`(pCategoryName nvarchar(16))
BEGIN

Select questions.description , questions.points from mydb.questions inner join mydb.categories on categories.idcategory=questions.idcategory and categories.name=pCategoryName;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_addKid
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addKid`(pName varchar(50),age int(11),pLastname1 varchar(50),pLastname2 varchar(50), 
									pIdGrade int(11), pIdSchool int(11),zipcode varchar(15),detail1 varchar(300),
                                    detail2 varchar(300),pIdCity int(11))
BEGIN

 
INSERT INTO mydb.players(`name`,age,idgrade,lastname1,lastname2,enable) VALUES (pName,age,pIdGrade,pLastName1,pLastName2,TRUE);
INSERT INTO mydb.addresses(zipcode,detail1,detail2,idCitiy) VALUES (zipcode,detail1,detail2,pIdCity);
INSERT INTO mydb.playersxschools(idplayer,idSchool)VALUES ((SELECT idplayer FROM mydb.players WHERE players.name = pName),pIdSchool);
INSERT INTO mydb.playersxaddresses(idplayer,idAddress,`date`,enable) VALUES ((SELECT idplayer FROM mydb.players WHERE players.name = pName),(SELECT idAddress FROM mydb.addresses ORDER BY idAddress DESC LIMIT 1),(SELECT CURDATE()),TRUE);

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_getAllKids
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllKids`()
BEGIN
SELECT players.idplayer,players.`name`,players.age,grades.`name` grade,players.lastname1,
	   players.lastname2, countries.name country, schools.name school FROM mydb.players 
       inner join mydb.grades on mydb.grades.idgrade=mydb.players.idgrade 
       inner join addresses inner join cities on addresses.idCitiy=cities.idCitiy 
       inner join regions on cities.idRegion = regions.idRegion 
       inner join countries on countries.idCountry=regions.idCountry 
       inner join schools 
       inner join playersxschools on playersxschools.idSchool=schools.idSchool 
       inner join playersxaddresses on playersxaddresses.idAddress=addresses.idAddress 
       and playersxaddresses.idplayer=players.idplayer 
       and players.idplayer=playersxschools.idplayer and player.id=pId;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_getKid
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getKid`(pId int)
BEGIN
SELECT players.idplayer,players.`name`,players.age,grades.`name` grade,players.lastname1,players.lastname2, countries.name country, regions.name region, cities.name city, addresses.detail1, addresses.zipCode, schools.name school FROM mydb.players inner join mydb.grades on mydb.grades.idgrade=mydb.players.idgrade inner join addresses inner join cities on addresses.idCitiy=cities.idCitiy inner join regions on cities.idRegion = regions.idRegion inner join countries on countries.idCountry=regions.idCountry inner join schools inner join playersxschools on playersxschools.idSchool=schools.idSchool inner join playersxaddresses on playersxaddresses.idAddress=addresses.idAddress and playersxaddresses.idplayer=players.idplayer and players.idplayer=playersxschools.idplayer and player.id=pId;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_modKid
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_modKid`(idKid int(11),pName varchar(50),age int(11),pLastname1 varchar(50),pLastname2 varchar(50), 
									pIdGrade int(11), pIdSchool int(11),zipcode varchar(15),detail1 varchar(300),
                                    detail2 varchar(300),pIdCity int(11))
BEGIN
UPDATE mydb.players SET players.`name`=pName,players.age=age,players.idgrade=pIdGrade,
						players.lastname1 = pLastname1,players.lastname2 = pLastname2
						where players.idplayer=idKid;
INSERT INTO mydb.addresses(zipcode,detail1,detail2,idCitiy) VALUES (zipcode,detail1,detail2,pIdCity);

UPDATE mydb.playersxaddresses SET playersxaddresses.`enable` = FALSE WHERE playersxaddresses.idplayer = idKid;
INSERT INTO mydb.playersxaddresses(idplayer,idAddress,`date`,enable) VALUES ((SELECT idplayer FROM mydb.players WHERE players.name = pName),(SELECT idAddress FROM mydb.addresses ORDER BY idAddress DESC LIMIT 1),(SELECT CURDATE()),TRUE);

UPDATE mydb.playersxschools SET playersxschools.idSchool = pIdSchool WHERE playersxschools.idplayer = idKid;
 

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_userProfile
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_userProfile`()
BEGIN
SELECT 
    users.username,
    users.email,
    users.`password`,
    users.iduserType,
    users.`enable`,
    users.`name`,
    users.lastname1,
    users.lastname2
FROM mydb.users;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_userProfileMod
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_userProfileMod`(id int,username nvarchar(16),email nvarchar(255),pass nvarchar(60),pname nvarchar(50),lastname1 nvarchar(50),lastname2 nvarchar(50))
BEGIN

UPDATE mydb.users SET users.username=username,users.email=email,users.`password`=pass,users.`name`=pname,users.lastname1=lastname1,users.lastname2=lastname2 where users.idUser=id;

END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;