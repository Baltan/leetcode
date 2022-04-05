# 1890. The Latest Login in 2020
select user_id, max(time_stamp) last_stamp
from Logins
where time_stamp between '2020-01-01 00:00:00' and '2020-12-31 23:59:59'
group by user_id