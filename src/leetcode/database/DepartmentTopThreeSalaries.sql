# 185. Department Top Three Salaries
select d.Name Department, e4.Name Employee, e4.Salary
from Employee e4,
     Department d,
     (select max(x4.Salary)  Salary,
             x4.DepartmentId DepartmentId
      from (select ifnull(e3.Salary, 0) Salary,
                   x3.DepartmentId      DepartmentId
            from Employee e3
                     right join
                 (select max(x2.Salary) Salary, x2.DepartmentId DepartmentId
                  from (select e2.Salary Salary, x1.DepartmentId DepartmentId
                        from Employee e2
                                 right join
                             (select ifnull(max(e1.Salary), 0) Salary, e1.DepartmentId DepartmentId
                              from Employee e1
                              group by e1.DepartmentId) x1
                             on e2.DepartmentId = x1.DepartmentId
                                 and e2.Salary < x1.Salary) x2
                  group by x2.DepartmentId) x3
                 on e3.Salary < x3.Salary
                     and e3.DepartmentId = x3.DepartmentId) x4
      group by x4.DepartmentId) x5
where e4.DepartmentId = d.Id
  and e4.DepartmentId = x5.DepartmentId
  and e4.Salary >= x5.Salary