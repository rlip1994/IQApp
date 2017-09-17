
-- -----------------------------------------------------
-- procedure sp_insertAddress
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$

DELIMITER ;
INSERT INTO playersxusers (idplayer,iduser) VALUES (8,17);
INSERT INTO playersxusers (idplayer,iduser) VALUES (9,17);
INSERT INTO playersxusers (idplayer,iduser) VALUES (10,17);
INSERT INTO playersxusers (idplayer,iduser) VALUES (11,17);
INSERT INTO playersxusers (idplayer,iduser) VALUES (12,18);
INSERT INTO playersxusers (idplayer,iduser) VALUES (13,19);
INSERT INTO playersxusers (idplayer,iduser) VALUES (14,20);

DELIMITER ;

INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("234","a","b",1);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("567","a","b",2);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("890","a","b",8);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("222","a","b",4);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("333","a","b",2);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("444","a","b",6);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("555","a","b",9);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("666","a","b",5);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("777","a","b",6);
INSERT INTO addresses (zipCode,detail1,detail2,idCitiy) VALUES ("888","a","b",2);


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertAnswer
-- -----------------------------------------------------


INSERT INTO answers(value,idimage) VALUES ("anws1",4);
INSERT INTO answers(value,idimage) VALUES ("anws2",5);
INSERT INTO answers(value,idimage) VALUES ("anws3",5);
INSERT INTO answers(value,idimage) VALUES ("anws3",4);
INSERT INTO answers(value,idimage) VALUES ("anws4",3);
INSERT INTO answers(value,idimage) VALUES ("anws5",3);


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertCategories
-- -----------------------------------------------------


INSERT INTO categories(name) VALUE ("categoria1");
INSERT INTO categories(name) VALUE ("categoria2");
INSERT INTO categories(name) VALUE ("categoria3");
INSERT INTO categories(name) VALUE ("categoria4");
INSERT INTO categories(name) VALUE ("categoria5");
INSERT INTO categories(name) VALUE ("categoria6");
INSERT INTO categories(name) VALUE ("categoria7");
INSERT INTO categories(name) VALUE ("categoria8");



DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertCities
-- -----------------------------------------------------

INSERT INTO cities (name,idRegion) VALUES ("San Jose",1);
INSERT INTO cities (name,idRegion) VALUES ("Los Angeles",2);
INSERT INTO cities (name,idRegion) VALUES ("Turin",4);
INSERT INTO cities (name,idRegion) VALUES ("San Diego",2);
INSERT INTO cities (name,idRegion) VALUES ("Barrio Mexico",1);
INSERT INTO cities (name,idRegion) VALUES ("Sarchi",3);
INSERT INTO cities (name,idRegion) VALUES ("Esparza",7);
INSERT INTO cities (name,idRegion) VALUES ("Nicoya",8);
INSERT INTO cities (name,idRegion) VALUES ("Liberia",8);

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertCountries
-- -----------------------------------------------------


INSERT INTO countries (name) VALUES("Costa Rica");
INSERT INTO countries (name) VALUES("Mexico");
INSERT INTO countries (name) VALUES("Canada");
INSERT INTO countries (name) VALUES("Estados Unidos");
INSERT INTO countries (name) VALUES("Francia");
INSERT INTO countries (name) VALUES("Italia");
INSERT INTO countries (name) VALUES("Honduras");
INSERT INTO countries (name) VALUES("Guatemala");
INSERT INTO countries (name) VALUES("Panama");
INSERT INTO countries (name) VALUES("Colombia");

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertGames
-- -----------------------------------------------------



INSERT INTO games (idplayer,totalPoints) VALUES (1,20);
INSERT INTO games (idplayer,totalPoints) VALUES (5,40);
INSERT INTO games (idplayer,totalPoints) VALUES (6,50);
INSERT INTO games (idplayer,totalPoints) VALUES (2,0);
INSERT INTO games (idplayer,totalPoints) VALUES (7,102);
INSERT INTO games (idplayer,totalPoints) VALUES (4,200);
INSERT INTO games (idplayer,totalPoints) VALUES (3,1);


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertGrades
-- -----------------------------------------------------


