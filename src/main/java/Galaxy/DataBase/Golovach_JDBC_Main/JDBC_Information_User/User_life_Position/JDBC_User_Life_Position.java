package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position;

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
public class JDBC_User_Life_Position implements Dao_User_LIfe_Position {


    private static final String UPDATE_USER_POLITICAL="UPDATE galaxyuser.lifeposition set Political_answ=";
    private static final String UPDATE_USER_WORLDVIEW="UPDATE galaxyuser.lifeposition set worldview=";
    private static final String UPDATE_USER_MAIN_IN_LIFE="UPDATE galaxyuser.lifeposition set main_in_life=";
    private static final String UPDATE_USER_MAIN_IN_PEOPLE="UPDATE galaxyuser.lifeposition set main_in_people=";
    private static final String UPDATE_USER_SMOKING="UPDATE galaxyuser.lifeposition set attitude_about_smoking=";
    private static final String UPDATE_USER_ALCOHOLE="UPDATE galaxyuser.lifeposition set attitude_about_alcohole=";
    private static final String UPDATE_USER_SPRING="UPDATE galaxyuser.lifeposition set Pierian_spring=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.lifeposition WHERE lifeposition.id=user.id AND lifeposition.id=";

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
    public void UpdatePolitical_answ(String id, String NewPolitical_answ) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_POLITICAL,id,UPDATE_USER_ID_WHERE,NewPolitical_answ);
    }

    @Override
    public void Updateworldview(String id, String Newworldview) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_WORLDVIEW,id,UPDATE_USER_ID_WHERE,Newworldview);
    }

    @Override
    public void Updatemain_in_life(String id, String Newmain_in_life) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MAIN_IN_LIFE,id,UPDATE_USER_ID_WHERE,Newmain_in_life);
    }

    @Override
    public void Updatemain_in_people(String id, String Newmain_in_people) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MAIN_IN_PEOPLE,id,UPDATE_USER_ID_WHERE,Newmain_in_people);
    }

    @Override
    public void Updateattitude_about_smoking(String id, String Newattitude_about_smoking) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_SMOKING,id,UPDATE_USER_ID_WHERE,Newattitude_about_smoking);
    }

    @Override
    public void UpdatePierian_spring(String id, String NewPierian_spring) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_SPRING,id,UPDATE_USER_ID_WHERE,NewPierian_spring);
    }

    @Override
    public void Updateattitude_about_alcohole(String id, String Newattitude_about_alcohole) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_ALCOHOLE,id,UPDATE_USER_ID_WHERE,Newattitude_about_alcohole);
    }

    @Override
    public User_Life_Position SelectUser_Life_Position(String id) throws DBSystemException {
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
            User_Life_Position user_position=null;

            if(rs.next()){
                String Political_answ=rs.getString("Political_answ");
                String worldview=rs.getString("worldview");
                String main_in_life=rs.getString("main_in_life");
                String main_in_people=rs.getString("main_in_people");
                String attitude_about_smoking=rs.getString("attitude_about_smoking");
                String attitude_about_alcohole=rs.getString("attitude_about_alcohole");
                String Pierian_spring=rs.getString("Pierian_spring");
                user_position= new User_Life_Position();
                user_position.setPolitical_answ(Political_answ);
                user_position.setWorldview(worldview);
                user_position.setMain_in_life(main_in_life);
                user_position.setMain_in_people(main_in_people);
                user_position.setAttitude_about_smoking(attitude_about_smoking);
                user_position.setAttitude_about_alcohole(attitude_about_alcohole);
                user_position.setPierian_spring(Pierian_spring);

            }
            conn.commit();
            return user_position;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertLifePosRegister(String id) throws DBSystemException {

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
            ps = conn.prepareStatement("insert into galaxyuser.lifeposition (Political_answ,worldview,main_in_life,main_in_people,attitude_about_smoking,attitude_about_alcohole,id,Pierian_spring) value (?,?,?,?,?,?,?,?)");
            ps.setString(1,"");
            ps.setString(2,"");
            ps.setString(3,"");
            ps.setString(4,"");
            ps.setString(5,"");
            ps.setString(6,"");
            ps.setString(7,id);
            ps.setString(8,"");


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
