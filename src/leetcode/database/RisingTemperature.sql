# 197. Rising Temperature
select w1.Id
from Weather w1,
     Weather w2
where TIMESTAMPDIFF(DAY, w2.RecordDate, w1.RecordDate) = 1
  and w1.Temperature > w2.Temperature