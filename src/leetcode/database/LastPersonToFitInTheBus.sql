# 1204. Last Person to Fit in the Bus
# 参考：<a href="https://leetcode.cn/problems/last-person-to-fit-in-the-bus/solutions/229666/zui-hou-yi-ge-neng-jin-ru-dian-ti-de-ren-by-leetco/">
select t2.person_name
from (select person_name, @total := @total + weight weight
      from Queue,
           (select @total := 0) t1
      order by turn) t2
where t2.weight <= 1000
order by t2.weight desc
limit 1