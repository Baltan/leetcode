# 1965. Employees With Missing Information
select employee_id
from (select t1.employee_id
      from Employees t1
               left join Salaries t2 on t1.employee_id = t2.employee_id
      where isnull(t2.employee_id)
      union all
      select t2.employee_id
      from Employees t1
               right join Salaries t2 on t1.employee_id = t2.employee_id
      where isnull(t1.employee_id)) t
order by employee_id