
var db = require('../dbconnection');

var userLogin = {

  sp_userloginUser: function (users, callback) {

    return db.query("call sp_userloginUser(?,?)", [users.username,users.password], callback);

  }
};

module.exports = userLogin;