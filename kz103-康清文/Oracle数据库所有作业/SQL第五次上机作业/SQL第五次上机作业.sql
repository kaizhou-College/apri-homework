select * from studentinfo
--1����ѯ����ѧԱ����ѧ�����죬һ���ȹ��˶����� 
select STUJOINTIME from studentinfo
select floor  (months_between(sysdate,STUJOINTIME))*30 from studentinfo

--2����ѯ��ĳ������ڵ��������������������/12��
select months_between (sysdate,to_date('1997-02-03','yyyy-mm-dd'))/12 from dual

--3����ѯÿ��2����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(day from STUJOINTIME)=2

--4����ѯ����ѧԱ�ı�ҵ���ڣ��ٶ���ÿ��ѧԱ��ѧʱ��1���֮�󽫱�ҵ��
select add_months(STUJOINTIME,18) from studentinfo

--5����ѯ��������ѧ��ѧԱ�������Ա����䣬�༶���   =5?
select stuname,stusex,stuage,stunumber,stujointime from studentinfo
where extract(day from next_day(STUJOINTIME,'������')-7)=extract(day from STUJOINTIME) and sclassid=2


--6����ѯ��2007-3-10��֮ǰ��ѧ��ѧԱ��Ϣ
select * from studentinfo where STUJOINTIME<'10-3��-07'

--7����ѯ����ѧԱ�����ĳ���
select length(STUNAME) from studentinfo

--8����ѯ���֤�е�9��10λΪ��89����ѧԱ��Ϣ��Ҫ��ʹ���ַ���������
select * from studentinfo where substr(stucard,9,2)='89'

--9���޸İ�������Ϣ���������еġ�yahoo���滻Ϊ��geekgroup��
select replace (TEACHEREMAIL,'yahoo','geekgroup') from teacherinfo

--10����д��ѯ���ȥ���ַ�����   �����Ұ���   ���еĿո�
select ltrim('  �����Ұ���   ')from dual

--11������ÿ��ѧԱ���֤���ַ���1�����ֵĴ���
select length(stucard)-length(replace(stucard,'1')) from studentinfo

--12����С��-58.9���������
select floor(-58.9) from dual

--13�������78.8����С����
select ceil(78.8) from dual

--14����64����7������
select mod(64,7)from dual

--15����ѯ����ѧԱ��ѧʱ�䣬Ҫ����ʾ��ʽΪ��2007��03��02�ա�
select to_char(STUJOINTIME,'yyyy"��"-mm"��"-dd"��') from studentinfo 

--16����ѯ��ǰʱ�䣬Ҫ����ʾ��ʽΪ��22ʱ57:37��
select to_char(sysdate,'hh24"ʱ":mi:ss') from dual

--17����ѯ2007����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(year from STUJOINTIME)=2007
select * from studentinfo

--��ϰ�������麯����ϰ
--1����ѯ����ѧԱ��ƽ�����䣨Ҫ������λС����
select round(avg(STUAGE),2) from studentinfo

--2����ѯ���п��Ե��ܳɼ�
select sum(EXAMRESULT) from studentexam

--3����ѯSQL���Ե���ͷ���
select min(EXAMRESULT) from studentexam where EXAMSUBJECT='SQL'

--4����ѯJava���Գɼ���ߵ�ѧԱ����
select b.stuname from(select estuid from studentexam where EXAMRESULT=(select max(EXAMRESULT)from studentexam where EXAMSUBJECT='Java'))a,studentinfo b
select * from studentexam
--5����ѯѧԱ������а��һ���μ��˼��ο���
select count(EXAMRESULT) from (select * from studentinfo where stuname='����а��')a,studentexam b 
where a.stuid=b.estuid

--6����ѯ����Ŀ��ƽ���ɼ�
select avg(EXAMRESULT) from studentexam

--7����ѯÿ���༶ѧԱ����С����
select min(STUAGE) from studentinfo

--8����ѯ���Բ����������
select * from studentexam where EXAMRESULT<=70

--9����ѯ��ѧԱ���ܳɼ���Ҫ��ɸѡ���ܳɼ���140�����ϵ�
select * from studentexam where EXAMRESULT>140

--10����ѯ��ŮѧԱ��ƽ������
select avg(STUAGE),STUSEX from studentinfo group by STUSEX

--11����ѯÿ�Ź��ε�ƽ���֣�Ҫ����ʾƽ������80�����ϵ�(����80��)
select avg(EXAMRESULT),EXAMSUBJECT from studentexam group by EXAMSUBJECT having avg(EXAMRESULT)>=80




















