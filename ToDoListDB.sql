drop schema if exists todolist;
create schema todolist;

use todolist;

create table items(
	item_id mediumint not null auto_increment,
    item_name varchar(30) not null,
    primary key (item_id)
);

create table users(
	user_id mediumint not null auto_increment,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    user_email varchar(70) not null,
    user_password varchar(30) not null,
    primary key (user_id)
);

insert into items (item_name) value
	('milk');
    
insert into users (first_name, last_name, user_email, user_password) value
    ('Craig', 'Rodewald', 'craig.rodewald@gmail.com', 'password');
    