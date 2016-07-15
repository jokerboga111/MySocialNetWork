package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends;

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

/**
 * Created by Admin on 03.02.2016.
 */
public class DaoFriendJDBC implements DaoFriend{

    public static final String INSERT_SQL_ZAYAVKA="INSERT INTO galaxyuser.zayavki  (idf,polsovatel,yourid) value(?,?,?)";
    public static final String DELET_BY_FRIEND_SQL="DELETE FROM galaxyuser.friends where idfri=";
    public static final String SELECT_ALLFRIENDS="SELECT galaxyuser.user.login," +
            " galaxyuser.user.uname,galaxyuser.user.SerName,galaxyuser.user.id FROM galaxyuser.user,galaxyuser.friends WHERE friends.idfri=user.id AND friends.yourid=";
    public static final String INSERT_SQL_FRIEND="INSERT INTO galaxyuser.friends  (idfri,Name,yourid) value(?,?,?)";
    public static final String DELET_BY_ID_SQL="DELETE FROM galaxyuser.zayavki where idf=";


    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }

    @Override
    public List<User> selectFriends(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALLFRIENDS+"'"+id+"'");
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
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLFRIENDS +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void deleteFriend(String id, String idf) throws DBSystemException {
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
            ps = conn.prepareStatement(DELET_BY_FRIEND_SQL+"'"+idf+"'"+"AND yourid="+"'"+id+"'");
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+DELET_BY_FRIEND_SQL);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public boolean insertNewFriend(String idf, String name, String id) throws DBSystemException, NotUniqueUserEmailException, NotUniqueUserLoginException {
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

            ps= conn.prepareStatement(INSERT_SQL_FRIEND);
            rece.log.debug("Содали запрос!");
            ps.setString(1,idf);
            ps.setString(2,name);
            ps.setString(3,id);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
            return result;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_FRIEND);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public boolean insertNewOrder(String id, String name, String idS) throws DBSystemException, NotUniqueUserEmailException, NotUniqueUserLoginException {
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

            ps= conn.prepareStatement(INSERT_SQL_ZAYAVKA);
            rece.log.debug("Содали запрос!");
            ps.setString(1,idS);
            ps.setString(2,name);
            ps.setString(3,id);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
            return result;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_ZAYAVKA);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void deleteByIDF(String id, String idf) throws DBSystemException {
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
            ps = conn.prepareStatement(DELET_BY_ID_SQL+"'"+id+"'"+"AND yourid="+"'"+idf+"'");
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+DELET_BY_ID_SQL);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
