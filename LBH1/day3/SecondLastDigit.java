public class SecondLastDigit {

    public static int getSecondLastDigit(int num) {

        num = Math.abs(num);

        if (num < 10)
            return -1;

        return (num / 10) % 10;
    }

    public static void main(String[] args) {
        System.out.println(getSecondLastDigit(197));
        System.out.println(getSecondLastDigit(-197));
        System.out.println(getSecondLastDigit(5));
    }
}