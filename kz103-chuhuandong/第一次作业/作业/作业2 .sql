select * from studentinfo
select stuname as "姓名",stuage as "年龄" from studentinfo
select distinct STUAGE from studentinfo
select * from studentinfo where stusex = '女'
select * from studentinfo where stuname like '%火%'
select '姓名' ||STUNAME||'年龄'||STUAGE||'家住'||STUADDRESS as 学员信息 from studentinfo
select * from studentinfo where (stuage < 20 and stusex = '男') and stuaddress like '%长沙市%'
select * from studentinfo where stuage between 16 and 18
select * from studentinfo where STUCARD like '%1989%'
select * from studentinfo where STUJOINTIME<'05-3月-2007'
select * from teacherinfo where TEACHEREMAIL like '%@yahoo%'
select * from teacherinfo where teachertel like '139%'
select stuname,stuaddress,stunumber from studentinfo where stuage is not null
select stuname,STUJOINTIME from studentinfo where (stunumber>001 and stunumber<003) and stunumber>001 and stunumber<004
select * from studentinfo
order by stuage desc
select * from studentexam
order by examresult,estuid desc
select * from studentexam
s
