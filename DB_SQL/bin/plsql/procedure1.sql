[결과]
2 ^ 3 = 8
IN IN  OUT
--a_exponent가 음수이면 값을 0으로 변경하고, 1을 반환한다.
create or replace procudure conpute_power(
	a_num In number,
	a_exponent IN OUT number,
	a_power OUT number
)
is
begin
	if a_exponent < 0 then
	a_exponent := 0;
	end if
	a_power := 1;
	
for in 1..a_exponent loop
	a_power := a_power*a_num;
end loop;

end;

select * from member2;