----1,根据用户输入的部门编号，更新员工工资
declare
  dno number;
begin
  dno:='&dno';
  update emp set sal=sal+100 where deptno=dno;
  if sql%found then
     dbms_output.put_line('部门编号'||dno||'涨了工资'||'有'||sql%rowcount||'人涨了工资');
   else
     dbms_output.put_line('部门不存在');
   end if;
end;

----2,使用显式游标编写一个程序，以显示scott用户中emp表和dept表中
----的empno，ename，sal，deptno，dname五个字段值。
select * from emp
select * from dept

declare
      cursor em is select * from emp;
      cursor dp(dno number) is select dname from dept where deptno=dno;
      emm emp%rowtype;
      dpp dept%rowtype;
begin
 dbms_output.put_line('empno-----------ename----------sal---------deptno-----------dname');
     for emm in em
      Loop
         for dpp in dp(emm.deptno)
             Loop
                 dbms_output.put_line(emm.empno||'------------'||emm.ename||'--------'||emm.sal||'------------'||emm.deptno||'------------'||dpp.dname);
             end loop;
      end loop;
     
end;

----3,编写程序以显示各部门名称和该部门包含的员工姓名。要求使用显式的循环游标实现。

select * from dept
select * from emp

declare
       cursor gs is select * from dept;
       em emp%rowtype;
       pt dept%rowtype;
       cursor emm(dno number) is select ename from emp where deptno=dno; 
       num number:=1;

begin
       for pt in gs
       loop
       dbms_output.put_line('--------------------------------');
       dbms_output.put_line('部门编号:'||pt.deptno||'部门名称'||pt.dname);
          for em in emm(pt.deptno)
             Loop
                    dbms_output.put_line('员工'||num||':'||em.ename);
                    num:=num+1;
             end loop;
       end loop;
end;


----4,将userInfo.dmp文件中的数据导入到Scott用户下，其中包含UserInfo表，
----由于UserInfo表中客户密码被加密了，现在请你编写PL/SQL语句，
----重新生成所有用户的密码，要求密码必须为6位数。

select * from userinfo
select * from dual

declare
  cursor sj is select * from dual;
  user userinfo%rowtype;
begin
  for user in sj
      loop
           update userinfo set(password) = round(dbms_random.value(100000,1000000));
           if sql%rowcount>0 then
              dbms_output.put_line('成功'); 
           else
              dbms_output.put_line('失败');
           end if;  
      end loop;      
end;

----5,以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
----如果用户输入‘E’则显示emp表中的empno，ename列的值；
----如果用户输入‘D’则显示dept表中的deptno，dname列的值。
declare
  cursor aa is select * from dept;                    
  myval sys_refcursor;
  bm varchar2(10):='&输入表名' ;
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
