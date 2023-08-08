# 2082. The Number of Rich Customers
select count(distinct customer_id) rich_count
from Store
where amount > 500