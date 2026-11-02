package assesment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LeaveManagementSystem system = new LeaveManagementSystem();

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE LEAVE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Apply Leave");
            System.out.println("5. Approve Leave");
            System.out.println("6. Reject Leave");
            System.out.println("7. Display All Leave Requests");
            System.out.println("8. Display Employee Leave Balance");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Leave Balance: ");
                    int balance = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Employee Type (Permanent/Contract): ");
                    String type = sc.nextLine();

                    Employee employee;

                    if (type.equalsIgnoreCase("Permanent")) {
                        employee = new PermanentEmployee(
                            id, name, department, email, balance
                        );
                    }
                    else if (type.equalsIgnoreCase("Contract")) {
                        employee = new ContractEmployee(
                            id, name, department, email, balance
                        );
                    }
                    else {
                        System.out.println("Invalid Employee Type");
                        break;
                    }

                    system.addEmployee(employee);
                    break;

                case 2:
                    system.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextLine();

                    system.searchEmployee(id);
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextLine();

                    System.out.print("Enter Leave Type (CASUAL/SICK/EARNED): ");
                    String leaveInput = sc.nextLine();

                    LeaveType leaveType;

                    try {
                        leaveType = LeaveType.valueOf(
                            leaveInput.toUpperCase()
                        );
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Invalid Leave Type");
                        break;
                    }

                    System.out.print("Enter Number of Days: ");
                    int days = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Reason: ");
                    String reason = sc.nextLine();

                    system.applyLeave(id, leaveType, days, reason);
                    break;

                case 5:
                    System.out.print("Enter Request ID: ");
                    String approveId = sc.nextLine();

                    system.approveLeave(approveId);
                    break;

                case 6:
                    System.out.print("Enter Request ID: ");
                    String rejectId = sc.nextLine();

                    system.rejectLeave(rejectId);
                    break;

                case 7:
                    system.displayAllLeaveRequests();
                    break;

                case 8:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextLine();

                    system.displayLeaveBalance(id);
                    break;

                case 9:
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 9);

        sc.close();
    }
}
