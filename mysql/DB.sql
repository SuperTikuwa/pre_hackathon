create table tasks_list(
    id int auto_increment not null primary key,
    register_day　data not null,
    detail varchar(128) not null,
    person_id int not null,
    deadline data not null,
    completion int,
    foreign key (person_id) references person(id) on delete cascade
);

create table person(
    id int not null primary key,
    person_name varchar(8)
);

insert into 
    person(id,person_name)
values
    (1,"ふくだ");

insert into 
    person(id,person_name)
values
    (2,"かみや");

insert into 
    person(id,person_name)
values
    (3,"にしざわ");