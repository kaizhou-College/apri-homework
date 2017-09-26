----公司决定向职员（emp表）发放奖金，发放原则根据职员所在部门编号（deptno）来计算。
----如果部门编号为“10”，奖金为2000元；部门编号为“20”，奖金为1700元；部门编号为“30”，奖金为1500元，请用条件结构解决该问题。
select * from emp
declare
  dno emp.deptno%type;
  eno emp.empno%type := '&请输入员工编号：';
begin
  select deptno into dno from emp where empno = eno;
  if dno = 10 then
    update emp set sal = sal + 2000 where empno = eno;
  elsif dno = 20 then
    update emp set sal = sal + 1700 where empno = eno;
  else
    update emp set sal = sal + 1500 where empno = eno;
  end if;
  commit;
end;

----请编写一个程序，通过循环向course_details表中插入10条件记录，要求学生编号每次累加1，课程由用户输入。
select * from course_detailss
create table course_detailss
(
	stuid number,--学员编号
	course varchar2(20)--—课程
);

declare 
         countid number :=0;--编号
         cousestr course_details.course%type;---课程
begin
       while(countid<10)
       loop
         countid :=countid+1;
         cousestr :='&请输入课程';
         insert into course_details values(countid,cousestr);
         commit;
       end loop;
end;


----练习三、编写一个程序，显示1至100之间的素数（质数）。


declare
    a number(4);--被除数
    b number(4) := 1;--除数
    c number(4) := 0;--被整除的次数;
begin
    for a in 1..100 loop
        while b <= a loop
            if mod(a,b) = 0 then 
                c := c + 1;
            end if;
            b := b + 1;
        end loop; 
        b := 0;
        if c = 2 then 
            dbms_output.put_line(a);         
        end if;  
        c := 0; 
    end loop;
end;

----练习四、请编写PL/SQL块，统计70后，80后，90后用户的人数和占三者人数和的比例。

select * from userinfo
declare 
       a70 number;
       a80 number;
       a90 number;
       a number ;
begin
       select count(*) into a from userinfo ;
       select count(*) into a90 from userinfo where Extract(year from birthday )>= 1990 and extract(year from birthday)<2000;
        select count(*) into a80 from userinfo where Extract(year from birthday )>= 1980 and Extract(year from birthday )<1990;
         select count(*) into a70 from userinfo where Extract(year from birthday )>= 1970 and Extract(year from birthday )<1980;
        dbms_output.put_line('70后总共'||a70||'人');
       dbms_output.put_line('80后总共'||a80||'人');
       dbms_output.put_line('90后总共'||a90||'人');
      dbms_output.put_line('70后共占'||round(a70/a*100,2)||'%');
      dbms_output.put_line('80后共占'||round(a80/a*100,2)||'%');
      dbms_output.put_line('90后共占'||round(a90/a*100,2)||'%');
end;

----针对scott用户的emp表，编写一段PL/SQL代码，根据接收的员工编号查询员工姓名，并将姓名存储在变量empname中。
----代码中要求将变量声明为varchar2(4)类型，如果ename的值的长度大于变量empname的长度，
----将引发Value_Error异常，则对异常进行处理，向用户提示信息。
declare
      empname varchar2(4);
      num number:='&员工编号';
begin
       select ename into empname from emp where empno=num;
       dbms_output.put_line('员工姓名：'||empname);
exception
       when Value_Error then
        dbms_output.put_line('姓名超出长度');
end;
