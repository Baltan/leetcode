# 1050. Actors and Directors Who Cooperated At Least Three Times
select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having count(*) >= 3