package Rdbms.CallableStatementAndTransactions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Assignment1 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle"; // Replace with your actual password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // 1. Ensure table and stored procedure exist
            setupDatabase(conn, stmt);

            // 2. Fetch all empno and ename from emp table
            String selectSql = "SELECT empno, ename FROM emp";
            try (ResultSet rs = stmt.executeQuery(selectSql)) {

                System.out.println("EMPNO\tENAME\t\tNET SALARY");
                System.out.println("----------------------------------------");

                // 3. Prepare call for stored procedure
                String procCall = "{call calculate_net_salary(?, ?)}";
                try (CallableStatement cstmt = conn.prepareCall(procCall)) {

                    while (rs.next()) {
                        int empno = rs.getInt("empno");
                        String ename = rs.getString("ename");

                        // Pass IN parameter (empno)
                        cstmt.setInt(1, empno);
                        // Register OUT parameter (net_salary)
                        cstmt.registerOutParameter(2, Types.DOUBLE);

                        // Execute procedure
                        cstmt.execute();

                        // Retrieve OUT parameter value
                        double netSalary = cstmt.getDouble(2);

                        System.out.printf("%d\t%-10s\t%.2f%n", empno, ename, netSalary);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void setupDatabase(Connection conn, Statement stmt) {
        try {
            // Create emp table if missing
            stmt.executeUpdate("CREATE TABLE emp (empno NUMBER(4) PRIMARY KEY, ename VARCHAR2(10), sal NUMBER(7,2), comm NUMBER(7,2))");
            stmt.executeUpdate("INSERT INTO emp VALUES (7369, 'SMITH', 800, NULL)");
            stmt.executeUpdate("INSERT INTO emp VALUES (7499, 'ALLEN', 1600, 300)");
            stmt.executeUpdate("INSERT INTO emp VALUES (7521, 'WARD', '1250', 500)");
            stmt.executeUpdate("INSERT INTO emp VALUES (7566, 'JONES', 2975, NULL)");
        } catch (SQLException ignored) {
            // Table already exists
        }

        // Create or replace stored procedure
        String createProcedureSQL = 
            "CREATE OR REPLACE PROCEDURE calculate_net_salary ( " +
            "    p_empno IN NUMBER, " +
            "    p_net_sal OUT NUMBER " +
            ") IS " +
            "    v_sal NUMBER(7,2); " +
            "    v_comm NUMBER(7,2); " +
            "    v_gross NUMBER(7,2); " +
            "    v_it NUMBER(7,2); " +
            "BEGIN " +
            "    SELECT sal, NVL(comm, 0) INTO v_sal, v_comm FROM emp WHERE empno = p_empno; " +
            "    v_gross := v_sal + v_comm; " +
            "    " +
            "    IF v_comm = 0 AND (SELECT comm FROM emp WHERE empno = p_empno) IS NULL THEN " +
            "        v_it := 0.10 * v_gross; " +
            "    ELSIF v_comm < 500 THEN " +
            "        v_it := 0.15 * v_gross; " +
            "    ELSE " +
            "        v_it := 0.20 * v_gross; " +
            "    END IF; " +
            "    " +
            "    p_net_sal := v_gross - v_it; " +
            "END;";

        try {
            stmt.execute(createProcedureSQL);
        } catch (SQLException e) {
            System.out.println("Procedure setup note: " + e.getMessage());
        }
    }
}