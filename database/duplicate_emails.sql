# https://leetcode.com/problems/duplicate-emails/
# Write your MySQL query statement below
# Runtime: 177 ms
SELECT 
    Email
FROM 
    Person
GROUP BY 
    Email
HAVING 
    count(*) > 1