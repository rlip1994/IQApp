var express = require('express');
var router = express.Router();
var usertypes=require('../models/getUsersTypes');
router.get('/',function(req,res,next){

        usertypes.sp_getuserTypes(function(err,rows){

            
            if(err)
            {
                res.json(err);
            }
            else{
                    res.json(rows);//return JSon usertypes
            }
        });
});

module.exports=router;