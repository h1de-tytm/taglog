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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    申し訳ありません!</h1>
                <h2>403 Forbidden</h2>
                <div class="error-details">
                    	URLに間違いがあるようです...。</br>
                </div>
                <div class="error-actions">
                    <a href="http://www.taglog.info/" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        	タグログを開く </a>
                    <a href="https://twitter.com/cook_hideyoshi" class="btn btn-default btn-lg">
                    <span class="glyphicon glyphicon-envelope"></span>ツイッターで連絡する</a>
                </div>
            </div>
        </div>
    </div>
</div>                 
  </body>
</html>