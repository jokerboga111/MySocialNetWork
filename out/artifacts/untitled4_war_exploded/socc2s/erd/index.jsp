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
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.JDBC_USER_CAREER" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.Dao_User_Career" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.User_Career" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.JDBC_User_service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.User_service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.Wall" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.JDBC_Wall" %>
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
    JDBC_USER_CAREER jdbc_user_career=(JDBC_USER_CAREER)Spring.springContext().getBean("CarreaUser");
    JDBC_User_service jdbc_user_service=(JDBC_User_service)Spring.springContext().getBean("serrviceUser");
    Iformation_User Informetion_user=Iu.SelectUserInformation(u.getID());
    User_Hith_Education hithEduc=UHE.SelectUser_Hith_Education(u.getID());
    User_Life_Position lifeP=lP.SelectUser_Life_Position(u.getID());
    User_Education ue=usE.SelectUser_Education(u.getID());
    ContactInfo contactInfo1=contactInfo.SelectContactInformation(u.getID());
    DaoFriend friendDao=
            (DaoFriend) Spring.springContext().getBean("friendDao");
    User_Career user_career=jdbc_user_career.SelectUser_Career(u.getID());
    User_Hobbys user_hobbys=juh.SelectUserHobbys(u.getID());
    User_service user_service=jdbc_user_service.SelectUser_Life_Position(u.getID());
    Dao_Ather_Service dao_options_page=new JDBC_Ather_Service();
    Ather_Service options_page=dao_options_page.SelectUserAther_Service(u.getID());

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

        <%if(options_page.getMy_friends().equals("true")){%>
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
        <%}%>
        <%if(options_page.getMy_photo().equals("true")){%>
        <li class="link">
          <a href="/socc2s/erd/Photo_Galery/Photo_Galary.jsp">
            <span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Мои Фотографии</span>
          </a>
        </li>
<%}%>
        <%if(options_page.getMy_video().equals("true")){%>
        <li class="link">
          <a href="/socc2s/erd/Video_Gallery/video.jsp">
            <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Мои Видеозаписи</span>
          </a>
        </li>
        <%}%>
        <%if(options_page.getMy_mysic().equals("true")){%>
        <li class="link ">
          <a href="/socc2s/erd/music.jsp?idUser=<%=u.getID()%>">
            <span class="glyphicon glyphicon-music" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Мои аудиозаписи</span>
          </a>
        </li>
        <%}%>
        <%if(options_page.getMy_massege().equals("true")){%>
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
        <%}%>

        <%if(options_page.getMy_group().equals("true")){%>
        <li class="link ">
          <a href="/socc2s/erd/group.jsp">
            <span class="glyphicon glyphicon-education" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Мои Группы</span>
          </a>
        </li>
       <%}%>
        <%if(options_page.getMy_news().equals("true")){%>
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
<%}%>


        <%if(options_page.getMy_answers().equals("true")){%>
        <li class="link">
          <a href="tags.html">
            <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Ответы</span>
          </a>
        </li>
       <%}%>
        <%if(options_page.getMy_bookmarks().equals("true")){%>
        <li class="link">
          <a href="tags.html">
            <span class="glyphicon glyphicon-tags" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Закладки</span>
          </a>
        </li>
        <%}%>

        <li class="link settings-btn">
          <a href="/socc2s/erd/Options.jsp">
            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Опции</span>
          </a>
        </li>
        <%if(options_page.getMy_aplication().equals("true")){%>
        <li class="link">
          <a href="tags.html">
            <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Приложения</span>
          </a>
        </li>
<%}%>
        <%if(options_page.getMy_documents().equals("true")){%>
        <li class="link">
          <a href="tags.html">
            <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
            <span class="hidden-sm hidden-xs">Документы</span>
          </a>
        </li>
        <%}%>
      </ul>
    </div>
  </div>

  <div class="col-md-10 col-sm-11 display-table-cell valign-top">
    <div class="row1">
      <header id="nav-header" class="clearfix">
        <div class="col-md-5">
          <ul class="pull-left">
            <li id="welcome" class="hidden-xs"><h3><%=Informetion_user.getName()%>  <%=Informetion_user.getSerName()%>   </h3></li>
          </ul>
        </div>


      </header>


      <div class="col-md-10 display-table-cell">

        <div class="col-md-2 col-sm-1 hidden-xs display-table-cell1 valign-top" id="side-menu"  >
          <img width="200" height="200" src="https://pp.vk.me/c628622/v628622106/22172/nlffExx9j8M.jpg" alt="Ваня  Карпов">
          <li class="link" width="20">
            <a href="Redactor.jsp#tab-1">
              <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
              <span class="hidden-sm hidden-xs">Редактировать страницу</span>
            </a>
          </li>

          <div class="panel-body">
            <hr>

            <h3>Друзья</h3>
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

            <div class="media">
              <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/80/F0F0F0">
              </a>
              <div class="media-body">
                <h5 class="media-heading"><a href="/tagged/modal" target="ext" class="pull-right"><i class="glyphicon glyphicon-share"></i></a> <a href="#"><strong>Modal</strong></a></h5>
                <small>Examples using the Bootstrap modal.</small><br>
                <span class="badge">87</span>
              </div>
            </div>
            <div class="media">
              <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/80/F0F0F0">
              </a>
              <div class="media-body">
                <h5 class="media-heading"><a href="/tagged/slider" target="ext" class="pull-right"><i class="glyphicon glyphicon-share"></i></a> <a href="#"><strong>Carousel</strong></a></h5>
                <small>How to use the Bootstrap slider.</small><br>
                <span class="badge">322</span>
              </div>
            </div>
            <div class="media">
              <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/80/F0F0F0">
              </a>
              <div class="media-body">
                <h5 class="media-heading"><a href="/tagged/typography" target="ext" class="pull-right"><i class="glyphicon glyphicon-share"></i></a> <a href="#"><strong>Typography</strong></a></h5>
                <small>See the various textual elements and options.</small><br>
                <span class="badge">44</span>
              </div>
            </div>
            <div class="media">
              <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/80/F0F0F0">
              </a>
              <div class="media-body">
                <h5 class="media-heading"><a href="/tagged/media" target="ext" class="pull-right"><i class="glyphicon glyphicon-share"></i></a> <a href="#"><strong>@Media</strong></a></h5>
                <small>Use @media queries to get the layout you want.</small><br>
                <span class="badge">119</span>
              </div>
            </div>

          </div>

        </div>

      </div>
      <div class="col-md-10 col-sm-11 display-table-cell2 valign-top">

        <div class="panel-body" style="background-color:#fff;color:#000000;">
          <div class="row" >

            <div class="col-md-8">
              <h4>Информация пользователя:</h4>
              <%if(0 != Informetion_user.getBirthday()){%><h6>День рождения: <%=Informetion_user.getBirthday()%> <%=Informetion_user.getMonth()%>  <%=Informetion_user.getYear()%>  г.</h6><%}%>
              <%if(!Informetion_user.getPol().equals("")){%><h6>Пол: <%=Informetion_user.getPol()%> </h6><%}%>
              <%if(!Informetion_user.getFamaliOrder().equals("")){%> <h6>Семейное положение: <%=Informetion_user.getFamaliOrder()%> </h6><%}%>
              <%if(!Informetion_user.getTown().equals("")){%><h6>Родной город: <%=Informetion_user.getTown()%> </h6><%}%>
              <%if(!hithEduc.getUniversity().equals("")){%><h6>Место учебы: <%=hithEduc.getUniversity()%></h6><%}%>
              <%if(!Informetion_user.getLanguege().equals("")){%><h6>Языки: <%=Informetion_user.getLanguege()%></h6><%}%>

              <br><br>
            </div>
            <div class="col col-sm-4">
              <h6><a href="#"><i class="glyphicon glyphicon-user"></i>Фото со мной</a>
                <h6><a href="#"><i class="glyphicon glyphicon-user"></i>Видеозаписи со мой</a>
                  <h6><a href="#"><i class="glyphicon glyphicon-user"></i>Мои подписчики</a>
            </div>
          </div>

          <hr>
          <a href="#spiler-1" data-toggle="collapse" class="btn btn-default">Море</a>
          <div class="collapse" id="spiler-1">
            <h4>Контактная информация</h4>
            <%if(!contactInfo1.getCountry().equals("")){%><h6>Страна: <%=contactInfo1.getCountry()%> </h6><%}%>
            <%if(!contactInfo1.getTown().equals("")){%><h6>Город: <%=contactInfo1.getTown()%> </h6><%}%>
            <%if(!contactInfo1.getHouse().equals("")){%><h6>Дом: <%=contactInfo1.getHouse()%></h6><%}%>
            <%if(!contactInfo1.getSkype().equals("")){%><h6>Skype: <%=contactInfo1.getSkype()%></h6><%}%>
            <%if(!contactInfo1.getMyPhone().equals("")){%><h6>Телефон: <%=contactInfo1.getMyPhone()%></h6><%}%>
           <%if(!contactInfo1.getYourSite().equals("")){%><h6>Личный сайт:<%=contactInfo1.getYourSite()%></h6><%}%>
          <hr>

            <h4>Образование</h4>
            <%if(!ue.getCountry().equals("")){%><h6>Страна: <%=ue.getCountry()%></h6><%}%>
            <%if(!ue.getTown().equals("")){%><h6>Город: <%=ue.getTown()%> </h6><%}%>
            <%if(!ue.getSchool().equals("")){%><h6>Школа: <%=ue.getSchool()%></h6><%}%>
            <%if(!ue.getY_S_Study().equals("")){%><h6>Город начала обучения: <%=ue.getY_S_Study()%></h6><%}%>
            <%if(!ue.getY_E_Study().equals("")){%><h6>Город окончания обучения: <%=ue.getY_E_Study()%></h6><%}%>
            <%if(!ue.getData_End().equals("")){%><h6>Дата выпуска: <%=ue.getData_End()%></h6><%}%>
            <%if(!ue.getClass1().equals("")){%><h6>Класс: <%=ue.getClass1()%></h6><%}%>
            <%if(!ue.getSpechializeshion().equals("")){%><h6>Специализация: <%=ue.getSpechializeshion()%></h6><%}%>

            <h4>Высшее образование</h4>
            <%if(!hithEduc.getCountry().equals("")){%><h6>Страна: <%=hithEduc.getCountry()%></h6><%}%>
            <%if(!hithEduc.getTown().equals("")){%><h6>Город: <%=hithEduc.getTown()%> </h6><%}%>
            <%if(!hithEduc.getUniversity().equals("")){%><h6>Вуз: <%=hithEduc.getUniversity()%></h6><%}%>
            <%if(!hithEduc.getDepartment().equals("")){%><h6> Факультет: <%=hithEduc.getDepartment()%></h6><%}%>
            <%if(!hithEduc.getMode_of_study().equals("")){%><h6> Форма обучения: <%=hithEduc.getMode_of_study()%></h6><%}%>
            <%if(!hithEduc.getStatus().equals("")){%><h6> Статус: <%=hithEduc.getStatus()%></h6><%}%>
            <%if(!hithEduc.getRelease_date().equals("")){%><h6> Дата выпуска: <%=hithEduc.getRelease_date()%></h6><%}%>

          <hr>

          <h4>Жизненная позиция</h4>
            <%if(!lifeP.getPolitical_answ().equals("")){%><h6>Полит. предпочтения: <%=lifeP.getPolitical_answ()%> </h6><%}%>
            <%if(!lifeP.getWorldview().equals("")){%><h6>Мировоззрение: <%=lifeP.getWorldview()%> </h6><%}%>
            <%if(!lifeP.getMain_in_life().equals("")){%> <h6>Главное в жизни: <%=lifeP.getMain_in_life()%></h6><%}%>
            <%if(!lifeP.getMain_in_people().equals("")){%><h6>Главное в людях: <%=lifeP.getMain_in_people()%></h6><%}%>
            <%if(!lifeP.getAttitude_about_smoking().equals("")){%><h6>Отношение к курению: <%=lifeP.getAttitude_about_smoking()%></h6><%}%>
            <%if(!lifeP.getAttitude_about_alcohole().equals("")){%><h6>Отношение к алкоголю: <%=lifeP.getAttitude_about_alcohole()%></h6><%}%>
            <%if(!lifeP.getPierian_spring().equals("")){%><h6>Источник вдохновения: <%=lifeP.getPierian_spring()%></h6><%}%>



          <hr>
          <h4>Личная информация</h4>
            <%if(!user_hobbys.getHobbys().equals("")){%><h6>Деятельность:<%=user_hobbys.getHobbys()%></h6><%}%>
            <%if(!user_hobbys.getInterests().equals("")){%><h6>Интересы:<%=user_hobbys.getInterests()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteMusic().equals("")){%> <h6>Любимая музыка:<%=user_hobbys.getFavoriteMusic()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteFilm().equals("")){%><h6>Любимый фильм:<%=user_hobbys.getFavoriteFilm()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteTvShow().equals("")){%><h6>Любимый телешоу:<%=user_hobbys.getFavoriteTvShow()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteBooks().equals("")){%><h6>Любимые книги:<%=user_hobbys.getFavoriteBooks()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteNovels().equals("")){%><h6>Любимый цитаты:<%=user_hobbys.getFavoriteNovels()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteGames().equals("")){%><h6>Любимый игры:<%=user_hobbys.getFavoriteGames()%></h6><%}%>
            <%if(!user_hobbys.getFavoriteKeyInfo().equals("")){%><h6>О себе:<%=user_hobbys.getFavoriteKeyInfo()%></h6><%}%>

            <hr>
            <h4>Карьера</h4>
            <%if(!user_career.getPlace_To_work().equals("")){%><h6>Место работы:<%=user_career.getPlace_To_work()%></h6><%}%>
            <%if(!user_career.getCountry().equals("")){%><h6>Страна:<%=user_career.getCountry()%></h6><%}%>
            <%if(!user_career.getTown().equals("")){%><h6>Город:<%=user_career.getTown()%></h6><%}%>
            <%if(!user_career.getYear_Start_Study().equals("")){%><h6>Год начала обучения:<%=user_career.getYear_Start_Study()%></h6><%}%>
            <%if(!user_career.getYear_End_Study().equals("")){%><h6>Год окончания обучения:<%=user_career.getYear_End_Study()%></h6><%}%>
            <%if(!user_career.getPosition().equals("")){%> <h6>Должность:<%=user_career.getPosition()%></h6><%}%>

            <hr>
            <h4>Служба</h4>
            <%if(user_service.getCountry().equals("")){%><h6>Страна:<%=user_service.getCountry()%></h6><%}%>
            <%if(user_service.getService_war().equals("")){%><h6>Военная часть:<%=user_service.getService_war()%></h6><%}%>


