# Write your MySQL query statement below
Select 
emp.name as Employee
from 
Employee emp ,
Employee mng
where 
emp.managerId = mng.id 
And emp.salary > mng.salary;