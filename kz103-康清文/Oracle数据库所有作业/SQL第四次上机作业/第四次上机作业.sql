--1、查询smith的工作、薪水和部门
select * from emp
select JOB,SAL,MGR from emp where ename='SMITH'

--查询员工一年的工资（sal*13）
select SAL*13 from emp

--查询工资高于3000的员工
select * from emp where SAL>=3000

--查询工资在800到1600之间的员工
select * from emp where SAL between 800 and 1600 

--查询1982-1-1后入职的员工
select * from emp where HIREDATE>'01-1月-1982';

--查询姓名以S开始的员工
select * from emp where ENAME like 'S%';

--查询员工名字第3个字符是O的员工
select * from emp where ENAME like '__O%';

--查询员工号为：7369、7499、7521的员工
select * from emp where EMPNO in('7369','7499','7521');

--查询没有上级的员工
select * from emp where mgr is  null

--查询工资大于500或者职位为manager，并且名字以S开头的员工
select * from emp where(sal>500 or JOB='manager')and ENAME like 'S%';

--查询员工信息，按照部门号升序且员工的工资降序排列
select * from emp order by DEPTNO asc,SAL desc

--查询员工信息，按照部门号升序且员工的入职时间降序排列
select * from emp order by DEPTNO asc,HIREDATE desc

--查询员工信息，按照员工的年薪降序排列
select * from emp order by SAL desc;

--查询最高工资员工的详细信息
select * from emp where SAL in(select max(SAL)from emp group by deptno)

--查询最低工资员工的详细信息
select * from emp where SAL in(select min(SAL)from emp group by deptno)

--查询工资高于公司平均工资的员工信息
select * from emp where SAL>(select avg(SAL)from emp)

--查询并显示每个部门的最高工资、最低工资、并按照部门编号降序排列
select a.deptno,max(SAL),min(SAL) from emp a group by a.deptno order by a.deptno desc

--查询并显示每个部门每个岗位的平均工资和最低工资
select a.deptno,JOB,avg(SAL),min(SAL)from emp a group by a.deptno order by JOB

--查询并显示平均工资低于2000的部门号和他的平均工资
select avg(sal),max(sal),deptno from emp group by deptno having avg(sal)<2000

--查询员工姓名、工资和工资等级
select ENAME,SAL,JOB from emp

--查询并显示员工姓名、工资、部门名并按部门排序（有问题，待解决）
--select ENAME,SAL from emp order by DEPTNO desc

--查询并显示指定员工的上级领导的姓名
select * from emp 
select a.*,b.* from emp a,emp b where a.mgr=b.empno and a.empno=7369

--查询员工的工资大于JONES的员工信息 
select * from emp where SAL>(select SAL from emp where ENAME='JONES')

--查询并显示和SMITH同部门的员工
select * from emp where DEPTNO=(select DEPTNO from emp where ENAME='SMITH')

--查询并显示和部门10员工同岗位的员工,
select * from emp where JOB in(select JOB from emp where DEPTNO=10)

--查询并显示和SMITH同部门同岗位的员工
select * from emp where (DEPTNO,JOB)=(select DEPTNO,JOB from emp where ENAME='SMITH')

--查询每个部门工资最高的员工信息  
select max(sal),deptno from emp  group by deptno

--查询工资比部门30的所有员工的工资高的员工的姓名、工资、部门编号
select ename,sal,deptno from emp where sal>all(select sal from emp where deptno =30)

--查询工资比部门30的任意一个员工,工资高的员工姓名、工资、部门编号
select ename,sal,deptno from emp where sal>(select min(sal) from emp where deptno =30)

--查询并显示高于自己部门平均工资的员工
select * from emp a,(select avg(sal) avgsal,deptno from emp group by deptno) b
where a.deptno =b.deptno and a.sal> b.avgsal

--查询薪水最高的5个员工的信息
select * from (select * from emp order by sal desc ) where rownum <=5

--1.列出部门30中的雇员
select * from emp where DEPTNO=30

--2.列出所有办事员的姓名、编号和部门
select JOB,EMPNO,DEPTNO from emp

--3.找出佣金高于薪金的雇员
select * from emp where COMM>SAL

--4.找出佣金高于薪金的20%的雇员
select ename from emp where comm>(sal * 0.2)

--5.找出部门10中所有经理和部门20中所有办事员的详细资料
select * from emp where (deptno = 10 and job='MANAGER') or(deptno = 20 and job='CLERK')

--6.找出收取佣金的雇员的不同工作 
select distinct job from emp where comm is not null

--7.找出不收取佣金或收取的佣金低于100的雇员
select ename from emp where comm<100 or comm is null

--8.显示雇员的详细资料,按姓名排序
select * from emp  order by ename

--9.显示雇员姓名，根据其服务年限，将最老的雇员排在最前面
select ename from emp   order by hiredate asc

--10.显示雇员姓名，工作和薪金，按工作的降序顺序排序，而工作按薪金排序
select ename,job,sal from emp order by job desc,sal asc

--11.显示雇员表中有多少个不同的部门
select distinct deptno from emp 

--12.显示至少有一个雇员的所有部门。
select emp.ename,dept.* from emp,dept where emp.deptno=dept.deptno

--13.显示部门名称和这些部门的雇员姓名，同时列出那些没有雇员的部门
select a.*,b.* from dept a left join emp b
on a.deptno=b.deptno





