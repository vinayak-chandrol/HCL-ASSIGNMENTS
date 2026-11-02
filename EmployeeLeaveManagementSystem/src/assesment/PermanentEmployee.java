package assesment;

public class PermanentEmployee extends Employee {

	public PermanentEmployee(String employeeId, String employeeName, String department, String email,
			int availableLeaveBalance) {
		super(employeeId, employeeName, department, email, availableLeaveBalance);
		this.employeeType="Permanent";
	}
	
	@Override 
	public String getEmployeeType() {
		return employeeType;
	}
}
