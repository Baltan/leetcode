# 1179. Reformat Department Table
select id,
       max(if(month = 'Jan', revenue, null)) Jan_Revenue,
       max(if(month = 'Feb', revenue, null)) Feb_Revenue,
       max(if(month = 'Mar', revenue, null)) Mar_Revenue,
       max(if(month = 'Apr', revenue, null)) Apr_Revenue,
       max(if(month = 'May', revenue, null)) May_Revenue,
       max(if(month = 'Jun', revenue, null)) Jun_Revenue,
       max(if(month = 'Jul', revenue, null)) Jul_Revenue,
       max(if(month = 'Aug', revenue, null)) Aug_Revenue,
       max(if(month = 'Sep', revenue, null)) Sep_Revenue,
       max(if(month = 'Oct', revenue, null)) Oct_Revenue,
       max(if(month = 'Nov', revenue, null)) Nov_Revenue,
       max(if(month = 'Dec', revenue, null)) Dec_Revenue
from Department
group by id