# 1729. Find Followers Count
select user_id, coalesce(count(follower_id), 0) followers_count
from Followers
group by user_id
order by user_id