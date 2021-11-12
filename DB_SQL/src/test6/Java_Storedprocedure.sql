Create Table member2(
	id varchar2(12),
	passwd varchar2(12),
	name varchar2(12),
	age number,
	addr varchar2(50),
	email varchar2(30)
);

drop table member2;

create procedure member_data(
	m_id in member2.id%TYPE,
	m_passwd in member2.passwd%TYPE,
	m_name in member2.name%TYPE,
	m_age in member2.age%TYPE,
	m_addr in member2.addr%TYPE,
	m_email in member2.email%TYPE
)
is
begin
	insert into member2(id,passwd,name,age,addr,email)
    values(m_id,m_passwd,m_name,m_age,m_addr,m_email);
    commit;rks 
end ;

select * from member2;

delete member2 where id='adsf';