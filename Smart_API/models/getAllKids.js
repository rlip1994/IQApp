var db=require('../dbconnection');

var getAllKids={

  sp_getAllKids:function(idUser,callback){

return db.query("call sp_getAllKids(?)",[idUser],callback);

}};

module.exports=getAllKids;