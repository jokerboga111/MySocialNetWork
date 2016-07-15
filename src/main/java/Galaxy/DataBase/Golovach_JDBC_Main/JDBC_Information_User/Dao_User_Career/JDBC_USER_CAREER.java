package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 12.02.2016.
 */
public class JDBC_USER_CAREER implements Dao_User_Career {

    private static final String UPDATE_USER_COUNTRY="UPDATE galaxyuser.user_career set Country=";
    private static final String UPDATE_USER_TOWN="UPDATE galaxyuser.user_career set Town=";
    private static final String UPDATE_USER_POSITION="UPDATE galaxyuser.user_career set Position=";
    private static final String UPDATE_USER_YEAR_START_STUDY="UPDATE galaxyuser.user_career set Year_Start_Study=";
    private static final String UPDATE_USER_YEAR_END_STUDY="UPDATE galaxyuser.user_career set Year_End_Study=";
    private static final String UPDATE_USER_PLACE_TO_WORK="UPDATE galaxyuser.user_career set Place_of_work=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.user_career WHERE user_career.id=user.id AND user_career.id=";

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
    public void UpdateCountry(String id, String NewCountry) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_COUNTRY,id,UPDATE_USER_ID_WHERE,NewCountry);
    }

    @Override
    public void UpdateTown(String id, String NewTown) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_TOWN,id,UPDATE_USER_ID_WHERE,NewTown);

    }

    @Override
    public void UpdatePosition(String id, String NewPosition) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_POSITION,id,UPDATE_USER_ID_WHERE,NewPosition);
    }


    @Override
    public void UpdateYear_Start_Study(String id, String NewYear_Start_Study) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_YEAR_START_STUDY,id,UPDATE_USER_ID_WHERE,NewYear_Start_Study);
    }

    @Override
    public void UpdateYear_End_Study(String id, String NewYear_End_Study) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_YEAR_END_STUDY,id,UPDATE_USER_ID_WHERE,NewYear_End_Study);
    }


    @Override
    public void UpdatePlace_To_work(String id, String NewPlace_To_work) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_PLACE_TO_WORK,id,UPDATE_USER_ID_WHERE,NewPlace_To_work);
    }

    @Override
    public User_Career SelectUser_Career(String id) throws DBSystemException {
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
            User_Career user_career=null;

            if(rs.next()){
                String Country=rs.getString("Country");
                String Town=rs.getString("Town");
                String Position=rs.getString("Position");
                String Y_S_Study=rs.getString("Year_Start_Study");
                String Y_E_Study=rs.getString("Year_End_Study");
                String Place_of_work=rs.getString("Place_of_work");
                user_career= new User_Career();
                user_career.setCountry(Country);
                user_career.setTown(Town);
                user_career.setPosition(Position);
                user_career.setYear_Start_Study(Y_S_Study);
                user_career.setYear_End_Study(Y_E_Study);
                user_career.setPlace_To_work(Place_of_work);

            }
            conn.commit();
            return user_career;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertCareaRegistr(String userId) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.user_career (Place_of_work,Country,Town,Year_Start_Study,Year_End_Study,Position,id) value (?,?,?,?,?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,"");
            ps.setString(4,"");
            ps.setString(5,"");
            ps.setString(6,"");
            ps.setString(7,userId);


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
