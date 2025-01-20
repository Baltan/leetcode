# 3421. Find Students Who Improved
with t1 as (select student_id,
                   subject,
                   min(exam_date) first_date,
                   max(exam_date) latest_date
            from Scores
            group by student_id, subject
            having first_date != latest_date),
     t2 as (select distinct t1.student_id,
                            t1.subject,
                            (select score
                             from Scores
                             where Scores.student_id = t1.student_id
                               and t1.subject = Scores.subject
                               and t1.first_date = Scores.exam_date
                             limit 1) first_score,
                            (select score
                             from Scores
                             where Scores.student_id = t1.student_id
                               and t1.subject = Scores.subject
                               and t1.latest_date = Scores.exam_date
                             limit 1) latest_score
            from t1,
                 Scores
            where t1.student_id = Scores.student_id
              and t1.subject = Scores.subject
            order by t1.student_id, t1.subject)
select t2.student_id, t2.subject, t2.first_score, t2.latest_score
from t2
where t2.first_score < t2.latest_score