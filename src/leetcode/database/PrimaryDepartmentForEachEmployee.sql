# 1789. Primary Department for Each Employee
select employee_id, department_id
from Employee
where primary_flag = "Y"
UNION
select t2.employee_id, t2.department_id
from (select employee_id from Employee group by employee_id having count(employee_id) = 1) t1,
     Employee t2
where t1.employee_id = t2.employee_id