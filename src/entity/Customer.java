package entity;

public class Customer extends Seat {

	
	private String firstName;
	private String lastName;
	private int age;
	private String classType;
	private int customerId;
	int  numberOfBookings;
	
	public Customer(String firstName,String lastName,int age,String classType,int customerId) {
		super(flightId,flightName,seatNumber,seatType);
		this.firstName=firstName;
		this.lastName= lastName;
		this.age=age;
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

	public int getAge() {
		return age;
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

	
}
