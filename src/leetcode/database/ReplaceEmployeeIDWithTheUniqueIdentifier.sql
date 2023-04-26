# 1378. Replace Employee ID With The Unique Identifier
select t2.unique_id, t1.name
from Employees t1
         left join EmployeeUNI t2 on t1.id = t2.id