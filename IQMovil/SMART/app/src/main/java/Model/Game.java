package model;

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
     private int speedGame; // Select correct class of time?
     private ArrayList<Question> questionsGame;
     private ArrayList<Question> answerQuestions;
     private Question currentQuestion;
     private int nextQuestion = 0;
     private int counterSpeed;
     private int idGame;


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
        shuffleResponsesArray(responses);
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

    public void answerCurrentQuestion(String text, int time, Integer timeValue) {
        if(this.currentQuestion.validateQuestion(text)) {
            this.pointsGame += this.currentQuestion.getPointsQuestion();
            this.currentQuestion.setScoreQuestion(this.getCurrentQuestion().getPointsQuestion());
        }else{
            this.currentQuestion.setScoreQuestion(this.getCurrentQuestion().getPointsQuestion());
        }
        this.speedGame += Math.abs(timeValue-time); // Need know actual speed in seconds
        this.counterSpeed++;
    }

    // RESULTS OPERATIONS
    public void calculateResults() {
        this.pointsGame = this.calculateScorePoints(); // BASE 100
        this.speedGame = this.calculateSpeedResults();// AVERAGE
    }
    private int calculateSpeedResults() {
        return Integer.valueOf((this.speedGame /this.counterSpeed)/60);//in seconds
    }

    private int calculateScorePoints() {
        int totalPoints = calculateTotalPoints();
        return Integer.valueOf((this.pointsGame/totalPoints) * 100);
    }

    private int calculateTotalPoints(){
        int counter = 0;
        for (Question question : this.getAnswerQuestions()) {
            counter += question.getPointsQuestion();
        }
        return counter;
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


    public int getPointsGame() {
        return this.pointsGame;
    }

    public int getSpeedGame() {
        return speedGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public ArrayList<Question> getAnswerQuestions() {
        return answerQuestions;
    }

    public int getIdGame() {
        return idGame;
    }


}
