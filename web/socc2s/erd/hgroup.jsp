<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User" %>
<%@ page
        import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.JDBC_User_Hith_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.User_Hith_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.JDBC_User_Life_Position" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.User_Life_Position" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.User_Hobbys" %>
<%@ page import="java.util.List" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriend" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.Dao_Upravlenye_Group" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.JDBC_Upravlenye_Group" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.UpravlenyeGroup" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroups" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroupsJDBC" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups" %>
<%--
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


  <%
    Dao_Upravlenye_Group upravlenye_group=new JDBC_Upravlenye_Group();
    DaoGroups daoGroups=new DaoGroupsJDBC();
    UserDao rec=(UserDao) Spring.springContext().getBean("userDao");
    PhotoDao pdao=(PhotoDao)Spring.springContext().getBean("photoDao");
    User u= (User) session.getAttribute("user");
    String img= (String) session.getAttribute("img");
    Photo photo= (Photo) pdao.selectAvatarByIdUser(u.getID());
    JDBC_InformationUser Iu=(JDBC_InformationUser)Spring.springContext().getBean("InformationUser");
    JDBC_User_Hith_Education UHE=(JDBC_User_Hith_Education)Spring.springContext().getBean("HithEducatUser");
    JDBC_User_Life_Position lP=(JDBC_User_Life_Position)Spring.springContext().getBean("LifePosition");
    JDBC_User_Education usE=(JDBC_User_Education)Spring.springContext().getBean("EducationUser");
    JDBC_Contact_Info contactInfo=(JDBC_Contact_Info)Spring.springContext().getBean("ContactUser1");
    JDBC_User_Hobbys juh=(JDBC_User_Hobbys)Spring.springContext().getBean("HobbyUser");
    Iformation_User Informetion_user=Iu.SelectUserInformation(u.getID());
    User_Hith_Education hithEduc=UHE.SelectUser_Hith_Education(u.getID());
    User_Life_Position lifeP=lP.SelectUser_Life_Position(u.getID());
    User_Education ue=usE.SelectUser_Education(u.getID());
    ContactInfo contactInfo1=contactInfo.SelectContactInformation(u.getID());
    DaoFriend friendDao=
            (DaoFriend) Spring.springContext().getBean("friendDao");
    Groups gr= daoGroups.selectAdminGrouppById(u.getID(),request.getParameter("idGroup"));
    UpravlenyeGroup upravlenyeGroup=upravlenye_group.SelectUpravlenyeGroup(gr.getIdGroup());

    User_Hobbys user_hobbys=juh.SelectUserHobbys(u.getID());

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
          <li><a href="/socc2s/erd/music.jsp">Музыка</a></li>
          <li><a href="#">Помощь</a></li>

          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Найти">
            </div>
            <button type="submit" class="btn btn-default">Поиск</button>
          </form>

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
            <a href="/socc2s/erd/friends.jsp#tab-2">Все друзья
              <span class="label label-success pull-right hidden-xs hidden-sm">10</span>
            </a>
          </li>
          <li>
            <a href="/socc2s/erd/friends.jsp">Онлайн
              <span class="label label-success pull-right hidden-xs hidden-sm">10</span>
            </a>
          </li>

          <li>
            <a href="/socc2s/erd/friends.jsp#tab-3">Заявки
              <span class="label label-warning pull-right hidden-xs hidden-sm">10</span>
            </a>
          </li>
        </ul>
      </li>

      <li class="link">
        <a href="/socc2s/erd/photo.jsp">
          <span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
          <span class="hidden-sm hidden-xs">Мои Фотографии</span>
        </a>
      </li>

      <li class="link">
        <a href="/socc2s/erd/video.jsp">
          <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
          <span class="hidden-sm hidden-xs">Мои Видеозаписи</span>
        </a>
      </li>

      <li class="link ">
        <a href="/socc2s/erd/music.jsp?idUser=<%=u.getID()%>">
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
            <a href="/socc2s/erd/message.jsp?id=<%=u.getID()%>">Беседы
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
        <a href="/socc2s/erd/group.jsp">
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
        <a href="/socc2s/erd/Options.jsp">
          <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
          <span class="hidden-sm hidden-xs">Опции</span>
        </a>
      </li>
    </ul>
  </div>
</div>

<div class="col-md-10 col-sm-11 display-table-cell ">
  <div class="row1">



    <%=(String)request.getAttribute("idGroup")%>


    <div class="col-md-10 col-sm-11 display-table-cell2 valign-top">

      <div class="panel-body" style="background-color:#fff;color:#000000;">

        <div class="row" >
          <div class="col-md-8">
            <h3 style="margin-left: 30px"><%=upravlenyeGroup.getNameGroup()%></h3>
            <hr>
           <h5 style="margin-left: 30px">Информация группы:<%=upravlenyeGroup.getInfoGroup()%></h5>
            <hr>
           <h5 style="margin-left: 30px">Тема группы:<%=upravlenyeGroup.getTemaGroup()%></h5>

            <br><br>
            <button class="btn btn-default">More</button>
          </div>

        </div>

        <hr>




        <div class="well">
          <h4>Мои фото  <a href="http://bootply.com/69913">Добавить фото</a></h4>
          <div class="row">
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/EDEDED" class="img-responsive"></a>
            </div>
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/DDDDDD" class="img-responsive"></a>
            </div>
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/555555/EEE" class="img-responsive"></a>
            </div>
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/F3F3F3" class="img-responsive"></a>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/999999/DDD" class="img-responsive"></a>
            </div>
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/CCCCCC" class="img-responsive"></a>
            </div>
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/EDEDED" class="img-responsive"></a>
            </div>
            <div class="col-md-3 col-sm-6 col-6">
              <a href="#"><img src="//placehold.it/600X200/E0E0E0" class="img-responsive"></a>
            </div>
          </div>
        </div>

        <hr>

        <div class="well">
          <h4>Мои записи  <a href="http://bootply.com/69913">к записям</a></h4>
          <textarea id="post_field" style="width: 550px;height:120px;"></textarea>
          <button type="button" class="btn btn-sm btn-default">Отправить</button>

        </div>




        <hr>

        <hr>

      </div>

    </div>






<div class="col-md-10 display-table-cell">

  <div class="col-md-2 col-sm-1 hidden-xs display-table-cell1 valign-top" id="side-menu"  >
    <img width="200" height="200" src="https://pp.vk.me/c628622/v628622106/22172/nlffExx9j8M.jpg" alt="Ваня  Карпов">
    <li class="link" width="20">
      <a href="Redactor.jsp#tab-1">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
        <span class="hidden-sm hidden-xs">Вступить в группу</span>
      </a>
    </li>

    <div class="panel-body">
      <hr>

      <h3>Участники</h3>
      <%List<User> list= friendDao.selectFriends(u.getID());
        for(User user1:list ){
      %>
      <h6><a href="#">
        <img data-src="holder.js/200x200" class="img-thumbnail" alt="200x200"
             data-holder-rendered="true" style="width: 80px; height: 80px;">
        <a href="/socc2s/erd/AtherPeople.jsp?id=<%=user1.getID()%>"><%=user1.getName()%> <%=user1.getSerName()%></a></a></h6>
      <%}%>

      <hr>

      <h3>Мои видеозаписи</h3>






    </div>
</div>


</div>
</div>
</div>
</div>

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

