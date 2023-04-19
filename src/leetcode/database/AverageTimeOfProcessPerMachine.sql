# 1661. Average Time of Process per Machine
select t1.machine_id, round(t2.avg_timestamp - t1.avg_timestamp, 3) processing_time
from (select machine_id, avg(timestamp) avg_timestamp
      from Activity
      where activity_type = 'start'
      group by machine_id) t1,
     (select machine_id, avg(timestamp) avg_timestamp
      from Activity
      where activity_type = 'end'
      group by machine_id) t2
where t1.machine_id = t2.machine_id