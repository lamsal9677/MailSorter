/**
 * ConcereteMailAddress.java
 * Project 0
 * 
 * This file Implements MailAddressInterface - provided - and describes the methods provided in MailAddressInterface
 *  
 * Sanskar Lamsal
 * EECS 2500 - Linear Data Structure in Java
 * Dr. Gerald R. Heuring
*/

/**
 * ConcreteMailAddress implements MailAddressInterface and describes all the necessary methods
 */
public class ConcreteMailAddress implements MailAddressInterface {
	
	String name;
	String address1;
	String address2;
	String city;
	String state;
	int zip;
	
	/**
	 * ConcreteMailAddress is the constructor for the class and it takes in 6 parameters passed from the main method
	 * in RadixSort and then assigns the value into the current instant of the object
	 * */
	public ConcreteMailAddress(String name, String address1, String address2, String city, String state, int zip) {
		this.name=name;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	
	/**
	 * getName is used to access the current instant of the name variable for the object
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * getAddressLine1 is used to access the current instant of the address1 variable for the object
	 */
	@Override
	public String getAddressLine1() {
		return this.address1;
	}
	
	/**
	 * getAddressLine2 is used to access the current instant of the address2 variable for the object
	 */
	@Override
	public String getAddressLine2() {
		return this.address2;
	}
	
	/**
	 * getCity is used to access the current instant of the city variable for the object
	 */
	@Override
	public String getCity() {
		return this.city;
	}
	
	/**
	 * getState is used to access the current instant of the state variable for the object
	 */
	@Override
	public String getState() {
		return this.state;
	}
	
	/**
	 * getZipCode is used to access the current instant of the zip variable for the object
	 */
	@Override
	public int getZipCode() {
		return this.zip;
	}
	
	/**
	 * getZipCodeDigit is used to get the int of the current instant of the zipcode at parameter digit.
	 * It outputs a single number which is then used in Radix Sorting
	 */
	@Override
	public int getZipCodeDigit(int digit) {
 		String a = String.valueOf(this.zip);
		if (a.length() < 5) {
			for (int i=0; i<5-a.length(); i++) {
				a = "0" + a;
			}
		}
		return Character.getNumericValue(a.charAt(digit-1));
	}
}
