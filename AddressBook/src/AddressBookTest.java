import java.util.List;


public class AddressBookTest {

	public static void main(String[] args) {
		AddressBook myBook = AddressBook.readAddressBookFromFile("myBook.txt");
//		myBook.addEntry(new AddressBookEntry.Builder("Brian", "postalAddress").
//				phoneNumber("phoneNumber").emailAddress("emailAddress").note("note").build());
//		myBook.addEntry(new AddressBookEntry.Builder("Calvin", "6507 Booth St, Rego Park, NY 11374").
//				phoneNumber("3478282458").emailAddress("ycy247@nyu.edu").note("Fake contact").build());
		myBook.save("myBook.txt");
		List<AddressBookEntry> result = myBook.search("Calvin");
		for(AddressBookEntry entry: result){
			myBook.remove(entry);
		}
		result = myBook.search("");
		for(AddressBookEntry entry: result){
			System.out.println(entry);
		}
		//myBook.save("myBook.txt");
	}

}
