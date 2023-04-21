# 2356. Number of Unique Subjects Taught by Each Teacher
select teacher_id, count(distinct subject_id) cnt
from Teacher
group by teacher_id