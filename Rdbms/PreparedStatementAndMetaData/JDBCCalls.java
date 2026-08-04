package Rdbms.PreparedStatementAndMetaData;

public class JDBCCalls {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:");
            System.out.println("Option 1 (Insert): java JDBCCalls 1 <rollno> <name> <standard> <dob> <fees>");
            System.out.println("Option 2 (Delete): java JDBCCalls 2 <rollno>");
            System.out.println("Option 3 (Modify): java JDBCCalls 3 <rollno> <new_fee>");
            System.out.println("Option 4 (Display): java JDBCCalls 4 [rollno]");
            return;
        }

        int option = Integer.parseInt(args[0]);
        DAOClass dao = new DAOClass();

        switch (option) {
            case 1:
                if (args.length == 6) {
                    int rollno = Integer.parseInt(args[1]);
                    String name = args[2];
                    String standard = args[3];
                    String dob = args[4];
                    double fees = Double.parseDouble(args[5]);
                    dao.insert(rollno, name, standard, dob, fees);
                } else {
                    System.out.println("Invalid arguments for Insert.");
                }
                break;

            case 2:
                if (args.length == 2) {
                    int rollno = Integer.parseInt(args[1]);
                    dao.delete(rollno);
                } else {
                    System.out.println("Invalid arguments for Delete.");
                }
                break;

            case 3:
                if (args.length == 3) {
                    int rollno = Integer.parseInt(args[1]);
                    double fee = Double.parseDouble(args[2]);
                    dao.modify(rollno, fee);
                } else {
                    System.out.println("Invalid arguments for Modify.");
                }
                break;

            case 4:
                dao.display(args);
                break;

            default:
                System.out.println("Invalid Option! Choose 1, 2, 3, or 4.");
        }
    }
}