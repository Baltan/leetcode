# 1141. User Activity for the Past 30 Days I
select activity_date day, count(distinct user_id) active_users
from Activity
where activity_date < '2019-07-28'
  and activity_date > '2019-06-27'
group by activity_date