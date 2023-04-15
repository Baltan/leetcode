# 1341. Movie Rating
select t.*
from ((select t1.name results
       from Users t1,
            (select user_id, count(user_id) cnt from MovieRating group by user_id) t2
       where t1.user_id = t2.user_id
       order by t2.cnt desc, t1.name asc
       limit 1)
      union all
      (select t1.title results
       from Movies t1,
            (select movie_id, avg(rating) rating
             from MovieRating
             where created_at like concat('2020-02', '%')
             group by movie_id) t2
       where t1.movie_id = t2.movie_id
       order by t2.rating desc, t1.title asc
       limit 1)) t