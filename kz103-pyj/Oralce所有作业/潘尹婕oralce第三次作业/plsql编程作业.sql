--ʹ�������ṹ
--��˾������ְԱ��emp�����Ž��𣬷���ԭ�����ְԱ���ڲ��ű�ţ�deptno�������㡣
--������ű��Ϊ��10��������Ϊ2000Ԫ�����ű��Ϊ��20��������Ϊ1700Ԫ�����ű��Ϊ��30����
--����Ϊ1500Ԫ�����������ṹ��������⡣ 
declare 
       deptnum emp.deptno%type;
       num1 number ;
begin
       num1 :='&ְԱ���';
      select deptno into deptnum from emp where empno=num1;
      dbms_output.put_line(deptnum);
       if deptnum =10 then
          update emp set comm=nvl(comm,0)+2000 where deptno=deptnum;
        elsif deptnum = 20 then
              update emp set comm=nvl(comm,0)+1700 where deptno=deptnum;
           else 
                update emp set comm=nvl(comm,0)+1500 where deptno=deptnum;
               end if;
               commit;
end;
select * from emp


--���дһ������ͨ��ѭ����course_details���в���10������¼��Ҫ��ѧ�����ÿ���ۼ�1���γ����û����롣
create table course_details
(
	stuid number,--ѧԱ���
	course varchar2(20)--��-�γ�
);
m
declare 
         stuid number;
        num number := 1; 
        input1 varchar2(20) :='&������γ���';
begin
        loop
           exit when num > 10;
           dbms_output.put_line(num ||input1);
           num := num+1;
           stuid :=stuid+1;
          end loop;
          commit;        
end;

--��дһ��������ʾ1��100֮�������������������������������ֻ�ܱ�1�ͱ�������������
declare
          num1 number(3):=2;
          num2 number:=0;
begin
          loop
               num2:=0;
               for num in 2..num1-1
          loop
               if(num1 mod num=0) then num2:=1;
               end if;
               end loop;
          if(num2=0) then 
                  dbms_output.put_line(num1);
                  end if; num1:=num1+1;
                  exit when num1=100;
           end loop;
end;
--���дPL/SQL�飬ͳ��70��80��90���û���������ռ���������͵ı�����
declare
          num70 number;
          num80 number;
          num90 number;
          sumtal number;
begin
          select count(*) into num70 from userinfo where substr(to_char(birthday,'yyyy'),3,1)='7';
          select count(*) into num80 from userinfo where substr(to_char(birthday,'yyyy'),3,1)='8';
          select count(*) into num90 from userinfo where substr(to_char(birthday,'yyyy'),3,1)='9';
          sumtal :=num70+num80+num90;
          dbms_output.put_line('70��'||num70||'��;80��'||num80||'��;90��'||num90||'��');
          dbms_output.put_line('70��ռ'||round(num70*100/sumtal,2)||'%');
          dbms_output.put_line('80��ռ'||round(num80*100/sumtal,2)||'%');
          dbms_output.put_line('90��ռ'||round(num90*100/sumtal,2)||'%');

end;
----���scott�û���emp����дһ��PL/SQL���룬���ݽ��յ�Ա����Ų�ѯԱ�����������������洢�ڱ���empname�С�
--������Ҫ�󽫱�������Ϊvarchar2(4)���ͣ����ename��ֵ�ĳ��ȴ��ڱ���empname�ĳ��ȣ�������Value_Error�쳣��
--����쳣���д������û���ʾ��Ϣ��
declare
          empname varchar2(4);
begin
          select ename into empname from emp where empno='7369';
      exception
        when Value_error then
              dbms_output.put_line('Ա����������');        
end;






























