----����ϰһ��ʹ�������ṹ��
----������������˾������ְԱ��emp�����Ž���
----����ԭ�����ְԱ���ڲ��ű�ţ�deptno�������㡣
----������ű��Ϊ��10��������Ϊ2000Ԫ�����ű��Ϊ��20����
----����Ϊ1700Ԫ�����ű��Ϊ��30��������Ϊ1500Ԫ�����������ṹ��������⡣

select deptno from emp
declare 
       num number;
       deptnum emp.deptno%type;
begin 
       num :='&ְԱ���';
       select deptno into deptnum from emp where empno=num;
       dbms_output.put_line(deptnum);
      if deptnum = 10 then 
        update emp set comm=nvl(comm,0)+2000 where deptno = deptnum;
      elsif deptnum = 20 then 
        update emp set comm = nvl(comm,0)+1700 where deptno = deptnum;
      else 
         update emp set comm = nvl(comm,0)+1500 where deptno = deptnum;
      end if;
      commit;
end;
select * from emp;

----����ϰ����ʹ��ѭ���ṹ��
--�������������дһ������ͨ��ѭ����course_details���в���10������¼��
--Ҫ��ѧ�����ÿ���ۼ�1���γ����û����롣
create table course_details
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
         dbms_output.put_line('---------'||countid||cousestr);
       end loop;
end;


----��ϰ������дһ��������ʾ1��100֮�����������������
--��ʾ��
--1����������������ֻ�ܱ�1�ͱ�������������
--2��ʹ��forѭ��
--����һ
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


----��ϰ�ġ���userInfo.dmp�ļ��е����ݵ���Scott�û���
--�����ļ��а���UserInfo�û���Ϣ�����дPL/SQL�飬
--ͳ��70��80��90���û���������ռ���������͵ı�
declare 
    num1 number;
    num2 number;
    num3 number;
    total number;
begin
    select count(*) into num1 from userinfo where substr(extract(year from birthday),3,1) ='7';
    select count(*) into num2 from userinfo where substr(extract(year from birthday),3,1) ='8';
    select count(*) into num3 from userinfo where substr(extract(year from birthday),3,1) ='9';
    total :=num1+num2+num3;
    dbms_output.put_line('70�����'||num1);
    dbms_output.put_line('80�����'||num2);
    dbms_output.put_line('90�����'||num3);
    dbms_output.put_line('70��ռ�����͵ı�'||trunc((num1/total*100),2)||'%');
    dbms_output.put_line('80��ռ�����͵ı�'||trunc((num2/total*100),2)||'%');
    dbms_output.put_line('90��ռ�����͵ı�'||trunc((num3/total*100),2)||'%');
end;
   
----��ϰ�塢ʹ��Ԥ�����쳣
--���scott�û���emp����дһ��PL/SQL���룬
--���ݽ��յ�Ա����Ų�ѯԱ�����������������洢�ڱ���empname�С�
--������Ҫ�󽫱�������Ϊvarchar2(4)���ͣ����ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ���
--��������Value_Error�쳣������쳣���д������û���ʾ��Ϣ��
declare 
	empname varchar2(4);
	empno :='&Ա�����';
begin
	select ename into empname from userinfo wnere empno=empno1 ;
	exception
		when Value_Error then
			dbms_output.put_line('ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ���');
end;
