<%@ page import="Galaxy.Chat.ChatConstants" %>
<%@ page import="Galaxy.Chat.ChatState" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SSound.Sound" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDaoJDBC" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriend" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriendJDBC" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% DaoFriend rec=new DaoFriendJDBC();
        SoundDao ser=new SoundDaoJDBC();
        User u= (User) session.getAttribute("user");%>
    <title><%=u.getlogin()%></title>
    <link rel="shortcut icon" href="{THEME}/images/favicon.ico" />
    <link media="screen" href="/socc2s/styles.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="/socc2s/html5audioplayer-master/css/style.css" media="screen">
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
        </div>


        </div><!--end sidebar-->

        <div id="content">
            <div class="info">
                Вся музыка! &copy;
            </div><br>

            <form name="sendform" enctype="multipart/form-data"action="/InsertMyMusic" method="post" >
            Добавить аудио запись:<input type="File" name="file_send"><input type="submit" value="Send">
            </form><br>
            <div id="container">
                <div id="audio-image">
                    <img class="cover" />
                </div>
                <div id="audio-player">
                    <div id="audio-info">
                        <span class="artist"></span> - <span class="title"></span>
                    </div>
                    <input id="volume" type="range" min="0" max="10" value="5" />
                    <br>
                    <div id="buttons">
		 <span>
			<button id="prev"></button>
			<button id="play"></button>
			<button id="pause"></button>
			<button id="stop"></button>
			<button id="next"></button>
			</span>
                    </div>
                    <div class="clearfix"></div>
                    <div id="tracker">
                        <div id="progressBar">
                            <span id="progress"></span>
                        </div>
                        <span id="duration"></span>
                    </div>
                    <div class="clearfix"></div>
                    <ul id="playlist" class="hidden">
                        <%List<Sound> listSound=ser.selectSoundByUserId(u.getID());
                            for(Sound sound:listSound ){
                        %>
                        <li song="<%=sound.getNameSound()%>" cover="cover1.jpg" artist="Linkin Park"><%=sound.getNameSound()%></li>
                        <%}%>
                    </ul>
                </div>

            </div>

            <script src="/socc2s/html5audioplayer-master/js/jquery.js"></script>
            <script src="/socc2s/html5audioplayer-master/js/main.js"></script>





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






