use case_study_module_3;
-- 1
-- 2
select *
from nhan_vien
where substring_index(ho_ten, ' ', -1)
regexp '^[HTK]' and char_length(ho_ten) <= 15;
-- 3
select * 
from khach_hang
where year(now()) - year(ngay_sinh) between 18 and 50 
and (dia_chi like  '% Quảng Trị' or dia_chi like  '% Đà Nẵng');
-- 4
-- 5
select ma_hk, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, sum(dv.chi_phi_thue + (hdct.so_luong*dvdk.gia)) as tong_tien
from khach_hang kh left join hop_dong hd on kh.ma_hk = hd.ma_kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join  dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu, dich_vu_di_kem dvdk, hop_dong_chi_tiet hdct;
-- 6
-- 7
-- 8
-- 9
-- 10
-- 11
-- 12
-- 13
-- 14
-- 15
-- 16
-- 17
-- 18
-- 19
-- 20
-- 21
-- 22
-- 23
-- 24
-- 25
-- 26
-- 27
-- 28