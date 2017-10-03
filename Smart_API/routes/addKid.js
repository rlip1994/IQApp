var express = require('express');
var router = express.Router();
var addKid=require('../models/addKid');
router.post('/',function(req,res,next){
    
    addKid.sp_addKid(req.body,function(err,count){
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