# 1907. Count Salary Categories
select t1.category, ifnull(t2.cnt, 0) accounts_count
from (select "Low Salary" category
      union all
      select "High Salary" category
      union all
      select "Average Salary" category) t1
         left join
     (select category, count(category) cnt
      from (select (case
                        when income < 20000 then "Low Salary"
                        when income > 50000 then "High Salary"
                        else "Average Salary" end) category
            from Accounts) t1
      group by category) t2 on t1.category = t2.category