--��дһ��PL/SQL���룬�����û�����Ĳ��ű�š��������ƺͲ��ŵ�ַ��������뵽scott�û���dept���С�
--Ҫ��ʹ�ö�̬SQLʵ�֡�execute immediate 'sql���'
--using �����б� --ʹ�ò����ռλ����:name��
select * from dept
begin
        execute immediate 'insert into dept values(:v1,:v2,:v3)'
        using '&�����벿�ű��','&�����벿������','&�����벿�ŵ�ַ';



end;

--��ϰһ����ʽ�α꣨�α����ԣ�
--��������PL/SQL�飬�����û�����Ĳ��ű�ţ�����Ա�����ʡ�
--����ע�ʹ���ȫ����ʵ�֣�������³ɹ�����ʾ�û��ɹ������˶�������¼��������ʾ���Ų����ڡ�
declare
      dno number;
      tiao number;--��¼���µ�����
begin
      dno:='&�����벿�ű��';
        update emp set sal=sal+100 where deptno=dno;
        select count(*) into tiao from emp where deptno=dno;
       
      if sql%rowcount>0 then
        dbms_output.put_line('�ɹ�������'||tiao||'����¼');
       else
         dbms_output.put_line('���Ų�����');

       end if;
end;
--��ϰ������ʽ�α�
--ʹ����ʽ�α��дһ����������ʾscott�û���emp���dept���е�empno��ename��sal��deptno��dname����ֶ�ֵ��
declare
       cursor xian is select * from emp;--emp�����ʾ�α�
       cursor shi is select * from dept;--dept�����ʾ�α�
       eesdd emp%rowtype;--emp��ļ�¼�ͱ���
       ddsee dept%rowtype;--dept��ļ�¼�ͱ���

begin
       open xian;
       loop
            fetch xian into eesdd;
            exit when xian%notfound;
            dbms_output.put_line(eesdd.empno||'===='||eesdd.ename||'===='||eesdd.sal);
       
       end loop;
       close xian;
       dbms_output.put_line('======================');
        open shi;
         loop
             fetch shi into ddsee;
            exit when shi%notfound;
            dbms_output.put_line(ddsee.deptno||'===='||ddsee.dname);
         
         end loop;
       close shi;
end;
--��ϰ����ѭ���α� for
--��д��������ʾ���������ƺ͸ò��Ű�����Ա��������Ҫ��ʹ����ʽ��ѭ���α�ʵ�֡�
--Ч�����£�


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
--��userInfo.dmp�ļ��е����ݵ��뵽Scott�û��£����а���UserInfo��
--����UserInfo���пͻ����뱻�����ˣ����������дPL/SQL��䣬�������������û������룬Ҫ���������Ϊ6λ����
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
select * from UserInfo
--��ϰ�塢REF�α�
--��Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
--����û����롮E������ʾemp���е�empno��ename�е�ֵ������û����롮D������ʾdept���е�deptno��dname�е�ֵ��

declare
      type myref is ref cursor;
      myval myref;
       bm varchar2(20):='&���������';
       v1 number;
       v2 varchar2(20);
      
begin
       if bm='E' then
                open myval for select empno,ename from emp ;
       else
                open myval for select deptno,dname from dept;
       
       end if;
       loop
           fetch myval into v1,v2;
           exit when myval%notfound;
           dbms_output.put_line(v1||'===='||v2);

       end loop;
end;

