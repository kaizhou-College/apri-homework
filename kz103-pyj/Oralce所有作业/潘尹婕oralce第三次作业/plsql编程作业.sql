--使用条件结构
--公司决定向职员（emp表）发放奖金，发放原则根据职员所在部门编号（deptno）来计算。
--如果部门编号为“10”，奖金为2000元；部门编号为“20”，奖金为1700元；部门编号为“30”，
--奖金为1500元，请用条件结构解决该问题。 
declare 
       deptnum emp.deptno%type;
       num1 number ;
begin
       num1 :='&职员编号';
      select deptno into deptnum from emp where empno=num1;
      dbms_output.put_line(deptnum);
       if deptnum =10 then
          update emp set comm=nvl(comm,0)+2000 where deptno=deptnum;
        elsif deptnum = 20 then
              update emp set comm=nvl(comm,0)+1700 where deptno=deptnum;
           else 
                update emp set comm=nvl(comm,0)+1500 where deptno=deptnum;
               end if;
               commit;
end;
select * from emp


--请编写一个程序，通过循环向course_details表中插入10条件记录，要求学生编号每次累加1，课程由用户输入。
create table course_details
(
	stuid number,--学员编号
	course varchar2(20)--—-课程
);
m
declare 
         stuid number;
        num number := 1; 
        input1 varchar2(20) :='&请输入课程名';
begin
        loop
           exit when num > 10;
           dbms_output.put_line(num ||input1);
           num := num+1;
           stuid :=stuid+1;
          end loop;
          commit;        
end;

--编写一个程序，显示1至100之间的素数（质数）。素数（质数）：只能被1和本身整除的数。
declare
          num1 number(3):=2;
          num2 number:=0;
begin
          loop
               num2:=0;
               for num in 2..num1-1
          loop
               if(num1 mod num=0) then num2:=1;
               end if;
               end loop;
          if(num2=0) then 
                  dbms_output.put_line(num1);
                  end if; num1:=num1+1;
                  exit when num1=100;
           end loop;
end;
--请编写PL/SQL块，统计70后，80后，90后用户的人数和占三者人数和的比例。
declare
          num70 number;
          num80 number;
          num90 number;
          sumtal number;
begin
          select count(*) into num70 from userinfo where substr(to_char(birthday,'yyyy'),3,1)='7';
          select count(*) into num80 from userinfo where substr(to_char(birthday,'yyyy'),3,1)='8';
          select count(*) into num90 from userinfo where substr(to_char(birthday,'yyyy'),3,1)='9';
          sumtal :=num70+num80+num90;
          dbms_output.put_line('70后共'||num70||'人;80后共'||num80||'人;90后共'||num90||'人');
          dbms_output.put_line('70后占'||round(num70*100/sumtal,2)||'%');
          dbms_output.put_line('80后占'||round(num80*100/sumtal,2)||'%');
          dbms_output.put_line('90后占'||round(num90*100/sumtal,2)||'%');

end;
----针对scott用户的emp表，编写一段PL/SQL代码，根据接收的员工编号查询员工姓名，并将姓名存储在变量empname中。
--代码中要求将变量声明为varchar2(4)类型，如果ename的值的长度大于变量empname的长度，将引发Value_Error异常，
--则对异常进行处理，向用户提示信息。
declare
          empname varchar2(4);
begin
          select ename into empname from emp where empno='7369';
      exception
        when Value_error then
              dbms_output.put_line('员工姓名过长');        
end;






























