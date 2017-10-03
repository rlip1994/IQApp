var db = require('../dbconnection');

var modKid = {


  sp_modKid: function (kid, callback) {

    return db.query("call sp_modKid(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", [kid.idKid,kid.pName, kid.age,kid.pLastname1,kid.pLastname2,
                                                        kid.pIdGrade,kid.pIdSchool,kid.zipcode,kid.detail1,
                                                         kid.detail2,kid.pIdCity,kid.favTopic,kid.favSubject,
                                                         kid.favHobbie,kid.otherInfo], callback);

  }
};

module.exports = modKid;