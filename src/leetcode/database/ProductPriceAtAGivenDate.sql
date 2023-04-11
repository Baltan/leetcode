# 1164. Product Price at a Given Date
select t1.product_id, ifnull(t2.new_price, 10) price
from (select distinct product_id from Products) t1
         left join
     (select t1.*
      from Products t1,
           (select product_id, max(change_date) change_date
            from Products
            where change_date <= '2019-08-16'
            group by product_id) t2
      where t1.product_id = t2.product_id
        and t1.change_date = t2.change_date) t2 on t1.product_id = t2.product_id