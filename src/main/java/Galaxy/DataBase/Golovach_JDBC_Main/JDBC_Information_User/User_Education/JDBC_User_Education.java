package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 12.02.2016.
 */
public class JDBC_User_Education implements Dao_User_Education {

    private static final String UPDATE_USER_COUNTRY="UPDATE galaxyuser.user_education set Country=";
    private static final String UPDATE_USER_TOWN="UPDATE galaxyuser.user_education set Town=";
    private static final String UPDATE_USER_SCHOOL="UPDATE galaxyuser.user_education set School=";
    private static final String UPDATE_USER_YEAR_START_STUDY="UPDATE galaxyuser.user_education set Year_Start_Study=";
    private static final String UPDATE_USER_YEAR_END_STUDY="UPDATE galaxyuser.user_education set Year_End_Study=";
    private static final String UPDATE_USER_DATA_END="UPDATE galaxyuser.user_education set Date_End=";
    private static final String UPDATE_USER_CLASS="UPDATE galaxyuser.user_education set Class=";
    private static final String UPDATE_USER_SPECHIALIZATION="UPDATE galaxyuser.user_education set Spechializeshion=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.user_education WHERE user_education.id=user.id AND user_education.id=";

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
    public void UpdateSchool(String id, String NewSchool) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_SCHOOL,id,UPDATE_USER_ID_WHERE,NewSchool);
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
    public void UpdateData_End(String id, String NewData_End) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_DATA_END,id,UPDATE_USER_ID_WHERE,NewData_End);
    }

    @Override
    public void UpdateClass(String id, String NewClass) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_CLASS,id,UPDATE_USER_ID_WHERE,NewClass);
    }

    @Override
    public void UpdateSpechialization(String id, String NewSpechialization) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_SPECHIALIZATION,id,UPDATE_USER_ID_WHERE,NewSpechialization);
    }

    @Override
    public User_Education SelectUser_Education(String id) throws DBSystemException {
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
            User_Education user_education=null;

            if(rs.next()){
                String Country=rs.getString("Country");
                String Town=rs.getString("Town");
                String School=rs.getString("School");
                String Y_S_Study=rs.getString("Year_Start_Study");
                String Y_E_Study=rs.getString("Year_End_Study");
                String Data_End=rs.getString("Date_End");
                String Class=rs.getString("Class");
                String Spechializeshion=rs.getString("Spechializeshion");
                user_education= new User_Education();
                user_education.setCountry(Country);
                user_education.setTown(Town);
                user_education.setSchool(School);
                user_education.setY_S_Study(Y_S_Study);
                user_education.setY_E_Study(Y_E_Study);
                user_education.setData_End(Data_End);
                user_education.setClass1(Class);
                user_education.setSpechializeshion(Spechializeshion);

            }
            conn.commit();
            return user_education;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertEducationRegister(String userId) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.user_education (Country,Town,School,Year_Start_Study,Year_End_Study,Date_End,Class,Spechializeshion,id) value (?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,"");
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setString(7,"");
            ps.setString(8,"");
            ps.setString(9,userId);


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

