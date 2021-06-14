package Exceptions;

public class SurvivingEnemyException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public SurvivingEnemyException(String errorMessage) {
		super(errorMessage);
	}
}
