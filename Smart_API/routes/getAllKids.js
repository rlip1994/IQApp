var express = require('express');
var router = express.Router();
var category=require('../models/getAllKids');
router.get('/',function(req,res,next){

        category.sp_getAllKids(function(err,rows){

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