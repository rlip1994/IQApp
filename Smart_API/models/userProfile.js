var db = require('../dbconnection');

var userProfile = {

  sp_userProfile: function (iduser, callback) {

    return db.query("call sp_userProfile(?)", [iduser], callback);

  }
};

module.exports = userProfile;