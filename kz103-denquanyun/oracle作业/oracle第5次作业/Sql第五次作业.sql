--1����ѯ����ѧԱ����ѧ�����죬һ���ȹ��˶����� 
Select stuname as "����",(months_between(sysdate,stujointime)*30) as "����" from studentinfo
--2����ѯ��ĳ������ڵ��������������������/12��
select (months_between(sysdate,'07-9��-1999')/12) as "���˶�����" from dual
--3����ѯÿ��2����ѧ��ѧԱ��Ϣ
select * from studentinfo
where extract(day from stujointime)=2
--4����ѯ����ѧԱ�ı�ҵ���ڣ��ٶ���ÿ��ѧԱ��ѧʱ��1���֮�󽫱�ҵ��
select stuname as "����",(Add_months(stujointime,18)) as "��ҵʱ��" from studentinfo
--5.��ѯ��������ѧ��ѧԱ�������Ա����䣬�༶���   =5?
select stuname,stusex,stuage,sclassid from studentinfo 
where to_char(stujointime,'day')='������' and sclassid=2;
--6����ѯ��2007-3-10��֮ǰ��ѧ��ѧԱ��Ϣ
select * from studentinfo
where stujointime<to_date('2007-3-10','yyyy-mm-dd')
--7����ѯ����ѧԱ�����ĳ���
select stuname as "����",(length(stuname)) as "���ֳ���" from studentinfo
--8����ѯ���֤�е�9��10λΪ��89����ѧԱ��Ϣ��Ҫ��ʹ���ַ���������
select * from studentinfo
where substr(stucard,9,2)='89'
--9���޸İ�������Ϣ���������еġ�yahoo���滻Ϊ��geekgroup��
Select replace(teacheremail,'yahoo','geekgroup') from teacherinfo
--10����д��ѯ���ȥ���ַ�����   �����Ұ���   ���еĿո�
select replace('   �����Ұ���   ',' ','') from dual
--11������ÿ��ѧԱ���֤���ַ���1�����ֵĴ���
select stuname as "����",(length(stucard)-length(replace(stucard,'1'))) as "����1�Ĵ���" from studentinfo
--12����С��-58.9���������
select ceil(-58.9) from dual
--13�������78.8����С����
select floor(78.8) from dual
--14����64����7������
select mod(64,7) from dual
--15����ѯ����ѧԱ��ѧʱ�䣬Ҫ����ʾ��ʽΪ��2007��03��02�ա�
select stuname as "����",(to_char(stujointime,'yyyy"��"mm"��"dd"��"')) as ��ѧʱ�� from studentinfo
--16����ѯ��ǰʱ�䣬Ҫ����ʾ��ʽΪ��22ʱ57:37��
select to_char(sysdate,'hh24"ʱ"mi:ss') from dual
--17����ѯ2007����ѧ��ѧԱ��Ϣ
select * from studentinfo
where extract(year from stujointime)='2007'


--------------------�ָ���--------------------------------
--1����ѯ����ѧԱ��ƽ�����䣨Ҫ������λС����
select Round(Avg(stuage),2) from studentinfo 
--2����ѯ���п��Ե��ܳɼ�
select sum(examresult) from studentexam
--3����ѯSQL���Ե���ͷ���
select min(examresult) from studentexam
where examsubject='SQL'
--4����ѯJava���Գɼ���ߵ�ѧԱ����
select stuname from studentinfo
where stuid = (Select estuid from studentexam where examresult=(Select max(examresult) from studentexam where examsubject='Java'))
--5����ѯѧԱ������а��һ���μ��˼��ο���
select count(*)||'��' as "����" from studentexam where estuid=(Select stuid from studentinfo where stuname='����а��')
--6����ѯ����Ŀ��ƽ���ɼ�
select examsubject as "��Ŀ",avg(examresult) from studentexam
group by examsubject
--7����ѯÿ���༶ѧԱ����С����
select min(stuage) from studentinfo 
group by sclassid
--8����ѯ���Բ����������
select count(*) from(
select estuid ,count(*) from studentexam
where examresult<60
group by estuid)
--9����ѯ��ѧԱ���ܳɼ���Ҫ��ɸѡ���ܳɼ���140�����ϵ�
select stuname from studentinfo where stuid in(
select estuid from studentexam
group by estuid
having sum(examresult)>=140)
--10����ѯ��ŮѧԱ��ƽ������
select stusex as "�Ա�",avg(stuage) from studentinfo
group by stusex
--11����ѯÿ�Ź��ε�ƽ���֣�Ҫ����ʾƽ������80�����ϵ�(����80��)
select examsubject as "��Ŀ",avg(examresult) from studentexam
group by examsubject
having avg(examresult)>=80
