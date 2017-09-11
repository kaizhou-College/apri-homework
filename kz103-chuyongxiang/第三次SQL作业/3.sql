----1、查询所有学员信息
select * from studentinfo
----2、查询所有学员的姓名，年龄（要求列名用中文显示）
select stuname as "姓名",stuage as "年龄" from studentinfo
----3、查询学员的年龄共有哪几种值（要求不计算重复项）
select distinct stuage from studentinfo
----4、查询所有女性学员的信息
select * from studentinfo where stusex='女'
----5、查询姓名中含有’火’字的学生的信息。
select * from studentinfo where stuname like '%火%'
----6、查询学员信息，要求显示效果如下：
select '姓名'||stuname||'，'||'年龄'||stuage||'，'||'家住'||stuaddress as 学员信息 from studentinfo
----7、查询年龄小于20岁，家住长沙的男性学员信息
select * from studentinfo where stuage<20 and stuaddress like '%长沙%'
----8、查询年龄在16-18岁(包括16,18岁)的学员信息
select * from studentinfo where stuage between 16 and 18
----9、查询身份证中包含有‘1989’字符的学员信息
select * from studentinfo where stucard like '%1989%'
----10、查询‘2007-3-5’后入学的学员信息
select * from studentinfo where stujointime > '05/3月/07'
----11、查询邮箱地址为yahoo的班主任信息
select * from TeacherInfo where TeacherEmail like '%yahoo%'
----12、查询手机以‘139’开头的班主任信息
select * from teacherinfo where TeacherTel like'%139%'
----13、查询年龄不为空男性学员的学号，姓名，住址
select stunumber,stuname,stuaddress from studentinfo where stuage is not null and stusex='男'
----14、查询学号在‘001’,‘003’,‘004’三者之间的学员姓名和入学时间
select stuname,stujointime from studentinfo where (stunumber >1 and stunumber<3)or(stunumber>3 and stunumber <4) 
----15、查询所有学员信息，并按年龄降序排序
select * from studentinfo order by stuage desc;
----16、查询所有成绩，按考试分数降序排序，分数相同的，按学员编号升序排序
select * from studentexam order by examresult desc,examid asc;
