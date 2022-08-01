use sales_manager;
insert into customer_manager
value (1, 'Minh Quan', 10),
	  (2, 'Ngoc Oanh', 20),
      (3, 'Hong Ha', 50);
insert into order_manager
value (1,1, '2006-3-21', null),
	  (2,2,'2006-3-23', null),
      (3,3,'2006-3-16', null);
insert into product_manager
value (1, 'May Giat', 3),
	  (2, 'Tu lanh', 5),
      (3, 'Dieu hoa', 7),
      (4, 'Quat', 4),
      (5, 'Bep dien', 2);
insert into order_detail
value (1,1,3),
	  (1,3,7),
      (1,4,2),
      (2,1,1),
      (3,1,8),
      (2,5,4),
      (2,3,3);
      
select * from customer_manager;
select * from order_manager;
select * from product_manager;
select * from order_detail;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select order_id, order_date, order_total_price
from order_manager;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer_name, product_name
from customer_manager cm join order_manager om on cm.customer_id = om.customer_id
join order_detail od on om.order_id = od.order_id
join product_manager pm on pm.product_id = od.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer_name 
from customer_manager c
join order_manager o on c.customer_id = o.customer_id
where o.customer_id is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select order_id, order_date, 




