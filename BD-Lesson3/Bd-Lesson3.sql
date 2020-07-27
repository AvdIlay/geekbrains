    --Сделать запрос, в котором мы выберем все данные о городе – регион, страна.
SELECT 
    c.title, r.title, co.title
FROM
    geodata._cities c,
    geodata._regions r,
    geodata._countries co 
WHERE
    r.country_id = co.id
        AND c.region_id = r.id;
   

    --Выбрать все города из Московской области.
SELECT 
    c.title, r.title
FROM
    geodata._cities c,
    geodata._regions r
WHERE
    r.title = "Московская область"
        AND c.region_id = r.id;

        --Выбрать среднюю зарплату по отделам.
        SELECT 
    d.dept_name, AVG (salary)
FROM
    eml_full.dept_emp de
        JOIN
    eml_full.departments d ON de.dept_no = d.dept_no
        JOIN
    eml_full.salaries s ON s.emp_no = de.emp_no
WHERE
    de.to_date = '9999-01-01'
GROUP BY d.dept_name;

    --Выбрать максимальную зарплату у сотрудника.
    SELECT 
    e.first_name, e.last_name, s.salary
FROM
    eml_full.employees e
        JOIN
    eml_full.salaries s 
    ON s.emp_no = e.emp_no
where s.salary = (select MAX(salary) from eml_full.salaries s)
AND s.to_date = '9999-01-01';

    --Удалить одного сотрудника, у которого максимальная зарплата.
    with max_salary(salary) as (SELECT 
            MAX(salary)
        FROM
            eml_full.salaries s)  
delete e, s, t, dm, de FROM 
    eml_full.salaries s
    join
    max_salary on s.salary = max_salary.salary
    join
    eml_full.employees e ON s.emp_no = e.emp_no
        JOIN
    eml_full.titles t ON t.emp_no = e.emp_no
        LEFT JOIN
    eml_full.dept_manager dm ON dm.emp_no = e.emp_no
        JOIN
    eml_full.dept_emp de ON de.emp_no = e.emp_no;

    --Посчитать количество сотрудников во всех отделах.
    SELECT 
    d.dept_name, COUNT(emp_no)
FROM
    eml_full.dept_emp de
        JOIN
   eml_full.departments d ON de.dept_no = d.dept_no
WHERE
    de.to_date = '1997-11-08'
GROUP BY d.dept_name;

    --Найти количество сотрудников в отделах и посмотреть, сколько всего денег получает отдел.
    SELECT 
    d.dept_name, SUM(salary)
FROM
    eml_full.dept_emp de
        JOIN
    eml_full.departments d ON de.dept_no = d.dept_no
        JOIN
    eml_full.employees e ON e.emp_no = de.emp_no
        JOIN
    eml_full.salaries s ON e.emp_no = s.emp_no
WHERE
    de.to_date = '9999-01-01'
GROUP BY d.dept_name;

