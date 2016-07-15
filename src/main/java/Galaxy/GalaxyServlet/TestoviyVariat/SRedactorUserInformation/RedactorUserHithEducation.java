package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.JDBC_User_Hith_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.User_Hith_Education;

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
public class RedactorUserHithEducation extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_User_Hith_Education jdbc_user_hith_education = (JDBC_User_Hith_Education) Spring.springContext().getBean("HithEducatUser");
        String id = request.getParameter("id");
        User_Hith_Education user_hith_education= null;
        try {
            user_hith_education = jdbc_user_hith_education.SelectUser_Hith_Education(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String country = request.getParameter("country");
        String town = request.getParameter("town");
        String univers = request.getParameter("univers");
        String department= request.getParameter("department");
        String chair = request.getParameter("chair");
        String Mode_of_study= request.getParameter("Mode_of_study");
        String status= request.getParameter("status");
        String Release_date = request.getParameter("Release_date");


        try {
            jdbc_user_hith_education.UpdateCountry(id, country);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_hith_education.UpdateTown(id, town);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_hith_education.UpdateDepartment(id, department);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        try {
            jdbc_user_hith_education.UpdateChair(id, chair);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_hith_education.UpdateMode_of_study(id,Mode_of_study);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_hith_education.UpdateUniversity(id, univers);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            jdbc_user_hith_education.UpdateRelease_date(id,Release_date);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            jdbc_user_hith_education.UpdateStatus(id,status);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }





        response.sendRedirect("socc2s/erd/Redactor.jsp");


    }


}

