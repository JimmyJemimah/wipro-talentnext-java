-- Insert dept Id 10 and Name Accounts
INSERT INTO DEPT (Dept_ID, Dept_Name) VALUES (10, 'Accounts');

-- Insert dept Id as null and Name as TT (Fails due to PK, corrected to 20)
INSERT INTO DEPT (Dept_ID, Dept_Name) VALUES (20, 'TT');

-- Insert A1 as Id and Accounts (Fails data type validation, corrected to 30)
INSERT INTO DEPT (Dept_ID, Dept_Name) VALUES (30, 'Accounts');

COMMIT;