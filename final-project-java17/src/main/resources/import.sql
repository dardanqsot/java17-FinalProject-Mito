insert into course (active, code, name) values (true, '001', 'JAVA 17');
insert into course (active, code, name) values (true, '002', 'JAVA FULLSTACK');
insert into course (active, code, name) values (true, '003', 'MICROSERVICIOS');
insert into course (active, code, name) values (true, '004', 'SPRING WEBFLUX');


insert into student (age, dni, first_name, last_name) values (19, '12345678' , 'Pepito', 'Perez Perez');
insert into student (age, dni, first_name, last_name) values (29, '87654321' , 'Darwin', 'Quispe Soto');
insert into student (age, dni, first_name, last_name) values (25, '12345670' , 'Daniel', 'Diaz Diaz');
insert into student (age, dni, first_name, last_name) values (33, '12345675' , 'Jaime', 'Medina Medina');

insert into enrollment (active, id_student, enrollment_date) values (true, 1, '05/11/2023');
insert into enrollment (active, id_student, enrollment_date) values (true, 2, '05/11/2023');
insert into enrollment (active, id_student, enrollment_date) values (true, 3, '05/11/2023');
insert into enrollment_detail (id_course, id_enrollment, classroom) values (4,1,'SALA 4');
insert into enrollment_detail (id_course, id_enrollment, classroom) values (1,2,'SALA 1');
insert into enrollment_detail (id_course, id_enrollment, classroom) values (2,2,'SALA 2');
insert into enrollment_detail (id_course, id_enrollment, classroom) values (3,2,'SALA 3');
insert into enrollment_detail (id_course, id_enrollment, classroom) values (2,3,'SALA 2');
insert into enrollment_detail (id_course, id_enrollment, classroom) values (4,3,'SALA 4');