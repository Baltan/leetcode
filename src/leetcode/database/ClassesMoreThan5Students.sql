# 596. Classes More Than 5 Students
select c.class class
from courses c
group by c.class
having count(DISTINCT c.student) > 4