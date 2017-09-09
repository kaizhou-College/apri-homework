--找出佣金高于薪金的20%的雇员
select ename from emp where comm>(sal * 0.2)
--找出部门10中所有经理和部门20中所有办事员的详细资料
select * from emp where (deptno = 10 and job='MANAGER') or(deptno = 20 and job='CLERK')
--找出收取佣金的雇员的不同工作 
select distinct job from emp where comm is not null
--找出不收取佣金或收取的佣金低于100的雇员
select ename from emp where comm<100 or comm is null
--显示雇员的详细资料,按姓名排序
select * from emp  order by ename
--显示雇员姓名，根据其服务年限，将最老的雇员排在最前面
select ename from emp   order by hiredate asc
--显示雇员姓名，工作和薪金，按工作的降序顺序排序，而工作按薪金排序
select ename,job,sal from emp order by job desc,sal asc
--显示雇员表中有多少个不同的部门
select distinct deptno from emp 
--显示至少有一个雇员的所有部门。
select emp.ename,dept.* from emp,dept where emp.deptno=dept.deptno
--显示部门名称和这些部门的雇员姓名，同时列出那些没有雇员的部门
select dept.dname,emp.ename from emp,dept where emp.deptno=dept.deptno or(emp.deptno not in (select deptno from dept))

--查询并显示每个部门每个岗位的平均工资和最低工资
select min(sal),avg(sal) ,deptno ,job from emp group by deptno,job;



