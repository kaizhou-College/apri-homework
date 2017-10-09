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
create or replace function Bystaff(eno number)
return varchar
as
       pname emp.ename%type;
begin
       select ename into pname from emp where empno=eno;
       return pname;
      exception
       when no_data_found then
            RAISE_APPLICATION_ERROR(-20000,'该员工不存在')
              
select * from emp

--用Scott用户的emp表为数据源，编写分页的存储过程，要求传入开始和结束的行处显示数量，输出游标。
--（提示：可在程序包中定义游标类型，再声明游标变量作为输出参数）
create or replace procedure copylimit(startpoint number,getnum number) as    
--/*定义table*/  
type emp_tab is table of myemp%rowtype;  
emp_rd emp_tab;  
 www.2cto.com  
--/*定义游标*/  
emp_cur sys_refcursor;  
--开启  
begin  
  --显示用户输入的开始点与要取出的数据量  
  dbms_output.put_line('开始点：'||startpoint||' 取出数量：'||getnum);  
  --打开游标并且给游标赋值（执行分页查询）  
  open emp_cur for select * from myemp where rowid in (  
                   select rd from(  
                   select rownum rm,rd from(     
                   select rowid rd from myemp order by empno) where rownum < startpoint + getnum) where rm >= startpoint);  
   --开启循环  
   loop    
     --从游标里面取值bulk collect方式赋给emp_rd  
     fetch emp_cur bulk collect into emp_rd limit 2;  
     --循环遍历  
     for i in 1..emp_rd.count loop  
       dbms_output.put_line('员工名：'||emp_rd(i).ename);  
     end loop;  
     exit when emp_cur%notfound;   
    --结速循环   
    end loop;  
    --关闭游标  
    close emp_cur;  
--结束  
end;  




--要求编写过程实现开单功能，即生成账编号并插入记录。
Create table billInfo(
	billID varchar2(14),	--账单编号，格式为‘ZD201005290001’
	billDate date			--开单时间
  );
  
create or replace procedure Bybill
is
       begin
          
