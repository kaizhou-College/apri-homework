----1,�����û�����Ĳ��ű�ţ�����Ա������
declare
  dno number;
begin
  dno:='&dno';
  update emp set sal=sal+100 where deptno=dno;
  if sql%found then
     dbms_output.put_line('���ű��'||dno||'���˹���'||'��'||sql%rowcount||'�����˹���');
   else
     dbms_output.put_line('���Ų�����');
   end if;
end;

----2,ʹ����ʽ�α��дһ����������ʾscott�û���emp���dept����
----��empno��ename��sal��deptno��dname����ֶ�ֵ��
select * from emp
select * from dept

declare
      cursor em is select * from emp;
      cursor dp(dno number) is select dname from dept where deptno=dno;
      emm emp%rowtype;
      dpp dept%rowtype;
begin
 dbms_output.put_line('empno-----------ename----------sal---------deptno-----------dname');
     for emm in em
      Loop
         for dpp in dp(emm.deptno)
             Loop
                 dbms_output.put_line(emm.empno||'------------'||emm.ename||'--------'||emm.sal||'------------'||emm.deptno||'------------'||dpp.dname);
             end loop;
      end loop;
     
end;

----3,��д��������ʾ���������ƺ͸ò��Ű�����Ա��������Ҫ��ʹ����ʽ��ѭ���α�ʵ�֡�

select * from dept
select * from emp

declare
       cursor gs is select * from dept;
       em emp%rowtype;
       pt dept%rowtype;
       cursor emm(dno number) is select ename from emp where deptno=dno; 
       num number:=1;

begin
       for pt in gs
       loop
       dbms_output.put_line('--------------------------------');
       dbms_output.put_line('���ű��:'||pt.deptno||'��������'||pt.dname);
          for em in emm(pt.deptno)
             Loop
                    dbms_output.put_line('Ա��'||num||':'||em.ename);
                    num:=num+1;
             end loop;
       end loop;
end;


----4,��userInfo.dmp�ļ��е����ݵ��뵽Scott�û��£����а���UserInfo��
----����UserInfo���пͻ����뱻�����ˣ����������дPL/SQL��䣬
----�������������û������룬Ҫ���������Ϊ6λ����

select * from userinfo
select * from dual

declare
  cursor sj is select * from dual;
  user userinfo%rowtype;
begin
  for user in sj
      loop
           update userinfo set(password) = round(dbms_random.value(100000,1000000));
           if sql%rowcount>0 then
              dbms_output.put_line('�ɹ�'); 
           else
              dbms_output.put_line('ʧ��');
           end if;  
      end loop;      
end;

----5,��Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
----����û����롮E������ʾemp���е�empno��ename�е�ֵ��
----����û����롮D������ʾdept���е�deptno��dname�е�ֵ��
declare
  cursor aa is select * from dept;                    
  myval sys_refcursor;
  bm varchar2(10):='&�������' ;
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
