# 1068. Product Sales Analysis I
select t2.product_name, t1.year, t1.price
from Sales t1,
     Product t2
where t1.product_id = t2.product_id