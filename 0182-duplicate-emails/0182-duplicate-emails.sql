# Write your MySQL query statement below
Select 
email as Email 
From 
Person
Group By 
email
Having 
Count(email) > 1;