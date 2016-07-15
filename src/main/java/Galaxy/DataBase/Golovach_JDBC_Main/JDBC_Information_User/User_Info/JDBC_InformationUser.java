package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;

import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 10.02.2016.
 */
public class JDBC_InformationUser implements Dao_Informaion_User {
    private static final String UPDATE_USER_NAME="UPDATE galaxyuser.informationuser set Name=";
    private static final String UPDATE_USER_TWONAME="UPDATE galaxyuser.informationuser  set TwoName=";
    private static final String UPDATE_USER_POL="UPDATE galaxyuser.informationuser  set Pol=";
    private static final String UPDATE_USER_FAMALYORDER="UPDATE galaxyuser.informationuser  set FamalyOrder=";
    private static final String UPDATE_USER_BIRTHDAY="UPDATE galaxyuser.informationuser  set Birthday=";
    private static final String UPDATE_USER_MONTH="UPDATE galaxyuser.informationuser  set BirthMoth=";
    private static final String UPDATE_USER_YEAR="UPDATE galaxyuser.informationuser  set BirthYear=";
    private static final String UPDATE_USER_LANGVEGE="UPDATE galaxyuser.informationuser  set languvege=";
    private static final String UPDATE_USER_TOWN="UPDATE galaxyuser.informationuser  set Town=";
    private static final String UPDATE_USER_PRIVATE_BIRTHDAY="UPDATE galaxyuser.informationuser  set privateBirsday=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.informationuser WHERE informationuser.id=user.id AND informationuser.id=";


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
            System.out.printf("Re re");
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
    public void UpdateNameUser(String id, String NewName) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_NAME,id,UPDATE_USER_ID_WHERE,NewName);
    }

    @Override
    public void UpdateSerName(String id, String NewSerName) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_TWONAME,id,UPDATE_USER_ID_WHERE,NewSerName);
    }

    @Override
    public void UpdateBirthDay(String id, String NewBirthDay) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_BIRTHDAY,id,UPDATE_USER_ID_WHERE,NewBirthDay);
    }

    @Override
    public void UpdateBirthMonth(String id, String NewBirthMonth) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MONTH,id,UPDATE_USER_ID_WHERE,NewBirthMonth);
    }

    @Override
    public void UpdateBirthYear(String id, String NewBirthMonth) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_YEAR,id,UPDATE_USER_ID_WHERE,NewBirthMonth);
    }

    @Override
    public void UpdatePol(String id, String NewPol) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_POL,id,UPDATE_USER_ID_WHERE,NewPol);
    }

    @Override
    public void UpdateFamaliOrder(String id, String NewFamaliOrder) throws DBSystemException{
        UpdateDaoShablon(UPDATE_USER_FAMALYORDER,id,UPDATE_USER_ID_WHERE,NewFamaliOrder);

    }

    @Override
    public void UpdatePrivateBirthDay(String id, String NewPrivateBirthDay) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_PRIVATE_BIRTHDAY,id,UPDATE_USER_ID_WHERE,NewPrivateBirthDay);

    }

    @Override
    public void UpdateLanguege(String id, String NewLanguege) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_LANGVEGE,id,UPDATE_USER_ID_WHERE,NewLanguege);
    }

    @Override
    public void UpdateTown(String id, String NewTown) throws DBSystemException{
        UpdateDaoShablon(UPDATE_USER_TOWN,id,UPDATE_USER_ID_WHERE,NewTown);
    }

    @Override
    public Iformation_User SelectUserInformation(String id) throws DBSystemException {
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
            Iformation_User user_Information=null;

            if(rs.next()){
                String Name=rs.getString("Name");
                String SerName=rs.getString("TwoName");
                String Town=rs.getString("Town");
                String PrivateBirthday=rs.getString("privateBirsday");
                int Birthday=rs.getInt("Birthday");
                String Month=rs.getString("BirthMoth");
                int Year=rs.getInt("BirthYear");
                String Languege=rs.getString("languvege");
                String FamaliOrder=rs.getString("FamalyOrder");
                String Pol=rs.getString("Pol");
                user_Information= new Iformation_User();
                user_Information.setFamaliOrder(FamaliOrder);
                user_Information.setLanguege(Languege);
                user_Information.setSerName(SerName);
                user_Information.setName(Name);
                user_Information.setMonth(Month);
                user_Information.setYear(Year);
                user_Information.setPol(Pol);
                user_Information.setPrivatBirsday(PrivateBirthday);
                user_Information.setTown(Town);
                user_Information.setBirthday(Birthday);

            }
            conn.commit();
            return user_Information;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertRegisterInfo(String Name,String twoName,String UserId) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.informationuser (Name,TwoName,Pol,FamalyOrder,Birthday,privateBirsday,Town,languvege,BirthMoth,BirthYear,id) value (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,Name);
            ps.setString(2,twoName);
            ps.setString(3,"");
            ps.setString(4,"");
            ps.setInt(5,0);
            ps.setString(6,"");
            ps.setString(7,"");
            ps.setString(8,"");
            ps.setString(9,"");
            ps.setInt(10,0);
            ps.setString(11,UserId);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
