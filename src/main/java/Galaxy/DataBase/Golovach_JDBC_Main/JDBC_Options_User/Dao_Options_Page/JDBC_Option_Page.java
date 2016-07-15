package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page;

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
public class JDBC_Option_Page implements Dao_Options_Page {
    private static final String UPDATE_USER_Skrity_blok_podarkov="UPDATE galaxyuser.options_page  set skrity_blok_podarkov=";
    private static final String UPDATE_USER_Zapisi_moi="UPDATE galaxyuser.options_page set  Zapisi_moi=";
    private static final String UPDATE_USER_Off_coments="UPDATE galaxyuser.options_page  set Off_coments=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.options_page WHERE options_page.id=user.id AND options_page.id=";


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
    public void UpdateSkrity_blok_podarkov(String id, String NeweSkrity_blok_podarkov) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Skrity_blok_podarkov,id,UPDATE_USER_ID_WHERE,NeweSkrity_blok_podarkov);
    }

    @Override
    public void UpdateZapisi_moi(String id, String NewZapisi_moi) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Zapisi_moi,id,UPDATE_USER_ID_WHERE,NewZapisi_moi);
    }

    @Override
    public void UpdateOff_coments(String id, String NewOff_coments) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Off_coments,id,UPDATE_USER_ID_WHERE,NewOff_coments);
    }

    @Override
    public Options_Page SelectUserOptions_Page(String id) throws DBSystemException {
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
            Options_Page options_page=null;

            if(rs.next()){

                String skrity_blok_podarkov=rs.getString("skrity_blok_podarkov");
                String Zapisi_moi=rs.getString("Zapisi_moi");
                String Off_coments=rs.getString("Off_coments");
                options_page= new Options_Page();
                options_page.setSkrity_blok_podarkov(skrity_blok_podarkov);
                options_page.setZapisi_moi(Zapisi_moi);
                options_page.setOff_coments(Off_coments);


            }
            conn.commit();
            return options_page;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertPageRegist(String UserId) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.options_page (skrity_blok_podarkov,Zapisi_moi,Options_pagecol,Off_coments,id) value(?,?,?,?,?)");
            ps.setString(1,"true");
            ps.setString(2,"true");
            ps.setString(3,"true");
            ps.setString(4,"true");
            ps.setString(5,UserId);
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
