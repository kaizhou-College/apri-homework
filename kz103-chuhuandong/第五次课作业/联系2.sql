--1����ѯ����ѧԱ����ѧ�����죬һ���ȹ��˶�����
select stuname as "����",(months_between(sysdate,stujointime)*30) as "�ȹ�����" from studentinfo
--2����ѯ��ĳ������ڵ��������������������/12��
select (months_between(sysdate,'17-12��-1999')/12) as "�������" from dual
--3.��ѯÿ��2����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(day from stujointime)=2
--4.��ѯ����ѧԱ�ı�ҵ���ڣ��ٶ���ÿ��ѧԱ��ѧʱ��1���֮�󽫱�ҵ
select stuname as "����",add_months(stujointime,18) as "��ҵ����" from studentinfo
--5����ѯ��������ѧ��ѧԱ�������Ա����䣬�༶���   =5?
select 
--6����ѯ��2007-3-10��֮ǰ��ѧ��ѧԱ��Ϣ                                                                                                                                                                                                                                                                                                                                                                                          
select * from studentinfo where stujointime<to_date('2007-3-10','yyyy-mm-dd')
--7����ѯ����ѧԱ�����ĳ���
select length(stuname) ���� from studentinfo
--8����ѯ���֤�е�9��10λΪ��89����ѧԱ��Ϣ��Ҫ��ʹ���ַ���������
select * from studentinfo where substr(STUCARD,9,2)='89'
--9���޸İ�������Ϣ���������еġ�yahoo���滻Ϊ��geekgroup��
select replace(teacheremail,'yahoo','geekgroup')
--10����д��ѯ���ȥ���ַ�����   �����Ұ���   ���еĿո�
select replace('   �����Ұ���   ','   ') from dual
--11������ÿ��ѧԱ���֤���ַ���1�����ֵĴ���
select length(stucard)-length(replace(stucard,'1')) ci from studentinfo
--12����С��-58.9���������
select ceil(-58.9) from dual
--13�������78.8����С����
select floor(78.9) from dual
--14����64����7������
select mod(64,7) from dual
--15����ѯ����ѧԱ��ѧʱ�䣬Ҫ����ʾ��ʽΪ��2007��03��02�ա�
select to_char(stujointime,'yyyy"��"-mm"��"-dd"��"') from studentinfo
--16����ѯ��ǰʱ�䣬Ҫ����ʾ��ʽΪ��22ʱ57:37��
select to_char(sysdate,'hh24:mi:ss') from dual
--17����ѯ2007����ѧ��ѧԱ��Ϣ
select * from studentinfo where extract(year from stujointime) = 2007
--
