--练习一、隐式游标（游标属性）
--现有如下PL/SQL块，根据用户输入的部门编号，更新员工工资。
declare
    dno number;
    cursor cur is select * from emp where deptno='&请输入部门编号';
begin
 
   update emp set sal=sal+100 where deptno=dno;
   if sql%found then
      dbms_output.put_line('更新成功');
   else
      dbms_output.put_line('更新失败');
   end if;
end;


--练习二、显式游标
--使用显式游标编写一个程序，以显示scott用户中emp表和dept表中的empno，ename，sal，deptno，dname五个字段值。
create view m
       as select a.empno,a.ename,a.job,a.mgr,a.hiredate,a.sal,a.comm,a.deptno,b.dname,b.loc from emp  a,dept b where a.deptno=b.deptno
      
declare
       cursor dbp is select * from m;
       emprow m%rowtype; ---记录型变量
begin
       --1,打开
       open dbp;
       --2,提取行
       loop
            fetch dbp into emprow;
          
            exit when dbp%notfound;
         
            dbms_output.put_line(emprow.empno||'---'||emprow.ename||'---'||emprow.sal||'---'||emprow.deptno||'---'||emprow.dname);
         
       end loop;
       --3,关闭
       close dbp;
end;



--练习三、循环游标 for
--编写程序以显示各部门名称和该部门包含的员工姓名。要求使用显式的循环游标实现。

declare
      s varchar2(10);
      cursor dno is select * from dept;
      cursor eno(no emp.deptno%type) is select ename from emp where deptno=no;
begin
      for r in dno
       loop
          dbms_output.put_line('部门编号：'||r.deptno||'部门名称：'||r.dname);
          for s in eno(r.deptno)
              loop
                   dbms_output.put_line('员工'||eno%rowcount||':'||s.ename);
              
              end loop;
      end loop;
end;


--练习四、使用游标更新数据
--将userInfo.dmp文件中的数据导入到Scott用户下，其中包含UserInfo表，由于UserInfo表中客户密码被加密了，
--现在请你编写PL/SQL语句，重新生成所有用户的密码，要求密码必须为6位数。
--提示：dbms_random程序包提供了生成随机数的方法。
--示例：select dbms_random.value(0,100) from dual;产生0-100之间的随机数

declare
            rand UserInfo.Password%type;
            cursor pw is select password from UserInfo for update;--创建一个pw游标

begin
             
            
            for r in pw
                loop
                  select floor(dbms_random.value(100000,999999)) into rand from dual;
                  update UserInfo set password=rand where current of pw;
                  
                end loop;
end;
  




--练习五、REF游标以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
--如果用户输入‘E’则显示emp表中的empno，ename列的值；如果用户输入‘D’则显示dept表中的deptno，dname列的值。
declare
  cursor aa is select * from dept;                    

  myval sys_refcursor;
  bm varchar2(10):='&请输入表名' ;
  v1 number;
  v2 varchar2(20);
begin

  if bm='E' then
     open myval for select empno,ename from emp;
  else 
     open myval for select deptno,dname from dept;
  end if;
  
  loop
      fetch myval into v1,v2;
            dbms_output.put_line(v1||'---'||v2);
      exit when myval%notfound;
  end loop;
  
end;









       
