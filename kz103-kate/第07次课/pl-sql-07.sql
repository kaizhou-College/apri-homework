----invalid_number的异常
create table test2(v2 varchar2(10))
insert into test2 values('1900667');
commit;

insert into test2 values('19aa667');
commit;
select * from test2

select to_number('19aa667') from dual
select *　from test2 where v2=1900667

declare
       v22 test2.v2%type;
begin
       select v2 into v22 from test2 where v2=1900667;
       exception
              when invalid_number then
                   dbms_output.put_line('无效数字异常');
          
       
end;
select v2 from test2 where v2=1900667;

---总结：
---如果字段是字符  一定要加'' 这是规范
select v2 from test2 where v2='1900667';

-------------------------------------
---1,为什么需要游标cursor？
---2,【隐式游标】
declare

begin
       
       ---select * from emp;
       update emp set comm=nvl(comm,0)+200 where empno=7369;
       if sql%isopen=false then
          dbms_output.put_line('游标关闭');
       end if;
       
       if sql%rowcount>0 then
          dbms_output.put_line('更新成功');
       else 
          dbms_output.put_line('更新失败'); 
       
       end if;
       
       if sql%found=true then
           dbms_output.put_line('更新成功22');
       else
            dbms_output.put_line('更新失败'); 
       end if;
       
end; 
----pl/sql的块中只能进行DML操作 不能进行单一查询
----若果在pl/sql块中需要查询全部  就需要使用游标
----游标------(resultSet:结果集)
select * from emp;


--【3，显示游标/光标】
declare
       cursor dbp is select * from emp;
       emprow emp%rowtype; ---记录型变量
begin
       --1,打开
       open dbp;
       --2,提取行
       loop
            fetch dbp into emprow;
            exit when dbp%notfound;
            dbms_output.put_line(emprow.empno||'---'||emprow.ename);
       end loop;
       --3,关闭
       close dbp;
end;

--【4，循环游标/光标】
declare
       cursor sdm is select * from emp;
       emprow emp%rowtype;
begin
       for emprow in sdm
       loop
           dbms_output.put_line(emprow.ename||'---'||emprow.sal);
       end loop;
end;

----给员工张工资，从最低工资涨起，每个员工10%，
----最终工资不能超过5万，
----统计涨工资的人数以及涨的工资总和
---1，获取所有员工的信息-----游标
---2，循环为员工涨工资  
---3，退出条件-,1）不能超过5w  2)%notfound
---4，记录涨工资的人数？定义变量
---5，记录涨过工资的总和?定义变量
declare 
   cursor zgz is select * from emp order by sal;             
   emprow emp%rowtype;
   num emp.sal%type :=0;---记录涨工资的人数
   sum2 emp.sal%type :=0;---记录涨过工资的总和
begin
   open zgz;
        loop--循环
          fetch zgz into emprow;--从游标中取一行数据
          dbms_output.put_line(emprow.ename||'------'||emprow.sal);
          ---退出条件1：工资不能超过5w
         
          exit when emprow.sal > 50000;
           ---退出条件2：没有员工
          exit when zgz%notfound;
          ---正常涨工资
          update emp set sal = sal*1.1 where empno =emprow.empno; 
          ---涨工资人数+1
          num := num+1;
          ---将涨的工资加到总和中
          sum2 := sum2 + emprow.sal*0.1;
          ---涨工资成功的提示
          if sql%found then
             dbms_output.put_line(emprow.ename||'涨了'||emprow.sal*0.1||'工资');
          end if;
          --提交
          commit;
         
        end loop;
   close zgz;
   
   ---输出最后结果
   dbms_output.put_line('涨工资人数为:'||num||',涨工资的总和：'||sum2);
   
end;

----【循环游标】
declare 
   cursor zgz is select * from emp order by sal;             
   emprow emp%rowtype;
   num emp.sal%type :=0;---记录涨工资的人数
   sum2 emp.sal%type :=0;---记录涨过工资的总和
begin
   for emprow in zgz
   loop
       dbms_output.put_line('------'||emprow.sal);
      ---退出条件1：工资不能超过5w
        exit when emprow.sal > 50000;
        ---正常涨工资
        update emp set sal = sal*1.1 where empno =emprow.empno; 
        ---涨工资人数+1
        num := num+1;
        ---将涨的工资加到总和中
        sum2 := sum2 + emprow.sal*0.1;
        ---涨工资成功的提示
        if sql%found then
           dbms_output.put_line(emprow.ename||'涨了'||emprow.sal*0.1||'工资');
        end if;
        ---退出条件2：没有员工
        exit when zgz%notfound;
   end loop;
  ---输出最后结果
   dbms_output.put_line('涨工资人数为:'||num||',涨工资的总和：'||sum2);
end;

select  * from emp  order by sal

---【游标更新数据】
----游标更新员工工资，每人涨500
declare
        cursor zgz2 is 
               select sal from emp for update;
begin
        for r in zgz2
        loop
            ---涨工资
            update emp set sal = sal+500 
            where current of zgz2;
            if sql%found then
               dbms_output.put_line('成功');
            end if;
        end loop;
        ---必须放到循环外面
        commit;
       
end;


----【使用游标更新】
declare
	cursor mycursor is
   		select sal from emp for update;
begin
   for r in mycursor
   loop
		update emp set sal=sal+500 
      	where current of mycursor;      
   end loop;
end; 


---【ref游标和游标变量】
declare
   ---声明ref游标类型
   type myref is ref cursor ;
   --申明ref游标变量
   myval myref ;
   r emp.sal%type;
begin
  open myval for select sal from emp where deptno=10;
  loop
       fetch myval into r;
       dbms_output.put_line(r);
       exit when myval%notfound; 
  end loop;
end;


----根据用户输入的表名，显示相应的信息。
---如果用户输入‘E’，则显示员工编号和员工姓名 --emp表
--如果用户输入‘D’，则显示部门编号和部门名称  ---dept表

declare
  cursor aa is select * from dept;                    
  --type myref is ref cursor ;
  ---myval myref;
  myval sys_refcursor;
  bm varchar2(10):='&输入表名' ;
  v1 number;
  v2 varchar2(20);
begin
  ---aa for select * from dept;
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


---【带参数游标】
declare 
  cursor c2(dno number) is select * from emp where empno=dno;
  r emp%rowtype;
begin
  
       for r in c2('&请输入员工编号')
       loop
          
           dbms_output.put_line(r.ename);
       end loop;

end;

【动态sql】
begin
  execute immediate 'select * from emp where empno=:dno'--执行查询
  using '&no','&n2';
  --immediate立即
  ---execute immediate 'create table t30522(tid number)';
end;

begin 
  ---DDL
  execute immediate 'create table t30522(tid number)';
end; 

---动态sql：有问题的
declare
  Type salcursor is ref cursor;--声明游标类型
  salcurvar salcursor;--定义游标变量
  mysal emp%rowtype;
begin
  open salcurvar for
  'select sal from emp where deptno=:dno'--动态SQL字符串
  using '&no';--填补占位符的参数
  loop
       fetch salcurvar into mysal;
             dbms_output.put_line(mysal.sal);
       exit when salcurvar%notfound;
  end loop;
end;

select * from emp




