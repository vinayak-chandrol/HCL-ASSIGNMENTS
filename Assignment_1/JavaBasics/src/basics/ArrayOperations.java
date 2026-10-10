
package basics;

import java.util.*;

public class ArrayOperations {

    void insert(int[] arr, int n, int pos, int value) {
        for (int i = n; i >= pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos - 1] = value;
        System.out.println("Element inserted successfully.");
    }

    void delete(int[] arr, int n, int pos) {
        for (int i = pos - 1; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        System.out.println("Element deleted successfully.");
    }

    void linearSearch(int[] arr, int n, int value) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == value) {
                System.out.println("Element found at position " + (i + 1));
                return;
            }
        }
        System.out.println("Element not found.");
    }

    void binarySearch(int[] arr, int n, int value) {
        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (temp[mid] == value) {
                System.out.println("Element found at sorted position " + (mid + 1));
                return;
            } else if (temp[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Element not found.");
    }

    void maximum(int[] arr, int n) {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum value = " + max);
    }

    void countEvenOdd(int[] arr, int n) {
        int even = 0, odd = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even elements = " + even);
        System.out.println("Odd elements = " + odd);
    }

    void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Array sorted successfully.");
    }

    void display(int[] arr, int n) {
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(arr, n)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayOperations obj = new ArrayOperations();

        int[] arr = new int[100];

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        if (n < 0 || n > arr.length) {
            System.out.println("Invalid array size.");
            sc.close();
            return;
        }

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n----- ARRAY MENU -----");
            System.out.println("1. Insertion");
            System.out.println("2. Deletion");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (n == arr.length) {
                        System.out.println("Array is full.");
                        break;
                    }

                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();

                    if (pos < 1 || pos > n + 1) {
                        System.out.println("Invalid position.");
                        break;
                    }

                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    obj.insert(arr, n, pos, value);
                    n++;
                    break;

                case 2:
                    if (n == 0) {
                        System.out.println("Array is empty.");
                        break;
                    }

                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();

                    if (pos < 1 || pos > n) {
                        System.out.println("Invalid position.");
                        break;
                    }

                    obj.delete(arr, n, pos);
                    n--;
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    obj.linearSearch(arr, n, value);
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    obj.binarySearch(arr, n, value);
                    break;

                case 5:
                    obj.maximum(arr, n);
                    break;

                case 6:
                    obj.countEvenOdd(arr, n);
                    break;

                case 7:
                    obj.insertionSort(arr, n);
                    break;

                case 8:
                    obj.display(arr, n);
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
