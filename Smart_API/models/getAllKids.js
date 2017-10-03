var db=require('../dbconnection');

var getAllKids={

  sp_getAllKids:function(callback){

return db.query("call sp_getAllKids()",callback);

}};

module.exports=getAllKids;