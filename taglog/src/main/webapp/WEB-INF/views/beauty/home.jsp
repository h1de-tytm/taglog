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

	<title>タグログ ビューティ - ツイッターで話題の美容情報が探せるサイト</title>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.2.3.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/tether.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>

	<!--  for using dropdown -->
	<!--  see:http://fezvrasta.github.io/bootstrap-material-design/bootstrap-elements.html -->
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/static/css/md4bootstpra/ripples.css" />" >
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/static/css/md4bootstpra/bootstrap-material-design.css" />" >

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-38971369-13', 'auto');
  ga('send', 'pageview');

</script>
<script>
$(function() {
	var order = 'favorite';
	$('[name=order]').change(function() {
		order = $('[name=order]').val();
		console.log('change ' + order);
	});
	//http://www.codechewing.com/library/add-query-string-to-end-of-link-jquery/
	$('.categoryLink').on('click', function(event) {
		console.log('click');
        $('.categoryLink').attr('href', function(index, value) {
        	console.log(value + order);
        	if (value.includes("favorite")) {
        		return value.replace("favorite", order);
        		
        	} else if (value.includes("retweet")) {
        		return value.replace("retweet", order);
        		
        	} else if (value.includes("newer")) {
        		return value.replace("newer", order);
        		
        	} else if (value.includes("random")) {
        		return value.replace("random", order);
        		
        	} else {
        		return value + '?order=' + order;
        	}
        	
        })
	});
	$('#searchButton').on('click', function(event) {
		window.location.href = '/beauty/search?keyword='
	});
	

});
</script>
</head>
<body>
<nav class="navbar navbar-toggleable-md navbar-dark default-color">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav1" aria-controls="navbarNav1" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="../beauty">
            <strong>タグログ ビューティ</strong>
        </a>
        <div class="collapse navbar-collapse" id="navbarNav1">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="../../">グルメ <!--<span class="sr-only">../(current)</span>--></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="../beauty">美容<!--<span class="sr-only">../(current)</span>--></a>
                </li>
            </ul>
         </div>
     </div>
 </nav>


<div class="container">


<br/>
ツイッターの美容・サプリ・筋トレ情報をカテゴリ分けして、探しやすくしてみました。<br/>
ツイートはいいね順、RT順、新着順、ランダムに並べ替えることができます。<br/>
筋トレ・恋愛系の情報は独断と偏見で選びましたが、美容情報は<a href="https://twitter.com/jayredjeans" target="_blank">@JayRedjeans</a>さんの
<a href="https://togetter.com/id/JayRedjeans" target="_blank">「美容垢と健康垢の方々のバズったツイートの美味しいとこだけをまとめました」</a>をかなり参考にしています。</br>
また、このサイトでは多くの方のツイートを掲載させていただいております。</br>
ツイート掲載に問題がある場合は即時削除いたしますので、<a href="https://twitter.com/cook_hideyoshi" target="_blank">@cook_hideyoshi</a>までご連絡いただければと思います。
<br/>
いいね数、RT順は週末に集計することが多いため、リアルタイムでのカウント数とズレが生じる可能性があります。
<br/>
<br/>
<form name="orderForm" method="get">
<div class="form-group">
    <label for="order" class="control-label">表示順:</label>
    <select name="order" id="order" class="form-control">
        <option value="favorite">いいね順</option>
        <option value="retweet">RT順</option>
        <option value="newer">新着順</option>
		<option value="random">ランダム</option>
    </select>
</div>
</form>
  
    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">カテゴリを選ぶ</h2>
    </div>
    <div class="list-group">
    	<c:forEach items="${beautyCategoryList}" var="beautyCategory">
			<a href="../beauty/category/${beautyCategory.categoryName}" class="list-group-item categoryLink">${beautyCategory.categoryName}</a>
		</c:forEach>    
    </div>
    <div class="divider-new">
        <h2 class="h2-responsive wow bounceIn">キーワード検索</h2>
    </div>
    <form action="/beauty/search" method="GET" role="form" class="form-horizontal">
	  <div class="form-group">
	    <label for="searchterm" class="col-sm-2 control-label">気になる単語で検索できます。</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="searchterm" name="keyword" placeholder="キーワードを入力してください...">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">キーワード検索</button>
	    </div>
	  </div>    
    </form>

</br>
</div>

<!--Footer-->
<footer class="page-footer default-color center-on-small-only">

    <!--Footer Links-->
    <div class="container-fluid">
        <div class="row">

            <!--First column-->
            <div class="col-md-6">
                <h5 class="title">ご連絡</h5>
                <p>このサイトは<a href="https://twitter.com/cook_hideyoshi" target="_blank">@cook_hideyoshi</a>によって運営されています。
               	 ツイートの掲載に問題がある場合は、<a href="https://twitter.com/cook_hideyoshi" target="_blank">@cook_hideyoshi</a>までご連絡ください。
                </p>
            </div>
            <!--/.First column-->

            <!--Second column-->
            <div class="col-md-6">
                <h5 class="title">リンク</h5>
                <ul>
                    <li>作成者のブログ:<a href="http://oreno-yuigon.hatenablog.com/" target="_blank">俺の遺言を聴いてほしい</a></li>
                    <li>Github:<a href="https://github.com/h1de-tytm/taglog" target="_blank">taglog</a></li>
                    <li>Special Thanks:<a href="https://twitter.com/jayredjeans" target="_blank">@JayRedjeans</a></li>
                </ul>
            </div>
            <!--/.Second column-->
        </div>
    </div>
    <!--/.Footer Links-->

    <!--Copyright　-->
    <div class="footer-copyright">
        <div class="container-fluid">
            © 2017 Copyright: <a href="https://twitter.com/cook_hideyoshi" target="_blank">@cook_hideyoshi </a>
        </div>
    </div>
    <!--/.Copyright-->

</footer>
<!--/.Footer-->

</body>
</html>