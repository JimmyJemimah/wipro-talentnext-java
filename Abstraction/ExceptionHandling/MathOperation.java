public class MathOperation {

    public static void main(String[] args) {

        try {

            if (args.length != 5) {
                throw new ArithmeticException("Please enter exactly 5 integers.");
            }

            int sum = 0;

            for (int i = 0; i < 5; i++) {
                sum += Integer.parseInt(args[i]);
            }

            double average = (double) sum / 5;

            System.out.println("Sum = " + sum);
            System.out.println("Average = " + average);

        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}