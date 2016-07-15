package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page;

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
public class JDBC_Zapisi_Page implements Dao_Zapisi_Page {

    private static final String UPDATE_who_saw_bad_zapisi="UPDATE  galaxyuser.zapisi_page  set who_saw_bad_zapisi=";
    private static final String UPDATE_who_can_cryare_zapisi="UPDATE  galaxyuser.zapisi_page  set who_can_cryare_zapisi=";
    private static final String UPDATE_who_saw_coments_to_zapisi="UPDATE  galaxyuser.zapisi_page  set  who_saw_coments_to_zapisi=";
    private static final String UPDATE_who_can_coment_my_zapisi="UPDATE  galaxyuser.zapisi_page  set who_can_coment_my_zapisi=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user, galaxyuser.zapisi_page WHERE  zapisi_page.id=user.id AND zapisi_page.id=";


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
    public void Update_who_saw_bad_zapisi(String id, String New_who_saw_bad_zapisi) throws DBSystemException {
        UpdateDaoShablon(UPDATE_who_saw_bad_zapisi,id,UPDATE_USER_ID_WHERE,New_who_saw_bad_zapisi);
    }

    @Override
    public void Update_who_can_cryare_zapisi(String id, String New_who_can_cryare_zapisi) throws DBSystemException {
        UpdateDaoShablon(UPDATE_who_can_cryare_zapisi,id,UPDATE_USER_ID_WHERE,New_who_can_cryare_zapisi);
    }

    @Override
    public void Update_who_saw_coments_to_zapisi(String id, String New_who_saw_coments_to_zapisi) throws DBSystemException {
        UpdateDaoShablon(UPDATE_who_saw_coments_to_zapisi,id,UPDATE_USER_ID_WHERE,New_who_saw_coments_to_zapisi);
    }

    @Override
    public void Update_who_can_coment_my_zapisi(String id, String New_who_can_coment_my_zapisi) throws DBSystemException {
        UpdateDaoShablon(UPDATE_who_can_coment_my_zapisi,id,UPDATE_USER_ID_WHERE,New_who_can_coment_my_zapisi);
    }

    @Override
    public Zapisi_page SelectUserZapisi_page(String id) throws DBSystemException {
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
            Zapisi_page zapisi_page=null;

            if(rs.next()){

                String who_saw_bad_zapisi=rs.getString("who_saw_bad_zapisi");
                String who_can_cryare_zapisi=rs.getString("who_can_cryare_zapisi");
                String who_saw_coments_to_zapisi=rs.getString("who_saw_coments_to_zapisi");
                String who_can_coment_my_zapisi=rs.getString("who_can_coment_my_zapisi");
                zapisi_page= new Zapisi_page();

                zapisi_page.setWho_saw_bad_zapisi(who_saw_bad_zapisi);
                zapisi_page.setWho_can_cryare_zapisi(who_can_cryare_zapisi);
                zapisi_page.setWho_saw_coments_to_zapisi(who_saw_coments_to_zapisi);
                zapisi_page.setWho_can_coment_my_zapisi(who_can_coment_my_zapisi);


            }
            conn.commit();
            return zapisi_page;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertZapisiPageRagistretion(String idUser) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.zapisi_page (who_saw_bad_zapisi,who_can_cryare_zapisi,who_saw_coments_to_zapisi,who_can_coment_my_zapisi,id) value(?,?,?,?,?)");
            ps.setString(1,"Все пользователи");
            ps.setString(2,"Все пользователи");
            ps.setString(3,"Все пользователи");
            ps.setString(4,"Все пользователи");
            ps.setString(5,idUser);
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
