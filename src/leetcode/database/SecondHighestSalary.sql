# 176. Second Highest Salary
select max(Salary) SecondHighestSalary
from Employee
where Salary < (select max(Salary) from Employee)