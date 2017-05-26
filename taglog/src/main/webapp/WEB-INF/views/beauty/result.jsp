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

    <title>タグログ ビューティ - ツイッターで話題の美容情報が探せるサイト</title>
	<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-38971369-13', 'auto');
  ga('send', 'pageview');

　　</script>
  </head>
  <body>
<nav class="navbar navbar-toggleable-md navbar-dark default-color">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav1" aria-controls="navbarNav1" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="../../beauty">
            <strong>タグログ ビューティ</strong>
        </a>
        <div class="collapse navbar-collapse" id="navbarNav1">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="../">タグログ <!--<span class="sr-only">../(current)</span>--></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="../../beauty">タグログ ビューティ<!--<span class="sr-only">../(current)</span>--></a>
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
        
         	　<h4>「${keyword}」が含まれるツイート</h4>
             <div class="jumbotron wow fadeIn" data-wow-delay="0.2s">
                 <c:forEach items="${beautyTweetList}" var="beautyTweet">
  					${beautyTweet.tweet}
  				</c:forEach>
  				 
             </div>
           </div>
         </div>
       </section>
     </div>
   </main>         
                   
  </body>
</html>