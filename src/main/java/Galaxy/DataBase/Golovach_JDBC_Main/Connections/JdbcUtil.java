package Galaxy.DataBase.Golovach_JDBC_Main.Connections;

import java.sql.*;

public class JdbcUtil {
private static boolean initialized;

private JdbcUtil(){
	}
public static synchronized void initDriver(String driverClass){
	if(!initialized){
		try{
			Class.forName(driverClass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("Can't initialized driver: "+driverClass);
		}
		initialized=true;
	}
}
public static void closeQuietly(Connection conn){
	if(conn != null){
		try{
			conn.close();
		}catch(SQLException e){
		// NOP
	}
	}}

public static void closeQuietly(ResultSet rs){
	if(rs != null){
		try{
			rs.close();
		}catch(SQLException e){
		// NOP
	}
	}}

public static void closeQuietly(PreparedStatement st){
	if(st != null){
		try{
			st.close();
		}catch(SQLException e){
		// NOP
	}
	}}
public static void closeQuietly(Statement st){
	if(st != null){
		try{
			st.close();
		}catch(SQLException e){
		// NOP
	}
	}}
public static void rollbackQuietly(Connection conn){
	if(conn != null){
		try{
			conn.rollback();
		}catch(SQLException e){
		// NOP
	}
}}

}
