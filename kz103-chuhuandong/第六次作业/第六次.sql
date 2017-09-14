--问题描述：公司决定向职员（emp表）发放奖金，发放原则根据职员所在部门编号（deptno）来计算。
--如果部门编号为“10”，奖金为2000元；部门编号为“20”，奖金为1700元；部门编号为“30”，奖金为1500元，请用条件结构解决该问题。
declare
  dno emp.deptno%type;
  eno emp.empno%type:='&请输入员工编号';
begin
  select deptno into dno from emp where empno = eno;
  if dno=10 then
    update emp set sal=sal+2000 where empno = eno;
  elsif dno=20 then
    update emp set sal=sal+1700 where empno = eno;
  else
    update emp set sal=sal+1500 where empno = eno;
  end if;
  commit;
end
--问题描述：请编写一个程序，通过循环向course_details表中插入10条件记录，要求学生编号每次累加1，课程由用户输入。
declare
  c varchar2(15);
Begin
For  i in  1..10
Loop
     c :='&输入科目';
   insert into course_details values(i,c);
End loop;
End;
--练习三、编写一个程序，显示1至100之间的素数（质数）。
--提示：
--1、素数（质数）：只能被1和本身整除的数。
--2、使用for循环
declare
    i number(4);--存储1-100中所有的数（用作被除数）
    j number(4) := 1;--存储除数
    z number(4) := 0;--存储被整除的次数;
begin
    for i in 1..100 loop
        while j <= i loop
            if mod(i,j) = 0 then 
                z := z + 1;
            end if;
            j := j + 1;
        end loop; 
        j := 0;
        if z = 2 then 
            dbms_output.put_line(i);         
        end if;  
        z := 0; 
    end loop;
end;

--练习四、将userInfo.dmp文件中的数据导入Scott用户下，该文件中包含UserInfo用户信息表，结构如下：
declare
    sevenzero number(4);
    eightzero number(4);
    ninezero number(4);
    alls number(4);
begin
    select count(*) into sevenzero from userInfo where extract(year from birthday)>=1970 and extract(year from birthday)<1980;
    select count(*) into eightzero from userInfo where extract(year from birthday)>=1980 and extract(year from birthday)<1990;
    select count(*) into ninezero from userInfo where extract(year from birthday)>=1990 and extract(year from birthday)<1999;
    alls :=ninezero+eightzero+sevenzero;
    dbms_output.put_line(round((sevenzero/alls)*100,2)||'%');
    dbms_output.put_line(round((eightzero/alls)*100,2)||'%');
   dbms_output.put_line(round((ninezero/alls)*100,2)||'%');
end;
--针对scott用户的emp表，编写一段PL/SQL代码，根据接收的员工编号查询员工姓名，并将姓名存储在变量empname中。
--代码中要求将变量声明为varchar2(4)类型，如果ename的值的长度大于变量empname的长度，
--将引发Value_Error异常，则对异常进行处理，向用户提示信息。
declare
   empname varchar2(4);
   empnos number:='&请输入员工编号';
begin
   select ename into empname from emp where empno=empnos;
   dbms_output.put_line(empname);
exception
    when Value_Error then
   dbms_output.put_line('被我捕获到了');
end;
select * from emp






















