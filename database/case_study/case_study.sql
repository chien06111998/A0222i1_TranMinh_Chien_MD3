create database if not exists case_study;
use case_study;
create table loai_khach(
	ma_loai_khach int primary key,
    ten_loai_khach varchar(45)
);

INSERT INTO loai_khach (ma_loai_khach, ten_loai_khach)
VALUE(1, 'Diamond'),
     (2, 'Platinium'),
     (3, 'Gold'),
     (4, 'Silver'),
     (5, 'Member');

select * from khach_hang;
select * from loai_khach;
select * from hop_dong;
delete from khach_hang;

update hop_dong set ngay_bat_dau = '2020-12-08', ngay_ket_thuc = '2020-12-08', tien_dat_coc = 150, tong_tien = 1500000, ma_kh = 2 where ma_hop_dong = 'HD-1';

update khach_hang 
set ho_ten = 'Nguyễn Thị Hào', ngay_sinh = '1970-11-07', gioi_tinh = 'nu', so_cmnd = '643431213', so_dien_thoai = '0945423362', email = 'thihao07@gmail.com', ma_loai_khach = 2, dia_chi ='23 Nguyễn Hoàng, Đà Nẵng' 
where ma_hk = 3;

create table khach_hang(
	ma_hk int primary key,
    ma_loai_khach int,
    ho_ten varchar(45),
    ngay_sinh date,
    gioi_tinh varchar(10),
    so_cmnd varchar(45),
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    foreign key(ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table hop_dong(
	ma_hop_dong varchar(10) primary key,
    ngay_bat_dau date,
    ngay_ket_thuc date,
    tien_dat_coc double,
    tong_tien double,
    ma_kh int,
    foreign key(ma_kh) references khach_hang(ma_hk)
);

INSERT INTO hop_dong
VALUE('HD-1', '2020-12-08', '2020-12-08', 0, 1000000, 1),
     ('HD-2', '2020-07-14', '2020-07-21', 200000, 2000000, 3),
     ('HD-3', '2021-03-15', '2021-03-17', 50000, 5000000, 4),
     ('HD-4', '2021-01-14', '2021-01-18', 100000, 10000000, 5),
     ('HD-5', '2021-07-14', '2021-07-15', 0, 1000000, 2),
     ('HD-6', '2021-06-01', '2021-06-03', 0, 1000000, 1),
     ('HD-7', '2021-09-02', '2021-09-05', 100000, 10000000, 4),
     ('HD-8', '2021-06-17', '2021-06-18', 150000, 1500000, 4),
     ('HD-9', '2020-11-19', '2020-11-19', 0, 1000000, 4),
     ('HD-10', '2021-04-12', '2021-04-14', 0, 1000000, 3),
     ('HD-11', '2021-04-25', '2021-04-25', 0, 1000000, 2);

INSERT INTO khach_hang
VALUE(1, 5, 'Nguyễn Thị Hào', '1970-11-07', 'nu', '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
     (2, 3, 'Phạm Xuân Diệu', '1992-08-08', 'nam', '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
     (3, 1, 'Trương Đình Nghệ', '1990-02-27', 'nam', '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
     (4, 1, 'Dương Văn Quan', '1981-07-08', 'nam', '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
     (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 'nu', '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai');     
     
-- tạo sp tìm kiếm theo 3 trường
delimiter //
create procedure search(in p_name varchar(50), in p_type varchar(50), in p_id varchar(50))
begin
select * from khach_hang where ho_ten like concat('%',p_name,'%') and ma_loai_khach like concat('%',p_type,'%') and ma_hk like concat('%',p_id,'%');
end //
delimiter ;

call search('','','');

delimiter //
create procedure searchHD(in p_id varchar(50), in p_idCustomer varchar(50))
begin
select * from hop_dong where ma_hop_dong like concat('%',p_id,'%') and ma_kh like concat('%',p_idCustomer,'%');
end //
delimiter ;
     
call searchHD('','');