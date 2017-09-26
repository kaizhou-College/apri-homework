----【练习一、隐式游标（游标属性）】
----根据用户输入的部门编号，更新员工工资。
----如果更新成功则显示用户成功更新了多少条记录，否则提示部门不存在。
declare 
  dno number;
  updatenum number;---显示用户成功更新了多少条记录
begin 
  loop
  exit when sql%notfound;
  dno :='&dno';
  update emp set sal = sal+100 where deptno=dno;
  select count(deptno) into updatenum from emp where deptno = 10;
  if sql%rowcount>0 then 
     dbms_output.put_line('用户更新了'||updatenum||'条数据');
  else
        dbms_output.put_line('部门不存在');
   end if;
   commit;
  end loop;
end;
select * from dept;




----【练习二、显式游标】
----使用显式游标编写一个程序，以显示scott用户中emp表和dept表中的
----empno，ename，sal，deptno，dname五个字段值。
create view view1
       as select a.*,b.dname,b.loc from emp a ,dept b where a.deptno=b.deptno
declare 
       cursor come is select * from view1;
       rrow view1%rowtype;
begin
       open come;
       loop 
            fetch come into rrow;
            exit when come%notfound ;
            dbms_output.put_line(rrow.empno||rrow.ename||rrow.sal||'------'||rrow.deptno||rrow.dname);
       end loop;
end; 

 select count(deptno)  numno1 from emp group by deptno

----【练习三、循环游标 for】
----编写程序以显示各部门名称和该部门包含的员工姓名。要求使用显式的循环游标实现。
declare 
         cursor bm is select dname,deptno from dept;
         cursor em(dno number) is select ename from emp where deptno = dno;
         deptrow dept%rowtype;
         empnum emp%rowtype;
         numno number :=1;
begin
         for deptrow in bm
         loop
             dbms_output.put_line('部门编号:'||deptrow.deptno||'，  名称:'||deptrow.dname);
             for empnum in em(deptrow.deptno)
                 loop
                        dbms_output.put_line('员工'||numno||':'||empnum.ename);
                        numno := numno+1;
                 end loop;
          exit when bm%notfound;
         end loop;
end;



----【练习四、使用游标更新数据】
---将userInfo.dmp文件中的数据导入到Scott用户下，其中包含UserInfo表，由于UserInfo表
---中客户密码被加密了，现在请你编写PL/SQL语句，重新生成所有用户的密码，要求密码必
--须为6位数。
---提示：dbms_random程序包提供了生成随机数的方法。
declare 
         cursor mycursor is
                select password from userinfo for update;
         mm userinfo.password%type;
begin
         for rs in mycursor
         loop
             select floor(dbms_random.value(100000,999999)) into mm from dual;
             update userinfo set password =mm
             where current of mycursor;
         end loop;
end;

select * from userinfo;



----【练习五、REF游标】
--以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
--如果用户输入‘E’则显示emp表中的empno，ename列的值；
--如果用户输入‘D’则显示dept表中的deptno，dname列的值。

declare 
        type myref is ref cursor;
        myval myref;
        sj varchar2(10) :='&输入表名';
        numno number;
        namestr varchar2(20);      
begin 
        if sj='E' then
           open myval for select empno,ename from emp;
        else
           open myval for select deptno,dname from dept;
        end if;
        loop
            fetch myval into numno,namestr;
                  dbms_output.put_line(numno||'----'||namestr);
            exit when myval%notfound;
        end loop; 
end;





