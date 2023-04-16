# 1934. Confirmation Rate
select t1.user_id, if(isnull(t3.cnt), 0.00, round(t3.cnt / t2.cnt, 2)) confirmation_rate
from Signups t1
         left join
     (select user_id, count(user_id) cnt from Confirmations group by user_id) t2 on t1.user_id = t2.user_id
         left join
     (select user_id, count(user_id) cnt from Confirmations where action = 'confirmed' group by user_id) t3
     on t2.user_id = t3.user_id