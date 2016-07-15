<%@ page import="Galaxy.Chat.ChatConstants" %>
<%@ page import="Galaxy.Chat.ChatState" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% UserDao rec=new UserDaoJdbc();
        User u= (User) session.getAttribute("user");%>
    <title><%=u.getlogin()%></title>
    <link rel="shortcut icon" href="{THEME}/images/favicon.ico" />
    <link media="screen" href="/socc2s/styles.css" type="text/css" rel="stylesheet" />
</head>
<body>

<div id="wrapper">
    <div id="wrap-content">

        <div class="sear�h-panel">
            <form method="get" action="/index.php" class="search-box">
                <input id="story" class="input-text" name="story" type="text" placeholder="Поиск..." value="" />
                <input type="submit" class="ser-button" alt="�����" title="�����" value="" />
            </form>
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

                    <span><%=u.getlogin()%></span>
                </div>
                <img src="/socc2s/images/avatar.png">
                <div class="progress-rate"><span>60%</span></div>

                <ul class="check-user">



                    <li><a href="/moiDial?Selid=<%=u.getID()%>">Мои сообщения</a></li>
                    <li><a href="/socc2s/friends.jsp">Мои друзья</a></li>
                    <li><a href="/socc2s/Photo.jsp">Мои фотографии</a></li>
                    <li><a href="/socc2s/sound.jsp">Мои аудиозаписи</a></li>
                    <li><a href="/socc2s/Video.jsp">Мои видеозаписи</a></li>
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

                <div style="float:right"><a href="/socc2s/friends.jsp">Все друзья? >></a></div>
            </div><!--end panel-side-->


        </div><!--end sidebar-->


        <div id="content">
            <div class="info">
                Работу выполнил Иван Карпов. Все права сохранены. &copy;
            </div>
            <%
                String idgroup=request.getParameter("idGroup");
                String Namegroup=request.getParameter("NameGroup");
                String idUser=request.getParameter("idUser");
            %>
            <div class="panel-side">
                <div class="user-bg">

                    <span><%=request.getParameter("NameGroup")%></span>
                </div>
                <img src="/socc2s/images/avatar.png">

                <ul class="check-user">
                    <li><a href="/socc2s/myGroups/Upravlenye.jsp?idGroup=<%=idgroup%>&NameGroup=<%=Namegroup%>&idUser=<%=idUser%>">Управление сообществом</a></li>
                    <li><a href="/zayavkivgroup?idGroup=<%=idgroup%>&NameGroup=><%=Namegroup%>&idUser=<%=idUser%>">Рекламировать сообщество</a></li>
                    <li><a href="/zayavkivgroup?idGroup=<%=idgroup%>&NameGroup=><%=Namegroup%>&idUser=<%=idUser%>">Статистика Сообщества</a></li>
                    <li><a href="/zayavkivgroup?idGroup=<%=idgroup%>&NameGroup=><%=Namegroup%>&idUser=<%=idUser%>">Добавить в закладки</a></li>


                </ul>
            </div><!--end panel-side-->



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
