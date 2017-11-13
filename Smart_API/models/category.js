var db=require('../dbconnection');

    var category={
    
        getAllCategories:function(callback){
        
            return db.query("call getAllCategories()",callback);
        },
        
        getCategoriesPlayer : function(idPlayer,callback){
            return db.query("call getIncompleteGamesxPlayer(?)",[idPlayer],callback);
        }    
    };

module.exports=category;