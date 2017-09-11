grant dba to scott


--1、查询所有学员信息

select * from studentinfo

--2、查询所有学员的姓名，年龄（要求列名用中文显示）

select stuname 姓名,stuage 年龄 from studentinfo

--3、查询学员的年龄共有哪几种值（要求不计算重复项）

select distinct stuage from studentinfo

--4、查询所有女性学员的信息

select * from studentinfo where stusex='女'

--5、查询姓名中含有’火’字的学生的信息。

select * from studentinfo where stuname like '%火%'


--6、查询学员信息

select ('姓名'||a.stuname||',年龄'||a.stuage||',家住'||a.stuaddress) 学员信息 from studentinfo a

--7、查询年龄小于20岁，家住长沙的男性学员信息

select * from studentinfo where stuage<20 and stuaddress like '%长沙%' and stusex='男'

--8、查询年龄在16-18岁(包括16,18岁)的学员信息

select * from studentinfo where stuage between 16 and 18
--9、查询身份证中包含有‘1989’字符的学员信息
select * from studentinfo where stucard like '%1989%'
--10、查询‘2007-3-5’后入学的学员信息
select * from studentinfo where stujointime>'05-3月-07'
--11、查询邮箱地址为yahoo的班主任信息
select * from teacherinfo where teacheremail like '%yahoo%'
--12、查询手机以‘139’开头的班主任信息
select * from teacherinfo where teachertel like '139%'
--13、查询年龄不为空男性学员的学号，姓名，住址
select stunumber,stuname,stuaddress from studentinfo where stuage is not null and stusex='男'
--14、查询学号在‘001’,‘003’,‘004’三者之间的学员姓名和入学时间
select stuname,stujointime from studentinfo where stunumber in('001','003','004')
--15、查询所有学员信息，并按年龄降序排序
select * from studentinfo order by stuage desc
--16、查询所有成绩，按考试分数降序排序，分数相同的，按学员编号升序排序
select * from studentexam order by examresult desc,estuid asc




--1、查询smith的工作、薪水和部门
select job,sal,dname from emp a,dept b where ename='SMITH' and a.deptno=b.deptno
--2、查询员工一年的工资（sal*13）
select sal*13 from emp
--3、查询工资高于3000的员工
select * from emp where sal>3000
--4、查询工资在800到1600之间的员工
select * from emp where sal between 800 and 1600
--5、查询1982-1-1后入职的员工
select * from emp where hiredate>'01-1月-82'
--6、查询姓名以S开始的员工
select * from emp where ename like 'S%'
--7、查询员工名字第3个字符是O的员工
select * from emp where ename like '__O%'
--8、查询员工号为：7369、7499、7521的员工
select * from emp where empno in('7369','7499','7521')
--9、查询没有上级的员工
select * from emp where mgr is null
--10、查询工资大于500或者职位为manager，并且名字以S开头的员工
select * from emp where (sal>500 or job='MANAGER') and ename like 'S%'
--11、查询员工信息，按照部门号升序且员工的工资降序排列
select * from emp order by deptno,sal desc

--12、查询员工信息，按照部门号升序且员工的入职时间降序排列
select * from emp  order by deptno,hiredate desc
--13、查询员工信息，按照员工的年薪降序排列
select * from emp order by (sal*13) desc
--14、查询最高工资员工的详细信息
select * from emp where sal in(select max(sal) from emp group by deptno)

--15、查询最低工资员工的详细信息
select * from emp where sal in(select min(sal) from emp group by deptno)
--16、查询工资高于公司平均工资的员工信息
select * from emp where sal>(select avg(sal) from emp)
--17、查询并显示每个部门的最高工资、最低工资、并按照部门编号降序排列

select a.deptno,max(sal),min(sal) from emp a group by a.deptno order by a.deptno desc

--18、查询并显示每个部门每个岗位的平均工资和最低工资
select a.deptno,a.job, avg(sal),min(sal) from emp a group by a.deptno order by job

--19、查询并显示平均工资低于2000的部门号和他的平均工资
select deptno, avg(sal) avg,(select * from emp where ename='SMITH') from emp where avg<2000 group by deptno

--20、查询员工姓名、工资和工资等级
select ename, sal from emp order by sal
--21、查询并显示员工姓名、工资、部门名并按部门排序
select ename,sal,dname from emp,dept where emp.deptno=dept.deptno order by dname
--22、查询并显示指定员工的上级领导的姓名
select a.*,b.* from emp a,emp b where a.mgr=b.empno and a.empno=7369

--23、查询员工的工资大于JONES的员工信息 
select * from emp where sal>(select sal FROM EMP WHERE ename='JONES')
--24、查询并显示和SMITH同部门的员工
select * from emp where deptno=(select deptno from emp where ename='SMITH')

--25、查询并显示和部门10员工同岗位的员工
select * from emp where job in(select job from emp where deptno=10)
 
--26、查询并显示和SMITH同部门同岗位的员工
select * from emp where deptno in(select deptno from emp where ename='SMITH') and job in(select job from emp where ename='SMITH')
--27、查询每个部门工资最高的员工信息  

select * from emp where sal in(select max(sal) from emp group by deptno)
--28、查询工资比部门30的所有员工的工资高的员工的姓名、工资、部门编号
select ename,sal,deptno from emp where sal>(select max(sal) from emp where deptno=30)
--29、查询工资比部门30的任意一个员工工资高的员工姓名、工资、部门编号
select ename,sal,deptno from emp where sal>(select max(sal) from emp where deptno=30)
--30、查询并显示高于自己部门平均工资的员工
select * from emp where sal>(select avg(sal) from emp )
--31、查询薪水最高的5个员工的信息
select *from emp where sal in(select rownum,sal from emp where rownum<=5 order by sal desc)







