public class Q13_PrimeNumbers10to99 {
    public static void main(String[] args) {

        for (int n = 10; n <= 99; n++) {

            boolean prime = true;

            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime)
                System.out.println(n);
        }
    }
}