# 1075. Project Employees I
select t1.project_id, round(avg(t2.experience_years), 2) average_years
from Project t1,
     Employee t2
where t1.employee_id = t2.employee_id
group by t1.project_id