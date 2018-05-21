create database dropwizard_blog;

use dropwizard_blog;

create table parts (
    id int(11) not null primary key auto_increment,
    name varchar(255),
    code varchar(255)
);