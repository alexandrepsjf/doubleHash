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
            const fileInput = document.getElementByName('url');
            fileInput.addEventListener('change', event => appendFiles(event.target.files));
        </script> 
        <script>
            const fileInput = document.getElementById('url1');
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

                            <h3 class="row col-md-10 col-md-offset-1" style="color: #ffffff;text-shadow: 1px 2px #ff5614"> T4 - Funções Hash e tratamento de colisões - DoubleHash							</h3>

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

        <!-- /Row -->

        <!-- /Container -->
        <!-- About -->
        <div  class="section md-padding">           
            <div class="container  " id="combos"  style="background-color: #c1ffd9;">                <!-- Row -->
                <div class="row">
                    <!-- Section header -->
                    <div class="section-header text-center">
                        <h2 class="title">Escolha o tamanho da tabela hash e o numero de chaves</h2>
                    </div>
                    <!-- /Section header -->
                    <!-- about -->
                    <div class="col-md-6">
                        <div class="about">
                            <h3>Escolha aqui para tabelas com mais de 50 posições </h3>
                            <div >
                                <form method="post" action="FrontController?action=CriarTabelaGrd"> 
                                    <div class= "form-group" > 
                                        <label for= "tamKey1" > Chaves </label> 
                                        <input type= "number" class= "form-control" id= "tamKey1" name="tamKey1" placeholder= "Numero de chaves" > 
                                    </div> 
                                    <div class= "form-group" > 
                                        <label for= "tamHash1" > Tabela Hash </label> 
                                        <input type= "number" min="1" class= "form-control" id= "tamHash1" name="tamHash1" placeholder= "Tamanho da tabela hash" > 
                                    </div>
                                    <div class="form-group">
                                            <label for="segHash1">Selecione o numero primo p/ segundo hash</label>
                                            <select class="form-control" id= "segHash1" name="segHash1" value="10" >
                                                <option value="3">2</option>
                                                <option value="3">3</option>
                                                <option value="5">5</option>
                                                <option value="7">7</option>                                           
                                                <option value="11">11</option>
                                                <option value="13">13</option> 
                                                <option value="7">17</option>                                           
                                                <option value="11">19</option>
                                                <option value="13">23</option>        
                                            </select>
                                            <button type="submit" class="btn btn-warning">Enviar</button>
                                        </div>       
                                </form> 
                            </div>					
                        </div>
                    </div>
                    <!-- /about -->
                    <!-- about -->
                    <div class="col-md-6">
                        <div class="about ">                            
                            <h3>Escolha aqui para tabelas com 50 posições ou menos </h3>
                            <div >
                                <form method="post" action="FrontController?action=CriarTabelaPeq"> 
                                    <div class= "form-group" > 
                                        <label for= "tamKey2" > Chaves </label> 
                                        <input type= "number" min="1" class= "form-control" id= "tamKey2" name="tamKey2" placeholder= "Numero de chaves" > 
                                    </div>          

                                    <div class="form-group">
                                        <label for="tamHash2">Selecione o tamanho da tabela hash</label>
                                        <select class="form-control" id= "tamHash2" name="tamHash2" value="10" >
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option> 
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option> 
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option> 
                                            <option value="31">31</option>
                                            <option value="32">32</option>
                                            <option value="33">33</option>
                                            <option value="34">34</option>
                                            <option value="35">35</option>
                                            <option value="36">36</option>
                                            <option value="37">37</option>
                                            <option value="38">38</option>
                                            <option value="39">39</option>
                                            <option value="40">40</option> 
                                            <option value="41">41</option>
                                            <option value="42">42</option>
                                            <option value="43">43</option>
                                            <option value="44">44</option>
                                            <option value="45">45</option>
                                            <option value="46">46</option>
                                            <option value="47">47</option>
                                            <option value="48">48</option>
                                            <option value="49">49</option>
                                            <option value="50">50</option>        
                                        </select>
                                        <div class="form-group">
                                            <label for="segHash2">Selecione o numero primo p/ segundo hash</label>
                                            <select class="form-control" id= "segHash2" name="segHash2" value="10" >
                                                <option value="3">2</option>
                                                <option value="3">3</option>
                                                <option value="5">5</option>
                                                <option value="7">7</option>                                           
                                                <option value="11">11</option>
                                                <option value="13">13</option> 
                                                <option value="7">17</option>                                           
                                                <option value="11">19</option>
                                                <option value="13">23</option>        
                                            </select>
                                            <button type="submit" class="btn btn-warning">Enviar</button>
                                        </div>                                         
                                </form> 

                            </div>
                        </div>
                        <!-- /about -->
                    </div>
                    <!-- /Row -->
                </div>
                <!-- /Container -->
            </div>
            <div class="container">

                <!-- Row -->
                <div class="row">
                    <!-- why choose us content -->
                    <div class="col-md-6">
                        <div class="section-header">
                            <h2 class="title">tabela hash</h2>
                        </div>
                        <h4>Definição</h4>

                        <h3>Em ciência da computação, 
                            uma tabela de dispersão (também conhecida por tabela de espalhamento ou tabela hash, 
                            do inglês hash) é uma estrutura de dados especial, 
                            que associa chaves de pesquisa a valores. 
                        </h3>
                        <div class="feature">
                            <i class="fa fa-check"></i>
                            <p>Seu objetivo é, a partir de uma chave simples, 
                                fazer uma busca rápida e obter o valor desejado.</p>
                        </div>

                    </div>
                    <!-- /why choose us content -->
                    <!-- About slider -->

                    <!-- /About slider -->

                </div>
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
                        <div class=" col-sm-offset-2 col-sm-4">
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
                        <div class="  col-sm-4">
                            <div class="team">
                                <div class="team-img">
                                    <img class="img-responsive" src="./img/icaro.jpg" alt="">
                                    <div class="overlay">
                                        <div class="team-social">
                                            <a href="#"><i class="fab fa-facebook-f"></i></a>
                                            <a href="#"><i class="fab fa-google-plus-g"></i></a>
                                            <a href="#"><i class="fab fa-twitter"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="team-content">
                                    <h3>Icaro Alvarenga - O Cara</h3>
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
