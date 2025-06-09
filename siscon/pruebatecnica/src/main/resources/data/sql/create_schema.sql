CREATE TABLE employees (
   employee_id SERIAL PRIMARY KEY,
   given_name VARCHAR(30) NOT NULL,
   middle_name VARCHAR(30) NOT NULL,
   surname VARCHAR(30) NOT NULL,
   age INTEGER NOT NULL,
   gender VARCHAR(1) ,
   birth_day TIMESTAMP,
   position VARCHAR(30)
);


CREATE INDEX idx_gender ON employees(gender);
CREATE INDEX idx_position ON employees(position);