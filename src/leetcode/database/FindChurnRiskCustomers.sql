# 3716. Find Churn Risk Customers
with t1 as (select user_id,
                   min(event_date)     start_date,
                   max(event_date)     end_date,
                   max(monthly_amount) max_monthly_amount,
                   max(event_id)       max_event_id
            from subscription_events
            group by user_id),
     t2 as (select t.user_id,
                   t.event_type,
                   t.plan_name,
                   t.monthly_amount
            from subscription_events t,
                 t1
            where t.user_id = t1.user_id
              and t.event_date = t1.end_date
              and t.event_id = t1.max_event_id),
     t3 as (select user_id,
                   count(*) downgrade_count
            from subscription_events
            where event_type = 'downgrade'
            group by user_id)
select t2.user_id,
       t2.plan_name                         current_plan,
       t2.monthly_amount                    current_monthly_amount,
       t1.max_monthly_amount                max_historical_amount,
       datediff(t1.end_date, t1.start_date) days_as_subscriber
from t1,
     t2,
     t3
where t1.user_id = t2.user_id
  and t2.user_id = t3.user_id
  and t2.event_type != 'cancel'
  and t3.downgrade_count > 0
  and t2.monthly_amount * 2 < t1.max_monthly_amount
  and datediff(t1.end_date, t1.start_date) >= 60
order by days_as_subscriber desc, t2.user_id