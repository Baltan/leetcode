# 175. Combine Two Tables
select t1.FirstName, t1.LastName, t2.City, t2.State
from Person t1
       left join Address t2 on t2.PersonId = t1.PersonId