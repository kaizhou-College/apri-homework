使用函数和过程实现分页查询的逻辑

为什么要使用函数或者过程
执行SQL的过程
1、编译
2、执行
3、取数
4、返回

函数和过程的逻辑都是预先封装好，并且已经是数据库引擎能够直接执行的
代码，因此执行函数和过程只需要2.3.4

【自定义存储过程】
create procedure sayhello as
begin
  dbms_output.put_line('hello');
end;

执行：
--方式一
sql>execute 过程名
--方式二
begin
  sayhello;
end;
--方式三（主要）
JDBC调用。。。

--带参数的过程
【in】
create procedure calcavgsal(dno in number) as
  avgs number;
begin
  select avg(sal) into avgs from emp where deptno = dno;
  dbms_output.put_line(avgs);
end;

begin
  calcavgsal(10);
end;

【out参数类型】
create procedure calcavgsal2(dno in number, avgs out number) as
begin
  select avg(sal) into avgs from emp where deptno = dno;
end;

declare
  n number;--在调用方先准备好一个参数
begin
  calcavgsal2(20, n);
  dbms_output.put_line(n);
end;

--这个out参数不是return出去的，而是调用方传过来，执行方赋值以后
--还过去的

【in out 复合类型参数】--不推荐常用
create procedure calcavgsal3(x in out number) as
begin
  select avg(sal) into x from emp where deptno = x;
end;

declare
  n number := 30; --在调用方先准备好一个参数
begin
  calcavgsal3(n);
  dbms_output.put_line(n);
end;

--参数不能声明长度/容量
create or replace procedure print(s in varchar2) as
begin
  dbms_output.put_line(s);
end;


begin
  print('jack');
end;

create or replace procedure swap(n1 in out number, n2 in out number) as
  tmp number;
begin
  tmp := n1;
  n1  := n2;
  n2  := tmp;
end;


declare
  n1 number := 3;
  n2 number := 7;
begin
  swap(n1, n2);
  dbms_output.put_line(n1);
  dbms_output.put_line(n2);
end;

【自定义函数】
create or replace function getempname(eno number) return varchar2 as
  ena emp.ename%type;
begin
  select ename into ena from emp where empno = eno;
  return ena;
  exception
     when no_data_found then
       return '没有找到数据包';
end;
--select * from emp where empno=empno;

select getempname(1) from dual;

--虽然函数与过程属于两种不同的对象类型
--但是两者共用一个命名空间
create or replace procedure getempname as
begin
  null;--空语句
end;

【程序包】
为了解决命名冲突的问题，可以将函数和过程定义在package中
--定义包的规范，告诉别人我能做什么
create or replace package java30522 as
  procedure calcavgsal2(dno in number, avgs out number);
  function getempname(eno number) return varchar2;
end;

create or replace package body java30522 as

  procedure calcavgsal2(dno in number, avgs out number) as
  begin
    select avg(sal) into avgs from emp where deptno = dno;
  end;

  function getempname(eno number) return varchar2 as
    ena emp.ename%type;
  begin
    select ename into ena from emp where empno = eno;
    return ena;
  exception
    when no_data_found then
      return '没有找到数据包';
  end;
end;
--1、包规范和包的实体名称必须一致
--2、包规范和实体中存放的对象必须要一致
--  数量一致、对象名一致、参数列表一致
declare
  avgs number;
begin
  calcavgsal2(10, avgs);
  dbms_output.put_line(avgs);
  java30522.calcavgsal2(10, avgs);
  dbms_output.put_line(avgs);
end;

select '姓名：' || java30522.getempname(7788) from dual;


--根据传递的表名(varchar2)返回游标(读取表记录的指针)
create or replace procedure querytable(tablename in varchar2,
                                       cur       out sys_refcursor) as
begin
  open cur for 'select * from ' || tablename;
end;

declare
  cur sys_refcursor;
  r   dept%rowtype;
begin
  querytable('dept', cur);
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.deptno || r.dname);
  end loop;
  close cur;
end;

--分页存储过程
create or replace procedure querypage(n1  in number,
                                      n2  in number,
                                      cur out sys_refcursor) as
begin
  open cur for
    select *
      from (select e.*, row_number() over(order by sal) rn from emp e)
     where rn between n1 and n2;
end;

--分页语句
select *
      from (select e.*, row_number() over(order by sal) rn from emp e)
     where rn between 5 and 8;




