---�Զ�����
create sequence seq_studentinfo
create sequence seq_classinfo
create sequence seq_Teacherinfo
create sequence seq_studentexam
commit
----��������
insert into teacherinfo values(seq_teacherinfo.nextval,'������','13907311119','tsz@yahoo.com')
insert into teacherinfo values(seq_teacherinfo.nextval,'������','13907315200','qtz@yahoo.com')
commit
----���Ҳ����

insert into Classinfo values(seq_classinfo.nextval,07034,(select teacherID from teacherinfo where teachername='������'),'S1')
commit
-----ѧ����Ϣ��
insert into studentinfo values(seq_studentinfo.nextval,'001','����а��',18,'��','4320105198905022032','01-3��-07','��ɳ�п�����',null)
insert into studentinfo values(seq_studentinfo.nextval,'002','��������',20,'��','430104198703012011','02-3��-07','�㶫��ɽ',null)
insert into studentinfo values(seq_studentinfo.nextval,'003','С��ɳ�',18,'��','420106198908064044','06-3��-07','������̶',null)
insert into studentinfo values(seq_studentinfo.nextval,'004','ӣ��������',18,'Ů','42010619890861085','02-3��-07','��ɳ����´��',null)
alter table studentinfo add constraint ck_Stuage
      check (stuage between 16 and 35)
      
alter table studentinfo add constraint ck_stusex
      check (stusex in( '��' , 'Ů'))

-----���Գɼ���
---����ѧԱid

insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '����а��'),'SQL',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '����а��'),'Java',56)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = 'С��ɳ�'),'SQL',90)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = 'С��ɳ�'),'Java',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = 'ӣ��������'),'SQL',95)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = 'ӣ��������'),'Java',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '��������'),'SQL',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '��������'),'Java',90)

----�޸�
update studentinfo set sclassid=3
       where stuname in ('����а��' , 'С��ɳ�')
----ɾ��
delete from  studentexam where estuid = (select stuid from studentinfo where stuname = '��������' )
