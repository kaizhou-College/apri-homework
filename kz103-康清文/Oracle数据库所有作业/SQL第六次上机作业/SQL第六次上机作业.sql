--��ϰһ��ʹ�������ṹ
--������������˾������ְԱ��emp�����Ž��𣬷���ԭ�����ְԱ���ڲ��ű�ţ�deptno�������㡣
--������ű��Ϊ��10��������Ϊ2000Ԫ�����ű��Ϊ��20��������Ϊ1700Ԫ�����ű��Ϊ��30��������Ϊ1500Ԫ��
--���������ṹ��������⡣

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



--��ϰ����ʹ��ѭ���ṹ
--�������������дһ������ͨ��ѭ����course_details���в���10������¼��Ҫ��ѧ�����ÿ���ۼ�1���γ����û����롣
create table course_details
(
	stuid number,--ѧԱ���
	course varchar2(20)--�γ�
);

select * from course_details
declare 
       num number;
       course varchar2(40);
begin
       
    for num in 1..10
        course  :='&������γ�����';
            dbms_output.put_line(num||'--------'||course);
            insert into course_details values(num,course);
        end loop;
        commit;
end;


--��ϰ������дһ��������ʾ1��100֮�����������������
--��ʾ��
--1����������������ֻ�ܱ�1�ͱ�������������
--2��ʹ��forѭ��
declare
        i number(4);--������
        j number(4):=1;--����
        z number(4):=0;--�洢�������Ĵ���
begin
        for i in 1..100
            loop 
                while j<=i 
                      loop
                        if mod(i,j)=0 then
                           z:=z+1;
                         end if;
                         j:=j+1;
                      end loop;
                      j:=0;
                      if z=2 then
                         dbms_output.put_line(i);
                       end if;
                       z:=0;
            end loop;

end;







--��ϰ�� ����  ע��
--CUSTOMERID  �ͻ����
--CREATETIME  �ͻ�����ʱ��
--EMAIL  �ͻ�email
--LANGUAGE  �ͻ�����
--USERNAME  �ͻ��ʻ�
--SCREENNAME  �س�
--PASSWORD  ����
--ISMALE  �Ƿ�ͨ��������֤
--BIRTHDAY  ����
--POSTALCODE  ��������
--FIRSTNAME  ��һ����
--LASTNAME  �ڶ�����
--ADDRESS  ��ַ
--���дPL/SQL�飬ͳ��70��80��90���û���������ռ���������͵ı�����Ч�����£�
select * from userinfo
declare
       seven number;--����������
       eight number;--����������
       nine number;--����������
       he number;--�ܺ�
      
begin
     select count(*) into seven from userinfo where substr(extract(year from birthday),3,1)=7;
     select count(*) into eight from userinfo where substr(extract(year from birthday),3,1)=8;
     select count(*) into nine from userinfo where substr(extract(year from birthday),3,1)=9;
      he:=seven+eight+nine;
      
      dbms_output.put_line('�����,�����,�����,�����������͵ı���Ϊ��'||seven||':'||eight||':'||nine||':'||he);
      dbms_output.put_line('�����ռ���������͵İٷֱ�Ϊ��'||floor((seven/he)*100)||'%');
      dbms_output.put_line('�����ռ���������͵İٷֱ�Ϊ��'||floor((eight/he)*100)||'%');
      dbms_output.put_line('�����ռ���������͵İٷֱ�Ϊ��'||floor((nine/he)*100)||'%');
end;








--��ϰ�塢ʹ��Ԥ�����쳣
--���scott�û���emp����дһ��PL/SQL���룬���ݽ��յ�Ա����Ų�ѯԱ�����������������洢�ڱ���empname�С�
--������Ҫ�󽫱�������Ϊvarchar2(4)���ͣ����ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ��ȣ�������Value_Error�쳣��
--����쳣���д������û���ʾ��Ϣ��
select * from emp
declare
         empname varchar2(4);
         num emp.empno%type:='&������Ա�����';
begin
         select ename into empname from emp where empno=num;
         exception
                when Value_Error then
                     dbms_output.put_line('ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ���');

end;




