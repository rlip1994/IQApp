var express = require('express');
var router = express.Router();
var user=require('../models/getRegions');

/* GET users listing. */
router.get('/:idCountry?', function(req, res, next) {
  if(req.params.idCountry){

    user.sp_getRegions(req.params.idCountry,function(err,rows){
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