CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllKidsResults`()
BEGIN

SELECT p.idPlayer,p.name,p.age,g.name as level,s.name as school
FROM players p JOIN grades g ON 
p.idgrade = g.idgrade INNER JOIN
playersxschools ps ON p.idPlayer = ps.idPlayer INNER JOIN
schools s ON ps.idSchool = s.idSchool
order by p.idPlayer;


END