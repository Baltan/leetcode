# 1581. Customer Who Visited but Did Not Make Any Transactions
select customer_id, count(customer_id) count_no_trans
from Visits
where visit_id not in (select visit_id from Transactions)
group by customer_id