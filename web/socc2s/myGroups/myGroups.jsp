<%@ page import="Galaxy.Chat.ChatConstants" %>
<%@ page import="Galaxy.Chat.ChatState" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
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
                    <%
                        User u1= (User) session.getAttribute("user");%>
                    <span><%=u1.getlogin()%></span>
                </div>
                <img src="/socc2s/images/avatar.png">
                <div class="progress-rate"><span>60%</span></div>

                <ul class="check-user">

                    <li><a href="/moiDial?Selid=<%=u.getID()%>">Мои сообщения</a></li>
                    <li><a href="/socc2s/friends.jsp">Мои друзья</a></li>
                    <li><a href="/socc2s/Photo.jsp">Мои фотографии</a></li>
                    <li><a href="/socc2s/sound.jsp">Мои аудиозаписи</a></li>
                    <li><a href="/socc2s/Video.jsp">Мои видеозаписи</a></li>
                    <li><a href="/socc2s/myGroups/myGroups.jsp">Мои группы</a></li>
                    <li><a href="/socc2s/apliccations.jsp">Мои приложения</a></li>
                    <li><a href="/socc2s/options.jsp">Настройка</a></li>
                    <li><a href="/">Выход</a></li>
                </ul>
            </div><!--end panel-side-->


        </div><!--end sidebar-->

        <div id="content">
            <div class="info">
                Работу выполнил Иван Карпов. Все права сохранены. &copy;
            </div>
            <input type="text" name="seachG">
            <form action="/socc2s/myGroups/creategroup.jsp" method="post">
            <input type="submit" name="G" value="Создать соощество">
            </form>
            <div id="header1">
                <ul>
                    <li><a href="/socc2s/myGroups/myGroups.jsp">Группы</a></li>
                    <li><a href="/socc2s/myGroups/myPublics.jsp?idfri=<%=u.getID()%>">Публичные страницы</a></li>
                    <li><a href="/socc2s/myGroups/mySlebretys.jsp?idZ=<%=u.getID()%>">Мероприятия</a></li>
                    <li><a href="/admin?idZA=<%=u.getID()%>">Админ</a></li>
                </ul>
            </div>
            <% UserDao userDao=new UserDaoJdbc();
                List<Groups> gr=userDao.selectMyGroupById(u.getID());
                for(Groups groups:gr ){

            %>
            <div class="usertop">
                <img src="/socc2s/images/camera_200.png" width="40" height="40">
                <div class="name"><a href="/socc2s/myGroups/group.jsp?idGroup=<%=groups.getIdGroup()%>&NameGroup=<%=groups.getNameGroup()%>&idUser=<%=u.getID()%>" name="log"><%=groups.getNameGroup()%></a></div>
            </div>
            <%}%>
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




