create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class (
	class_id int auto_increment primary key NOT NULL,
    class_name varchar(50) NOT NULL, 
    start_date datetime NOT NULL, 
    status int
);
create table student (
	student_id int auto_increment primary key NOT NULL,
    student_name varchar(50) NOT NULL,
    address varchar (50),
    phone varchar (20),
    status int,
    class_id int NOT NULL,
    foreign key (class_id) references class (class_id) 
);
create table subject (
	sub_id int auto_increment primary key NOT NULL,
    sub_name varchar(50)  NOT NULL,
    credit int NOT NULL default 1 check (credit >= 1),
    status int default 1
);
create table mark (
	mark_id int auto_increment primary key NOT NULL,
    sub_id int NOT NULL,
	student_id int NOT NULL,
    mark float default 0 check ( mark between 0 and 100),
    exam_time tinyint default 1,
    unique key (sub_id, student_id),
    foreign key (sub_id) references subject (sub_id),
    foreign key (student_id) references student (student_id)
);

insert into class 
values (1, 'A1', '2008-12-20', 1);
insert into class
values (2, 'A2', '2008-12-22', 1);
insert into class
values (3, 'B3', current_date, 0);

insert into student (student_name, address, phone, status, class_id)
values ('Hung', 'Ha Noi', '0123456789', 1, 1);
insert into student (student_name, address, status, class_id)
values ('Hoa', 'Hai Phong', 1, 1);
insert into student (student_name, address, phone, status, class_id)
values ('Manh', 'HCM', '0987654321', 0, 2);

insert into subject 
value (1, 'CF', 5, 1),
	  (2, 'C', 6, 1),
	  (3, 'HDJ', 5, 1),
	  (4, 'RDBMS', 10, 1);
      
insert into mark (sub_id, student_id, mark, exam_time)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);

select * from class;
select * from student;
select * from subject;
select * from mark;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’-- 
select *
from student
where student_name like 'H%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *
from class
where extract(month from start_date) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * 
from subject
where credit >= 3 and credit <=5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student
set class_id = 2
where student_name = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. 
-- nếu trùng sắp theo tên tăng dần.
select student_name, sub_name, mark
from student st join mark m on st.student_id = m.student_id
join subject sb on sb.sub_id = m.sub_id 
order by mark desc, student_name asc;











