# 3521. Find Product Recommendation Pairs
select t1.product1_id,
       t1.product2_id,
       t2.category       product1_category,
       t3.category       product2_category,
       count(t1.user_id) customer_count
from (select t1.user_id, t1.product_id product1_id, t2.product_id product2_id
      from ProductPurchases t1,
           ProductPurchases t2
      where t1.user_id = t2.user_id
        and t1.product_id < t2.product_id) t1,
     ProductInfo t2,
     ProductInfo t3
where t1.product1_id = t2.product_id
  and t1.product2_id = t3.product_id
group by t1.product1_id, t2.product2_id
having count(t1.user_id) >= 3
order by count(t1.user_id) desc, t1.product1_id, t1.product2_id