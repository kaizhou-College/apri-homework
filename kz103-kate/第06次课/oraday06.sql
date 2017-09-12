procedure language/structure query language
  
���������� anonymous block��
declare
  str varchar2(10) := 'hello';--��������
begin
  dbms_output.put_line(str);--ִ�в���
  --exception--�쳣����
end;

����θ�ֵ��
--:= / select xx into xx
declare
  n1 number := 10;
  n2 number;
begin
  n2 := 20;
  select sal into n2 from emp where empno = 7499;--���ܷ��ض���
  dbms_output.put_line(n1 || '-' || n2);
end;

--��
begin
  dbms_output.put_line('hello');
end;

���������͡�
%type %rowtype
declare
  empname emp.ename%type; --��%typeǰ����е����Ϳ���
begin
  select ename into empname from emp where empno = 7499;
  dbms_output.put_line(empname);
end;

declare
  r emp%rowtype;--һ����Ϊһ����������
begin
  select * into r from emp where empno = 7499;
  --r.����û���Ⱥ�˳��
  dbms_output.put_line(r.empno || '-' || r.ename);
end;

��if�ṹ��
declare
  n1 number;
  n2 number;
begin
  n1 := '&�������һ������'; --�ַ�����ĩβ��Ҫ��ð��
  n2 := '&������ڶ�������';
  /*if n1 > n2 then
    dbms_output.put_line('����');
  end if;*/

  /*if n1 > n2 then
    dbms_output.put_line('����');
  else
    dbms_output.put_line('С�ڻ����');
  end if;*/

  if n1 > n2 then
    dbms_output.put_line('����');
  elsif n1 = n2 then
    dbms_output.put_line('����');
  else
    dbms_output.put_line('С��');
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
  eno emp.empno%type := '&������Ա����ţ�';
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

��case-when��
declare
  n number := '&������һ������';
begin
  case
    when n >= 80 then
      dbms_output.put_line('����');
    when n < 80 and n >= 60 then
      dbms_output.put_line('����');
    else
      dbms_output.put_line('��');
  end case;
end;


��ѭ����
declare
  n number := 1;
begin
  loop
    exit when n >= 5;--�˳�����
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
--i�ı仯��Χ��n1��n2��ÿ�μ�1
begin
  for i in reverse 1..5 loop
    dbms_output.put_line(i);
  end loop;
end;

���쳣��
declare
  r emp%rowtype;
begin
  select * into r from emp where empno=1;
exception 
  when no_data_found then
    dbms_output.put_line('�Ҳ�������');
end;

declare
  r emp%rowtype;
begin
  select * into r from emp;
exception
  when too_many_rows then
    dbms_output.put_line('̫����');
end;

declare
  n number := '&����';
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
    dbms_output.put_line('�����ظ���ֵ��unique index��');
end;

--select * from studentinfo where stucard=430a06198801010001;
declare
 ena studentinfo%rowtype;
begin
  select * into ena from studentinfo where stucard='&������';
exception
  when invalid_number then--?
    dbms_output.put_line('��Ч������');
end;

���Զ��塿
declare
  age_outof_range exception;--�Զ����쳣
  age number := '&��������������';
begin
  if age > 100 or age < 0 then
    raise age_outof_range;
  else
    dbms_output.put_line('����:' || age);
  end if;
exception
  when age_outof_range then
    dbms_output.put_line('���Ҳ�����');
end;

declare
  age number := '&��������������';
begin
  if age > 100 or age < 0 then
    raise_application_error(-20001,'���䳬����Χ');
  else
    dbms_output.put_line('����:' || age);
  end if;
/*exception
  when others then
    dbms_output.put_line('���Ҳ�����');*/
end;
    




--Ԥ�����쳣��ϸ�б�
access_into_null ��δ��������ʱ����
case_not_found ��CASE����е�ѡ�����û���������ݲ�ƥ��ʱ����
collection_is_null �ڸ���δ��ʼ���ı�����鸳ֵʱ����
cursor_already_open ���û���ͼ���Ѿ��򿪵��α�ʱ����
dup_val_on_index ���û���ͼ���ظ���ֵ����ʹ��Ψһ���������ݿ�����ʱ����
invalid_cursor ��ִ�зǷ��α����㣨���һ����δ�򿪵��α꣩ʱ����
invalid_number �ڽ��ַ���ת��Ϊ����ʱ����
login_denied ��������û�����������Чʱ����
no_data_found �ڱ��в����ڵ��������ʱ���֣����⣬�����������Ѿ�ɾ����Ԫ��ʱ
storage_error ���ڴ��𻵻�PL/SQL�ľ��ڴ�ʱ����
too_many_rows ��ִ��SELECT INTO���󷵻ض���ʱ����
value_error �ڲ�����С���ƴ���ʱ����
zero_divide ����������ʱ����
others�����쳣
