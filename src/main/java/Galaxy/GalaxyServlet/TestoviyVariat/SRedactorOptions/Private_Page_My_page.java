package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.Dao_Moment_opoveshenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.JDBC_Moment_Opovechenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.Moment_Opoveshenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.Dao_My_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.JDBC_My_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.My_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Dao_Options_Page;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class Private_Page_My_page  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_My_Page dao_my_page=new JDBC_My_page();
        My_page my_page=null;
        try {
            my_page=dao_my_page.SelectUserMy_page(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String who_saw_my_info = request.getParameter("who_saw_my_info");
        String who_saw_photo_in_what_you_acept = request.getParameter("who_saw_photo_in_what_you_acept");
        String who_saw_video_in_what_you_acept = request.getParameter("who_saw_video_in_what_you_acept");
        String who_saw_spisok_group = request.getParameter("who_saw_spisok_group");
        String who_saw_spisok_audio = request.getParameter("who_saw_spisok_audio");
        String who_saw_spisok_surprise = request.getParameter("who_saw_spisok_surprise");
        String who_saw_map_photos = request.getParameter("who_saw_map_photos");
        String who_saw_friends_and_pidpish = request.getParameter("who_saw_friends_and_pidpish");
        String who_saw_my_skritish_friends = request.getParameter("who_saw_my_skritish_friends");

        try {
            dao_my_page.Update_who_saw_my_info(id, who_saw_my_info);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_photo_in_what_you_acept(id, who_saw_photo_in_what_you_acept);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_video_in_what_you_acept(id, who_saw_video_in_what_you_acept);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_spisok_group(id, who_saw_spisok_group);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_spisok_audio(id, who_saw_spisok_audio);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_spisok_surprise(id, who_saw_spisok_surprise);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_map_photos(id, who_saw_map_photos);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_friends_and_pidpish(id, who_saw_friends_and_pidpish);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_my_page.Update_who_saw_my_skritish_friends(id, who_saw_my_skritish_friends);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        response.sendRedirect("socc2s/erd/Options.jsp");


    }}

