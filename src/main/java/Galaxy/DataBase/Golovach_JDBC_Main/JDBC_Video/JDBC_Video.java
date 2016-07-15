package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Video;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 21.02.2016.
 */
public class JDBC_Video implements Dao_Video {

    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.my_video WHERE id=";

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }

    @Override
    public List<Video> selectVideoByIdUser(String idUser) throws DBSystemException {
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
            List<Video> videoList=new ArrayList<Video>();
            while(rs.next()){
                String IdUser=rs.getString("id");
                String AvatarName=rs.getString("my_video");
                String NameVideo=rs.getString("name_video");
                Video video=new Video();
                video.setId(IdUser);
                video.setNameVideo(NameVideo);
                video.setAdresVideo(AvatarName);
                videoList.add(video);
            }
            conn.commit();
            return videoList;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
