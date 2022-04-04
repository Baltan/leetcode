# 1795. Rearrange Products Table
select product_id, 'store1' store, store1 price
from Products
where not isnull(store1)
union all
select product_id, 'store2' store, store2 price
from Products
where not isnull(store2)
union all
select product_id, 'store3' store, store3 price
from Products
where not isnull(store3)
