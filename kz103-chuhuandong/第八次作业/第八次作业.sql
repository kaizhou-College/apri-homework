--练习一、
--用Scott用户的emp表为数据源，编写一个过程根据员工编号输出员工姓名和薪水。（要求将员工姓名和薪水作为输出参数）
create or replace procedure que(empnos number,ename out varchar2,sal out number) as
begin
       select ename,sal into ename,sal from emp where empno=empnos;
end;

declare
       ename varchar2(10);
       sal number;
begin
       que(7369,ename,sal);
       dbms_output.put_line(sal||'--------'||ename);
end;

--练习二、
--用Scott用户的emp表为数据源，编写一个函数根据员工编号返回员工的入职时间。
create or replace function worktwo(empnos number)
return date
as
dates emp.hiredate%type;
begin
      select hiredate into dates from emp where empno=empnos;
      return dates;
end;

declare
      empnos number;
begin
      empnos :='&请输入员工编号';
      dbms_output.put_line(worktwo(empnos));
end;

--练习三、
--创建程序包，在程序包中定义一个过程用作添加员工，
--再定义一个函数用作根据员工编号判断员工是否存在。
--（要求：在用户执行添加操作之前，先调用函数判断该员工是否存在，
--如果不存在，则插入并提交数据；否则提示该员工已存在）
create or replace function workthree(empnos number)
return varchar2
as
ena emp.ename%type;
begin
  select ename into ena from emp where empno = empnos;
  return '该用户已存在';
  exception
     when no_data_found then
       return '添加成功您的编号是'||empnos;
end;

begin
       dbms_output.put_line(workthree(736));
end;

--练习四 参照上课代码完成：
--用Scott用户的emp表为数据源，编写分页的存储过程，要求传入开始和结束的行处显示数量，输出游标。
--（提示：可在程序包中定义游标类型，再声明游标变量作为输出参数）
create or replace procedure fneye(n1 in number,n2 in number,cur out sys_refcursor) as
begin
open cur for select * from(select e.*, row_number() over(order by sal) rn from emp e)
where rn between n1 and n2;
end;

select * from (select e.*, row_number() over(order by sal) rn from emp e) where rn between 5 and 15;

--练习五、
--现有账单表如下：

