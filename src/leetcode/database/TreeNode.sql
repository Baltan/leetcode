# 608. Tree Node
select id, Type
from (
         select id, 'Root' Type
         from tree
         where isnull(p_id)
         union
         select id, 'Inner' Type
         from tree
         where not isnull(p_id)
           and id in (select p_id from tree where not isnull(p_id))
         union
         select id, 'Leaf' Type
         from tree
         where id not in (select p_id from tree where not isnull(p_id))
           and not isnull(p_id)) t
order by id