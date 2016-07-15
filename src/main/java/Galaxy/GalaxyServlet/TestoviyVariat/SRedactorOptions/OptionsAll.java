package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class OptionsAll extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Ather_Service dao_ather_service=new JDBC_Ather_Service();
        try {
            Ather_Service ather_service=dao_ather_service.SelectUserAther_Service(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String My_Friend = request.getParameter("My_friends");
        String My_photo = request.getParameter("My_photo");
        String My_video = request.getParameter("My_video");
        String My_audio = request.getParameter("My_audio");
        String My_masseg = request.getParameter("My_masseg");
        String My_group = request.getParameter("My_group");
        String My_news = request.getParameter("My_news");
        String My_answer = request.getParameter("My_answer");
        String My_acepts = request.getParameter("My_acepts");
        String My_aplication = request.getParameter("My_aplication");
        String My_documents = request.getParameter("My_documents");
        System.out.println(My_Friend);


        try {
            dao_ather_service.UpdateMy_friends(id,My_Friend);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_photo(id, My_photo);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_video(id, My_video);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_mysic(id, My_audio);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_massege(id, My_masseg);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_group(id, My_group);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_news(id, My_news);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_answers(id, My_answer);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_aplication(id, My_aplication);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_bookmarks(id, My_acepts);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_ather_service.UpdateMy_documents(id, My_documents);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        response.sendRedirect("socc2s/erd/Options.jsp");


    }


}
