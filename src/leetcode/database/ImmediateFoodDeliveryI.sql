# 1173. Immediate Food Delivery I
select round(t1.cnt / t2.cnt * 100, 2) immediate_percentage
from (select count(*) cnt from Delivery where order_date = customer_pref_delivery_date) t1,
     (select count(*) cnt from Delivery) t2