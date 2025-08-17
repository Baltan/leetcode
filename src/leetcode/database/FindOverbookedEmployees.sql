# 3611. Find Overbooked Employees
with t1 as (select employee_id
            from meetings
            group by employee_id, week(meeting_date, 1)
            having sum(duration_hours) > 20),
     t2 as (select employee_id, count(employee_id) meeting_heavy_weeks
            from t1
            group by employee_id
            having count(employee_id) >= 2)
select t3.employee_id, t3.employee_name, t3.department, t2.meeting_heavy_weeks
from t2,
     employees t3
where t2.employee_id = t3.employee_id
order by t2.meeting_heavy_weeks desc, t3.employee_name

