select * from emp
--1、查询smith的工作、薪水和部门
select sal,job,deptno from emp where ename = 'SMITH'
--2、查询员工一年的工资（sal*13）
select (sal*13) as "一年的工资" from emp
--3、查询工资高于3000的员工
select * from emp where sal>3000
--4、查询工资在800到1600之间的员工
select * from emp where sal>800 and sal <1600
--5、查询1982-1-1后入职的员工
select * from emp where hiredate>'01-1月-1982'
--6、查询姓名以S开始的员工
select * from emp where ename like 'S%'
--7、查询员工名字第3个字符是O的员工
select * from emp where ename like '__O%'
--8、查询员工号为：7369、7499、7521的员工
select * from emp where empno=7369 or empno=7499 or empno=7521
--9、查询没有上级的员工
select * from emp where mgr is null
--10、查询工资大于500或者职位为manager，并且名字以S开头的员工
select * from emp where ename like 'S%' and (sal>500 or job='MANAGER')
--11、查询员工信息，按照部门号升序且员工的工资降序排列
select * from emp
order by deptno,sal desc
--12、查询员工信息，按照部门号升序且员工的入职时间降序排列
select * from emp
order by deptno,hiredate desc
--13、查询员工信息，按照员工的年薪降序排列
select * from emp
order by sal
--14、查询最高工资员工的详细信息
select * from emp where sal=(select max(sal) from emp)
--15、查询最低工资员工的详细信息
select * from emp where sal=(select min(sal) from emp)
--16、查询工资高于公司平均工资的员工信息
select * from emp where sal>(select avg(sal) from emp)
--17、查询并显示每个部门的最高工资、最低工资、并按照部门编号降序排列
select distinct DEPTNO as 部门号,min(sal) as "最低工资",max(sal) as "最高工资" from emp
group by DEPTNO
order by DEPTNO
--18、查询并显示每个部门每个岗位的平均工资和最低工资
select distinct job as "岗位",min(sal) as "最低工资",avg(sal) as "平均工资" from emp
group by job
--19、查询并显示平均工资低于2000的部门号和他的平均工资
select distinct DEPTNO as "部门号",avg(sal) as "平均工资" from emp
group by deptno
having avg(sal)<2000
--20、查询员工姓名、工资和工资等级
select a.ename as "员工姓名",a.sal as "工资",b.grade as "工资等级" from emp a,salgrade b
where a.sal between b.losal and b.hisal
--21、查询并显示员工姓名、工资、部门名并按部门排序
select a.ename,a.sal,b.dname from emp a,dept b
where a.deptno = b.deptno
order by a.DEPTNO
--22、查询并显示指定员工的上级领导的姓名
select a.ename as "领导",b.ename as "员工" from emp a,emp b
where a.empno=b.mgr

select ename as "领导" from emp where empno = (select mgr from emp where ename='SMITH')
--23、查询员工的工资大于JONES的员工信息
select * from EMP where sal>(select sal from emp where ename='JONES')
--24、查询并显示和SMITH同部门的员工
select ename from emp where deptno = (select deptno from emp where ename='SMITH')
--25、查询并显示和部门10员工同岗位的员工
select * from emp where job in(select job from emp where deptno=10)
order by deptno
--26、查询并显示和SMITH同部门同岗位的员工
select * from emp where deptno = (select deptno from emp where ename='SMITH') and job =(select job from emp where ename='SMITH')
--27、查询每个部门工资最高的员工信息
select * from emp a,(select deptno,max(sal) maxsal from emp group by deptno) b
where a.deptno=b.deptno and a.sal=b.maxsal
--28、查询工资比部门30的所有员工的工资高的员工的姓名、工资、部门编号
select * from emp where sal>(select max(sal) from emp where deptno = 30)
--29、查询工资比部门30的任意一个员工工资高的员工姓名、工资、部门编号
select * from emp where sal>(select max(sal) from emp where deptno = 30)
--30、查询并显示高于自己部门平均工资的员工
select * from emp where sal>(select avg(sal) from emp)
--31、查询薪水最高的5个员工的信息
select * from (select * from emp order by sal desc ) where rownum <=5
