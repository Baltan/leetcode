# 3554. Find Category Recommendation Pairs
with t1 as (select distinct t1.user_id, t2.category
            from ProductPurchases t1,
                 ProductInfo t2
            where t1.product_id = t2.product_id),
     t2 as (select t1.category category1, t2.category category2
            from t1,
                 t1 t2
            where t1.user_id = t2.user_id
              and t1.category < t2.category)
select category1, category2, count(*) customer_count
from t2
group by category1, category2
having (customer_count) >= 3
order by customer_count desc, category1, category2



