----【练习一、】
----用Scott用户的emp表为数据源，编写一个过程根据员工编号输出员工姓名和薪水。（要求将员工姓名和薪水作为输出参数）
create or replace procedure 
       name7Sal(epno in emp.empno%type,namep out emp.ename%type,salp out emp.sal%type)    
as
begin
     
     select ename ,sal into namep,salp from emp where empno=epno;
     dbms_output.put_line('员工姓名:   '||namep||'员工工资:   '||salp);
         --  exception 
             --    when no_data_found then
              --        RAISE_APPLICATION_ERROR(-20001,'输入的用户不存在');
end;

---调用
declare
       nn emp.ename%type;
       ss emp.sal%type;
begin
       name7Sal('&请输入员工编号',nn,ss);
      -- dbms_output.put_line(nn||'   '||ss);
end;      

     
-----【练习二、】
-----用Scott用户的emp表为数据源，编写一个函数根据员工编号返回员工的入职时间。
create or replace function
                             shijian(epno number)
return varchar                             
as
      sj emp.hiredate%type;
begin
      select hiredate into sj from emp where empno=epno;
      return sj;
      dbms_output.put_line('员工编号   '||epno||'入职时间   '||sj);
end;


--调用
declare 
      shij emp.hiredate%type;
begin
      shij :=shijian('&请输入员工编号');
      dbms_output.put_line('员工入职时间    '||shij);
end;


----【练习三、】
----创建程序包，在程序包中定义一个过程用作添加员工，再定义一个函数用作根据员工编号判断员工是否存在。
----（要求：在用户执行添加操作之前，先调用函数判断该员工是否存在，如果不存在，则插入并提交数据；否则提示该员工已存在）

create








