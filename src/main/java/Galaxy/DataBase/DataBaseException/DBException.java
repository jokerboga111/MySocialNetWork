package Galaxy.DataBase.DataBaseException;

public class DBException extends Exception {
	
	public DBException (String message){
		super(message);
	}

	public DBException (String message,Throwable casue){
		super(message,casue);
	}
}
