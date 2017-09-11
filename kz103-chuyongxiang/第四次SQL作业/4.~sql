----1、查询smith的工作、薪水和部门
select job,sal,deptno from emp where ename='SMITH'
----2、查询员工一年的工资（sal*13）
select ename, sal*13 as "年薪" from emp
----3、查询工资高于3000的员工
select * from emp where sal>3000 
----4、查询工资在800到1600之间的员工
select * from emp where sal between 800 and 1600
----5、查询1982-1-1后入职的员工
select * from emp where hiredate > '01/3月/1982'
----6、查询姓名以S开始的员工
select * from emp where ename like 'S%'
----7、查询员工名字第3个字符是O的员工
select * from emp where ename like '__O%'
----8、查询员工号为：7369、7499、7521的员工
select * from emp where empno = 7369 or empno = 7499 or empno = 7521
----9、查询没有上级的员工
select * from emp where mgr is null
----10、查询工资大于500或者职位为manager，并且名字以S开头的员工
select * from emp where (sal>500 or job='manager')and ename like 'S%'
----11、查询员工信息，按照部门号升序且员工的工资降序排列
select * from emp order by deptno asc,sal desc
----12、查询员工信息，按照部门号升序且员工的入职时间降序排列
select * from emp order by deptno asc,hiredate desc
----13、查询员工信息，按照员工的年薪降序排列
select * from emp order by  sal  desc
----14、查询最高工资员工的详细信息
select * from emp where sal=(select max(sal) from emp)
----15、查询最低工资员工的详细信息
select * from emp where sal=(select min(sal) from emp)
----16、查询工资高于公司平均工资的员工信息
select * from emp where sal>(select avg(sal)  from emp)
----17、查询并显示每个部门的最高工资、最低工资、并按照部门编号降序排列
select distinct deptno as 部门编号,max(sal)as 最高工资,min(sal)as 最低工资 from emp
group by deptno
order by deptno
----18、查询并显示每个部门每个岗位的平均工资和最低工资
select distinct deptno as 部门编号,avg(sal)as 平均工资,min(sal)as 最低工资 from emp
group by deptno
----19、查询并显示平均工资低于2000的部门号和他的平均工资
select deptno,avg(sal) from emp group by deptno
having avg(sal)>=2000 order by avg(sal) desc;
----20、查询员工姓名、工资和工资等级
select a.ename,a.sal,b.grade from emp a, salgrade b 
where a.sal between b.losal and b.hisal
----21、查询并显示员工姓名、工资、部门名并按部门排序
select a.ename,a.sal,b.dname from emp a, dept b
where a.deptno=b.deptno 
order by b.deptno
----22、查询并显示指定员工的上级领导的姓名
select  a.*, b.* from emp a,emp b
where a.mgr = b.empno and a.empno = 7369
----23、查询员工的工资大于JONES的员工信息 
select* from emp
where sal>(select sal from emp where ename='JONES')
----24、查询并显示和SMITH同部门的员工
select * from emp
where deptno in (select deptno from emp where ename='SMITH')
----25、查询并显示和部门10员工同岗位的员工
select * from emp
where job in(select job from emp where deptno=10)
----26、查询并显示和SMITH同部门同岗位的员工
select * from emp
where (deptno in (select deptno from emp where ename='SMITH')) and(job in (select job from emp where ename='SMITH')) 
----27、查询每个部门工资最高的员工信息  
select * from emp a,
(select max(sal)maxsal,deptno from emp group by deptno)b
where a.deptno=b.deptno and a.sal=b.maxsal 
----28、查询工资比部门30的所有员工的工资高的员工的姓名、工资、部门编号
select Ename,sal,deptno from emp
where sal>(select max(sal) from emp where deptno=30)
----29、查询工资比部门30的任意一个员工工资高的员工姓名、工资、部门编号
select Ename,sal,deptno from emp
where sal>(select min(sal) from emp where deptno=30)
----30、查询并显示高于自己部门平均工资的员工
select * from emp
where sal>(select avg(sal) from emp where deptno=10)
----31、查询薪水最高的5个员工的信息
select * from (select * from emp order by sal desc)
where rownum<=5;
----查询练习2
----1.列出部门30中的雇员
select * from emp where deptno=30
----2.列出所有办事员的姓名、编号和部门
select a.ename,a.deptno,b.dname from emp a, dept b 
where a.deptno = b.deptno
----3.找出佣金高于薪金的雇员
select * from emp where comm>sal
----4.找出佣金高于薪金的20%的雇员
select * from emp where comm>(sal*0.2)
----5.找出部门10中所有经理和部门20中所有办事员的详细资料
select * from emp where (job='MANAGER' and deptno=10) or (job='CLERK' and deptno=20)
----6.找出收取佣金的雇员的不同工作 
select distinct job from emp where comm is not null
----7.找出不收取佣金或收取的佣金低于100的雇员
select ename from emp where comm<100 or comm is null
----8.显示雇员的详细资料,按姓名排序
select * from emp  order by ename
----9.显示雇员姓名，根据其服务年限，将最老的雇员排在最前面
select ename from emp   order by hiredate asc
----10.显示雇员姓名，工作和薪金，按工作的降序顺序排序，而工作按薪金排序
select ename,job,sal from emp order by job desc,sal asc
----11.显示雇员表中有多少个不同的部门
select distinct deptno from emp 
----12.显示至少有一个雇员的所有部门。
select emp.ename as 员工姓名,dept.* from emp,dept
where emp.deptno=dept.deptno
----13.显示部门名称和这些部门的雇员姓名，同时列出那些没有雇员的部门
select a.dname,b.ename from dept a left join emp b
on a.deptno=b.deptno



