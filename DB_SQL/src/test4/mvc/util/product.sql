--javalink/javalink

create table product(
num number primary key,
name varchar2(30),
price number
);

--sequence
create sequence product_seq;


drop table product;
drop sequence product_seq;

select * from product;