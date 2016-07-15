<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDaoJDBC" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Dao_Options_Page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.JDBC_Option_Page" %>
<%@ page import="java.nio.file.OpenOption" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Options_Page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.Ather_page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Dao_Change_Email" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.JDBC_Change_Email" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Change_Email" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.Dao_Change_Id" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.JDBC_Change_Id" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.Change_Id" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.Dao_Opoveshenie_Email" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.JDBC_Opoveshenie_Email" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.Opoveshenie_Email" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.Dao_Moment_opoveshenye" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.JDBC_Moment_Opovechenye" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions.MomentAcepted" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.Moment_Opoveshenye" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.Dao_ather_page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.JDBC_ather_page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.Dao_Svyazi_so_mnoy" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.JDBC_Svyazi_so_mnoy" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.Svyazy_so_mnoy" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.Dao_Zapisi_Page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.JDBC_Zapisi_Page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.Zapisi_page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.Dao_My_Page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.JDBC_My_page" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.My_page" %>

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

  <%
    Dao_My_Page dao_my_page=new JDBC_My_page();
    Dao_Zapisi_Page dao_zapisi_page=new JDBC_Zapisi_Page();
    Dao_Svyazi_so_mnoy svazi=new JDBC_Svyazi_so_mnoy();
    Dao_ather_page rec1=new JDBC_ather_page();
    Dao_Moment_opoveshenye moment_opovechenye=new JDBC_Moment_Opovechenye();
    Dao_Ather_Service dao_options_page=new JDBC_Ather_Service();
    Dao_Options_Page dao_page=new JDBC_Option_Page();
    Dao_Change_Email dao_change_email=new JDBC_Change_Email();
    Dao_Change_Id dao_change_id=new JDBC_Change_Id();
    UserDao rec=new UserDaoJdbc();
    PhotoDao pdao=new PhotoDaoJDBC();
    Dao_Opoveshenie_Email dao_opoveshenie_email=new JDBC_Opoveshenie_Email();
    User u= (User) session.getAttribute("user");
    String img= (String) session.getAttribute("img");
    Photo photo= (Photo) pdao.selectAvatarByIdUser(u.getID());
    SoundDao ser=new SoundDaoJDBC();
    Change_Id change_id=dao_change_id.SelectUserChange_Id(u.getID());
    Ather_Service options_page=dao_options_page.SelectUserAther_Service(u.getID());
    Options_Page page1=dao_page.SelectUserOptions_Page(u.getID());
    Change_Email change_email=dao_change_email.SelectUserChange_Email(u.getID());
    Opoveshenie_Email opoveshenie_email=dao_opoveshenie_email.SelectUserOpoveshenie_Email(u.getID());
    Moment_Opoveshenye moment_opoveshenye1=moment_opovechenye.SelectUserMoment_Opoveshenye(u.getID());
    Ather_page ather_page=rec1.SelectUserAther_page(u.getID());
    Svyazy_so_mnoy svyazy_so_mnoy=svazi.SelectUserSvyazy_so_mnoy(u.getID());
    Zapisi_page zapisi_page=dao_zapisi_page.SelectUserZapisi_page(u.getID());
    My_page my_page=dao_my_page.SelectUserMy_page(u.getID());



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
        <a href="/socc2s/erd/Options.jsp">
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

      <ul class="nav nav-tabs">
        <li class="active"><a href="#tab-1" data-toggle="tab">Общее</a></li>
        <li><a href="#tab-2" data-toggle="tab">Приватность</a></li>
        <li><a href="#tab-3" data-toggle="tab">Оповещение</a></li>
        <li><a href="#tab-4" data-toggle="tab">Черный список</a></li>
      </ul>

      <div class="tab-content">
        <div class="tab-pane active" id="tab-1">
          <div class="well">
            <form action="/OptionsAll?id=<%=u.getID()%>" method="post">
            <p><input type="checkbox" name="My_friends" value="true" <%if(options_page.getMy_friends().equals("true")){%>checked<%}%> >Мои Друзья</p>
            <p><input type="checkbox" name="My_photo" value="true" <%if(options_page.getMy_photo().equals("true")){%>checked<%}%>>Мои Фотографии</p>
            <p><input type="checkbox" name="My_video" value="true" <%if(options_page.getMy_video().equals("true")){%>checked<%}%>>Мои Видеозаписи</p>
            <p><input type="checkbox" name="My_audio" value="true"  <%if(options_page.getMy_mysic().equals("true")){%>checked<%}%>>Мои Аудиозаписи</p>
            <p><input type="checkbox" name="My_masseg" value="true"  <%if(options_page.getMy_massege().equals("true")){%>checked<%}%>>Мои Сообщения</p>
            <p><input type="checkbox" name="My_group" value="true" <%if(options_page.getMy_group().equals("true")){%>checked<%}%>>Мои Группы</p>
            <p><input type="checkbox" name="My_news" value="true" <%if(options_page.getMy_news().equals("true")){%>checked<%}%>>Мои Новости</p>
            <p><input type="checkbox" name="My_answer" value="true" <%if(options_page.getMy_answers().equals("true")){%>checked<%}%>>Мои Ответы</p>
            <p><input type="checkbox" name="My_acepts" value="true" <%if(options_page.getMy_bookmarks().equals("true")){%>checked<%}%>>Мои Закладки</p>
            <p><input type="checkbox" name="My_aplication" value="true" <%if(options_page.getMy_aplication().equals("true")){%>checked<%}%>>Приложения</p>
            <p><input type="checkbox" name="My_documents" value="true" <%if(options_page.getMy_documents().equals("true")){%>checked<%}%>>Документы</p>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
              </form>
          </div>
          <div class="well">
            <form action="/OptionsPage?id=<%=u.getID()%>" method="post">
            <p><input type="checkbox" name="skrity_blok_podarkov" value="true" <%if(page1.getSkrity_blok_podarkov().equals("true")){%>checked<%}%>>Скрывать блок подарков</p>
            <p><input type="checkbox" name="Zapisi_moi" value="true" <%if(page1.getZapisi_moi().equals("true")){%>checked<%}%>>Показывать только мои записи</p>
            <p><input type="checkbox" name="Off_coments" value="true" <%if(page1.getOff_coments().equals("true")){%>checked<%}%>>Отключить комментирование записей</p>
            <small>
              <input type="submit" name="save" value="Сохранить">
            </small>
            </form>
          </div>
          <div class="well">
            <form action="/Changepasword?id=<%=u.getID()%>" method="post">
              Старый пароль:
              <input type="text" name="old_password" size="10"><br>
              Новый пароль:
              <input type="text" name="new_password" size="10"><br>
              Повторите пароль:
              <input type="text" name="repite_password" size="10"><br>
             <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
          <div class="well">
            <form action="/Changeemail?id=<%=u.getID()%>" method="post">
              Текущий адрес:
              <%=change_email.getNewEmail()%><br>
              Новый адрес:
              <input type="text" name="new_email" size="20"><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
          <div class="well">
            <form action="/Changeid?id=<%=u.getID()%>" method="post">
              Текущий id:
              id<%=change_id.getNewId()%><br>
              Новый id:
              <input type="text" name="new_id" size="20"><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
        </div>
        <div class="tab-pane " id="tab-2">
          <div class="well">
            <form action="/Private_Page_My_page?id=<%=u.getID()%>" method="post">
              Кто видит основную информацию моей страницы:
              <td>
                <select name = "who_saw_my_info">
                  <option <%if(my_page.getWho_saw_my_info().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_my_info().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_my_info().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_my_info().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_my_info().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит фотографии, на которых меня отметили:
              <td>
                <select name = "who_saw_photo_in_what_you_acept">
                  <option <%if(my_page.getWho_saw_photo_in_what_you_acept().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_photo_in_what_you_acept().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_photo_in_what_you_acept().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_photo_in_what_you_acept().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_photo_in_what_you_acept().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит видеозаписи, на которых меня отметили:
              <td>
                <select name = "who_saw_video_in_what_you_acept">
                  <option <%if(my_page.getWho_saw_video_in_what_you_acept().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_video_in_what_you_acept().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_video_in_what_you_acept().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_video_in_what_you_acept().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_video_in_what_you_acept().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит список моих групп:
              <td>
                <select name = "who_saw_spisok_group">
                  <option <%if(my_page.getWho_saw_spisok_group().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_spisok_group().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_spisok_group().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_spisok_group().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_spisok_group().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит список моих аудиозаписей:
              <td>
                <select name = "who_saw_spisok_audio">
                  <option <%if(my_page.getWho_saw_spisok_audio().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_spisok_audio().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_spisok_audio().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_spisok_audio().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_spisok_audio().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит список моих подарков:
              <td>
                <select  name = "who_saw_spisok_surprise">
                  <option <%if(my_page.getWho_saw_spisok_surprise().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_spisok_surprise().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_spisok_surprise().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_spisok_surprise().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_spisok_surprise().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит карту с моими фотографиями:
              <td>
                <select name = "who_saw_map_photos">
                  <option <%if(my_page.getWho_saw_map_photos().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_map_photos().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_map_photos().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_map_photos().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_map_photos().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кого видно в списке моих друзей и подписок:
              <td>
                <select name = "who_saw_friends_and_pidpish">
                  <option <%if(my_page.getWho_saw_friends_and_pidpish().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_friends_and_pidpish().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_friends_and_pidpish().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_friends_and_pidpish().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_friends_and_pidpish().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит моих скрытых друзей:
              <td>
                <select name = "who_saw_my_skritish_friends">
                  <option <%if(my_page.getWho_saw_my_skritish_friends().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(my_page.getWho_saw_my_skritish_friends().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(my_page.getWho_saw_my_skritish_friends().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(my_page.getWho_saw_my_skritish_friends().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(my_page.getWho_saw_my_skritish_friends().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>

              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
          <div class="well">
            <form action="/Zapisi_so_page?id=<%=u.getID()%>" method="post">
              Кто видит чужие записи на моей странице:
              <td>
                <select name = "who_saw_bad_zapisi">
                  <option <%if(zapisi_page.getWho_saw_bad_zapisi().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(zapisi_page.getWho_saw_bad_zapisi().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(zapisi_page.getWho_saw_bad_zapisi().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(zapisi_page.getWho_saw_bad_zapisi().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(zapisi_page.getWho_saw_bad_zapisi().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто может оставлять записи на моей странице:
              <td>
                <select name = "who_can_cryare_zapisi">
                  <option <%if(zapisi_page.getWho_can_cryare_zapisi().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(zapisi_page.getWho_can_cryare_zapisi().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(zapisi_page.getWho_can_cryare_zapisi().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(zapisi_page.getWho_can_cryare_zapisi().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(zapisi_page.getWho_can_cryare_zapisi().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто видит комментарии к записям:
              <td>
                <select name = "who_saw_coments_to_zapisi">
                  <option <%if(zapisi_page.getWho_saw_coments_to_zapisi().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(zapisi_page.getWho_saw_coments_to_zapisi().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(zapisi_page.getWho_saw_coments_to_zapisi().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(zapisi_page.getWho_saw_coments_to_zapisi().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(zapisi_page.getWho_saw_coments_to_zapisi().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто может комментировать мои записи:
              <td>
                <select name = "who_can_coment_my_zapisi">
                  <option <%if(zapisi_page.getWho_can_coment_my_zapisi().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(zapisi_page.getWho_can_coment_my_zapisi().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(zapisi_page.getWho_can_coment_my_zapisi().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(zapisi_page.getWho_can_coment_my_zapisi().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(zapisi_page.getWho_can_coment_my_zapisi().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
          <div class="well">
            <form action="/Svyazi?id=<%=u.getID()%>" method="post">
              Кто может писать мне личные сообщения:
              <td>
                <select name = "who_write_masage_to_me">
                  <option <%if(svyazy_so_mnoy.getWho_write_masage_to_me().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(svyazy_so_mnoy.getWho_write_masage_to_me().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(svyazy_so_mnoy.getWho_write_masage_to_me().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(svyazy_so_mnoy.getWho_write_masage_to_me().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(svyazy_so_mnoy.getWho_write_masage_to_me().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто может вызывать меня по видеосвязи:
              <td>
                <select name = "who_can_duel_me_video">
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_video().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_video().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_video().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_video().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_video().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто может вызывать меня в приложениях:
              <td>
                <select name = "who_can_duel_me_aplication">
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_aplication().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_aplication().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_aplication().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_aplication().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_duel_me_aplication().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто может приглашать меня в сообщества:
              <td>
                <select name = "who_can_acept_me_video">
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_video().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_video().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_video().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_video().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_video().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Кто может приглашать меня в приложения:
              <td>
                <select name = "who_can_acept_me_aplication">
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_aplication().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_aplication().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_aplication().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_aplication().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(svyazy_so_mnoy.getWho_can_acept_me_aplication().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
          <div class="well">
            <form action="/Ather?id=<%=u.getID()%>" method="post">
              Кому в интернете видна моя страница:
              <td>
                <select name = "who_can_see_my_page">
                  <option <%if(ather_page.getWho_can_see_my_page().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(ather_page.getWho_can_see_my_page().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(ather_page.getWho_can_see_my_page().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(ather_page.getWho_can_see_my_page().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(ather_page.getWho_can_see_my_page().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              Какие обновления видят в новостях мои друзья:
              <td>
                <select name = "what_about_can_see">
                  <option <%if(ather_page.getWhat_about_can_see().equals("Все пользователи")){%>selected <%}%> value = "Все пользователи">Все пользователи</option>
                  <option <%if(ather_page.getWhat_about_can_see().equals("Только друзья")){%>selected <%}%> value = "Только друзья">Только друзья</option>
                  <option <%if(ather_page.getWhat_about_can_see().equals("Друзья и друзья друзей")){%>selected <%}%> value = "Друзья и друзья друзей">Друзья и друзья друзей</option>
                  <option <%if(ather_page.getWhat_about_can_see().equals("Только я")){%>selected <%}%> value = "Только я">Только я</option>
                  <option <%if(ather_page.getWhat_about_can_see().equals("Некоторые друзья")){%>selected <%}%> value = "Некоторые друзья">Некоторые друзья</option>
                </select>
              </td><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
        </div>
        <div class="tab-pane " id="tab-3">

            <div class="well">
              <form action="/OpoveshenyeEmail?id=<%=u.getID()%>" method="post">
                E-Mail для оповещений: <%=change_email.getNewEmail()%>(<a href="Options.jsp">Изминить</a>)<br>
                Частота оповещений: <input type="text" name="chastota_opoveshenie" size="20"><br>
                <p><input type="checkbox" name="zaiavki_fiends" value="true" <%if(opoveshenie_email.getZaiavki_fiends().equals("true")){%>checked<%}%> >Заявки в друзья</p>
                <p><input type="checkbox" name="vosmoshnie_friends" value="true" <%if(opoveshenie_email.getVosmoshnie_friends().equals("true")){%>checked<%}%>>Возможные друзья</p>
                <p><input type="checkbox" name="lich_massege" value="true" <%if(opoveshenie_email.getLich_massege().equals("true")){%>checked<%}%>>Личные сообщения</p>
                <p><input type="checkbox" name="achepted_photo" value="true"  <%if(opoveshenie_email.getAchepted_photo().equals("true")){%>checked<%}%>>Отметки на фотографиях</p>
                <p><input type="checkbox" name="masage_wall" value="true"  <%if(opoveshenie_email.getMasage_wall().equals("true")){%>checked<%}%>>Сообщения на стене</p>
                <p><input type="checkbox" name="koment_wall" value="true" <%if(opoveshenie_email.getKoment_wall().equals("true")){%>checked<%}%>>Комментарии на стене</p>
                <p><input type="checkbox" name="koment_photo" value="true" <%if(opoveshenie_email.getKoment_photo().equals("true")){%>checked<%}%>>Комментарии к фотографиям</p>
                <p><input type="checkbox" name="coment_video" value="true" <%if(opoveshenie_email.getComent_video().equals("true")){%>checked<%}%>>Комментарии к видеозаписям</p>
                <p><input type="checkbox" name="ansewer_coment" value="true" <%if(opoveshenie_email.getAnsewer_coment().equals("true")){%>checked<%}%>>Ответы в комментариях</p>
                <p><input type="checkbox" name="Upominaniya" value="true" <%if(opoveshenie_email.getUpominaniya().equals("true")){%>checked<%}%>>Упоминания</p>
                <p><input type="checkbox" name="acept_group" value="true" <%if(opoveshenie_email.getAcept_group().equals("true")){%>checked<%}%>>Приглашения в сообщества</p>
                <p><input type="checkbox" name="meropriyatiya" value="true" <%if(opoveshenie_email.getMeropriyatiya().equals("true")){%>checked<%}%>>Грядущие мероприятия</p>
                <p><input type="checkbox" name="birthday" value="true" <%if(opoveshenie_email.getBirthday().equals("true")){%>checked<%}%>>Дни рождения</p>
                <p><input type="checkbox" name="surprise" value="true" <%if(opoveshenie_email.getSurprise().equals("true")){%>checked<%}%>>Подарки</p>
                <small>
                  <input type="submit" name="save" value="Сохранить">
                </small>
              </form>
            </div>
          <div class="well">
            <form action="/MomentAcepted?id=<%=u.getID()%>" method="post">
              Типы событий:
              <input type="text" name="opovechenie_of_all" size="20"><br>
              <p><input type="checkbox" name="saw_the_massege" value="true" <%if(moment_opoveshenye1.getSaw_the_massege().equals("true")){%>checked<%}%> >Показывать текст сообщений</p>
              <p><input type="checkbox" name="listen_audio_masage" value="true" <%if(moment_opoveshenye1.getListen_audio_masage().equals("true")){%>checked<%}%>>Включить звуковые оповещения</p>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
              </form>
          </div>
        </div>

        <div class="tab-pane " id="tab-4">
          <div class="well">

            </form>
          </div>
        </div>


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

<%!
  public ArrayList Birsday() {
    ArrayList arrayList=new ArrayList();
    for(int i=1;i<=31;i++){
      arrayList.add(i);
    }
    return arrayList;
  }
%>
