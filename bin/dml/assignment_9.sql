DELETE FROM my_employee
WHERE LOWER(first_name) LIKE '%man%'
   OR LOWER(last_name) LIKE '%man%';