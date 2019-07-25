# 601. Human Traffic of Stadium
select distinct x.id, x.visit_date, x.people
from (select s1.* from stadium s1 where s1.people >= 100) x,
     (select s2.* from stadium s2 where s2.people >= 100) y,
     (select s3.* from stadium s3 where s3.people >= 100) z
where (x.id + 1 = y.id and x.id + 2 = z.id)
   or (x.id - 1 = y.id and x.id + 1 = z.id)
   or (x.id - 1 = y.id and x.id - 2 = z.id)
order by x.id