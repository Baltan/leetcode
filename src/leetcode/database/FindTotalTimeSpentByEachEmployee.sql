# 1741. Find Total Time Spent by Each Employee
select event_day day, emp_id, coalesce(sum(out_time) - sum(in_time), 0) total_time
from Employees
group by day, emp_id