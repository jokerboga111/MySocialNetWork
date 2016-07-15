package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.JDBC_USER_CAREER;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.User_Career;
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
public class RedactorCarrea extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_USER_CAREER carreaUser = ( JDBC_USER_CAREER) Spring.springContext().getBean("CarreaUser");
        String id = request.getParameter("id");
        User_Career user_career= null;
        try {
            user_career = carreaUser.SelectUser_Career(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String Place_To_work = request.getParameter("Place_To_work1");
        System.out.println(Place_To_work);
        String country = request.getParameter("country");
        String town = request.getParameter("town");
        String Year_Start_Study= request.getParameter("Year_Start_Study");
        String Year_End_Study = request.getParameter("Year_End_Study");
        String position = request.getParameter("position");

        try {
            carreaUser.UpdatePlace_To_work(id,Place_To_work);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            carreaUser.UpdateCountry(id,country);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            carreaUser.UpdateTown(id,town);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        try {
            carreaUser.UpdateYear_Start_Study(id,Year_Start_Study);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            carreaUser.UpdateYear_End_Study(id,Year_End_Study);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            carreaUser.UpdatePosition(id,position);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }





        response.sendRedirect("socc2s/erd/Redactor.jsp");


    }


}
