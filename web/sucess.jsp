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

                <!--  Main navigation  -->
               
                <!-- /Main navigation -->
            </div>
        </nav>
        <!-- /Nav -->
        <!-- home wrapper -->
        <div class="home-wrapper">
            <div class="container">
                <div class=" white-text">
                    <!-- home content -->
                    <div class="home-content" >                        
                        <div class="center ">
                            <h1 class="white-text">Lista de conjuntos e elementos</h1>
                        </div>                        
                        <div>
                            <table class=" table text-primary">            
                                <thead>                  
                                    <tr> 
                                        <th scope="col" colspan="2"> Lista de Elementos </th>
                                        <th scope="col" colspan="2"> Lista de Conjuntos </th>
                                    </tr>
                                </thead>
                                <tbody>
                                <td colspan="2"><select name="comboElementos"> 
                                        <c:forEach var="elemento" items="${elementos}">  
                                            <option value=""> ${elemento.name} = ${elemento.value} </option>  
                                        </c:forEach>  
                                    </select>
                                </td>
                                <td>
                                    <select colspan="2" name="comboConjuntos"> 
                                        <c:forEach var="conjunto" items="${conjuntos}">  
                                            <option value="">${conjunto.getGrupo()}</option>  
                                        </c:forEach>  
                                    </select>
                                </td>
                                </tbody> 
                            </table>
                        </div>
                    </div>
                    <div class="container-fluid"> 
                        <h3 class="white-text center" >lista de Operações</h3>
                        <form method="post" action="FrontController?action=PrepararUniao&conjuntos=${conjuntos}&url=${url}"><button class="btn btn-warning btn-block"><h4>União</h4> </button></form>
                        <form method="post" action="FrontController?action=PrepararInter&conjuntos=${conjuntos}&url=${url}"><button class="btn btn-warning btn-block"><h4>Interseção</h4> </button></form>
                        <form method="post" action="FrontController?action=PrepararPertinencia&conjuntos=${conjuntos}&elementos=${elementos}&url=${url}" ><button class="btn btn-warning  btn-block"><h4>Pertence</h4> </button></form>
                        <form method="post" action="FrontController?action=PrepararContidoIgual&conjuntos=${conjuntos}&url=${url}"><button class="btn btn-warning btn-block"><h4>Contido ou Igual</h4> </button></form>
                        <form method="post" action="FrontController?action=PrepararPropContido&conjuntos=${conjuntos}&url=${url}"><button class="btn btn-warning btn-block"><h4>Contido Propriamente</h4></button></form>
                        <form method="post" action="FrontController?action=PrepararProduto&conjuntos=${conjuntos}&url=${url}"><button class="btn btn-warning btn-block"><h4>Produto Cartesiano</h4> </button></form>
                        <form method="post" action="FrontController?action=PrepararPartes&conjuntos=${conjuntos}&url=${url}"><button class="btn btn-warning btn-block"><h4>Conjunto das partes (P(X))</h4> </button></form>

                    </div>
                   
                    <!-- /home content -->

                </div>
                <!-- /home wrapper -->
            </div>
        </div>
    </header>
</body>
</html>
