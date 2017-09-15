var db=require('../dbconnection');

var category={

getAllCategories:function(callback){

return db.query("Select * from categories",callback);

}};

module.exports=category;