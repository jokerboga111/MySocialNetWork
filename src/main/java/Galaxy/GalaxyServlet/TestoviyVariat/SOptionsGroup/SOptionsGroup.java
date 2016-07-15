package Galaxy.GalaxyServlet.TestoviyVariat.SOptionsGroup;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.Dao_Upravlenye_Group;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.JDBC_Upravlenye_Group;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.UpravlenyeGroup;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.Ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.Dao_ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.JDBC_ather_page;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 20.02.2016.
 */
public class SOptionsGroup  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Upravlenye_Group upravlenye_group=new JDBC_Upravlenye_Group();
      UpravlenyeGroup upravlenyeGroup=null;
        try {
            upravlenyeGroup=upravlenye_group.SelectUpravlenyeGroup(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String nameGroup= request.getParameter("nameGroup");
        String codeGroup= request.getParameter("codeGroup");
        String InfoGroup= request.getParameter("InfoGroup");
        String TemaGroup= request.getParameter("TemaGroup");
        String WebSite= request.getParameter("WebSite");
        String oldFilter= request.getParameter("oldFilter");
        String commentFilter= request.getParameter("commentFilter");
        String AdresGroup= request.getParameter("AdresGroup");
        String massageGroup= request.getParameter("massageGroup");
        String wall= request.getParameter("wall");
        String photo= request.getParameter("photo");
        String video= request.getParameter("video");
        String audio= request.getParameter("audio");
        String document= request.getParameter("document");
        String beseda= request.getParameter("beseda");
        String matirial= request.getParameter("matirial");
        String type_group= request.getParameter("type_group");


        try {
            upravlenye_group.UpdatenameGroup(id, nameGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdatecodeGroup(id, codeGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            upravlenye_group.UpdateInfoGroup(id, InfoGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            upravlenye_group.UpdateTemaGroup(id, TemaGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            upravlenye_group.UpdateWebSite(id, WebSite);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            upravlenye_group.UpdateOldfilter(id, oldFilter);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateComentFilter(id, commentFilter);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateAddersGroup(id, AdresGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateMassageGroup(id, massageGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateWall(id, wall);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdatePhoto(id, photo);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateVideo(id, video);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.Updateaudio(id, audio);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.Updatedocument(id, document);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateBeseda(id, beseda);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateMatirial(id, matirial);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            upravlenye_group.UpdateType_of_group(id, type_group);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        response.sendRedirect("socc2s/erd/Options.jsp");


    }}
