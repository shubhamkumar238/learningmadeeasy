insert into learning_made_easy.student values(1, "deepak", "email1");
insert into learning_made_easy.student values(2, "ravi", "email2");
insert into learning_made_easy.student values(3, "shubham", "email3");
insert into learning_made_easy.student values(4, "sagar", "email4");

insert into learning_made_easy.teacher_details values(1, "about1", "achievements1", "myobjectives1", "myobjectives2", "expert1@@expert2");
insert into learning_made_easy.teacher_details values(2, "about2", "achievements2", "myobjectives1", "myobjectives2", "expert1@@expert2");
insert into learning_made_easy.teacher_details values(3, "about3", "achievements3", "myobjectives1", "myobjectives2", "expert1@@expert2");
insert into learning_made_easy.teacher_details values(4, "about4", "achievements4", "myobjectives1", "myobjectives2", "expert1@@expert2");


insert into learning_made_easy.teacher values(1, "t1", "email1", "1");
insert into learning_made_easy.teacher values(2, "t2", "email2", "2");
insert into learning_made_easy.teacher values(3, "t3", "email3", "3");
insert into learning_made_easy.teacher values(4, "t4", "email4", "4");


insert into learning_made_easy.course_category values("course_category1", "url1");
insert into learning_made_easy.course_category values("course_category2", "url2");


insert into learning_made_easy.course values(1, "c1", 1, "course_category1");
insert into learning_made_easy.course values(2, "c2", 1, "course_category1");
insert into learning_made_easy.course values(3, "c3", 1, "course_category1");
insert into learning_made_easy.course values(4, "c4", 1, "course_category2");
insert into learning_made_easy.course values(5, "c5", 2, "course_category2");
insert into learning_made_easy.course values(6, "c6", 2, "course_category2");

insert into learning_made_easy.course_student values(1, 1);
insert into learning_made_easy.course_student values(1, 2);
insert into learning_made_easy.course_student values(1, 3);
insert into learning_made_easy.course_student values(3, 2);
insert into learning_made_easy.course_student values(4, 2);
insert into learning_made_easy.course_student values(6, 2);

insert into learning_made_easy.question values(1, "q1", 1);
insert into learning_made_easy.question values(2, "q2", 1);
insert into learning_made_easy.question values(3, "q3", 1);

insert into learning_made_easy.answer values(1, 1, "a1");
insert into learning_made_easy.answer values(2, 1, "a2");

insert into learning_made_easy.rating values(1, 9, 1);
insert into learning_made_easy.rating values(2, 10, 1);


insert into learning_made_easy.video values("url1", 1);
insert into learning_made_easy.video values("url2", 1);

insert into learning_made_easy.timestamp values(1, 1,"url1", 50);
