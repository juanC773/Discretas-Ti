package exceptions.dataStructure;

public class UsePollWithoutElementsException extends RuntimeException{

    public UsePollWithoutElementsException(){
        super("You can't use the method poll if there are no elements");
    }
}
