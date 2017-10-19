var db=require('../dbconnection');

var getSchool={

  sp_getSchool:function(callback){

return db.query("call sp_getSchool()",callback);

},
	 getNamesSchools: function(callback){
		return db.query("call getAllSchoolsNames()",callback);
	}
};

module.exports=getSchool;