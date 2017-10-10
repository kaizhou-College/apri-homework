--��Scott�û���emp��Ϊ����Դ����дһ�����̸���Ա��������Ա��������нˮ����Ҫ��Ա��������нˮ��Ϊ���������
select * from emp

create or replace procedure Byname(eno number)
is
       pname emp.ename%type;
       money emp.sal%type;
begin
       select ename,sal into pname,money from emp where empno=eno;
       dbms_output.put_line(pname||'---'||money);
       exception
        when no_data_found then
             RAISE_APPLICATION_ERROR(-20000,'��Ա��������');
end;
--����
begin 
       Byname('&����Ա�����');
end;

--��Scott�û���emp��Ϊ����Դ����дһ����������Ա����ŷ���Ա������ְʱ�䡣
create or replace function Bytime(eno number)
return varchar
as
       time emp.hiredate%type;
begin
       select hiredate into time from emp where empno=eno;
       return time;
       exception
        when no_data_found then
             RAISE_APPLICATION_ERROR(-2000,'��Ա����δ��ְ');
end;
--����
declare
         time varchar2(20);
begin
      time:=Bytime('&Ա�����');
      dbms_output.put_line(time);     
end;

--������������ڳ�����ж���һ�������������Ա�����ٶ���һ��������������Ա������ж�Ա���Ƿ���ڡ�
--��Ҫ�����û�ִ����Ӳ���֮ǰ���ȵ��ú����жϸ�Ա���Ƿ���ڣ���������ڣ�����벢�ύ���ݣ�������ʾ��Ա���Ѵ��ڣ�
create or replace function Bystaff(eno number)
return varchar
as
       pname emp.ename%type;
begin
       select ename into pname from emp where empno=eno;
       return pname;
      exception
       when no_data_found then
            RAISE_APPLICATION_ERROR(-20000,'��Ա��������')
              
select * from emp

--��Scott�û���emp��Ϊ����Դ����д��ҳ�Ĵ洢���̣�Ҫ���뿪ʼ�ͽ������д���ʾ����������αꡣ
--����ʾ�����ڳ�����ж����α����ͣ��������α������Ϊ���������
create or replace procedure copylimit(startpoint number,getnum number) as    
--/*����table*/  
type emp_tab is table of myemp%rowtype;  
emp_rd emp_tab;  
 www.2cto.com  
--/*�����α�*/  
emp_cur sys_refcursor;  
--����  
begin  
  --��ʾ�û�����Ŀ�ʼ����Ҫȡ����������  
  dbms_output.put_line('��ʼ�㣺'||startpoint||' ȡ��������'||getnum);  
  --���α겢�Ҹ��α긳ֵ��ִ�з�ҳ��ѯ��  
  open emp_cur for select * from myemp where rowid in (  
                   select rd from(  
                   select rownum rm,rd from(     
                   select rowid rd from myemp order by empno) where rownum < startpoint + getnum) where rm >= startpoint);  
   --����ѭ��  
   loop    
     --���α�����ȡֵbulk collect��ʽ����emp_rd  
     fetch emp_cur bulk collect into emp_rd limit 2;  
     --ѭ������  
     for i in 1..emp_rd.count loop  
       dbms_output.put_line('Ա������'||emp_rd(i).ename);  
     end loop;  
     exit when emp_cur%notfound;   
    --����ѭ��   
    end loop;  
    --�ر��α�  
    close emp_cur;  
--����  
end;  




--Ҫ���д����ʵ�ֿ������ܣ��������˱�Ų������¼��
Create table billInfo(
	billID varchar2(14),	--�˵���ţ���ʽΪ��ZD201005290001��
	billDate date			--����ʱ��
  );
  
create or replace procedure Bybill
is
       begin
          
