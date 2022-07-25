-- create database sales_manager;
-- use sales_manager;
create table customer_manager (
	customer_id int auto_increment primary key,
    customer_name varchar(50),
    customer_age int
);
create table order_manager (
	order_id int auto_increment primary key,
	customer_id int,
	order_date date,
	order_total_price int,
	foreign key(customer_id) references customer_manager(customer_id),
	foreign key(order_total_price) references order_detail(order_id)
);
create table order_detail (
	order_id int,
    product_id int,
    order_detail_qty int
);
create table product_manager (
	product_id int auto_increment primary key,
    product_name varchar(50),
    product_price int,
    foreign key(product_id) references order_detail(product_id)
);


