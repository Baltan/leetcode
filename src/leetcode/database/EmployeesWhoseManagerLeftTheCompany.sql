# 1978. Employees Whose Manager Left the Company
select t1.employee_id
from Employees t1
         left join Employees t2 on t1.manager_id = t2.employee_id
where t1.salary < 30000
  and not isnull(t1.manager_id)
  and isnull(t2.employee_id)
order by employee_id