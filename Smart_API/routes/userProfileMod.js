var express = require('express');
var router = express.Router();
var userProfileMod=require('../models/userProfileMod');
router.post('/',function(req,res,next){
    
    userProfileMod.sp_userProfileMod(req.body,function(err,count){
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