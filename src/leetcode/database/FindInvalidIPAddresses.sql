# 3451. Find Invalid IP Addresses
select ip,
       count(*) invalid_count
from logs
where length(regexp_replace(ip, '[0-9]', '')) != 3
   or substring_index(ip, '.', 1) not regexp "^[0-9]$|^[1-9][0-9]$|^1[0-9]{2}$|^2[0-4][0-9]$|^25[0-5]$"
   or substring_index(substring_index(ip, '.', 2), ".", -1) not regexp
      "^[0-9]$|^[1-9][0-9]$|^1[0-9]{2}$|^2[0-4][0-9]$|^25[0-5]$"
   or substring_index(substring_index(ip, '.', 3), ".", -1) not regexp
      "^[0-9]$|^[1-9][0-9]$|^1[0-9]{2}$|^2[0-4][0-9]$|^25[0-5]$"
   or substring_index(ip, '.', -1) not regexp "^[0-9]$|^[1-9][0-9]$|^1[0-9]{2}$|^2[0-4][0-9]$|^25[0-5]$"
group by ip
order by invalid_count desc, ip desc