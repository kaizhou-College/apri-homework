----invalid_number���쳣
create table test2(v2 varchar2(10))
insert into test2 values('1900667');
commit;

insert into test2 values('19aa667');
commit;
select * from test2

select to_number('19aa667') from dual
select *��from test2 where v2=1900667

declare
       v22 test2.v2%type;
begin
       select v2 into v22 from test2 where v2=1900667;
       exception
              when invalid_number then
                   dbms_output.put_line('��Ч�����쳣');
          
       
end;
select v2 from test2 where v2=1900667;

---�ܽ᣺
---����ֶ����ַ�  һ��Ҫ��'' ���ǹ淶
select v2 from test2 where v2='1900667';

-------------------------------------
---1,Ϊʲô��Ҫ�α�cursor��
---2,����ʽ�α꡿
declare

begin
       
       ---select * from emp;
       update emp set comm=nvl(comm,0)+200 where empno=7369;
       if sql%isopen=false then
          dbms_output.put_line('�α�ر�');
       end if;
       
       if sql%rowcount>0 then
          dbms_output.put_line('���³ɹ�');
       else 
          dbms_output.put_line('����ʧ��'); 
       
       end if;
       
       if sql%found=true then
           dbms_output.put_line('���³ɹ�22');
       else
            dbms_output.put_line('����ʧ��'); 
       end if;
       
end; 
----pl/sql�Ŀ���ֻ�ܽ���DML���� ���ܽ��е�һ��ѯ
----������pl/sql������Ҫ��ѯȫ��  ����Ҫʹ���α�
----�α�------(resultSet:�����)
select * from emp;


--��3����ʾ�α�/��꡿
declare
       cursor dbp is select * from emp;
       emprow emp%rowtype; ---��¼�ͱ���
begin
       --1,��
       open dbp;
       --2,��ȡ��
       loop
            fetch dbp into emprow;
            exit when dbp%notfound;
            dbms_output.put_line(emprow.empno||'---'||emprow.ename);
       end loop;
       --3,�ر�
       close dbp;
end;

--��4��ѭ���α�/��꡿
declare
       cursor sdm is select * from emp;
       emprow emp%rowtype;
begin
       for emprow in sdm
       loop
           dbms_output.put_line(emprow.ename||'---'||emprow.sal);
       end loop;
end;

----��Ա���Ź��ʣ�����͹�������ÿ��Ա��10%��
----���չ��ʲ��ܳ���5��
----ͳ���ǹ��ʵ������Լ��ǵĹ����ܺ�
---1����ȡ����Ա������Ϣ-----�α�
---2��ѭ��ΪԱ���ǹ���  
---3���˳�����-,1�����ܳ���5w  2)%notfound
---4����¼�ǹ��ʵ��������������
---5����¼�ǹ����ʵ��ܺ�?�������
declare 
   cursor zgz is select * from emp order by sal;             
   emprow emp%rowtype;
   num emp.sal%type :=0;---��¼�ǹ��ʵ�����
   sum2 emp.sal%type :=0;---��¼�ǹ����ʵ��ܺ�
begin
   open zgz;
        loop--ѭ��
          fetch zgz into emprow;--���α���ȡһ������
          dbms_output.put_line(emprow.ename||'------'||emprow.sal);
          ---�˳�����1�����ʲ��ܳ���5w
         
          exit when emprow.sal > 50000;
           ---�˳�����2��û��Ա��
          exit when zgz%notfound;
          ---�����ǹ���
          update emp set sal = sal*1.1 where empno =emprow.empno; 
          ---�ǹ�������+1
          num := num+1;
          ---���ǵĹ��ʼӵ��ܺ���
          sum2 := sum2 + emprow.sal*0.1;
          ---�ǹ��ʳɹ�����ʾ
          if sql%found then
             dbms_output.put_line(emprow.ename||'����'||emprow.sal*0.1||'����');
          end if;
          --�ύ
          commit;
         
        end loop;
   close zgz;
   
   ---��������
   dbms_output.put_line('�ǹ�������Ϊ:'||num||',�ǹ��ʵ��ܺͣ�'||sum2);
   
