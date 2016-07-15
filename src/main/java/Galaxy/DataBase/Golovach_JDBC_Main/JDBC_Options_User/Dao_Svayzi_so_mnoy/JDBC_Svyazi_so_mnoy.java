package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Options_Page;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 15.02.2016.
 */
public class JDBC_Svyazi_so_mnoy implements Dao_Svyazi_so_mnoy {
    private static final String UPDATE_USER_who_write_masage_to_me="UPDATE galaxyuser.svazi_so_mnoy set  who_write_masage_to_me=";
    private static final String UPDATE_USER_who_can_duel_me_video="UPDATE galaxyuser.svazi_so_mnoy set  who_can_duel_me_video=";
    private static final String UPDATE_USER_who_can_duel_me_aplication="UPDATE galaxyuser.svazi_so_mnoy  set who_can_duel_me_aplication=";
    private static final String UPDATE_USER_who_can_acept_me_video="UPDATE galaxyuser.svazi_so_mnoy set  who_can_acept_me_video=";
    private static final String UPDATE_USER_who_can_acept_me_aplication="UPDATE galaxyuser.svazi_so_mnoy  set who_can_acept_me_aplication=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.svazi_so_mnoy WHERE svazi_so_mnoy.id=user.id AND svazi_so_mnoy.id=";


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
    public void Updatewho_write_masage_to_me(String id, String Newwho_write_masage_to_me) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_write_masage_to_me,id,UPDATE_USER_ID_WHERE,Newwho_write_masage_to_me);
    }

    @Override
    public void Updatewho_can_duel_me_video(String id, String Newwho_can_duel_me_video) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_can_duel_me_video,id,UPDATE_USER_ID_WHERE,Newwho_can_duel_me_video);
    }

    @Override
    public void Updatewho_can_duel_me_aplication(String id, String Newwho_can_duel_me_aplication) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_can_duel_me_aplication,id,UPDATE_USER_ID_WHERE,Newwho_can_duel_me_aplication);
    }

    @Override
    public void Updatewho_can_acept_me_video(String id, String Newwho_can_acept_me_video) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_can_acept_me_video,id,UPDATE_USER_ID_WHERE,Newwho_can_acept_me_video);
    }

    @Override
    public void Updatewho_can_acept_me_aplication(String id, String Newwho_can_acept_me_aplication) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_can_acept_me_aplication,id,UPDATE_USER_ID_WHERE,Newwho_can_acept_me_aplication);
    }

    @Override
    public Svyazy_so_mnoy SelectUserSvyazy_so_mnoy(String id) throws DBSystemException {
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
            Svyazy_so_mnoy svyazy_so_mnoy=null;

            if(rs.next()){
                String who_write_masage_to_me=rs.getString("who_write_masage_to_me");
                String who_can_duel_me_video=rs.getString("who_can_duel_me_video");
                String who_can_duel_me_aplication=rs.getString("who_can_duel_me_aplication");
                String who_can_acept_me_video=rs.getString("who_can_acept_me_video");
                String who_can_acept_me_aplication=rs.getString("who_can_acept_me_aplication");
                svyazy_so_mnoy= new Svyazy_so_mnoy();
                svyazy_so_mnoy.setWho_write_masage_to_me(who_write_masage_to_me);
                svyazy_so_mnoy.setWho_can_duel_me_video(who_can_duel_me_video);
                svyazy_so_mnoy.setWho_can_duel_me_aplication(who_can_duel_me_aplication);
                svyazy_so_mnoy.setWho_can_acept_me_video(who_can_acept_me_video);
                svyazy_so_mnoy.setWho_can_acept_me_aplication(who_can_acept_me_aplication);



            }
            conn.commit();
            return svyazy_so_mnoy;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertSo_mnoyRegister(String userId) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.svazi_so_mnoy (who_write_masage_to_me,who_can_duel_me_video,who_can_duel_me_aplication,who_can_acept_me_video,who_can_acept_me_aplication,id) value(?,?,?,?,?,?)");
            ps.setString(1,"Все пользователи");
            ps.setString(2,"Все пользователи");
            ps.setString(3,"Все пользователи");
            ps.setString(4,"Все пользователи");
            ps.setString(5,"Все пользователи");
            ps.setString(6,userId);
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
