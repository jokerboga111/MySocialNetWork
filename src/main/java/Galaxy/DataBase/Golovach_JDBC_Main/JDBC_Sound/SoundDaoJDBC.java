package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.GalaxyServlet.TestoviyVariat.SSound.Sound;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20.01.2016.
 */
public class SoundDaoJDBC implements SoundDao {
    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    public static final String SELECT_ALL_SOUND = "SELECT * from galaxyuser.sound";
    public static final String INSERT_SOUND="INSERT INTO galaxyuser.sound  (idMaster,NameMusic) value(?,?)";
    public static final String SELECT_SOUND_BY_USER_ID = "SELECT * from galaxyuser.sound WHERE idMaster=";

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }
    @Override
    public List<Sound> selectAllSound() throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALL_SOUND );
            List<Sound> ls=new ArrayList<Sound>();
            Sound sound=null;
            while(rs.next()){
                String IdUser=rs.getString("idMaster");
                String SoundName=rs.getString("NameMusic");;
                sound=new Sound();
                sound.setIdUser(IdUser);
                sound.setNameSound(SoundName);
                ls.add(sound);
            }
            conn.commit();
            return ls;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALL_SOUND  +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }

    }

    @Override
    public void insertSound(String idUser, String NameSound) throws DBSystemException {
        Connection conn;
        boolean result=true;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            ps= conn.prepareStatement(INSERT_SOUND);
            ps.setString(1,idUser);
            ps.setString(2,NameSound);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SOUND);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }

    }

    @Override
    public List<Sound> selectSoundByUserId(String idUser) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_SOUND_BY_USER_ID+"'"+idUser+"'");
            List<Sound> ls=new ArrayList<Sound>();
            Sound sound=null;
            while(rs.next()){
                String IdUser=rs.getString("idMaster");
                String SoundName=rs.getString("NameMusic");;
                sound=new Sound();
                sound.setIdUser(IdUser);
                sound.setNameSound(SoundName);
                ls.add(sound);
            }
            conn.commit();
            return ls;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALL_SOUND  +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }

    }
}
