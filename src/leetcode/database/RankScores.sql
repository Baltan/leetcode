select s2.Score, c.rank
from Scores s2,
     (select @rank := @rank + 1 rank, a.score score
      from (select distinct s1.Score score from Scores s1 order by s1.Score desc) a, (select @ rank := 0) b) c
where s2.Score = c.score
order by c.rank