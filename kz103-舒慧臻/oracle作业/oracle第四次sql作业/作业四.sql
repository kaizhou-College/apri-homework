-----��ѯsmith�Ĺ�����нˮ�Ͳ���
select job as "����" , sal as "нˮ" , deptno as "����" from emp
where ename = 'SMITH'

----��ѯԱ��һ��Ĺ��ʣ�sal*13��
select (sal*13) as "����" from emp
 
----��ѯ���ʸ���3000��Ա��
select ename as "Ա������" from emp where sal > 3000

----��ѯ������800��1600֮���Ա��
select ename as "Ա������" from emp where sal between 800 and 1600

----��ѯ1982-1-1����ְ��Ա��
select ename as "Ա������" from emp where hiredate > '01-1��-1982'

----��ѯ������S��ʼ��Ա��
select ename as "Ա������" from emp where ename like 'S%'

----��ѯԱ�����ֵ�3���ַ���O��Ա��
select ename as "Ա������" from emp where ename like '__O%'

----��ѯԱ����Ϊ��7369��7499��7521��Ա��
select * from emp where empno in (7369 , 7499 , 7521)

----��ѯû���ϼ���Ա��
select * from emp where mgr is null

----��ѯ���ʴ���500����ְλΪmanager������������S��ͷ��Ա��
select * from emp where (sal>500 or job='MANAGER') and  ename like 'S%'

----��ѯԱ����Ϣ�����ղ��ź�������Ա���Ĺ��ʽ�������
select * from emp order by deptno asc , sal desc

-----��ѯԱ����Ϣ�����ղ��ź�������Ա������ְʱ�併������
select * from emp order by deptno asc , hiredate desc;

----��ѯԱ����Ϣ������Ա������н��������
select * from emp order by (sal*13) desc

-----��ѯ��߹���Ա������ϸ��Ϣ
select * from emp where sal in( select max(sal) from emp)
select rownum,a.* from (select * from emp order by sal desc ) a where rownum = 1


------��ѯ��͹���Ա������ϸ��Ϣ
select * from emp where sal in( select min(sal) from emp)

-----��ѯ���ʸ��ڹ�˾ƽ�����ʵ�Ա����Ϣ
select * from emp where sal>(select avg(sal) from emp)

-----��ѯ����ʾÿ�����ŵ���߹��ʡ���͹��ʡ������ղ��ű�Ž�������
select * from emp where sal = (select max(sal) from emp ) a 


-----��ѯ����ʾÿ������ÿ����λ��ƽ�����ʺ���͹���
 select avg(sal),min(sal),deptno,job from emp group by deptno,job
 
 
----��ѯ����ʾƽ�����ʵ���2000�Ĳ��źź�����ƽ������
select avg(sal),max(sal),deptno from emp group by deptno having avg(sal)<2000

----��ѯԱ�����������ʺ͹��ʵȼ�
select e.ename  , e.sal , s.grade from emp e ,salgrade s where e.sal between s.losal and s.hisal

----��ѯ����ʾԱ�����������ʡ�������������������
select e.ename, e.sal,d.dname from emp e , dept d where e.deptno = d.deptno order by e.deptno 
 
----��ѯ����ʾָ��Ա�����ϼ��쵼������
select w.ename,boss.ename from emp w,emp boss where w.mgr = boss.empno and w.ename = 'FORD'

----��ѯԱ���Ĺ��ʴ���JONES��Ա����Ϣ
select e.ename ,e.sal from emp e where sal > (select sal from emp where ename='JONES')

----��ѯ����ʾ��SMITHͬ���ŵ�Ա��
select * from emp where deptno =  (select deptno from emp where ename = 'SMITH')

----��ѯ����ʾ�Ͳ���10Ա��ͬ��λ��Ա��
select * from emp where job in (select distinct job from emp where deptno = 10);

----��ѯ����ʾ��SMITHͬ����ͬ��λ��Ա��
select * from emp where job = (select distinct job from emp
where ename = 'SMITH') 
and deptno = (select distinct deptno from emp where ename='SMITH');

----��ѯÿ�����Ź�����ߵ�Ա����Ϣ  
select * from emp where sal in (select max(sal) from emp group by deptno) ;

----��ѯ���ʱȲ���30������Ա���Ĺ��ʸߵ�Ա�������������ʡ����ű��
select * from emp where sal >(select max(sal) from emp e  where deptno = 30);

-----��ѯ���ʱȲ���30������һ��Ա�����ʸߵ�Ա�����������ʡ����ű��
select * from emp where sal >(select max(sal) from emp e  where deptno = 30);

-----��ѯ����ʾ�����Լ�����ƽ�����ʵ�Ա��
select a.*,b.* from emp a,
(select deptno ,avg(sal) ss from emp group by deptno) b
where a.deptno = b.deptno  and a.sal > b.ss


-----��ѯнˮ��ߵ�5��Ա������Ϣ
select * from (select * from emp order by sal desc ) where rownum<=5;


---------------��ϰ��

-----�г�����30�еĹ�Ա
select * from emp where deptno=30;

-----�г����а���Ա����������źͲ���
select ename,empno,deptno from emp where job='CLERK';

----�ҳ�Ӷ�����н��Ĺ�Ա
select ename from emp where comm>sal;

----�ҳ�Ӷ�����н���20%�Ĺ�Ա
select ename from emp where comm>(sal*0.2);

-----�ҳ�����10�����о���Ͳ���20�����а���Ա����ϸ����
select * from emp where (deptno=10 and job='MANAGER') or (deptno = 20 and job='CLERK');

-----�ҳ���ȡӶ��Ĺ�Ա�Ĳ�ͬ���� 
select job from emp where comm is not null;

-----�ҳ�����ȡӶ�����ȡ��Ӷ�����100�Ĺ�Ա
select ename from emp where comm is null or comm<100;

-----��ʾ��Ա����ϸ����,����������
select * from emp order by ename;

-----��ʾ��Ա������������������ޣ������ϵĹ�Ա������ǰ��
select ename from emp order by hiredate ;

-----��ʾ��Ա������������н�𣬰������Ľ���˳�����򣬶�������н������
select ename , job , sal from emp order by job desc , sal ;

-----��ʾ��Ա�����ж��ٸ���ͬ�Ĳ���
select distinct deptno from emp;

-----��ʾ������һ����Ա�����в���
select b.ss,a.deptno from dept a,
(select deptno,count(ename) ss from emp group by deptno) b
where a.deptno = b.deptno and ss>=1;

----��ʾ�������ƺ���Щ���ŵĹ�Ա������ͬʱ�г���Щû�й�Ա�Ĳ���
select a.*,b.* from dept a
left join
emp b
on a.deptno = b.deptno 
