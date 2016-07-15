package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.User_Hobbys;
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
public class RedactorUserEducation extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_User_Education educationUser = (JDBC_User_Education) Spring.springContext().getBean("EducationUser");
        String id = request.getParameter("id");
        User_Education education= null;
        try {
            education = educationUser.SelectUser_Education(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String country = request.getParameter("country");
        String town = request.getParameter("town");
        String school = request.getParameter("school");
        String Y_S_Study = request.getParameter("Y_S_Study");
        String Y_E_Study = request.getParameter("Y_E_Study");
        String dataend = request.getParameter("dataend");
        String class1= request.getParameter("class1");
        String spechia = request.getParameter("spechia");


        try {
            educationUser.UpdateCountry(id,country);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            educationUser.UpdateTown(id,town);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            educationUser.UpdateSchool(id,school);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        try {
            educationUser.UpdateYear_End_Study(id, Y_E_Study);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            educationUser.UpdateYear_Start_Study(id, Y_S_Study);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            educationUser.UpdateSpechialization(id,spechia);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            educationUser.UpdateData_End(id,dataend);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            educationUser.UpdateClass(id,class1);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }





        response.sendRedirect("socc2s/erd/Redactor.jsp");


    }


}
