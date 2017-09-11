----查询所有学员信息
select * from studentinfo

----查询所有学员的姓名，年龄
select stuname as "姓名" , stuage as "年龄" from studentinfo

----查询所有学员的年龄共有几种值
select distinct stuage from studentinfo 

----查询所有女性学员都信息
select * from studentinfo where stusex = '女'

----查询姓名中含有“火”子的学生的信息
select * from studentinfo where stuname like '%火%'

----查询学员信息
select '姓名为'||a.stuname||'，年龄'||a.stuage||'，家住'||a.stuaddress from studentinfo a

---查询年龄小于20岁的，家住长沙的男性学员信息
select * from studentinfo where stuage < 20 and stuaddress like '长沙%'

----查询年龄在16-18岁的学员信息
select * from studentinfo where stuage between 16 and 18

----查询身份证中包含有1989字符的学员信息
select * from studentinfo where stucard like '%1989%'

---查询‘2007-3-5’后入学的学员信息
select * from studentinfo where stujointime > '05-3月-07'


----查询邮箱地址为Yahoo的班主任信息
select * from teacherinfo where teacheremail like '%yahoo%'

----查询手机以‘139’开头的班主任信息
select * from teacherinfo where teachertel like '139%'

---查询年龄不为空男性学员的学号，姓名，住址
select stunumber as "学号",stuname as "姓名",stuaddress as "住址" from studentinfo where stuage is not null

---查询学号在‘001’,‘003’,‘004’三者之间的学员姓名和入学时间
select stuname as "学员姓名 ",stujointime as "入学时间" from studentinfo where stunumber between 001 and 004

----查询所有学员信息，并按年龄降序排序
select * from studentinfo order by stuage desc

----查询所有成绩，按考试分数降序排序，分数相同的，按学员编号升序排序
select * from studentexam order by examresult desc,estuid asc
 
