procedure language/structure query language
  
【匿名语句块 anonymous block】
declare
  str varchar2(10) := 'hello';--声明部分
begin
  dbms_output.put_line(str);--执行部分
  --exception--异常部分
end;

【如何赋值】
--:= / select xx into xx
declare
  n1 number := 10;
  n2 number;
begin
  n2 := 20;
  select sal into n2 from emp where empno = 7499;--不能返回多行
  dbms_output.put_line(n1 || '-' || n2);
end;

--简单
begin
  dbms_output.put_line('hello');
end;

【属性类型】
%type %rowtype
declare
  empname emp.ename%type; --向%type前面的列的类型看齐
begin
  select ename into empname from emp where empno = 7499;
  dbms_output.put_line(empname);
end;

declare
  r emp%rowtype;--一行作为一个整体类型
begin
  select * into r from emp where empno = 7499;
  --r.列名没有先后顺序
  dbms_output.put_line(r.empno || '-' || r.ename);
end;

【if结构】
declare
  n1 number;
  n2 number;
begin
  n1 := '&请输入第一个数字'; --字符串的末尾不要带冒号
  n2 := '&请输入第二个数字';
  /*if n1 > n2 then
    dbms_output.put_line('大于');
  end if;*/

  /*if n1 > n2 then
    dbms_output.put_line('大于');
  else
    dbms_output.put_line('小于或等于');
  end if;*/

  if n1 > n2 then
    dbms_output.put_line('大于');
  elsif n1 = n2 then
    dbms_output.put_line('等于');
  else
    dbms_output.put_line('小于');
  end if;
end;

declare
  n1 number := 10;
  n2 number := 20;
begin
  if n1 > 0 and n1 < n2 then
    dbms_output.put_line('****');
  end if;
end;

declare
  dno emp.deptno%type;
  eno emp.empno%type := '&请输入员工编号：';
begin
  select deptno into dno from emp where empno = eno;
  if dno = 10 then
    update emp set sal = sal + 100 where empno = eno;
  elsif dno = 20 then
    update emp set sal = sal + 200 where empno = eno;
  else
    update emp set sal = sal + 300 where empno = eno;
  end if;
  commit;
end;

【case-when】
declare
  n number := '&请输入一个数字';
begin
  case
    when n >= 80 then
      dbms_output.put_line('优秀');
    when n < 80 and n >= 60 then
      dbms_output.put_line('良好');
    else
      dbms_output.put_line('差');
  end case;
end;


【循环】
declare
  n number := 1;
begin
  loop
    exit when n >= 5;--退出条件
    dbms_output.put_line('*****');
    n := n + 1;
  end loop;
end;

declare
  n number := 1;
begin
  while n <= 5 loop
    dbms_output.put_line('*****');
    n := n + 1;
  end loop;
end;

--for i in [reverse] n1..n2 loop
--i的变化范围从n1至n2，每次加1
begin
  for i in reverse 1..5 loop
    dbms_output.put_line(i);
  end loop;
end;

【异常】
declare
  r emp%rowtype;
begin
  select * into r from emp where empno=1;
exception 
  when no_data_found then
    dbms_output.put_line('找不到数据');
end;

declare
  r emp%rowtype;
begin
  select * into r from emp;
exception
  when too_many_rows then
    dbms_output.put_line('太多行');
end;

declare
  n number := '&数字';
begin
  null;
exception
  when invalid_number then
    dbms_output.put_line('...');
end;

begin
  insert into emp (empno) values (7788);
  commit;
exception
  when dup_val_on_index then
    dbms_output.put_line('插入重复的值在unique index上');
end;

--select * from studentinfo where stucard=430a06198801010001;
declare
 ena studentinfo%rowtype;
begin
  select * into ena from studentinfo where stucard='&请输入';
exception
  when invalid_number then--?
    dbms_output.put_line('无效的数字');
end;

【自定义】
declare
  age_outof_range exception;--自定义异常
  age number := '&请输入您的年龄';
begin
  if age > 100 or age < 0 then
    raise age_outof_range;
  else
    dbms_output.put_line('年龄:' || age);
  end if;
exception
  when age_outof_range then
    dbms_output.put_line('被我捕获到了');
end;

declare
  age number := '&请输入您的年龄';
begin
  if age > 100 or age < 0 then
    raise_application_error(-20001,'年龄超出范围');
  else
    dbms_output.put_line('年龄:' || age);
  end if;
/*exception
  when others then
    dbms_output.put_line('被我捕获到了');*/
end;
    




--预定义异常详细列表
access_into_null 在未初化对象时出现
case_not_found 在CASE语句中的选项与用户输入的数据不匹配时出现
collection_is_null 在给尚未初始化的表或数组赋值时出现
cursor_already_open 在用户试图打开已经打开的游标时出现
dup_val_on_index 在用户试图将重复的值存在使用唯一索引的数据库列中时出现
invalid_cursor 在执行非法游标运算（如打开一个尚未打开的游标）时出现
invalid_number 在将字符串转换为数字时出现
login_denied 在输入的用户名或密码无效时出现
no_data_found 在表中不存在的请求的行时出现，此外，当程序引用已经删除的元素时
storage_error 在内存损坏或PL/SQL耗尽内存时出现
too_many_rows 在执行SELECT INTO语句后返回多行时出现
value_error 在产生大小限制错误时出现
zero_divide 以零作除数时出现
others所有异常
