select * from emp
--查询smith的工作、薪水和部门
select job,sal,deptno from emp where ename='SMITH'
--查询员工一年的工资（sal*13）
select (sal*13) from emp 
--查询工资高于3000的员工
select ename from emp where sal>3000
--查询工资在800到1600之间的员工
select ename from emp where sal between 800 and 1600
--查询1982-1-1后入职的员工
select ename from emp where hiredate >'01-1月-1982'
--查询姓名以S开始的员工
select ename from emp where ename like 'S%'
--查询员工名字第3个字符是O的员工
select ename from emp where ename like '__O%'
--查询员工号为：7369、7499、7521的员工
select ename from emp where empno in (7369,7499,7521)
--查询没有上级的员工
select ename from emp where mgr is null
--查询工资大于500或者职位为manager，并且名字以S开头的员工
select ename,job from emp where (SAL>500 or JOB='MANAGER') and ename like 'S%'
--查询员工信息，按照部门号升序且员工的工资降序排列
select * from emp  order by deptno asc,sal desc
--查询员工信息，按照部门号升序且员工的入职时间降序排列
select * from emp order by deptno asc,hiredate desc
--查询员工信息，按照员工的年薪降序排列
select * from emp order by (sal*13) desc
--查询最高工资员工的详细信息
select * from emp where sal in (select max(sal) from emp)
--查询最低工资员工的详细信息
select * from emp where sal in (select min(sal) from emp)
--平均工资
select avg(sal) from emp
--查询工资高于公司平均工资的员工信息 
select * from emp where sal> (select avg(sal) from emp)
--查询并显示每个部门的最高工资、最低工资、并按照部门编号降序排列
select a.deptno,(select max(sal) from emp where deptno = a.deptno ) Maxsal,
(select min(sal) from emp where deptno = a.deptno )Minsal
from emp a order by a.deptno desc
--查询并显示平均工资低于2000的部门号和他的平均工资
select avg(sal),max(sal),deptno from emp group by deptno having avg(sal)<2000
--查询员工姓名、工资和工资等级
select e.ename,e.sal,s.grade from emp e,salgrade s where e.sal between s.losal and s.hisal
--查询并显示员工姓名、工资、部门名并按部门排序
select e.ename, e.sal,d.dname from emp e,dept d where e.deptno=d.deptno order by e.deptno
--查询并显示指定员工的上级领导的姓名
select w.ename, b.ename from emp w,emp b where w.mgr=b.empno and w.ename='FORD'
--查询员工的工资大于JONES的员工信息 
select * from emp where 
--查询并显示和SMITH同部门的员工
select * from emp where (deptno) =(select deptno from emp where ename='SMITH')
--查询并显示和部门10员工同岗位的员工
select * from emp where job in (select distinct job  from emp where deptno=10)
--查询并显示和SMITH同部门同岗位的员工
select * from emp where (deptno,job)=(select deptno,job from emp where  ename='SMITH')
--查询每个部门工资最高的员工信息 
select max(sal),deptno from emp  group by deptno
--查询工资比部门30的所有员工的工资高的员工的姓名、工资、部门编号
select ename,sal,deptno from emp where sal>all(select sal from emp where deptno =30)
--查询工资比部门30的任意一个员工工资高的员工姓名、工资、部门编号
select ename,sal,deptno from emp where sal>(select min(sal) from emp where deptno =30)
--查询并显示高于自己部门平均工资的员工
--select * from emp where sal>(select avg(sal) from emp)
select * from emp a,(select avg(sal) avgsal,deptno from emp group by deptno) b
where a.deptno =b.deptno and a.sal> b.avgsal
--查询薪水最高的5个员工的信息
select * from (select * from emp order by sal desc ) where rownum <=5
--列出部门30中的雇员
select * from emp where deptno =30
--列出所有办事员的姓名、编号和部门
select ename,empno,deptno from emp where JOB='CLERK'
--找出佣金高于薪金的雇员
select * from emp where COMM>SAL
