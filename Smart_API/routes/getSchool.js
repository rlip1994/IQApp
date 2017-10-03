var express = require('express');
var router = express.Router();
var getSchool=require('../models/getSchool');
router.get('/',function(req,res,next){

        getSchool.sp_getSchool(function(err,rows){

            //console.log(req.body);
            if(err)
            {
                res.json(err);
            }
            else{
                    res.json(rows);//return JSon categories
            }
        });
});

module.exports=router;