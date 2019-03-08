select if(id & 1 = 1, if(id + 1 <= (select count(*) from seat), id + 1, id), id - 1) id, student
from seat
order by id