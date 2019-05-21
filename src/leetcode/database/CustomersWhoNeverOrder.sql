# 183. Customers Who Never Order
select Name Customers
from Customers cu
where cu.Id not in (select CustomerId from Orders)