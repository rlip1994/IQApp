var express = require('express');
var router = express.Router();
var user=require('../models/getCities');

/* GET users listing. */
router.get('/:idRegions?', function(req, res, next) {
  if(req.params.idRegions){

    user.sp_getCities(req.params.idRegions,function(err,rows){
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