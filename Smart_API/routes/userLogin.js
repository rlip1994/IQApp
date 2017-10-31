var express = require('express');
var router = express.Router();
var userLogin=require('../models/userLogin');
router.post('/',function(req,res,next){
    
    userLogin.sp_userloginUser(req.body,function(err,count){
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