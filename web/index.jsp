<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>MatemáticaDiscreta</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CVarela+Round" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Owl Carousel -->
        <link type="text/css" rel="stylesheet" href="css/owl.carousel.css" />
        <link type="text/css" rel="stylesheet" href="css/owl.theme.default.css" />

        <!-- Magnific Popup -->
        <link type="text/css" rel="stylesheet" href="css/magnific-popup.css" />
        <link rel="stylesheet" href="css/animate.min.css">

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous"/>


        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <script>
            const fileInput = document.getElementById('url');

            fileInput.addEventListener('change', event => appendFiles(event.target.files));
        </script>
        <!-- Header -->
    <header id="home">
        <!-- Background Image -->
        <div class="bg-img" style="background-image: url('./img/venn.jpg');">
            <div class="overlay"></div>
        </div>
        <!-- /Background Image -->

        <!-- Nav -->
        <nav id="nav" class="navbar nav-transparent">
            <div class="container">

                <div class="navbar-header">
                    <!-- Logo -->
                    <div class="navbar-brand">
                        <a href="index.jsp">
                            <img class="logo" src="img/inter.png" alt="logo">
                            <img class="logo-alt" src="img/inter.png" alt="logo">
                        </a>
                    </div>
                    <!-- /Logo -->

                    <!-- Collapse nav button -->
                    <div class="nav-collapse">
                        <span></span>
                    </div>
                    <!-- /Collapse nav button -->
                </div>

            </div>
        </nav>
        <!-- /Nav -->
        <!-- home wrapper -->
        <div class="home-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <!-- home content -->
                    <div class="col-md-12 ">
                        <div class="home-content" >
                            <h1 class="white-text  col-md-10 col-md-offset-1 ">Matemàtica Discreta</h1>                             

                            <h3 class="row col-md-10 col-md-offset-1" style="color: #ffffff;text-shadow: 1px 2px #ff5614"> “Considerando que a maioria dos conceitos computacionais
                                pertencem ao domínio do discreto, a matemática discreta (ou
                                também chamada álgebra abstrata) é fortemente empregada.”							</h3>

                        </div>

                    </div>
                    <!-- /home content -->
                </div>
            </div>
            <!-- /home wrapper -->           
        </div>

    </header>
    <!-- /Header -->
    <!-- Why Choose Us -->
    <div id="features" class="section md-padding bg-grey ">
        <!-- Container -->
        <div class="container">

            <!-- Row -->
            <div class="row">
                <!-- why choose us content -->
                <div class="col-md-6">
                    <div class="section-header">
                        <h2 class="title">Conjunto</h2>
                    </div>
                    <h4>Definição</h4>

                    <h3>Coleção de zero ou mais objetos distintos, chamados Elementos do
                        conjunto os quais não possuem qualquer ordem associada</h3>
                    <div class="feature">
                        <i class="fa fa-check"></i>
                        <p>estrutura que agrupa objetos.</p>
                    </div>
                    <div class="feature">
                        <i class="fa fa-check"></i>
                        <p>constitui uma base para construir estruturas mais complexas.</p>
                    </div>
                    <h4>Informalmente</h4>

                    <div class="feature">
                        <i class="fa fa-check"></i>
                        <p>coleção, sem repetições e sem qualquer ordenação, de objetos
                            denominados elementos.</p>
                    </div>
                    <div class="feature">
                        <i class="fa fa-check"></i>
                        <p>elemento: pode designar um objeto concreto ou abstrato.</p>
                    </div>
                </div>
                <!-- /why choose us content -->
                <!-- About slider -->

                <!-- /About slider -->

            </div>
        </div>
        <!-- /Row -->
        <div class=" container md-padding">           
            <h2 class=" col-lg-offset-4"> <i class="fa fa-bullhorn"></i> Fique ligado</h2>
            <div class="col-md-6">                    
                <h2><span class="font-weight-bold" style="font-family: impact;"> Operações Não-Reversíveis</span> </h2>
                <h4><span class="" style="font-family: impact;"> <i class="fa fa-thumbs-down"></i> </span>   União ;</h4>
                <h4><span class="" style="font-family: impact;"> <i class="fa fa-thumbs-down"></i> </span>  Intersecção;</h4>
            </div>
            <div class="col-md-6">
                <h2><span class="font-weight-bold" style="font-family: impact;"> Operações Reversíveis </span> </h2>
                <h4><span class="" style="font-family: impact;"> <i class="fa fa-thumbs-up"></i> </span> Complemento;</h4>
                <h4><span class="" style="font-family: impact;"> <i class="fa fa-thumbs-up"></i> </span>  Conjunto das Partes;</h4>
                <h4><span class="" style="font-family: impact;"> <i class="fa fa-thumbs-up"></i> </span>  Produto Cartesiano;</h4>
                <h4><span class="" style="font-family: impact;"> <i class="fa fa-thumbs-up"></i> </span>  União Disjunta;</h4>
            </div>
        </div>
        <!-- /Container -->
        <!-- About -->
        <div  class="section md-padding">           
            <div class="container  " id="combos"  style="background-color: #c1ffd9;">                <!-- Row -->
                <div class="row">
                    <!-- Section header -->
                    <div class="section-header text-center">
                        <h2 class="title">Escolha seu arquivo texto e suas operações</h2>
                    </div>
                    <!-- /Section header -->
                    <!-- about -->
                    <div class="col-md-4">
                        <div class="about">
                            <div >
                                <form method="post" action="FrontController?action=CriarArquivo">
                                    <input type='file' accept='text/*' id='url' name='url' class="imputFile"  />
                                    <label for='url' >
                                        <div class='btn btn-primary'>Escolha seu arquivo TXT</div>
                                    </label >
                                    <button type="submit" class="btn btn-warning">Enviar</button>
                                </form>
                            </div>					
                        </div>
                    </div>
                    <!-- /about -->
                    <!-- about -->
                    <div class="col-md-4">
                        <div class="about ">
                            
                            <h3>Trabalho 2</h3>
                           					
                        </div>
                    </div>
                    <!-- /about -->
                    <!-- about -->
                    <div class="col-md-4">
                        <div class="about">
                            
                            <h3>Trabalho 3</h3>
                           
                        </div>
                    </div>
                    <!-- /about -->
                </div>
                <!-- /Row -->
            </div>
            <!-- /Container -->
        </div>
        <!-- Team -->
            <div id="team" class="section md-padding">
                <!-- Container -->
                <div class="container">
                    <!-- Row -->
                    <div class="row">
                        <!-- Section header -->
                        <div class="section-header text-center">
                            <h2 class="title">Participantes</h2>
                        </div>
                        <!-- /Section header -->
                        <!-- team -->
                        <div class=" col-sm-offset-4 col-sm-4">
                            <div class="team">
                                <div class="team-img">
                                    <img class="img-responsive" src="./img/alexandre.jpg" alt="">
                                    <div class="overlay">
                                        <div class="team-social">
                                            <a href="#"><i class="fab fa-facebook-f"></i></a>
                                            <a href="#"><i class="fab fa-google-plus-g"></i></a>
                                            <a href="#"><i class="fab fa-twitter"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="team-content">
                                    <h3>Alexandre de Paula - O Bão</h3>
                                    <span>Web Designer</span>
                                </div>
                            </div>
                        </div>
                        <!-- /team -->

                    </div>
                    <!-- /Row -->
                </div>
                <!-- /Container -->
            </div>
            <!-- /Team -->
        <!-- Footer -->
        <footer id="footer" class="sm-padding bg-dark">
            <!-- Container -->
            <div class="container">
                <!-- Row -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- footer logo -->
                        <div class="footer-logo">
                            <a href="index.jsp"><img src="img/2.png" alt="logo"></a>
                        </div>
                        <!-- /footer logo -->
                        <!-- footer follow -->
                        <ul class="footer-follow">
                            <li><a href="#"><i class="fab fa-android" style="font-size:40px;"></i></a></li>
                            <li><a href="#"><i class="fab fa-twitter" style="font-size:40px;"></i></a></li>
                            <li><a href="#"><i class="fab fa-google-plus-g" style="font-size:40px;"></i></a></li>
                            <li><a href="#"><i class="fab fa-instagram" style="font-size:40px;"></i></a></li>
                            <li><a href="#"><i class="fab fa-linkedin" style="font-size:40px;"></i></a></li>
                            <li><a href="#"><i class="fab fa-youtube" style="font-size:40px;"></i></a></li>
                        </ul>
                        <!-- /footer follow -->
                        <!-- footer copyright -->
                        <div class="footer-copyright">
                            <p>Copyright © 2019. All Rights Reserved. Designed by <a href="http://www.baoburgao.com.br" target="_blank">alexandrePS</a></p>
                        </div>
                        <!-- /footer copyright -->
                    </div>
                </div>
                <!-- /Row -->
            </div>
            <!-- /Container -->
        </footer>
        <!-- /Footer -->
        <!-- Back to top -->
        <div id="back-to-top"></div>
        <!-- /Back to top -->
        <!-- Preloader -->
        <div id="preloader">
            <div class="preloader">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </div>
        <!-- /Preloader -->
        <!-- jQuery Plugins -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="js/jquery.magnific-popup.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
    </body>

</html>
