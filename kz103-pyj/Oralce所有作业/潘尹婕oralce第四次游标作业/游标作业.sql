--根据用户输入的部门编号，更新员工工资。
--如果更新成功则显示成功更新了多少条记录，否则提示部门不存在。
declare
  dno number;
begin
  dno:='&dno';
  update emp set sal=sal+100 where deptno=dno;
  if sql%isopen=false then
     dbms_output.put_line('游标关闭');
  end if;
  if sql%found  then 
     dbms_output.put_line('更新了'||sql%rowcount||'条');
  else 
     dbms_output.put_line('部门不存在');
  end if;
end;

select deptno,sal from emp;
--使用显式游标编写一个程序，以显示scott用户中emp表和dept表中的
--empno，ename，sal，deptno，dname五个字段值。
declare 
       cursor mytable is select empno,ename,sal,dept.deptno,dname from emp,dept
       where emp.deptno=dept.deptno;     
begin
       for r in mytable
       loop
            dbms_output.put_line(r.empno||'---'||r.ename||'---'||r.sal||'---'||r.deptno||'---'||r.dname);
       end loop;
end;

--编写程序以显示各部门名称和该部门包含的员工姓名。要求使用显式的循环游标实现。
select * from emp;
declare 
         cursor empdeptno is select emp1.deptno dept,dept1.dname from emp emp1 inner join dept dept1
               on emp1.deptno=dept1.deptno;
         cursor depstsum(deptno2 number) is select ename from emp where deptno= deptno2;
begin
      for s in empdeptno
      loop
          dbms_output.put_line('部门编号：'||s.dept||'名称:'||s.dname);                 
      
      for r in depstsum(s.dept)
          loop
          dbms_output.put_line('员工:'||depstsum%rowcount||r.ename);
          end loop;
        end loop;
end;
----将userInfo.dmp文件中的数据导入到Scott用户下，其中包含UserInfo表，
--由于UserInfo表中客户密码被加密了，现在请你编写PL/SQL语句，
--重新生成所有用户的密码，要求密码必须为6位数。
declare
	cursor pass is  select * from userinfo for update of password;
  num number:=round(dbms_random.value(100000,999999));
begin
   for user in pass
   loop
		update userinfo set password=num where current of pass;      
   end loop;
end;

--以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
--如果用户输入‘E’则显示emp表中的empno，ename列的值；如果用户输入‘D’则显示dept表中的deptno，dname列的值。
declare
    cursor myscott is select * from dept;                    
    mytable sys_refcursor;
    tablename varchar2(10):='&输入表名' ;
    name1 number;
    name2 varchar2(20);
begin
        if tablename='E' then
           open mytable for select empno,ename from emp;
     else 
          open mytable for select deptno,dname from dept;
     end if; 
  loop
      fetch mytable into name1,name2;
            dbms_output.put_line(name1||'-----'||name2);
            exit when mytable%notfound;
  end loop;
end;
