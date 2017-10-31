var express = require('express');
var router = express.Router();
var addUser=require('../models/userRegister');
router.post('/',function(req,res,next){
    
    addUser.sp_addUser(req.body,function(err,count){
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