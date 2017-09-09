
--3.找出佣金高于薪金的雇员
select * from emp where comm>sal
--4.找出佣金高于薪金的20%的雇员
select * from emp where comm>0.2*sal
--5.找出部门10中所有经理和部门20中所有办事员的详细资料
select * from emp where deptno=10 and job='MANAGER'
select * from emp where deptno=20 and job='CLERK'
--6.找出收取佣金的雇员的不同工作 
select job from emp where comm is not null and comm!=0
--7.找出不收取佣金或收取的佣金低于100的雇员
select * from emp where comm is null or comm=0 or comm<100
--8.显示雇员的详细资料,按姓名排序
select * from emp order by ename
--9.显示雇员姓名，根据其服务年限，将最老的雇员排在最前面
select ename,hiredate from emp order by hiredate 
--10.显示雇员姓名，工作和薪金，按工作的降序顺序排序，而工作按薪金排序

select ename,job,sal from emp order by job desc,sal
--11.显示雇员表中有多少个不同的部门
select distinct a.deptno,b.dname  from emp a,dept b where a.deptno=b.deptno 
--12.显示至少有一个雇员的所有部门。
select a.*,b.* from emp a,dept b where a.deptno=b.deptno and mgr is not null

--13.显示部门名称和这些部门的雇员姓名，同时列出那些没有雇员的部门
select a.*,b.* from dept a
left join emp b
on a.deptno=b.deptno