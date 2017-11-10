package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

import exceptions.EmptyQuestionArrayException;
import exceptions.MessageException;

/**
 * Created by kanat on 15/9/2017.
 */

public class Game {
    /**
     attributes
     * **/
     private Category  categorySelected;
     private int pointsGame;
     private Time speedGame; // Select correct class of time?
     private ArrayList<Question> questionsGame;
     private ArrayList<Question> answerQuestions;
     private Question currentQuestion;
     private int nextQuestion = 0;



    /**Method: Constructor
     * @param pCategory use to get database question
     **/
    public Game(Category pCategory ){
        this.categorySelected = pCategory;
        this.questionsGame =  new ArrayList<Question>();
        this.answerQuestions =  new ArrayList<Question>();
    }

    public ArrayList<Question> getQuestionsGame() {
        return questionsGame;
    }
    public void addQuestion(Question pQuestion){
        this.questionsGame.add(pQuestion);
    }

    public Category getCategorySelected() {
        return categorySelected;
    }

    public void setCurrentQuestion() throws EmptyQuestionArrayException {
        //VALIDATION
        if(this.questionsGame.size() == 0) throw new EmptyQuestionArrayException(MessageException.NOFOUNDQUESTIONS );
        this.currentQuestion  = this.questionsGame.remove(0); //NEXT QUESTION ON QUEUE
        this.answerQuestions.add(this.currentQuestion);
    }
    public void AddAlternativeResponses(String[] alternative){
        this.currentQuestion.setAlternativeResponse(getRandomResponse(alternative));
    }
    private String[] getRandomResponse(String[] alternative){
        String[] responses = new String[4];
        responses[0] = this.currentQuestion.getResponseQuestion().getTextResponse();
        for(int i = 0;i<alternative.length;i++){
            responses[i+1] = alternative[i];
        }
        return responses;
    }
    private void shuffleResponsesArray(String[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void answerCurrentQuestion(String text, int time) {
        //if(this.validateResponse(text)){
            this.pointsGame++;
         //   this.currentQuestion.setPoint(1);
       // }
    }

    @Override
    public String toString() {
        return "Game{" +
                "categorySelected=" + categorySelected +
                ", pointsGame=" + pointsGame +
                ", speedGame=" + speedGame +
                ", questionsGame=" + questionsGame +
                ", answerQuestions=" + answerQuestions.toString() +
                ", currentQuestion=" + currentQuestion +
                ", nextQuestion=" + nextQuestion +
                '}';
    }
}
