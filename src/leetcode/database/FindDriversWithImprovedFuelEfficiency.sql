# 3601. Find Drivers with Improved Fuel Efficiency
with t as (select driver_id,
                  avg(distance_km / fuel_consumed)                                                      avg,
                  (case quarter(trip_date) when 1 then 1 when 2 then 1 when 3 then 2 when 4 then 2 end) half
           from trips
           group by driver_id, half)
select t3.driver_id,
       t3.driver_name,
       round(t1.avg, 2)          first_half_avg,
       round(t2.avg, 2)          second_half_avg,
       round(t2.avg - t1.avg, 2) efficiency_improvement
from t t1,
     t t2,
     drivers t3
where t1.driver_id = t2.driver_id
  and t1.driver_id = t3.driver_id
  and t1.half = 1
  and t2.half = 2
  and t1.avg < t2.avg
order by efficiency_improvement desc, t3.driver_name