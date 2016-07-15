package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;

import java.sql.*;

/**
 * Created by Admin on 20.01.2016.
 */
public class PhotoDaoJDBC implements PhotoDao {
    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    public static final String SELECT_AVATAR_BY_USERID = "SELECT * from galaxyuser.myavatars WHERE idUser=";
    public static final String INSERT_AVATAR="INSERT INTO galaxyuser.myavatars  (idUser,NamePicture) value(?,?)";

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }

    @Override
    public Photo selectAvatarByIdUser(String idUser) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_AVATAR_BY_USERID+"'"+idUser+"'");
            Photo photo=null;
            if(rs.next()){
                String IdUser=rs.getString("idUser");
                String AvatarName=rs.getString("NamePicture");;
                photo=new Photo();
               photo.setIdUser(IdUser);
                photo.setNamePhoto(AvatarName);
            }
            conn.commit();
            return photo;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_AVATAR_BY_USERID +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }

    }

    @Override
    public void insertAvatar(String idUser,String NameAvatar) throws DBSystemException {
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

            ps= conn.prepareStatement(INSERT_AVATAR);
            ps.setString(1,idUser);
            ps.setString(2,NameAvatar);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_AVATAR);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }

    }
}
