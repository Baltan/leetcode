# 196. Delete Duplicate Emails
-- delete p1 from Person p1,Person p2 where p1.Email=p2.Email and p1.Id>p2.Id
delete
from Person
where Id not in (select a.Id from (select min(p1.Id) Id from Person p1 group by p1.Email) a)