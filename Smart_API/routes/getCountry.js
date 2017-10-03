var express = require('express');
var router = express.Router();
var getCountry=require('../models/getCountry');
router.get('/',function(req,res,next){

        getCountry.sp_getCountries(function(err,rows){

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