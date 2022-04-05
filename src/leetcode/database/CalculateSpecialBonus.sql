# 1873. Calculate Special Bonus
select employee_id, if(left(name, 1) != 'M' and employee_id & 1, salary, 0) bonus
from Employees
group by employee_id