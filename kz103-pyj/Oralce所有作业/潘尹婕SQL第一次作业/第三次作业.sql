--������ѧԱ��Ϣ
select * from StudentInfo
--��ѯ����ѧԱ�����������䣨��������ʾ��
select stuname as "����", stuAge as "����" from StudentInfo
--��ѯѧԱ�����乲���ļ���ֵ��Ҫ�󲻼����ظ��
select distinct stuAge from StudentInfo 
--��ѯ����Ů��ѧԱ����Ϣ
select * from StudentInfo where stusex='Ů'
--��ѯ�����к��С����ֵ�ѧ������Ϣ��
select * from  StudentInfo where stuname like'%��%'
--�����ı��
select '����'|| a.stuname||'������' ||a.stuage||'����ס'||a.stuaddress from StudentInfo a
--��ѯ����С��20�꣬��ס��ɳ������ѧԱ��Ϣ
select * from StudentInfo where stuage<20 and stuaddress like'��ɳ%'
--��ѯ������16-18��(����16,18��)��ѧԱ��Ϣ
select * from StudentInfo where stuage between 16 and 18
--��ѯ���֤�а����С�1989���ַ���ѧԱ��Ϣ
select * from StudentInfo where stucard like '%1989%'
--��ѯ��2007-3-5������ѧ��ѧԱ��Ϣ
select * from StudentInfo where stujointime >'05-3��-07'
--��ѯ�����ַΪyahoo�İ�������Ϣ
select * from teacherinfo where teacheremail like '%yahoo%'
--��ѯ���䲻Ϊ������ѧԱ��ѧ�ţ�������סַ
select StuNumber,stuname,stuaddress from studentInfo where stuage is not null
--��ѯѧ���ڡ�001��,��003��,��004������֮���ѧԱ��������ѧʱ��
select stuname,stujointime from studentInfo where stunumber in(001,003,004)
--��ѯ����ѧԱ��Ϣ���������併������
select * from studentInfo order by stuage desc
--��ѯ���гɼ��������Է����������򣬷�����ͬ�ģ���ѧԱ�����������
select examresult,estuid from studentexam order by examresult desc,estuid asc
