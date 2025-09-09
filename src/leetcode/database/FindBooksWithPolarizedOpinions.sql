# 3642. Find Books with Polarized Opinions
with t as (select book_id,
                  min(session_rating)                                       min_session_rating,
                  max(session_rating)                                       max_session_rating,
                  sum(if(session_rating <= 2 or session_rating >= 4, 1, 0)) extreme_rating_cnt,
                  count(book_id)                                            session_cnt
           from reading_sessions
           group by book_id)
select t1.book_id,
       t1.title,
       t1.author,
       t1.genre,
       t1.pages,
       t.max_session_rating - t.min_session_rating rating_spread,
       round(t.extreme_rating_cnt / t.session_cnt, 2)        polarization_score
from t,
     books t1
where t.book_id = t1.book_id
  and t.min_session_rating <= 2
  and t.max_session_rating >= 4
  and t.session_cnt >= 5
  and t.extreme_rating_cnt / t.session_cnt >= 0.6
order by polarization_score desc, t1.title desc
