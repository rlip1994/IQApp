var db=require('../dbconnection');

var getTypeXUser={

  sp_getTypeXUser:function(idUser,callback){

return db.query("call sp_getTypeXUser(?)", [idUser],callback);

}};

module.exports= getTypeXUser;