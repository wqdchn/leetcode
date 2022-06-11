# Write your MySQL query statement below
select a.name as customers from customers a left join orders b on a.id = b.customerid
where b.customerid is null