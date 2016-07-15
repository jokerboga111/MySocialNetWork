package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 08.03.2016.
 */
public class JDBC_Wall implements Dao_Wall {

    private static final String INSERT_OPISANIE="INSERT INTO galaxyuser.stena (id,opisanie) value (?,?)";
    private static final String UPDATE_ZAPISI="UPDATE galaxyuser.stena set zapisi=";
    private static final String UPDATE_PICTURE="UPDATE galaxyuser.stena set picture=";
    private static final String UPDATE_VIDEO="UPDATE galaxyuser.stena set video=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.stena WHERE stena.id=";



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
    public void insertNewOpisanie(String id, String Opisanie) throws DBSystemException {
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
            ps= conn.prepareStatement(INSERT_OPISANIE);
            ps.setString(1,id);
            ps.setString(2,Opisanie);
            ps.executeUpdate();
            conn.commit();


        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void updateNewPicture(String id, String Picture) throws DBSystemException {
        UpdateDaoShablon(UPDATE_PICTURE,Picture,UPDATE_USER_ID_WHERE ,id);
    }

    @Override
    public void updateNewVideo(String id, String Video) throws DBSystemException {
        UpdateDaoShablon(UPDATE_PICTURE,Video,UPDATE_USER_ID_WHERE ,id);
    }

    @Override
    public void updateNewZapisi(String id, String Zapisi) throws DBSystemException {
        UpdateDaoShablon(UPDATE_PICTURE,Zapisi,UPDATE_USER_ID_WHERE ,id);
    }

    @Override
    public List<Wall> selectListWall(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALLINFORMAATION+"'"+id+"'");
            System.out.println("2");
            List<Wall> Lwall=new ArrayList<Wall>();
            while(rs.next()){
                String picture=rs.getString("picture");
                String opisanie=rs.getString("opisanie");
                String video=rs.getString("video");
                String zapisi=rs.getString("zapisi");
                Wall wall=new Wall();
                wall.setOpisanie(opisanie);
                wall.setPicture(picture);
                wall.setVideo(video);
                wall.setZapisi(zapisi);
                Lwall.add(wall);

            }
            conn.commit();
            return Lwall;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '");
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public Wall selectWall(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALLINFORMAATION+"'"+id+"'");
            System.out.println("2");
            Wall wall=null;
            if(rs.next()){
                String picture=rs.getString("picture");
                String opisanie=rs.getString("opisanie");
                String video=rs.getString("video");
                String zapisi=rs.getString("zapisi");
                wall=new Wall();
                wall.setOpisanie(opisanie);
                wall.setPicture(picture);
                wall.setVideo(video);
                wall.setZapisi(zapisi);

            }
            conn.commit();
            return wall;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '");
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
