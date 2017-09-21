var db=require('../dbconnection');

var category={

getAllCategories:function(callback){

return db.query("call getAllCategories()",callback);

}};

module.exports=category;