package basics;
import java.util.*;

public class BankApplication {
	
	
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
		
	public void Signup() { //SignUp Function 
		System.out.println("Enter your details");
	
		System.out.println("Enter your account number");
		int an = sc.nextInt();
		System.out.println("Enter your pincode");
		int pin = sc.nextInt();
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your intial amount");
		double amount = sc.nextDouble();
		
		BankAccount account = new BankAccount(an,pin,name,amount);
		accounts.add(account);
		
		System.out.println("Account created Succesfully");
		
		
	}
	
	public void Login() {  // Login Function 
		System.out.println("Please Enter Your Bank Account number");
		
		int an = sc.nextInt();
		System.out.println("Enter your 4 digit pincode ");
		int pin = sc.nextInt();
		for(BankAccount account1:accounts) {
			if(account1.getAccountNumber()==an && account1.getPin() ==pin) {
				
				System.out.println("Login Succesfull \n Welcome "+ account1.getName());
				
				
				while(true) {
				System.out.println("Enter Your Choice \n 1) Deposit \n 2) Withdraw \n 3) Balance \n 4) Logout ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:  {
							Deposit(account1);
							break;
				}
				case 2: {
							Withdraw(account1);
							break;
				}
				case 3: {
							Balance(account1);
							break;
				}
				case 4: Exit(); return ;
				default: System.out.println("Invalid choice");
				
				}
				
				}
			}
			
		}
		System.out.println("invalid credentials");
		
	}
	
	public void Deposit(BankAccount account) {
		System.out.println("Enter amount to deposit ");
		double deposit = sc.nextDouble();
		account.deposit(deposit);
		
		System.out.println("Amount deposited Succesfully");
		
	}
	
	public void Withdraw(BankAccount account) {
		System.out.println("Enter amount to Withdraw ");
		double withdraw = sc.nextDouble();
		if (account.withdraw(withdraw)) {
		    System.out.println("Amount withdrawn successfully");
		} else {
		    System.out.println("Insufficient balance");
		}
		
		
		
	}
	
	public void Balance(BankAccount account) {
		System.out.printf("Available Balance: %.2f%n" , account.balance());
	}
	
	
	 public void Exit() {
		 System.out.println("Thanks for banking with City Bank ");
		 
	}
	
	
	public static void main(String [] args) {
		
		
		BankApplication obj = new BankApplication();
		while(true) {
			System.out.println("================================ \n WELCOME TO CITY BANK ");
			System.out.println("\nEnter your choice \n 1) Signup \n 2) Login \n 3) Exit");
			
		
		int choice = obj.sc.nextInt();
		switch(choice) {
		
		case 1: obj.Signup(); break;
		case 2: obj.Login(); break;
		case 3: {
				obj.Exit();
				obj.sc.close();
				return;
		}
		default: System.out.println("Invalid choice");
		}
		
		}
		
		
	}
	
	
}
