--������������˾������ְԱ��emp�����Ž��𣬷���ԭ�����ְԱ���ڲ��ű�ţ�deptno�������㡣
--������ű��Ϊ��10��������Ϊ2000Ԫ�����ű��Ϊ��20��������Ϊ1700Ԫ�����ű��Ϊ��30��������Ϊ1500Ԫ�����������ṹ��������⡣
declare
  dno emp.deptno%type;
  eno emp.empno%type:='&������Ա�����';
begin
  select deptno into dno from emp where empno = eno;
  if dno=10 then
    update emp set sal=sal+2000 where empno = eno;
  elsif dno=20 then
    update emp set sal=sal+1700 where empno = eno;
  else
    update emp set sal=sal+1500 where empno = eno;
  end if;
  commit;
end
--�������������дһ������ͨ��ѭ����course_details���в���10������¼��Ҫ��ѧ�����ÿ���ۼ�1���γ����û����롣
declare
  c varchar2(15);
Begin
For  i in  1..10
Loop
     c :='&�����Ŀ';
   insert into course_details values(i,c);
End loop;
End;
--��ϰ������дһ��������ʾ1��100֮�����������������
--��ʾ��
--1����������������ֻ�ܱ�1�ͱ�������������
--2��ʹ��forѭ��
declare
    i number(4);--�洢1-100�����е�����������������
    j number(4) := 1;--�洢����
    z number(4) := 0;--�洢�������Ĵ���;
begin
    for i in 1..100 loop
        while j <= i loop
            if mod(i,j) = 0 then 
                z := z + 1;
            end if;
            j := j + 1;
        end loop; 
        j := 0;
        if z = 2 then 
            dbms_output.put_line(i);         
        end if;  
        z := 0; 
    end loop;
end;

--��ϰ�ġ���userInfo.dmp�ļ��е����ݵ���Scott�û��£����ļ��а���UserInfo�û���Ϣ���ṹ���£�
declare
    sevenzero number(4);
    eightzero number(4);
    ninezero number(4);
    alls number(4);
begin
    select count(*) into sevenzero from userInfo where extract(year from birthday)>=1970 and extract(year from birthday)<1980;
    select count(*) into eightzero from userInfo where extract(year from birthday)>=1980 and extract(year from birthday)<1990;
    select count(*) into ninezero from userInfo where extract(year from birthday)>=1990 and extract(year from birthday)<1999;
    alls :=ninezero+eightzero+sevenzero;
    dbms_output.put_line(round((sevenzero/alls)*100,2)||'%');
    dbms_output.put_line(round((eightzero/alls)*100,2)||'%');
   dbms_output.put_line(round((ninezero/alls)*100,2)||'%');
end;
--���scott�û���emp����дһ��PL/SQL���룬���ݽ��յ�Ա����Ų�ѯԱ�����������������洢�ڱ���empname�С�
--������Ҫ�󽫱�������Ϊvarchar2(4)���ͣ����ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ��ȣ�
--������Value_Error�쳣������쳣���д������û���ʾ��Ϣ��
declare
   empname varchar2(4);
   empnos number:='&������Ա�����';
begin
   select ename into empname from emp where empno=empnos;
   dbms_output.put_line(empname);
exception
    when Value_Error then
   dbms_output.put_line('���Ҳ�����');
end;
select * from emp






















