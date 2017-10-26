var db = require('../dbconnection');

var addKid = {

  sp_addKid: function (kid, callback) {


    return db.query("call sp_addKid(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", [kid.name, kid.age,kid.lastname1,kid.lastname2,
                                                      kid.grade,kid.school,kid.zipCode,kid.detail1,
                                                      kid.detail2,kid.city,kid.idCard,kid.favoriteTopic,
                                                      kid.favoriteSubject,kid.favoriteHobbie,
                                                      kid.otherInfo,kid.idUser], callback);

  }
};

module.exports = addKid;