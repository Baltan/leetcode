# 1667. Fix Names in a Table
select user_id, concat(upper(substr(name, 1, 1)), lower(substr(name from 2))) name
from Users order by user_id