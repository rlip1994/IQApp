var db=require('../dbconnection');

var getAllKids={

  sp_getAllKids:function(idUser,callback){

return db.query("call sp_getAllKids(?)",[idUser],callback);

},
  sp_getAllKidsResults: function(callback){
  	return db.query("call getAllKidsResults()",callback);
  }
 };

module.exports=getAllKids;