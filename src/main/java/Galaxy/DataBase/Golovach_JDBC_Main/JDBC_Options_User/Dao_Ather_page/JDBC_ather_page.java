package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 15.02.2016.
 */
public class JDBC_ather_page implements Dao_ather_page {
    private static final String UPDATE_who_can_see_my_page="UPDATE galaxyuser.ather_page  set  who_can_see_my_page=";
    private static final String UPDATE_what_about_can_see="UPDATE galaxyuser.ather_page  set what_about_can_see=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.ather_page WHERE ather_page.id=user.id AND ather_page.id=";


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
            System.out.printf("Re re");
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

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }



    @Override
    public void Update_who_can_see_my_page(String id, String New_who_can_see_my_page) throws DBSystemException {
        UpdateDaoShablon(UPDATE_who_can_see_my_page,id,UPDATE_USER_ID_WHERE,New_who_can_see_my_page);
    }

    @Override
    public void Update_what_about_can_see(String id, String New_who_can_see_my_page) throws DBSystemException {
        UpdateDaoShablon(UPDATE_what_about_can_see,id,UPDATE_USER_ID_WHERE,New_who_can_see_my_page);
    }

    @Override
    public Ather_page SelectUserAther_page(String id) throws DBSystemException {
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
            Ather_page ather_page=null;

            if(rs.next()){

                String who_can_see_my_page=rs.getString("who_can_see_my_page");
                String what_about_can_see=rs.getString("what_about_can_see");
                ather_page= new Ather_page();
                ather_page.setWho_can_see_my_page(who_can_see_my_page);
                ather_page.setWhat_about_can_see(what_about_can_see);



            }
            conn.commit();
            return ather_page;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertAtherPage(String userId) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.ather_page (who_can_see_my_page,what_about_can_see,id) value(?,?,?)");
            ps.setString(1,"Все пользователи");
            ps.setString(2,"Все пользователи");
            ps.setString(3,userId);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
