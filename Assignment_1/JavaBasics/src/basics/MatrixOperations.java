package basics;

import java.util.Scanner;

public class MatrixOperations {

    void add(int[][] a, int[][] b, int r, int c) {
        System.out.println("Addition:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] + b[i][j]) + " ");
            }
            System.out.println();
        }
    }

    void sub(int[][] a, int[][] b, int r, int c) {
        System.out.println("Subtraction:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] - b[i][j]) + " ");
            }
            System.out.println();
        }
    }

    void multiply(int[][] a, int[][] b, int r, int c, int c2) {
        System.out.println("Multiplication:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;

                for (int k = 0; k < c; k++) {
                    sum += a[i][k] * b[k][j];
                }

                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    void transpose(int[][] a, int r, int c) {
        System.out.println("Transpose:");
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    void checkSquare(int r, int c) {
        if (r == c) {
            System.out.println("It is a square matrix.");
        } else {
            System.out.println("It is not a square matrix.");
        }
    }

    void checkDiagonal(int[][] a, int r, int c) {
        if (r != c) {
            System.out.println("It is not a diagonal matrix.");
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i != j && a[i][j] != 0) {
                    System.out.println("It is not a diagonal matrix.");
                    return;
                }
            }
        }

        System.out.println("It is a diagonal matrix.");
    }

    void checkIdentity(int[][] a, int r, int c) {
        if (r != c) {
            System.out.println("It is not an identity matrix.");
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j && a[i][j] != 1) {
                    System.out.println("It is not an identity matrix.");
                    return;
                }

                if (i != j && a[i][j] != 0) {
                    System.out.println("It is not an identity matrix.");
                    return;
                }
            }
        }

        System.out.println("It is an identity matrix.");
    }

    void display(int[][] a, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrixOperations obj = new MatrixOperations();

        int[][] a = new int[10][10];
        int[][] b = new int[10][10];

        System.out.print("Enter rows of first matrix: ");
        int r = sc.nextInt();

        System.out.print("Enter columns of first matrix: ");
        int c = sc.nextInt();

        if (r < 1 || r > 10 || c < 1 || c > 10) {
            System.out.println("Invalid matrix size.");
            sc.close();
            return;
        }

        System.out.println("Enter first matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter rows of second matrix: ");
        int r2 = sc.nextInt();

        System.out.print("Enter columns of second matrix: ");
        int c2 = sc.nextInt();

        if (r2 < 1 || r2 > 10 || c2 < 1 || c2 > 10) {
            System.out.println("Invalid matrix size.");
            sc.close();
            return;
        }

        System.out.println("Enter second matrix elements:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int choice;

        do {
            System.out.println("\n----- MATRIX MENU -----");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose");
            System.out.println("5. Check Square Matrix");
            System.out.println("6. Check Diagonal Matrix");
            System.out.println("7. Check Identity Matrix");
            System.out.println("8. Display First Matrix");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (r == r2 && c == c2) {
                        obj.add(a, b, r, c);
                    } else {
                        System.out.println("Addition is not possible.");
                    }
                    break;

                case 2:
                    if (r == r2 && c == c2) {
                        obj.sub(a, b, r, c);
                    } else {
                        System.out.println("Subtraction is not possible.");
                    }
                    break;

                case 3:
                    if (c == r2) {
                        obj.multiply(a, b, r, c, c2);
                    } else {
                        System.out.println("Multiplication is not possible.");
                    }
                    break;

                case 4:
                    obj.transpose(a, r, c);
                    break;

                case 5:
                    obj.checkSquare(r, c);
                    break;

                case 6:
                    obj.checkDiagonal(a, r, c);
                    break;

                case 7:
                    obj.checkIdentity(a, r, c);
                    break;

                case 8:
                    obj.display(a, r, c);
                    break;

                case 9:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
