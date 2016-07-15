package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie;

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
public class JDBC_Moment_Opovechenye implements Dao_Moment_opoveshenye {

    private static final String UPDATE_opovechenie_of_all="UPDATE galaxyuser.moment_opovechenie  set opovechenie_of_all=";
    private static final String UPDATE_saw_the_massege="UPDATE galaxyuser.moment_opovechenie  set  saw_the_massege=";
    private static final String UPDATE_listen_audio_masage="UPDATE galaxyuser.moment_opovechenie  set listen_audio_masage=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.moment_opovechenie WHERE moment_opovechenie.id=user.id AND moment_opovechenie.id=";

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
    public void Update_opovechenie_of_all(String id, String New_opovechenie_of_all) throws DBSystemException {
        UpdateDaoShablon(UPDATE_opovechenie_of_all,id,UPDATE_USER_ID_WHERE,New_opovechenie_of_all);
    }

    @Override
    public void Update_saw_the_massege(String id, String New_saw_the_massege) throws DBSystemException {
        UpdateDaoShablon(UPDATE_saw_the_massege,id,UPDATE_USER_ID_WHERE,New_saw_the_massege);
    }

    @Override
    public void Update_listen_audio_masage(String id, String New_listen_audio_masage) throws DBSystemException {
        UpdateDaoShablon(UPDATE_listen_audio_masage,id,UPDATE_USER_ID_WHERE,New_listen_audio_masage);
    }

    @Override
    public Moment_Opoveshenye SelectUserMoment_Opoveshenye(String id) throws DBSystemException {
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
            Moment_Opoveshenye moment_opoveshenye=null;

            if(rs.next()){
                String opovechenie_of_all=rs.getString("opovechenie_of_all");
                String saw_the_massege=rs.getString("saw_the_massege");
                String listen_audio_masage=rs.getString("listen_audio_masage");
                moment_opoveshenye= new Moment_Opoveshenye();
                moment_opoveshenye.setOpovechenie_of_all(opovechenie_of_all);
                moment_opoveshenye.setSaw_the_massege(saw_the_massege);
                moment_opoveshenye.setListen_audio_masage(listen_audio_masage);
            }
            conn.commit();
            return moment_opoveshenye;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertMomentRegister(String idUser) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.moment_opovechenie (opovechenie_of_all,saw_the_massege,listen_audio_masage,id) value(?,?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"true");
            ps.setString(3,"true");
            ps.setString(4,idUser);
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
