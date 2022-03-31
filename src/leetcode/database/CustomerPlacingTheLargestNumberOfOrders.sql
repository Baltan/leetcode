# 586. Customer Placing the Largest Number of Orders
select customer_number
from Orders
group by customer_number
order by count(customer_number) desc
limit 1