var db = require('../dbconnection');

var user = {

  getUserxKids: function (idUser, callback) {

    return db.query("call getAllKidsxUser(?)", [idUser], callback);

  }
};

module.exports = user;


