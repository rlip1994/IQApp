var express = require('express');
var router = express.Router();
var games=require('../models/game');
router.get('/insertGame/:idPlayer/:points/:idCategory/:speed',function(req,res,next){

        games.addGamexPlayer(req.params.idPlayer,req.params.points,req.params.idCategory,req.params.speed,function(err,rows){
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
router.get('/linkQuestion/:idGame/:idQuestion/:points',function(req,res,next){

        games.addQuestionxGame(req.params.idQuestion,req.params.idGame,req.params.points,function(err,rows){
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