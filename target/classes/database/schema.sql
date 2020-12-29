create table if not exists trains (
    id bigint primary key not null ,
    capacity varchar(255) not null ,
    number varchar(255) not null
);