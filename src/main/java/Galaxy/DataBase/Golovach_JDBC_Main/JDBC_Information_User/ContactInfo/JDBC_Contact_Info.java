package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;
import Galaxy.DataBase.Golovach_JDBC_Main.PatterDao.JDBC_DAO;
import Galaxy.DataBase.Golovach_JDBC_Main.PatterDao.PatterDao;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 11.02.2016.
 */
public class JDBC_Contact_Info implements Dao_Contact_Info {
    private static final String UPDATE_USER_COUNTRY="UPDATE galaxyuser.contactinfo set Country=";
    private static final String UPDATE_USER_TOWN="UPDATE galaxyuser.contactinfo set Town=";
    private static final String UPDATE_USER_HOUSE="UPDATE galaxyuser.contactinfo set Hous=";
    private static final String UPDATE_USER_MYPHONE="UPDATE galaxyuser.contactinfo set MPhone=";
    private static final String UPDATE_USER_SKYPE="UPDATE galaxyuser.contactinfo set Skype=";
    private static final String UPDATE_USER_MYSITE="UPDATE galaxyuser.contactinfo set YourSite=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.contactinfo WHERE contactinfo.id=user.id AND contactinfo.id=";

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
    public void UpdateHouse(String id, String NewHouse) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_HOUSE,id,UPDATE_USER_ID_WHERE,NewHouse);
    }

    @Override
    public void UpdateMyPhone(String id, String NewMyPhone) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MYPHONE,id,UPDATE_USER_ID_WHERE,NewMyPhone);
    }

    @Override
    public void UpdateSkype(String id, String NewSkype) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_SKYPE,id,UPDATE_USER_ID_WHERE,NewSkype);
    }

    @Override
    public void UpdateMySite(String id, String NewMySite) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MYSITE,id,UPDATE_USER_ID_WHERE,NewMySite);
    }

    @Override
    public ContactInfo SelectContactInformation(String id) throws DBSystemException {
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
            ContactInfo contactInfo=null;

            if(rs.next()){
                String Country=rs.getString("Country");
                String Town=rs.getString("Town");
                String House=rs.getString("Hous");
                String MyPhone=rs.getString("MPhone");
                String Skype=rs.getString("Skype");
                String YourSite=rs.getString("YourSite");
                contactInfo= new ContactInfo();
                contactInfo.setCountry(Country);
                contactInfo.setTown(Town);
                contactInfo.setHouse(House);
                contactInfo.setMyPhone(MyPhone);
                contactInfo.setSkype(Skype);
                contactInfo.setYourSite(YourSite);

            }
            conn.commit();
            return contactInfo;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertContactRegister(String userid) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.contactinfo (Country,Town,Hous,MPhone,Skype,YourSite,id) value (?,?,?,?,?,?,?);");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,"");
            ps.setString(4,"");
            ps.setString(5,"");
            ps.setString(6,"");
            ps.setString(7,userid);


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
