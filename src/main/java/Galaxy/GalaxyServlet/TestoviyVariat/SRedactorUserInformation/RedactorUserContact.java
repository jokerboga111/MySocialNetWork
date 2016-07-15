package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser;
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
public class RedactorUserContact extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_Contact_Info contact_info = (JDBC_Contact_Info) Spring.springContext().getBean("ContactUser1");
        String id = request.getParameter("id");
        ContactInfo User_cotact = null;
        try {
            User_cotact = contact_info.SelectContactInformation(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String country = request.getParameter("country1");
        String town = request.getParameter("town1");
        String mPhone = request.getParameter("mPhone1");
        String house = request.getParameter("house");
        String Skype = request.getParameter("Skype1");
        String mySite = request.getParameter("mySite");
        System.out.print(mySite);

            try {
                contact_info.UpdateCountry(id, country);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }


            try {
                contact_info.UpdateTown(id, town);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }


            try {
                contact_info.UpdateHouse(id, house);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }



            try {
                contact_info.UpdateMyPhone(id, mPhone);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }


            try {
                contact_info.UpdateSkype(id, Skype);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }


            try {
                contact_info.UpdateMySite(id, mySite);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }




            response.sendRedirect("socc2s/erd/Redactor.jsp");


        }


    }



