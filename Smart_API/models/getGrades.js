var db=require('../dbconnection');

var getGrade={

  sp_grade:function(callback){

return db.query("call sp_grade()",callback);

}};

module.exports=getGrade;