# Write your MySQL query statement below
select max(Employee.Salary) from Employee where Employee.Salary not in(select max(Employee.Salary) from Employee);