create database newdb1;
use newdb1;

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    emp_salary DECIMAL(10, 2),
    emp_doj DATE,
    emp_dob DATE,
    emp_designation VARCHAR(50),
    emp_department VARCHAR(50),
    emp_address VARCHAR(100),
    emp_photo VARCHAR(100)
);
select * from employees;
