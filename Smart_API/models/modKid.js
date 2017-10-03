var db = require('../dbconnection');

var modKid = {


  sp_modKid: function (kid, callback) {

    return db.query("call sp_modKid(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", [kid.idplayer,kid.name,kid.age,kid.lastname1,kid.lastname2,
                                                        kid.grade,kid.school,kid.zipCode,kid.detail1,
                                                         kid.detail2,kid.city,kid.favoriteTopic,kid.favoriteSubject,
                                                         kid.favoriteHobbie,kid.otherInfo], callback);

  }
};

module.exports = modKid;