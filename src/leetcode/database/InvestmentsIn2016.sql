# 585. Investments in 2016
select round(sum(t1.TIV_2016), 2) tiv_2016
from (select t1.*
      from insurance t1,
           (select TIV_2015 from insurance group by TIV_2015 having count(TIV_2015) > 1) t2
      where t1.TIV_2015 = t2.TIV_2015) t1,
     (select t1.*
      from insurance t1,
           (select LAT, LON from insurance group by LAT, LON having count(*) = 1) t2
      where t1.LAT = t2.LAT
        and t1.LON = t2.LON) t2
where t1.pid = t2.pid