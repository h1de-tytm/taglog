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

<br/>
タグログは、人気ツイッタラーが紹介してくれたお店を検索しやすくしたものです。<br/>
ハッシュタグや最寄り駅、ジャンルからお店を検索することができ、検索結果には食べログURLをつけてます。<br/>
<br/>

<blockquote class="twitter-tweet" data-lang="ja"><p lang="ja" dir="ltr">2017年  <br>東京の今を知る<br>遊び場はこれで検索 🍾<a href="https://twitter.com/hashtag/%E9%A3%9F%E3%81%B96?src=hash">#食べ6</a><a href="https://twitter.com/hashtag/%E3%81%A1%E3%82%87%E3%81%93%E3%83%AD%E3%82%B0?src=hash">#ちょこログ</a><a href="https://twitter.com/hashtag/%E3%81%82%E3%81%BE%E3%83%AD%E3%82%B0?src=hash">#あまログ</a><a href="https://twitter.com/hashtag/%E3%81%B5%E3%81%BF%E9%A3%AF?src=hash">#ふみ飯</a> <a href="https://twitter.com/hashtag/%E9%A3%9F%E3%81%B9%E3%82%8B%E3%81%A1%E3%82%83%E3%82%93%E3%81%AD%E3%82%8B?src=hash">#食べるちゃんねる</a><a href="https://twitter.com/hashtag/%E3%81%B5%E5%9C%9F%E7%94%A3?src=hash">#ふ土産</a><a href="https://twitter.com/hashtag/%E3%81%A1%E3%82%8F%E3%83%AD%E3%82%B0?src=hash">#ちわログ</a><a href="https://twitter.com/hashtag/%E3%81%93%E3%81%98%E3%82%89%E3%81%9B%E3%82%B4%E3%83%8F%E3%83%B3?src=hash">#こじらせゴハン</a><a href="https://twitter.com/hashtag/%E3%82%A2%E3%83%A9%E3%82%B5%E3%83%BC%E3%82%BA%E9%A3%AF?src=hash">#アラサーズ飯</a><a href="https://twitter.com/hashtag/%E3%82%BB%E3%83%A9%E3%83%AD%E3%82%B0?src=hash">#セラログ</a><a href="https://twitter.com/hashtag/%E3%83%A6%E3%82%A6%E9%A3%AF?src=hash">#ユウ飯</a> <a href="https://twitter.com/hashtag/%E3%82%8A%E3%81%8B%E3%83%AD%E3%82%B0?src=hash">#りかログ</a><a href="https://twitter.com/hashtag/%E3%81%92%E3%81%99%E3%82%8D%E3%81%90?src=hash">#げすろぐ</a><a href="https://twitter.com/hashtag/%E3%82%B9%E3%83%94%E3%83%AD%E3%82%B0?src=hash">#スピログ</a> <a href="https://twitter.com/hashtag/%E3%81%BE%E3%81%AA%E3%81%A6%E3%81%83%E9%A3%AF?src=hash">#まなてぃ飯</a><a href="https://twitter.com/hashtag/%E3%81%8D%E3%82%88%E3%83%AD%E3%82%B0?src=hash">#きよログ</a><a href="https://twitter.com/hashtag/%E3%81%82%E3%81%BE%E3%82%AD%E3%83%A8?src=hash">#あまキヨ</a></p>&mdash; Kiyoto (@KiyotoDrives) <a href="https://twitter.com/KiyotoDrives/status/815182870943645700">2016年12月31日</a></blockquote>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>   
    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">タグからお店を選ぶ</h2>
    </div>
    <div class="list-group">
    	<c:forEach items="${tagList}" var="tag">
			<a href="../tag/${tag}" class="list-group-item">${tag}</a>
		</c:forEach>    
    </div>
    <!--  
	<div class="list-group">
	    <a href="../tag/きよログ" class="list-group-item">きよログ</a>
	    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
	    <a href="#" class="list-group-item">Morbi leo risus</a>
	    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
	    <a href="#" class="list-group-item">Vestibulum at eros</a>
	</div>
	-->
	
    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">最寄り駅からお店を選ぶ</h2>
    </div>
    <div class="list-group">
    	<c:forEach items="${locationList}" var="location">
			<a href="../location/${location}" class="list-group-item">${location}</a>
		</c:forEach>
    </div> 
    <!--  
	<div class="list-group">
	    <a href="../location/六本木" class="list-group-item">六本木</a>
	    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
	    <a href="#" class="list-group-item">Morbi leo risus</a>
	    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
	    <a href="#" class="list-group-item">Vestibulum at eros</a>
	</div> 
	-->
	<!-- TODO: 数が多い順に並べる -->
    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">ジャンルからお店を選ぶ</h2>
    </div>
    <div class="list-group">
		<c:forEach items="${genreList}" var="genre">
			<a href="../genre/${genre}" class="list-group-item">${genre}</a>
		</c:forEach>
	</div> 
    <!--  
	<div class="list-group">
	    <a href="../genre/ウニ" class="list-group-item">ウニ</a>
	    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
	    <a href="#" class="list-group-item">Morbi leo risus</a>
	    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
	    <a href="#" class="list-group-item">Vestibulum at eros</a>
	</div>     
	 -->   
</br>
</br>
</br>
</div>
<!--Footer-->
<footer class="page-footer blue center-on-small-only">

    <!--Footer Links-->
    <div class="container-fluid">
        <div class="row">

            <!--First column-->
            <div class="col-md-6">
                <h5 class="title">Footer Content</h5>
                <p>Here you can use rows and columns here to organize your footer content.</p>
            </div>
            <!--/.First column-->

            <!--Second column-->
            <div class="col-md-6">
                <h5 class="title">Links</h5>
                <ul>
                    <li><a href="#!">Link 1</a></li>
                    <li><a href="#!">Link 2</a></li>
                    <li><a href="#!">Link 3</a></li>
                    <li><a href="#!">Link 4</a></li>
                </ul>
            </div>
            <!--/.Second column-->
        </div>
    </div>
    <!--/.Footer Links-->

    <!--Copyright-->
    <div class="footer-copyright">
        <div class="container-fluid">
            © 2015 Copyright: <a href="https://www.MDBootstrap.com"> MDBootstrap.com </a>

        </div>
    </div>
    <!--/.Copyright-->

</footer>
<!--/.Footer-->
</body>
</html>