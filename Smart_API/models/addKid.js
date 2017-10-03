var db = require('../dbconnection');

var addKid = {

  sp_addKid: function (kid, callback) {


    return db.query("call sp_addKid(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", [kid.pName, kid.age,kid.pLastname1,kid.pLastname2,
                                                      kid.pIdGrade,kid.pIdSchool,kid.zipcode,kid.detail1,
                                                      kid.detail2,kid.pIdCity,kid.pIdCard,kid.favTopic,kid.favSubject,
                                                      kid.favHobbie,kid.otherInfo], callback);

  }
};

module.exports = addKid;