--�ҳ�Ӷ�����н���20%�Ĺ�Ա
select ename from emp where comm>(sal * 0.2)
--�ҳ�����10�����о���Ͳ���20�����а���Ա����ϸ����
select * from emp where (deptno = 10 and job='MANAGER') or(deptno = 20 and job='CLERK')
--�ҳ���ȡӶ��Ĺ�Ա�Ĳ�ͬ���� 
select distinct job from emp where comm is not null
--�ҳ�����ȡӶ�����ȡ��Ӷ�����100�Ĺ�Ա
select ename from emp where comm<100 or comm is null
--��ʾ��Ա����ϸ����,����������
select * from emp  order by ename
--��ʾ��Ա������������������ޣ������ϵĹ�Ա������ǰ��
select ename from emp   order by hiredate asc
--��ʾ��Ա������������н�𣬰������Ľ���˳�����򣬶�������н������
select ename,job,sal from emp order by job desc,sal asc
--��ʾ��Ա�����ж��ٸ���ͬ�Ĳ���
select distinct deptno from emp 
--��ʾ������һ����Ա�����в��š�
select emp.ename,dept.* from emp,dept where emp.deptno=dept.deptno
--��ʾ�������ƺ���Щ���ŵĹ�Ա������ͬʱ�г���Щû�й�Ա�Ĳ���
select a.*,b.* from dept a left join emp b
on a.deptno=b.deptno

--��ѯ����ʾÿ������ÿ����λ��ƽ�����ʺ���͹���
select min(sal),avg(sal) ,deptno ,job from emp group by deptno,job;



