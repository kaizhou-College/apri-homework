--1����ѯ����ѧԱ����ѧ�����죬һ���ȹ��˶����� 
select * from studentinfo
select stujointime from studentinfo
--��
select floor(months_between(sysdate,stujointime))*30 ���� from studentinfo
--2����ѯ��ĳ������ڵ��������������������/12��
select months_between(sysdate,to_date('1997-02-02','yyyy-mm-dd'))/12 from dual
--3����ѯÿ��2����ѧ��ѧԱ��Ϣ
select * from studentinfo where Extract(day from stujointime)=2
--4����ѯ����ѧԱ�ı�ҵ���ڣ��ٶ���ÿ��ѧԱ��ѧʱ��1���֮�󽫱�ҵ��
select add_months(stujointime,18) ��ҵ���� from studentinfo
--5����ѯ��������ѧ��ѧԱ�������Ա����䣬�༶���   =2?
select next_day(to_date('2017-9-11','yyyy-mm-dd'),'������') from dual
select next_day(stujointime,'������') from studentinfo
select extract( day from next_day(stujointime,'������')-7) from studentinfo

--��
select stuname, stusex,stuage,stunumber,stujointime from studentinfo
 where extract( day from next_day(stujointime,'������')-7)=extract(day from stujointime) and sclassid=2

--6����ѯ��2007-3-10��֮ǰ��ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(day from stujointime)-extract(day from (to_date('2017-3-10','yyyy-mm-dd')))<0
--7����ѯ����ѧԱ�����ĳ���
select length(stuname) from studentinfo
--8����ѯ���֤�е�9��10λΪ��89����ѧԱ��Ϣ��Ҫ��ʹ���ַ���������
select * from studentinfo where substr(stucard,9,2)='89'
--9���޸İ�������Ϣ���������еġ�yahoo���滻Ϊ��geekgroup��
select * from teacherinfo
select replace(teacheremail,'yahoo','geekgroup') from teacherinfo
--10����д��ѯ���ȥ���ַ�����   �����Ұ���   ���еĿո�
select trim('     �����Ұ���           ') �ַ��� from dual
--11������ÿ��ѧԱ���֤���ַ���1�����ֵĴ���
select length(stucard)-length(replace(stucard,'1')) from studentinfo
--12����С��-58.9���������
select floor(-58.9) from dual
--13�������78.8����С����
select ceil(78.8) from dual
--14����64����7������
select mod(64,7) from dual
--15����ѯ����ѧԱ��ѧʱ�䣬Ҫ����ʾ��ʽΪ��2007��03��02�ա�
select to_char(stujointime,'yyyy"��"mm"��"dd"��"') ��ѧʱ�� from studentinfo
--16����ѯ��ǰʱ�䣬Ҫ����ʾ��ʽΪ��22ʱ57:37��
select to_char(sysdate,'hh24"ʱ"mi":"ss') from dual
--17����ѯ2007����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(year from stujointime)=2007
--1����ѯ����ѧԱ��ƽ�����䣨Ҫ������λС����
select round(avg(stuage),2) from studentinfo
--2����ѯ���п��Ե��ܳɼ�
select * from studentexam
select sum(examresult) �ܳɼ�from studentexam
--3����ѯSQL���Ե���ͷ���
select min(examresult) from studentexam where examsubject='SQL'
--4����ѯJava���Գɼ���ߵ�ѧԱ����
select max(examresult) from studentexam  where examsubject='Java'
select estuid from studentexam where examresult=(select max(examresult) from studentexam  where examsubject='Java')
--��
select b.stuname from (select estuid from studentexam where examresult=(select max(examresult) from studentexam  where examsubject='Java')) a,
studentinfo b 
where a.estuid=b.stuid
--5����ѯѧԱ������а��һ���μ��˼��ο���
select * from studentinfo where stuname='����а��'
select count(examresult) from (select * from studentinfo where stuname='����а��') a ,studentexam b
where a.stuid =b.estuid
--6����ѯ����Ŀ��ƽ���ɼ�
select avg(examresult),examsubject from studentexam group by examsubject 
--7����ѯÿ���༶ѧԱ����С����
select min(stuage),sclassid from studentinfo group by sclassid
--8����ѯ���Բ����������
select count(examresult) from studentexam where examresult<60
--9����ѯ��ѧԱ���ܳɼ���Ҫ��ɸѡ���ܳɼ���140�����ϵ�
select sum(examresult),estuid from studentexam group by estuid having sum(examresult)>140
--10����ѯ��ŮѧԱ��ƽ������
select avg(stuage),stusex from studentinfo group by stusex
--11����ѯÿ�Ź��ε�ƽ���֣�Ҫ����ʾƽ������80�����ϵ�(����80��)
select avg(examresult),examsubject from studentexam group by examsubject having avg(examresult)>=80
