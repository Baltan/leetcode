# 602. Friend Requests II: Who Has the Most Friends
select t1.id, count(t1.id) num
from (select requester_id id from RequestAccepted union all select accepter_id id from RequestAccepted) t1
group by t1.id
order by count(t1.id) desc
limit 1