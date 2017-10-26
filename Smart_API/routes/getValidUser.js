var express = require('express');
var router = express.Router();
var user=require('../models/getValidUser');

/* GET users listing. */
router.get('/:idUser/:password', function(req, res, next) {
  if(req.params.idUser && req.params.password){

    user.sp_getValidUser(req.params.idUser,req.params.password,function(err,rows){
        if(err)
        {
            res.json(err);
        }
        else{
            res.json(rows);
        }
    });
}
});


module.exports = router;