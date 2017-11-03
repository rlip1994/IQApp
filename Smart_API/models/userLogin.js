
var db = require('../dbconnection');

var userLogin = {

  sp_userlogin: function (username, password, callback) {

    return db.query("call sp_loginUser(?,?)", [username,password], callback);

  }
};

module.exports = userLogin;