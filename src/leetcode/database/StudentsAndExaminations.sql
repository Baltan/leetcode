# 1280. Students and Examinations
select t1.student_id, t1.student_name, t1.subject_name, ifnull(t2.attended_exams, 0) attended_exams
from (select t1.student_id, t1.student_name, t2.subject_name
      from Students t1,
           Subjects t2) t1
         left join
     (select student_id, subject_name, count(subject_name) attended_exams
      from Examinations
      group by student_id, subject_name) t2
     on t1.student_id = t2.student_id and t1.subject_name = t2.subject_name
order by t1.student_id, t1.subject_name