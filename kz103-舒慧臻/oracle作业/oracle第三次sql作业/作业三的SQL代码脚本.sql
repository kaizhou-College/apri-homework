----��ѯ����ѧԱ��Ϣ
select * from studentinfo

----��ѯ����ѧԱ������������
select stuname as "����" , stuage as "����" from studentinfo

----��ѯ����ѧԱ�����乲�м���ֵ
select distinct stuage from studentinfo 

----��ѯ����Ů��ѧԱ����Ϣ
select * from studentinfo where stusex = 'Ů'

----��ѯ�����к��С����ӵ�ѧ������Ϣ
select * from studentinfo where stuname like '%��%'

----��ѯѧԱ��Ϣ
select '����Ϊ'||a.stuname||'������'||a.stuage||'����ס'||a.stuaddress from studentinfo a

---��ѯ����С��20��ģ���ס��ɳ������ѧԱ��Ϣ
select * from studentinfo where stuage < 20 and stuaddress like '��ɳ%'

----��ѯ������16-18���ѧԱ��Ϣ
select * from studentinfo where stuage between 16 and 18

----��ѯ���֤�а�����1989�ַ���ѧԱ��Ϣ
select * from studentinfo where stucard like '%1989%'

---��ѯ��2007-3-5������ѧ��ѧԱ��Ϣ
select * from studentinfo where stujointime > '05-3��-07'


----��ѯ�����ַΪYahoo�İ�������Ϣ
select * from teacherinfo where teacheremail like '%yahoo%'

----��ѯ�ֻ��ԡ�139����ͷ�İ�������Ϣ
select * from teacherinfo where teachertel like '139%'

---��ѯ���䲻Ϊ������ѧԱ��ѧ�ţ�������סַ
select stunumber as "ѧ��",stuname as "����",stuaddress as "סַ" from studentinfo where stuage is not null

---��ѯѧ���ڡ�001��,��003��,��004������֮���ѧԱ��������ѧʱ��
select stuname as "ѧԱ���� ",stujointime as "��ѧʱ��" from studentinfo where stunumber between 001 and 004

----��ѯ����ѧԱ��Ϣ���������併������
select * from studentinfo order by stuage desc

----��ѯ���гɼ��������Է����������򣬷�����ͬ�ģ���ѧԱ�����������
select * from studentexam order by examresult desc,estuid asc
 
