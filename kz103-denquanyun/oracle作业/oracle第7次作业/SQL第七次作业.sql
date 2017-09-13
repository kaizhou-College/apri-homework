--练习一、隐式游标（游标属性）。
declare
      dno number;
begin
      dno:='&dno';
      update emp set sal = sal+100 where deptno=dno;
      if sql%rowcount>0 then
         dbms_output.put_line('执行成功！执行了'||sql%rowcount||'行记录');
      else
         dbms_output.put_line('执行失败');
      end if;
end;

--练习二、显式游标
--使用显式游标编写一个程序，以显示scott用户中emp表和dept表中的empno，ename，sal，deptno，dname五个字段值。
declare
      cursor em is select * from emp;  --emp表游标
      cursor dp(dno number) is select dname from dept where deptno=dno;  --dept表游标
      emn emp%rowtype;  --emp记录性变量
      dpn dept%rowtype;  --dept 表类型变量
begin
     for emn in em
      Loop
         for dpn in dp(emn.deptno)
             Loop
                 dbms_output.put_line(emn.empno||'------------'||emn.ename||'--------'||emn.sal||'------------'||emn.deptno||'------------'||dpn.dname);
             end loop;
      end loop;
     
end;

--练习三、循环游标 for
--编写程序以显示各部门名称和该部门包含的员工姓名。要求使用显式的循环游标实现。
declare
      cursor dp is select * from dept;  
      cursor em(dno number) is select ename from emp where deptno=dno;  
      emn emp%rowtype;  
      dpn dept%rowtype;  
      num number:=1;
begin
     for dpn in dp
      Loop
              dbms_output.put_line('--------------------------------------------');
             dbms_output.put_line('部门编号：'||dpn.deptno||'，名称：'||dpn.dname);
         for emn in em(dpn.deptno)
             Loop
                    dbms_output.put_line('员工'||num||'：'||emn.ename);
                    num:=num+1;
             end loop;
      end loop;
     
end;

--练习四、使用游标更新数据
--将userInfo.dmp文件中的数据导入到Scott用户下，其中包含UserInfo表，
--由于UserInfo表中客户密码被加密了，现在请你编写PL/SQL语句，重新生成所有用户的密码，要求密码必须为6位数。
declare
	cursor up is  select * from userinfo for update of password;
  num number:=round(dbms_random.value(100000,999999));
begin
   for use in up
   loop
		update userinfo set password=num	where current of up;      
   end loop;
end; 

--练习五、REF游标
--以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
--如果用户输入‘E’则显示emp表中的empno，ename列的值；如果用户输入‘D’则显示dept表中的deptno，dname列的值。
declare
   type Boss is ref cursor;
   DE Boss;
   input varchar2(10):='&输入表名' ;
   num number;
   name varchar2(20);
begin
    if input='E' then
       open DE for select empno,ename from emp;
     else 
       open DE for select deptno,dname from dept;
      end if;
    loop
      fetch DE into num,name;
            dbms_output.put_line(num||'---'||name);
      exit when DE%notfound;
  end loop;
end;
