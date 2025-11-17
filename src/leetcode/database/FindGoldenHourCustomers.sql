# 3705. Find Golden Hour Customers
select customer_id,
       count(*)                                                                     total_orders,
       round(sum(if((time(order_timestamp) between '11:00:00' and '14:00:00') or
                    (time(order_timestamp) between '18:00:00' and '21:00:00'), 1, 0)) * 100 /
             count(*))                                                              peak_hour_percentage,
       round(sum(ifnull(order_rating, 0)) / sum(if(isnull(order_rating), 0, 1)), 2) average_rating
from restaurant_orders
group by customer_id
having total_orders >= 3
   and peak_hour_percentage >= 60
   and average_rating >= 4.0
   and sum(if(isnull(order_rating), 0, 1)) / total_orders >= 0.5
order by average_rating desc, customer_id desc