package model;

import android.media.Image;

/**
 * Created by kanat on 15/9/2017.
 */

public class Response {
    /**
     attributes
     * **/
    private int idResponse;
    private String textResponse;
    private Image imageResponse;


    /**
     * Method: Simple Contructor
     * @param pIdResponse identifier response
     * @param pTextReponse  identifier description
     * **/
    public Response(int pIdResponse, String pTextReponse) {
        this.idResponse = pIdResponse;
        this.textResponse = pTextReponse;
    }
    /**
     * Method: Contructor with image response
     * @param pIdResponse identifier response
     * @param pTextReponse  identifier description
     * **/
    public Response(int pIdResponse, String pTextReponse, Image pImageResponse) {
        this.idResponse = pIdResponse;
        this.textResponse = pTextReponse;
        this.imageResponse = pImageResponse;
    }

    public String getTextResponse() {
        return textResponse;
    }
}
