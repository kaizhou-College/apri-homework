----����ϰһ����
----��Scott�û���emp��Ϊ����Դ����дһ�����̸���Ա��������Ա��������нˮ����Ҫ��Ա��������нˮ��Ϊ���������
create or replace procedure 
       name7Sal(epno in emp.empno%type,namep out emp.ename%type,salp out emp.sal%type)    
as
begin
     
     select ename ,sal into namep,salp from emp where empno=epno;
     dbms_output.put_line('Ա������:   '||namep||'Ա������:   '||salp);
         --  exception 
             --    when no_data_found then
              --        RAISE_APPLICATION_ERROR(-20001,'������û�������');
end;

---����
declare
       nn emp.ename%type;
       ss emp.sal%type;
begin
       name7Sal('&������Ա�����',nn,ss);
      -- dbms_output.put_line(nn||'   '||ss);
end;      

     
-----����ϰ������
-----��Scott�û���emp��Ϊ����Դ����дһ����������Ա����ŷ���Ա������ְʱ�䡣
create or replace function
                             shijian(epno number)
return varchar                             
as
      sj emp.hiredate%type;
begin
      select hiredate into sj from emp where empno=epno;
      return sj;
      dbms_output.put_line('Ա�����   '||epno||'��ְʱ��   '||sj);
end;


--����
declare 
      shij emp.hiredate%type;
begin
      shij :=shijian('&������Ա�����');
      dbms_output.put_line('Ա����ְʱ��    '||shij);
end;


----����ϰ������
----������������ڳ�����ж���һ�������������Ա�����ٶ���һ��������������Ա������ж�Ա���Ƿ���ڡ�
----��Ҫ�����û�ִ����Ӳ���֮ǰ���ȵ��ú����жϸ�Ա���Ƿ���ڣ���������ڣ�����벢�ύ���ݣ�������ʾ��Ա���Ѵ��ڣ�

create