end;

----��ѭ���α꡿
declare 
   cursor zgz is select * from emp order by sal;             
   emprow emp%rowtype;
   num emp.sal%type :=0;---��¼�ǹ��ʵ�����
   sum2 emp.sal%type :=0;---��¼�ǹ����ʵ��ܺ�
begin
   for emprow in zgz
   loop
       dbms_output.put_line('------'||emprow.sal);
      ---�˳�����1�����ʲ��ܳ���5w
        exit when emprow.sal > 50000;
        ---�����ǹ���
        update emp set sal = sal*1.1 where empno =emprow.empno; 
        ---�ǹ�������+1
        num := num+1;
        ---���ǵĹ��ʼӵ��ܺ���
        sum2 := sum2 + emprow.sal*0.1;
        ---�ǹ��ʳɹ�����ʾ
        if sql%found then
           dbms_output.put_line(emprow.ename||'����'||emprow.sal*0.1||'����');
        end if;
        ---�˳�����2��û��Ա��
        exit when zgz%notfound;
   end loop;
  ---��������
   dbms_output.put_line('�ǹ�������Ϊ:'||num||',�ǹ��ʵ��ܺͣ�'||sum2);
end;

select  * from emp  order by sal

---���α�������ݡ�
----�α����Ա�����ʣ�ÿ����500
declare
        cursor zgz2 is 
               select sal from emp for update;
begin
        for r in zgz2
        loop
            ---�ǹ���
            update emp set sal = sal+500 
            where current of zgz2;
            if sql%found then
               dbms_output.put_line('�ɹ�');
            end if;
        end loop;
        ---����ŵ�ѭ������
        commit;
       
end;


----��ʹ���α���¡�
declare
	cursor mycursor is
   		select sal from emp for update;
begin
   for r in mycursor
   loop
		update emp set sal=sal+500 
      	where current of mycursor;      
   end loop;
end; 


---��ref�α���α������
declare
   ---����ref�α�����
   type myref is ref cursor ;
   --����ref�α����
   myval myref ;
   r emp.sal%type;
begin
  open myval for select sal from emp where deptno=10;
  loop
       fetch myval into r;
       dbms_output.put_line(r);
       exit when myval%notfound; 
  end loop;
end;


----�����û�����ı�������ʾ��Ӧ����Ϣ��
---����û����롮E��������ʾԱ����ź�Ա������ --emp��
--����û����롮D��������ʾ���ű�źͲ�������  ---dept��

declare
  cursor aa is select * from dept;                    
  --type myref is ref cursor ;
  ---myval myref;
  myval sys_refcursor;
  bm varchar2(10):='&�������' ;
  v1 number;
  v2 varchar2(20);
begin
  ---aa for select * from dept;
  if bm='E' then
     open myval for select empno,ename from emp;
  else 
     open myval for select deptno,dname from dept;
  end if;
  
  loop
      fetch myval into v1,v2;
            dbms_output.put_line(v1||'---'||v2);
      exit when myval%notfound;
  end loop;
  
end;


---���������α꡿
declare 
  cursor c2(dno number) is select * from emp where empno=dno;
  r emp%rowtype;
begin
  
       for r in c2('&������Ա�����')
       loop
          
           dbms_output.put_line(r.ename);
       end loop;

end;

����̬sql��
begin
  execute immediate 'select * from emp where empno=:dno'--ִ�в�ѯ
  using '&no','&n2';
  --immediate����
  ---execute immediate 'create table t30522(tid number)';
end;

begin 
  ---DDL
  execute immediate 'create table t30522(tid number)';
end; 

---��̬sql���������
declare
  Type salcursor is ref cursor;--�����α�����
  salcurvar salcursor;--�����α����
  mysal emp%rowtype;
begin
  open salcurvar for
  'select sal from emp where deptno=:dno'--��̬SQL�ַ���
  using '&no';--�ռλ���Ĳ���
  loop
       fetch salcurvar into mysal;
             dbms_output.put_line(mysal.sal);
       exit when salcurvar%notfound;
  end loop;
end;

select * from emp




