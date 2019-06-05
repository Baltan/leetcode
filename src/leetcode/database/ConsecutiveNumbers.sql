# 180. Consecutive Numbers
select distinct t.v1 ConsecutiveNums
from (select l1.Num v1, l2.Num v2, l3.Num v3
      from Logs l1,
           Logs l2,
           Logs l3
      where l1.Id in (select Id from Logs l4)
        and l2.Id = l1.Id + 1
        and l3.Id = l1.Id + 2) t
where t.v1 = t.v2
  and t.v2 = t.v3