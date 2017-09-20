package Model;

import java.util.ArrayList;

/**
 * Created by kanat on 14/9/2017.
 */

public class User {
    /**
     attributes
     * **/
    private int idUser;

    private String nameUser;
    private ArrayList<Kid> kidsUser;

    public User(String pNameUser, int pIdUser){
        this.idUser = pIdUser;
        this.nameUser = pNameUser;
        this.kidsUser =  new ArrayList<Kid>();
    }

    public void addKidUser(Kid pKid){
        this.kidsUser.add(pKid);
    }
    /**GETTERS AND SETTERS**/

    public int getIdUser() {
        return idUser;
    }

    public ArrayList<Kid> getKidsUser() {
        return kidsUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", nameUser='" + nameUser + '\'' +
                ", kidsUser=" + kidsUser +
                '}';
    }
}
