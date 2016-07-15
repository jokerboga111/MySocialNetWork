package Galaxy.DataBase.DataBaseException;

public class DBSystemException extends DBException {
	
	public DBSystemException (String message){
		super(message);
	}

	public DBSystemException (String message,Throwable casue){
		super(message,casue);
	}
}
