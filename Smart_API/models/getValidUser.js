var db = require('../dbconnection');

var getValidUser = {
  
  sp_getValidUser: function (iduser,password, callback) {

    return db.query("call sp_getValidUser(?,?)", [iduser,password], callback);

  }
};

module.exports = getValidUser;