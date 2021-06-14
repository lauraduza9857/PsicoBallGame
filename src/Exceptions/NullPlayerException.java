package Exceptions;

public class NullPlayerException extends Exception{
	private static final long serialVersionUID = 1L;

    public NullPlayerException(String errorMessage) {
        super(errorMessage);
    }
}
