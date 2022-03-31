# 584. Find Customer Referee
select distinct name
from Customer
where isnull(referee_id)
union all
select name
from Customer
where referee_id != 2