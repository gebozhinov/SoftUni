UPDATE projects
SET end_date = start_date + INTERVAL '5 month'
WHERE end_date IS NULL;

SELECT * FROM projects
ORDER BY id;
