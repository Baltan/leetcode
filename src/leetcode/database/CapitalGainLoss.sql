# 1393. Capital Gain/Loss
select b.stock_name, ifnull(s.price, 0) - b.price capital_gain_loss
from (select stock_name, sum(price) price from Stocks where operation = 'Buy' group by stock_name) b
         left join
     (select stock_name, sum(price) price from Stocks where operation = 'Sell' group by stock_name) s
     on b.stock_name = s.stock_name
