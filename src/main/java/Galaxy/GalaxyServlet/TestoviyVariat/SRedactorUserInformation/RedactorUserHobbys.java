package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info;
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
public class RedactorUserHobbys  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_User_Hobbys hobbyUser = (JDBC_User_Hobbys) Spring.springContext().getBean("HobbyUser");
        String id = request.getParameter("id");
        User_Hobbys user_hobbys= null;
        try {
            user_hobbys = hobbyUser.SelectUserHobbys(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String deyatelnosty = request.getParameter("deyatelnosty");
        String interes = request.getParameter("interes");
        String favoriteMusic = request.getParameter("favoriteMusic");
        String favoritefilm = request.getParameter("favoritefilm");
        String favoriteTvShow = request.getParameter("favoriteTvShow");
        String favoriteBook = request.getParameter("favoriteBook");
        String favoriteNovels= request.getParameter("favoriteNovels");
        String favoriteGames = request.getParameter("favoriteGames");
        String aboutMe = request.getParameter("aboutMe");

        try {
            hobbyUser.UpdateHobbyUser(id, deyatelnosty);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            hobbyUser.UpdateInterests(id, interes);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            hobbyUser.UpdateFavoriteMusic(id,favoriteMusic);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        try {
            hobbyUser.UpdateFavoriteFilm(id, favoritefilm);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            hobbyUser.UpdateFavoriteTvShow(id,favoriteTvShow);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            hobbyUser.UpdateFavoriteBooks(id, favoriteBook);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            hobbyUser.UpdateFavoriteNovels(id,favoriteNovels);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            hobbyUser.UpdateFavoriteGames(id,favoriteGames);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            hobbyUser.UpdateKeyInfo(id,aboutMe);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }




        response.sendRedirect("socc2s/erd/Redactor.jsp");


    }


}



