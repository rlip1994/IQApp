
var db = require('../dbconnection');

var userRegister = {

  sp_addUser: function (users, callback) {

    return db.query("call sp_addUser(?,?,?,?,?,?,?)", [users.username, users.email, users.userType,  users.name,
    users.lastname1, users.lastname2, users.password], callback);

  }
};

module.exports = userRegister;