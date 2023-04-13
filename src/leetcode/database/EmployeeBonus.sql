# 577. Employee Bonus
select t1.name, t2.bonus
from Employee t1
         left join Bonus t2 on t1.empId = t2.empId
where isnull(t2.bonus)
   or t2.bonus < 1000