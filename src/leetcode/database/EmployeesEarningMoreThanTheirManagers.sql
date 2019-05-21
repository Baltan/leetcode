# 181. Employees Earning More Than Their Managers
select Name Employee
from (select e1.ID, e1.Name, e1.Salary, e1.ManagerId, e2.Salary ManagerSalary
      from Employee e1,
           Employee e2
      where e1.ManagerId = e2.Id) e
where e.Salary > e.ManagerSalary