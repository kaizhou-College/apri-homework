--查所有学员信息
select * from StudentInfo
--查询所有学员的姓名，年龄（用中文显示）
select stuname as "姓名", stuAge as "年龄" from StudentInfo
--查询学员的年龄共有哪几种值（要求不计算重复项）
select distinct stuAge from StudentInfo 
--查询所有女性学员的信息
select * from StudentInfo where stusex='女'
--查询姓名中含有’火’字的学生的信息。
select * from  StudentInfo where stuname like'%火%'
--以中文表达
select '姓名'|| a.stuname||'，年龄' ||a.stuage||'，家住'||a.stuaddress from StudentInfo a
--查询年龄小于20岁，家住长沙的男性学员信息
select * from StudentInfo where stuage<20 and stuaddress like'长沙%'
--查询年龄在16-18岁(包括16,18岁)的学员信息
select * from StudentInfo where stuage between 16 and 18
--查询身份证中包含有‘1989’字符的学员信息
select * from StudentInfo where stucard like '%1989%'
--查询‘2007-3-5’后入学的学员信息
select * from StudentInfo where stujointime >'05-3月-07'
--查询邮箱地址为yahoo的班主任信息
select * from teacherinfo where teacheremail like '%yahoo%'
--查询年龄不为空男性学员的学号，姓名，住址
select StuNumber,stuname,stuaddress from studentInfo where stuage is not null
--查询学号在‘001’,‘003’,‘004’三者之间的学员姓名和入学时间
select stuname,stujointime from studentInfo where stunumber in(001,003,004)
--查询所有学员信息，并按年龄降序排序
select * from studentInfo order by stuage desc
--查询所有成绩，按考试分数降序排序，分数相同的，按学员编号升序排序
select examresult,estuid from studentexam order by examresult desc,estuid asc
