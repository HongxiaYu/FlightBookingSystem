package entity;

public class Customer{

	
	private String firstName;
	private String lastName;
	private int passportNumber;
	private String classType;
	private int customerId;
	int  numberOfBookings;
	
	public Customer(String firstName,String lastName,int passportNumber,String classType,int customerId) {
		this.firstName=firstName;
		this.lastName= lastName;
		this.passportNumber=passportNumber;
		this.classType=classType;
		this.customerId=customerId;
		numberOfBookings++;		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public String getClassType() {
		return classType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getNumberOfBookings() {
		return numberOfBookings;
	}
	
	public int getId() {
		return customerId;
	}
	
	public String toString() {
		return customerId +" "+ firstName +" "+ lastName;
	}

	
}
