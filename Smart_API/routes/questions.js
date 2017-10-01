var express = require('express');
var router = express.Router();
var question=require('../models/question');

/* GET users listing. */
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