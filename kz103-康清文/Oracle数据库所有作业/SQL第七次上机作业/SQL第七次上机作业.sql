--��ϰһ����ʽ�α꣨�α����ԣ�
--��������PL/SQL�飬�����û�����Ĳ��ű�ţ�����Ա�����ʡ�
declare
    dno number;
    cursor cur is select * from emp where deptno='&�����벿�ű��';
begin
 
   update emp set sal=sal+100 where deptno=dno;
   if sql%found then
      dbms_output.put_line('���³ɹ�');
   else
      dbms_output.put_line('����ʧ��');
   end if;
end;


--��ϰ������ʽ�α�
--ʹ����ʽ�α��дһ����������ʾscott�û���emp���dept���е�empno��ename��sal��deptno��dname����ֶ�ֵ��
create view m
       as select a.empno,a.ename,a.job,a.mgr,a.hiredate,a.sal,a.comm,a.deptno,b.dname,b.loc from emp  a,dept b where a.deptno=b.deptno
      
declare
       cursor dbp is select * from m;
       emprow m%rowtype; ---��¼�ͱ���
begin
       --1,��
       open dbp;
       --2,��ȡ��
       loop
            fetch dbp into emprow;
          
            exit when dbp%notfound;
         
            dbms_output.put_line(emprow.empno||'---'||emprow.ename||'---'||emprow.sal||'---'||emprow.deptno||'---'||emprow.dname);
         
       end loop;
       --3,�ر�
       close dbp;
end;



--��ϰ����ѭ���α� for
--��д��������ʾ���������ƺ͸ò��Ű�����Ա��������Ҫ��ʹ����ʽ��ѭ���α�ʵ�֡�

declare
      s varchar2(10);
      cursor dno is select * from dept;
      cursor eno(no emp.deptno%type) is select ename from emp where deptno=no;
begin
      for r in dno
       loop
          dbms_output.put_line('���ű�ţ�'||r.deptno||'�������ƣ�'||r.dname);
          for s in eno(r.deptno)
              loop
                   dbms_output.put_line('Ա��'||eno%rowcount||':'||s.ename);
              
              end loop;
      end loop;
end;


--��ϰ�ġ�ʹ���α��������
--��userInfo.dmp�ļ��е����ݵ��뵽Scott�û��£����а���UserInfo������UserInfo���пͻ����뱻�����ˣ�
--���������дPL/SQL��䣬�������������û������룬Ҫ���������Ϊ6λ����
--��ʾ��dbms_random������ṩ������������ķ�����
--ʾ����select dbms_random.value(0,100) from dual;����0-100֮��������

declare
            rand UserInfo.Password%type;
            cursor pw is select password from UserInfo for update;--����һ��pw�α�

begin
             
            
            for r in pw
                loop
                  select floor(dbms_random.value(100000,999999)) into rand from dual;
                  update UserInfo set password=rand where current of pw;
                  
                end loop;
end;
  




--��ϰ�塢REF�α���Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
--����û����롮E������ʾemp���е�empno��ename�е�ֵ������û����롮D������ʾdept���е�deptno��dname�е�ֵ��
declare
  cursor aa is select * from dept;                    

  myval sys_refcursor;
  bm varchar2(10):='&���������' ;
  v1 number;
  v2 varchar2(20);
begin

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









       
