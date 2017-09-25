【游标cursor】
begin
  --DML
  select * from emp;
end;

--在plsql块中只能执行DML操作，而不能做单一的查询，
--要查询必须依赖游标
--在查询数据的时候，获取的结果会通过cursor逐行被游标读取

【隐式游标】
执行DML语句时，由oracle自动启用的，不需要编码干预
begin
  update emp set sal=sal+1 where deptno=10;
  dbms_output.put_line(sql%rowcount);
  commit;--提交以后会导致属性的值被释放和回收掉
  --dbms_output.put_line(sql%rowcount);
end;

begin
  update emp set sal=sal+1 where deptno=10;
  if sql%found then
    dbms_output.put_line(1);
  else
    dbms_output.put_line(2);
  end if;
  commit;
end;

--因为这个隐式游标（sql）是由oracle自身管理的，
--所以开启的状态一般都是为“关闭”
begin
  if sql%isopen then
    dbms_output.put_line(1);
  else
    dbms_output.put_line(2);
  end if;
  update emp set sal=sal+1 where deptno=10;
  if sql%isopen then
    dbms_output.put_line(1);
  else
    dbms_output.put_line(2);
  end if;
  commit;
end;
--游标在处理数据的时候，生命周期中各个阶段的情况如下
--www.avast.com.cn
--1、创建
--2、开启
--3、取数
--4、关闭

【显式游标】
declare
  cursor cur is
    select * from dept; --声明
  r dept%rowtype;
  r0 dept%rowtype;
begin
  open cur;
  loop
    fetch cur
      into r;
    --dbms_output.put_line(r.deptno || '-' || r.dname); 
    exit when cur%notfound;--4
    dbms_output.put_line(r.deptno || '-' || r.dname); 
  end loop;
  --fetch cur into r0;
  --dbms_output.put_line(r0.deptno || '-' || r0.dname); 
  close cur;
end;

初始状态是指向查询结果第一条记录的上方
首先往下移动一行
(就算下一行没有数据，上一次读取的值仍然保留在r变量上)
读取数据，Y：%found =true N:%notfound=true
--要注意fetch不是判断下一行是否有数据，
--而是判断当前游标有无读取到数据

--游标对应JDBC中的Statement对象(1:1),默认只能开启300个

--【带参数的显示游标】
declare
   cursor cur is select * from emp where deptno='&请输入部门编号';
   r emp%rowtype;
begin
  open cur;
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.empno || '-' || r.ename); 
  end loop;
  close cur;
end;

declare
  cursor cur(dno number, esal number) is
    select *
      from emp
     where deptno = dno
       and sal > esal;
  r emp%rowtype;
begin
  open cur(30, 2000); --在开启游标的同时给形参赋值
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.empno || '-' || r.ename);
  end loop;
  close cur;
end;

【最简洁的循环游标的写法，用for】
--游标的open和close由for代劳
declare
  cursor cur(dno number) is
    select * from emp where deptno = dno;
begin
  --r相当于行变量，在运行时会自动给他赋值一个cur读取的行类型
  for r in cur(10) loop
    dbms_output.put_line(r.empno || '-' || r.ename);
  end loop;
  --close cur;--不能重复关闭cursor
  /*if cur%isopen then
    dbms_output.put_line(1);
  end if;*/
end;

--能否将游标操作的数据，在begin-end间来决定？

【ref 游标】
--操作起来更加灵活，可以在运行期间操作不同的表
declare
  type tcur is ref cursor; --定义ref游标的子类型（ref游标的弱类型）
  cur   tcur;
  remp  emp%rowtype;
  rdept dept%rowtype;
begin
  open cur for
    select * from emp;
  loop
    fetch cur
      into remp;
    exit when cur%notfound;
    dbms_output.put_line(remp.ename);
  end loop;
  --通过for从句指定一个新的上下文
  open cur for
    select * from dept;
  loop
    fetch cur
      into rdept;
    exit when cur%notfound;
    dbms_output.put_line(rdept.dname);
  end loop;
  close cur;
end;

declare
  --sys_refcursor是oracle自带的一个ref cursor的子类型(弱类型)
  cur sys_refcursor;
  r   emp%rowtype;
begin
  open cur for
    select * from emp;
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.ename);
  end loop;
  close cur;
end;

--获取某一个部门的员工工资
declare
  cursor cur(dno number) is
    select * from emp where deptno = dno;
begin
  for r in cur('&部门编号') loop
    dbms_output.put_line(r.ename || '-' || r.sal);
  end loop;
end;

declare
  cur sys_refcursor;
  r   emp%rowtype;
begin
  open cur for
    select * from emp where deptno = '&部门编号';
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.ename || '-' || r.sal);
  end loop;
  close cur;
end;

【使用游标来执行DML】
declare
  cursor cur is select * from emp for update;
  r emp%rowtype;
begin
  open cur;
  loop
    fetch cur into r;
    exit when cur%notfound;
    --current of cur表示游标当前抓取的那一行
    update emp set sal=sal+1 where current of cur;
  end loop;
  commit;
  close cur;
end;

【执行动态SQL】
begin
  --execute immediate 'select * from emp';--执行查询
  --immediate立即
  execute immediate 'create table t30522(tid number)';
end;

--结合ref游标
declare
  cur sys_refcursor;
  r   emp%rowtype;
begin
  open cur for 'select * from emp where deptno=:1 and sal>:1'
    using 10, 3000;
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.ename || '-' || r.sal);
  end loop;
  close cur;
end;

--附加题
--create table xxx(sid number,sqlstr varchar2(100));
--存入三条sql
--在plsql中使用for循环来读取每一条sql语句
--然后执行（execute immediate）













