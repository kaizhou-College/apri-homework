--��˾������ְԱ��emp�����Ž��𣬷���ԭ�����ְԱ���ڲ��ű�ţ�deptno�������㡣
--������ű��Ϊ��10��������Ϊ2000Ԫ�����ű��Ϊ��20��������Ϊ1700Ԫ��
--���ű��Ϊ��30��������Ϊ1500Ԫ�����������ṹ��������⡣
declare
      epn emp.empno%type:='&���������Ա�����';
      dpn emp.deptno%type;
begin
      select deptno into dpn from emp where empno = epn;
      if dpn=10 then
         update emp set sal = sal+2000 where empno=epn;
      elsif dpn=20 then
            update emp set sal = sal+1700 where empno=epn;
      elsif dpn=30 then
            update emp set sal = sal+1500 where empno=epn;
      end if;
end;


--��ϰ����ʹ��ѭ���ṹ
--�������������дһ������ͨ��ѭ����course_details���в���10������¼��Ҫ��ѧ�����ÿ���ۼ�1���γ����û����롣
declare
         id number:=1;
         subject varchar2(15);
begin
      For  i in  1..10
           Loop
              subject := '&������γ�';
              id :=id+1;
             insert into course_details values(id,subject);
           End loop;
end;
--��ϰ������дһ��������ʾ1��100֮�����������������
--��ʾ��
--1����������������ֻ�ܱ�1�ͱ�������������
--2��ʹ��forѭ��
declare
           c number:=1;
           z number:=0;
begin
           for i in 1..100
               loop
                 while c<=i
                       loop
                         if mod(i,c)=0 then
                            z:=z+1;
                         end if;
                         c:=c+1;
                 end loop;
                 c:=0;
                 if z=2 then
                    dbms_output.put_line(i);
                 end if;
                 z:=0;
                 end loop;
end;
--��ϰ�ġ����дPL/SQL�飬ͳ��70��80��90���û���������ռ���������͵ı�����
select * from userinfo
declare
       seven number;--70
       eight number;--80
       nine number;--90
       num number;--he
begin
       select count(*) into seven from userinfo where extract(year from birthday)>=1970 and extract(year from birthday)<1980;
       select count(*) into eight from userinfo where extract(year from birthday)>=1980 and extract(year from birthday)<1990;
       select count(*) into nine from userinfo where extract(year from birthday)>=1990 and extract(year from birthday)<2000;
       select count(*) into num from userinfo;
       dbms_output.put_line('70���ܹ�'||seven||'��');
       dbms_output.put_line('80���ܹ�'||eight||'��');
       dbms_output.put_line('90���ܹ�'||nine||'��');
       dbms_output.put_line('70����ռ'||round(seven*100/num,2)||'%');
       dbms_output.put_line('80����ռ'||round(eight*100/num,2)||'%');
       dbms_output.put_line('90����ռ'||round(nine*100/num,2)||'%');
end;
--��ϰ�塢ʹ��Ԥ�����쳣
--���scott�û���emp����дһ��PL/SQL���룬���ݽ��յ�Ա����Ų�ѯԱ�����������������洢�ڱ���empname�С�
--������Ҫ�󽫱�������Ϊvarchar2(4)���ͣ����ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ��ȣ�������Value_Error�쳣��
--����쳣���д������û���ʾ��Ϣ��
declare
      empname varchar2(4);
      num number:='&Ա�����';
begin
       select ename into empname from emp where empno=num;
exception
       when Value_Error then
        dbms_output.put_line('������������');
end;
--��ϰ������̬SQL
--��дһ��PL/SQL���룬�����û�����Ĳ��ű�š��������ƺͲ��ŵ�ַ��������뵽scott�û���dept���С�Ҫ��ʹ�ö�̬SQLʵ�֡�
declare
        deptno varchar2(20);
        dname varchar2(20);
        loc varchar2(20);
begin   
        deptno:='&�����벿�ű��';
        dname:='&�����벿������';
        loc:='&�����벿�ŵ�ַ';
        insert into dept values(deptno,dname,loc);
end;

