package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education;
import Galaxy.Logger.LoggingGalaxy;
import com.mchange.v2.c3p0.impl.NewProxyResultSet;

import java.sql.*;

/**
 * Created by Admin on 12.02.2016.
 */
public class JDBC_User_service implements User_Dao_service {
    private static final String UPDATE_USER_COUNTRY="UPDATE galaxyuser.user_service_war set Country=";
    private static final String UPDATE_USER_Military_Unit="UPDATE galaxyuser.user_service_war set Military_Unit=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.user_service_war WHERE user_service_war.id=user.id AND user_service_war.id=";


    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }

    private void UpdateDaoShablon(String Update,String id,String where ,String newInfo) throws DBSystemException {

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
            ps = conn.prepareStatement(Update + " '" + newInfo + "' " + where + " '" + id + "'");
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+Update+" '"+newInfo+" '"+where+" '"+id+"'");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }



    @Override
    public void UpdateCountry(String id, String NewCountry) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_COUNTRY,id,UPDATE_USER_ID_WHERE,NewCountry);
    }

    @Override
    public void UpdateServise(String id, String NewServise) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Military_Unit,id,UPDATE_USER_ID_WHERE, NewServise);
    }

    @Override
    public User_service SelectUser_Life_Position(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALLINFORMAATION+"'"+id+"'");
            User_service user_servise=null;

            if(rs.next()){
                String Country=rs.getString("Country");
                String Military_Unit=rs.getString("Military_Unit");
                user_servise= new User_service();
                user_servise.setCountry(Country);
                user_servise.setService_war(Military_Unit);

            }
            conn.commit();
            return user_servise;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertServiceRegister(String userid) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.user_service_war (Country,Military_Unit,id) value (?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,userid);

            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL =");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}

