--��ϰһ��
--��Scott�û���emp��Ϊ����Դ����дһ�����̸���Ա��������Ա��������нˮ����Ҫ��Ա��������нˮ��Ϊ���������
create or replace procedure que(empnos number,ename out varchar2,sal out number) as
begin
       select ename,sal into ename,sal from emp where empno=empnos;
end;

declare
       ename varchar2(10);
       sal number;
begin
       que(7369,ename,sal);
       dbms_output.put_line(sal||'--------'||ename);
end;

--��ϰ����
--��Scott�û���emp��Ϊ����Դ����дһ����������Ա����ŷ���Ա������ְʱ�䡣
create or replace function worktwo(empnos number)
return date
as
dates emp.hiredate%type;
begin
      select hiredate into dates from emp where empno=empnos;
      return dates;
end;

declare
      empnos number;
begin
      empnos :='&������Ա�����';
      dbms_output.put_line(worktwo(empnos));
end;

--��ϰ����
--������������ڳ�����ж���һ�������������Ա����
--�ٶ���һ��������������Ա������ж�Ա���Ƿ���ڡ�
--��Ҫ�����û�ִ����Ӳ���֮ǰ���ȵ��ú����жϸ�Ա���Ƿ���ڣ�
--��������ڣ�����벢�ύ���ݣ�������ʾ��Ա���Ѵ��ڣ�
create or replace function workthree(empnos number)
return varchar2
as
ena emp.ename%type;
begin
  select ename into ena from emp where empno = empnos;
  return '���û��Ѵ���';
  exception
     when no_data_found then
       return '��ӳɹ����ı����'||empnos;
end;

begin
       dbms_output.put_line(workthree(736));
end;

--��ϰ�� �����Ͽδ�����ɣ�
--��Scott�û���emp��Ϊ����Դ����д��ҳ�Ĵ洢���̣�Ҫ���뿪ʼ�ͽ������д���ʾ����������αꡣ
--����ʾ�����ڳ�����ж����α����ͣ��������α������Ϊ���������
create or replace procedure fneye(n1 in number,n2 in number,cur out sys_refcursor) as
begin
open cur for select * from(select e.*, row_number() over(order by sal) rn from emp e)
where rn between n1 and n2;
end;

select * from (select e.*, row_number() over(order by sal) rn from emp e) where rn between 5 and 15;

--��ϰ�塢
--�����˵������£�

