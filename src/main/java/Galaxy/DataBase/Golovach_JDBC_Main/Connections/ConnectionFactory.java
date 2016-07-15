package Galaxy.DataBase.Golovach_JDBC_Main.Connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {

	public Connection newConnection() throws SQLException;
	
	public void close() throws SQLException;
	
}

