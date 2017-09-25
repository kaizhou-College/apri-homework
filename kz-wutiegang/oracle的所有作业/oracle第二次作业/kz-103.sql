create sequence seq_STUDENTINFO
insert into STUDENTINFO values(seq_STUDENTINFO.nextval,'001','火云邪神',18,'男','430105198905022032','01-3月-07','长沙市开福区',null);
insert into STUDENTINFO values(seq_STUDENTINFO.Nextval,'002','东方不败',20,'男','430104198703012011','10-3月-07','湖南湘潭',null);
insert into STUDENTINFO values(seq_STUDENTINFO.Nextval,'003','小李飞车',18,'男','420106198912064044','02-3月-07','广东佛山',null);
insert into STUDENTINFO values(seq_STUDENTINFO.Nextval,'004','樱桃肉丸子',18,'女','420106198908061085','06-3月-07','长沙市岳麓区',null);
create sequence seq_teacherinfo
insert into teacherinfo values(seq_teacherinfo.nextval,'唐三藏','13907311119','tsz@yahoo.com');
insert into teacherinfo values(seq_teacherinfo.Nextval,'擎天柱','13907315200','qtz@yahoo.com');
create sequence seq_classinfo

insert into classinfo values(seq_classinfo.nextval,'07034',(select TeacherID from teacherinfo where TeacherName='擎天柱'),'S1');
update studentinfo set SClassID=(select ClassID from ClassInfo	where ClassNumber='07034') where StuName='火云邪神' or StuName='小李飞车';
insert into classinfo values(seq_classinfo.nextval,'07038',(select TeacherID from teacherinfo where TeacherName='唐三藏'),'S1');
update studentinfo set SClassID=22 where StuName='东方不败' or StuName='樱桃肉丸子';
create sequence seq_studentexam
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='火云邪神'),'SQL',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='火云邪神'),'Java',56);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='小李飞车'),'SQL',90);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='小李飞车'),'Java',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='樱桃肉丸子'),'SQL',95);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='樱桃肉丸子'),'Java',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='东方不败'),'SQL',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='东方不败'),'Java',90);
delete from studentexam where EStuID=(select StuID from StudentInfo where StuName='东方不败');
