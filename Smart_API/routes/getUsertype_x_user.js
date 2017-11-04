var express = require('express');
var router = express.Router();
var user=require('../models/getUsertype_x_user');

/* GET users listing. */
router.get('/:idUser?', function(req, res, next) {
  if(req.params.idUser){

    user.sp_getTypeXUser(req.params.idUser,function(err,rows){
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