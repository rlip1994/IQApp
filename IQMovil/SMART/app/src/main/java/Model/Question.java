package Model;

import android.media.Image;

import java.sql.Time;

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
    private Time speedQuestion;
    private Response responseQuestion;
    private String[] alternativeResponse;

    /**
     * Method: Contructor
     * @param pIdQuestion Identifier question
     * @param pTextQuestion Question description
     * **/
     public Question(int pIdQuestion,String pTextQuestion){
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

     public Question(int pIdQuestion,String pTextQuestion,int pIdResponse,String pTextReponse){
         this.idQuestion = pIdQuestion;
         this.textQuestion = pTextQuestion;
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

    public void setAlternativeResponse(String[] alternativeResponse) {
        this.alternativeResponse = alternativeResponse;
    }

    public String[] getAlternativeResponse() {
        return alternativeResponse;
    }
}
