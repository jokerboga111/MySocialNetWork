package Galaxy.DataBase.Golovach_JDBC_Main.Connections;

import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryDbcp implements ConnectionFactory {

	public static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/quiz";
	public static final String LOGIN="root";
	public static final String PASSWORD="root"; 
	public static final String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	
	
    public BasicDataSource dataSource;
	
	public ConnectionFactoryDbcp(){
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER_CLASS_NAME);
		ds.setUsername(LOGIN);
	     ds.setPassword(PASSWORD);
		ds.setUrl(JDBC_URL);
		dataSource=ds;
	}
	@Override
	public Connection newConnection() throws SQLException {
		return dataSource.getConnection();
	}

	@Override
	public void close() throws SQLException {
		dataSource.close();
		
	}

}
