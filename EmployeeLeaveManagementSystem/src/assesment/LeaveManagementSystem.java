package assesment;
import java.util.*;

public class LeaveManagementSystem {

    // Collections
    private List<Employee> employees = new ArrayList<>();
    private Set<String> employeeEmails = new HashSet<>();
    private Map<String, Employee> employeeMap = new HashMap<>();//employee id ,employee object
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    private int requestNumber = 1001;

    
    // 1. Add Employee
    public void addEmployee(Employee employee) {

        if (employeeMap.containsKey(employee.getEmployeeId())) {
            System.out.println("Employee ID already exists.");
            return;
        }

        if (employeeEmails.contains(employee.getEmail())) {
            System.out.println("Email already exists.");
            return;
        }

        if (employee.getAvailableLeaveBalance() < 0) {
            System.out.println("Leave balance cannot be negative.");
            return;
        }

        employees.add(employee);
        employeeEmails.add(employee.getEmail());
        employeeMap.put(employee.getEmployeeId(), employee);

        System.out.println("Employee added successfully.");
    }


    // 2. Display All Employees
    public void displayAllEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();

            employee.displayDetails();

            System.out.println("----------------------");
        }
    }

    
    // 3. Search Employee
    public void searchEmployee(String employeeId) {

        try {
            Employee employee = findEmployee(employeeId);
            employee.displayDetails();

        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Find Employee
    private Employee findEmployee(String employeeId)
            throws EmployeeNotFoundException {

        Employee employee = employeeMap.get(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundException(
                "Employee " + employeeId + " does not exist."
            );
        }

        return employee;
    }

 
    // 4. Apply Leave
    public void applyLeave(String employeeId, LeaveType leaveType,
                           int days, String reason) {

        try {

            Employee employee = findEmployee(employeeId);

            if (days <= 0) {
                System.out.println("Leave days must be greater than 0.");
                return;
            }

            if (days > employee.getAvailableLeaveBalance()) {

                throw new InsufficientLeaveException(
                    "Insufficient leave balance. Available: "
                    + employee.getAvailableLeaveBalance()
                    + ", Requested: " + days
                );
            }

            String requestId = "LR" + requestNumber;
            requestNumber++;

            LeaveRequest request = new LeaveRequest(
                requestId, employeeId, leaveType, days, reason
            );

            leaveRequests.add(request);

            System.out.println("Leave request created successfully.");
            System.out.println("Request ID: " + requestId);
            System.out.println("Status: " + request.getStatus());

        } catch (EmployeeNotFoundException |
                 InsufficientLeaveException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

 
    // 5. Approve Leave
    public void approveLeave(String requestId) {

        LeaveRequest request = findRequest(requestId);

        if (request == null) {
            System.out.println("Leave request not found.");
            return;
        }

        if (request.getStatus() != LeaveStatus.PENDING) {
            System.out.println("Request already processed.");
            return;
        }

        try {

            Employee employee = findEmployee(request.getEmployeeId());

            int previousBalance = employee.getAvailableLeaveBalance();

            if (request.getNumberOfDays() > previousBalance) {
                throw new InsufficientLeaveException(
                    "Insufficient leave balance."
                );
            }

            employee.setAvailableLeaveBalance(
                previousBalance - request.getNumberOfDays()
            );

            request.setStatus(LeaveStatus.APPROVED);

            System.out.println("Leave Request Approved.");
            System.out.println("Previous Balance: " + previousBalance);
            System.out.println("Leave Used: " + request.getNumberOfDays());
            System.out.println("Remaining Leave: "
                    + employee.getAvailableLeaveBalance());

        } catch (EmployeeNotFoundException |
                 InsufficientLeaveException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    // 6. Reject Leave
    public void rejectLeave(String requestId) {

        LeaveRequest request = findRequest(requestId);

        if (request == null) {
            System.out.println("Leave request not found.");
            return;
        }

        if (request.getStatus() != LeaveStatus.PENDING) {
            System.out.println("Request already processed.");
            return;
        }

        request.setStatus(LeaveStatus.REJECTED);

        System.out.println("Leave Request Rejected.");
        System.out.println("Leave balance remains unchanged.");
    }


    // Find Leave Request
    private LeaveRequest findRequest(String requestId) {

        for (LeaveRequest request : leaveRequests) {

            if (request.getRequestId().equalsIgnoreCase(requestId)) {
                return request;
            }
        }

        return null;
    }


    // 7. Display All Leave Requests
    public void displayAllLeaveRequests() {

        if (leaveRequests.isEmpty()) {
            System.out.println("No leave requests found.");
            return;
        }

        for (LeaveRequest request : leaveRequests) {
            request.displayDetails();
        }
    }


    // 8. Display Employee Leave Balance
    public void displayLeaveBalance(String employeeId) {

        try {

            Employee employee = findEmployee(employeeId);

            System.out.println("Employee ID: "
                    + employee.getEmployeeId());

            System.out.println("Employee Name: "
                    + employee.getEmployeeName());

            System.out.println("Available Leave Balance: "
                    + employee.getAvailableLeaveBalance());

        } catch (EmployeeNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}
