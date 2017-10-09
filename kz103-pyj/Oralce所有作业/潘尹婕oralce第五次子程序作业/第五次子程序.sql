--用Scott用户的emp表为数据源，编写一个过程根据员工编号输出员工姓名和薪水。（要求将员工姓名和薪水作为输出参数）
select * from emp

create or replace procedure Byname(eno number)
is
       pname emp.ename%type;
       money emp.sal%type;
begin
       select ename,sal into pname,money from emp where empno=eno;
       dbms_output.put_line(pname||'---'||money);
       exception
        when no_data_found then
             RAISE_APPLICATION_ERROR(-20000,'该员工不存在');
end;
--调用
begin 
       Byname('&输入员工编号');
end;

--用Scott用户的emp表为数据源，编写一个函数根据员工编号返回员工的入职时间。
create or replace function Bytime(eno number)
return varchar
as
       time emp.hiredate%type;
begin
       select hiredate into time from emp where empno=eno;
       return time;
       exception
        when no_data_found then
             RAISE_APPLICATION_ERROR(-2000,'该员工并未入职');
end;
--调用
declare
         time varchar2(20);
begin
      time:=Bytime('&员工编号');
      dbms_output.put_line(time);     
end;

--创建程序包，在程序包中定义一个过程用作添加员工，再定义一个函数用作根据员工编号判断员工是否存在。
--（要求：在用户执行添加操作之前，先调用函数判断该员工是否存在，如果不存在，则插入并提交数据；否则提示该员工已存在）


--用Scott用户的emp表为数据源，编写分页的存储过程，要求传入开始和结束的行处显示数量，输出游标。
--（提示：可在程序包中定义游标类型，再声明游标变量作为输出参数）
create or replace procedure Bypage(v1 in number,v2 in number,mycur out sys_refcursor)
as
begin
       open mycur for select * from (select e.*,row_number() over(order by sal) rn from emp e)
       where rn between v1 and v2;

end;
declare
       type myref is ref cursor;
       mycur myref;
       page number:='&page';
       pageSize number:='&pagesize';
       pemp emp%rowtype;
begin
       open mycur for select empno,ename,job,mgr,hiredate,sal,comm,deptno from (select e.*, row_number() over(order by sal) rn from emp e)
        where rn>(page-1)*pageSize and rn<=page*pageSize;
        loop
              fetch mycur into pemp;
              exit when mycur%notfound;
                dbms_output.put_line(pemp.ename||'====='||pemp.empno);
        
        end loop;
end;
select * from emp order by sal
--要求编写过程实现开单功能，即生成账编号并插入记录。
Create table billInfo(
  billID varchar2(14),  --账单编号，格式为‘ZD201005290001’
  billDate date      --开单时间
  );
  
create or replace procedure Bybill
is
       begin
       
--编写通用版的分页存储过程，然后编写java程序调用
create or replace packge Bytypage  


