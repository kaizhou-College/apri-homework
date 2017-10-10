--���������ʹ�ã�������������
---1��������
create or replace package kz103
as
       ---����(���)---����Ա�������ʾԱ���������͹���
       procedure findByNo(eno number);
       ---����(���)
       function loveYou(year number) return varchar2;
end;

---2�������
create or replace package body kz103
as     ---�������
      procedure findByNo(eno number)       
      as
          pename emp.ename%type;
          psal   emp.sal%type;
      begin
         select ename, sal into pename, psal from emp where empno = eno;        
         dbms_output.put_line(pename||'---'||psal);
      end;
       ---���庯��
       function loveYou(year number) 
       return varchar2
       as
        begin
             return '����'||year||'��';  
        
        end;
end;  

---- ����
begin 
     findByno(7369);
end; 

select kz103.loveYou(1000) from dual


create or replace procedure findByNo(eno number)       
as
    pename emp.ename%type;
    psal   emp.sal%type;
begin
   select ename, sal into pename, psal from emp where empno = eno;        
   dbms_output.put_line(pename||'---'||psal);
end;


begin
   findByNo(7369);
end; 

---���ڳ������ʹ���α������
---ʹ�ó����дһ���洢���̣�
---���ݲ��ű�ŵõ��ò�������Ա����Ϣ
---1,select * from emp where deptno=10
---2,ʹ���α�õ����صĽ��
create or replace package kz103 
as 
   ----������������α����
   type myref is ref cursor;
   procedure findByDno(dno number, myemp out myref);    
end ;

create or replace package body kz103
as
   procedure findByDno(dno number, myemp out myref)
   as
   begin
       open myemp  for select * from emp where deptno=dno;
   
       --close myemp;---�α�ʧЧ
   end;      
end;

---����
declare
   
   type myref2 is ref cursor;
   myemp2 myref2;
   pemp emp%rowtype;
begin
   kz103.findByDno('&dno',myemp2);
   loop
     fetch myemp2 into  pemp;
     exit when   myemp2%notfound;  
     dbms_output.put_line(pemp.empno||'----'||pemp.ename||'----'||pemp.sal);
   end loop;
end;

----����д��ҳ�Ĵ洢����:ҳ��---page  ÿҳ������pageSize ��
create or replace package kzPage103
as     
       type myref is ref cursor;
       procedure findByPage(page number ,pagesize number,myemp out myref);
end;

create or replace package body kzPage103
as
       
   procedure findByPage(page number ,pagesize number,myemp out myref)
   as
   begin
       open myemp for select empno,ename,empjob,
       mgr,hiredate,sal,comm,deptno from
       (select e.* ,row_number() over(order by sal desc) rn
       from emp e) where rn>(page-1)*pagesize and rn <=page*pagesize;     
   end;
end;

---���÷�ʽ1��pl/sql����
declare 
   type myref is ref cursor;
   myemp myref;
   pmyemp emp%rowtype;
begin
   kzPage103.findByPage('&page','&pageSize',myemp);
   loop
          ---������������߲�ѯ�����Ͳ�ƥ��
         fetch myemp into pmyemp;
         exit when myemp%notfound;
         dbms_output.put_line(pmyemp.empno||'---'||pmyemp.sal);
   end loop;
end;


---���÷�ʽ2��java����
----��������д��ҳ�Ĵ洢����:ҳ��---page  ÿҳ������pageSize ��

create or replace package NtkzPage103
as  
      --page :ҳ��  pageSize��ÿҳ����
      --tname:����  myemp�����ص����ݵ��α�   
       type myref is ref cursor;
       procedure findByPage(page number ,pagesize number,tname varchar,myemp out myref);
end;

create or replace package body NtkzPage103
as    
   procedure findByPage(page number ,pagesize number,tname varchar,myemp out myref)
   as
   begin
       open myemp for select empno,ename,empjob,
       mgr,hiredate,sal,comm,deptno from
       (select e.* ,row_number() over(order by sal desc) rn
       from tname e) where rn>(page-1)*pagesize and rn <=page*pagesize;     
   end;
end;
--pl/sql����������ҳ �������⣿

declare 
   type myref is ref cursor;
   myemp myref;
   tname varchar(20) :='&���������';
   --pmyemp  ???%rowtype;
begin
   NtkzPage103.findByPage('&page','&pageSize',tname,myemp);
   dbms_output.put_line(myemp%rowcount);
end;
---java����


---��ҳ���
select * from 
(select rownum rn,e.* from emp e)
where rn>(page-1)*pageSize and rn <=page*pageSize
---��ҳ������
select * from
(select e.* ,row_number() over(order by sal desc) rn
from emp e) 
where rn>(page-1)*pagesize and rn <=page*pagesize



page= 3 pagesize =3;
select * from 
(select rownum rn,e.* from emp e)
where rn>6 and rn <=9

select rownum rn,e.* from emp e where rownum <=5 order by sal desc

-- ��rownum ������ ���ǲ��Ե�
-- Ӧ���������rownum 
--�������1�������Ӳ�ѯ

select rownum rn,e.* from 
(select * from emp order by sal desc) e 
where rownum <=5
--�������2������(�Ƽ���)
---page=2 pagesiz=5
select * from
(select e.* ,row_number() over(order by sal desc) rn
from emp e) 
where rn>5 and rn <=10


select * from emp where empno =7369




 
select * from 
(select rownum rn ,emp.* from emp
 where rownum<=2*5)
where rn>((2-1)*5)







