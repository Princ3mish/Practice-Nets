# Write your MySQL query statement below
Select 
emp.name As Employee 
from
Employee emp
join
Employee mng On emp.managerId = mng.id
where
emp.salary > mng.salary;