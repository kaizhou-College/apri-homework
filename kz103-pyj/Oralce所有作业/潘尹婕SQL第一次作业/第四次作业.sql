select * from emp
--��ѯsmith�Ĺ�����нˮ�Ͳ���
select job,sal,deptno from emp where ename='SMITH'
--��ѯԱ��һ��Ĺ��ʣ�sal*13��
select (sal*13) from emp 
--��ѯ���ʸ���3000��Ա��
select ename from emp where sal>3000
--��ѯ������800��1600֮���Ա��
select ename from emp where sal between 800 and 1600
--��ѯ1982-1-1����ְ��Ա��
select ename from emp where hiredate >'01-1��-1982'
--��ѯ������S��ʼ��Ա��
select ename from emp where ename like 'S%'
--��ѯԱ�����ֵ�3���ַ���O��Ա��
select ename from emp where ename like '__O%'
--��ѯԱ����Ϊ��7369��7499��7521��Ա��
select ename from emp where empno in (7369,7499,7521)
--��ѯû���ϼ���Ա��
select ename from emp where mgr is null
--��ѯ���ʴ���500����ְλΪmanager������������S��ͷ��Ա��
select ename,job from emp where (SAL>500 or JOB='MANAGER') and ename like 'S%'
--��ѯԱ����Ϣ�����ղ��ź�������Ա���Ĺ��ʽ�������
select * from emp  order by deptno asc,sal desc
--��ѯԱ����Ϣ�����ղ��ź�������Ա������ְʱ�併������
select * from emp order by deptno asc,hiredate desc
--��ѯԱ����Ϣ������Ա������н��������
select * from emp order by (sal*13) desc
--��ѯ��߹���Ա������ϸ��Ϣ
select * from emp where sal in (select max(sal) from emp)
--��ѯ��͹���Ա������ϸ��Ϣ
select * from emp where sal in (select min(sal) from emp)
--ƽ������
select avg(sal) from emp
--��ѯ���ʸ��ڹ�˾ƽ�����ʵ�Ա����Ϣ 
select * from emp where sal> (select avg(sal) from emp)
--��ѯ����ʾÿ�����ŵ���߹��ʡ���͹��ʡ������ղ��ű�Ž�������
select a.deptno,(select max(sal) from emp where deptno = a.deptno ) Maxsal,
(select min(sal) from emp where deptno = a.deptno )Minsal
from emp a order by a.deptno desc
--��ѯ����ʾƽ�����ʵ���2000�Ĳ��źź�����ƽ������
select avg(sal),max(sal),deptno from emp group by deptno having avg(sal)<2000
--��ѯԱ�����������ʺ͹��ʵȼ�
select e.ename,e.sal,s.grade from emp e,salgrade s where e.sal between s.losal and s.hisal
--��ѯ����ʾԱ�����������ʡ�������������������
select e.ename, e.sal,d.dname from emp e,dept d where e.deptno=d.deptno order by e.deptno
--��ѯ����ʾָ��Ա�����ϼ��쵼������
select w.ename, b.ename from emp w,emp b where w.mgr=b.empno and w.ename='FORD'
--��ѯԱ���Ĺ��ʴ���JONES��Ա����Ϣ 
select * from emp where 
--��ѯ����ʾ��SMITHͬ���ŵ�Ա��
select * from emp where (deptno) =(select deptno from emp where ename='SMITH')
--��ѯ����ʾ�Ͳ���10Ա��ͬ��λ��Ա��
select * from emp where job in (select distinct job  from emp where deptno=10)
--��ѯ����ʾ��SMITHͬ����ͬ��λ��Ա��
select * from emp where (deptno,job)=(select deptno,job from emp where  ename='SMITH')
--��ѯÿ�����Ź�����ߵ�Ա����Ϣ 
select max(sal),deptno from emp  group by deptno
--��ѯ���ʱȲ���30������Ա���Ĺ��ʸߵ�Ա�������������ʡ����ű��
select ename,sal,deptno from emp where sal>all(select sal from emp where deptno =30)
--��ѯ���ʱȲ���30������һ��Ա�����ʸߵ�Ա�����������ʡ����ű��
select ename,sal,deptno from emp where sal>(select min(sal) from emp where deptno =30)
--��ѯ����ʾ�����Լ�����ƽ�����ʵ�Ա��
--select * from emp where sal>(select avg(sal) from emp)
select * from emp a,(select avg(sal) avgsal,deptno from emp group by deptno) b
where a.deptno =b.deptno and a.sal> b.avgsal
--��ѯнˮ��ߵ�5��Ա������Ϣ
select * from (select * from emp order by sal desc ) where rownum <=5
--�г�����30�еĹ�Ա
select * from emp where deptno =30
--�г����а���Ա����������źͲ���
select ename,empno,deptno from emp where JOB='CLERK'
--�ҳ�Ӷ�����н��Ĺ�Ա
select * from emp where COMM>SAL
