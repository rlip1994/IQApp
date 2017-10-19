CREATE DEFINER=`root`@`localhost` PROCEDURE `getGamesxKid`(pIdKid INT)
BEGIN
	-- Get games from pIdKid  
	SELECT c.name as category,g.totalPoints as grade
    FROM players p 
    INNER JOIN games g ON 
    p.idPlayer = pIdKid AND
    p.idPlayer = g.idPlayer 
    INNER JOIN categories c ON 
    g.idCategory = c.idCategory
    ;
END