INSERT INTO grades (name) VALUES ("1");
INSERT INTO grades (name) VALUES ("2");
INSERT INTO grades (name) VALUES ("3");
INSERT INTO grades (name) VALUES ("4");
INSERT INTO grades (name) VALUES ("5");
INSERT INTO grades (name) VALUES ("6");



DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertImages
-- -----------------------------------------------------

INSERT INTO images (value) VALUES (LOAD_FILE("/IQApp-Master/1.png"));
INSERT INTO images (value) VALUES (LOAD_FILE("/IQApp-Master/2.png"));
INSERT INTO images (value) VALUES (LOAD_FILE("/IQApp-Master/3.png"));
INSERT INTO images (value) VALUES (LOAD_FILE("/IQApp-Master/4.png"));

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertPlayers
-- -----------------------------------------------------

INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Fulano",8,2,"apellido1","apellido2",1);
INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Sutano",10,4,"apellido1","apellido2",2);
INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Mengano",12,6,"apellido1","apellido2",3);
INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Paco",9,3,"apellido1","apellido2",4);
INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Lola",11,5,"apellido1","apellido2",5);
INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Jeff",10,4,"apellido1","apellido2",6);
INSERT INTO players (name,age,idgrade,lastname1,lastname2,enable) VALUES ("Saul",8,2,"apellido1","apellido2",7);


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertPlayersXSchool
-- -----------------------------------------------------

INSERT INTO playersxschools (idplayer,idSchool) VALUES (1,2);
INSERT INTO playersxschools (idplayer,idSchool) VALUES (2,3);
INSERT INTO playersxschools (idplayer,idSchool) VALUES (4,6);
INSERT INTO playersxschools (idplayer,idSchool) VALUES (7,9);
INSERT INTO playersxschools (idplayer,idSchool) VALUES (3,2);


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertPlayersxAdress
-- -----------------------------------------------------



INSERT INTO playersxaddresses (idplayer,idAddress,date,enable) VALUES (1,10,"2017-09-15",1);
INSERT INTO playersxaddresses (idplayer,idAddress,date,enable) VALUES (3,9,"2017-09-15",1);
INSERT INTO playersxaddresses (idplayer,idAddress,date,enable) VALUES (5,6,"2017-09-15",0);
INSERT INTO playersxaddresses (idplayer,idAddress,date,enable) VALUES (2,1,"2017-09-15",1);
INSERT INTO playersxaddresses (idplayer,idAddress,date,enable) VALUES (6,3,"2017-09-15",0);
INSERT INTO playersxaddresses (idplayer,idAddress,date,enable) VALUES (8,5,"2017-09-15",1);



DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertQuestions
-- -----------------------------------------------------


INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta1",1,1,3,40,6);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta2",2,2,2,50,2);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta3",3,3,3,60,3);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta4",4,4,4,70,5);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta5",5,5,5,40,4);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta6",6,6,6,80,1);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta7",7,1,5,90,6);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta8",8,2,2,100,5);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta9",1,3,3,110,4);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta10",9,3,3,110,4);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta11",9,3,3,110,4);
INSERT INTO questions(description,idcategory,idgrade,idanswer,points,idTime) VALUES ("pregunta12",11,3,3,110,4);


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertRegions
-- -----------------------------------------------------


INSERT INTO regions (name,idCountry) VALUES ("San Jose",23);
INSERT INTO regions (name,idCountry) VALUES ("California",26);
INSERT INTO regions (name,idCountry) VALUES ("Alajuela",23);
INSERT INTO regions (name,idCountry) VALUES ("Turin",28);
INSERT INTO regions (name,idCountry) VALUES ("Paris",27);
INSERT INTO regions (name,idCountry) VALUES ("Heredia",23);
INSERT INTO regions (name,idCountry) VALUES ("Puntarenas",23);
INSERT INTO regions (name,idCountry) VALUES ("Guanacaste",23);
INSERT INTO regions (name,idCountry) VALUES ("Limon",23);
INSERT INTO regions (name,idCountry) VALUES ("Cartago",23);



DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertSchools
-- -----------------------------------------------------


INSERT INTO schools (name,idAddress) VALUES ("escuela1",1);
INSERT INTO schools (name,idAddress) VALUES ("escuela2",2);
INSERT INTO schools (name,idAddress) VALUES ("escuela3",8);
INSERT INTO schools (name,idAddress) VALUES ("escuela4",5);
INSERT INTO schools (name,idAddress) VALUES ("escuela5",5);
INSERT INTO schools (name,idAddress) VALUES ("escuela6",3);
INSERT INTO schools (name,idAddress) VALUES ("escuela7",3);
INSERT INTO schools (name,idAddress) VALUES ("escuela8",1);
INSERT INTO schools (name,idAddress) VALUES ("escuela9",1);
INSERT INTO schools (name,idAddress) VALUES ("escuela10",9);



DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertTimes
-- -----------------------------------------------------



INSERT INTO times(idTime,value,idUnit) VALUES (1,42,1);
INSERT INTO times(idTime,value,idUnit) VALUES (2,0,2);
INSERT INTO times(idTime,value,idUnit) VALUES (3,5,3);
INSERT INTO times(idTime,value,idUnit) VALUES (4,30,1);
INSERT INTO times(idTime,value,idUnit) VALUES (5,23,5);
INSERT INTO times(idTime,value,idUnit) VALUES (6,40,4);



DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertUnits
-- -----------------------------------------------------


INSERT INTO units (idUnit,name) VALUES (1,"unit1");
INSERT INTO units (idUnit,name) VALUES (2,"unit2");
INSERT INTO units (idUnit,name) VALUES (3,"unit3");
INSERT INTO units (idUnit,name) VALUES (4,"unit4");
INSERT INTO units (idUnit,name) VALUES (5,"unit5");
INSERT INTO units (idUnit,name) VALUES (6,"unit6");
INSERT INTO units (idUnit,name) VALUES (7,"unit7");


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertUserTypes
-- -----------------------------------------------------



INSERT INTO userstypes(name) VALUES ("tipoUsuario1");
INSERT INTO userstypes(name) VALUES ("tipoUsuario2");
INSERT INTO userstypes(name) VALUES ("tipoUsuario3");
INSERT INTO userstypes(name) VALUES ("tipoUsuario4");
INSERT INTO userstypes(name) VALUES ("tipoUsuario5");


DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insertUsers
-- -----------------------------------------------------

INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam1","email1@correo.com","1234",2,0);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam2","email2@correo.com","5678",5,1);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam3","email3@correo.com","1379",3,0);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam4","email4@correo.com","2468",1,1);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam5","email5@correo.com","12345",2,0);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam5","email6@correo.com","123456",3,1);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam6","email7@correo.com","1234567",4,0);
INSERT INTO users(username,email,password,idUserType,enable) VALUES("usernam7","email8@correo.com","12345678",1,1);



DELIMITER ;

CREATE PROCEDURE getAllCategories()
BEGIN

SELECT name FROM mydb.categories;

END

CREATE PROCEDURE getAllKidsxUser(pUserName nvarchar(16))
BEGIN

Select players.idplayer,players.name, players.age, players.idgrade, players.lastname1, players.lastname2 from mydb.playersxusers inner join mydb.players on players.idPlayer=playersxusers.idPlayer inner join mydb.users on users.iduser=playersxusers.iduser where username=pUserName and players.enable=True ;

END

CREATE PROCEDURE getGroupQuestionsxCategory(pCategoryName nvarchar(16))
BEGIN

Select questions.description , questions.points from mydb.questions inner join mydb.categories on categories.idcategory=questions.idcategory and categories.name=pCategoryName;

END