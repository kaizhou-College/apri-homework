���α�cursor��
begin
  --DML
  select * from emp;
end;

--��plsql����ֻ��ִ��DML����������������һ�Ĳ�ѯ��
--Ҫ��ѯ���������α�
--�ڲ�ѯ���ݵ�ʱ�򣬻�ȡ�Ľ����ͨ��cursor���б��α��ȡ

����ʽ�α꡿
ִ��DML���ʱ����oracle�Զ����õģ�����Ҫ�����Ԥ
begin
  update emp set sal=sal+1 where deptno=10;
  dbms_output.put_line(sql%rowcount);
  commit;--�ύ�Ժ�ᵼ�����Ե�ֵ���ͷźͻ��յ�
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

--��Ϊ�����ʽ�α꣨sql������oracle�������ģ�
--���Կ�����״̬һ�㶼��Ϊ���رա�
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
--�α��ڴ������ݵ�ʱ�����������и����׶ε��������
--www.avast.com.cn
--1������
--2������
--3��ȡ��
--4���ر�

����ʽ�α꡿
declare
  cursor cur is
    select * from dept; --����
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

��ʼ״̬��ָ���ѯ�����һ����¼���Ϸ�
���������ƶ�һ��
(������һ��û�����ݣ���һ�ζ�ȡ��ֵ��Ȼ������r������)
��ȡ���ݣ�Y��%found =true N:%notfound=true
--Ҫע��fetch�����ж���һ���Ƿ������ݣ�
--�����жϵ�ǰ�α����޶�ȡ������

--�α��ӦJDBC�е�Statement����(1:1),Ĭ��ֻ�ܿ���300��

--������������ʾ�α꡿
declare
   cursor cur is select * from emp where deptno='&�����벿�ű��';
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
  open cur(30, 2000); --�ڿ����α��ͬʱ���βθ�ֵ
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.empno || '-' || r.ename);
  end loop;
  close cur;
end;

�������ѭ���α��д������for��
--�α��open��close��for����
declare
  cursor cur(dno number) is
    select * from emp where deptno = dno;
begin
  --r�൱���б�����������ʱ���Զ�������ֵһ��cur��ȡ��������
  for r in cur(10) loop
    dbms_output.put_line(r.empno || '-' || r.ename);
  end loop;
  --close cur;--�����ظ��ر�cursor
  /*if cur%isopen then
    dbms_output.put_line(1);
  end if;*/
end;

--�ܷ��α���������ݣ���begin-end����������

��ref �α꡿
--�������������������������ڼ������ͬ�ı�
declare
  type tcur is ref cursor; --����ref�α�������ͣ�ref�α�������ͣ�
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
  --ͨ��for�Ӿ�ָ��һ���µ�������
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
  --sys_refcursor��oracle�Դ���һ��ref cursor��������(������)
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

--��ȡĳһ�����ŵ�Ա������
declare
  cursor cur(dno number) is
    select * from emp where deptno = dno;
begin
  for r in cur('&���ű��') loop
    dbms_output.put_line(r.ename || '-' || r.sal);
  end loop;
end;

declare
  cur sys_refcursor;
  r   emp%rowtype;
begin
  open cur for
    select * from emp where deptno = '&���ű��';
  loop
    fetch cur
      into r;
    exit when cur%notfound;
    dbms_output.put_line(r.ename || '-' || r.sal);
  end loop;
  close cur;
end;

��ʹ���α���ִ��DML��
declare
  cursor cur is select * from emp for update;
  r emp%rowtype;
begin
  open cur;
  loop
    fetch cur into r;
    exit when cur%notfound;
    --current of cur��ʾ�α굱ǰץȡ����һ��
    update emp set sal=sal+1 where current of cur;
  end loop;
  commit;
  close cur;
end;

��ִ�ж�̬SQL��
begin
  --execute immediate 'select * from emp';--ִ�в�ѯ
  --immediate����
  execute immediate 'create table t30522(tid number)';
end;

--���ref�α�
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

--������
--create table xxx(sid number,sqlstr varchar2(100));
--��������sql
--��plsql��ʹ��forѭ������ȡÿһ��sql���
--Ȼ��ִ�У�execute immediate��













