package streams;

public class PhoneBookCrawler {

	private PhoneBook phoneBook;

	public PhoneBookCrawler(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}

	public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
		return phoneBook.findPhoneNumberByName(name)
				.orElseThrow(() -> new IllegalArgumentException("No phone number found"));
	}

	public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
		//return phoneBook.findPhoneNumberByName(name).orElseGet(() -> phoneBook.toString());
		return phoneBook.findPhoneNumberByName(name).orElse(phoneBook.toString());
	}

	public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){
		return phoneBook.findPhoneNumberByName(name)
				.orElseGet(() -> phoneBook.findNameByPhoneNumber(phoneNumber)
						.orElseGet(() -> phoneBook.findPhoneNumberByName("Jos de Vos").get()));
	}

	public PhoneBook getPhoneBook(){
		return phoneBook;
	}
}
