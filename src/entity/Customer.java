
package entity;

import util.GenericNumber;

public class Customer{
	
	private String firstName;
	private String lastName;
	private int customerId;
	private String passportNo;
	private String gender;
	


	public Customer(String firstName,String lastName, String passportNo, String gender) {
		this.firstName=firstName;
		this.lastName= lastName;
		
		this.customerId=GenericNumber.getCustomerIDNext();		
		this.passportNo = passportNo;
		this.gender=gender;
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

	



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}




	public int getCustomerId() {
		return customerId;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
