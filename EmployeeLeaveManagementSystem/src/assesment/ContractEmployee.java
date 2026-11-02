package assesment;

public class ContractEmployee extends Employee{

	public ContractEmployee(String employeeId, String employeeName, String department, String email,
			int availableLeaveBalance) {
		super(employeeId, employeeName, department, email, availableLeaveBalance);
		this.employeeType="Contract";
	}
	
	 @Override
	    public String getEmployeeType() {
	        return employeeType;
	    }
	
}
