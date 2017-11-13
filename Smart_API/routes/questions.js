var express = require('express');
var router = express.Router();
var question=require('../models/question');


router.get('/answers/:idQuestion', function(req, res, next) {
    if(req.params.idQuestion){
        question.getAlternativeSimpleAnswers(req.params.idQuestion,function(err,rows){
            if(err)
            {
                res.json(err);
            }
            else{
                res.json(rows);
            }
        });
    }
});

router.get('/:idCategory/:idGrade', function(req, res, next) {
    if(req.params.idCategory && req.params.idGrade){
        question.getgroupQuestionxCategory(req.params.idCategory,req.params.idGrade,function(err,rows){
            if(err)
            {
                res.json(err);
            }
            else{
                res.json(rows);
            }
        });
    }
});


module.exports = router;