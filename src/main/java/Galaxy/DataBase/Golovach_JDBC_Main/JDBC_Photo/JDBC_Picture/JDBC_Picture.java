package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.JDBC_Picture;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 21.02.2016.
 */
public class JDBC_Picture implements Dao_Picture{

    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.my_photo WHERE user_id=";

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }


    @Override
    public List<Photo> selectPictureByIdUser(String idUser) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALLINFORMAATION+"'"+idUser+"'");
            List<Photo> photoList=new ArrayList<Photo>();
            while(rs.next()){
                String IdUser=rs.getString("user_id");
                String AvatarName=rs.getString("name_photo");;
                Photo photo=new Photo();
                photo.setIdUser(IdUser);
                photo.setNamePhoto(AvatarName);
                photoList.add(photo);
            }
            conn.commit();
            return photoList;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
