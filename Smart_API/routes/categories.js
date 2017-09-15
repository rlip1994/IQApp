var express = require('express');
var router = express.Router();
var category=require('../models/category');
router.get('/',function(req,res,next){

        category.getAllCategories(function(err,rows){

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