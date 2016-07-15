<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao" %>
<%@ page import="Galaxy.UserAccount.User" %>
<%@ page import="Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC" %>
<%@ page import="Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <link href="/socc2s/Пуус/css/bootstrap.css" rel="stylesheet">
    <link href="/socc2s/Пуус/css/bootstrap.min.css" rel="stylesheet">
    <link href="/socc2s/Пуус/css/styles.css" rel="stylesheet"  type="text/css">
    <link rel="stylesheet" type="text/css" href="/socc2s/Пуус/css/index.css">
      <script src="/socc2s/Пуус/js/bootstrap.js"></script>
      <script src="/socc2s/Пуус/js/bootstrap.min.js"></script>
      <script src="/socc2s/Пуус/js/default.js"></script>
      <script src="/socc2s/Пуус/js/js1/scripts.js"></script>

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
  </head>
  <body>
  <div class="container" >
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
              <a href="index.html">
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
              <a href="tags.html">
                <span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
                <span class="hidden-sm hidden-xs">Мои Фотографии</span>
              </a>
            </li>
            
<li class="link">
              <a href="tags.html">
                <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
                <span class="hidden-sm hidden-xs">Мои Видеозаписи</span>
              </a>
            </li>

            <li class="link ">
              <a href="inde.html">
                <span class="glyphicon glyphicon-music" aria-hidden="true"></span>
                <span class="hidden-sm hidden-xs">Мои Моиаудиозаписи</span>
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
                  <a href="approved.html">Диалоги
                    <span class="label label-warning pull-right hidden-xs hidden-sm">10</span>
                  </a>
                </li>
              </ul>
            </li>
              <li class="link ">
              <a href="index.html">
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
            <header id="nav-header" class="clearfix">
              <div class="col-md-5">
              <ul class="pull-left">
                 <li id="welcome" class="hidden-xs"><h3>Карпов Иван</h3></li>
                </ul>
              </div>

           
            </header>
          
          
      <div class="col-md-10 display-table-cell">
       
       <div class="col-md-2 col-sm-1 hidden-xs display-table-cell1 valign-top" id="side-menu" >
       <img width="200" height="200" src="https://pp.vk.me/c628622/v628622106/22172/nlffExx9j8M.jpg" alt="Ваня  Карпов">
            <li class="link" width="20">
              <a href="index.html">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                <span class="hidden-sm hidden-xs">Редактировать страницу</span>
              </a>
            </li>

            <div class="panel-body">
                  <hr>
                  
                  <h3>Друзья</h3>
                  
                  <h6><a href="#"><img data-src="holder.js/200x200" class="img-thumbnail" alt="200x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDIwMCAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzIwMHgyMDAKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNTI4NDE3YWVlMCB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE1Mjg0MTdhZWUwIj48cmVjdCB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9Ijc1LjUiIHk9IjEwNC41Ij4yMDB4MjAwPC90ZXh0PjwvZz48L2c+PC9zdmc+" data-holder-rendered="true" style="width: 80px; height: 80px;"><a> John Chapman</a></a></h6>
                   
                
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
                    <h6>День рождения: 26 октября 1994 г.</h6>
                    <h6>Родной город: Одесса</h6>
                    <h6>Место учебы: ОГАСА</h6>
                    <h6>Языки:Русский</h6>
                    <h6>Братья,сестры: Богдан</h6>
              
                    <br><br>
                    <button class="btn btn-default">More</button>
                  </div> 
                  <div class="col col-sm-4">
                    <h6><a href="#"><i class="glyphicon glyphicon-user"></i>Фото со мной</a>
                    <h6><a href="#"><i class="glyphicon glyphicon-user"></i>Видеозаписи со мой</a>
                    <h6><a href="#"><i class="glyphicon glyphicon-user"></i>Мои подписчики</a>
                  </div>
                </div>
                
                  <hr>
                  
                  <h4>Контактная информация</h4>
                  <h6>Город: Одесса</h6>
                  <h6>Дом: Богдан</h6>
                  
                  <hr>
                  
                  <h4>Контактная информация</h4>
                  <h6>Вуз:ОГАСА (бывш. ОИСИ) '18</h6>
                    <h6> Факультет:Строительно-технологический институт</h6>
                    <h6> Форма обучения:Дневное отделение</h6>
                    <h6> Статус:Студент (специалист)</h6>
                    <h6> Школа:Школа №35 '12</h6>
                    <h6> Одесса, 2001–2012 (б)</h6>
                  
                  <hr>
                  
                  <h4>Жизненная позиция</h4>
                   <h6>Полит. предпочтения:Умеренные </h6>
                    <h6>Мировоззрение:♂+♀=♥ </h6>
            
                  
                  <hr>
                  <h4>Личная информация</h4>
                   <h6>Любимая музыка:Nickelback Rise Against</h6>
                  <h6>Группы:e6ijy, Stud info Zелёный kирпич ОГАСА, Клубничка Best Erotic Club Порно Эротика, Спортивный Клуб ЧЕМПИОН, В ПизДу UGG, В Кино Лучшие кино фильмы, Java, Дневники вампира Древние, Любители хентая, Хочу Секса 18, Jacky's, Красота здоровье тренинг фитнес диеты пресс, Одесса Доска Объявлений Барахолка, Вписки Одесса, Мой бодибилдинг твой путь к совершенству</h6>
                   
                  
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
                 <h4>Мои записи  <a href="http://bootply.com/69913">к записям</a></h4>
                 <textarea id="post_field" style="width: 550px;height:120px;"></textarea>
                 <button type="button" class="btn btn-sm btn-default">Отправить</button>
                <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
                 </div>
            
              
                   
                  
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

  </body>
</html>