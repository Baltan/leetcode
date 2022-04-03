# 1693. Daily Leads and Partners
select date_id,
       make_name,
       coalesce(count(distinct lead_id), 0)    unique_leads,
       coalesce(count(distinct partner_id), 0) unique_partners
from DailySales
group by date_id, make_name