--1����ѯsmith�Ĺ�����нˮ�Ͳ���
select * from emp
select JOB,SAL,MGR from emp where ename='SMITH'

--��ѯԱ��һ��Ĺ��ʣ�sal*13��
select SAL*13 from emp

--��ѯ���ʸ���3000��Ա��
select * from emp where SAL>=3000

--��ѯ������800��1600֮���Ա��
select * from emp where SAL between 800 and 1600 

--��ѯ1982-1-1����ְ��Ա��
select * from emp where HIREDATE>'01-1��-1982';

--��ѯ������S��ʼ��Ա��
select * from emp where ENAME like 'S%';

--��ѯԱ�����ֵ�3���ַ���O��Ա��
select * from emp where ENAME like '__O%';

--��ѯԱ����Ϊ��7369��7499��7521��Ա��
select * from emp where EMPNO in('7369','7499','7521');

--��ѯû���ϼ���Ա��
select * from emp where mgr is  null

--��ѯ���ʴ���500����ְλΪmanager������������S��ͷ��Ա��
select * from emp where(sal>500 or JOB='manager')and ENAME like 'S%';

--��ѯԱ����Ϣ�����ղ��ź�������Ա���Ĺ��ʽ�������
select * from emp order by DEPTNO asc,SAL desc

--��ѯԱ����Ϣ�����ղ��ź�������Ա������ְʱ�併������
select * from emp order by DEPTNO asc,HIREDATE desc

--��ѯԱ����Ϣ������Ա������н��������
select * from emp order by SAL desc;

--��ѯ��߹���Ա������ϸ��Ϣ
select * from emp where SAL in(select max(SAL)from emp group by deptno)

--��ѯ��͹���Ա������ϸ��Ϣ
select * from emp where SAL in(select min(SAL)from emp group by deptno)

--��ѯ���ʸ��ڹ�˾ƽ�����ʵ�Ա����Ϣ
select * from emp where SAL>(select avg(SAL)from emp)

--��ѯ����ʾÿ�����ŵ���߹��ʡ���͹��ʡ������ղ��ű�Ž�������
select a.deptno,max(SAL),min(SAL) from emp a group by a.deptno order by a.deptno desc

--��ѯ����ʾÿ������ÿ����λ��ƽ�����ʺ���͹���
select a.deptno,JOB,avg(SAL),min(SAL)from emp a group by a.deptno order by JOB

--��ѯ����ʾƽ�����ʵ���2000�Ĳ��źź�����ƽ������
select avg(sal),max(sal),deptno from emp group by deptno having avg(sal)<2000

--��ѯԱ�����������ʺ͹��ʵȼ�
select ENAME,SAL,JOB from emp

--��ѯ����ʾԱ�����������ʡ������������������������⣬�������
--select ENAME,SAL from emp order by DEPTNO desc

--��ѯ����ʾָ��Ա�����ϼ��쵼������
select * from emp 
select a.*,b.* from emp a,emp b where a.mgr=b.empno and a.empno=7369

--��ѯԱ���Ĺ��ʴ���JONES��Ա����Ϣ 
select * from emp where SAL>(select SAL from emp where ENAME='JONES')

--��ѯ����ʾ��SMITHͬ���ŵ�Ա��
select * from emp where DEPTNO=(select DEPTNO from emp where ENAME='SMITH')

--��ѯ����ʾ�Ͳ���10Ա��ͬ��λ��Ա��,
select * from emp where JOB in(select JOB from emp where DEPTNO=10)

--��ѯ����ʾ��SMITHͬ����ͬ��λ��Ա��
select * from emp where (DEPTNO,JOB)=(select DEPTNO,JOB from emp where ENAME='SMITH')

--��ѯÿ�����Ź�����ߵ�Ա����Ϣ  
select max(sal),deptno from emp  group by deptno

--��ѯ���ʱȲ���30������Ա���Ĺ��ʸߵ�Ա�������������ʡ����ű��
select ename,sal,deptno from emp where sal>all(select sal from emp where deptno =30)

--��ѯ���ʱȲ���30������һ��Ա��,���ʸߵ�Ա�����������ʡ����ű��
select ename,sal,deptno from emp where sal>(select min(sal) from emp where deptno =30)

--��ѯ����ʾ�����Լ�����ƽ�����ʵ�Ա��
select * from emp a,(select avg(sal) avgsal,deptno from emp group by deptno) b
where a.deptno =b.deptno and a.sal> b.avgsal

--��ѯнˮ��ߵ�5��Ա������Ϣ
select * from (select * from emp order by sal desc ) where rownum <=5

--1.�г�����30�еĹ�Ա
select * from emp where DEPTNO=30

--2.�г����а���Ա����������źͲ���
select JOB,EMPNO,DEPTNO from emp

--3.�ҳ�Ӷ�����н��Ĺ�Ա
select * from emp where COMM>SAL

--4.�ҳ�Ӷ�����н���20%�Ĺ�Ա
select ename from emp where comm>(sal * 0.2)

--5.�ҳ�����10�����о���Ͳ���20�����а���Ա����ϸ����
select * from emp where (deptno = 10 and job='MANAGER') or(deptno = 20 and job='CLERK')

--6.�ҳ���ȡӶ��Ĺ�Ա�Ĳ�ͬ���� 
select distinct job from emp where comm is not null

--7.�ҳ�����ȡӶ�����ȡ��Ӷ�����100�Ĺ�Ա
select ename from emp where comm<100 or comm is null

--8.��ʾ��Ա����ϸ����,����������
select * from emp  order by ename

--9.��ʾ��Ա������������������ޣ������ϵĹ�Ա������ǰ��
select ename from emp   order by hiredate asc

--10.��ʾ��Ա������������н�𣬰������Ľ���˳�����򣬶�������н������
select ename,job,sal from emp order by job desc,sal asc

--11.��ʾ��Ա�����ж��ٸ���ͬ�Ĳ���
select distinct deptno from emp 

--12.��ʾ������һ����Ա�����в��š�
select emp.ename,dept.* from emp,dept where emp.deptno=dept.deptno

--13.��ʾ�������ƺ���Щ���ŵĹ�Ա������ͬʱ�г���Щû�й�Ա�Ĳ���
select a.*,b.* from dept a left join emp b
on a.deptno=b.deptno





