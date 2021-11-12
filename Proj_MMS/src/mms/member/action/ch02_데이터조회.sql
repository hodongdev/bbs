--Ch02.데이터 조회하기
select * from tab; --table

--문자열 데이터 조회
--문자열, 날짜: 작은따옴표 사용, 대소문자 구분
select eno,ename,salary from employee where ename='ford';--X
select eno,ename,salary from employee where ename='FORD';--O
select eno,ename,salary from employee where ename="FORD";--X
select * from employee where hiredate <= '1982/01/01';

--논리연산자(AND,OR,NOT)
--2000~3000 급여를 받는 사원에 대한 정보 출력?
select *
from employee
where salary >= 2000 and salary <=3000;

select * 
from employee
where salary between 2000 and 3000;

--예)2000이하 이거나 3000이상 급여를 받는 사원에 대한 정보 출력?
select *
from employee
where salary <= 2000 or salary >= 3000;

--in: 특정값이 하나라도 일치하면 참
select * from employee where commission in(300,500,1400);
--commission이 300,500,1400 아닌 사원 검색?
select * from employee where commission not in(300,500,1400);
select * 
from employee 
where commission <> 300 and commission <> 500 and commission <> 1400;
--Like(%,_)
--%:여러문자를 포함, _:하나의 문자만을 포함
select * from employee where ename like 'F';
select * from employee where ename like 'F%';
select * from employee where ename like '%A%';
select * from employee where ename not like '%A%';
select * from employee where ename like '_A%';

--null : 0도 아니고 공백도 아닌, 알수없는 어떤 값(=unknown)
--연산,할당,비교 불가능 (null+10, null = 10, null>10)
select * from employee where commission = null; --X
select * from employee where commission is null;--O
select * from employee where commission is not null;--O
select * from employee where commission <> null;--X <>은 자바에서 != 와 같은 의미

--order by
--ascending(오름차순)-null은 가장 나중에, descending(내림차순)-null이 가장 먼저
select * from employee order by commission asc;
select * from employee order by commission desc;
select * from employee order by commission desc, eno asc;

--(예)상관(상사)이 없는 사원 검색?
select * from employee where manager is null;

--급여 300 인상하기
select ename,salary,salary+300
from employee;

--총수입 순(수입이 많은것부터 작아지도록) 으로 출력 하기
select ename, salary,salary*12+100
from employee order by salary*12+100 desc;

--급여가 2000은 넘는 사원의 이름과 급여를 급여가 많은 것부터 출력
select ename,salary from employee where salary > 2000 order by salary desc;

--사원번호가 7788인 사원의 이름과 부서번호 출력
select ename,dno from employee where eno= '7788';

--급여가 2000에서 3000사이에 포함되지 않는 사원의 이름과 급여를 출력
select ename,salary from employee where salary not between 2000 and 3000;

--1981년 2월 20일부터 1981년 5월 1일 사이에 입사한 사원의 이름,담당업무,입사일을 출력
select ename,job,hiredate 
from employee 
where hiredate between '81/02/20' and '81/05/01';

--부서번호가 20~30에 속한 사원의 이름과 부서번호 출력- 이름을 기준으로 내림차순 적용
select ename,dno from employee where dno between 20 and 30 order by ename asc;

--사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와
  -- 부서번호를 출력 이름순으로(오름차순)
  select ename,salary,dno 
  from employee 
  where salary between 2000 and 3000 
  and dno in(20,30) order by ename;
  
--1981년도에 입사한 사원의 이름과 입사일을 출력 하시오
select ename,hiredate from employee where hiredate like '81%';
  
--관리자가 없는 사원의 이름과 담당 업무 출력
select ename,job from employee where manager is null;

--커미션을 받을수 있는 자격이 되는 사원의 이름,급여,커미션을 출력하되 급여 및 커미션을 기준으로
--내림차순 정렬하여 표시하시오
select ename,salary,commission from employee where commission is not null
order by salary,commission asc;

--이름의 세 번째 문자가 R인 사원의 이름을 표시하시오.
select ename from employee where ename like '__R%'

--이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시
select ename from employee where ename like '%A%' and ename like '%E%';

--담당 업무가 CLERK 또는 SALES맨 이면서 급여가 1600/950 또는 1300이 아닌 사원의 이름
--담당업무 급여를 출력
select ename,job,salary from employee where job in('CLERK','SALESMAN')
and salary not in(1600,950,1300);

--커미션이 500이상인 사원의 이름과 급여 및 커미션을 출력
select ename,salary,commission from employee where commission >= 500;