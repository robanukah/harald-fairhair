CREATE TABLE post (
  id SERIAL,
  title TEXT NOT NULL,
  author TEXT NOT NULL,
  date TEXT NOT NULL,
  content TEXT NOT NULL,
  CONSTRAINT pk_posst_id PRIMARY KEY (id)
);

create table if not exists school (
  id int unsigned not null auto_increment,
  code varchar (32) character set ascii collate ascii_general_ci not null,
  name varchar (64) not null,
  constraint pk_school_id primary key (id)
) engine=innodb character set utf8 collate utf8_general_ci;

create table if not exists student (
  id int unsigned not null auto_increment,
  school_id int unsigned not null,
  first_name varchar(32) not null,
  last_name varchar(32) not null,
  new_filed varchar(255),
  constraint pk_student_id primary key (id),
  constraint uk_student_id_school_id unique (id, school_id),
  constraint fk_student_school_id
  foreign key (school_id) references school (id)
  on delete cascade on update cascade
) engine=innodb character set utf8 collate utf8_general_ci;

create table if not exists course (
  id int unsigned not null auto_increment,
  code varchar(32) character set ascii collate ascii_general_ci not null,
  name varchar(64) not null,
  constraint pk_course_id primary key (id)
) engine=innodb character set utf8 collate utf8_general_ci;

create table if not exists student_course (
  id int unsigned not null auto_increment,
  student_id int unsigned not null,
  course_id int unsigned not null,
  constraint pk_student_course_id primary key (id),
  constraint uk_student_course_id unique (student_id, course_id),
  constraint fk_student_course_id
  foreign key fk_student_id (student_id) references student (id)
  on delete cascade on update cascade,
  constraint fk_course_student_id
  foreign key fk_course_id (course_id) references course (id)
  on delete cascade on update cascade
) engine=innodb  character set ascii collate ascii_general_ci;

create table if not exists school_course (
  id int unsigned not null auto_increment,
  school_id int unsigned not null,
  course_id int unsigned not null,
  constraint pk_school_course_id primary key (id),
  constraint uk_school_course_id unique (school_id, course_id),
  constraint fk_school_course_id
  foreign key fk_school_id (school_id) references school (id)
  on delete cascade on update cascade,
  constraint fk_course_school_id
  foreign key fk_course_id (course_id) references course (id)
  on delete cascade on update cascade
) engine=innodb  character set ascii collate ascii_general_ci;

insert into school (code, name) values ('12345678','Cork primary');
set @school_id = last_insert_id();

insert ignore into course (code, name) values ('87654321','JS Gay Club');
set @course_id_1 = last_insert_id();
insert into school_course (school_id, course_id) values (@school_id, @course_id_1);

insert ignore into course (code, name) values ('666','Java MAN Club');
set @course_id_2 = last_insert_id();
insert into school_course (school_id, course_id) values (@school_id, @course_id_2);

insert ignore into course (code, name) values ('000','LOL KEK Club');
set @course_id_3 = last_insert_id();
insert into school_course (school_id, course_id) values (@school_id, @course_id_3);

insert into student (school_id, first_name, last_name) values (@school_id, 'TI','Pidor');
set @student_id = last_insert_id();
insert into student_course (student_id, course_id) values (@student_id, @course_id_1);

insert into student (school_id, first_name, last_name) values (@school_id, 'TI','MAN');
set @student_id = last_insert_id();
insert into student_course (student_id, course_id) values (@student_id, @course_id_2);
insert into student_course (student_id, course_id) values (@student_id, @course_id_3);
