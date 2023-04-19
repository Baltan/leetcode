# 1251. Average Selling Price
select t1.product_id, round(sum(t1.price * t2.units) / sum(t2.units), 2) average_price
from Prices t1,
     UnitsSold t2
where t1.product_id = t2.product_id
  and t2.purchase_date between t1.start_date and t1.end_date
group by t1.product_id