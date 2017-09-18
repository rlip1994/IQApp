package Model;

import java.util.ArrayList;

/**
 * Created by Katerine Molina on 14/9/2017.
 */

public class Kid {
    /**
     attributes
     * **/
    private int idKid;
    private String nameKid;
    private ArrayList<Game> gamesKid;


    /**
     * Function: Contructor
     * @param pIdKid  Kid's Identifier
     * @param pNameKid Kid's name
     * @note instance of games's arrayList
     * **/
    public Kid(int pIdKid, String pNameKid){
        this.idKid = pIdKid;
        this.nameKid = pNameKid;
        this.gamesKid = new ArrayList<Game>();
    }
}
