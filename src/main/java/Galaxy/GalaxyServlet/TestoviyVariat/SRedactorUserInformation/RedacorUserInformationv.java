package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
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
 * Created by Admin on 10.02.2016.
 */
public class RedacorUserInformationv extends Dispatcher {



        LoggingGalaxy rece= new LoggingGalaxy();
        public String getServletInfo(){
            return "Registration servlet";
        }
        public void service(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            JDBC_InformationUser dao_informaion_user = (JDBC_InformationUser) Spring.springContext().getBean("InformationUser");
            String id = request.getParameter("id");
            Iformation_User iformation_user = null;
            try {
                iformation_user = dao_informaion_user.SelectUserInformation(id);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }
            String name = request.getParameter("name");
            String SerName = request.getParameter("serName");
            String Pol = request.getParameter("pol");
            String FamaliOrder = request.getParameter("famalyOrder");
            String Town = request.getParameter("Town");
            String languege = request.getParameter("languege");
            String privatBirsday = request.getParameter("privatBirsday");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            System.out.print(name);
            System.out.print(SerName);
            System.out.print(Pol);
            System.out.print(FamaliOrder);
            System.out.print(Town);
            System.out.print(languege);
            System.out.print(privatBirsday);
            System.out.print(month);
            System.out.print(year);
            System.out.print(id);
            System.out.println(iformation_user.getName());

            try {
                dao_informaion_user.UpdateNameUser(id, name);
            } catch (DBSystemException e) {
                e.printStackTrace();
            }

                try {
                    dao_informaion_user.UpdateSerName(id,SerName);
                } catch (DBSystemException e) {
                    e.printStackTrace();
                }

                if (!Pol.equals(iformation_user.getPol())) {
                    try {
                        dao_informaion_user.UpdatePol(id,Pol);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }
                if (!FamaliOrder.equals(iformation_user.getFamaliOrder())) {
                    try {
                        dao_informaion_user.UpdateFamaliOrder(id,FamaliOrder);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }
                if (!Town.equals(iformation_user.getTown())) {
                    try {
                        dao_informaion_user.UpdateTown(id,Town);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }
                if (!languege.equals(iformation_user.getLanguege())) {
                    try {
                        dao_informaion_user.UpdateLanguege(id,languege);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }
                if (!privatBirsday.equals(iformation_user.getPrivatBirsday())) {
                    try {
                        dao_informaion_user.UpdatePrivateBirthDay(id,privatBirsday);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }
                if (!month.equals(iformation_user.getMonth())) {
                    try {
                        dao_informaion_user.UpdateBirthMonth(id,month);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }
                if (!year.equals(iformation_user.getYear())) {
                    try {
                        dao_informaion_user.UpdateBirthYear(id,year);
                    } catch (DBSystemException e) {
                        e.printStackTrace();
                    }
                }


                response.sendRedirect("socc2s/erd/Redactor.jsp");


            }


    }


