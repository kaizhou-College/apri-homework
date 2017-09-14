--编写一段PL/SQL代码，接收用户输入的部门编号、部门名称和部门地址，将其插入到scott用户的dept表中。
--要求使用动态SQL实现。execute immediate 'sql语句'
--using 参数列表 --使用参数填补占位符（:name）
select * from dept
begin
        execute immediate 'insert into dept values(:v1,:v2,:v3)'
        using '&请输入部门编号','&请输入部门名称','&请输入部门地址';



end;

--练习一、隐式游标（游标属性）
--现有如下PL/SQL块，根据用户输入的部门编号，更新员工工资。
--请在注释处补全代码实现：如果更新成功则显示用户成功更新了多少条记录，否则提示部门不存在。
declare
      dno number;
      tiao number;--记录更新的条数
begin
      dno:='&请输入部门编号';
        update emp set sal=sal+100 where deptno=dno;
        select count(*) into tiao from emp where deptno=dno;
       
      if sql%rowcount>0 then
        dbms_output.put_line('成功更新了'||tiao||'条记录');
       else
         dbms_output.put_line('部门不存在');

       end if;
end;
--练习二、显式游标
--使用显式游标编写一个程序，以显示scott用户中emp表和dept表中的empno，ename，sal，deptno，dname五个字段值。
declare
       cursor xian is select * from emp;--emp表的显示游标
       cursor shi is select * from dept;--dept表的显示游标
       eesdd emp%rowtype;--emp表的记录型变量
       ddsee dept%rowtype;--dept表的记录型变量

begin
       open xian;
       loop
            fetch xian into eesdd;
            exit when xian%notfound;
            dbms_output.put_line(eesdd.empno||'===='||eesdd.ename||'===='||eesdd.sal);
       
       end loop;
       close xian;
       dbms_output.put_line('======================');
        open shi;
         loop
             fetch shi into ddsee;
            exit when shi%notfound;
            dbms_output.put_line(ddsee.deptno||'===='||ddsee.dname);
         
         end loop;
       close shi;
end;
--练习三、循环游标 for
--编写程序以显示各部门名称和该部门包含的员工姓名。要求使用显式的循环游标实现。
--效果如下：


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
--将userInfo.dmp文件中的数据导入到Scott用户下，其中包含UserInfo表，
--由于UserInfo表中客户密码被加密了，现在请你编写PL/SQL语句，重新生成所有用户的密码，要求密码必须为6位数。
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
select * from UserInfo
--练习五、REF游标
--以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
--如果用户输入‘E’则显示emp表中的empno，ename列的值；如果用户输入‘D’则显示dept表中的deptno，dname列的值。

declare
      type myref is ref cursor;
      myval myref;
       bm varchar2(20):='&请输入表名';
       v1 number;
       v2 varchar2(20);
      
begin
       if bm='E' then
                open myval for select empno,ename from emp ;
       else
                open myval for select deptno,dname from dept;
       
       end if;
       loop
           fetch myval into v1,v2;
           exit when myval%notfound;
           dbms_output.put_line(v1||'===='||v2);

       end loop;
end;

