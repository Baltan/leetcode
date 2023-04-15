# 1321. Restaurant Growth
select t1.visited_on, sum(t2.amount) amount, round(sum(t2.amount) / 7, 2) average_amount
from (select distinct visited_on from Customer) t1,
     Customer t2
where t1.visited_on >= (select visited_on
                        from (select distinct visited_on from Customer order by visited_on limit 7) t1
                        order by visited_on desc
                        limit 1)
  and t2.visited_on between date_sub(t1.visited_on, interval 6 day) and t1.visited_on
group by t1.visited_on
order by visited_on