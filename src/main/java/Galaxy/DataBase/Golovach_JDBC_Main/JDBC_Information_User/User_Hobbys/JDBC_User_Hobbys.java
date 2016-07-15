package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 12.02.2016.
 */
public class JDBC_User_Hobbys implements Dao_User_Hobbys {
    private static final String UPDATE_USER_HOBBYS="UPDATE galaxyuser.user_hobbys set hobbys=";
    private static final String UPDATE_USER_INTERESTS="UPDATE galaxyuser.user_hobbys set Interes=";
    private static final String UPDATE_USER_FAVORITE_MUSIC="UPDATE galaxyuser.user_hobbys set FavoritMusic=";
    private static final String UPDATE_USER_FAVORITE_FILM="UPDATE galaxyuser.user_hobbys set FavoriteFilm=";
    private static final String UPDATE_USER_FAVORITE_TV_SHOW="UPDATE galaxyuser.user_hobbys set FavoriteTVShow=";
    private static final String UPDATE_USER_FAVORITE_GAMES="UPDATE galaxyuser.user_hobbys set FavoriteGames=";
    private static final String UPDATE_USER_FAVORITE_NOVELS="UPDATE galaxyuser.user_hobbys set FavoriteNovels=";
    private static final String UPDATE_USER_KEY_INFO="UPDATE galaxyuser.user_hobbys set KeyInfo=";
    private static final String UPDATE_USER_BOOKS="UPDATE galaxyuser.user_hobbys set FavoriteBooks=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALL_INFO_ABOUT_HOBBYS="SELECT * FROM galaxyuser.user,galaxyuser.user_hobbys WHERE user_hobbys.id=user.id AND user_hobbys.id=";


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

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }

    @Override
    public void UpdateHobbyUser(String id, String NewHobbyUser) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_HOBBYS,id,UPDATE_USER_ID_WHERE,NewHobbyUser);
    }

    @Override
    public void UpdateInterests(String id, String NewInterests) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_INTERESTS,id,UPDATE_USER_ID_WHERE,NewInterests);
    }

    @Override
    public void UpdateFavoriteMusic(String id, String NewFavoriteMusic) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_FAVORITE_MUSIC,id,UPDATE_USER_ID_WHERE,NewFavoriteMusic);
    }

    @Override
    public void UpdateFavoriteFilm(String id, String NewFavoriteFilm) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_FAVORITE_FILM,id,UPDATE_USER_ID_WHERE,NewFavoriteFilm);
    }

    @Override
    public void UpdateFavoriteTvShow(String id, String NewFavoriteTvShow) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_FAVORITE_TV_SHOW,id,UPDATE_USER_ID_WHERE,NewFavoriteTvShow);
    }

    @Override
    public void UpdateFavoriteBooks(String id, String NewFavoriteBooks) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_BOOKS,id,UPDATE_USER_ID_WHERE,NewFavoriteBooks);
    }

    @Override
    public void UpdateFavoriteGames(String id, String NewFavoriteGames) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_FAVORITE_GAMES,id,UPDATE_USER_ID_WHERE,NewFavoriteGames);
    }

    @Override
    public void UpdateFavoriteNovels(String id, String NewFavoriteNovels) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_FAVORITE_NOVELS,id,UPDATE_USER_ID_WHERE,NewFavoriteNovels);
    }

    @Override
    public void UpdateKeyInfo(String id, String NewKeyInfo) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_KEY_INFO,id,UPDATE_USER_ID_WHERE,NewKeyInfo);
    }

    @Override
    public User_Hobbys SelectUserHobbys(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ALL_INFO_ABOUT_HOBBYS+"'"+id+"'");
            User_Hobbys user_Hobbys=null;

            if(rs.next()){
                String Hobbys=rs.getString("hobbys");
                String Interests=rs.getString("Interes");
                String FavoriteMusic=rs.getString("FavoritMusic");
                String FavoriteFilm=rs.getString("FavoriteFilm");
                String FavoriteTvShow=rs.getString("FavoriteTVShow");
                String FavoriteBooks=rs.getString("FavoriteBooks");
                String FavoriteGames=rs.getString("FavoriteGames");
                String FavoriteNovels=rs.getString("FavoriteNovels");
                String FavoriteKeyInfo=rs.getString("KeyInfo");

                user_Hobbys= new User_Hobbys();
                user_Hobbys.setHobbys(Hobbys);
                user_Hobbys.setInterests(Interests);
                user_Hobbys.setFavoriteMusic(FavoriteMusic);
                user_Hobbys.setFavoriteFilm(FavoriteFilm);
                user_Hobbys.setFavoriteTvShow(FavoriteTvShow);
                user_Hobbys.setFavoriteBooks(FavoriteBooks);
                user_Hobbys.setFavoriteGames(FavoriteGames);
                user_Hobbys.setFavoriteNovels(FavoriteNovels);
                user_Hobbys.setFavoriteKeyInfo(FavoriteKeyInfo);

            }
            conn.commit();
            return user_Hobbys;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALL_INFO_ABOUT_HOBBYS +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertHobbyRegister(String userId) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.user_hobbys (hobbys,Interes,FavoritMusic,FavoriteFilm,FavoriteTVShow,FavoriteBooks,FavoriteGames,FavoriteNovels,KeyInfo,id) value (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,"");
            ps.setString(4,"");
            ps.setString(5,"");
            ps.setString(6,"");
            ps.setString(7,"");
            ps.setString(8,"");
            ps.setString(9,"");
            ps.setString(10,userId);


            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL =");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
