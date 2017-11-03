var express = require('express');
var router = express.Router();
var userLogin=require('../models/userLogin');

router.get('/:username/:password',function(req,res,next){
    if(req.params.username && req.params.password){
        
    userLogin.sp_userlogin(req.params.username, req.params.password,function(err,row){
            if(err)
            {
                res.json(err);
            }
            else{
                    res.json(row);
            }
        });
    }
});

module.exports=router;
