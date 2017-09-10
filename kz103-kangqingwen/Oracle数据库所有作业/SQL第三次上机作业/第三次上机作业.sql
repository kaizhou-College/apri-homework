--查询所有学员信息
select * from StudentInfo
--查询所有学员的姓名，年龄（要求列名用中文显示）
select STUNAME 姓名,STUAGE 年龄 from StudentInfo

--查询学员的年龄共有哪几种值（要求不计算重复项）
select distinct STUAGE from StudentInfo

--查询所有女性学员的信息
select * from StudentInfo where STUSEX='女';

--查询姓名中含有’火’字的学生的信息。
select * from StudentInfo where STUNAME like'火%';

--查询学员信息，要求显示效果如下：
select '姓名'||a.STUNAME||'年龄'||a.STUAGE ||'家住'|| a.STUADDRESS  from StudentInfo a 

--查询年龄小于20岁，家住长沙的男性学员信息
select * from StudentInfo where STUAGE<20 and STUADDRESS like '%长沙%' and STUSEX='男';

--查询年龄在16-18岁(包括16,18岁)的学员信息
select *　from StudentInfo where STUAGE  between 16 and 18

--查询身份证中包含有‘1989’字符的学员信息
select * from StudentInfo where STUCARD like'%1989%';

--查询‘2007-3-5’后入学的学员信息
select * from StudentInfo where STUJOINTIME>'05-3月-07';

--查询邮箱地址为yahoo的班主任信息
select * from teacherinfo where TEACHEREMAIL like'%yahoo%';

--查询手机以‘139’开头的班主任信息
select * from teacherinfo where TEACHERTEL like'%139%';

--查询年龄不为空男性学员的学号，姓名，住址
select STUNUMBER,STUNAME,STUADDRESS from StudentInfo where STUAGE is not null

--查询学号在‘001’,‘003’,‘004’三者之间的学员姓名和入学时间
select STUNAME,STUJOINTIME from StudentInfo where STUNUMBER in ('001','003','004');

--查询所有学员信息，并按年龄降序排序
select * from StudentInfo order by STUAGE desc

--查询所有成绩，按考试分数降序排序，分数相同的，按学员编号升序排序
select * from studentexam order by EXAMRESULT desc,ESTUID asc;
