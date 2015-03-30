create table t_user(
id int primary key auto_increment,
username varchar(50) unique,
pwd varchar(50),
age int);

insert into t_user(username,pwd,age) 
values('zs','test',22);