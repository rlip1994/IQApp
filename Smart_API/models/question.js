var db=require('../dbconnection');

var question={

// Function
/**
@params 
**/

getgroupQuestionxCategory:function(idCategory,idGrade,callback){

return db.query("call getGroupQuestionsxCategoryText(?,?)",[idCategory,idGrade],callback);

}};

module.exports=question;