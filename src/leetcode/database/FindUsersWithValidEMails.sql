# 1517. Find Users With Valid E-Mails
select *
from Users
where mail regexp '^[a-zA-Z]{1}[a-zA-Z0-9_\\.\\-]*@leetcode\\.com$'