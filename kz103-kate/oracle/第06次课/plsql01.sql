---pl/sql的块的机构
declare
  ----声明部分
  b1  number :=1;
  b2  number ;
  ename varchar2(10);
begin
  ----执行部分
  --执行输出
  b2 :=3;
  select ename into ename from emp where empno=7369;
  dbms_output.put_line('b2====='||b2);
  dbms_output.put_line('ename==='||ename);
  
end;


---【1，变量赋值的两种方式】
---1.1  b1 number := 3
---1.2  select into  注意是返回必须是一个值

---【2，常用的数据类型】
---2.1 数字 number
---2.2 字符 varchar2
---2.3 日期 date
---2.4 类型变量     %TYPE
---2.5 记录型变量

----2.4 类型变量 
select * from emp
desc emp;


declare 
        em emp.ename%TYPE;
begin
        select ename into em from emp where empno = 7369;
        dbms_output.put_line(em);
end;
select * from emp 
---2.5 记录型变量
declare 
       emp2 emp%rowtype;
begin 
       emp2.ename :='smith';
       emp2.empno :=44;
       emp2.empjob :='捡垃圾';
       dbms_output.put_line(emp2.ename||'---'||emp2.empno);
end;
       
declare 

      emp2 emp%rowtype;
begin
      select * into emp2 from emp where empno=7369;
      dbms_output.put_line(emp2.ename||'--'||emp2.empjob);
end;


----【3，if结构】
declare
      n1 number :='&请输入第1个整数';
      n2 number :='&请输入第2个整数';
begin 
      if n1>n2 then
            dbms_output.put_line('n1大于n2');
      elsif n1<n2 then      
            dbms_output.put_line('n1小于n2');
      else
            dbms_output.put_line('n1等于n2');  
      end if;
      ---dbms_output.put_line(n1||'---'||n2);
end;

--if(条件判断){      ===>   if  条件  then
--    执行的部分     ===>            ---执行的部分
--}                  ===>    end if;

--示例2：根据员工部门编号，给员工增加工资
--10部门，增加100
--20部门，增加200
--30部门，增加300
select deptno from emp
declare
      deptnum emp.deptno%type;               
begin
      select deptno into deptnum from emp where empno=7369;
      if deptnum=20 then
         update emp set sal=sal+100  where empno=7369;
      end if;
      ---提交 
      commit;
end;

select * from emp where empno = 7369;

----【3，case结构】
----根据某个同学分数划分等级
----<60               C
--- 大于60 小于90     B
----大于90            A
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

---case的写法方式二：
declare 
    exam studentexam.examresult%type;
    stuid number :='&输入学生的编号';
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

--【4，循环】 
---1,loop
declare
    n1 number :=1;
begin
    loop   
        ---怎么样结束循环
        exit when n1>100;
        dbms_output.put_line(n1||'我爱你');
        n1 :=n1+1;
    end loop;
end;  
----2, while
declare 
       n1 number :=1;
begin
       while(n1<=100) 
          loop
             dbms_output.put_line(n1||'我爱你');
             n1 :=n1+1;
          end loop;
end;
----3,for
declare 
    num number ;  
begin
   for num in 1.. 100
   loop
        dbms_output.put_line(num||'我爱你');
   end loop;
  
end;
select * from emp
---【5，异常】
declare 
   em emp.ename%type;
   n1 number;
begin
   --select ename into em from emp;
   --update emp set empno=7499 where empno=7369;
   --commit;
   n1 := '&输入数字';
   ---select ename into em from emp where empno=1;
   --n1 :=10/0;
   --dbms_output.put_line(em);
   exception
         when invalid_number then
                    dbms_output.put_line('你输入的不是数字');
              when zero_divide then
                    dbms_output.put_line('傻叉除数不能为0');
          when no_data_found then
                    dbms_output.put_line('没有给变量赋值!!!');
          when too_many_rows then
                    dbms_output.put_line('给变量赋值时只能返回1个数据');
          when dup_val_on_index then
                    dbms_output.put_line('主键不能重复');
          when others then
                    dbms_output.put_line('其他异常');
end;

---【6，自定义异常】
declare
    aa  exception;
    n1 number :='&n1';
begin
    if n1=1 then
       raise aa;---自定义的必须通过raise进行抛出
    end if;
    exception
       when aa then
            dbms_output.put_line('捕获了我自定义的异常');
end;

public class myexm extends exception{
       
}











