var express = require('express');
var router = express.Router();
var user=require('../models/userProfile');

/* GET users listing. */
router.get('/:idUser?', function(req, res, next) {
  if(req.params.idUser){

    user.sp_userProfile(req.params.idUser,function(err,rows){
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