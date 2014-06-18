import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.*;
/**
 * PQS 2014 Summer class<p>
 * Problem Set 1 <p>
 * Implementation of Address Book Library
 * 
 * @author yuyuchih
 *
 */
public class AddressBook {
	HashSet<AddressBookEntry> entrySet;
	/**
	 * Constructs a new empty AddressBook
	 */
	public AddressBook(){
		entrySet = new HashSet<AddressBookEntry>();
		System.out.println("Address Book Created.");
	}
	public boolean addEntry(String name, String postalAddress, String phoneNumber, 
			String emailAddress, String note){
		return entrySet.add(new AddressBookEntry(name, postalAddress, phoneNumber, emailAddress, note));
	}
	/**
	 * Remove specific element from this AddressBook if it is present
	 * @param entry element to be removed from this AddressBook, if present
	 * @return true if entrySet contained the specific element
	 */
	public boolean remove(AddressBookEntry entry){
		return entrySet.remove(entry);
	}
	/**
	 * This method check if the keyword is contained in any field of each entry.
	 * @param keyword Searching keyword
	 * @return An ArrayList containing the result
	 */
	public List<AddressBookEntry> search(String keyword){
		List<AddressBookEntry> result = new ArrayList<AddressBookEntry>();
		for(AddressBookEntry entry: entrySet){
			if(entry.getName().contains(keyword) || entry.getPostalAddress().contains(keyword) ||
			entry.getPhoneNumber().contains(keyword) || entry.getEmailAddress().contains(keyword) ||
			entry.getNote().contains(keyword) ){
				result.add(entry);
			}
		}
		return result;
	}
	/**
	 * Saves the whole address book to a text based file 
	 * The first line is the size of the address book and 
	 * followed by size x (number of fields in an entry) lines
	 * @param fileName the name of the file that the address will be stored into
	 */
	public void save(String fileName){
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(entrySet.size());
			for(AddressBookEntry entry: entrySet){
				writer.println(entry.getName());
				writer.println(entry.getPostalAddress());
				writer.println(entry.getPhoneNumber());
				writer.println(entry.getEmailAddress());
				writer.println(entry.getNote());
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO: Log
			e.printStackTrace();
		}
	}
	/**
	 * Reads AddressBook from a text file, first line of the file should be 
	 * the size of AddressBook and followed by (size of the addressBook) x 
	 * (number of fields per entry) lines.
	 * @param fileName FileName to read from.
	 * @return 
	 */
	public static AddressBook readAddressBookFromFile(String fileName){
		AddressBook addressBook = new AddressBook();
		try {
			Scanner fin = new Scanner(new FileReader(fileName));
			int size = Integer.parseInt(fin.nextLine());
			while(size-->0){
				addressBook.addEntry(fin.nextLine(), fin.nextLine()
						, fin.nextLine(), fin.nextLine(), fin.nextLine());
			}
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addressBook;
	}
	
	public static void test(){
		Set<Double> a = new TreeSet<Double>();
		a.add(1.2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
