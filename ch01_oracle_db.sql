-- Ch01. Oracle & Database
--Relation DataBase: 테이블과 테이블사이의 관계를 통해서 데이터 저장,검색 하는것.
--DBMS: Oracle,MySQL,MS-SQL

--테이블 만들기
--자식 테이블
create table employee(
eno number(4) primary key, 
ename varchar2(10),  
job varchar2(9),
manager number(4),
hiredate date,
salary number(7,2),
commission number(7,2),
dno number(2)REFERENCES department(dno)
);

--부모 테이블
create table department(
DNO number(2) PRIMARY KEY,
DNAME varchar(14),
LOC varchar2(13)
);


create table salgrade(
GRADE number,
LOSAL number,
HISAL number
);
commit;

insert into employee 
values(7369,'SMITH','CLERK',7902,to_date('17-12-80','dd-mm-yyyy'),800,NULL,20);
insert into employee 
values(7499,'ALLEN','SALESMAN',7698,to_date('20-02-81','dd-mm-yyyy'),1600,300,30);
insert into employee 
values(7521,'WARD','SALESMAN',7698,to_date('22-02-81','dd-mm-yyyy'),1250,500,30);
insert into employee 
values(7566,'JONES','MANAGER',7839,to_date('02-04-81','dd-mm-yyyy'),2975,NULL,20);
insert into employee 
values(7654,'MARTIN','SALESMAN',7698,to_date('28-09-81','dd-mm-yyyy'),1250,1400,30);
insert into employee 
values(7698,'BLAKE','MANAGER',7839,to_date('01-05-81','dd-mm-yyyy'),2850,NULL,30);
insert into employee 
values(7782,'CLARK','MANAGER',7839,to_date('09-06-81','dd-mm-yyyy'),2450,NULL,10);
insert into employee 
values(7788,'SCOTT','ANALYST',7566,to_date('19-04-87','dd-mm-yyyy'),3000,NULL,20);
insert into employee 
values(7839,'KING','PRESIDENT',NULL,to_date('17-11-81','dd-mm-yyyy'),5000,NULL,10);
insert into employee 
values(7844,'TURNER','SALESMAN',7698,to_date('08-09-81','dd-mm-yyyy'),1500,0,30);
insert into employee 
values(7876,'ADAMS','CLERK',7788,to_date('23-05-87','dd-mm-yyyy'),1100,NULL,20);
insert into employee 
values(7900,'JAMES','CLERK',7698,to_date('03-12-81','dd-mm-yyyy'),950,NULL,30);
insert into employee 
values(7902,'FORD','ANALYST',7566,to_date('03-12-81','dd-mm-yyyy'),3000,NULL,20);
insert into employee 
values(7934,'MILLER','CLERK',7782,to_date('12-01-82','dd-mm-yyyy'),1300,NULL,10);
--추가
--primary key 제약조건(eno): not null, 중복값X 
--foreign Key 제약조건(dno): 부모 테이블의 기본키(dno)를 하나의 컬럼으로 놓은 것.
--                        : 그 컬럼은 domain(10,20,30,40), 중복된 값, NULL이 올 수 있다.
insert into employee 
values(1000,'MILLER','CLERK',7782,to_date('12-01-82','dd-mm-yyyy'),1300,NULL,10);
insert into employee 
values(2000,'MILLER','CLERK',7782,to_date('12-01-82','dd-mm-yyyy'),1300,NULL,NULL);


drop table salgrade;
drop table department;
drop table employee;
-- 테이블을 만들때는 부모 테이블을 먼저 만들고 자식 테이블을 만들어야 한다.
-- 테이블을 지울때는 자식 테이블을 먼저 지우고 부모 테이블을 지워야 한다.


commit;
rollback;--실행취소, 철회

select * from employee;
select * from department;
select * from salgrade;

--
insert into department values(10,'ACCOUNTING','NEW YORK');
insert into department values(20,'RESEARCH','DALLAS');
insert into department values(30,'SALES','CHICAGO');
insert into department values(40,'OPERATION','BOSTON');

insert into salgrade values(1,700,1200);
insert into salgrade values(2,1201,1400);
insert into salgrade values(3,1401,2000);
insert into salgrade values(4,2001,3000);
insert into salgrade values(5,3001,9999);

select * from employee;
select * from department;
select * from salgrade;

select * from emp;
select * from dept;

-----30 page---------------------------------------------------------
desc department; --describe

select * from employee;
select eno,ename from employee;
--연봉구하기
select ename,salary,salary*12 from employee;
select ename,salary,salary*12,salary*12+commission from employee;

-- null+10 => null, 0+10=>10
select ename,salary,job,dno,nvl(commission,0) 보너스,salary*12,
salary*12+nvl(commission,0) "연 봉" from employee;

select ename || ' is a ' || job from employee;
select ename, ' is a ',  job from employee;

--Distinct: 중복제거
select dno from employee;
select distinct dno from employee;

--직급이 중복되지 않고 한번씩 출력하기
select distinct job from employee;

--dual table: 가상 테이블
select * from employee;
select sysdate from employee;
select sysdate from dual;

