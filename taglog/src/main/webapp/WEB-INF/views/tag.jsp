<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ page session="false" %>
<html>
  <head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="shortcut icon" 
          href="<c:url value="/resources/favicon/favicon.ico" />" >
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/css/bootstrap.css" />" >
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/css/mdb.min.css" />" >
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/static/css/style.css" />" >
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.2.3.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/tether.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>

    <title>タグログ - ツイッターで話題のお店が探せるグルメサイト</title>
    <!--  
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
    -->
  </head>
  <body>
<nav class="navbar navbar-toggleable-md navbar-dark warning-color-dark">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav1" aria-controls="navbarNav1" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="../">
            <strong>タグログ</strong>
        </a>
        <div class="collapse navbar-collapse" id="navbarNav1">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="../">Home <!--<span class="sr-only">../(current)</span>--></a>
                </li>
            </ul>
         </div>
     </div>
 </nav>    
  <!--Main layout-->
  <main>
  	<div class="container-fluid">
    　　　　<!--Section: Blog v.4-->
       <section class="section section-blog-fw">
       　　　　　<!--First row-->
         <div class="row">
         　　　　　　<div class="col-md-12 wow fadeIn">
        
         	　<h4><a href="../tag/${tagName}">#${tagName}</a>のお店</h4>
             <div class="jumbotron wow fadeIn" data-wow-delay="0.2s">
                 <c:forEach items="${taglogList}" var="taglog">
  					${taglog.tweet}
  					<div class="table-responsive">
					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th>店名</th>
					      <th>最寄り駅</th>
					      <th>ジャンル</th>
					      <th>食べログ</th>
					    </tr>
					  </thead>
					  <tbody>
	  					<c:forEach items="${taglog.shopList}" var="shop">
	  					　　　<tr>
	  						  <td>${shop.shopName} </td>
	  						  <td><a href="../location/${shop.location}">${shop.location}</a></td>
	  						  <td><a href="../genre/${shop.genre}">${shop.genre}</a> </td>
	  						  <!--  <td><a href="${shop.tabelogUrl}" target="_blank">${shop.tabelogUrl}</a> </td>-->
	  						  <td><a href="${shop.tabelogUrl}" target="_blank"><img src="<c:url value="/resources/img/tabelog.jpg" />" alt="${shop.tabelogUrl}" width="35" height="35"></a></td>
	  						</tr>
	  					</c:forEach>
					  </tbody>
					</table>
					</div>
  				</c:forEach>
  				 
             </div>
           </div>
         </div>
       </section>
     </div>
   </main>         
                   
  </body>
</html>