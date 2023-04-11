# 1174. Immediate Food Delivery II
select round(100.0 * t1.x / t2.y, 2) immediate_percentage
from (select count(t1.customer_id) x
      from Delivery t1,
           (select customer_id, min(order_date) order_date
            from Delivery
            group by customer_id) t2
      where t1.customer_id = t2.customer_id
        and t1.order_date = t2.order_date
        and t1.order_date = t1.customer_pref_delivery_date) t1,
     (select count(distinct customer_id) y from Delivery) t2