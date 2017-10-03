
var db = require('../dbconnection');

var userProfileMod = {

  sp_userProfileMod: function (users, callback) {

    return db.query("call sp_userProfileMod(?,?,?,?,?,?,?)", [users.iduser, users.username, users.email, users.password, users.name,
    users.lastname1, users.lastname2], callback);

  }
};

module.exports = userProfileMod;