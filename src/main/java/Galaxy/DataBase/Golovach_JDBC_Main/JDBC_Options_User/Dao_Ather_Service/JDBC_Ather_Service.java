package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 15.02.2016.
 */
public class JDBC_Ather_Service implements Dao_Ather_Service{



    private static final String UPDATE_USER_My_friends="UPDATE galaxyuser.user_options set My_friends=";
    private static final String UPDATE_USER_My_group="UPDATE galaxyuser.user_options  set My_group=";
    private static final String UPDATE_USER_My_mysic="UPDATE galaxyuser.user_options  set My_mysic=";
    private static final String UPDATE_USER_My_photo="UPDATE galaxyuser.user_options  set My_photo=";
    private static final String UPDATE_USER_My_video="UPDATE galaxyuser.user_options  set My_video=";
    private static final String UPDATE_USER_My_massege="UPDATE galaxyuser.user_options  set My_massege=";
    private static final String UPDATE_USER_My_news="UPDATE galaxyuser.user_options  set My_news=";
    private static final String UPDATE_USER_My_answers="UPDATE galaxyuser.user_options  set My_answers=";
    private static final String UPDATE_USER_My_bookmarks="UPDATE galaxyuser.user_options  set My_bookmarks=";
    private static final String UPDATE_USER_My_aplication="UPDATE galaxyuser.user_options  set My_aplication=";
    private static final String UPDATE_USER_My_documents="UPDATE galaxyuser.user_options  set  My_documents=";
    private static final String UPDATE_USER_My_blog_presents="UPDATE galaxyuser.user_options  set My_blog_presents=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.user_options WHERE user_options.id=user.id AND user_options.id=";


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
    public void UpdateMy_friends(String id, String NewMy_friends) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_friends,id,UPDATE_USER_ID_WHERE,NewMy_friends);
    }

    @Override
    public void UpdateMy_group(String id, String NewMy_group) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_group,id,UPDATE_USER_ID_WHERE,NewMy_group);
    }

    @Override
    public void UpdateMy_mysic(String id, String NewMy_mysic) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_mysic,id,UPDATE_USER_ID_WHERE,NewMy_mysic);
    }

    @Override
    public void UpdateMy_photo(String id, String NewMy_photo) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_photo,id,UPDATE_USER_ID_WHERE,NewMy_photo);
    }

    @Override
    public void UpdateMy_video(String id, String NewMy_video) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_video,id,UPDATE_USER_ID_WHERE,NewMy_video);
    }

    @Override
    public void UpdateMy_massege(String id, String NewMy_massege) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_massege,id,UPDATE_USER_ID_WHERE,NewMy_massege);
    }

    @Override
    public void UpdateMy_news(String id, String NewMy_news) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_news,id,UPDATE_USER_ID_WHERE,NewMy_news);
    }

    @Override
    public void UpdateMy_answers(String id, String NewMy_answers) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_answers,id,UPDATE_USER_ID_WHERE,NewMy_answers);
    }

    @Override
    public void UpdateMy_bookmarks(String id, String NewMy_bookmarks) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_bookmarks,id,UPDATE_USER_ID_WHERE,NewMy_bookmarks);
    }

    @Override
    public void UpdateMy_aplication(String id, String NewMy_aplication) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_aplication,id,UPDATE_USER_ID_WHERE,NewMy_aplication);
    }

    @Override
    public void UpdateMy_documents(String id, String NewMy_documents) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_documents,id,UPDATE_USER_ID_WHERE,NewMy_documents);
    }

    @Override
    public void UpdateMy_blog_presents(String id, String NewMy_blog_presents) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_My_blog_presents,id,UPDATE_USER_ID_WHERE,NewMy_blog_presents);
    }

    @Override
    public Ather_Service SelectUserAther_Service(String id) throws DBSystemException {
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
            Ather_Service ather_service=null;

            if(rs.next()){
                String My_friends=rs.getString("My_friends");
                String My_group=rs.getString("My_group");
                String My_mysic=rs.getString("My_mysic");
                String My_photo=rs.getString("My_photo");
                String My_video=rs.getString("My_video");
                String My_massege=rs.getString("My_massege");
                String My_news=rs.getString("My_news");
                String My_answers=rs.getString("My_answers");
                String My_bookmarks=rs.getString("My_bookmarks");
                String My_aplication=rs.getString("My_aplication");
                String My_documents=rs.getString("My_documents");
                String My_blog_presents=rs.getString("My_blog_presents");
                ather_service= new Ather_Service();
                ather_service.setMy_friends(My_friends);
                ather_service.setMy_group(My_group);
                ather_service.setMy_mysic(My_mysic);
                ather_service.setMy_photo(My_photo);
                ather_service.setMy_massege(My_massege);
                ather_service.setMy_video(My_video);
                ather_service.setMy_news(My_news);
                ather_service.setMy_answers(My_answers);
                ather_service.setMy_bookmarks(My_bookmarks);
                ather_service.setMy_aplication(My_aplication);
                ather_service.setMy_documents(My_documents);
                ather_service.setMy_blog_presents(My_blog_presents);


            }
            conn.commit();
            return ather_service;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertTrueRegister(String userId) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.user_options (My_friends,My_group,My_mysic,My_photo,My_video,My_massege,My_news,My_answers,My_bookmarks,My_aplication,My_documents,My_blog_presents,id) value(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"true");
            ps.setString(2,"true");
            ps.setString(3,"true");
            ps.setString(4,"true");
            ps.setString(5,"true");
            ps.setString(6,"true");
            ps.setString(7,"true");
            ps.setString(8,"true");
            ps.setString(9,"true");
            ps.setString(10,"true");
            ps.setString(11,"true");
            ps.setString(12,"true");
            ps.setString(13,userId);

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
