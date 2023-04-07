# 550. Game Play Analysis IV
select round(count(*) / (select count(distinct player_id) from Activity), 2) fraction
from (select player_id, min(event_date) event_date
      from Activity
      group by player_id) t1,
     Activity t2
where t1.player_id = t2.player_id
  and datediff(t2.event_date, t1.event_date) = 1