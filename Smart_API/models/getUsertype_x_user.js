var db=require('../dbconnection');

var getUsertype_x_user={

  sp_getTypeXUser:function(idUser,callback){

    return db.query("call sp_getTypeXUser(?)",[idUser],callback);

  }
}; 

module.exports=getUsertype_x_user;