
package basics;

import java.util.*;

public class ArithematicOperations {

    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    int mod(int a, int b) {
        return a % b;
    }

    int square(int a) {
        return a * a;
    }

    int cube(int b) {
        return b * b * b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArithematicOperations obj = new ArithematicOperations();

        System.out.println("Enter A value");
        int a = sc.nextInt();

        System.out.println("Enter B value");
        int b = sc.nextInt();

        System.out.println("Sum " + obj.add(a, b));
        System.out.println("Subtraction " + obj.sub(a, b));
        System.out.println("Product " + obj.multiply(a, b));
        System.out.println("Division " + obj.divide(a, b));
        System.out.println("Reminder " + obj.mod(a, b));
        System.out.println("Square of A " + obj.square(a));
        System.out.println("Square of B " + obj.square(b));
        System.out.println("Cube of A " + obj.cube(a));
        System.out.println("Cube of B " + obj.cube(b));

        sc.close();
    }
}
