# Write your MySQL query statement below

# Runtime: 3421 ms, faster than 5.02% of MySQL online submissions for Delete Duplicate Emails.
delete p1 from person p1, person p2 
where p1.email = p2.email and p1.id > p2.id;

Runtime: 2054 ms, faster than 32.86% of MySQL online submissions for Delete Duplicate Emails.
delete from person
where id not in (
    select id 
    from (select min(id) as id 
        from person 
        group by email) p);

# Runtime: 2200 ms, faster than 26.74% of MySQL online submissions for Delete Duplicate Emails.
delete from person
where id not in(
    select t.id from (
    select min(id) as id
from person
group by email
    ) t
);