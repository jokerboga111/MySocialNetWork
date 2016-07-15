<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.List" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <% UserDao rec=new UserDaoJdbc();
            PhotoDao pdao=new PhotoDaoJDBC();
            User u= (User) session.getAttribute("user");
            String img= (String) session.getAttribute("img");
            Photo photo= (Photo) pdao.selectAvatarByIdUser(u.getID());
        %>
        <%!
        String PhotoNullOrNot(String img,Photo photo){
            if(photo!=null){
                return photo.getNamePhoto();
            }else {
                return img;
            }
        }
        %>
        <title><%=u.getlogin()%></title>
        <link rel="shortcut icon" href= />
        <link media="screen" href="/socc2s/styles.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div id="wrapper">
            <div id="wrap-content">
                
                <div class="sear�h-panel">

                        <input id="story" class="input-text" name="story" type="text" placeholder="Поиск..." value="" />
                        <input type="submit" class="ser-button" alt="�����" title="�����" value="" />

                </div>
                
                <div id="header">
                    <ul>
                        <li><a href="/socc2s/ludi.jsp">Люди</a></li>
                        <li><a href="/poisck">Моя страница</a></li>
                        <li><a href="/socc2s/sound.jsp">Аудио</a></li>
                        <li><a href="/socc2s/Video.jsp">Видео</a></li>
                        <li><a href="/socc2s/myGroups/groups.jsp">Группы</a></li>
                        <li><a href="/socc2s/apliccations.jsp">Приложения</a></li>
                    </ul>
                </div>
                <jsp:useBean id="user" class="Galaxy.UserAccount.User" scope="request"/>
                <div id="sidebar">
                    
                    <div class="panel-side">
                        <div class="user-bg">



                            <span><%= u.getlogin()%></span>
                        </div>

                        <img src="/Photos/<%=PhotoNullOrNot(img,photo)%>"  width="130" height="169">


                        <form name="sendform" enctype="multipart/form-data"action="/yourservlet" method="post" >
                            <table>
                                <tr>
                                    <td>File to send:</td>
                                    <td>
                                        <input type="File" name="file_send">
                                    </td>
                                </tr>
                            </table>
                            <p>
                                <input type="submit" value="Send">
                            </p>
                        </form>
                        <div class="progress-rate"><span>60%</span></div>
      
                        <ul class="check-user">

                            <li><a href="/moiDial?Selid=<%=u.getID()%>">Мои сообщения</a></li>
                            <li><a href="/socc2s/friends.jsp">Мои друзья</a></li>
                            <li><a href="/socc2s/Photo.jsp">Мои фотографии</a></li>
                            <li><a href="/PoiskMyMusic?idUser=<%=u.getID()%>">Мои аудиозаписи</a></li>
                            <li><a href="/socc2s/Video.jsp">Мои видеозаписи</a></li>
                            <li><a href="/socc2s/myGroups/myGroups.jsp">Мои группы</a></li>
                            <li><a href="/socc2s/apliccations.jsp">Мои приложения</a></li>
                            <li><a href="/socc2s/options.jsp">Настройка</a></li>
                            <li><a href="/">Выход</a></li>
                        </ul>
                    </div><!--end panel-side-->
                    <div class="panel-side">
                        <%List<User> list=rec.selectFriends(u.getID());
                        for(User user1:list ){

                    %>
                    <div class="usertop">
                        <img src="/socc2s/images/camera_200.png" width="40" height="40">
                        <div class="name"><a href="/poiscPolsovatelya?id=<%=user1.getID()%>" name="log"><%=user1.getlogin()%></a></div>
                        <div class="on">Online</div>
                    </div>
                    <%}%>
                        </div>
                        
                        <div style="float:right"><a href="/">Все друзья? >></a></div>
                    </div><!--end panel-side-->

                    
                </div><!--end sidebar-->
                
                <div id="content">
                    <div class="info">
                        Работу выполнил Иван Карпов. Все права сохранены. &copy;
                    </div>

                    <div class="status-bar">
                        <span>
                            <input type="text"  style="width:650px" placeholder="Что у вас нового?" class="f_input" />
                        </span>
                    </div>
                </div><!--end content-->

            </div><!--end wrap-content-->
            <div id="footer">
                Работу выполнил Иван Карпов. Все права сохранены.<br>
                SiteName - 2015 &copy; |
                <a href="/">Реклама</a> |
                <a href="/">Правила</a> |
                <a href="/">Более интересно</a>
            </div>
        </div><!--end wrapper-->
    </body>
</html>

