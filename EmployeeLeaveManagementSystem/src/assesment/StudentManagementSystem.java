package assesment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        addStudent(sc);
                        break;

                    case 2:
                        viewAllStudents();
                        break;

                    case 3:
                        searchStudent(sc);
                        break;

                    case 4:
                        System.out.println("Exiting application...");
                        break;

                    default:
                        System.out.println("Invalid choice. Enter a number from 1 to 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0;
            }

        } while (choice != 4);

        sc.close();
    }

    // Adds a student record to the file.
    private static void addStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            if (id <= 0) {
                System.out.println("Student ID must be a positive number.");
                return;
            }

            if (studentIdExists(id)) {
                System.out.println("A student with this ID already exists.");
                return;
            }

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter student age: ");
            int age = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter course: ");
            String course = sc.nextLine().trim();

            if (name.isEmpty() || course.isEmpty() || age <= 0) {
                System.out.println("Invalid details. Name, course and a positive age are required.");
                return;
            }

            // Commas are used as separators in the text file.
            if (name.contains(",") || course.contains(",")) {
                System.out.println("Name and course cannot contain commas.");
                return;
            }

            StudentData student = new StudentData(id, name, age, course);

            try (BufferedWriter writer =
                         new BufferedWriter(new FileWriter(FILE_NAME, true))) {

                writer.write(student.toString());
                writer.newLine();
                System.out.println("Student record saved successfully.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID and age must be valid whole numbers.");
        } catch (IOException e) {
            System.out.println("Unable to save student record: " + e.getMessage());
        }
    }

    // Displays every valid student record.
    private static void viewAllStudents() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("Student records file does not exist yet.");
            return;
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length != 4) {
                    System.out.println("Skipping invalid record: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    int age = Integer.parseInt(data[2]);

                    StudentData student =
                            new StudentData(id, data[1], age, data[3]);

                    System.out.println("\nStudent ID: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Age: " + student.getAge());
                    System.out.println("Course: " + student.getCourse());
                    System.out.println("--------------------------------");
                    found = true;

                } catch (NumberFormatException e) {
                    System.out.println("Skipping record with invalid ID or age: " + line);
                }
            }

            if (!found) {
                System.out.println("No valid student records found.");
            }

        } catch (IOException e) {
            System.out.println("Unable to read student records: " + e.getMessage());
        }
    }

    // Searches for a student using the ID entered by the user.
    private static void searchStudent(Scanner sc) {
        try {
            System.out.print("Enter student ID to search: ");
            int searchId = Integer.parseInt(sc.nextLine().trim());

            if (searchId <= 0) {
                System.out.println("Student ID must be a positive number.");
                return;
            }

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("Student records file does not exist yet.");
                return;
            }

            boolean found = false;

            try (BufferedReader reader =
                         new BufferedReader(new FileReader(FILE_NAME))) {

                String line;

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",", -1);

                    if (data.length != 4) {
                        continue;
                    }

                    try {
                        int id = Integer.parseInt(data[0]);

                        if (id == searchId) {
                            int age = Integer.parseInt(data[2]);
                            StudentData student =
                                    new StudentData(id, data[1], age, data[3]);

                            System.out.println("\nStudent found!");
                            System.out.println("Student ID: " + student.getId());
                            System.out.println("Name: " + student.getName());
                            System.out.println("Age: " + student.getAge());
                            System.out.println("Course: " + student.getCourse());

                            found = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Ignore malformed records and continue searching.
                    }
                }
            }

            if (!found) {
                System.out.println("Student with ID " + searchId + " was not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric student ID.");
        } catch (IOException e) {
            System.out.println("Unable to search student records: " + e.getMessage());
        }
    }

    // Checks existing records to prevent duplicate student IDs.
    private static boolean studentIdExists(int searchId) throws IOException {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return false;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length == 4) {
                    try {
                        if (Integer.parseInt(data[0]) == searchId) {
                            return true;
                        }
                    } catch (NumberFormatException e) {
                        // Ignore malformed records.
                    }
                }
            }
        }

        return false;
    }
}
