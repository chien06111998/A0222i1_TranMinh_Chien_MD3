CREATE DATABASE uerDao;
USE uerDao;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

select * from users;
select id from users;
-- insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
-- insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
-- insert into users(name, email, country) values('Hoa','hoa@che.uk','Viet Nam');
-- insert into users(name, email, country) values('John','john@che.uk','Lao');