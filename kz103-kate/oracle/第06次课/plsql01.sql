---pl/sql�Ŀ�Ļ���
declare
  ----��������
  b1  number :=1;
  b2  number ;
  ename varchar2(10);
begin
  ----ִ�в���
  --ִ�����
  b2 :=3;
  select ename into ename from emp where empno=7369;
  dbms_output.put_line('b2====='||b2);
  dbms_output.put_line('ename==='||ename);
  
end;


---��1��������ֵ�����ַ�ʽ��
---1.1  b1 number := 3
---1.2  select into  ע���Ƿ��ر�����һ��ֵ

---��2�����õ��������͡�
---2.1 ���� number
---2.2 �ַ� varchar2
---2.3 ���� date
---2.4 ���ͱ���     %TYPE
---2.5 ��¼�ͱ���

----2.4 ���ͱ��� 
select * from emp
desc emp;


declare 
        em emp.ename%TYPE;
begin
        select ename into em from emp where empno = 7369;
        dbms_output.put_line(em);
end;
select * from emp 
---2.5 ��¼�ͱ���
declare 
       emp2 emp%rowtype;
begin 
       emp2.ename :='smith';
       emp2.empno :=44;
       emp2.empjob :='������';
       dbms_output.put_line(emp2.ename||'---'||emp2.empno);
end;
       
declare 

      emp2 emp%rowtype;
begin
      select * into emp2 from emp where empno=7369;
      dbms_output.put_line(emp2.ename||'--'||emp2.empjob);
end;


----��3��if�ṹ��
declare
      n1 number :='&�������1������';
      n2 number :='&�������2������';
begin 
      if n1>n2 then
            dbms_output.put_line('n1����n2');
      elsif n1<n2 then      
            dbms_output.put_line('n1С��n2');
      else
            dbms_output.put_line('n1����n2');  
      end if;
      ---dbms_output.put_line(n1||'---'||n2);
end;

--if(�����ж�){      ===>   if  ����  then
--    ִ�еĲ���     ===>            ---ִ�еĲ���
--}                  ===>    end if;

--ʾ��2������Ա�����ű�ţ���Ա�����ӹ���
--10���ţ�����100
--20���ţ�����200
--30���ţ�����300
select deptno from emp
declare
      deptnum emp.deptno%type;               
begin
      select deptno into deptnum from emp where empno=7369;
      if deptnum=20 then
         update emp set sal=sal+100  where empno=7369;
      end if;
      ---�ύ 
      commit;
end;

select * from emp where empno = 7369;

----��3��case�ṹ��
----����ĳ��ͬѧ�������ֵȼ�
----<60               C
--- ����60 С��90     B
----����90            A
declare 
    exam studentexam%rowtype;
begin
    select * into exam from studentexam where estuid=8 and examsubject='SQL';
    dbms_output.put_line(exam.examresult);
    case exam.examresult
        when 44 then dbms_output.put_line('A');
        when 55 then dbms_output.put_line('C');
        else dbms_output.put_line('D');
    end case ;
end;

---case��д����ʽ����
declare 
    exam studentexam.examresult%type;
    stuid number :='&����ѧ���ı��';
begin
    select examresult into exam from studentexam where estuid=stuid  and examsubject='SQL';
    dbms_output.put_line(exam);
    case
      when exam <60 then dbms_output.put_line('C');
      when exam >=60 and exam<90 then dbms_output.put_line('B');
      else
           dbms_output.put_line('A');
    end case;
end;  

--��4��ѭ���� 
---1,loop
declare
    n1 number :=1;
begin
    loop   
        ---��ô������ѭ��
        exit when n1>100;
        dbms_output.put_line(n1||'�Ұ���');
        n1 :=n1+1;
    end loop;
end;  
----2, while
declare 
       n1 number :=1;
begin
       while(n1<=100) 
          loop
             dbms_output.put_line(n1||'�Ұ���');
             n1 :=n1+1;
          end loop;
end;
----3,for
declare 
    num number ;  
begin
   for num in 1.. 100
   loop
        dbms_output.put_line(num||'�Ұ���');
   end loop;
  
end;
select * from emp
---��5���쳣��
declare 
   em emp.ename%type;
   n1 number;
begin
   --select ename into em from emp;
   --update emp set empno=7499 where empno=7369;
   --commit;
   n1 := '&��������';
   ---select ename into em from emp where empno=1;
   --n1 :=10/0;
   --dbms_output.put_line(em);
   exception
         when invalid_number then
                    dbms_output.put_line('������Ĳ�������');
              when zero_divide then
                    dbms_output.put_line('ɵ���������Ϊ0');
          when no_data_found then
                    dbms_output.put_line('û�и�������ֵ!!!');
          when too_many_rows then
                    dbms_output.put_line('��������ֵʱֻ�ܷ���1������');
          when dup_val_on_index then
                    dbms_output.put_line('���������ظ�');
          when others then
                    dbms_output.put_line('�����쳣');
end;

---��6���Զ����쳣��
declare
    aa  exception;
    n1 number :='&n1';
begin
    if n1=1 then
       raise aa;---�Զ���ı���ͨ��raise�����׳�
    end if;
    exception
       when aa then
            dbms_output.put_line('���������Զ�����쳣');
end;

public class myexm extends exception{
       
}











