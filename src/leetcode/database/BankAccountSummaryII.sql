# 1587. Bank Account Summary II
select u.name, t.balance
from Users u
         inner join
     (select account, sum(amount) balance from Transactions group by account) t on u.account = t.account
where t.balance > 10000