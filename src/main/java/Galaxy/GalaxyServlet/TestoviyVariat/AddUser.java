package Galaxy.GalaxyServlet.TestoviyVariat;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.JDBC_USER_CAREER;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.Dao_User_Hith_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.JDBC_User_Hith_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.JDBC_User_Life_Position;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.JDBC_User_service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.JDBC_ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.JDBC_Change_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.JDBC_Change_Id;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.JDBC_Moment_Opovechenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.JDBC_My_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.JDBC_Opoveshenie_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.JDBC_Option_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.JDBC_Svyazi_so_mnoy;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.JDBC_Zapisi_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Add user servlet";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        UserDao userDao=(UserDao) Spring.springContext().getBean("userDao");
        if (request.getParameter("save")!=null){
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String age = request.getParameter("age");
            int maxId=0;
            try {
               maxId=Integer.parseInt(userDao.selectMaxId());
            } catch (DBSystemException e) {
                e.printStackTrace();
            }
            Integer idUser=maxId+1;

            User newUser = new User();
            newUser.setlogin(login);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setAge(age);
            newUser.setName(name);
            newUser.setSerName(lastname);
            newUser.setID(idUser.toString());
            System.out.println(newUser.toString());
            boolean res = false;


            try {
                res = userDao.insertNewUser(newUser);
                JDBC_Ather_Service userDaoJdbc=new JDBC_Ather_Service();
                userDaoJdbc.insertTrueRegister(idUser.toString());
                Dao_Informaion_User informaion_user = new JDBC_InformationUser();
                informaion_user.insertRegisterInfo(name, lastname,idUser.toString());
                Dao_User_Hith_Education hith_education=new JDBC_User_Hith_Education();
                hith_education.insertRegisterHightEducation(idUser.toString());
                JDBC_Contact_Info contact_info=new JDBC_Contact_Info();
                contact_info.insertContactRegister(idUser.toString());
                JDBC_User_Education contact_info1= new JDBC_User_Education();
                contact_info1.insertEducationRegister(idUser.toString());
                JDBC_User_Life_Position rec= new JDBC_User_Life_Position();
                rec.insertLifePosRegister(idUser.toString());
                JDBC_User_Hobbys user_hobbys= new JDBC_User_Hobbys();
                user_hobbys.insertHobbyRegister(idUser.toString());
                JDBC_USER_CAREER user_career= new JDBC_USER_CAREER();
                user_career.insertCareaRegistr(idUser.toString());
                JDBC_User_service user_service= new JDBC_User_service();
                user_service.insertServiceRegister(idUser.toString());
                JDBC_Option_Page option_page= new JDBC_Option_Page();
                option_page.insertPageRegist(idUser.toString());
                JDBC_My_page my_page= new JDBC_My_page();
                my_page.insertMy_pageRegister(idUser.toString());
                JDBC_Zapisi_Page zapisi_page= new JDBC_Zapisi_Page();
                zapisi_page.insertZapisiPageRagistretion(idUser.toString());
                JDBC_Svyazi_so_mnoy svyazi_so_mnoy= new JDBC_Svyazi_so_mnoy();
                svyazi_so_mnoy.insertSo_mnoyRegister(idUser.toString());
                JDBC_ather_page atherPage= new JDBC_ather_page();
                atherPage.insertAtherPage(idUser.toString());
                JDBC_Opoveshenie_Email opoveshenie_email= new JDBC_Opoveshenie_Email();
                opoveshenie_email.insertOpoveshenieRegistetion(idUser.toString());
                JDBC_Moment_Opovechenye moment_opovechenye=new JDBC_Moment_Opovechenye();
                moment_opovechenye.insertMomentRegister(idUser.toString());
                JDBC_Change_Email change_email= new JDBC_Change_Email();
                change_email.insertChangeEmailRagister("4","vanyakarpov@icloud.com");
                JDBC_Change_Id change_id= new JDBC_Change_Id();
                change_id.inserIdREgister("4");
            } catch (DBSystemException e) {
                e.printStackTrace();
            } catch (NotUniqueUserEmailException e) {
                e.printStackTrace();
            } catch (NotUniqueUserLoginException e) {
                e.printStackTrace();
            }

            if (res) {
                this.forward("/successRegistration.jsp", request, response);
            } else {
                this.forward("/errorRegistration.html", request, response);
            }
        } else if (request.getParameter("cancel")!=null){
            this.forward("/login.html", request, response);
        }
    }
}