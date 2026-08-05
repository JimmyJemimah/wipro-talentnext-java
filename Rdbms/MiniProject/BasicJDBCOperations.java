package MiniProject;

import java.sql.*;
import java.util.ArrayList;

public class BasicJDBCOperations {

    public String getUserType(String userID) {
        String userType = null;
        String query = "SELECT UserType FROM UserTable WHERE UserID = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    userType = rs.getString("UserType");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }

    public String getIncorrectAttempts(String userID) {
        String query = "SELECT IncorrectAttempts FROM UserTable WHERE UserID = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int attempts = rs.getInt("IncorrectAttempts");
                    if (attempts == 0) return "No Incorrect Attempt";
                    else if (attempts == 1) return "One Time";
                    else return "Incorrect Attempt Exceeded";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User Not Found";
    }

    public String changeUserType(String userID) {
        String query = "UPDATE UserTable SET UserType = 'Admin' WHERE UserID = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userID);
            int count = ps.executeUpdate();
            if (count > 0) return "Update Success";
            else return "Update Failed";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Update Failed";
        }
    }

    public int getLockStatus() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM UserTable WHERE LockStatus = 0";
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public String changeName(String id, String name) {
        String query = "UPDATE UserTable SET Name = ? WHERE UserID = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, id);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) return "Success";
            else return "Failed";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Failed";
        }
    }

    public String changePassword(String password) {
        String query = "UPDATE UserTable SET Password = ? WHERE UserType = 'Admin'";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, password);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) return "Changed";
            else return "0";
        } catch (SQLException e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String addUser_1(UserBean bean) {
        String query = "INSERT INTO UserTable VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getUserID());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());

            int count = ps.executeUpdate();
            if (count > 0) return "Success";
            else return "Fail";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addUser_2(UserBean bean) {
        if (bean.getLockStatus() != 0) {
            return "Fail";
        }
        return addUser_1(bean);
    }

    public ArrayList<UserBean> getUsers(String userType) {
        ArrayList<UserBean> list = new ArrayList<>();
        String query = "SELECT * FROM UserTable WHERE UserType = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userType);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UserBean user = new UserBean(
                        rs.getString("UserID"),
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getInt("IncorrectAttempts"),
                        rs.getInt("LockStatus"),
                        rs.getString("UserType")
                    );
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<UserBean> storeAllRecords() {
        ArrayList<UserBean> list = new ArrayList<>();
        String query = "SELECT * FROM UserTable";
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                UserBean user = new UserBean(
                    rs.getString("UserID"),
                    rs.getString("Password"),
                    rs.getString("Name"),
                    rs.getInt("IncorrectAttempts"),
                    rs.getInt("LockStatus"),
                    rs.getString("UserType")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String[] getNames() {
        ArrayList<String> nameList = new ArrayList<>();
        String query = "SELECT Name FROM UserTable";
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                nameList.add(rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        BasicJDBCOperations app = new BasicJDBCOperations();

        System.out.println("Scenario 1: " + app.getUserType("AB1001"));
        System.out.println("Scenario 2: " + app.getIncorrectAttempts("TA1002"));
        System.out.println("Scenario 3: " + app.changeUserType("TA1002"));
        System.out.println("Scenario 4: " + app.getLockStatus());
        System.out.println("Scenario 5: " + app.changeName("RS1003", "Ganesh Kumar"));
        System.out.println("Scenario 6: " + app.changePassword("AdminPass123"));

        UserBean user1 = new UserBean("VK1004", "pass123", "Vikram", 0, 0, "Employee");
        System.out.println("Scenario 7: " + app.addUser_1(user1));

        UserBean user2 = new UserBean("SK1005", "pass456", "Suresh", 0, 1, "Employee");
        System.out.println("Scenario 8: " + app.addUser_2(user2));

        System.out.println("Scenario 9 (Employees): " + app.getUsers("Employee"));
        System.out.println("Scenario 10 (All Records): " + app.storeAllRecords());

        System.out.print("Scenario 11 (Names): ");
        for (String name : app.getNames()) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}