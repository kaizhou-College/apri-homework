create table users
(
	id int primary key identity(1,1),
    uname varchar(20) not null,
	upwd varchar(20)  not null

)