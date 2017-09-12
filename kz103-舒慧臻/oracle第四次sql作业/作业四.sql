-----查询smith的工作、薪水和部门
select job as "工作" , sal as "薪水" , deptno as "部门" from emp
where ename = 'SMITH'

----查询员工一年的工资（sal*13）
select (sal*13) as "工资" from emp
 
----查询工资高于3000的员工
select ename as "员工姓名" from emp where sal > 3000

----查询工资在800到1600之间的员工
select ename as "员工姓名" from emp where sal between 800 and 1600

----查询1982-1-1后入职的员工
select ename as "员工姓名" from emp where hiredate > '01-1月-1982'

----查询姓名以S开始的员工
select ename as "员工姓名" from emp where ename like 'S%'

----查询员工名字第3个字符是O的员工
select ename as "员工姓名" from emp where ename like '__O%'

----查询员工号为：7369、7499、7521的员工
select * from emp where empno in (7369 , 7499 , 7521)

----查询没有上级的员工
select * from emp where mgr is null

----查询工资大于500或者职位为manager，并且名字以S开头的员工
select * from emp where (sal>500 or job='MANAGER') and  ename like 'S%'

----查询员工信息，按照部门号升序且员工的工资降序排列
select * from emp order by deptno asc , sal desc

-----查询员工信息，按照部门号升序且员工的入职时间降序排列
select * from emp order by deptno asc , hiredate desc;

----查询员工信息，按照员工的年薪降序排列
select * from emp order by (sal*13) desc

-----查询最高工资员工的详细信息
select * from emp where sal in( select max(sal) from emp)
select rownum,a.* from (select * from emp order by sal desc ) a where rownum = 1


------查询最低工资员工的详细信息
select * from emp where sal in( select min(sal) from emp)

-----查询工资高于公司平均工资的员工信息
select * from emp where sal>(select avg(sal) from emp)

-----查询并显示每个部门的最高工资、最低工资、并按照部门编号降序排列
select * from emp where sal = (select max(sal) from emp ) a 


-----查询并显示每个部门每个岗位的平均工资和最低工资
 select avg(sal),min(sal),deptno,job from emp group by deptno,job
 
 
----查询并显示平均工资低于2000的部门号和他的平均工资
select avg(sal),max(sal),deptno from emp group by deptno having avg(sal)<2000

----查询员工姓名、工资和工资等级
select e.ename  , e.sal , s.grade from emp e ,salgrade s where e.sal between s.losal and s.hisal

----查询并显示员工姓名、工资、部门名并按部门排序
select e.ename, e.sal,d.dname from emp e , dept d where e.deptno = d.deptno order by e.deptno 
 
----查询并显示指定员工的上级领导的姓名
select w.ename,boss.ename from emp w,emp boss where w.mgr = boss.empno and w.ename = 'FORD'

----查询员工的工资大于JONES的员工信息
select e.ename ,e.sal from emp e where sal > (select sal from emp where ename='JONES')

----查询并显示和SMITH同部门的员工
select * from emp where deptno =  (select deptno from emp where ename = 'SMITH')

----查询并显示和部门10员工同岗位的员工
select * from emp where job in (select distinct job from emp where deptno = 10);

----查询并显示和SMITH同部门同岗位的员工
select * from emp where job = (select distinct job from emp
where ename = 'SMITH') 
and deptno = (select distinct deptno from emp where ename='SMITH');

----查询每个部门工资最高的员工信息  
select * from emp where sal in (select max(sal) from emp group by deptno) ;

----查询工资比部门30的所有员工的工资高的员工的姓名、工资、部门编号
select * from emp where sal >(select max(sal) from emp e  where deptno = 30);

-----查询工资比部门30的任意一个员工工资高的员工姓名、工资、部门编号
select * from emp where sal >(select max(sal) from emp e  where deptno = 30);

-----查询并显示高于自己部门平均工资的员工
select a.*,b.* from emp a,
(select deptno ,avg(sal) ss from emp group by deptno) b
where a.deptno = b.deptno  and a.sal > b.ss


-----查询薪水最高的5个员工的信息
select * from (select * from emp order by sal desc ) where rownum<=5;


---------------练习二

-----列出部门30中的雇员
select * from emp where deptno=30;

-----列出所有办事员的姓名、编号和部门
select ename,empno,deptno from emp where job='CLERK';

----找出佣金高于薪金的雇员
select ename from emp where comm>sal;

----找出佣金高于薪金的20%的雇员
select ename from emp where comm>(sal*0.2);

-----找出部门10中所有经理和部门20中所有办事员的详细资料
select * from emp where (deptno=10 and job='MANAGER') or (deptno = 20 and job='CLERK');

-----找出收取佣金的雇员的不同工作 
select job from emp where comm is not null;

-----找出不收取佣金或收取的佣金低于100的雇员
select ename from emp where comm is null or comm<100;

-----显示雇员的详细资料,按姓名排序
select * from emp order by ename;

-----显示雇员姓名，根据其服务年限，将最老的雇员排在最前面
select ename from emp order by hiredate ;

-----显示雇员姓名，工作和薪金，按工作的降序顺序排序，而工作按薪金排序
select ename , job , sal from emp order by job desc , sal ;

-----显示雇员表中有多少个不同的部门
select distinct deptno from emp;

-----显示至少有一个雇员的所有部门
select b.ss,a.deptno from dept a,
(select deptno,count(ename) ss from emp group by deptno) b
where a.deptno = b.deptno and ss>=1;

----显示部门名称和这些部门的雇员姓名，同时列出那些没有雇员的部门
select a.*,b.* from dept a
left join
emp b
on a.deptno = b.deptno 
