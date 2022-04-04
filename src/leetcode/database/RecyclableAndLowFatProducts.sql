# 1757. Recyclable and Low Fat Products
select product_id
from Products
where low_fats = 'Y'
  and recyclable = 'Y'