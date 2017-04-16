drop table if exists taglog;

create table taglog(
taglogId identity auto_increment ,
tag varchar(140) not null ,
tweet varchar(5000) not null ,
tweetId bigint not null );


insert into taglog(tag,tweet,tweetId) values ('kiyolog', '<blockquote class="twitter-tweet" data-lang="ja"><p lang="ja" dir="ltr">炒飯  東京TOP3<br><br>(ぼく調べ)<br><br>わさ  都立大学<br><br>香宮  六本木<br><br>大枡  蒲田<a href="https://twitter.com/hashtag/%E3%81%8D%E3%82%88%E3%83%AD%E3%82%B0?src=hash">#きよログ</a> <a href="https://t.co/y24mWYDuZn">pic.twitter.com/y24mWYDuZn</a></p>&mdash; Kiyoto (@KiyotoDrives) <a href="https://twitter.com/KiyotoDrives/status/850725207501225985">2017年4月8日</a></blockquote><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>',850725207501225985);
insert into taglog(tag,tweet,tweetId) values ('kiyolog', '<blockquote class="twitter-tweet" data-lang="ja"><p lang="ja" dir="ltr">メゾン・ランドゥメンヌ<br><br>フランス産レスキュールバターをたっぷり使った1個500円ほどの超高級クロワッサンが有名ですが<br><br>ぼくのオススメはこの小さなカヌレ(120円)<br><br>なかはトロリとした食感<br><br>ランチついでに大量買いをして3時のおやつ用にストックします<a href="https://twitter.com/hashtag/%E3%81%8D%E3%82%88%E3%83%AD%E3%82%B0?src=hash">#きよログ</a> <a href="https://t.co/w3q524N0He">pic.twitter.com/w3q524N0He</a></p>&mdash; Kiyoto (@KiyotoDrives) <a href="https://twitter.com/KiyotoDrives/status/848451931496259584">2017年4月2日</a></blockquote><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>',848451931496259584);
insert into taglog(tag,tweet,tweetId) values ('kiyolog', '<blockquote class="twitter-tweet" data-lang="ja"><p lang="ja" dir="ltr">本日のランチは<br>港区最強のコストパフォーマンス(ぼく調べ)を誇る天丼<br>「天丼 金子屋」<br>にて蓋の閉まらない天丼を<br><br>温泉卵の天ぷらを割り、タレの染みたご飯と混ぜて食べるのが、月に一回しあわせのルーティン<a href="https://twitter.com/hashtag/%E3%81%8D%E3%82%88%E3%83%AD%E3%82%B0?src=hash">#きよログ</a> <a href="https://t.co/FBqFht4geQ">pic.twitter.com/FBqFht4geQ</a></p>&mdash; Kiyoto (@KiyotoDrives) <a href="https://twitter.com/KiyotoDrives/status/848395738702684160">2017年4月2日</a></blockquote><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>',848395738702684160);

drop table if exists shops;
create table shops(
shopId identity auto_increment ,
tweetId bigint not null ,
shopName varchar(300) not null ,
genre varchar(140) not null ,
location varchar(140) not null ,
tabelogUrl varchar(1000) not null );

insert into shops(tweetId,shopName,genre,location,tabelogUrl) values (850725207501225985, 'わさ','炒飯','都立大学','https://tabelog.com/tokyo/A1317/A131702/13091042/');
insert into shops(tweetId,shopName,genre,location,tabelogUrl) values (850725207501225985, '香宮','炒飯','六本木','https://tabelog.com/tokyo/A1307/A130701/13132399/');
insert into shops(tweetId,shopName,genre,location,tabelogUrl) values (850725207501225985, '大枡','炒飯','蒲田','https://tabelog.com/tokyo/A1315/A131503/13062254/');
insert into shops(tweetId,shopName,genre,location,tabelogUrl) values (848451931496259584, 'メゾン・ランドゥメンヌ','パン','六本木','https://tabelog.com/tokyo/A1307/A130701/13180316/');
insert into shops(tweetId,shopName,genre,location,tabelogUrl) values (848395738702684160, '天丼 金子屋 赤坂店 ','天丼','赤坂','https://tabelog.com/tokyo/A1308/A130802/13169860/');
