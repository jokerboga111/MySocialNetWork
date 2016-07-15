package Galaxy.DataBase.Golovach_JDBC_Main.Connections;

import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryProxool implements ConnectionFactory {
	public static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/galaxyuser";
	public static final String LOGIN="root";
	public static final String PASSWORD="root";
	public static final String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	
	public ConnectionFactoryProxool() throws SQLException{
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Properties info = new Properties();
		info.getProperty("proxool.maximum-connection-count","10");
		info.getProperty("proxool.house-keeping-test-sql","select CURRENT");
		info.getProperty("user",LOGIN);
		info.getProperty("password",PASSWORD);
		String alias="conn";
		String driverClass = DRIVER_CLASS_NAME;
		String driverUrl = JDBC_URL;
		String url ="proxool."+alias+":"+driverClass+":"+driverUrl;
		
		try {
			ProxoolFacade.registerConnectionPool(url, info);
		} catch (ProxoolException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public Connection newConnection() throws SQLException {
		return DriverManager.getConnection("proxool.conn");
	}
	@Override
	public void close() throws SQLException {
		ProxoolFacade.shutdown(1);
		
	}

	




}
