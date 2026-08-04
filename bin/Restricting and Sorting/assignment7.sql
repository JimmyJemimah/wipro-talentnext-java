SELECT last_name, hire_date 
FROM employees 
WHERE hire_date LIKE '%94' 
   OR EXTRACT(YEAR FROM hire_date) = 1994;