# 3808. Find Emotionally Consistent Users
with t1 as (select user_id, count(user_id) cnt
            from reactions
            group by user_id
            having count(user_id) >= 5),
     t2 as (select user_id, reaction, count(reaction) cnt
            from reactions
            group by user_id, reaction)
select t1.user_id, t2.reaction dominant_reaction, round(t2.cnt / t1.cnt, 2) reaction_ratio
from t1,
     t2
where t1.user_id = t2.user_id
  and round(t2.cnt / t1.cnt, 2) >= 0.6
order by reaction_ratio desc, user_id