----【练习一、使用条件结构】
----问题描述：公司决定向职员（emp表）发放奖金，
----发放原则根据职员所在部门编号（deptno）来计算。
----如果部门编号为“10”，奖金为2000元；部门编号为“20”，
----奖金为1700元；部门编号为“30”，奖金为1500元，请用条件结构解决该问题。

select deptno from emp
declare 
       num number;
       deptnum emp.deptno%type;
begin 
       num :='&职员编号';
       select deptno into deptnum from emp where empno=num;
       dbms_output.put_line(deptnum);
      if deptnum = 10 then 
        update emp set comm=nvl(comm,0)+2000 where deptno = deptnum;
      elsif deptnum = 20 then 
        update emp set comm = nvl(comm,0)+1700 where deptno = deptnum;
      else 
         update emp set comm = nvl(comm,0)+1500 where deptno = deptnum;
      end if;
      commit;
end;
select * from emp;

----【练习二、使用循环结构】
--问题描述：请编写一个程序，通过循环向course_details表中插入10条件记录，
--要求学生编号每次累加1，课程由用户输入。
create table course_details
(
	stuid number,--学员编号
	course varchar2(20)--—课程
);

declare 
         countid number :=0;--编号
         cousestr course_details.course%type;---课程
begin
       while(countid<10)
       loop
         countid :=countid+1;
         cousestr :='&请输入课程';
         insert into course_details values(countid,cousestr);
         dbms_output.put_line('---------'||countid||cousestr);
       end loop;
end;


----练习三、编写一个程序，显示1至100之间的素数（质数）。
--提示：
--1、素数（质数）：只能被1和本身整除的数。
--2、使用for循环
--方法一
declare
    i number(4);--存储1-100中所有的数（用作被除数）
    j number(4) := 1;--存储除数
    z number(4) := 0;--存储被整除的次数;
begin
    for i in 1..100 loop
        while j <= i loop
            if mod(i,j) = 0 then 
                z := z + 1;
            end if;
            j := j + 1;
        end loop; 
        j := 0;
        if z = 2 then 
            dbms_output.put_line(i);         
        end if;  
        z := 0; 
    end loop;
end;


----练习四、将userInfo.dmp文件中的数据导入Scott用户下
--，该文件中包含UserInfo用户信息表，请编写PL/SQL块，
--统计70后，80后，90后用户的人数和占三者人数和的比
declare 
    num1 number;
    num2 number;
    num3 number;
    total number;
begin
    select count(*) into num1 from userinfo where substr(extract(year from birthday),3,1) ='7';
    select count(*) into num2 from userinfo where substr(extract(year from birthday),3,1) ='8';
    select count(*) into num3 from userinfo where substr(extract(year from birthday),3,1) ='9';
    total :=num1+num2+num3;
    dbms_output.put_line('70后的人'||num1);
    dbms_output.put_line('80后的人'||num2);
    dbms_output.put_line('90后的人'||num3);
    dbms_output.put_line('70后占总数和的比'||trunc((num1/total*100),2)||'%');
    dbms_output.put_line('80后占总数和的比'||trunc((num2/total*100),2)||'%');
    dbms_output.put_line('90后占总数和的比'||trunc((num3/total*100),2)||'%');
end;
   
----练习五、使用预定义异常
--针对scott用户的emp表，编写一段PL/SQL代码，
--根据接收的员工编号查询员工姓名，并将姓名存储在变量empname中。
--代码中要求将变量声明为varchar2(4)类型，如果ename的值的长度大于变量empname的长度
--，将引发Value_Error异常，则对异常进行处理，向用户提示信息。
declare 
	empname varchar2(4);
	empno :='&员工编号';
begin
	select ename into empname from userinfo wnere empno=empno1 ;
	exception
		when Value_Error then
			dbms_output.put_line('ename的值的长度大于变量empname的长度');
end;
