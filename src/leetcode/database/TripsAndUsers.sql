# 262. Trips and Users
select t2.request_at                        `Day`,
       round(ifnull(t1.num, 0) / t2.num, 2) `Cancellation Rate`
from (
         select t1.request_at,
                count(*) num
         from Trips t1,
              Users t2,
              Users t3
         where t1.client_id = t2.users_id
           and t1.driver_id = t3.users_id
           and t2.banned = 'No'
           and t3.banned = 'No'
           and t1.status != 'completed'
         group by t1.request_at
     ) t1
         right join
     (
         select t1.request_at,
                count(*) num
         from Trips t1,
              Users t2,
              Users t3
         where t1.client_id = t2.users_id
           and t1.driver_id = t3.users_id
           and t2.banned = 'No'
           and t3.banned = 'No'
         group by t1.request_at
     ) t2
     on t1.request_at = t2.request_at
where t2.request_at between '2013-10-01' and '2013-10-03'