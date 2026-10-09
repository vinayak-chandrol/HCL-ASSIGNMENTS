package basics;

public class BankAccount{
	private int an,pin;
	private String name;
	 double amount;
	
	public BankAccount(int an,int pin,String name,double amount) {
		this.an=an;
		this.pin=pin;
		this.name=name;
		this.amount=amount;
	}
	
	 public int getAccountNumber() {
	        return an;
	    }

	    // Getter for PIN
	    public int getPin() {
	        return pin;
	    }

	    // Getter for name
	    public String getName() {
	        return name;
	    }

	    // Getter for balance
	    public double balance() {
	        return amount;
	    }
	    

	    public void deposit(double deposit) {
	        amount += deposit;
	    }

	    public boolean withdraw(double withdraw) {

	        if (withdraw > amount) {
	        	System.out.println("Entered amount is more than account balance");
	            return false;
	        }

	        amount -= withdraw;
	        System.out.println("Amount Withdrawn Succesfully");
	        return true;
	    }
}
