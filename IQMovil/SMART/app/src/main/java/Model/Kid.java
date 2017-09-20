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
    private int gradeIdKid;
    private String schoolKid;
    private ArrayList<Game> gamesKid;


    /**
     * Function: Contructor
     * @param pIdKid  Kid's Identifier
     * @param pNameKid Kid's name
     * @note instance of games's arrayList
     * **/
    public Kid(int pIdKid, String pNameKid, int pidGrade,String pSchool){
        this.idKid = pIdKid;
        this.nameKid = pNameKid;
        this.gradeIdKid = pidGrade;
        this.schoolKid = pSchool;
        this.gamesKid = new ArrayList<Game>();
    }

    /**SETTERS AND GETTERS**/
    public int getIdKid() {
        return idKid;
    }

    public String getNameKid() {
        return nameKid;
    }

    public int getGradeIdKid() {
        return gradeIdKid;
    }

    public String getSchoolKid() {
        return schoolKid;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "idKid=" + idKid +
                ", nameKid='" + nameKid + '\'' +
                ", gradeIdKid=" + gradeIdKid +
                ", schoolKid='" + schoolKid + '\'' +
                '}';
    }
}
