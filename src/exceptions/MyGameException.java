package exceptions;

public class MyGameException extends Exception {

	public MyGameException() {
		super();

	}

	public MyGameException(String message, Throwable cause) {
	}

	public MyGameException(String message) {
		super(message);
	}

	public MyGameException(Throwable cause) {
	}

}
