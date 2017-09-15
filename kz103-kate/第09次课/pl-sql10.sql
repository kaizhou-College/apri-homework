--【程序包的使用：避免重命名】
---1，包声明
create or replace package kz103
as
       ---过程(多个)---根据员工编号显示员工的姓名和工资
       procedure findByNo(eno number);
       ---函数(多个)
       function loveYou(year number) return varchar2;
end;

---2，定义包
create or replace package body kz103
as     ---定义过程
      procedure findByNo(eno number)       
      as
          pename emp.ename%type;
          psal   emp.sal%type;
      begin
         select ename, sal into pename, psal from emp where empno = eno;        
         dbms_output.put_line(pename||'---'||psal);
      end;
       ---定义函数
       function loveYou(year number) 
       return varchar2
       as
        begin
             return '爱你'||year||'年';  
        
        end;
end;  

---- 调用
begin 
     findByno(7369);
end; 

select kz103.loveYou(1000) from dual


create or replace procedure findByNo(eno number)       
as
    pename emp.ename%type;
    psal   emp.sal%type;
begin
   select ename, sal into pename, psal from emp where empno = eno;        
   dbms_output.put_line(pename||'---'||psal);
end;


begin
   findByNo(7369);
end; 

---【在程序包中使用游标变量】
---使用程序包写一个存储过程，
---根据部门编号得到该部门所有员工信息
---1,select * from emp where deptno=10
---2,使用游标得到返回的结果
create or replace package kz103 
as 
   ----定义变量或者游标变量
   type myref is ref cursor;
   procedure findByDno(dno number, myemp out myref);    
end ;

create or replace package body kz103
as
   procedure findByDno(dno number, myemp out myref)
   as
   begin
       open myemp  for select * from emp where deptno=dno;
   
       --close myemp;---游标失效
   end;      
end;

---调用
declare
   
   type myref2 is ref cursor;
   myemp2 myref2;
   pemp emp%rowtype;
begin
   kz103.findByDno('&dno',myemp2);
   loop
     fetch myemp2 into  pemp;
     exit when   myemp2%notfound;  
     dbms_output.put_line(pemp.empno||'----'||pemp.ename||'----'||pemp.sal);
   end loop;
end;

----【编写分页的存储过程:页数---page  每页条数：pageSize 】
create or replace package kzPage103
as     
       type myref is ref cursor;
       procedure findByPage(page number ,pagesize number,myemp out myref);
end;

create or replace package body kzPage103
as
       
   procedure findByPage(page number ,pagesize number,myemp out myref)
   as
   begin
       open myemp for select empno,ename,empjob,
       mgr,hiredate,sal,comm,deptno from
       (select e.* ,row_number() over(order by sal desc) rn
       from emp e) where rn>(page-1)*pagesize and rn <=page*pagesize;     
   end;
end;

---调用方式1：pl/sql调用
declare 
   type myref is ref cursor;
   myemp myref;
   pmyemp emp%rowtype;
begin
   kzPage103.findByPage('&page','&pageSize',myemp);
   loop
          ---结果集变量或者查询的类型不匹配
         fetch myemp into pmyemp;
         exit when myemp%notfound;
         dbms_output.put_line(pmyemp.empno||'---'||pmyemp.sal);
   end loop;
end;


---调用方式2：java调用
----【逆天版编写分页的存储过程:页数---page  每页条数：pageSize 】

create or replace package NtkzPage103
as  
      --page :页数  pageSize：每页条数
      --tname:表名  myemp：返回的数据的游标   
       type myref is ref cursor;
       procedure findByPage(page number ,pagesize number,tname varchar,myemp out myref);
end;

create or replace package body NtkzPage103
as    
   procedure findByPage(page number ,pagesize number,tname varchar,myemp out myref)
   as
   begin
       open myemp for select empno,ename,empjob,
       mgr,hiredate,sal,comm,deptno from
       (select e.* ,row_number() over(order by sal desc) rn
       from tname e) where rn>(page-1)*pagesize and rn <=page*pagesize;     
   end;
end;
--pl/sql调用逆天版分页 遇到问题？

declare 
   type myref is ref cursor;
   myemp myref;
   tname varchar(20) :='&请输入表名';
   --pmyemp  ???%rowtype;
begin
   NtkzPage103.findByPage('&page','&pageSize',tname,myemp);
   dbms_output.put_line(myemp%rowcount);
end;
---java调用


---分页语句
select * from 
(select rownum rn,e.* from emp e)
where rn>(page-1)*pageSize and rn <=page*pageSize
---分页加排序
select * from
(select e.* ,row_number() over(order by sal desc) rn
from emp e) 
where rn>(page-1)*pagesize and rn <=page*pagesize



page= 3 pagesize =3;
select * from 
(select rownum rn,e.* from emp e)
where rn>6 and rn <=9

select rownum rn,e.* from emp e where rownum <=5 order by sal desc

-- 先rownum 后排序 这是不对的
-- 应该先排序后rownum 
--解决方法1：内联子查询

select rownum rn,e.* from 
(select * from emp order by sal desc) e 
where rownum <=5
--解决方法2：函数(推荐的)
---page=2 pagesiz=5
select * from
(select e.* ,row_number() over(order by sal desc) rn
from emp e) 
where rn>5 and rn <=10


select * from emp where empno =7369




 
select * from 
(select rownum rn ,emp.* from emp
 where rownum<=2*5)
where rn>((2-1)*5)







