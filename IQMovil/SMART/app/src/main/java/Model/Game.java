package Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

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
     private int nextQuestion = 0;

    /**Method: Constructor
     * @param pCategory use to get database question
     **/
    public Game(Category pCategory ){
        this.categorySelected = pCategory;
        this.questionsGame =  new ArrayList<Question>();
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

    public Question getQuestion() throws Exception {
        if(this.questionsGame.size()==this.nextQuestion){
            throw new Exception("Sin preguntas");
        }
        Question actualQuestion = this.questionsGame.get(nextQuestion);
        actualQuestion.setAlternativeResponse(this.getRandomResponse(actualQuestion.getResponseQuestion().getTextResponse()));
        this.nextQuestion++;
        return  actualQuestion;
    }

    private String[] getRandomResponse(String response){
        String[] responses = new String[4];
        responses[0] = response;
        Random random = new Random();
        int index,arrayIndex = 1; // Because response[0] is true response
        while (arrayIndex!=4){
            index = random.nextInt(this.questionsGame.size());
            if(index == this.nextQuestion){
                continue;
            }else{
                responses[arrayIndex] = this.questionsGame.get(index).getResponseQuestion().getTextResponse();
                arrayIndex++;
            }
        }
        return this.shuffleArray(responses);
    }

    private String[]  shuffleArray(String[] array)
    {
        int index;
        String tempValue;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                tempValue = array[i];
                array[i] = array[index];
                array[index] = tempValue;
            }
        }
        return array;
    }
}
