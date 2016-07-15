package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJdbc implements UserDao {
	
	private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();
	
    public static final String SELECT_BY_LOGIN_SQL="SELECT * FROM galaxyuser.user";
	public static final String INSERT_SQL="INSERT INTO galaxyuser.user  (login,Age,E_mail,uname,SerName,Password,id) value(?,?,?,?,?,?,?)";
	public static final String DELET_BY_LOGIN_SQL="DELETE FROM galaxyuser.user where login=?";
	public static final String SELECT_ALL_BY_ID_SQL="SELECT * FROM galaxyuser.user WHERE id=";
	public static final String SELECT_ALL_BY_ID_AND_SQL="SELECT galaxyuser.user.login," +
			" galaxyuser.user.uname,galaxyuser.user.SerName,galaxyuser.user.id FROM galaxyuser.user,galaxyuser.zayavki WHERE  zayavki.polsovatel=user.login AND zayavki.yourid=";
	public static final String SELECT_LOGIN_SQL="SELECT * FROM galaxyuser.user WHERE login=";

	LoggingGalaxy rece= new LoggingGalaxy();
	private Connection getConnection() throws SQLException {
		
			return factory.newConnection();
		
	}

	@Override
	public User selectByLogin(String login) throws DBSystemException {
		Connection conn;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		Statement ps=null;
		ResultSet rs=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			System.out.println("2");
			ps = conn.createStatement();
			System.out.println("2");
			rs= ps.executeQuery(SELECT_LOGIN_SQL+"'"+login+"'");
			System.out.println("2");
			User user=null;
			if(rs.next()){
				String Login=rs.getString("login");
				String Password=rs.getString("password");
				String LastName=rs.getString("SerName");
				String Id=rs.getString("id");
				String UName=rs.getString("uname");
				String Email=rs.getString("E_mail");
				String Age=rs.getString("Age");
				user=new User();
				user.setlogin(Login);
				user.setPassword(Password);
				user.setEmail(Email);
				user.setSerName(LastName);
				user.setName(UName);
				user.setAge(Age);
				user.setID(Id);
			}
			conn.commit();
			return user;
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_LOGIN_SQL +e);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}

	}

	@Override
	public List<User> selectAll() throws DBSystemException {
		Connection conn;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		Statement ps=null;
		ResultSet rs=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			ps = conn.createStatement();
			rs= ps.executeQuery(SELECT_BY_LOGIN_SQL);
			User user=null;
			List<User> lu=new ArrayList<User>();
			while(rs.next()){
				String Login=rs.getString("login");
				String Password=rs.getString("password");
				String LastName=rs.getString("SerName");
				String Id=rs.getString("id");
				String UName=rs.getString("uname");
				String Email=rs.getString("E_mail");
				String Age=rs.getString("Age");
				user=new User();
				user.setlogin(Login);
				user.setPassword(Password);
				user.setEmail(Email);
				user.setSerName(LastName);
				user.setName(UName);
				user.setAge(Age);
				user.setID(Id);
				lu.add(user);
			}
			conn.commit();
			return lu;
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_LOGIN_SQL +e);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}

	}

	@Override
	public User selectByID(String id) throws DBSystemException {
		Connection conn;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		Statement ps=null;
		ResultSet rs=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			System.out.println("2");
			ps = conn.createStatement();
			System.out.println("2");
			rs= ps.executeQuery(SELECT_ALL_BY_ID_SQL+"'"+id+"'");
			System.out.println("2");
			User user=null;
			if(rs.next()){
				String Login=rs.getString("login");
				String Password=rs.getString("password");
				String LastName=rs.getString("SerName");
				String Id=rs.getString("id");
				String UName=rs.getString("uname");
				String Email=rs.getString("E_mail");
				String Age=rs.getString("Age");
				user=new User();
				user.setlogin(Login);
				user.setPassword(Password);
				user.setEmail(Email);
				user.setSerName(LastName);
				user.setName(UName);
				user.setAge(Age);
				user.setID(Id);
			}
			conn.commit();
			return user;
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_LOGIN_SQL +e);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}

	}

	@Override
	public List<User> selectByIDAndLogin(String id) throws DBSystemException {
		Connection conn;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		Statement ps=null;
		ResultSet rs=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			System.out.println("2");
			ps = conn.createStatement();
			System.out.println("2");
			rs= ps.executeQuery(SELECT_ALL_BY_ID_AND_SQL+"'"+id+"'");
			System.out.println("2");
			User user=null;
			List<User> lu=new ArrayList<User>();
			while(rs.next()){
				String Login=rs.getString("login");
				String LastName=rs.getString("SerName");
				String UName=rs.getString("uname");
				String id1=rs.getString("id");
				user=new User();
				user.setID(id1);
				user.setlogin(Login);
				user.setSerName(LastName);
				user.setName(UName);
				lu.add(user);
			}
			conn.commit();
			return lu;
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_LOGIN_SQL +e);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}


	}

	@Override
	public int selectId(String login) throws DBSystemException {
		Connection conn;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		Statement ps=null;
		ResultSet rs=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			ps = conn.createStatement();
			rs= ps.executeQuery("SELECT idUser FROM galaxyuser.user WHERE Password = "+login);
			int IdUser = 0;
			if(rs.next()){
				IdUser=rs.getInt("idUser");
			}
			conn.commit();
			return IdUser;
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_LOGIN_SQL+e);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}

	}

	@Override
	public int deleteByLogin(String login) throws DBSystemException {
			Connection conn;
			try {
				conn = getConnection();
			} catch (SQLException e) {
				throw new DBSystemException("Can't get connection "+e);
			}
			PreparedStatement ps=null;
			try{
				conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(DELET_BY_LOGIN_SQL);
				ps.setString(1, login);
				int result= ps.executeUpdate();
				conn.commit();
				return result;
			}catch(SQLException e){
				JdbcUtil.rollbackQuietly(conn);
				throw new DBSystemException("Can't execute SQL = '"+DELET_BY_LOGIN_SQL);
			}finally{
				JdbcUtil.closeQuietly(ps);
				JdbcUtil.closeQuietly(conn);
			}
	}


	@Override
	public boolean insertNewUser(User user) throws DBSystemException, NotUniqueUserEmailException, NotUniqueUserLoginException {
			Connection conn;
		   boolean result=true;
		try {
			conn = getConnection();
			rece.log.debug("Подключились к базе данных");
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		PreparedStatement ps=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			rece.log.debug("Зоздли иерархию транзакции!");
			conn.setAutoCommit(false);
			rece.log.debug("Отключили авто закрытие!");

			ps= conn.prepareStatement(INSERT_SQL);
			rece.log.debug("Содали запрос!");
			ps.setString(1, user.getlogin());
			ps.setString(2, user.getAge());
			ps.setString(3, user.getEmail());
			ps.setString(4,user.getName());
			ps.setString(5,user.getSerName());
			ps.setString(6,user.getPassword());
			ps.setString(7,user.getID());
            ps.executeUpdate();
			rece.log.debug("Запрос отработал!");
			conn.commit();
			return result;
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}

	}

	@Override
	public void changePassword(String NewPass, String id) throws DBSystemException {

		Connection conn;
		PreparedStatement ps=null;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			System.out.printf("Re re");
			ps = conn.prepareStatement("UPDATE galaxyuser.user  set Password=" + " '" + NewPass + "' " + "WHERE id=" + " '" + id + "'");
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+"UPDATE galaxyuser.change_password  set new_password="+" '"+NewPass+" '"+"WHERE id="+" '"+id+"'");

		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}
	}

	@Override
	public void changeEmail(String NewEmail, String id) throws DBSystemException {

		Connection conn;
		PreparedStatement ps=null;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("UPDATE galaxyuser.user  set E_mail=" + " '" + NewEmail + "' " + "WHERE id=" + " '" + id + "'");
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("Can't execute SQL = '"+"UPDATE galaxyuser.user  set E_mail="+" '"+NewEmail+" '"+"WHERE id="+" '"+id+"'");
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}
	}

	@Override
	public String selectMaxId() throws DBSystemException {
		Connection conn;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			throw new DBSystemException("Can't get connection "+e);
		}
		Statement ps=null;
		ResultSet rs=null;
		try{
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);

			ps = conn.createStatement();
			rs= ps.executeQuery("SELECT MAX(id) FROM galaxyuser.user");
			String idDiaPol=null;
			while(rs.next()){
				idDiaPol = rs.getString(1);
			}
			conn.commit();
			return idDiaPol;

		}catch(SQLException e){
			JdbcUtil.rollbackQuietly(conn);
			throw new DBSystemException("SELECT max(idDiaPol) FROM galaxyuser.dialog" +e);
		}finally{
			JdbcUtil.closeQuietly(ps);
			JdbcUtil.closeQuietly(conn);
		}
	}


}
