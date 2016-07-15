package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo;
import Galaxy.Logger.LoggingGalaxy;
import sun.swing.UIClientPropertyKey;

import java.sql.*;

/**
 * Created by Admin on 20.02.2016.
 */
public class JDBC_Upravlenye_Group implements Dao_Upravlenye_Group {

    private static final String UPDATE_USER_nameGroup="UPDATE galaxyuser.upravlenye_group set nameGroup=";
    private static final String UPDATE_USER_codeGroup="UPDATE galaxyuser.upravlenye_group set codeGroup=";
    private static final String UPDATE_USER_InfoGroup="UPDATE galaxyuser.upravlenye_group set InfoGroup=";
    private static final String UPDATE_USER_TemaGroup="UPDATE galaxyuser.upravlenye_group set TemaGroup=";
    private static final String UPDATE_USER_WebSite="UPDATE galaxyuser.upravlenye_group set WebSite=";
    private static final String UPDATE_USER_Oldfilter="UPDATE galaxyuser.upravlenye_group set Oldfilter=";
    private static final String UPDATE_USER_ComentFilter="UPDATE galaxyuser.upravlenye_group set ComentFilter=";
    private static final String UPDATE_USER_AddersGroup="UPDATE galaxyuser.upravlenye_group set AddersGroup=";
    private static final String UPDATE_USER_MassageGroup="UPDATE galaxyuser.upravlenye_group set MassageGroup=";
    private static final String UPDATE_USER_Wall="UPDATE galaxyuser.upravlenye_group set Wall=";
    private static final String UPDATE_USER_Photo="UPDATE galaxyuser.upravlenye_group set Photo=";
    private static final String UPDATE_USER_Video="UPDATE galaxyuser.upravlenye_group set Video=";
    private static final String UPDATE_USER_audio="UPDATE galaxyuser.upravlenye_group set audio=";
    private static final String UPDATE_USER_document="UPDATE galaxyuser.upravlenye_group set document=";
    private static final String UPDATE_USER_Beseda="UPDATE galaxyuser.upravlenye_group set Beseda=";
    private static final String UPDATE_USER_Matirial="UPDATE galaxyuser.upravlenye_group set Matirial=";
    private static final String UPDATE_USER_Type_of_group="UPDATE galaxyuser.upravlenye_group set Type_of_group=";
    private static final String UPDATE_USER_ID_WHERE="WHERE idGroup=";
    private static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.admingroup,galaxyuser.upravlenye_group WHERE upravlenye_group.idGroup=admingroup.idGroup AND upravlenye_group.idGroup=";

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
    public void UpdatenameGroup(String id, String NewnameGroup) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_nameGroup,id,UPDATE_USER_ID_WHERE,NewnameGroup);
    }

    @Override
    public void UpdatecodeGroup(String id, String NewcodeGroup) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_codeGroup,id,UPDATE_USER_ID_WHERE,NewcodeGroup);
    }

    @Override
    public void UpdateInfoGroup(String id, String NewInfoGroup) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_InfoGroup,id,UPDATE_USER_ID_WHERE,NewInfoGroup);
    }

    @Override
    public void UpdateTemaGroup(String id, String NewTemaGroup) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_TemaGroup,id,UPDATE_USER_ID_WHERE,NewTemaGroup);
    }

    @Override
    public void UpdateWebSite(String id, String NewWebSite) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_WebSite,id,UPDATE_USER_ID_WHERE,NewWebSite);
    }

    @Override
    public void UpdateMassageGroup(String id, String NewMassageGroup) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_MassageGroup,id,UPDATE_USER_ID_WHERE,NewMassageGroup);
    }

    @Override
    public void UpdateOldfilter(String id, String NewOldfilter) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Oldfilter,id,UPDATE_USER_ID_WHERE,NewOldfilter);
    }

    @Override
    public void UpdateComentFilter(String id, String NewComentFilter) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_ComentFilter,id,UPDATE_USER_ID_WHERE,NewComentFilter);
    }

    @Override
    public void UpdateAddersGroup(String id, String NewAddersGroup) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_AddersGroup,id,UPDATE_USER_ID_WHERE,NewAddersGroup);
    }

    @Override
    public void UpdateWall(String id, String NewWall) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Wall,id,UPDATE_USER_ID_WHERE,NewWall);
    }

    @Override
    public void UpdatePhoto(String id, String NewPhoto) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Photo,id,UPDATE_USER_ID_WHERE,NewPhoto);
    }

    @Override
    public void UpdateVideo(String id, String NewVideo) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Video,id,UPDATE_USER_ID_WHERE,NewVideo);
    }

    @Override
    public void Updateaudio(String id, String Newaudio) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_audio,id,UPDATE_USER_ID_WHERE,Newaudio);
    }

    @Override
    public void Updatedocument(String id, String Newdocument) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_document,id,UPDATE_USER_ID_WHERE,Newdocument);
    }

    @Override
    public void UpdateBeseda(String id, String NewBeseda) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Beseda,id,UPDATE_USER_ID_WHERE,NewBeseda);
    }

    @Override
    public void UpdateMatirial(String id, String NewMatirial) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Matirial,id,UPDATE_USER_ID_WHERE,NewMatirial);
    }

    @Override
    public void UpdateType_of_group(String id, String NewType_of_group) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Type_of_group,id,UPDATE_USER_ID_WHERE,NewType_of_group);
    }

    @Override
    public UpravlenyeGroup SelectUpravlenyeGroup(String id) throws DBSystemException {
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
            UpravlenyeGroup upravlenyeGroup=null;

            if(rs.next()){

                String nameGroup=rs.getString("nameGroup");
                String codeGroup=rs.getString("codeGroup");
                String InfoGroup=rs.getString("InfoGroup");
                String TemaGroup=rs.getString("TemaGroup");
                String WebSite=rs.getString("WebSite");
                String Oldfilter=rs.getString("Oldfilter");
                String ComentFilter=rs.getString("ComentFilter");
                String AddersGroup=rs.getString("AddersGroup");
                String MassageGroup=rs.getString("MassageGroup");
                String Wall=rs.getString("Wall");
                String Photo=rs.getString("Photo");
                String Video=rs.getString("Video");
                String audio=rs.getString("audio");
                String document=rs.getString("document");
                String Beseda=rs.getString("Beseda");
                String Matirial=rs.getString("Matirial");
                String Type_of_group=rs.getString("Type_of_group");
                upravlenyeGroup= new UpravlenyeGroup();
                upravlenyeGroup.setNameGroup(nameGroup);
                upravlenyeGroup.setCodeGroup(codeGroup);
                upravlenyeGroup.setInfoGroup(InfoGroup);
                upravlenyeGroup.setTemaGroup(TemaGroup);
                upravlenyeGroup.setWebSite(WebSite);
                upravlenyeGroup.setOldfilter(Oldfilter);
                upravlenyeGroup.setComentFilter(ComentFilter);
                upravlenyeGroup.setAddersGroup(AddersGroup);
                upravlenyeGroup.setMassageGroup(MassageGroup);
                upravlenyeGroup.setWall(Wall);
                upravlenyeGroup.setPhoto(Photo);
                upravlenyeGroup.setVideo(Video);
                upravlenyeGroup.setAudio(audio);
                upravlenyeGroup.setDocument(document);
                upravlenyeGroup.setBeseda(Beseda);
                upravlenyeGroup.setMatirial(Matirial);
                upravlenyeGroup.setType_of_group(Type_of_group);


            }
            conn.commit();
            return upravlenyeGroup;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void InsertUpravlenye(String idGroup, String nameGroup) throws DBSystemException {
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
            ps = conn.prepareStatement("INSERT INTO galaxyuser.upravlenye_group (nameGroup,idGroup) value (?,?)");
            ps.setString(1,nameGroup);
            ps.setString(2,idGroup);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
