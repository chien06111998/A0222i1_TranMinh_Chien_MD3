create database manage_students;
use manage_students;
create table class(
	id int,
    `name` varchar(50)
);
create table teacher(
	id int,
    `name` varchar(50),
    age int,
    coutry varchar(50)
);
insert into class (id, name) values (2, "a1221i1");
update class set name = "A1121i1" where id = 1;
delete from class where id = 1;
insert into teacher (id, name, age, coutry) values (2, "chien1", 24, "Quang Binh");
update teacher set name = "Hoang" where id = 2;
delete from teacher where id = 2;
select * from class;
select * from teacher;