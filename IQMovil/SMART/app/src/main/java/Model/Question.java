package model;

import android.media.Image;

import java.sql.Time;
import java.util.Arrays;

/**
 * Created by kanat on 15/9/2017.
 */

public class Question {
    /**
     attributes
     * **/
    private int idQuestion;
    private String textQuestion;
    private int pointQuestion;
    private int scoreQuestion;
    private Time speedQuestion;
    private Response responseQuestion;


    private String[] alternativeResponse;

    /**
     * Method: Contructor
     * @param idQuestion
     * @param description
     * @param pIdQuestion Identifier question
     * @param pTextQuestion Question description
       **/
     public Question(int idQuestion, String description, int pIdQuestion, String pTextQuestion){
         this.idQuestion = pIdQuestion;
         this.textQuestion = pTextQuestion;
     }
    /**
     * Method: Contructor with simple response
     * @param pIdQuestion Identifier question
     * @param pTextQuestion Question description
     * @param pIdResponse Identifier response
     * @param pTextReponse Response Description
     *
     * **/

     public Question(int pIdQuestion,String pTextQuestion,int pIdResponse,String pTextReponse,int pPoints){
         this.idQuestion = pIdQuestion;
         this.textQuestion = pTextQuestion;
         this.pointQuestion = pPoints;
         this.responseQuestion =  new Response(pIdResponse,pTextReponse);
     }
    /**
     * Method: Contructor with image response
     * @param pIdQuestion Identifier question
     * @param pTextQuestion Question description
     * @param pIdResponse Identifier response
     * @param pTextReponse Response Description
     *
     * **/

    public Question(int pIdQuestion, String pTextQuestion, int pIdResponse, String pTextReponse, Image pImageResponse){
        this.idQuestion = pIdQuestion;
        this.textQuestion = pTextQuestion;
        this.responseQuestion =  new Response(pIdResponse,pTextReponse,pImageResponse);
    }

    /**GETTERS AND SETTERS**/

    public int getIdQuestion() {
        return idQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public Response getResponseQuestion() {
        return responseQuestion;
    }

    public void setAlternativeResponse(String[] pAlternativeResponse) {
        this.alternativeResponse = pAlternativeResponse;
    }

    public String[] getAlternativeResponse() {
        return alternativeResponse;
    }

    /**
     * @param  point : 1 correct response
     *                 2 wrong response **/
    public void setScoreQuestion(int point) {
        this.pointQuestion = point;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", textQuestion='" + textQuestion + '\'' +
                ", pointQuestion=" + pointQuestion +
                ", speedQuestion=" + speedQuestion +
                ", responseQuestion=" + responseQuestion +
                ", alternativeResponse=" + Arrays.toString(alternativeResponse) +
                '}';
    }

    public boolean validateQuestion(String text) {
        return this.getResponseQuestion().getTextResponse()==(text);
    }

    public int getPointsQuestion() {
        return this.pointQuestion;
    }

    public int getScoreQuestion() {
        return scoreQuestion;
    }
}
