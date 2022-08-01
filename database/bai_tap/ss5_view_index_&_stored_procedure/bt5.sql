create database examp5;
use examp5;
create table products (
	id int auto_increment primary key,
	product_code int,
	product_name varchar(20),
	product_price int,
	product_amount int,
	product_description varchar(50),
	product_status varchar(50)
);
create unique index index_product_code
on products(product_code);
create index composite_index_products
on products(product_name, product_price);
-- Tạo view
create view view_products as 
select product_code, product_name, product_price, product_status
from products;
-- Sửa đổi view
alter view view_products as
select product_code, product_name, product_amount, product_status 
from products
go;
-- Xóa view
drop view if exists view_products;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure find_view_product_name ()
begin
	select product_name from products;
end
// delimiter ;
call find_view_product_name ();
-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_new_products ()
begin
	insert into products (id, product_code, product_name, product_price, product_amount, product_description, product_status) 
    value (3, 3, 'hoang', 20000, 200, 'tồn kho', 'hang xau');
end
// delimiter ;
call add_new_products ();
-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_products ()
begin
	update products set product_name = 'Hồng' where id = 2;
end
// delimiter ;
call update_products ();
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_products ()
begin
	delete from products where id = 1;
end
// delimiter ;
call delete_products ();


