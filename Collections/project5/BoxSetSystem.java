package project5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Box {
    private double length;
    private double width;
    private double height;
    private double volume;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        // Calculate and round to 2 decimal places to prevent float precision mismatches
        this.volume = Math.round((length * width * height) * 100.0) / 100.0;
    }

    public double getLength() { return length; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getVolume() { return volume; }

    // Override equals to compare boxes strictly by their volumes
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Box other = (Box) obj;
        return Double.compare(this.volume, other.volume) == 0;
    }

    // Override hashCode to match the equals contract based on volume
    @Override
    public int hashCode() {
        return Objects.hash(volume);
    }
}

public class BoxSetSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Box> boxSet = new HashSet<>();

        System.out.println("Enter the number of Box");
        int numBoxes = scanner.nextInt();

        for (int i = 1; i <= numBoxes; i++) {
            System.out.println("Enter the Box " + i + " details");
            System.out.println("Enter Length");
            double length = scanner.nextDouble();
            System.out.println("Enter Width");
            double width = scanner.nextDouble();
            System.out.println("Enter Height");
            double height = scanner.nextDouble();

            Box newBox = new Box(length, width, height);
            boxSet.add(newBox);
        }

        System.out.println("Unique Boxes in the Set are");
        // Print unique values according to the format in the sample screenshots
        for (Box box : boxSet) {
            System.out.printf("Length =%.1f Width =%.1f Height =%.1f Volume =%.2f\n",
                box.getLength(), box.getWidth(), box.getHeight(), box.getVolume());
        }

        scanner.close();
    }
}