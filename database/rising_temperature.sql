# https://leetcode.com/problems/rising-temperature/
# Write your MySQL query statement below
# Runtime: 335 ms
SELECT 
    w1.Id
FROM 
    Weather w1,
    Weather w2
WHERE
    TO_DAYS(w1.RecordDate) = TO_DAYS(w2.RecordDate) + 1 AND
    w1.Temperature > w2.Temperature