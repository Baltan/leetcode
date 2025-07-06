# 3580. Find Consistently Improving Employees
# t1：每个员工最后一次被评估的日期
with t1 as (select employee_id,
                   max(review_date) review_date
            from performance_reviews
            group by employee_id),
     # t2：每个员工最后一次被评估的分数
     t2 as (select t.employee_id, t.rating
            from t1,
                 performance_reviews t
            where t1.employee_id = t.employee_id
              and t1.review_date = t.review_date),
     # t3：每个员工倒数第二次被评估的日期
     t3 as (select t.employee_id,
                   max(t.review_date) review_date
            from t1,
                 performance_reviews t
            where t1.employee_id = t.employee_id
              and t1.review_date > t.review_date
            group by t.employee_id),
     # t4：每个员工倒数第二次被评估的分数
     t4 as (select t.employee_id, t.rating
            from t3,
                 performance_reviews t
            where t3.employee_id = t.employee_id
              and t3.review_date = t.review_date),
     # t5：每个员工倒数第三次被评估的日期
     t5 as (select t.employee_id,
                   max(t.review_date) review_date
            from t3,
                 performance_reviews t
            where t3.employee_id = t.employee_id
              and t3.review_date > t.review_date
            group by t.employee_id),
     # t6：每个员工倒数第三次被评估的分数
     t6 as (select t.employee_id, t.rating
            from t5,
                 performance_reviews t
            where t5.employee_id = t.employee_id
              and t5.review_date = t.review_date)
select t.employee_id, t.name, t2.rating - t6.rating improvement_score
from t2,
     t4,
     t6,
     employees t
where t2.employee_id = t4.employee_id
  and t2.employee_id = t6.employee_id
  and t2.employee_id = t.employee_id
  and t2.rating > t4.rating
  and t4.rating > t6.rating
order by improvement_score desc, name