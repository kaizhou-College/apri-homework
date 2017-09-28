ʹ�ú����͹���ʵ�ַ�ҳ��ѯ���߼�

ΪʲôҪʹ�ú������߹���
ִ��SQL�Ĺ���
1������
2��ִ��
3��ȡ��
4������

�����͹��̵��߼�����Ԥ�ȷ�װ�ã������Ѿ������ݿ������ܹ�ֱ��ִ�е�
���룬���ִ�к����͹���ֻ��Ҫ2.3.4

���Զ���洢���̡�
create procedure sayhello as
begin
  dbms_output.put_line('hello');
end;

ִ�У�
--��ʽһ
sql>execute ������
--��ʽ��
begin
  sayhello;
end;
--��ʽ������Ҫ��
JDBC���á�����

--�������Ĺ���
��in��
create procedure calcavgsal(dno in number) as
  avgs number;
begin
  select avg(sal) into avgs from emp where deptno = dno;
  dbms_output.put_line(avgs);
end;

begin
  calcavgsal(10);
end;

��out�������͡�
create procedure calcavgsal2(dno in number, avgs out number) as
begin
  select avg(sal) into avgs from emp where deptno = dno;
end;

declare
  n number;--�ڵ��÷���׼����һ������
begin
  calcavgsal2(20, n);
  dbms_output.put_line(n);
end;

--���out��������return��ȥ�ģ����ǵ��÷���������ִ�з���ֵ�Ժ�
--����ȥ��

��in out �������Ͳ�����--���Ƽ�����
create procedure calcavgsal3(x in out number) as
begin
  select avg(sal) into x from emp where deptno = x;
end;

declare
  n number := 30; --�ڵ��÷���׼����һ������
begin
  calcavgsal3(n);
  dbms_output.put_line(n);
end;

--����������������/����
create or replace procedure print(s in varchar2) as
begin
  dbms_output.put_line(s);
end;


begin
  print('jack');
end;

create or replace procedure swap(n1 in out number, n2 in out number) as
  tmp number;
begin
  tmp := n1;
  n1  := n2;
  n2  := tmp;
end;


declare
  n1 number := 3;
  n2 number := 7;
begin
  swap(n1, n2);
  dbms_output.put_line(n1);
  dbms_output.put_line(n2);
end;

���Զ��庯����
create or replace function getempname(eno number) return varchar2 as
  ena emp.ename%type;
begin
  select ename into ena from emp where empno = eno;
  return ena;
  exception
     when no_data_found then
       return 'û���ҵ����ݰ�';
end;
--select * from emp where empno=empno;

select getempname(1) from dual;

--��Ȼ����������������ֲ�ͬ�Ķ�������
--�������߹���һ�������ռ�
create or replace procedure getempname as
begin
  null;--�����
end;

���������
Ϊ�˽��������ͻ�����⣬���Խ������͹��̶�����package��
--������Ĺ淶�����߱���������ʲô
create or replace package java30522 as
  procedure calcavgsal2(dno in number, avgs out number);
  function getempname(eno number) return varchar2;
end;

create or replace package body java30522 as

  procedure calcavgsal2(dno in number, avgs out number) as
  begin
    select avg(sal) into avgs from emp where deptno = dno;
  end;

  function getempname(eno number) return varchar2 as
    ena emp.ename%type;
  begin
    select ename into ena from emp where empno = eno;
    return ena;
  exception
    when no_data_found then
      return 'û���ҵ����ݰ�';
  end;
end;
--1�����淶�Ͱ���ʵ�����Ʊ���һ��
--2�����淶��ʵ���д�ŵĶ������Ҫһ��
--  ����һ�¡�������һ�¡������б�һ��
declare
  avgs number;
begin
  calcavgsal2(10, avgs);
  dbms_output.put_line(avgs);
  java30522.calcavgsal2(10, avgs);
  dbms_output.put_line(avgs);
end;

select '������' || java30522.getempname(7788) from dual;


--���ݴ��ݵı���(varchar2)�����α�(��ȡ���¼��ָ��)
create or replace procedure querytable(tablename in varchar2,
                                       cur       out sys_refcursor) as
begin
  open cur for 'select * from ' || tablename;
end;

declare
  cur sys_refcursor;
  r   dept%rowtype;
begin
  querytable('dept', cur);
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.deptno || r.dname);
  end loop;
  close cur;
end;

--��ҳ�洢����
create or replace procedure querypage(n1  in number,
                                      n2  in number,
                                      cur out sys_refcursor) as
begin
  open cur for
    select *
      from (select e.*, row_number() over(order by sal) rn from emp e)
     where rn between n1 and n2;
end;

--��ҳ���
select *
      from (select e.*, row_number() over(order by sal) rn from emp e)
     where rn between 5 and 8;




