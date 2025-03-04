# 3475. DNA Pattern Recognition
with t1 as (select sample_id from Samples where left(dna_sequence, 3) = 'ATG'),
     t2 as (select sample_id
            from Samples
            where right(dna_sequence, 3) = 'TAA'
               or right(dna_sequence, 3) = 'TAG'
               or right(dna_sequence, 3) = 'TGA'),
     t3 as (select sample_id from Samples where dna_sequence like '%ATAT%'),
     t4 as (select sample_id from Samples where dna_sequence like '%GGG%')
select t.sample_id,
       t.dna_sequence,
       t.species,
       if(isnull(t1.sample_id), 0, 1) has_start,
       if(isnull(t2.sample_id), 0, 1) has_stop,
       if(isnull(t3.sample_id), 0, 1) has_atat,
       if(isnull(t4.sample_id), 0, 1) has_ggg
from Samples t
         left join t1 on t.sample_id = t1.sample_id
         left join t2 on t.sample_id = t2.sample_id
         left join t3 on t.sample_id = t3.sample_id
         left join t4 on t.sample_id = t4.sample_id
order by t.sample_id