# 1407. Top Travellers
select u.name, ifnull(t.distance, 0) travelled_distance
from Users u
         left join
         (select user_id, sum(distance) distance from Rides group by user_id) t on u.id = t.user_id
order by travelled_distance desc, name