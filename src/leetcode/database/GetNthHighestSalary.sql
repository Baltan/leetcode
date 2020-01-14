# 177. Nth Highest Salary
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        # Write your MySQL query statement below.
        select if(count(*) = N, min(temp.Salary), null)
        from (select distinct Salary from Employee order by Salary desc limit N) temp
    );
END