----��˾������ְԱ��emp�����Ž��𣬷���ԭ�����ְԱ���ڲ��ű�ţ�deptno�������㡣
----������ű��Ϊ��10��������Ϊ2000Ԫ�����ű��Ϊ��20��������Ϊ1700Ԫ�����ű��Ϊ��30��������Ϊ1500Ԫ�����������ṹ��������⡣
select * from emp
declare
  dno emp.deptno%type;
  eno emp.empno%type := '&������Ա����ţ�';
begin
  select deptno into dno from emp where empno = eno;
  if dno = 10 then
    update emp set sal = sal + 2000 where empno = eno;
  elsif dno = 20 then
    update emp set sal = sal + 1700 where empno = eno;
  else
    update emp set sal = sal + 1500 where empno = eno;
  end if;
  commit;
end;

----���дһ������ͨ��ѭ����course_details���в���10������¼��Ҫ��ѧ�����ÿ���ۼ�1���γ����û����롣
select * from course_detailss
create table course_detailss
(
	stuid number,--ѧԱ���
	course varchar2(20)--���γ�
);

declare 
         countid number :=0;--���
         cousestr course_details.course%type;---�γ�
begin
       while(countid<10)
       loop
         countid :=countid+1;
         cousestr :='&������γ�';
         insert into course_details values(countid,cousestr);
         commit;
       end loop;
end;


----��ϰ������дһ��������ʾ1��100֮�����������������


declare
    a number(4);--������
    b number(4) := 1;--����
    c number(4) := 0;--�������Ĵ���;
begin
    for a in 1..100 loop
        while b <= a loop
            if mod(a,b) = 0 then 
                c := c + 1;
            end if;
            b := b + 1;
        end loop; 
        b := 0;
        if c = 2 then 
            dbms_output.put_line(a);         
        end if;  
        c := 0; 
    end loop;
end;

----��ϰ�ġ����дPL/SQL�飬ͳ��70��80��90���û���������ռ���������͵ı�����

select * from userinfo
declare 
       a70 number;
       a80 number;
       a90 number;
       a number ;
begin
       select count(*) into a from userinfo ;
       select count(*) into a90 from userinfo where Extract(year from birthday )>= 1990 and extract(year from birthday)<2000;
        select count(*) into a80 from userinfo where Extract(year from birthday )>= 1980 and Extract(year from birthday )<1990;
         select count(*) into a70 from userinfo where Extract(year from birthday )>= 1970 and Extract(year from birthday )<1980;
        dbms_output.put_line('70���ܹ�'||a70||'��');
       dbms_output.put_line('80���ܹ�'||a80||'��');
       dbms_output.put_line('90���ܹ�'||a90||'��');
      dbms_output.put_line('70��ռ'||round(a70/a*100,2)||'%');
      dbms_output.put_line('80��ռ'||round(a80/a*100,2)||'%');
      dbms_output.put_line('90��ռ'||round(a90/a*100,2)||'%');
end;

----���scott�û���emp����дһ��PL/SQL���룬���ݽ��յ�Ա����Ų�ѯԱ�����������������洢�ڱ���empname�С�
----������Ҫ�󽫱�������Ϊvarchar2(4)���ͣ����ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ��ȣ�
----������Value_Error�쳣������쳣���д������û���ʾ��Ϣ��
declare
      empname varchar2(4);
      num number:='&Ա�����';
begin
       select ename into empname from emp where empno=num;
       dbms_output.put_line('Ա��������'||empname);
exception
       when Value_Error then
        dbms_output.put_line('������������');
end;
