# 3220. Odd and Even Transactions
select transaction_date, sum(if(amount % 2 = 1, amount, 0)) odd_sum, sum(if(amount % 2 = 0, amount, 0)) even_sum
from transactions
group by transaction_date
order by transaction_date