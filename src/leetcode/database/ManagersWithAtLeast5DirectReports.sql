# 570. Managers with at Least 5 Direct Reports
select t1.name
from Employee t1,
     (select managerId from Employee where not isnull(managerId) group by managerId having (count(managerId) >= 5)) t2
where t1.id = t2.managerId