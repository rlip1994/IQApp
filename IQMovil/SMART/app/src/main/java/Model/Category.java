package Model;

/**
 * Created by kanat on 15/9/2017.
 */

public class Category {
    /**
     attributes
     * **/
    private int idCategory;
    private String nameCategory;

    /**
     * Method : Contructor
     * @param pIdCategory category identifier
     * @param pNameCategory  category's name**/

    public Category(int pIdCategory,String pNameCategory){
        this.idCategory = pIdCategory;
        this.nameCategory = pNameCategory;
    }

    /**
     * Method: Getter and setter **/
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
