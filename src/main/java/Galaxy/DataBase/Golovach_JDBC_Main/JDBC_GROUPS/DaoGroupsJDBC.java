package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoGroupsJDBC implements DaoGroups {

    public static final String SELECT_SQL_GROUP_POLSOVATEL="SELECT galaxyuser.user.login," +
            " galaxyuser.user.uname,galaxyuser.user.SerName,galaxyuser.user.id FROM galaxyuser.user,galaxyuser.friendingroup WHERE friendingroup.yourid=user.id AND friendingroup.idGroup=";
    public static final String SELECT_SQL_POLSOVATEL_GROUPS="SELECT galaxyuser.groups.namegroup" +
            " ,galaxyuser.groups.idgroup FROM galaxyuser.groups,galaxyuser.spisokgroup WHERE spisokgroup.idgrup=groups.idgroup AND spisokgroup.yourId=";
    public static final String INSERT_ADMIN_GROUP = "INSERT INTO galaxyuser.admingroup (idGroup,NameGroup,idUser) value(?,?,?)";
    public static final String INSERT_SQL_FRIENDINGROUP="INSERT INTO galaxyuser.spisokgroup  (idgrup,NameGroup,yourid) value(?,?,?)";
    public static final String INSERT_SQL_GROUPINFRIEND="INSERT INTO galaxyuser.friendingroup  (yourId,NameGroup,idGroup) value(?,?,?)";
    public static final String DELET_BY_POLSOVATEL_GROUP_SQL="DELETE FROM galaxyuser.zayavkigroups where idGroup=";
    public static final String SELECT_ADMIN_SQL_ZAYAVKI="SELECT galaxyuser.user.login," +
            " galaxyuser.user.uname,galaxyuser.user.SerName,galaxyuser.user.id FROM galaxyuser.user,galaxyuser.zayavkigroups WHERE zayavkigroups.idUser=user.id AND zayavkigroups.idGroup=";
    public static final String SELECT_SQL_ADMIN_GROUP="SELECT * FROM galaxyuser.admingroup WHERE idUser=";
    public static final String INSERT_SQL_ZAYAVKA_GROUPS="INSERT INTO galaxyuser.zayavkigroups  (idGroup,NameGroup,idUser) value(?,?,?)";
    public static final String SELECT_SQL_GROUP="SELECT * FROM galaxyuser.groups";
    public static final String INSERT_SQL_GROUP="INSERT INTO galaxyuser.groups  (idgroup,namegroup) value(?,?)";
    public static final String SELECT_SQL_MY_GROUP="SELECT * FROM galaxyuser.friendingroup WHERE yourId=";


    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();
    LoggingGalaxy rece= new LoggingGalaxy();
    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }
    @Override
    public List<Groups> selectAdminGroupById(String idUser) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_SQL_ADMIN_GROUP+"'"+idUser+"'");
            Groups grup=null;
            List<Groups> lu=new ArrayList<Groups>();
            while(rs.next()){
                String Id=rs.getString("idGroup");
                String UName=rs.getString("NameGroup");
                grup=new Groups();
                grup.setNameGroup(UName);
                grup.setIdGroup(Id);
                lu.add(grup);
            }
            conn.commit();
            return lu;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_SQL_ADMIN_GROUP +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public Groups selectAdminGrouppById(String idUser,String idgroup) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_SQL_MY_GROUP+"'"+idUser+"'"+"AND idGroup="+"'"+idgroup+"'");
            Groups grup=null;

            if(rs.next()){
                String Id=rs.getString("idGroup");
                String UName=rs.getString("NameGroup");
                grup=new Groups();
                grup.setNameGroup(UName);
                grup.setIdGroup(Id);

            }
            conn.commit();
            return grup;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_SQL_ADMIN_GROUP +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<User> selectAdminZayavkiByIdGroup(String idGroup) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_ADMIN_SQL_ZAYAVKI+"'"+idGroup+"'");
            System.out.println("2");
            User user=null;
            List<User> lu=new ArrayList<User>();
            while(rs.next()){
                String Login=rs.getString("login");
                String LastName=rs.getString("SerName");
                String UName=rs.getString("uname");
                String id1=rs.getString("id");
                user=new User();
                user.setID(id1);
                user.setlogin(Login);
                user.setSerName(LastName);
                user.setName(UName);
                lu.add(user);
            }
            conn.commit();
            return lu;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ADMIN_SQL_ZAYAVKI+e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void deleteGroupAdminZayavka(String id, String idGroup) throws DBSystemException {
        Connection conn;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(DELET_BY_POLSOVATEL_GROUP_SQL+"'"+idGroup+"'"+"AND idUser="+"'"+id+"'");
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+DELET_BY_POLSOVATEL_GROUP_SQL);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertNewFriendInGroup(String id, String NameGroup, String idGroup) throws DBSystemException {
        Connection conn;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_SQL_GROUPINFRIEND);
            rece.log.debug("Содали запрос!");
            ps.setString(1,id);
            ps.setString(2,NameGroup);
            ps.setString(3,idGroup);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_GROUPINFRIEND);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertNewGroupInUser(String idGroup, String NameGroup, String id) throws DBSystemException {
        Connection conn;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_SQL_FRIENDINGROUP);
            rece.log.debug("Содали запрос!");
            ps.setString(1,idGroup);
            ps.setString(2,NameGroup);
            ps.setString(3,id);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_FRIENDINGROUP);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertAdminGroup(String idGroup, String NameGroup, String idUser) throws DBSystemException {
        Connection conn;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_ADMIN_GROUP);
            rece.log.debug("Содали запрос!");
            ps.setString(1,idGroup);
            ps.setString(2,NameGroup);
            ps.setString(3,idUser);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_ADMIN_GROUP);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<Groups> selectMyGroupById(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_SQL_POLSOVATEL_GROUPS+"'"+id+"'");
            System.out.println("2");
            Groups groups=null;
            List<Groups> lu=new ArrayList<Groups>();
            while(rs.next()){
                String idGroup=rs.getString("idgroup");
                String NameGroup=rs.getString("namegroup");
                groups=new Groups();
                groups.setIdGroup(idGroup);
                groups.setNameGroup(NameGroup);
                lu.add(groups);
            }
            conn.commit();
            return lu;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_SQL_POLSOVATEL_GROUPS +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<User> selectUserInGroupById(String idGroup) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_SQL_GROUP_POLSOVATEL+"'"+idGroup+"'");
            System.out.println("2");
            User user=null;
            List<User> lu=new ArrayList<User>();
            while(rs.next()){
                String Login=rs.getString("login");
                String LastName=rs.getString("SerName");
                String UName=rs.getString("uname");
                String id1=rs.getString("id");
                user=new User();
                user.setID(id1);
                user.setlogin(Login);
                user.setSerName(LastName);
                user.setName(UName);
                lu.add(user);
            }
            conn.commit();
            return lu;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_SQL_GROUP_POLSOVATEL +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertGroup(String idgroup, String NameGroup) throws DBSystemException {
        Connection conn;
        boolean result=true;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_SQL_GROUP);
            rece.log.debug("Содали запрос!");
            ps.setString(1,idgroup);
            ps.setString(2,NameGroup);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_GROUP);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<Groups> selectAllGroups() throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_SQL_GROUP);
            Groups grup=null;
            List<Groups> lu=new ArrayList<Groups>();
            while(rs.next()){
                String Id=rs.getString("idgroup");
                String UName=rs.getString("namegroup");
                grup=new Groups();
                grup.setNameGroup(UName);
                grup.setIdGroup(Id);
                lu.add(grup);
            }
            conn.commit();
            return lu;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_SQL_GROUP +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public boolean insertNewOrderGroups(String idGroup, String NameGroup, String idUser) throws DBSystemException, NotUniqueUserEmailException, NotUniqueUserLoginException {
        Connection conn;
        boolean result=true;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_SQL_ZAYAVKA_GROUPS);
            rece.log.debug("Содали запрос!");
            ps.setString(1,idGroup);
            ps.setString(2,NameGroup);
            ps.setString(3,idUser);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
            return result;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_ZAYAVKA_GROUPS);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
