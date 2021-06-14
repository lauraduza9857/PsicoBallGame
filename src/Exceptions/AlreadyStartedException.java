package Exceptions;

public class AlreadyStartedException extends Exception {
	private static final long serialVersionUID = 1L;

    public AlreadyStartedException(String errorMessage) {
        super(errorMessage);
    }
}
