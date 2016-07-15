<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SSound.Sound" %>
<%@ page import="java.util.List" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDaoJDBC" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.12.2015
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet"  type="text/css">
        <link rel="stylesheet" type="text/css" href="css/index.css">

    <link rel="stylesheet" type="text/css" href="/socc2s/GalaryImg/refed.css">

    <!--[if IE]>
    <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <% UserDao rec=new UserDaoJdbc();
        PhotoDao pdao=new PhotoDaoJDBC();
        User u= (User) session.getAttribute("user");
        String img= (String) session.getAttribute("img");
        Photo photo= (Photo) pdao.selectAvatarByIdUser(u.getID());
        SoundDao ser=new SoundDaoJDBC();
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
</head>
<body>
<div class="row">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                    <snap class="sr-only">Открыть навигацию</snap>
                    <snap class="icon-bar"></snap>
                    <snap class="icon-bar"></snap>
                    <snap class="icon-bar"></snap>
                </button>
                <a class="navbar-brand" href="#">Логотип</a>
            </div>
            <div class="collapse navbar-collapse" id="responsive-menu">
                <ul class="nav navbar-nav">
                    <li><a href="/socc2s/ludi.jsp">Люди</a></li>
                    <li><a href="/socc2s/myGroups/groups.jsp">Сообщества</a></li>
                    <li><a href="/socc2s/sound.jsp">Музыка</a></li>
                    <li><a href="#">Помощь</a></li>
                    <li class="fixed-width">
                        <a href="#">
                            <span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
                            <snap class="label label-warning">3</snap>
                        </a>
                    </li>
                    <li class="fixed-width">
                        <a href="#">
                            <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                            <snap class="label label-message">3</snap>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="logout">
                            <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                            Выйти
                        </a>
                    </li>



                </ul>
            </div>
        </div>
    </div>
</div>





<div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top" >
    <div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top" id="side-menu" >
        <ul>
            <li class="link active">
                <a href="/poisck">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Моя страница</span>
                </a>
            </li>


            <li class="link">
                <a href="#collapse-comment" data-toggle="collapse" aria-controls="collapse-comments">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Друзья</span>
                </a>
                <ul class="collapse collapseable" id="collapse-comment">
                    <li>
                        <a href="/PoiskDruzey?idfri=<%=u.getID()%>">Все друзья
                            <span class="label label-success pull-right hidden-xs hidden-sm">10</span>
                        </a>
                    </li>
                    <li>
                        <a href="/socc2s/friends/OnlineFriends.jsp">Онлайн
                            <span class="label label-success pull-right hidden-xs hidden-sm">10</span>
                        </a>
                    </li>

                    <li>
                        <a href="/PoiskZayavka?idZ=<%=u.getID()%>">Заявки
                            <span class="label label-warning pull-right hidden-xs hidden-sm">10</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="link">
                <a href="/socc2s/Photo.jsp">
                    <span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Мои Фотографии</span>
                </a>
            </li>

            <li class="link">
                <a href="/socc2s/Video.jsp">
                    <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Мои Видеозаписи</span>
                </a>
            </li>

            <li class="link ">
                <a href="/PoiskMyMusic?idUser=<%=u.getID()%>">
                    <span class="glyphicon glyphicon-music" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Мои аудиозаписи</span>
                </a>
            </li>
            <li class="link">
                <a href="#collapse-comments" data-toggle="collapse" aria-controls="collapse-comments">
                    <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Мои Сообщения</span>
                </a>
                <ul class="collapse collapseable" id="collapse-comments">
                    <li>
                        <a href="approved.html">Беседы
                            <span class="label label-success pull-right hidden-xs hidden-sm">10</span>
                        </a>
                    </li>

                    <li>
                        <a href="/moiDial?Selid=<%=u.getID()%>">Диалоги
                            <span class="label label-warning pull-right hidden-xs hidden-sm">10</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="link ">
                <a href="/socc2s/myGroups/myGroups.jsp">
                    <span class="glyphicon glyphicon-education" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Мои Группы</span>
                </a>
            </li>


            <li class="link">
                <a href="#collapse-post" data-toggle="collapse" aria-controls="collapse-post">
                    <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Новости</span>
                    <span class="label label-success pull-right hidden-xs hidden-sm">20</span>
                </a>
                <ul class="collapse collapseable" id="collapse-post">
                    <li><a href="new-article.html">Лента</a></li>
                    <li><a href="articles.html">Фотографии</a></li>
                    <li><a href="new-article.html">Поиск</a></li>
                    <li><a href="articles.html">Друзья</a></li>
                    <li><a href="articles.html">Статьи</a></li>
                </ul>
            </li>




            <li class="link">
                <a href="tags.html">
                    <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Ответы</span>
                </a>
            </li>

            <li class="link">
                <a href="tags.html">
                    <span class="glyphicon glyphicon-tags" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Закладки</span>
                </a>
            </li>

            <li class="link settings-btn">
                <a href="settings.html">
                    <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    <span class="hidden-sm hidden-xs">Опции</span>
                </a>
            </li>
        </ul>
    </div>
</div>

<div class="col-md-10 col-sm-11 display-table-cell valign-top">
    <div class="row1">


        <div class="panel-body" style="background-color:#fff;color:#000000;">

<div id="container1">
    <header>Photo</header>
    <div id="content1">
    <ul>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/01.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/01.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/02.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/02.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/03.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/03.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="https://youtu.be/s3yrEQzeDLw" title="Video"/><img src="https://youtu.be/s3yrEQzeDLw" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/05.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/05.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/06.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/06.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/07.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/07.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/08.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/08.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/09.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/09.jpg" width="200" height="120" alt=""></il>
        <il><a class="fancybox" rel="group" href="/socc2s/GalaryImg/gallery_img/big/10.jpg" title="Photos"/><img src="/socc2s/GalaryImg/gallery_img/small/10.jpg" width="200" height="120" alt=""></il>
    </ul>
        <script type="text/javascript">
            $(document).ready(function() {
                $(".fancybox").fancybox();
            });
        </script>
    </div>
    <footer>All</footer>
</div>



        </div>




</div>


    </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- Add mousewheel plugin (this is optional) -->
<script type="text/javascript" src="/socc2s/GalaryImg/lib/jquery.mousewheel-3.0.6.pack.js"></script>
<!-- Add fancyBox -->
<link rel="stylesheet" href="/socc2s/GalaryImg/source/jquery.fancybox.css" type="text/css" media="screen" />
<script type="text/javascript" src="/socc2s/GalaryImg/source/jquery.fancybox.pack.js"></script>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/default.js"></script>
<script src="js/js1/scripts.js"></script>
</body>
</html>

