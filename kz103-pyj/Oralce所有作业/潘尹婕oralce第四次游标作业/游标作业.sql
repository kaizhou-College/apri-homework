--�����û�����Ĳ��ű�ţ�����Ա�����ʡ�
--������³ɹ�����ʾ�ɹ������˶�������¼��������ʾ���Ų����ڡ�
declare
  dno number;
begin
  dno:='&dno';
  update emp set sal=sal+100 where deptno=dno;
  if sql%isopen=false then
     dbms_output.put_line('�α�ر�');
  end if;
  if sql%found  then 
     dbms_output.put_line('������'||sql%rowcount||'��');
  else 
     dbms_output.put_line('���Ų�����');
  end if;
end;

select deptno,sal from emp;
--ʹ����ʽ�α��дһ����������ʾscott�û���emp���dept���е�
--empno��ename��sal��deptno��dname����ֶ�ֵ��
declare 
       cursor mytable is select empno,ename,sal,dept.deptno,dname from emp,dept
       where emp.deptno=dept.deptno;     
begin
       for r in mytable
       loop
            dbms_output.put_line(r.empno||'---'||r.ename||'---'||r.sal||'---'||r.deptno||'---'||r.dname);
       end loop;
end;

--��д��������ʾ���������ƺ͸ò��Ű�����Ա��������Ҫ��ʹ����ʽ��ѭ���α�ʵ�֡�
select * from emp;
declare 
         cursor empdeptno is select emp1.deptno dept,dept1.dname from emp emp1 inner join dept dept1
               on emp1.deptno=dept1.deptno;
         cursor depstsum(deptno2 number) is select ename from emp where deptno= deptno2;
begin
      for s in empdeptno
      loop
          dbms_output.put_line('���ű�ţ�'||s.dept||'����:'||s.dname);                 
      
      for r in depstsum(s.dept)
          loop
          dbms_output.put_line('Ա��:'||depstsum%rowcount||r.ename);
          end loop;
        end loop;
end;
----��userInfo.dmp�ļ��е����ݵ��뵽Scott�û��£����а���UserInfo��
--����UserInfo���пͻ����뱻�����ˣ����������дPL/SQL��䣬
--�������������û������룬Ҫ���������Ϊ6λ����
declare
	cursor pass is  select * from userinfo for update of password;
  num number:=round(dbms_random.value(100000,999999));
begin
   for user in pass
   loop
		update userinfo set password=num where current of pass;      
   end loop;
end;

--��Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
--����û����롮E������ʾemp���е�empno��ename�е�ֵ������û����롮D������ʾdept���е�deptno��dname�е�ֵ��
declare
    cursor myscott is select * from dept;                    
    mytable sys_refcursor;
    tablename varchar2(10):='&�������' ;
    name1 number;
    name2 varchar2(20);
begin
        if tablename='E' then
           open mytable for select empno,ename from emp;
     else 
          open mytable for select deptno,dname from dept;
     end if; 
  loop
      fetch mytable into name1,name2;
            dbms_output.put_line(name1||'-----'||name2);
            exit when mytable%notfound;
  end loop;
end;
