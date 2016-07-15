package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education;

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
public class JDBC_User_Hith_Education implements Dao_User_Hith_Education {

    private static final String UPDATE_USER_COUNTRY="UPDATE galaxyuser.user_hith_education set Country=";
    private static final String UPDATE_USER_TOWN="UPDATE galaxyuser.user_hith_education set Town=";
    private static final String UPDATE_USER_UNIVERSITY="UPDATE galaxyuser.user_hith_education set university=";
    private static final String UPDATE_USER_DEPARTMENT="UPDATE galaxyuser.user_hith_education set department=";
    private static final String UPDATE_USER_CHAIR="UPDATE galaxyuser.user_hith_education set chair=";
    private static final String UPDATE_USER_MODE_OF_STUDY="UPDATE galaxyuser.user_hith_education set Mode_of_study=";
    private static final String UPDATE_USER_STATUS="UPDATE galaxyuser.user_hith_education set Status=";
    private static final String UPDATE_USER_RELEASE_DATE="UPDATE galaxyuser.user_hith_education set Release_date=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.user_hith_education WHERE user_hith_education.id=user.id AND user_hith_education.id=";



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
    public void UpdateUniversity(String id, String NewUniversity) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_UNIVERSITY,id,UPDATE_USER_ID_WHERE,NewUniversity);
    }

    @Override
    public void UpdateDepartment(String id, String NewDepartment) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_DEPARTMENT,id,UPDATE_USER_ID_WHERE,NewDepartment);
    }

    @Override
    public void UpdateChair(String id, String NewChair) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_CHAIR,id,UPDATE_USER_ID_WHERE,NewChair);
    }

    @Override
    public void UpdateMode_of_study(String id, String NewMode_of_study) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MODE_OF_STUDY,id,UPDATE_USER_ID_WHERE,NewMode_of_study);
    }

    @Override
    public void UpdateStatus(String id, String NewStatus) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_STATUS,id,UPDATE_USER_ID_WHERE,NewStatus);
    }

    @Override
    public void UpdateRelease_date(String id, String NewRelease_date) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_RELEASE_DATE,id,UPDATE_USER_ID_WHERE,NewRelease_date);
    }

    @Override
    public User_Hith_Education SelectUser_Hith_Education(String id) throws DBSystemException {
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
            User_Hith_Education user_hith_education=null;

            if(rs.next()){
                String Country=rs.getString("Country");
                String Town=rs.getString("Town");
                String University=rs.getString("university");
                String department=rs.getString("department");
                String chair=rs.getString("chair");
                String Mode_of_study=rs.getString("Mode_of_study");
                String Status=rs.getString("Status");
                String Release_date=rs.getString("Release_date");
                user_hith_education= new User_Hith_Education();
                user_hith_education.setCountry(Country);
                user_hith_education.setTown(Town);
                user_hith_education.setUniversity(University);
                user_hith_education.setDepartment(department);
                user_hith_education.setChair(chair);
                user_hith_education.setMode_of_study(Mode_of_study);
                user_hith_education.setStatus(Status);
                user_hith_education.setRelease_date(Release_date);

            }
            conn.commit();
            return user_hith_education;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertRegisterHightEducation(String Userid) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.user_hith_education (Country,Town,university,department,chair,Mode_of_study,Status,Release_date,id) value (?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,"");
            ps.setString(4,"");
            ps.setString(5,"");
            ps.setString(6,"");
            ps.setString(7,"");
            ps.setString(8,"");
            ps.setString(9,Userid);


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
