# 3497. Analyze Subscription Conversion
with t1 as (select user_id, activity_type, round(sum(activity_duration) / count(*), 2) avg_duration
            from UserActivity
            group by user_id, activity_type),
     t2 as (select t1.user_id, t1.avg_duration
            from t1
            where t1.activity_type = 'free_trial'),
     t3 as (select t1.user_id, t1.avg_duration
            from t1
            where t1.activity_type = 'paid')
select t2.user_id, t2.avg_duration trial_avg_duration, t3.avg_duration paid_avg_duration
from t2,
     t3
where t2.user_id = t3.user_id
order by t2.user_id

