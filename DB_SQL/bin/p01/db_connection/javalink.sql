
--���̺� �����
drop table member1;

create table member2(
id VARCHAR2(15) primary key,
password varchar2(10),
name varchar2(10),
age number,
gender varchar2(5),
email varchar2(30)
);

--���̺� ������ �ֱ�
insert into member2 values('hong2','1234','hongkil',20,'��','hong@hong.com');
commit;

select * from member2;




--------------------------------------------------

create table goodsinfo(
	code  char(5) not null primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
);

insert into goodsinfo values('10001','������ TV',35000,'LG');
insert into goodsinfo values('10002','LCD TV',135000,'�Ｚ');
insert into goodsinfo values('10003','LED TV',235000,'LG');
insert into goodsinfo values('10004','UHD TV',335000,'�Ｚ');
insert into goodsinfo values('10005','OLED TV',435000,'LG');

commit;

select * from goodsinfo;


create table book(
id varchar2(10) primary key,
name varchar(10),
price number(10)
);

insert into book values('aaaa','hong',1000);
insert into book values('bbbb','alphago',2000);
insert into book values('cccc','beta',3000);

select * from book;


drop table book;


