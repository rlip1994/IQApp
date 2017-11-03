var db=require('../dbconnection');

var usertypes={

sp_getuserTypes:function(callback){

return db.query("call sp_getuserTypes()",callback);

}};

module.exports=usertypes;