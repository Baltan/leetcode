# 3570. Find Books with No Available Copies
with t1 as (select book_id, count(book_id) cnt
            from borrowing_records
            where isnull(return_date)
            group by book_id)
select t2.book_id,
       t2.title,
       t2.author,
       t2.genre,
       t2.publication_year,
       t1.cnt current_borrowers
from t1,
     library_books t2
where t1.book_id = t2.book_id
  and t1.cnt = t2.total_copies
order by t1.cnt desc, t2.title