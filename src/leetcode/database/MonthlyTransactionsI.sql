# 1193. Monthly Transactions I
select t2.trans_date                       month,
       t2.country,
       t2.trans_count,
       ifnull(t1.approved_count, 0)        approved_count,
       t2.trans_total_amount,
       ifnull(t1.approved_total_amount, 0) approved_total_amount
from (select country, left(trans_date, 7) trans_date, count(*) approved_count, sum(amount) approved_total_amount
      from Transactions
      where state = 'approved'
      group by country, left(trans_date, 7)) t1
         right join
     (select country, left(trans_date, 7) trans_date, count(*) trans_count, sum(amount) trans_total_amount
      from Transactions
      group by country, left(trans_date, 7)) t2 on t1.country = t2.country and t1.trans_date = t2.trans_date