----����ϰһ����ʽ�α꣨�α����ԣ���
----�����û�����Ĳ��ű�ţ�����Ա�����ʡ�
----������³ɹ�����ʾ�û��ɹ������˶�������¼��������ʾ���Ų����ڡ�
declare 
  dno number;
  updatenum number;---��ʾ�û��ɹ������˶�������¼
begin 
  loop
  exit when sql%notfound;
  dno :='&dno';
  update emp set sal = sal+100 where deptno=dno;
  select count(deptno) into updatenum from emp where deptno = 10;
  if sql%rowcount>0 then 
     dbms_output.put_line('�û�������'||updatenum||'������');
  else
        dbms_output.put_line('���Ų�����');
   end if;
   commit;
  end loop;
end;
select * from dept;




----����ϰ������ʽ�α꡿
----ʹ����ʽ�α��дһ����������ʾscott�û���emp���dept���е�
----empno��ename��sal��deptno��dname����ֶ�ֵ��
create view view1
       as select a.*,b.dname,b.loc from emp a ,dept b where a.deptno=b.deptno
declare 
       cursor come is select * from view1;
       rrow view1%rowtype;
begin
       open come;
       loop 
            fetch come into rrow;
            exit when come%notfound ;
            dbms_output.put_line(rrow.empno||rrow.ename||rrow.sal||'------'||rrow.deptno||rrow.dname);
       end loop;
end; 

 select count(deptno)  numno1 from emp group by deptno

----����ϰ����ѭ���α� for��
----��д��������ʾ���������ƺ͸ò��Ű�����Ա��������Ҫ��ʹ����ʽ��ѭ���α�ʵ�֡�
declare 
         cursor bm is select dname,deptno from dept;
         cursor em(dno number) is select ename from emp where deptno = dno;
         deptrow dept%rowtype;
         empnum emp%rowtype;
         numno number :=1;
begin
         for deptrow in bm
         loop
             dbms_output.put_line('���ű��:'||deptrow.deptno||'��  ����:'||deptrow.dname);
             for empnum in em(deptrow.deptno)
                 loop
                        dbms_output.put_line('Ա��'||numno||':'||empnum.ename);
                        numno := numno+1;
                 end loop;
          exit when bm%notfound;
         end loop;
end;



----����ϰ�ġ�ʹ���α�������ݡ�
---��userInfo.dmp�ļ��е����ݵ��뵽Scott�û��£����а���UserInfo������UserInfo��
---�пͻ����뱻�����ˣ����������дPL/SQL��䣬�������������û������룬Ҫ�������
--��Ϊ6λ����
---��ʾ��dbms_random������ṩ������������ķ�����
declare 
         cursor mycursor is
                select password from userinfo for update;
         mm userinfo.password%type;
begin
         for rs in mycursor
         loop
             select floor(dbms_random.value(100000,999999)) into mm from dual;
             update userinfo set password =mm
             where current of mycursor;
         end loop;
end;

select * from userinfo;



----����ϰ�塢REF�α꡿
--��Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
--����û����롮E������ʾemp���е�empno��ename�е�ֵ��
--����û����롮D������ʾdept���е�deptno��dname�е�ֵ��

declare 
        type myref is ref cursor;
        myval myref;
        sj varchar2(10) :='&�������';
        numno number;
        namestr varchar2(20);      
begin 
        if sj='E' then
           open myval for select empno,ename from emp;
        else
           open myval for select deptno,dname from dept;
        end if;
        loop
            fetch myval into numno,namestr;
                  dbms_output.put_line(numno||'----'||namestr);
            exit when myval%notfound;
        end loop; 
end;





