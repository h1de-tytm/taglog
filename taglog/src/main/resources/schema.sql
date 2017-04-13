DROP TABLE IF EXISTS taglog;
create table taglog (
	id identity auto_increment,
	tag varchar(140) not null,
	location varchar(100) not null,
	genre	varchar(100) not null,
	tweet	varchar(5000) not null,
	tabelogUrl	varchar(1000),
	shopName	varchar(100)
);

insert into taglog(tag, location, genre, tweet, tabelogUrl, shopName)
values('kiyolog', '恵比寿', 'フレンチ','ここはとても良いお店です', 'http://www.google.com', 'いい店');

insert into taglog(tag, location, genre, tweet, tabelogUrl, shopName)
values(
'kiyolog',
'渋谷',
'中華',
'<blockquote class="twitter-tweet" data-lang="ja"><p lang="ja" dir="ltr">炒飯  東京TOP3<br><br>(ぼく調べ)<br><br>わさ  都立大学<br><br>香宮  六本木<br><br>大枡  蒲田<a href="https://twitter.com/hashtag/%E3%81%8D%E3%82%88%E3%83%AD%E3%82%B0?src=hash">#きよログ</a> <a href="https://t.co/y24mWYDuZn">pic.twitter.com/y24mWYDuZn</a></p>&mdash; Kiyoto (@KiyotoDrives) <a href="https://twitter.com/KiyotoDrives/status/850725207501225985">2017年4月8日</a></blockquote>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>',
'http://www.yahoo.co.jp',
'茶半炒飯'
);
