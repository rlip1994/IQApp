var express = require('express');
var router = express.Router();
var getGrades=require('../models/getGrades');
router.get('/',function(req,res,next){

        getGrades.sp_grade(function(err,rows){

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