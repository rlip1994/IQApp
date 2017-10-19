
var db = require('../dbconnection');

var getKid = {

  sp_getKid: function (idkid, callback) {

    return db.query("call sp_getKid(?)", [idkid], callback);
  },
  sp_getKidGames: function(idPlayer,callback){
  	return db.query("call getGamesxKid(?)", [idPlayer], callback);
  }
};

module.exports = getKid;