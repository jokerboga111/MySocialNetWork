package Galaxy.DataBase.Golovach_JDBC_Main.Connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFacoryJDBC implements ConnectionFactory {
	
	public static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/galaxyuser";
	public static final String LOGIN="root";
	public static final String PASSWORD="root";




	@Override
	public Connection newConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
	}

	@Override
	public void close() throws SQLException {
		// nothing to close
		
	}

}
