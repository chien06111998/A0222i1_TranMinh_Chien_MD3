create database exam_module3;
use exam_module3;

select * from mat_bang; 
select * from type_mb; 
select * from note_mb; 

create table type_mb (
	id int auto_increment primary key,
    name varchar(50)
);

insert into type_mb (id, name) 
value 
(1, 'Nha o'),
(2, 'Nha tro');

create table note_mb (
	id int primary key,
    name varchar(50)
);

insert into note_mb (id, name) 
value 
(1, 'Da cho thue'),
(2, 'Con trong');

create table mat_bang (
	ma_mb varchar(20) primary key,
    id_trang_thai int,
    dien_tich int,
    so_tang int,
    id_loai_mb int,
    mo_ta varchar(50),
    gia_tien int,
    ngay_thue date,
    ngay_tra date,
    foreign key(id_trang_thai) references note_mb(id),
    foreign key(id_loai_mb) references type_mb(id)
);

delete from mat_bang where ma_mb = 'HD-14';

insert into mat_bang (ma_mb, id_trang_thai, dien_tich, so_tang, id_loai_mb, mo_ta, gia_tien, ngay_thue, ngay_tra)
value
('HD-1',1, 10000, 4, 1, 'nha1', 111111111, '2020-08-12', '2020-12-08'),
('HD-2',2, 20000, 6, 2, 'nha2', 22222222, '2020-03-18', '2020-03-08'),
('HD-3',2, 30000, 2, 1, 'nha3', 33333333, '2020-04-08', '2020-06-08'),
('HD-4',1, 80000, 9, 2, 'nha8', 88888888, '2020-12-09', '2020-12-08');

-- tạo sp tìm kiếm theo 3 trường
delimiter //
create procedure search(in p_gia varchar(50), in p_so_tang varchar(50), in p_loai varchar(50))
begin
select * from mat_bang where gia_tien like concat('%',p_gia,'%') and so_tang like concat('%',p_so_tang,'%') and id_loai_mb like concat('%',p_loai,'%');
end //
delimiter ;

call search('','','');


