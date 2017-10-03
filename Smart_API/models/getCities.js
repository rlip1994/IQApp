var db = require('../dbconnection');

var getCities = {

  sp_getCities: function (idRegion, callback) {

    return db.query("call sp_getCities(?)", [idRegion], callback);

  }
};

module.exports = getCities;