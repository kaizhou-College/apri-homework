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


--��Scott�û���emp��Ϊ����Դ����д��ҳ�Ĵ洢���̣�Ҫ���뿪ʼ�ͽ������д���ʾ����������αꡣ
--����ʾ�����ڳ�����ж����α����ͣ��������α������Ϊ���������
create or replace procedure Bypage(v1 in number,v2 in number,mycur out sys_refcursor)
as
begin
       open mycur for select * from (select e.*,row_number() over(order by sal) rn from emp e)
       where rn between v1 and v2;

end;
declare
       type myref is ref cursor;
       mycur myref;
       page number:='&page';
       pageSize number:='&pagesize';
       pemp emp%rowtype;
begin
       open mycur for select empno,ename,job,mgr,hiredate,sal,comm,deptno from (select e.*, row_number() over(order by sal) rn from emp e)
        where rn>(page-1)*pageSize and rn<=page*pageSize;
        loop
              fetch mycur into pemp;
              exit when mycur%notfound;
                dbms_output.put_line(pemp.ename||'====='||pemp.empno);
        
        end loop;
end;
select * from emp order by sal
--Ҫ���д����ʵ�ֿ������ܣ��������˱�Ų������¼��
Create table billInfo(
  billID varchar2(14),  --�˵���ţ���ʽΪ��ZD201005290001��
  billDate date      --����ʱ��
  );
  
create or replace procedure Bybill
is
       begin
       
--��дͨ�ð�ķ�ҳ�洢���̣�Ȼ���дjava�������
create or replace packge Bytypage  


