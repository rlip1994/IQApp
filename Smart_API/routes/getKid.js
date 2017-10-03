var express = require('express');
var router = express.Router();
var user=require('../models/getKid');

/* GET users listing. */
router.get('/:idkid?', function(req, res, next) {
  if(req.params.idkid){

    user.sp_getKid(req.params.idkid,function(err,rows){
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