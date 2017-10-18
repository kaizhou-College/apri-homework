--练习一、隐式游标（游标属性）
declare
 dno number;
begin
 dno :='&dno';
 update emp set sal=sal+100 where deptno=dno;
 if sql%rowcount>0 then
    dbms_output.put_line('执行成功，执行了'||sql%rowcount||'行');
  else
    dbms_output.put_line('执行失败部门不存在');
  end if;  
end;

--练习二、显式游标
--使用显式游标编写一个程序，
--以显示scott用户中emp表和dept表中的empno，ename，sal，deptno，dname五个字段值。
declare
  cursor cur is select * from emp order by deptno;
  cursor curs is select * from dept;
  num emp%rowtype;
  num2 dept%rowtype;
begin
  for num in cur
  loop
       for num2 in curs
       loop
           if num.deptno=num2.deptno then
              dbms_output.put_line(num.empno||'----'||num.ename||'----'||num.sal||'----'||num.deptno||'----'||num2.dname);
           end if;
       end loop;
  end loop;
end;
--练习三、循环游标 for
declare
  cursor cur is select * from emp;
  cursor curs is select * from dept;
  num emp%rowtype;
  num2 dept%rowtype;
  nums number:=0;
begin
  for num2 in curs
      loop
           dbms_output.put_line('部门编号：'||num2.deptno||'，名称：'||num2.dname);
           for num in cur
           loop
               if num.deptno=num2.deptno then
                  nums:=nums+1;
                  dbms_output.put_line('员工'||nums||'：'||num.ename);
               end if;
           end loop;
            dbms_output.put_line('————————————————————————————————————————————');
      end loop;
end;
--练习四、使用游标更新数据
declare
      cursor cur is select passwords from userinfo for update;
      num number(6):=round(dbms_random.value(100000,999999),0);
      nums number:=0;
begin
      for r in cur
      loop
          update userinfo set passwords = num where current of cur;
          nums := nums+1;
      end loop;
      if sql%found then
               dbms_output.put_line('成功'||'跟新了'||nums||'行');
      end if;
      commit;
end;
select * from userinfo

--以Scott用户登录，编写一段代码，提示用户要查看哪个表的记录，
--如果用户输入‘E’则显示emp表中的empno，ename列的值；
--如果用户输入‘D’则显示dept表中的deptno，dname列的值。
declare
       refs sys_refcursor;
       input varchar(2):='&输入表名';
       v1 number;
       v2 varchar2(20);
begin
       if input='E' then
          open refs for select empno,ename from emp;
       elsif input='D' then
          open refs for select deptno,dname from dept;
       else
          dbms_output.put_line('请输入正确的表');                                             
       end if;
       loop
           fetch refs into v1,v2;
                 dbms_output.put_line(v1||'————————————'||v2);
           exit when refs%notfound;
        end loop;
        close refs;
end;
