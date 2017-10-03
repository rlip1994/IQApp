
var db = require('../dbconnection');

var getKid = {

  sp_getKid: function (idkid, callback) {

    return db.query("call sp_getKid(?)", [idkid], callback);

  }
};

module.exports = getKid;