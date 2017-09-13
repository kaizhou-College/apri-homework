--公司决定向职员（emp表）发放奖金，发放原则根据职员所在部门编号（deptno）来计算。
--如果部门编号为“10”，奖金为2000元；部门编号为“20”，奖金为1700元；
--部门编号为“30”，奖金为1500元，请用条件结构解决该问题。
declare
      epn emp.empno%type:='&请输入你的员工编号';
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


--练习二、使用循环结构
--问题描述：请编写一个程序，通过循环向course_details表中插入10条件记录，要求学生编号每次累加1，课程由用户输入。
declare
         id number:=1;
         subject varchar2(15);
begin
      For  i in  1..10
           Loop
              subject := '&请输入课程';
              id :=id+1;
             insert into course_details values(id,subject);
           End loop;
end;
--练习三、编写一个程序，显示1至100之间的素数（质数）。
--提示：
--1、素数（质数）：只能被1和本身整除的数。
--2、使用for循环
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
--练习四、请编写PL/SQL块，统计70后，80后，90后用户的人数和占三者人数和的比例。
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
       dbms_output.put_line('70后总共'||seven||'人');
       dbms_output.put_line('80后总共'||eight||'人');
       dbms_output.put_line('90后总共'||nine||'人');
       dbms_output.put_line('70后总占'||round(seven*100/num,2)||'%');
       dbms_output.put_line('80后总占'||round(eight*100/num,2)||'%');
       dbms_output.put_line('90后总占'||round(nine*100/num,2)||'%');
end;
--练习五、使用预定义异常
--针对scott用户的emp表，编写一段PL/SQL代码，根据接收的员工编号查询员工姓名，并将姓名存储在变量empname中。
--代码中要求将变量声明为varchar2(4)类型，如果ename的值的长度大于变量empname的长度，将引发Value_Error异常，
--则对异常进行处理，向用户提示信息。
declare
      empname varchar2(4);
      num number:='&员工编号';
begin
       select ename into empname from emp where empno=num;
exception
       when Value_Error then
        dbms_output.put_line('姓名超出长度');
end;
--练习六、动态SQL
--编写一段PL/SQL代码，接收用户输入的部门编号、部门名称和部门地址，将其插入到scott用户的dept表中。要求使用动态SQL实现。
declare
        deptno varchar2(20);
        dname varchar2(20);
        loc varchar2(20);
begin   
        deptno:='&请输入部门编号';
        dname:='&请输入部门名称';
        loc:='&请输入部门地址';
        insert into dept values(deptno,dname,loc);
end;

