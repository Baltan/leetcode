# 3564. Seasonal Sales Analysis
-- t1: 计算出各个季节，每类商品的总销量和总收入
with t1 as (select t2.category,
                   (case
                        when month(t1.sale_date) in (3, 4, 5) then 'Spring'
                        when month(t1.sale_date) in (6, 7, 8) then 'Summer'
                        when month(t1.sale_date) in (9, 10, 11) then 'Fall'
                        when month(t1.sale_date) in (12, 1, 2) then 'Winter'
                       end)                    season,
                   sum(t1.quantity)            total_quantity,
                   sum(t1.quantity * t1.price) total_revenue
            from sales t1,
                 products t2
            where t1.product_id = t2.product_id
            group by t2.category, season),
     -- t2: 计算出各个季节销量最大的商品的总销量
     t2 as (select t1.season,
                   max(t1.total_quantity) total_quantity
            from t1
            group by t1.season),
     -- t3: 计算出各个季节销量最大的商品中总收入最大的商品的总收入
     t3 as (select t1.season,
                   max(t1.total_revenue) total_revenue
            from t1,
                 t2
            where t1.total_quantity = t2.total_quantity
            group by t1.season)
select t1.season, t1.category, t1.total_quantity, t1.total_revenue
from t1,
     t2,
     t3
where t1.season = t2.season
  and t1.season = t3.season
  and t1.total_quantity = t2.total_quantity
  and t1.total_revenue = t3.total_revenue
order by t1.season