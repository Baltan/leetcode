# 3626. Find Stores with Inventory Imbalance
with t1 as (select store_id, max(price) max_price, min(price) min_price, count(price) cnt
            from inventory
            group by store_id
            having count(price) >= 3),
     t2 as (select t.store_id, t.price, max(t.quantity) over (partition by t.store_id, t.price) quantity, t.product_name
            from t1,
                 inventory t
            where t1.store_id = t.store_id
              and t1.max_price = t.price),
     t3 as (select t.store_id, t.price, max(t.quantity) over (partition by t.store_id, t.price) quantity, t.product_name
            from t1,
                 inventory t
            where t1.store_id = t.store_id
              and t1.min_price = t.price)
select t2.store_id,
       t.store_name,
       t.location,
       t2.product_name                     most_exp_product,
       t3.product_name                     cheapest_product,
       round(t3.quantity / t2.quantity, 2) imbalance_ratio
from t2,
     t3,
     stores t
where t.store_id = t2.store_id
  and t2.store_id = t3.store_id
  and t2.quantity < t3.quantity
order by imbalance_ratio desc, t.store_name
