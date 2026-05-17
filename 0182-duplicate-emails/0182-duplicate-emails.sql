# Write your MySQL query statement below
Select Distinct
p1.email as Email
from
person p1
join 
Person p2 ON p1.email = p2.email
where 
p1.id <> p2.id;