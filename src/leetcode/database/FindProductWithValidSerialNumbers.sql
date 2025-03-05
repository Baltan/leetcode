# 3465. Find Products with Valid Serial Numbers
select product_id, product_name, description
from products
where description regexp '(^SN[0-9]{4}-[0-9]{4}$| SN[0-9]{4}-[0-9]{4}$|^SN[0-9]{4}-[0-9]{4} | SN[0-9]{4}-[0-9]{4} )'
order by product_id