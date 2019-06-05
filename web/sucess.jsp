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
    
        <div class="container">
            <div class=" white-text">
                <!-- home content -->
                <div class="home-content" >                        
                    <div class="center ">
                        <h3 class="text-danger">Digite a chave para inserção de 1 a ${tamKey2}</h3>
                         <form method="post" action="FrontController?action=CriarTabelaPeq"> 
                                    <div class= "form-group" > 
                                        <label for= "key" >  </label> 
                                        <input type= "number" class= "form-control" id= "key" name="key" placeholder= "Numero da chave" > 
                                    </div> 
                    </div>                        
                    <div style=" max-height:400px; overflow-x:auto;">
                        <table class=" table table-striped table-responsive text-primary" >            
                            <thead>                  
                                <tr> 
                                    <th scope="col" > Posição </th>
                                    <th scope="col" > Chave </th>
                                    <th scope="col" > Valor </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="no" items="${tabela}">
                                    <tr>
                                        <td >
                                            ${no.posicao}                                     
                                        </td>
                                        <td >
                                            ${no.key}                                     
                                        </td>
                                        <td >
                                            ${no.valor}                                     
                                        </td>                             

                                    </tr>
                                </c:forEach>
                            </tbody> 
                        </table>
                    </div>
                </div>


                <!-- /home content -->

            </div>
            <!-- /home wrapper -->
    </div>

</body>
</html>
