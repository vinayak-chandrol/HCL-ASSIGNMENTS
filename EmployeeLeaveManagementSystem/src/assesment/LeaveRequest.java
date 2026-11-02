package assesment;

public class LeaveRequest {
	
	
    private String requestId;
    private String employeeId;
    private LeaveType leaveType;
    private int numberOfDays;
    private String reason;
    private LeaveStatus status;

    public LeaveRequest(String requestId, String employeeId, LeaveType leaveType,
                        int numberOfDays, String reason) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
        this.status = LeaveStatus.PENDING;
    }

    public void displayDetails() {
        System.out.println("Request ID : " + requestId);
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Leave Type : " + leaveType);
        System.out.println("Days : " + numberOfDays);
        System.out.println("Reason : " + reason);
        System.out.println("Status : " + status);
        System.out.println("------------------------------");
    }

    public String getRequestId() {
        return requestId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }
}
