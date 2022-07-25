create database order_management;
use order_management;
create table phieu_xuat (
	so_px int auto_increment primary key,
    ngay_xuat date
);
create table phieu_nhap (
	so_pn int auto_increment primary key,
    ngay_nhap date
);
create table so_dien_thoai (
	id int primary key,
    sdt varchar(20)
);
create table nha_cung_cap (
	ma_ncc int auto_increment primary key,
    ten_ncc varchar(50),
    dia_chi varchar(50),
    id_sdt int,
	foreign key(id_sdt) references so_dien_thoai(id)
);
create table vat_tu (
	ma_vt int auto_increment primary key,
    ten_vt varchar(50)
);
create table don_dat_hang (
	so_dh int auto_increment primary key,
    ngay_dh date,
    ma_ncc int,
    foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);
create table chi_tiet_phieu_xuat (
	ma_vt int,
    so_px int,
    don_gia_xuat int,
    so_luong_xuat int,
    primary key(ma_vt, so_px),
    foreign key(ma_vt) references vat_tu(ma_vt),
	foreign key(so_px) references phieu_xuat(so_px)
);
create table chi_tiet_phieu_nhap (
	ma_vt int,
    so_pn int,
    don_gia_nhap int,
    so_luong_nhap int,
    primary key(ma_vt, so_pn),
    foreign key(ma_vt) references vat_tu(ma_vt),
	foreign key(so_pn) references phieu_nhap(so_pn)
);
create table chi_tiet_don_dat_hang (
	ma_vt int,
    so_dh int,
    primary key(ma_vt, so_dh),
    foreign key(ma_vt) references vat_tu(ma_vt),
    foreign key(so_dh) references don_dat_hang(so_dh)
);