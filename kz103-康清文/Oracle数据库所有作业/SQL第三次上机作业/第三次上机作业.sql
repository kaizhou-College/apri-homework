--��ѯ����ѧԱ��Ϣ
select * from StudentInfo
--��ѯ����ѧԱ�����������䣨Ҫ��������������ʾ��
select STUNAME ����,STUAGE ���� from StudentInfo

--��ѯѧԱ�����乲���ļ���ֵ��Ҫ�󲻼����ظ��
select distinct STUAGE from StudentInfo

--��ѯ����Ů��ѧԱ����Ϣ
select * from StudentInfo where STUSEX='Ů';

--��ѯ�����к��С����ֵ�ѧ������Ϣ��
select * from StudentInfo where STUNAME like'��%';

--��ѯѧԱ��Ϣ��Ҫ����ʾЧ�����£�
select '����'||a.STUNAME||'����'||a.STUAGE ||'��ס'|| a.STUADDRESS  from StudentInfo a 

--��ѯ����С��20�꣬��ס��ɳ������ѧԱ��Ϣ
select * from StudentInfo where STUAGE<20 and STUADDRESS like '%��ɳ%' and STUSEX='��';

--��ѯ������16-18��(����16,18��)��ѧԱ��Ϣ
select *��from StudentInfo where STUAGE  between 16 and 18

--��ѯ���֤�а����С�1989���ַ���ѧԱ��Ϣ
select * from StudentInfo where STUCARD like'%1989%';

--��ѯ��2007-3-5������ѧ��ѧԱ��Ϣ
select * from StudentInfo where STUJOINTIME>'05-3��-07';

--��ѯ�����ַΪyahoo�İ�������Ϣ
select * from teacherinfo where TEACHEREMAIL like'%yahoo%';

--��ѯ�ֻ��ԡ�139����ͷ�İ�������Ϣ
select * from teacherinfo where TEACHERTEL like'%139%';

--��ѯ���䲻Ϊ������ѧԱ��ѧ�ţ�������סַ
select STUNUMBER,STUNAME,STUADDRESS from StudentInfo where STUAGE is not null

--��ѯѧ���ڡ�001��,��003��,��004������֮���ѧԱ��������ѧʱ��
select STUNAME,STUJOINTIME from StudentInfo where STUNUMBER in ('001','003','004');

--��ѯ����ѧԱ��Ϣ���������併������
select * from StudentInfo order by STUAGE desc

--��ѯ���гɼ��������Է����������򣬷�����ͬ�ģ���ѧԱ�����������
select * from studentexam order by EXAMRESULT desc,ESTUID asc;
