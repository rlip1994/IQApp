package Model;

import java.sql.Time;
import java.util.ArrayList;

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

    /**Method: Constructor
     * @param pCategory use to get database question
     **/
    public Game(Category pCategory){
        this.categorySelected = pCategory;
        this.questionsGame =  new ArrayList<Question>();
    }

}
