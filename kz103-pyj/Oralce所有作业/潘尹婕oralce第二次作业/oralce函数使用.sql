--��ѯ����ѧԱ����ѧ�����죬һ���ȹ��˶�����
select months_between(sysdate,STUJOINTIME)* 30 from studentinfo


--��ѯ��ĳ������ڵ��������������������/12��
select months_between(sysdate,'20-6��-1998')/12 from dual


--��ѯÿ��2����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(day from STUJOINTIME)=2


--��ѯ����ѧԱ�ı�ҵ���ڣ��ٶ���ÿ��ѧԱ��ѧʱ��1���֮�󽫱�ҵ��
select add_months(STUJOINTIME,18) from studentinfo


--��ѯ��������ѧ��ѧԱ�������Ա����䣬�༶��� 
select stuname,stusex,stuage,sclassid from studentinfo where to_char(STUJOINTIME,'day')='������'and sclassid=2


--��ѯ��2007-3-10��֮ǰ��ѧ��ѧԱ��Ϣ
select * from studentinfo where to_char(STUJOINTIME,'yyyy-mm-dd')<'2007-03-10'


--��ѯ����ѧԱ�����ĳ���()
select length(STUNAME) from studentinfo


--��ѯ���֤�е�9��10λΪ��89����ѧԱ��Ϣ��Ҫ��ʹ���ַ���������
select * from studentinfo where substr(STUCARD,instr(stucard,'89'),2)='89'


--�޸İ�������Ϣ���������еġ�yahoo���滻Ϊ��geekgroup��
select replace(TEACHEREMAIL,'yahoo','geekgroup') from teacherinfo


--��д��ѯ���ȥ���ַ�����   �����Ұ���   ���еĿո�
select trim   ('  �����Ұ���  ') from dual


--����ÿ��ѧԱ���֤���ַ���1�����ֵĴ���
select length(STUCARD) - length(replace(STUCARD,'1')) from studentinfo


--��С��-58.9���������
select floor(-58.9) from dual


--�����78.8����С����
select ceil(78.8) from dual


--��64����7������
select mod(64,7) from dual


--��ѯ����ѧԱ��ѧʱ�䣬Ҫ����ʾ��ʽΪ��2007��03��02�ա�
select to_char(STUJOINTIME,'yyyy"��"mm"��"dd"��"') from studentinfo


--��ѯ��ǰʱ�䣬Ҫ����ʾ��ʽΪ��22ʱ57:37��
select to_char(sysdate,'hh24"ʱ"mi:ss') from dual


--��ѯ2007����ѧ��ѧԱ��Ϣ
select * from studentinfo where Extract(year from STUJOINTIME)=2007


--��ѯ����ѧԱ��ƽ�����䣨Ҫ������λС����
select trunc(avg(STUAGE),2) from studentinfo


--��ѯ���п��Ե��ܳɼ�
select sum(EXAMRESULT) from studentexam 


--��ѯSQL���Ե���ͷ���
select min(EXAMRESULT) from studentexam


--��ѯJava���Գɼ���ߵ�ѧԱ����
select b.stuname from
(select estuid from studentexam where examresult=
(select max(examresult) from studentexam where examsubject='Java'))a,
studentinfo b 
where a.estuid=b.stuid


--��ѯѧԱ������а��һ���μ��˼��ο���
select count(*) from studentinfo , studentexam where studentinfo.stuid=studentexam.estuid and stuname='����а��'


--��ѯ����Ŀ��ƽ���ɼ�
select EXAMSUBJECT, avg(EXAMRESULT) from studentexam group by EXAMSUBJECT


--��ѯÿ���༶ѧԱ����С����
select sclassid,min(stuage) from studentinfo group by sclassid


--��ѯ���Բ����������
select count(*) from studentexam where EXAMRESULT<60


--��ѯ��ѧԱ���ܳɼ���Ҫ��ɸѡ���ܳɼ���140�����ϵ�
select sum(examresult) ,estuid  from studentexam  group by estuid having sum(examresult)>140


--��ѯ��ŮѧԱ��ƽ������
select stusex,avg(stuage) from studentinfo group by stusex


--��ѯÿ�Ź��ε�ƽ���֣�Ҫ����ʾƽ������80�����ϵ�(����80��)
select * from (select avg(examresult)total from studentexam group by EXAMSUBJECT)where total>80
