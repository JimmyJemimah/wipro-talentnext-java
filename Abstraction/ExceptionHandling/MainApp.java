public class MainApp {

    // Method to validate age
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age >= 60) {
            throw new InvalidAgeException("Error: Age must be >= 18 and < 60");
        }
    }

    public static void main(String[] args) {

        try {
            // Check if arguments are passed correctly
            if (args.length != 2) {
                throw new Exception("Usage: java MainApp <name> <age>");
            }

            String name = args[0];
            int age;

            // Convert age
            try {
                age = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                throw new Exception("Error: Age must be a number");
            }

            // Validate age
            validateAge(age);

            // Success message
            System.out.println("User registration done successfully");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}