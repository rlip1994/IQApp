var db = require('../dbconnection');

var getRegions = {

  sp_getRegions: function (idCountry, callback) {

    return db.query("call sp_getRegions(?)", [idCountry], callback);

  }
};

module.exports = getRegions;