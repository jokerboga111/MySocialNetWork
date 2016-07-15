package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.JDBC_User_service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.User_service;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 14.02.2016.
 */
public class RedactorUserService extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_User_service jdbc_user_service = (JDBC_User_service) Spring.springContext().getBean("serrviceUser");
        String id = request.getParameter("id");
        User_service user_service= null;
        try {
            user_service = jdbc_user_service.SelectUser_Life_Position(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String country = request.getParameter("country");
        String Service_war = request.getParameter("Service_war");


        try {
            jdbc_user_service.UpdateCountry(id, country);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_service.UpdateServise(id, Service_war);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }





        response.sendRedirect("socc2s/erd/Redactor.jsp");


    }


}