</div
        >

          <hr>

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
            <form action="/StenaUser?id=<%=u.getID()%>" method="post">
            <h4>Мои записи  <a href="http://bootply.com/69913">к записям</a></h4>
            <textarea name="wall" id="post_field" style="width: 550px;height:120px;"></textarea>
            <button type="SUBMIT" class="btn btn-sm btn-default">Отправить</button>
              </form>
          </div>
          <hr>
<%List<Wall> listWall= new JDBC_Wall().selectListWall(u.getID());
  for(Wall w:listWall){%>
            <div class="well" id="well1">
              <div class="Img"><img src="https://pp.vk.me/c628622/v628622106/22172/nlffExx9j8M.jpg" height="60" width="60" style="float: left" class="img1"/></div>
            <div id="serName">
              <a  href="" style="margin-left: 10px"><strong><%=Informetion_user.getName()%>  <%=Informetion_user.getSerName()%></strong></a>
            </div>
              <h6 style="margin-left: 70px"><%=w.getOpisanie()%></h6>
              <img id="feder" height="300" style="margin-left: 10px " width="400" src="<%=w.getPicture()%>"/>
            <div  id="roz"><a href="" style="margin-left: 105px">12 минут назадь |</a><a href="">коментарии</a><a href="#">
              <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
              <snap class="label label-default" id="span">3</snap> </a>
              <a href="#">
                <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                <snap class="label label-default" id="span">3</snap> </a></div>

              </div>
<%}%>




          <hr>

          <hr>

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
