package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page;

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
public class JDBC_My_page implements Dao_My_Page {


    private static final String UPDATE_USER_who_saw_my_info="UPDATE galaxyuser.privat_page_my_page set who_saw_my_info=";
    private static final String UPDATE_USER_who_saw_photo_in_what_you_acept="UPDATE galaxyuser.privat_page_my_page  set who_saw_photo_in_what_you_acept=";
    private static final String UPDATE_USER_who_saw_video_in_what_you_acept="UPDATE galaxyuser.privat_page_my_page  set who_saw_video_in_what_you_acept=";
    private static final String UPDATE_USER_who_saw_spisok_group="UPDATE galaxyuser.privat_page_my_page  set who_saw_spisok_group=";
    private static final String UPDATE_USER_who_saw_spisok_audio="UPDATE galaxyuser.privat_page_my_page  set who_saw_spisok_audio=";
    private static final String UPDATE_USER_who_saw_spisok_surprise="UPDATE galaxyuser.privat_page_my_page  set who_saw_spisok_surprise=";
    private static final String UPDATE_USER_who_saw_map_photos="UPDATE galaxyuser.privat_page_my_page  set who_saw_map_photos=";
    private static final String UPDATE_USER_who_saw_friends_and_pidpish="UPDATE galaxyuser.privat_page_my_page  set who_saw_friends_and_pidpish=";
    private static final String UPDATE_USER_who_saw_my_skritish_friends="UPDATE galaxyuser.privat_page_my_page  set who_saw_my_skritish_friends=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.privat_page_my_page WHERE privat_page_my_page.id=user.id AND privat_page_my_page.id=";

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
    public void Update_who_saw_my_info(String id, String New_who_saw_my_info) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_my_info,id,UPDATE_USER_ID_WHERE,New_who_saw_my_info);
    }

    @Override
    public void Update_who_saw_photo_in_what_you_acept(String id, String New_who_saw_photo_in_what_you_acept) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_photo_in_what_you_acept,id,UPDATE_USER_ID_WHERE,New_who_saw_photo_in_what_you_acept);
    }

    @Override
    public void Update_who_saw_video_in_what_you_acept(String id, String New_who_saw_video_in_what_you_acept) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_video_in_what_you_acept,id,UPDATE_USER_ID_WHERE,New_who_saw_video_in_what_you_acept);
    }

    @Override
    public void Update_who_saw_spisok_group(String id, String New_who_saw_spisok_group) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_spisok_group,id,UPDATE_USER_ID_WHERE,New_who_saw_spisok_group);
    }

    @Override
    public void Update_who_saw_spisok_audio(String id, String New_who_saw_spisok_audio) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_spisok_audio,id,UPDATE_USER_ID_WHERE,New_who_saw_spisok_audio);
    }

    @Override
    public void Update_who_saw_spisok_surprise(String id, String New_who_saw_spisok_surprise) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_spisok_surprise,id,UPDATE_USER_ID_WHERE,New_who_saw_spisok_surprise);
    }

    @Override
    public void Update_who_saw_map_photos(String id, String New_who_saw_map_photos) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_map_photos,id,UPDATE_USER_ID_WHERE,New_who_saw_map_photos);
    }

    @Override
    public void Update_who_saw_friends_and_pidpish(String id, String New_who_saw_friends_and_pidpish) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_friends_and_pidpish,id,UPDATE_USER_ID_WHERE,New_who_saw_friends_and_pidpish);
    }

    @Override
    public void Update_who_saw_my_skritish_friends(String id, String New_who_saw_my_skritish_friends) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_who_saw_my_skritish_friends,id,UPDATE_USER_ID_WHERE,New_who_saw_my_skritish_friends);
    }

    @Override
    public My_page SelectUserMy_page(String id) throws DBSystemException {
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
            My_page my_page=null;

            if(rs.next()){
                String who_saw_my_info=rs.getString("who_saw_my_info");
                String who_saw_photo_in_what_you_acept=rs.getString("who_saw_photo_in_what_you_acept");
                String who_saw_video_in_what_you_acept=rs.getString("who_saw_video_in_what_you_acept");
                String who_saw_spisok_group=rs.getString("who_saw_spisok_group");
                String who_saw_spisok_audio=rs.getString("who_saw_spisok_audio");
                String who_saw_spisok_surprise=rs.getString("who_saw_spisok_surprise");
                String who_saw_map_photos=rs.getString("who_saw_map_photos");
                String who_saw_friends_and_pidpish=rs.getString("who_saw_friends_and_pidpish");
                String who_saw_my_skritish_friends=rs.getString("who_saw_my_skritish_friends");
                my_page= new My_page();
                my_page.setWho_saw_my_info(who_saw_my_info);
                my_page.setWho_saw_photo_in_what_you_acept(who_saw_photo_in_what_you_acept);
                my_page.setWho_saw_video_in_what_you_acept(who_saw_video_in_what_you_acept);
                my_page.setWho_saw_spisok_group(who_saw_spisok_group);
                my_page.setWho_saw_spisok_audio(who_saw_spisok_audio);
                my_page.setWho_saw_spisok_surprise(who_saw_spisok_surprise);
                my_page.setWho_saw_map_photos(who_saw_map_photos);
                my_page.setWho_saw_friends_and_pidpish(who_saw_friends_and_pidpish);
                my_page.setWho_saw_my_skritish_friends(who_saw_my_skritish_friends);


            }
            conn.commit();
            return my_page;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertMy_pageRegister(String idUser) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.privat_page_my_page (who_saw_my_info,who_saw_photo_in_what_you_acept,who_saw_video_in_what_you_acept,who_saw_spisok_group,who_saw_spisok_audio,who_saw_spisok_surprise,who_saw_map_photos,who_saw_friends_and_pidpish,who_saw_my_skritish_friends,id) value(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"Все пользователи");
            ps.setString(2,"Все пользователи");
            ps.setString(3,"Все пользователи");
            ps.setString(4,"Все пользователи");
            ps.setString(5,"Все пользователи");
            ps.setString(6,"Все пользователи");
            ps.setString(7,"Все пользователи");
            ps.setString(8,"Все пользователи");
            ps.setString(9,"Все пользователи");
            ps.setString(10,idUser);
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
