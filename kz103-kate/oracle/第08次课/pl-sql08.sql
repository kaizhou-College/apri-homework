---1,动态sql
---输入部门号，获取该部门所有员工工资


declare
  ---显示游标(参数)
  ---ref游标变量
  type myref is ref cursor;
  mysals myref;---定义一个myref类型 的游标变量
  mysal emp.sal%type;
begin
  open mysals for 'select sal from emp where deptno=:dno'
  using '&no';
  ---读取游标中数据(1,普通方式，2，循环游标)
  
  loop
     fetch mysals into mysal;
     exit when mysals%notfound;
      ---输出
     dbms_output.put_line(mysal.sal);
  end loop;
  close mysals;
end;


---总结：1,for游标 中必须要使用记录游标，并且不能open close  fetch
---------2, 如果返回的结果只包含了某些字段 ,那么fetch不能使用记录型变量                     

===============================================
---以前我们写的都是匿名pl/sql块 ，有名的pl/sql块就叫子程序

--- 写一个存储过程实现输出我爱你
--declare
create or replace procedure sayLoveYou 
--return number
as

begin
    dbms_output.put_line('我爱你');
    --return 1;
end;
---输出100次我爱你
create or replace procedure sayLoveYou 
as
begin
    for r in 1..100
    loop
     dbms_output.put_line(r||'我爱你');
    end loop;
end;
---【1，存储过程三种调用方式】
--1，command window
exec 过程名;

set serveroutput on;
exec sayLoveYou;
--2，sql window 
begin 
     sayLoveYou();
end; 
---3，通过java程序调用  (重点)

--【2，带参数存储过程】

--写一个存储过程实现输出我爱你？年   ？通过参数输入
create or replace procedure sayLoveYou(year number)
is

begin
    dbms_output.put_line('我爱你'||year||'年');   
end;
---调用
begin
    sayLoveYou('&year');
end; 

--根据员工编号查询员工姓名，并打印；
--如果没找到记录则为用户输出友好提示（不存在该员工）。
create or replace procedure findByNO(eno  number)
is
----声明变量
       pename emp.ename%type;
begin
   select ename into pename  from emp where empno=eno;
   dbms_output.put_line(eno||'---'||pename);  
   exception
         when no_data_found then
              RAISE_APPLICATION_ERROR(-20001,'输入的用户不存在');    
end;
-- 调用
begin
   findByNO('&输入员工编号');

end;

---使用in 和out

create or replace procedure 
       findByNo(eno in number,pname out varchar)

as
begin
       select ename into pname from emp where empno=eno;
       exception
         when no_data_found then
              RAISE_APPLICATION_ERROR(-20001,'输入的用户不存在');    
end;


---调用
declare
   aa emp.ename%type;
begin
---这里不叫返回值，将aa变量传入过程，过程赋值还回来
   findByNo('&输入员工编号',aa);
   dbms_output.put_line(aa);
end;
--【in out 的使用---不推荐使用】
----输入两个整数，交换，调用过程的是然后输出
create or replace procedure 
       swap(n3 in out number,n4 in out number)
as
       temp number;
begin
      temp :=n3;
      n3 :=n4;
      n4 :=temp; 
end;

--调用
declare 
      n1 number :=55;
      n2 number :=44;
begin
      dbms_output.put_line('交换前n1='||n1||'   n2='||n2);
      --交换
      swap(n1,n2);
      dbms_output.put_line('交换后n1='||n1||'   n2='||n2);
      
end;  

--【存储函数】
---返回'我爱你'
create or replace function LoveYou           
return varchar2
as 
begin
   return '我爱你';    
end;

---调用
declare
   v2 varchar2(20);
begin
   v2:=LoveYou;
   dbms_output.put_line(v2);
end;

select LoveYou from dual;


---返回'我爱你?年'
create or replace function LoveYou(year number)
return varchar2
as
begin
       return '我爱你'||year||'年';
end;

select LoveYou(10000) from dual









--根据员工编号查询员工姓名，并打印；
--如果没找到记录则为用户输出友好提示（不存在该员工）。
create or replace function findByNo(eno number)
return varchar
as
       pname emp.ename%type;
begin
       select ename into pname from emp 
              where empno=eno;
       return pname;
       exception
           when no_data_found then
              RAISE_APPLICATION_ERROR(-20002,'查询员工不存在');
        

end;
---调用
declare
   pname varchar2(20);           
begin
   pname:=   findByNo('&输入员工编号') ;
   dbms_output.put_line(pname);       
end;

select findByNo('&输入员工编号') from dual;


drop findbyno;

---【自主事务处理】
--过程1：
create or replace procedure
testp1 
is 
pragma autonomous_transaction;--标识子程序为自主事务处理
begin
  delete from emp where empno=7369;
  rollback;
end;
--过程2：
create or replace procedure
testp2 
is 
begin
  delete from emp where empno=7499;
  testp1;
end;
调用：
begin
  testp2;
end;

---总结：自主事务---每个子程序的事务的独立

select * from emp where empno=7499

----为什么程序包？
---过程和函数使用同一个命名空间，导致过程的名字
---不能和函数的名字一样  命名冲突的问题

---声明
create or replace package mypack
is
       procedure LoveYou(eno number);
       function IsHaveEmp(eno number) return number;
end;


---  定义
create or replace package body mypack
is
---定义声明的存储过程
procedure LoveYou(eno number)
is
myname varchar2(20);
   begin
  if IsHaveEmp(eno)>0 then
         select ename into myname from emp where empno=eno;
         dbms_output.put_line(myname);
      else
         dbms_output.put_line('不存在该员工');
      end if;      
   end;
---定义声明的存储函数       
function IsHaveEmp(eno number) 
       return boolean
       is
       counter number;
       begin
          select count(*) into counter from emp where empno=eno;
          return counter;
       end;
end;


select loveyou(1000) from dual

begin
       mypack.loveyou(1000);
end;









