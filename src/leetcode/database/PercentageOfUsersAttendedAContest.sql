# 1633. Percentage of Users Attended a Contest
select t1.contest_id, round(100.0 * count(t1.contest_id) / t2.cnt, 2) percentage
from Register t1,
     (select count(*) cnt from Users) t2
group by t1.contest_id
order by percentage desc, contest_id