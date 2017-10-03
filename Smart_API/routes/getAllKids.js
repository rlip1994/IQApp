var express = require('express');
var router = express.Router();
var user=require('../models/getAllKids');

/* GET users listing. */
router.get('/:idUsers?', function(req, res, next) {
  if(req.params.idUsers){

    user.sp_getAllKids(req.params.idUsers,function(err,rows){
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