var express = require('express');
var router = express.Router();

var kidAll=require('../models/getAllKids');
var kid=require('../models/getKid');

router.get('/:idUser', function(req, res, next) {
    kidAll.sp_getAllKidsResults(req.params.idUser,function(err,rows){
        if(err)
        {
            res.json(err);
        }
        else{
            res.json(rows);
        }
    });
});
router.get('/kidGames/:idPlayer', function(req, res, next) {
    kid.sp_getKidGames(req.params.idPlayer,function(err,rows){
        if(err)
        {
            res.json(err);
        }
        else{
            res.json(rows);
        }
    });
});
module.exports = router;