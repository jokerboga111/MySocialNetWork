package Galaxy.DataBase.Golovach_JDBC_Main.Connections;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFacoryC3P0 implements ConnectionFactory {
	public static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/quiz";
	public static final String LOGIN="root";
	public static final String PASSWORD="root";
	public static final String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	
	private final ComboPooledDataSource dataSource;

	public ConnectionFacoryC3P0() throws SQLException{
		try{
			dataSource=new ComboPooledDataSource();
			dataSource.setDriverClass(DRIVER_CLASS_NAME);
			dataSource.setJdbcUrl(JDBC_URL);
			dataSource.setUser(LOGIN);
			dataSource.setPassword(PASSWORD);
			
			dataSource.setMinPoolSize(1);
			dataSource.setAcquireIncrement(1);
			dataSource.setMaxPoolSize(20);
			
			dataSource.setMaxStatements(180);

			
		}catch(PropertyVetoException e){
					throw new SQLException("ERROR");	
		}
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
