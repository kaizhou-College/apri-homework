--1����ѯ����ѧԱ��ƽ�����䣨Ҫ������λС����
select trunc(avg(stuage),2) from studentinfo
--2����ѯ���п��Ե��ܳɼ�
select sum(examresult) from studentexam
--3����ѯSQL���Ե���ͷ���
select min(examresult) from studentexam where examsubject='SQL'
--4����ѯJava���Գɼ���ߵ�ѧԱ����
select stuname from studentinfo where STUID=(select EXAMID from studentexam where examresult=(select max(examresult) from studentexam))
--5����ѯѧԱ������а��һ���μ��˼��ο���
select count(*)||'��' ���� from studentexam where estuid=(select stuid from studentinfo stuname='����а��')
--6����ѯ����Ŀ��ƽ���ɼ�
select examsubject ��Ŀ,avg(examresult)  from studentexam
group by examsubject
--7����ѯÿ�༶ѧԱ����С����
select min(stuage) from studentinfo
group by sclassid
--8����ѯ���Բ����������
select count(*) from studentexam where examsubject<60
--9����ѯ��ѧԱ���ܳɼ���Ҫ��ɸѡ���ܳɼ���140�����ϵ�
select sum(examresult) from studentexam
group by estuid
having sum(examresult) >= 140
--10����ѯ��ŮѧԱ��ƽ������
select avg(stuage) from studentinfo
group by stusex
--11����ѯÿ�Ź��ε�ƽ���֣�Ҫ����ʾƽ������80�����ϵ�(����80��)
select avg(examresult)  from studentexam
group by examsubject
having avg(examresult)>=80
