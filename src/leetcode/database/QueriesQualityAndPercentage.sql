# 1211. Queries Quality and Percentage
select t1.query_name, t1.quality, ifnull(round(100.0 * t2.x / t1.x, 2), 0) poor_query_percentage
from (select query_name, round(avg(rating / position), 2) quality, count(query_name) x
      from Queries
      group by query_name) t1
         left join
     (select query_name, count(query_name) x from Queries where rating < 3 group by query_name) t2
     on t1.query_name = t2.query_name