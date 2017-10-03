var db=require('../dbconnection');

var getCountry={

  sp_getCountries:function(callback){

return db.query("call sp_getCountries()",callback);

}};

module.exports=getCountry;