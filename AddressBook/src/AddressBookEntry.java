/**
 * Each AddressBookEntry contains one record.
 * @author yuyuchih
 *
 */
public class AddressBookEntry {
	/**
	 * Name of the contact.
	 */
	private String name;
	/**
	 * Postal address of the contact.
	 */
	private String postalAddress;
	/**
	 * Phone number of the contact.
	 */
	private String phoneNumber;
	/**
	 * Email address of the contact.
	 */
	private String emailAddress;
	/**
	 * Any extra information.
	 */
	private String note;
	/**
	 * This class is referenced from Effective Jave 2e, page 14. 
	 * Name and postalAddress are required and phoneNumber, 
	 * emailAddress and note are optional.
	 * @author yuyuchih
	 *
	 */
	public static class Builder{
		//Required parameters
		private String name;
		private String postalAddress;
		
		//Optional parameters - Initialized to default values
		private String phoneNumber = "";
		private String emailAddress = "";
		private String note = "";
		/**
		 * This contructor takes required parameters.
		 * @param name Name of the contact.
		 * @param postalAddress Postal Address of the contact.
		 */
		public Builder(String name, String postalAddress){
			this.name = name;
			this.postalAddress = postalAddress;
		}
		/**
		 * Sets the phone number of the contact.
		 * @param phoneNumber the String to be set as phone number.
		 * @return modified Builder
		 */
		public Builder phoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
			return this;
		}
		/**
		 * Sets the email address of the contact.
		 * @param emailAddress the String to be set as email address.
		 * @return modified Builder.
		 */
		public Builder emailAddress(String emailAddress){
			this.emailAddress = emailAddress;
			return this;
		}
		/**
		 * Sets note of the contact.
		 * @param note the String to be set as note.
		 * @return modified Builder.
		 */
		public Builder note(String note){
			this.note = note;
			return this;
		}
		/**
		 * Passes all stored fields of a contact to AddressBookEntry.
		 * @return a new AddressBookEntry with all fields set.
		 */
		public AddressBookEntry build(){
			return new AddressBookEntry(this);
		}
	}
	/**
	 * This constructor takes a builder in and sets its own fields 
	 * with a Builder object's fields.
	 * @param builder
	 */
	private AddressBookEntry(Builder builder){
		this.name  = builder.name;
		this.postalAddress = builder.postalAddress;
		this.emailAddress= builder.emailAddress;
		this.phoneNumber = builder.phoneNumber;
		this.note = builder.note;
	}
	
	@Override
	public String toString() {
		return "Name: " + name +"\nPostal Address: " +postalAddress + "\nPhone Number: "
				+ phoneNumber + "\nEmail Address: " + emailAddress + "\nNote: " + note +
				"\n";
	}
	public String toFileFormat() {
		return name +"\n" +postalAddress + "\n"
				+ phoneNumber + "\n" + emailAddress + "\n" + note +
				"\n";
	}
	@Override
	public boolean equals(Object obj) {
		if( this == obj)
			return true;
		else if(this != null &&  obj != null){
			if(obj instanceof AddressBookEntry){
				AddressBookEntry entry = (AddressBookEntry) obj;
				if(entry.name.equalsIgnoreCase(this.name) 
						&& entry.postalAddress.equalsIgnoreCase(this.postalAddress) 
						&& entry.phoneNumber.equalsIgnoreCase(phoneNumber)
						&& entry.emailAddress.equalsIgnoreCase(emailAddress)
						&& entry.note.equalsIgnoreCase(note)){
					return true;
				}
					
			}
		}
			
		return false;
	}
	/**
	 * Checks if any field of this entry has substring k. It is case sensitive.
	 * @param k The keyword.
	 * @return true if any field contains keyword k.
	 */
	
	public boolean contains(String k){
		String a = "";
		if( name.contains(k) || postalAddress.contains(k) || emailAddress.contains(k)
				|| phoneNumber.contains(k) || note.contains(k) )
			return true;
		else return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
