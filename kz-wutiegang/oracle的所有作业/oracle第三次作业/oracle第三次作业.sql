grant dba to scott


--1����ѯ����ѧԱ��Ϣ

select * from studentinfo

--2����ѯ����ѧԱ�����������䣨Ҫ��������������ʾ��

select stuname ����,stuage ���� from studentinfo

--3����ѯѧԱ�����乲���ļ���ֵ��Ҫ�󲻼����ظ��

select distinct stuage from studentinfo

--4����ѯ����Ů��ѧԱ����Ϣ

select * from studentinfo where stusex='Ů'

--5����ѯ�����к��С����ֵ�ѧ������Ϣ��

select * from studentinfo where stuname like '%��%'


--6����ѯѧԱ��Ϣ

select ('����'||a.stuname||',����'||a.stuage||',��ס'||a.stuaddress) ѧԱ��Ϣ from studentinfo a

--7����ѯ����С��20�꣬��ס��ɳ������ѧԱ��Ϣ

select * from studentinfo where stuage<20 and stuaddress like '%��ɳ%' and stusex='��'

--8����ѯ������16-18��(����16,18��)��ѧԱ��Ϣ

select * from studentinfo where stuage between 16 and 18
--9����ѯ���֤�а����С�1989���ַ���ѧԱ��Ϣ
select * from studentinfo where stucard like '%1989%'
--10����ѯ��2007-3-5������ѧ��ѧԱ��Ϣ
select * from studentinfo where stujointime>'05-3��-07'
--11����ѯ�����ַΪyahoo�İ�������Ϣ
select * from teacherinfo where teacheremail like '%yahoo%'
--12����ѯ�ֻ��ԡ�139����ͷ�İ�������Ϣ
select * from teacherinfo where teachertel like '139%'
--13����ѯ���䲻Ϊ������ѧԱ��ѧ�ţ�������סַ
select stunumber,stuname,stuaddress from studentinfo where stuage is not null and stusex='��'
--14����ѯѧ���ڡ�001��,��003��,��004������֮���ѧԱ��������ѧʱ��
select stuname,stujointime from studentinfo where stunumber in('001','003','004')
--15����ѯ����ѧԱ��Ϣ���������併������
select * from studentinfo order by stuage desc
--16����ѯ���гɼ��������Է����������򣬷�����ͬ�ģ���ѧԱ�����������
select * from studentexam order by examresult desc,estuid asc




--1����ѯsmith�Ĺ�����нˮ�Ͳ���
select job,sal,dname from emp a,dept b where ename='SMITH' and a.deptno=b.deptno
--2����ѯԱ��һ��Ĺ��ʣ�sal*13��
select sal*13 from emp
--3����ѯ���ʸ���3000��Ա��
select * from emp where sal>3000
--4����ѯ������800��1600֮���Ա��
select * from emp where sal between 800 and 1600
--5����ѯ1982-1-1����ְ��Ա��
select * from emp where hiredate>'01-1��-82'
--6����ѯ������S��ʼ��Ա��
select * from emp where ename like 'S%'
--7����ѯԱ�����ֵ�3���ַ���O��Ա��
select * from emp where ename like '__O%'
--8����ѯԱ����Ϊ��7369��7499��7521��Ա��
select * from emp where empno in('7369','7499','7521')
--9����ѯû���ϼ���Ա��
select * from emp where mgr is null
--10����ѯ���ʴ���500����ְλΪmanager������������S��ͷ��Ա��
select * from emp where (sal>500 or job='MANAGER') and ename like 'S%'
--11����ѯԱ����Ϣ�����ղ��ź�������Ա���Ĺ��ʽ�������
select * from emp order by deptno,sal desc

--12����ѯԱ����Ϣ�����ղ��ź�������Ա������ְʱ�併������
select * from emp  order by deptno,hiredate desc
--13����ѯԱ����Ϣ������Ա������н��������
select * from emp order by (sal*13) desc
--14����ѯ��߹���Ա������ϸ��Ϣ
select * from emp where sal in(select max(sal) from emp group by deptno)

--15����ѯ��͹���Ա������ϸ��Ϣ
select * from emp where sal in(select min(sal) from emp group by deptno)
--16����ѯ���ʸ��ڹ�˾ƽ�����ʵ�Ա����Ϣ
select * from emp where sal>(select avg(sal) from emp)
--17����ѯ����ʾÿ�����ŵ���߹��ʡ���͹��ʡ������ղ��ű�Ž�������

select a.deptno,max(sal),min(sal) from emp a group by a.deptno order by a.deptno desc

--18����ѯ����ʾÿ������ÿ����λ��ƽ�����ʺ���͹���
select a.deptno,a.job, avg(sal),min(sal) from emp a group by a.deptno order by job

--19����ѯ����ʾƽ�����ʵ���2000�Ĳ��źź�����ƽ������
select deptno, avg(sal) avg,(select * from emp where ename='SMITH') from emp where avg<2000 group by deptno

--20����ѯԱ�����������ʺ͹��ʵȼ�
select ename, sal from emp order by sal
--21����ѯ����ʾԱ�����������ʡ�������������������
select ename,sal,dname from emp,dept where emp.deptno=dept.deptno order by dname
--22����ѯ����ʾָ��Ա�����ϼ��쵼������
select a.*,b.* from emp a,emp b where a.mgr=b.empno and a.empno=7369

--23����ѯԱ���Ĺ��ʴ���JONES��Ա����Ϣ 
select * from emp where sal>(select sal FROM EMP WHERE ename='JONES')
--24����ѯ����ʾ��SMITHͬ���ŵ�Ա��
select * from emp where deptno=(select deptno from emp where ename='SMITH')

--25����ѯ����ʾ�Ͳ���10Ա��ͬ��λ��Ա��
select * from emp where job in(select job from emp where deptno=10)
 
--26����ѯ����ʾ��SMITHͬ����ͬ��λ��Ա��
select * from emp where deptno in(select deptno from emp where ename='SMITH') and job in(select job from emp where ename='SMITH')
--27����ѯÿ�����Ź�����ߵ�Ա����Ϣ  

select * from emp where sal in(select max(sal) from emp group by deptno)
--28����ѯ���ʱȲ���30������Ա���Ĺ��ʸߵ�Ա�������������ʡ����ű��
select ename,sal,deptno from emp where sal>(select max(sal) from emp where deptno=30)
--29����ѯ���ʱȲ���30������һ��Ա�����ʸߵ�Ա�����������ʡ����ű��
select ename,sal,deptno from emp where sal>(select max(sal) from emp where deptno=30)
--30����ѯ����ʾ�����Լ�����ƽ�����ʵ�Ա��
select * from emp where sal>(select avg(sal) from emp )
--31����ѯнˮ��ߵ�5��Ա������Ϣ
select *from emp where sal in(select rownum,sal from emp where rownum<=5 order by sal desc)







