----��ϰ�������к�����ϰ
select * from studentinfo
select * from teacherinfo
----1����ѯ����ѧԱ����ѧ�����죬һ���ȹ��˶����� 
select stuname,Ceil(months_between(sysdate,stujointime)*30) as ��ѧ���� from studentinfo 
----2����ѯ��ĳ������ڵ��������������������/12��
select Floor (months_between(sysdate,stujointime)/12) as ������� from studentinfo
----3����ѯÿ��2����ѧ��ѧԱ��Ϣ
select * from studentinfo where Extract(day from stujointime)=2
----4����ѯ����ѧԱ�ı�ҵ���ڣ��ٶ���ÿ��ѧԱ��ѧʱ��1���֮�󽫱�ҵ��
select stuname,add_months(sysdate,18) as ��ҵ���� from studentinfo
----5����ѯ��������ѧ��ѧԱ�������Ա����䣬�༶���   ????????????????????????????????????????
select stuname,stusex,stuage,stunUMber from studentinfo where to_char( StuJointime,'day') ='������'
----6����ѯ��2007-3-10��֮ǰ��ѧ��ѧԱ��Ϣ
select * from studentinfo where stujointime < ('10-3��-07')
----7����ѯ����ѧԱ�����ĳ���
select stuname,length(stuname) from studentinfo
----8����ѯ���֤�е�9��10λΪ��89����ѧԱ��Ϣ��Ҫ��ʹ���ַ���������
select * from studentinfo where substr(stucard,9,2)='89'
----9���޸İ�������Ϣ���������еġ�yahoo���滻Ϊ��geekgroup��
select replace(teacheremail , 'yahoo','geekgroup') from teacherinfo
----10����д��ѯ���ȥ���ַ�����   �����Ұ���   ���еĿո�
select replace('   �����Ұ���   ',' ','') from dual
----11������ÿ��ѧԱ���֤���ַ���1�����ֵĴ���
select length(stucard)-length(replace(stucard,'1','')) from studentinfo
----12����С��-58.9���������
select floor(-58.9) from dual
----13�������78.8����С����
select Ceil(78.8) from dual
----14����64����7������
select mod(64,7) from dual
----15����ѯ����ѧԱ��ѧʱ�䣬Ҫ����ʾ��ʽΪ��2007��03��02�ա�
select stuname,to_char(stujointime,'yyyy"��"mm"��"dd"��"') from studentinfo
----16����ѯ��ǰʱ�䣬Ҫ����ʾ��ʽΪ��22ʱ57:37��
select to_char( sysdate,'hh24"ʱ"mi:ss"��"') from dual
----17����ѯ2007����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(year from stuJointime)=2007



----��ϰ�������麯����ϰ
----1����ѯ����ѧԱ��ƽ�����䣨Ҫ������λС����
select round(avg(stuage),2) from studentinfo
----2����ѯ���п��Ե��ܳɼ�
select ExamsubJect , sum(Examresult) from studentexam
group by examsubject
----3����ѯSQL���Ե���ͷ���
select min(Examresult) from studentexam
----4����ѯJava���Գɼ���ߵ�ѧԱ����
select a.stuname from studentinfo a,(select estuid from studentexam 
where examresult=(select max(examresult) from studentexam  where examsubject='Java')) b
where b.estuid=a.stuid
----5����ѯѧԱ������а��һ���μ��˼��ο���
select count(a.estuid)as �μӴ��� from studentexam a ,studentinfo b
where a.estuid=b.stuid and b.stuname='����а��'
----6����ѯ����Ŀ��ƽ���ɼ�
select examsubject , avg(examresult) from studentexam
group by examsubject
----7����ѯÿ���༶ѧԱ����С����
select sclassid, min(stuage) from studentinfo
group by sclassid
----8����ѯ���Բ����������
select * from studentexam where examresult<60
----9����ѯ��ѧԱ���ܳɼ���Ҫ��ɸѡ���ܳɼ���140�����ϵ�
select * from (select s.stuname,sum(examresult) as result  from studentexam a ,studentinfo s 
where  a.Estuid=s.stuid group by s.stuname) where result>140
----10����ѯ��ŮѧԱ��ƽ������
select stusex,avg(stuage) from studentinfo
group by stusex
----11����ѯÿ�Ź��ε�ƽ���֣�Ҫ����ʾƽ������80�����ϵ�(����80��)
select examsubject , avg(examresult) as pj from  studentexam 
having avg(examresult)>=80
group by examsubject
