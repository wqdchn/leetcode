# Write your MySQL query statement below
SELECT FirstName, LastName, City, State
FROM Person a LETF JOIN Address b
ON a.PersonId = b.PersonId