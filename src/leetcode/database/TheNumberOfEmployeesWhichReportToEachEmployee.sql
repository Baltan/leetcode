# 1731. The Number of Employees Which Report to Each Employee
select t2.employee_id, t2.name, count(t1.employee_id) reports_count, round(avg(t1.age)) average_age
from Employees t1,
     Employees t2
where not isnull(t1.reports_to)
  and t1.reports_to = t2.employee_id
group by t2.employee_id, t2.name
order by t2.employee_id