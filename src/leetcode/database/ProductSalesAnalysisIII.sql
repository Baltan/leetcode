# 1070. Product Sales Analysis III
select t1.product_id, t1.year first_year, t1.quantity, t1.price
from Sales t1,
     (select product_id, min(year) year from Sales group by product_id) t2
where t1.product_id = t2.product_id
  and t1.year = t2.year