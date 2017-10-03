var db = require('../dbconnection');

var addKid = {

  sp_addKid: function (kid, callback) {


    return db.query("call sp_addKid(?,?,?,?,?,?,?,?,?,?,?)", [kid.pName, kid.age,kid.pLastname1,kid.pLastname2,
                                                      kid.pIdGrade,kid.pIdSchool,kid.zipcode,kid.detail1,
                                                      kid.detail2,kid.pIdCity,kid.pIdCard], callback);

  }
};

module.exports = addKid;