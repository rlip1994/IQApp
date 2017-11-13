var db=require('../dbconnection');
var gameFunctions={

    addQuestionxGame:function(idQuestion,idGame,points,callback){
        return db.query("call addQuestionxGame(?,?,?)",[idQuestion,idGame,points],callback);
    },
    addGamexPlayer: function(idPlayer,points,idCategory,speed,callback){
  	    return db.query("call addGamexPlayer(?,?,?,?)",[idPlayer,points,idCategory,speed],callback);
  }
};

module.exports=gameFunctions;