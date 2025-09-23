# 3657. Find Loyal Customers
with t1 as (select customer_id,
                   sum(if(transaction_type = 'purchase', 1, 0)) purchase_days,
                   count(*)                                     total_days,
                   min(transaction_date)                        first_day,
                   max(transaction_date)                        last_day
            from customer_transactions
            group by customer_id)
select customer_id
from t1
where purchase_days >= 3
  and datediff(last_day, first_day) >= 30
  and (total_days - purchase_days) / total_days < 0.2
order by customer_id