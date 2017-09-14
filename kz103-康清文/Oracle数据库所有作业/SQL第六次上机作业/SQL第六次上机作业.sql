--练习一、使用条件结构
--问题描述：公司决定向职员（emp表）发放奖金，发放原则根据职员所在部门编号（deptno）来计算。
--如果部门编号为“10”，奖金为2000元；部门编号为“20”，奖金为1700元；部门编号为“30”，奖金为1500元，
--请用条件结构解决该问题。

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



--练习二、使用循环结构
--问题描述：请编写一个程序，通过循环向course_details表中插入10条件记录，要求学生编号每次累加1，课程由用户输入。
create table course_details
(
	stuid number,--学员编号
	course varchar2(20)--课程
);

select * from course_details
declare 
       num number;
       course varchar2(40);
begin
       
    for num in 1..10
        course  :='&请输入课程名字';
            dbms_output.put_line(num||'--------'||course);
            insert into course_details values(num,course);
        end loop;
        commit;
end;


--练习三、编写一个程序，显示1至100之间的素数（质数）。
--提示：
--1、素数（质数）：只能被1和本身整除的数。
--2、使用for循环
declare
        i number(4);--被除数
        j number(4):=1;--除数
        z number(4):=0;--存储被整除的次数
begin
        for i in 1..100
            loop 
                while j<=i 
                      loop
                        if mod(i,j)=0 then
                           z:=z+1;
                         end if;
                         j:=j+1;
                      end loop;
                      j:=0;
                      if z=2 then
                         dbms_output.put_line(i);
                       end if;
                       z:=0;
            end loop;

end;







--练习四 列名  注释
--CUSTOMERID  客户编号
--CREATETIME  客户创建时间
--EMAIL  客户email
--LANGUAGE  客户语言
--USERNAME  客户帐户
--SCREENNAME  呢称
--PASSWORD  密码
--ISMALE  是否通过邮箱认证
--BIRTHDAY  生日
--POSTALCODE  邮政编码
--FIRSTNAME  第一名称
--LASTNAME  第二名称
--ADDRESS  地址
--请编写PL/SQL块，统计70后，80后，90后用户的人数和占三者人数和的比例。效果如下：
select * from userinfo
declare
       seven number;--七零后的人数
       eight number;--八零后的人数
       nine number;--九零后的人数
       he number;--总和
      
begin
     select count(*) into seven from userinfo where substr(extract(year from birthday),3,1)=7;
     select count(*) into eight from userinfo where substr(extract(year from birthday),3,1)=8;
     select count(*) into nine from userinfo where substr(extract(year from birthday),3,1)=9;
      he:=seven+eight+nine;
      
      dbms_output.put_line('七零后,八零后,九零后,和三者人数和的比率为：'||seven||':'||eight||':'||nine||':'||he);
      dbms_output.put_line('七零后占三者人数和的百分比为：'||floor((seven/he)*100)||'%');
      dbms_output.put_line('八零后占三者人数和的百分比为：'||floor((eight/he)*100)||'%');
      dbms_output.put_line('九零后占三者人数和的百分比为：'||floor((nine/he)*100)||'%');
end;








--练习五、使用预定义异常
--针对scott用户的emp表，编写一段PL/SQL代码，根据接收的员工编号查询员工姓名，并将姓名存储在变量empname中。
--代码中要求将变量声明为varchar2(4)类型，如果ename的值的长度大于变量empname的长度，将引发Value_Error异常，
--则对异常进行处理，向用户提示信息。
select * from emp
declare
         empname varchar2(4);
         num emp.empno%type:='&请输入员工编号';
begin
         select ename into empname from emp where empno=num;
         exception
                when Value_Error then
                     dbms_output.put_line('ename的值的长度大于变量empname的长度');

end;




