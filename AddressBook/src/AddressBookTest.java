import java.util.ArrayList;
import java.util.List;


public class AddressBookTest {

	public static void main(String[] args) {
		AddressBook myBook = AddressBook.readAddressBookFromFile("myBook.txt");
		//myBook.addEntry("name", "postalAddress", "phoneNumber", "emailAddress", "note");
		//myBook.addEntry("Calvin", "11374 6507 Booth ST", "34782822458", "ycy247@nyu.edu", "this is real");
		List<AddressBookEntry> result = myBook.search("John");
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
