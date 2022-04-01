# 1158. Market Analysis I
select u.user_id buyer_id, u.join_date, ifnull(t.orders_in_2019, 0) orders_in_2019
from Users u
         left join (select buyer_id, count(buyer_id) orders_in_2019
                    from Orders
                    where order_date between '2019-01-01' and '2019-12-31'
                    group by buyer_id) t on u.user_id = t.buyer_id