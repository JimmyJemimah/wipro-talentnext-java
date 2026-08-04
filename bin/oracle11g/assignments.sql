-- ====================================================================
-- ASSIGNMENTS 2 & 3: SCHEMA CREATION AND DATA POPULATION
-- ====================================================================

-- 1. Create the Tables & Constraints
CREATE TABLE REGIONS (
    region_id NUMBER CONSTRAINT region_id_nn NOT NULL,
    region_name VARCHAR2(25)
);
ALTER TABLE REGIONS ADD (CONSTRAINT reg_id_pk PRIMARY KEY (region_id));

CREATE TABLE COUNTRIES (
    country_id CHAR(2) CONSTRAINT country_id_nn NOT NULL,
    country_name VARCHAR2(40),
    region_id NUMBER,
    CONSTRAINT countr_reg_fk FOREIGN KEY (region_id) REFERENCES REGIONS(region_id)
);
ALTER TABLE COUNTRIES ADD (CONSTRAINT country_c_id_pk PRIMARY KEY (country_id));

CREATE TABLE LOCATIONS (
    location_id NUMBER(4),
    street_address VARCHAR2(40),
    postal_code VARCHAR2(12),
    city VARCHAR2(30) CONSTRAINT loc_city_nn NOT NULL,
    state_province VARCHAR2(25),
    country_id CHAR(2),
    CONSTRAINT loc_c_id_fk FOREIGN KEY (country_id) REFERENCES COUNTRIES(country_id)
);
ALTER TABLE LOCATIONS ADD (CONSTRAINT loc_id_pk PRIMARY KEY (location_id));

CREATE TABLE DEPARTMENTS (
    department_id NUMBER(4),
    department_name VARCHAR2(30) CONSTRAINT dept_name_nn NOT NULL,
    manager_id NUMBER(6),
    location_id NUMBER(4),
    CONSTRAINT dept_loc_fk FOREIGN KEY (location_id) REFERENCES LOCATIONS(location_id)
);
ALTER TABLE DEPARTMENTS ADD (CONSTRAINT dept_id_pk PRIMARY KEY (department_id));

CREATE TABLE JOBS (
    job_id VARCHAR2(10),
    job_title VARCHAR2(35) CONSTRAINT job_title_nn NOT NULL,
    min_salary NUMBER(6),
    max_salary NUMBER(6)
);
ALTER TABLE JOBS ADD (CONSTRAINT job_id_pk PRIMARY KEY (job_id));

CREATE TABLE EMPLOYEES (
    employee_id NUMBER(6),
    first_name VARCHAR2(20),
    last_name VARCHAR2(25) CONSTRAINT emp_last_name_nn NOT NULL,
    email VARCHAR2(25) CONSTRAINT emp_email_nn NOT NULL,
    phone_number VARCHAR2(20),
    hire_date DATE CONSTRAINT emp_hire_date_nn NOT NULL,
    job_id VARCHAR2(10) CONSTRAINT emp_job_nn NOT NULL,
    salary NUMBER(8,2),
    commission_pct NUMBER(2,2),
    manager_id NUMBER(6),
    department_id NUMBER(4),
    CONSTRAINT emp_salary_min CHECK (salary > 0),
    CONSTRAINT emp_email_uk UNIQUE (email),
    CONSTRAINT emp_dept_fk FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(department_id),
    CONSTRAINT emp_job_fk FOREIGN KEY (job_id) REFERENCES JOBS(job_id),
    CONSTRAINT emp_manager_fk FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(employee_id)
);
ALTER TABLE EMPLOYEES ADD (CONSTRAINT emp_emp_id_pk PRIMARY KEY (employee_id));
ALTER TABLE DEPARTMENTS ADD (CONSTRAINT dept_mgr_fk FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(employee_id));

-- 2. Insert Sample Data
INSERT INTO REGIONS VALUES (1, 'Europe');
INSERT INTO COUNTRIES VALUES ('UK', 'United Kingdom', 1);
INSERT INTO LOCATIONS VALUES (2400, '8204 Arthur St', 'London', 'London', NULL, 'UK');
INSERT INTO DEPARTMENTS VALUES (90, 'Executive', NULL, 2400);
INSERT INTO JOBS VALUES ('AD_PRES', 'President', 20000, 40000);
INSERT INTO EMPLOYEES VALUES (100, 'Steven', 'King', 'SKING', '515.123.4567', TO_DATE('17-JUN-2003', 'DD-MON-YYYY'), 'AD_PRES', 24000, NULL, NULL, 90);

UPDATE DEPARTMENTS SET manager_id = 100 WHERE department_id = 90;

INSERT INTO JOBS VALUES ('AD_ASST', 'Administration Assistant', 3000, 6000);
INSERT INTO EMPLOYEES VALUES (200, 'Jennifer', 'Whalen', 'JWHALEN', '515.123.4444', TO_DATE('17-SEP-2003', 'DD-MON-YYYY'), 'AD_ASST', 4400, NULL, 100, 90);

COMMIT;

-- 3. SQL*Plus Connection Test Verification
SELECT table_name FROM user_tables;