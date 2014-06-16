/**
 * Each AddressBookEntry contains one record.
 * @author yuyuchih
 *
 */
public class AddressBookEntry {
	private String name;
	private String postalAddress;
	private String phoneNumber;
	private String emailAddress;
	private String note;
	public AddressBookEntry(String name, String postalAddress, String phoneNumber, 
			String emailAddress, String note){
		this.name = name;
		this.postalAddress = postalAddress;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.note = note;
	}
	/**
	 * getter of emailAddress
	 * @return the email address of this entry
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getName() {
		return name;
	}
	public String getNote() {
		return note;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	@Override
	public String toString() {
		return "Name: " + name +"\nPostal Address: " +postalAddress + "\nPhone Number: "
				+ phoneNumber + "\nEmail Address: " + emailAddress + "\nNote: " + note +
				"\n";
	}
}
