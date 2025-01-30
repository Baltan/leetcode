# 3436. Find Valid Emails
select user_id, email
from Users
where email regexp '^[a-zA-Z0-9_]+@[a-zA-Z].*\\.com$'
order by user_id