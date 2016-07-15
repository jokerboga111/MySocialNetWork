<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDaoJDBC" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.Dao_Contact_Info" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo" %>
<%@ page
        import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.JDBC_User_Hith_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.JDBC_User_Life_Position" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.User_Hith_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.User_Life_Position" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.User_Hobbys" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.JDBC_USER_CAREER" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.User_Career" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.JDBC_User_service" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.User_service" %>

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
    Dao_Informaion_User dao_informaion_user=(Dao_Informaion_User) Spring.springContext().getBean("InformationUser");
    JDBC_Contact_Info dao_contact_info=(JDBC_Contact_Info)Spring.springContext().getBean("ContactUser1");
    JDBC_User_Hith_Education UHE=(JDBC_User_Hith_Education)Spring.springContext().getBean("HithEducatUser");
    JDBC_User_Life_Position lP=(JDBC_User_Life_Position)Spring.springContext().getBean("LifePosition");
    JDBC_User_Education usE=(JDBC_User_Education)Spring.springContext().getBean("EducationUser");
    JDBC_User_Hobbys juh=(JDBC_User_Hobbys)Spring.springContext().getBean("HobbyUser");
    JDBC_USER_CAREER juc=(JDBC_USER_CAREER)Spring.springContext().getBean("CarreaUser");
    JDBC_User_service jus=(JDBC_User_service)Spring.springContext().getBean("serrviceUser");
    UserDao rec=new UserDaoJdbc();
    PhotoDao pdao=new PhotoDaoJDBC();
    User u= (User) session.getAttribute("user");
    String img= (String) session.getAttribute("img");
    Photo photo= (Photo) pdao.selectAvatarByIdUser(u.getID());
    SoundDao ser=new SoundDaoJDBC();
    Iformation_User iformation_user =dao_informaion_user.SelectUserInformation(u.getID());
    ContactInfo contactInfo=dao_contact_info.SelectContactInformation(u.getID());
    User_Hith_Education hithEduc=UHE.SelectUser_Hith_Education(u.getID());
    User_Life_Position lifeP=lP.SelectUser_Life_Position(u.getID());
    User_Education ue=usE.SelectUser_Education(u.getID());
    User_Hobbys user_hobbys=juh.SelectUserHobbys(u.getID());
    User_Career user_carrer=juc.SelectUser_Career(u.getID());
    User_service us=jus.SelectUser_Life_Position(u.getID());

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

      <ul class="nav nav-tabs">
        <li class="active"><a href="#tab-1" data-toggle="tab">Основное</a></li>
        <li><a href="#tab-2" data-toggle="tab">Конткты</a></li>
        <li><a href="#tab-3" data-toggle="tab">Интересы</a></li>
        <li><a href="#tab-5" data-toggle="tab">Карьера</a></li>
        <li><a href="#tab-6" data-toggle="tab">Служба</a></li>
        <li><a href="#tab-7" data-toggle="tab">Жизненая позиция</a></li>
        <li><a href="#tab-8" data-toggle="tab">Образование</a></li>
        <li><a href="#tab-9" data-toggle="tab">Высшее образование</a></li>
      </ul>

      <div class="tab-content">
        <div class="tab-pane active" id="tab-1">
          <div class="well">
      <form action="/RedactInformation?id=<%=u.getID()%>" method="post">
        Имя: <input type="text" name="name" value="<%=iformation_user.getName()%>" size="10"><br>
        Фамилия: <input type="text" value="<%=iformation_user.getSerName()%>" name="serName" size="10"><br>
        Пол: <input type="text" value="<%=iformation_user.getPol()%>" name="pol" size="10"><br>
        Семейное положение : <input type="text" value="<%=iformation_user.getFamaliOrder()%>"name="famalyOrder" size="10"><br>
        Город: <input type="text" value="<%=iformation_user.getTown()%>" name="Town"><br>
        Язык:<input type="text"value="<%=iformation_user.getLanguege()%>" name="languege"><br>
        <td>
          <select name = "privatBirsday" >
            <option сlass="active"  value = "Показывать дату рождения ">`</option>
            <option value = "Показывать дату и месяц">Показывать дату и месяц</option>
            <option value = "Не показывать дату рождения">Не показывать дату рождения</option>
          </select>
        </td>
        <br>
        День рождения:
        <td>
          <select name = "day">
            <%for(Object i:(ArrayList)Birsday()){%>

            <option value = "<%=i%>"><%=i%></option>
           <%}%>
          </select>
        </td>
        <td>
          <select name = "month">
            <option value = "Январь">Январь</option>
            <option value = "Февраль">Февраль</option>
            <option value = "Март">Март</option>
            <option value = "Апрель">Апрель</option>
          </select>
        </td>
        <td>
          <select name = "year">
            <option <%if(iformation_user.getYear()==1994){%>selected <%}%> value = "1994">1994</option>
            <option <%if(iformation_user.getYear()==1995){%>selected <%}%> value = "1995">1995</option>
            <option <%if(iformation_user.getYear()==1996){%>selected <%}%> value = "1996">1996</option>
            <option <%if(iformation_user.getYear()==1997){%>selected <%}%> value = "1997">1997</option>
          </select>
        </td>
        <p>
        <table>
          <tr>
            <th><small>
              <input type="submit" name="save" value="Сохранить">
            </small>
        </table>
      </form>
          </div>
        </div>
        <div class="tab-pane " id="tab-2">
          <div class="well">
            <form action="/RedactContact?id=<%=u.getID()%>" method="post">
            Страна
            <input type="text" value="<%=contactInfo.getCountry()%>" name="country1" size="10"><br>
            Город
            <input type="text" value="<%=contactInfo.getTown()%>" name="town1" size="10"><br>
            дом: <input type="text" value="<%=contactInfo.getHouse()%>" name="house" size="10"><br>
            Мобильный телефон: <input type="text"  value="<%=contactInfo.getMyPhone()%>" name="mPhone1" size="10"><br>
            Skype: <input type="text" name="Skype1"  value="<%=contactInfo.getSkype()%>" size="10"><br>
            Личный сайт: <input type="text"  value="<%=contactInfo.getYourSite()%>" name="mySite" size="10"><br>
              <small>
                <input type="submit" name="save1" value="Сохранить">
              </small>
            </form>
          </div>
        </div>
            <div class="tab-pane " id="tab-3">
              <div class="well">
                <form action="/RedactHobby?id=<%=u.getID()%>" method="post">
                Деятельность:<textarea name="deyatelnosty"  id="post_field" style="width: 550px;height:120px;"><%=user_hobbys.getHobbys()%></textarea><br>
                Интересы:<textarea name="interes" id="post_field1" style="width: 550px;height:120px;"><%=user_hobbys.getInterests()%></textarea><br>
                Любимая музыка:<textarea name="favoriteMusic" id="post_field2" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteMusic()%></textarea><br>
                Любимые фильмы:<textarea name="favoritefilm" id="post_field3" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteFilm()%></textarea><br>
                Любимые телетокшоу:<textarea name="favoriteTvShow" id="post_field4" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteTvShow()%></textarea><br>
                Любимые книги:<textarea name="favoriteBook" id="post_field5" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteBooks()%></textarea><br>
                Любимые цитаты:<textarea name="favoriteNovels" id="post_field6" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteNovels()%></textarea><br>
                Любимые игры:<textarea name="favoriteGames" id="post_field7" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteGames()%></textarea><br>
                О себе:<textarea name="aboutMe" id="post_field8" style="width: 550px;height:120px;"><%=user_hobbys.getFavoriteKeyInfo()%></textarea><br>
                  <small>
                    <input type="submit" name="save" value="Сохранить">
                  </small>
                </form>
              </div>
            </div>

          <div class="tab-pane " id="tab-8">
            <div class="well">
              <form action="/RedactEucation?id=<%=u.getID()%>" method="post">
              Страна
              <input type="text" value="<%=ue.getCountry()%>" name="country" size="10"><br>
              Город
              <input type="text"  value="<%=ue.getTown()%>" name="town" size="10"><br>
              Школа
              <input type="text"  value="<%=ue.getSchool()%>" name="school" size="10"><br>
              Год начала обучения
              <input type="text"  value="<%=ue.getY_S_Study()%>" name="Y_S_Study" size="10"><br>
              Год окончания обучения:
              <input type="text"  value="<%=ue.getY_E_Study()%>" name="Y_E_Study" size="10"><br>
              Дата выпуска:
              <input type="text"  value="<%=ue.getData_End()%>" name="dataend" size="10"><br>
              Класс:
              <input type="text"  value="<%=ue.getClass1()%>" name="class1" size="10"><br>
              Специализация:<input type="text"  value="<%=ue.getSpechializeshion()%>" name="spechia" size="10"><br>
                <small>
                  <input type="submit" name="save" value="Сохранить">
                </small>
              </form>
            </div>
          </div>
          <div class="tab-pane " id="tab-9">
            <div class="well">
              <form action="/RedactHithEducation?id=<%=u.getID()%>" method="post">
              Страна
              <input type="text" value="<%=hithEduc.getCountry()%>" name="country" size="10"><br>
              Город
              <input type="text" value="<%=hithEduc.getTown()%>" name="town" size="10"><br>
              Вуз
              <input type="text" value="<%=hithEduc.getUniversity()%>" name="univers" size="10"><br>
              Факультет
              <input type="text" value="<%=hithEduc.getDepartment()%>" name="department" size="10"><br>
              Кафедра:
              <input type="text" value="<%=hithEduc.getChair()%>" name="chair" size="10"><br>
              Форма обучения:
              <input type="text" value="<%=hithEduc.getMode_of_study()%>" name="Mode_of_study" size="10"><br>
              Статус:
              <input type="text" value="<%=hithEduc.getStatus()%>" name="status" size="10"><br>
              Дата выпуска:<input type="text" value="<%=hithEduc.getRelease_date()%>" name="Release_date" size="10"><br>
                <small>
                  <input type="submit" name="save" value="Сохранить">
                </small>
              </form>
            </div>
          </div>


        <div class="tab-pane " id="tab-5">
          <div class="well">
            <form action="/RedactHithCarrea?id=<%=u.getID()%>" method="post">
            Место работы <input type="text" value="<%=user_carrer.getPlace_To_work()%>" name="Place_To_work1" size="10"><br>
            Страна
            <input type="text" value="<%=user_carrer.getCountry()%>" name="country" size="10"><br>
            Город
            <input type="text" value="<%=user_carrer.getTown()%>" name="town" size="10"><br>
            Год начала обучения
            <input type="text" value="<%=user_carrer.getYear_Start_Study()%>" name="Year_Start_Study" size="10"><br>
            Год окончания обучения:
            <input type="text" value="<%=user_carrer.getYear_End_Study()%>" name="Year_End_Study" size="10"><br>
            Должность:<input type="text" value="<%=user_carrer.getPosition()%>" name="position" size="10"><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
        </div>
        <div class="tab-pane " id="tab-6">
          <div class="well">
            <form action="/RedactService?id=<%=u.getID()%>" method="post">
            Страна:
            <input type="text" value="<%=us.getCountry()%>" name="country" size="10"><br>
            Военная часть:<input type="text" value="<%=us.getService_war()%>" name="Service_war" size="10"><br>
              <small>
                <input type="submit" name="save" value="Сохранить">
              </small>
            </form>
          </div>
        </div>
        <div class="tab-pane " id="tab-7">
          <div class="well">
            <form action="/RedactLifePosition?id=<%=u.getID()%>" method="post">
            Полит.позиция:
            <input type="text" value="<%=lifeP.getPolitical_answ()%>" name="Political_answ" size="10"><br>
            Мировозрение:<input type="text" value="<%=lifeP.getWorldview()%>" name="Worldview" size="10"><br>
            Главное в жизни:
            <input type="text" value="<%=lifeP.getMain_in_life()%>" name="maininlife" size="10"><br>
            Главное в людях:
            <input type="text" value="<%=lifeP.getMain_in_people()%>" name="maininpeople" size="10"><br>
            Отношение к курению:
            <input type="text" value="<%=lifeP.getAttitude_about_smoking()%>" name="about_smoking" size="10"><br>
            Отношение к алкоголю:
            <input type="text" value="<%=lifeP.getAttitude_about_alcohole()%>" name="about_alcohole" size="10"><br>
            Источник вдохновения
            <input type="text" value="<%=lifeP.getPierian_spring()%>" name="Pierian_spring" size="10"><br>
              <small>
            <input type="submit" name="save" value="Сохранить">
          </small>
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
