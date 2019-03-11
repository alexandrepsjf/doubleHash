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

    <body class="white-text">
        <script>
            const fileInput = document.getElementById('file-input');
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
        <div class="">
            <div class="container">
                <div class=" white-text">
                    <!-- home content -->
                    <div class="center white-text shadowBlack">
                        <h1 class="text-primary ">Resultado</h1>
                    </div>                        

                    <div class="container-fluid white-text">     
                        <div class="animated bounceInDown">                                 
                            <h2 class="white-text break_word" style="
                                overflow-wrap: break-word;
                                word-wrap: break-word;

                                -ms-word-break: break-all;
                                word-break: break-all;
                                word-break: break-word;
                                -ms-hyphens: auto;
                                -moz-hyphens: auto;
                                -webkit-hyphens: auto;
                                hyphens: auto;" >${resultado}</h2> 
                        </div>
                        <div class="row">
                            <div class=" center col-lg-6"> 
                                <form method="post" class="success" action="FrontController?action=CriarArquivo&url=${url}"><button class="btn btn-success"> Voltar</button></form>
                            </div>
                            <div class=" center col-lg-6"> 
                                <form method="post" class="success" action="FrontController?action=CriarReverterProduto&url=${url}&resultado=${resultado}">
                                    <button class="btn btn-danger" <c:if test="${Reverter == false}"> disabled </c:if> > Reverter</button>
                                </form>
                                    <div >
                                        <h3 class="text-warning shadowBlack"<c:if test="${Reverter == false}"> hidden </c:if>>Operação Reversivel. Deseja Reverter?</h3>
                                    <div <c:if test="${NA == true}"> hidden </c:if>><h2 class="text-warning shadowBlack"<c:if test="${Reverter == true}"> hidden </c:if>>Operação Irreversível. </h2></div>
                                    <h2 class="text-warning shadowBlack"<c:if test="${NA != true}"> hidden </c:if>>Reverter Não se Aplica. </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /home content -->

                </div>
                <!-- /home wrapper -->
            </div>
        </div>
    </header>
</body>
</html>
