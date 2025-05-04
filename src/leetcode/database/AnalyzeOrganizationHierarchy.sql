# 3482. analyze organization hierarchy
# 参考：<a href="https://leetcode.cn/problems/analyze-organization-hierarchy/solutions/3607154/mysql-with-recursive-pandas-shu-xing-dp-gskbg/">
with recursive
    # 从CEO开始递归计算每个员工所在的组织层级
    t1 as (select employee_id, employee_name, manager_id, salary, 1 level
           from Employees
           where isnull(manager_id)
           union all
           select e.employee_id,
                  e.employee_name,
                  e.manager_id,
                  e.salary,
                  t1.level + 1
           from Employees e
                    inner join t1 on e.manager_id = t1.employee_id),
    # 从每个员工开始递归获取组织架构树中以其作为根节点的子树中的所有节点，子树中的所有节点用group_id标记它们同属于一个集合
    t2 as (select employee_id, employee_name, employee_id group_id, salary, level
           from t1
           union all
           select t1.employee_id,
                  t2.employee_name,
                  t2.group_id,
                  t1.salary,
                  t2.level
           from t1
                    inner join t2 on t1.manager_id = t2.employee_id)
# 计算组织架构树中以各个节点分别作为根节点的子树中所有节点代表员工的薪资总和（包含根节点）与团队大小（不包含根节点）
select group_id     employee_id,
       employee_name,
       level,
       count(*) - 1 team_size,
       sum(salary)  budget
from t2
group by group_id, employee_name, level
order by level, budget desc, employee_name