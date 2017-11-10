package exceptions;

/**
 * Created by kanat on 9/11/2017.
 */

public class EmptyQuestionArrayException extends Exception {
    public EmptyQuestionArrayException(String message) { super(message); }
    public EmptyQuestionArrayException() { super(); }
}
