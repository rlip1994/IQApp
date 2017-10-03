var express = require('express');
var router = express.Router();
var modKid=require('../models/modKid');
router.post('/',function(req,res,next){
    
    modKid.sp_modKid(req.body,function(err,count){
            if(err)
            {
                res.json(err);
            }
            else{
                    res.json(req.body);//or return count for 1 & 0
            }
        });
});

module.exports=router;