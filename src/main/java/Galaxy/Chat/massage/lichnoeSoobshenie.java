package Galaxy.Chat.massage;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage.DaoMassage;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage.DaoMassageJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Admin on 11.01.2016.
 */
public class lichnoeSoobshenie extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id=request.getParameter("id");
        String adres=request.getParameter("komu");
        String idfriend=request.getParameter("idfriend");
        String soobshenye=request.getParameter("soobshenye");
        UserDao userDao= (UserDao) Spring.springContext().getBean("userDao");
        DaoMassage massageDao= (DaoMassage) Spring.springContext().getBean("masageDao");

        try {
            Dao_Informaion_User dao_informaion_user=new JDBC_InformationUser();
            Iformation_User iformation_user=dao_informaion_user.SelectUserInformation(id);

            User ur=userDao.selectByID(idfriend);
            User ur1=userDao.selectByID(id);
            int maxDialogId=massageDao.selectMaxId(id);
            int idDialog =maxDialogId+1;
            if(massageDao.checkDialog("1","2")){
            massageDao.insertNewDialog(idDialog,adres,id,idfriend);
            massageDao.insertNewDialog(idDialog,iformation_user.getName()+" "+iformation_user.getSerName(),idfriend,id);}
            Masege masege = null;
            Masege masege1=null;
            Locale local = new Locale("ru","RU");
            DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
            Date currentDate = new Date();
            masege=new Masege();
            masege.setIdDiaPol(iformation_user.getName() + " " + iformation_user.getSerName());
            masege.setMasage(soobshenye);
            masege.setYourId(ur1.getID());
            masege.setFirstAndLastName(iformation_user.getName()+" "+iformation_user.getSerName());
            masege.setTime(df.format(currentDate));
                masege1=new Masege();
            masege1.setIdDiaPol(iformation_user.getName() + " " + iformation_user.getSerName());
            masege1.setMasage(soobshenye);
            masege1.setYourId(ur.getID());
            masege1.setFirstAndLastName(iformation_user.getName()+" "+iformation_user.getSerName());
            masege1.setTime(df.format(currentDate));
                if(massageDao.checkDialog("1","2")){
            masege1.setIdDialog(idDialog);
                masege.setIdDialog(idDialog);}else{
                    masege1.setIdDialog(massageDao.selectIdDialog(id,idfriend));
                    masege.setIdDialog(massageDao.selectIdDialog(id,idfriend));
            }
            massageDao.insertNewMassage1(masege);
            massageDao.insertNewMassage1(masege1);



        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/socc2s/erd/dialogi.jsp");


    }
}