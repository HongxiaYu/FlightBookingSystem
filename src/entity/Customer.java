
package entity;

public class Customer{
	
	private String firstName;
	private String lastName;
	private int age;
	private String classType;
	private int customerId;
	int  numberOfBookings;
	private String passportNo;
	private String gender;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Customer(String firstName,String lastName,int age,String classType,int customerId, String passportNo, String gender) {
		this.firstName=firstName;
		this.lastName= lastName;
		this.age=age;
		this.classType=classType;
		this.customerId=customerId;
		this.passportNo = passportNo;
		numberOfBookings++;		
	}
	
	public Customer(String firstName,String lastName,String classType,int customerId, String passportNo, String gender) {
		this.firstName=firstName;
		this.lastName= lastName;
		this.classType=classType;
		this.customerId=customerId;
		this.passportNo = passportNo;
		numberOfBookings++;		
	}	

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
