package exeptions;

import enums.ErrorType;

public class ApplicationException extends Exception{
private ErrorType errorType;

public ApplicationException(Exception innerException, ErrorType errorType, String message) {
	super();
	this.errorType = errorType;
}
public ApplicationException(ErrorType errorType, String message) {
	super();
	this.errorType = errorType;
}
public ApplicationException() {
	super();
	this.errorType = errorType;
}
public ErrorType getErrorType() {
	return errorType;
}

}
