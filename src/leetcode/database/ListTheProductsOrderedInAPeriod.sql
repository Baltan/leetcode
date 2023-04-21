# 1327. List the Products Ordered in a Period
select t1.product_name, sum(t2.unit) unit
from Products t1,
     Orders t2
where t1.product_id = t2.product_id
  and t2.order_date between '2020-02-01' and '2020-02-29'
group by t1.product_name
having sum(t2.unit) >= 100