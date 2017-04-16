<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    
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
<div class="container">

    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">タグからお店を選ぶ</h2>
    </div>
	<div class="list-group">
	    <a href="../tag/kiyolog" class="list-group-item disabled">きよログ</a>
	    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
	    <a href="#" class="list-group-item">Morbi leo risus</a>
	    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
	    <a href="#" class="list-group-item">Vestibulum at eros</a>
	</div>
	
    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">最寄り駅からお店を選ぶ</h2>
    </div>
	<div class="list-group">
	    <a href="../location/roppongi" class="list-group-item disabled">六本木</a>
	    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
	    <a href="#" class="list-group-item">Morbi leo risus</a>
	    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
	    <a href="#" class="list-group-item">Vestibulum at eros</a>
	</div>    
</div>



</body>
</html>